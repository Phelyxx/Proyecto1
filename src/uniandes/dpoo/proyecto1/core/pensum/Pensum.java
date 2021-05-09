package uniandes.dpoo.proyecto1.core.pensum;

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
	
	private Pensum ejecutarCargarPensum()
	{
		String archivo = "./data/pensum.csv";
		try
		{
			Pensum pensum = LoaderPensum.cargarArchivo(archivo);
			return pensum;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("ERROR: el archivo indicado no se encontr�.");
		}
		catch (IOException e)
		{
			System.out.println("ERROR: hubo un problema leyendo el archivo.");
		}
		return null;
	}		
	public static void main(String[] args)
	{
		Pensum pensum = new Pensum(null);
		pensum.ejecutarCargarPensum();
	}
}
