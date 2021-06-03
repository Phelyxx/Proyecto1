package modelo.reporteador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import interfaz.Estudiante;
import modelo.core.pensum.Curso;

public class CalculadoraReportes
{
	public static Double calcularPGA(Estudiante estudiante)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Double pga = (double) 0;
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				List<Curso> cursos = entry.getValue();
				Double creditosSemestre = (double) 0;
				for(Curso curso: cursos)
				{
					creditosSemestre += curso.darCreditos();
				}
				Double promedio = CalculadoraReportes.calcularPromedioSemestre(estudiante, entry.getKey());
				System.out.println(promedio);
				System.out.println(creditosSemestre);
				pga += promedio * creditosSemestre;
			} 
			Map<String, Double> creditos_semestre = CalculadoraReportes.calcularCreditosPorSemestre(estudiante);
			double sumacreditos = 0;
			for(Map.Entry<String, Double> entry : creditos_semestre.entrySet()) 
			{
				System.out.println(entry.getValue());
				sumacreditos += entry.getValue();
			}
			pga = pga / sumacreditos;
		}
		return pga;
	}
	public static Double calcularPromedioSemestre(Estudiante estudiante, String semestre)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Double promedio = (double) 0;
		if(cursosAprobados != null)
		{
			List<Curso> cursos = cursosAprobados.get(semestre);
			Double conteocreditos = (double) 0;
			Double conteocreditosnota = (double) 0;
			for(Curso curso: cursos)
			{
				double creditos = curso.darCreditos();
				String nota = curso.darNota();
				conteocreditos += creditos;
				try
				{
				Double creditosNota = creditos * Double.parseDouble(nota);
				conteocreditosnota += creditosNota;
				}
				catch(NumberFormatException e)
				{
				}
			}
			promedio = conteocreditosnota/conteocreditos;

		}
		return promedio;
	}



	public static Map<String, Double> calcularCreditosPorSemestre(Estudiante estudiante)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Map<String, Double> creditosSemestre = new HashMap<String, Double>();
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				double conteo = 0;
				List<Curso> cursos = entry.getValue();
				for(Curso curso: cursos)
				{
					conteo += curso.darCreditos();		
				}
				creditosSemestre.put(entry.getKey(), conteo);
			}
		}
		return creditosSemestre;
	}
	
}
