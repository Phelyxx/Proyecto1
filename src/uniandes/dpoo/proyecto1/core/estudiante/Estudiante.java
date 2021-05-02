package uniandes.dpoo.proyecto2.core.estudiante;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uniandes.dpoo.proyecto2.core.pensum.Curso;
import uniandes.dpoo.proyecto2.core.pensum.LoaderPensum;
import uniandes.dpoo.proyecto2.core.pensum.Pensum;
import uniandes.dpoo.proyecto2.verificador.ValidadorInscripcion;
import uniandes.dpoo.proyecto2.verificador.ValidadorRegistro;



public class Estudiante
{
	
	private Map<String, List<Curso>> cursosAprobados; 
	private Map<String, List<Curso>> cursosPlaneados; 
	private Map<String, String> semestreSegunCreditos; 
	private boolean candidatoGrado;
	private boolean tieneSegundaLengua;
	private Pensum pensum;
	private Map<String, Integer> creditosporSemestre; 
	
	
	public Estudiante(boolean candidatoGrado, boolean tieneSegundaLengua)
	{
		this.cursosAprobados = new HashMap<String, List<Curso>>();
		this.candidatoGrado = candidatoGrado;
		this.tieneSegundaLengua = tieneSegundaLengua;
	}
	public Map<String, List<Curso>> darCursosAprobados()
	{
		return cursosAprobados;
	}
	public Map<String, List<Curso>> darCursosPlaneados()
	{
		return cursosPlaneados;
	}
	public Map<String, List<Curso>> agregarCurso(String codigo, String numSemestre, String nota, String caracteristicaEspecial) 
	{
		List<Curso> cursospensum = pensum.consultarCursos();
		boolean cumpleRestricciones = ValidadorRegistro.validarRestriccionesCurso(codigo,numSemestre, 
				nota, caracteristicaEspecial, this, cursospensum);
		if(cumpleRestricciones)
		{
		    Iterator<Entry<String, List<Curso>>> it = cursosAprobados.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, List<Curso>> pair = (Entry<String, List<Curso>>)it.next();
		        if(pair.getKey() == numSemestre)
		        {
		        	Curso curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
		        	pair.getValue().add(curso_inscribir);
		        }
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
			}
		}
		else
		{
			System.out.println("No se pudo inscribir el curso, verifique que cumpla las restricciones");
		}
		return cursosAprobados;
	}
	public Map<String, List<Curso>> planearCurso(String codigo, String numSemestre) 
	{
		String nota = "5.0";
		String caracteristicaEspecial = "";
		List<Curso> cursospensum = pensum.consultarCursos();
		boolean cumpleRestricciones = ValidadorRegistro.validarRestriccionesCurso(codigo,numSemestre, 
				nota, caracteristicaEspecial, this, cursospensum);
		if(cumpleRestricciones)
		{
		    Iterator<Entry<String, List<Curso>>> it = cursosPlaneados.entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry<String, List<Curso>> pair = (Entry<String, List<Curso>>)it.next();
		        if(pair.getKey() == numSemestre)
		        {
		        	Curso curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
		        	pair.getValue().add(curso_inscribir);
		        }
		        System.out.println(pair.getKey() + " = " + pair.getValue());
		        it.remove(); // avoids a ConcurrentModificationException
			}
		}
		else
		{
			System.out.println("No se pudo inscribir el curso, verifique que cumpla las restricciones");
		}
		return cursosAprobados;
	}
}