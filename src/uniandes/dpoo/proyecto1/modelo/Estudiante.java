package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class Estudiante
{
	
	private HashMap<String, List<Curso>> cursosAprobados; 
	private boolean candidatoGrado;
	private boolean tieneSegundaLengua;
	
	
	public Estudiante(boolean candidatoGrado, boolean tieneSegundaLengua)
	{
		this.cursosAprobados = new HashMap<>();
		this.candidatoGrado = candidatoGrado;
		this.tieneSegundaLengua = tieneSegundaLengua;
	}
	public Map<String, List<Curso>> agregarCurso(String numSemestre, Curso curso) 
	{
		List<Curso> lista = cursosAprobados.get(numSemestre);
		lista.add(curso);
		cursosAprobados.put(numSemestre, lista);
		return cursosAprobados;
	}
}
