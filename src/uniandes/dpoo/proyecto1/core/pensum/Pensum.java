package uniandes.dpoo.proyecto2.core.pensum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;




public class Pensum
{
	private List<Curso> cursos;
	public Pensum(List<Curso> cursos)
	{
		this.cursos = cursos;
	}
	public List<Curso> consultarCursos()
	{
		return cursos;
	}
	
	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	
	private void ejecutarCargarPensum()
	{
		System.out.println("\n" + "Cargar un archivo de atletas" + "\n");

		String archivo = "./data/pensum.csv";
		try
		{
			Pensum Pensum = LoaderPensum.cargarArchivo(archivo);
			System.out.println("Se cargó el archivo " + archivo + " con información de los Juegos Olímpicos.");
			//cursos = consultarCursos(Pensum);
			//System.out.println(cursos);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontró.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
			System.out.println(e.getMessage());
		}
	}		
	public static void main(String[] args)
	{
		Pensum pensum = new Pensum(null);
		pensum.ejecutarCargarPensum();
	}
}
