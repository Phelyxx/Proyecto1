package modelo.verificador;

import java.util.List;
import java.util.Map;

import interfaz.Estudiante;
import modelo.core.pensum.Correquisito;
import modelo.core.pensum.Curso;
import modelo.core.pensum.Prerrequisito;
import modelo.persistencia.LoaderPensum;
import modelo.reporteador.CalculadoraReportes;

public class ValidadorRegistro
{

	public static String validarRestriccionesCurso(String codigoDigitado, String numSemestre, 
			String nota, String caracteristicaEspecial, Estudiante estudiante, List<Curso> cursospensum) 
	{
		String resStr = "";
		for(Curso cursopensum: cursospensum)
		{
			if(cursopensum.darCodigo().equals(codigoDigitado))
			{
				List<Correquisito> correquisitos = cursopensum.darCorrequisitos();
				List<Prerrequisito> prerrequisitos = cursopensum.darPrerrequisitos();
				boolean validarPrerreq = validarPrerrequisitos(prerrequisitos, estudiante);
				boolean validarCorreq = validarCorrequisitos(correquisitos, estudiante);
				boolean validarNivel = validarNivel(cursopensum, estudiante, cursospensum);
				boolean validarRestriccionesPensum = validarRestriccionesPensum(cursopensum, estudiante, cursospensum);
				boolean validarCreditos = validarCreditos(estudiante, cursopensum);
				boolean validarSemanas = validarSemanas(cursopensum, estudiante, cursospensum);
				if(validarPrerreq && validarCorreq && validarNivel && validarRestriccionesPensum && validarCreditos && validarSemanas)
				{
					return "Curso añadido";
				}
				else
				{
					resStr += "Problemas con: ";
					if(!validarPrerreq)
					{
						resStr += "Prerrequisitos";
					}
					if(!validarCorreq)
					{
						resStr += "Correquisitos";
					}
					if(!validarNivel)
					{
						resStr += "Nivel";
					}
					if(!validarSemanas)
					{
						resStr += "Dependencias semanas";
					}
					if(!validarRestriccionesPensum)
					{
						resStr += "Restricciones Pensum";
					}
					if(!validarCreditos)
					{
						resStr += "Creditos";
					}
				}
			}
		}		
		return resStr;

	}
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validarPrerrequisitos(List<Prerrequisito> prerrequisitos, Estudiante estudiante)
	{
		boolean cumple = false;
		Map<String, List<Curso>> cursosEstudiante = estudiante.darCursosAprobados();
		int cantidad = 0;
		int conteoPrerreqs = 0;
		for(Prerrequisito prerrequisito: prerrequisitos)
		{
			cantidad += 1;
			List<Curso> cursos = prerrequisito.darPrerreqs();
			int conteoPrereqIgual = 0;
			for(Curso curso: cursos)
			{
				if(cursosEstudiante.containsValue(curso))
				{
					conteoPrereqIgual = 1;
				}
			}
			conteoPrerreqs += conteoPrereqIgual;
		}
		if(conteoPrerreqs >= cantidad)
		{
			cumple = true;
		}
		return cumple;

	}
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validarCorrequisitos(List<Correquisito> correquisitos, Estudiante estudiante)
	{
		boolean cumple = false;
		Map<String, List<Curso>> cursosEstudiante = estudiante.darCursosAprobados();
		int cantidad = 0;
		int conteoCorreqs = 0;
		for(Correquisito correquisito: correquisitos)
		{
			cantidad += 1;
			List<Curso> cursos = correquisito.darCorreqs();
			int conteoCoreqIgual = 0;
			for(Curso curso: cursos)
			{
				if(cursosEstudiante.containsValue(curso))
				{
					conteoCoreqIgual = 1;
				}
			}
			conteoCorreqs += conteoCoreqIgual;
		}
		if(conteoCorreqs >= cantidad)
		{
			cumple = true;
		}
		return cumple;

	}	
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validarNivel(Curso curso, Estudiante estudiante, List<Curso> cursospensum)
	{
		boolean cumple = true;
		int nivel = curso.darNivel();
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		if(nivel == 3)
		{
			for(Curso cursoP: cursospensum)
			{
				if(cursoP.darNivel() == 1 && cursoP.esObligatorio())
				{
					if(!cursosAprobados.containsValue(cursoP));
					{
						cumple = false;
					}
				}
			}
		}
		else if(curso.darCodigo().equals("ISIS-3007") || nivel == 4)
		{
			for(Curso cursoP: cursospensum)
			{
				if(cursoP.darNivel() == 2 && cursoP.esObligatorio())
				{
					if(!cursosAprobados.containsValue(cursoP));
					{
						cumple = false;
					}
				}
			}
		}
		return cumple;

	}		
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validarRestriccionesPensum(Curso curso, Estudiante estudiante, List<Curso> cursospensum)
	{
		boolean cumple = true;
		if(curso.darCodigo().substring(0, 4).equals("ISIS") && curso.darSemestre() >= 5)
		{
			Map<String, List<Curso>> cursosE = estudiante.darCursosAprobados();
			Curso requisitoIngles = LoaderPensum.encontrarCurso(cursospensum, "LENG-2999");
			if(!cursosE.containsValue(requisitoIngles))
			{
				cumple = false;
			}
		}
		if(curso.darCodigo().substring(0, 4).equals("ISIS") && curso.darSemestre() >= 6)
		{
			Map<String, Boolean> requisitos = estudiante.darEstadoRequisitos();
			if(!requisitos.get("REQUISITO DE ESPAÑOL"))
			{
				cumple = false;
			}
		}
		if(curso.darCodigo().equals("ISIS-3007"))
		{
			Map<String, List<Curso>> cursosE = estudiante.darCursosAprobados();
			Curso infraComunicaciones = LoaderPensum.encontrarCurso(cursospensum, "ISIS-3204");
			if(!cursosE.containsValue(infraComunicaciones))
			{
				cumple = false;
			}
		}
		return cumple;

	}	
	public static boolean validarCreditos(Estudiante estudiante, Curso curso)
	{
		boolean cumple = true;
		Double pga = CalculadoraReportes.calcularPGA(estudiante);
		Map<String, Double> creditosSemestre = CalculadoraReportes.calcularCreditosPorSemestre(estudiante);
		Integer semestre = curso.darSemestre();
		if(!creditosSemestre.isEmpty())
		{
			Double creditos = creditosSemestre.get(String.valueOf(semestre));
			if(pga >= 4 && creditos >= 25)
			{
				cumple = false;
			}
			else if(creditos >= 20)
			{
				cumple = false;
			}
		}
		return cumple;
	}			
	@SuppressWarnings("unlikely-arg-type")
	public static boolean validarSemanas(Curso curso, Estudiante estudiante, List<Curso> cursospensum)
	{
		boolean cumple = true;
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		if(curso.darSemanas().equals("8-1"))
		{
			List<Prerrequisito> prerrequisitos = curso.darPrerrequisitos();
			for(Prerrequisito prerrequisito: prerrequisitos)
			{
				List<Curso> cursosPrerreqs = prerrequisito.darPrerreqs();
				for(Curso cursoPrerreq: cursosPrerreqs)
				{
					if(cursoPrerreq.darSemanas().equals("8-2") && cursosAprobados.containsValue(cursoPrerreq) == false)
					{
						cumple = false;
					}
				}
			}
		}
		return cumple;
	}			
}
