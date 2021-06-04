package modelo.core.pensum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import modelo.persistencia.LoaderPensum;
import modelo.verificador.RequisitosGrado;
import modelo.verificador.ValidadorRegistro;




public class Estudiante
{

	private Map<String, List<Curso>> cursosAprobados; 
	private Map<String, List<Curso>> cursosPlaneados; 
	private Map<String, Boolean> estadoRequisitosPensum; 
	private Pensum pensum;
	private String codigo;
	private String estadoAcademico;

	public Estudiante(String codigo, Map<String, List<Curso>> cursosAprobados, Map<String, List<Curso>> cursosPlaneados,
			Map<String, Boolean> estadoRequisitosPensum, String estadoAcademico)
	{
		this.codigo = codigo;
		this.cursosAprobados = new HashMap<String, List<Curso>>();
		this.cursosPlaneados = new HashMap<String, List<Curso>>();
		this.estadoRequisitosPensum = RequisitosGrado.darRequisitosGradoEstudiante(this);
		this.estadoAcademico = estadoAcademico;
	}
	public Map<String, List<Curso>> darCursosAprobados()
	{
		return cursosAprobados;
	}
	public Map<String, List<Curso>> darCursosPlaneados()
	{
		return cursosPlaneados;
	}
	public Map<String, Boolean> darEstadoRequisitos()
	{
		return estadoRequisitosPensum;
	}
	public String agregarCurso(String codigo, String numSemestre, double creditos, String nota, 
			String caracteristicaEspecial) 
	{
		List<Curso> cursospensum = pensum.consultarCursos();
		Curso curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
		String cumpleRestricciones = ValidadorRegistro.validarRestriccionesCurso(codigo,numSemestre, 
				nota, caracteristicaEspecial, this, cursospensum);
		if(curso_inscribir == null)
		{
			List<Prerrequisito> prerrequisitos = new ArrayList<Prerrequisito>();
			List<Correquisito> correquisitos = new ArrayList<Correquisito>();
			curso_inscribir = new Curso("", codigo, creditos, false, false, false, false, false, false, false, prerrequisitos, correquisitos, 
					"16",1, 1, nota);
			List<Curso> crearcursossemestre = new ArrayList<>();
			crearcursossemestre.add(curso_inscribir);
			this.cursosAprobados.put(numSemestre, crearcursossemestre);
			cumpleRestricciones = "Curso añadido";
		}	
		else if(cumpleRestricciones.equals("Curso añadido"))	
		{
			if(cursosAprobados.containsKey(numSemestre))
			{
				for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
				{
					if(entry.getKey().equals(numSemestre))
					{
						curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
						curso_inscribir.setSemestre(Integer.parseInt(numSemestre));
						if(caracteristicaEspecial.equals("Tipo E"))
						{
							curso_inscribir.setTipoE(true);
						}
						curso_inscribir.setCreditos(creditos);
						curso_inscribir.setNota(nota);
						entry.getValue().add(curso_inscribir);
						this.cursosAprobados.put(numSemestre, entry.getValue());
					}
				}
			}
			else
			{
				List<Curso> crearcursossemestre = new ArrayList<>();
				curso_inscribir.setSemestre(Integer.parseInt(numSemestre));
				curso_inscribir.setNota(nota);
				curso_inscribir.setCreditos(creditos);
				if(caracteristicaEspecial.equals("Tipo E"))
				{
					curso_inscribir.setTipoE(true);
				}
				crearcursossemestre.add(curso_inscribir);
				this.cursosAprobados.put(numSemestre, crearcursossemestre);
				cumpleRestricciones = "Curso añadido";
			}
		}
		return cumpleRestricciones;
	}
	public String planearCurso(String codigo, String numSemestre) 
	{
		List<Curso> cursospensum = pensum.consultarCursos();
		String cumpleRestricciones = ValidadorRegistro.validarRestriccionesCurso(codigo,numSemestre, 
				"", "", this, cursospensum);
		if(cumpleRestricciones.equals("Curso añadido"))
		{
			Curso curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
			if(cursosPlaneados.containsKey(numSemestre))
			{
				for (Map.Entry<String, List<Curso>> entry : cursosPlaneados.entrySet()) 
				{
					if(entry.getKey().equals(numSemestre))
					{
						curso_inscribir = LoaderPensum.encontrarCurso(cursospensum, codigo);
						curso_inscribir.setSemestre(Integer.parseInt(numSemestre));
						entry.getValue().add(curso_inscribir);
						this.cursosPlaneados.put(numSemestre, entry.getValue());
					}
				}
			}	
			else
			{
				List<Curso> crearcursossemestre = new ArrayList<>();
				curso_inscribir.setSemestre(Integer.parseInt(numSemestre));
				crearcursossemestre.add(curso_inscribir);
				this.cursosPlaneados.put(numSemestre, crearcursossemestre);
			}
		}
		return cumpleRestricciones;
	}
	public void setPensum(Pensum pensum)
	{	
		this.pensum = pensum;
	}
	public boolean retirarCurso(Curso cursoRetirar)
	{
		boolean retirado = false;
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				List<Curso> cursos = entry.getValue();
				for(Curso curso: cursos)
				{
					if(curso.equals(cursoRetirar))
					{
						cursos.remove(curso);
						retirado = true;
						return retirado;
					}
				}
			}
		}
		return retirado;
	}
	public boolean actualizarCurso(Curso cursoActualizar, String nota)
	{
		boolean actualizado = false;
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				List<Curso> cursos = entry.getValue();
				for(Curso curso: cursos)
				{
					if(curso.equals(cursoActualizar))
					{
						curso.setNota(nota);
						actualizado = true;
					}
				}
			}
		}
		return 	actualizado;
	}

	public String darCodigo()
	{
		return codigo;
	}

	public Pensum darPensum()
	{
		return pensum;
	}
	public String darEstadoAcademico()
	{
		return estadoAcademico;
	}
	public void setEstadoAcademico(String estadoAcademico)
	{	
		this.estadoAcademico = estadoAcademico;
	}
}