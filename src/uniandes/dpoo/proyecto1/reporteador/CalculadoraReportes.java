package uniandes.dpoo.proyecto1.reporteador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.core.pensum.Curso;

public class CalculadoraReportes
{
	public static float calcularPGA(Estudiante estudiante)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Float pga = (float) 0;
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				List<Curso> cursos = entry.getValue();
				Float creditosSemestre = (float) 0;
				for(Curso curso: cursos)
				{
					creditosSemestre += curso.darCreditos();
				}
				Float promedio = CalculadoraReportes.calcularPromedioSemestre(estudiante, entry.getKey());
				pga += promedio * creditosSemestre;
			} 
			Map<String, Integer> creditos_semestre = CalculadoraReportes.calcularCreditosPorSemestre(estudiante);
			int sumacreditos = 0;
			for(Map.Entry<String, Integer> entry : creditos_semestre.entrySet()) 
			{
				System.out.println(entry.getValue());
				sumacreditos += entry.getValue();
			}
			pga = pga / sumacreditos;
		}
		return pga;
	}
	public static float calcularPromedioSemestre(Estudiante estudiante, String semestre)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Float promedio = (float) 0;
		if(cursosAprobados != null)
		{
			List<Curso> cursos = cursosAprobados.get(semestre);
			int conteocreditos = 0;
			Float conteocreditosnota = (float) 0;
			for(Curso curso: cursos)
			{
				int creditos = curso.darCreditos();
				String nota = curso.darNota();
				conteocreditos += creditos;
				try
				{
				Float creditosNota = creditos * Float.parseFloat(nota);
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



	public static Map<String, Integer> calcularCreditosPorSemestre(Estudiante estudiante)
	{
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Map<String, Integer> creditosSemestre = new HashMap<String, Integer>();
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				int conteo = 0;
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
