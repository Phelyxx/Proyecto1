package uniandes.dpoo.proyecto2.core.pensum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
			else if(partes[4].equals("si"))
			{
				esElectivaIngenieria = true;
			}
			else if(partes[5].equals("si"))
			{
				esElectivaProfesional = true;
			}
			else if(partes[6].equals("si"))
			{
				esCBU = true;
			}
			else if(partes[7].equals("si"))
			{
				esTipoI = true;
			}
			else if(partes[8].equals("si"))
			{
				esTipoE = true;
			}
			else if(partes[9].equals("si"))
			{
				esEpsilon = true;
			}	
			List<Prerrequisito> prerrequisitos = new ArrayList<>();
			List<Correquisito> correquisitos = new ArrayList<>();
			String semanas =partes[12];
			int nivel = Integer.parseInt(partes[13]);
			int semestre = Integer.parseInt(partes[14]);
			Curso elCurso = new Curso(nombreCurso, codigoCurso, creditos, esObligatorio, esElectivaIngenieria, 
					esElectivaProfesional, esCBU, esTipoI, esTipoE, esEpsilon, prerrequisitos, 
					correquisitos, semanas, nivel, semestre);
			cursos.add(elCurso);

			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();

		Pensum calculadora = new Pensum(cursos);
		calculadora = cargarCorrequisitos(calculadora, nombreArchivo);
		return calculadora;
	}

	public static Pensum cargarCorrequisitos(Pensum pensum, String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();	
		List<Curso> cursos;
		cursos = pensum.consultarCursos();

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
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();

		Pensum calculadora = new Pensum(cursos);
		return calculadora;
	}

	public static Pensum cargarPrerequisitos(Pensum pensum, String nombreArchivo) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();	
		List<Curso> cursos;
		cursos = pensum.consultarCursos();

		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			String[] partes = linea.split(",");
			for (Curso curso : cursos) 
			{
				if(curso.darCodigo().equals(partes[1]))
				{
					List<Prerrequisito> prerrequisitos = curso.darPrerrequisitos(); // Crea lista de prerrequisitos (Lista de listas cursos)
					if(partes[11].contains("+"))
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
					else if(partes[11].contains("=") && partes[11].contains("+") == false)
					{
						String[] strprerreqigual = partes[11].split("\\=");
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
				}
			}
			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();

		Pensum calculadora = new Pensum(cursos);
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
}
