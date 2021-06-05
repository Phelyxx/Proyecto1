package modelo.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell; 
import org.apache.poi.xssf.usermodel.XSSFRow; 

import modelo.core.pensum.Correquisito;
import modelo.core.pensum.Curso;
import modelo.core.pensum.Estudiante;
import modelo.core.pensum.Pensum;
import modelo.core.pensum.Prerrequisito;

public class LoaderPensum
{

	public static Pensum cargarArchivo(String nombreArchivo) throws FileNotFoundException, IOException
	{
		boolean esObligatorio = false;
		boolean esElectivaIngenieria = false;
		boolean esElectivaProfesional = false;
		boolean esCBU = false;
		boolean esTipoI = false;
		boolean esTipoE = false;
		boolean esEpsilon = false;
		List<Curso> cursos = new ArrayList<>();

		// Abrir el archivo y leerlo línea por línea usando un BufferedReader
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			// Separar los valores que estaban en una línea
			String[] partes = linea.split(",");
			String nombreCurso = partes[0];
			String codigoCurso = partes[1];
			int creditos = Integer.parseInt(partes[2]);
			if(partes[3].equals("si"))
			{
				esObligatorio = true;
			}
			if(partes[4].equals("si"))
			{
				esElectivaIngenieria = true;
			}
			if(partes[5].equals("si"))
			{
				esElectivaProfesional = true;
			}
			if(partes[6].equals("si"))
			{
				esCBU = true;
			}
			if(partes[7].equals("si"))
			{
				esTipoI = true;
			}
			if(partes[8].equals("si"))
			{
				esTipoE = true;
			}
			if(partes[9].equals("si"))
			{
				esEpsilon = true;
			}	
			List<Prerrequisito> prerrequisitos = new ArrayList<>();
			List<Correquisito> correquisitos = new ArrayList<>();
			String semanas = partes[12];
			int nivel = Integer.parseInt(partes[13]);
			int semestre = Integer.parseInt(partes[14].replaceAll(" ", ""));
			Curso elCurso = new Curso(nombreCurso, codigoCurso, creditos, esObligatorio, esElectivaIngenieria, 
					esElectivaProfesional, esCBU, esTipoI, esTipoE, esEpsilon, prerrequisitos, 
					correquisitos, semanas, nivel, semestre, "0");
			cursos.add(elCurso);

			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();

		Pensum pensum = new Pensum(cursos, null);
		pensum = cargarCorrequisitos(pensum, nombreArchivo);
		pensum = cargarPrerequisitos(pensum, nombreArchivo);
		return pensum;
	}

	public static Pensum cargarCorrequisitos(Pensum pensum, String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();	
		List<Curso> cursosNuevos = new ArrayList<Curso>();
		List<Curso> cursos = pensum.consultarCursos();

		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(",");
			for (Curso curso : cursos) 
			{
				if(curso.darCodigo().equals(partes[1]))
				{
					List<Correquisito> correquisitos = curso.darCorrequisitos(); // Crea lista de correquisitos (Lista de listas cursos)
					if(partes[11].contains("+"))
					{
						String [] strcoreqs = partes[11].split("\\+");
						for(String strcoreq : strcoreqs)
						{
							if(strcoreq.contains("=") == false)
							{
								List<Curso> listacorreqs = new ArrayList<>();
								Correquisito correquisitoindividual = new Correquisito(listacorreqs);
								Curso encontrado = encontrarCurso(cursos, strcoreq);
								if(encontrado != null)
									correquisitoindividual.add(encontrado);
								correquisitos.add(correquisitoindividual);
							}
							else if(strcoreq.contains("="))
							{
								List<Curso> listacorreqs = new ArrayList<>();
								Correquisito correquisitosiguales = new Correquisito(listacorreqs);
								String[] strcoreqigual = strcoreq.split("\\=");
								for(String strcoreqequal : strcoreqigual)
								{
									Curso encontradoigual = encontrarCurso(cursos, strcoreqequal );
									if(encontradoigual != null)
										correquisitosiguales.add(encontradoigual);
								}
								correquisitos.add(correquisitosiguales);
							}
						}
					}
					else if(partes[11].contains("=") && partes[11].contains("+") == false)
					{
						String[] strcoreqigual = partes[11].split("\\=");
						for(String strcoreqequal : strcoreqigual)
						{

							List<Curso> listacorreqs = new ArrayList<>();
							Correquisito correquisitoindividual = new Correquisito(listacorreqs);
							Curso encontrado = encontrarCurso(cursos, strcoreqequal);
							correquisitoindividual.add(encontrado);
							if(encontrado != null)
								correquisitos.add(correquisitoindividual);
						}
					}
					curso.setCorrequisitos(correquisitos);
					cursosNuevos.add(curso);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}
		br.close();

		Pensum calculadora = new Pensum(cursosNuevos, null);
		return calculadora;
	}

	public static Pensum cargarPrerequisitos(Pensum pensum, String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();	
		List<Curso> cursosNuevos = new ArrayList<Curso>();
		List<Curso> cursos = pensum.consultarCursos();

		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(",");
			for (Curso curso : cursos) 
			{
				if(curso.darCodigo().equals(partes[1]))
				{
					List<Prerrequisito> prerrequisitos = curso.darPrerrequisitos(); // Crea lista de prerrequisitos (Lista de listas cursos)
					if(partes[10].contains("+"))
					{
						String [] strprereqs = partes[10].split("\\+");
						for(String strprereq : strprereqs)
						{
							if(strprereq.contains("=") == false)
							{
								List<Curso> listaprerreqs = new ArrayList<>();
								Prerrequisito prerrequisitoindividual = new Prerrequisito(listaprerreqs);
								Curso encontrado = encontrarCurso(cursos, strprereq);
								if(encontrado != null)
									prerrequisitoindividual.add(encontrado);
								prerrequisitos.add(prerrequisitoindividual);
							}
							else if(strprereq.contains("="))
							{
								List<Curso> listaprerreqs = new ArrayList<>();
								Prerrequisito prerrequisitosiguales = new Prerrequisito(listaprerreqs);
								String[] strprerreqigual = strprereq.split("\\=");
								for(String strprerreqequal : strprerreqigual)
								{
									Curso encontradoigual = encontrarCurso(cursos, strprerreqequal );
									if(encontradoigual != null)
										prerrequisitosiguales.add(encontradoigual);
								}
								prerrequisitos.add(prerrequisitosiguales);
							}
						}
					}
					else if(partes[10].contains("=") && partes[10].contains("+") == false)
					{
						String[] strprerreqigual = partes[10].split("\\=");
						for(String strprrereqequal : strprerreqigual)
						{
							List<Curso> listaprerreqs = new ArrayList<>();
							Prerrequisito prerequisitoindividual = new Prerrequisito(listaprerreqs);
							Curso encontrado = encontrarCurso(cursos, strprrereqequal);
							prerequisitoindividual.add(encontrado);
							if(encontrado != null)
								prerrequisitos.add(prerequisitoindividual);
						}
					}
					curso.setPrerrequisitos(prerrequisitos);
					cursosNuevos.add(curso);
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();

		Pensum calculadora = new Pensum(cursosNuevos, null);
		return calculadora;
	}


	public static Curso encontrarCurso(List<Curso> cursos, String codigo)
	{
		for(Curso curso: cursos)
		{
			if(codigo.equals(curso.darCodigo()))
			{
				return curso;
			}
		}
		return null;
	}
	public static List<String> cargarCartelera(String nombreArchivo) throws FileNotFoundException
	{
		List<String> codigoDisponibles = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(nombreArchivo));
		try
		{
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			Map<Integer, List<String>> data = new HashMap<>();
			int i = 0;
			for (Row row : sheet) {
				data.put(i, new ArrayList<String>());
				Cell cell = row.getCell(10);
				if(cell != null)
				{
					switch (cell.getCellType()) {
					case NUMERIC:
						double disponibilidad = cell.getNumericCellValue();
						if(disponibilidad >= 1)
						{
							Cell codigoCell = row.getCell(4);
							switch (codigoCell.getCellType()) {
							case STRING:
								String codigoCurso = codigoCell.getStringCellValue();
								codigoCurso = codigoCurso.replaceAll(" ", "");
								if(!codigoDisponibles.contains(codigoCurso))
								{
									codigoDisponibles.add(codigoCurso);
								}
								break;
							default: 
							}
						}
						break;
					default: 
					}
				}    
			}
			i++;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			logError(e);
			e.printStackTrace();
		}
		return codigoDisponibles;
	}
	public static List<String> cargarReformado(String nombreArchivo, Estudiante estudiante) throws FileNotFoundException
	{
		List<String> codigoNuevos = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(nombreArchivo));
		try
		{
			@SuppressWarnings("resource")
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheetAt(0);
			Map<Integer, List<String>> data = new HashMap<>();
			int i = 0;
			for (Row row : sheet) {
				data.put(i, new ArrayList<String>());
				Cell cellCursos = row.getCell(0);
				if(cellCursos != null)
				{
					switch (cellCursos.getCellType()) {
					case STRING:
						String codigoCursos = cellCursos.getStringCellValue();
						String[] arrayCursos = codigoCursos.split(",");
						int tamanio = arrayCursos.length;
						int conteo = 0;
						Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
						for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
						{
							List<Curso> cursos = entry.getValue();
							for(Curso curso: cursos)
							{
								for(String cursoReformado: arrayCursos)
								{
									if(cursoReformado.equals(curso.darCodigo()))
									{
										conteo += 1;
									}
								}
							}
						}
						if(conteo >= tamanio)
						{
							Cell codigoCell = row.getCell(1);
							switch (codigoCell.getCellType()) {
							case STRING:
								String codigoCurso = codigoCell.getStringCellValue();
								codigoCurso = codigoCurso.replaceAll(" ", "");
								Curso curso = LoaderPensum.encontrarCurso(estudiante.darPensum().consultarCursos(), codigoCurso);
								if(curso != null)
								{
									codigoNuevos.add(curso.darCodigo());
								}
							default: 
							}
						}
						break;
					default: 
					}
				}    
			}
			i++;
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			logError(e);
		}
		return codigoNuevos;
	}

	public static void logError(Exception e)
	{
		try {
			FileWriter writer = new FileWriter("./data/log.txt", true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			Date date = new Date(); 
			bufferedWriter.write("Fecha del error: " + dateFormat.format(date));
			bufferedWriter.newLine();
			e.printStackTrace(new PrintWriter(bufferedWriter));
			bufferedWriter.newLine();
			bufferedWriter.close();
		} catch (IOException d) {
			d.printStackTrace();
		}
	}
}
