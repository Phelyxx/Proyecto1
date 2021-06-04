package modelo.core.pensum;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import modelo.persistencia.LoaderPensum;

public class Pensum
{
	private List<Curso> cursos;
	private List<String> cursosDisponibles;
	public Pensum(List<Curso> cursos, List<String> cursosDisponibles)
	{
		this.cursos = cursos;
		this.cursosDisponibles = cursosDisponibles;
	}
	
	public List<Curso> consultarCursos()
	{
		return cursos;
	}
	
	public List<String> consultarCursosDisponibles()
	{
		return cursosDisponibles;
	}
	
	public void setCartelera(List<String> cursosDisponibles)
	{	
		this.cursosDisponibles = cursosDisponibles;
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
			e.printStackTrace();
			LoaderPensum.logError(e);
		}
		return null;
	}
}
