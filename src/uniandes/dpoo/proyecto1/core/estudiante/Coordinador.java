package uniandes.dpoo.proyecto1.core.estudiante;

import java.io.IOException;
import java.util.List;

import uniandes.dpoo.proyecto1.core.pensum.Pensum;
import uniandes.dpoo.proyecto1.persistencia.LoaderEstudiantes;

public class Coordinador
{
	private List<Estudiante> estudiantes;
	private Pensum pensum;
	private String codigo;
	public Coordinador(List<Estudiante> estudiantes, String codigo)
	{
		this.estudiantes = estudiantes;
		this.codigo = codigo;
	}
	public void cargarMateriasEstudiantes(String archivo) throws IOException
	{
		this.estudiantes = LoaderEstudiantes.cargarMateriasEstudiantes(this, archivo);
	}
	public List<Estudiante> darEstudiantes()
	{
		return estudiantes;
	}
	
	public Pensum darPensum()
	{
		return pensum;
	}
	public String darCodigo()
	{
		return codigo;
	}
	public void setPensum(Pensum pensum)
	{	
		this.pensum = pensum;
	}
}
