package modelo.persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import modelo.core.pensum.Coordinador;
import modelo.core.pensum.Curso;
import modelo.core.pensum.Estudiante;

public class LoaderEstudiantes
{
	public static List<Estudiante> cargarMateriasEstudiantes(Coordinador coordinador, String archivo) throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(archivo));
		String linea = br.readLine(); // La primera línea del archivo se ignora porque únicamente tiene los títulos de
		// las columnas
		linea = br.readLine();
		String[] partes = linea.split(",");
		List<Estudiante> estudiantes = coordinador.darEstudiantes();
		while (linea != null) // Cuando se llegue al final del archivo, linea tendrá el valor null
		{
			for(Estudiante estudiante: estudiantes)
			{
				if(estudiante.darCodigo() == partes[0])
				{
					System.out.println("X");
					Curso curso = LoaderPensum.encontrarCurso(coordinador.darPensum().consultarCursos(), partes[1]);
					estudiante.agregarCurso(curso.darCodigo(), partes[2], curso.darCreditos(), partes[3], "");
				}
			}
			HashMap<String, List<Curso>> cursosAprobados = new HashMap<String, List<Curso>>();
			HashMap<String, List<Curso>> cursosPlaneados = new HashMap<String, List<Curso>>();
			HashMap<String, Boolean> estadoRequisitosPensum = new HashMap<String, Boolean>();;
			Estudiante estudiantecreado = new Estudiante(partes[0], cursosAprobados, cursosPlaneados, estadoRequisitosPensum, "Normal");
			Curso curso = LoaderPensum.encontrarCurso(coordinador.darPensum().consultarCursos(), partes[1]);
			estudiantecreado.setPensum(coordinador.darPensum());
			estudiantecreado.agregarCurso(curso.darCodigo(), partes[2], curso.darCreditos(), partes[3], "");
			estudiantes.add(estudiantecreado);

			linea = br.readLine(); // Leer la siguiente línea
		}

		br.close();
		return estudiantes;
	}
}
