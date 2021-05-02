package uniandes.dpoo.proyecto2.persistencia;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uniandes.dpoo.proyecto2.core.pensum.Curso;
import uniandes.dpoo.proyecto2.core.pensum.LoaderPensum;

public class ReporteNotas
{
	public void generarReporteNotas(Map<String, List<Curso>> cursosAprobados)
	{
		Map<String, Float> notasSemestre = new HashMap<String, Float>();
		Iterator<Entry<String, List<Curso>>> it = cursosAprobados.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<Curso>> pair = (Entry<String, List<Curso>>)it.next();
			for(Curso curso: pair.getValue())
			{
				String nota = curso.darNota();
				boolean esFloat = isFloat(nota);
				if(esFloat)
				{
					notasSemestre.put(pair.getKey(), Float.parseFloat(nota));
				}
			}
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove(); // avoids a ConcurrentModificationException
		}
	}
	public Map<String, Float> calcularPromedioSemestres(Map<String, List<Curso>> cursosAprobados)
	{
		Map<String, Float> promediosSemestre = new HashMap<String, Float>();
		Iterator<Entry<String, List<Curso>>> it = cursosAprobados.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, List<Curso>> pair = (Entry<String, List<Curso>>)it.next();
			Float sumanotas = (float) 0;
			int contador = 0;
			for(Curso curso: pair.getValue())
			{
				String nota = curso.darNota();
				boolean esFloat = isFloat(nota);
				if(esFloat)
				{
					Float notafloat = Float.parseFloat(nota);
					sumanotas += notafloat;
					contador += 1;
				}
			}
			Float promediosemestre = sumanotas/contador;
			promediosSemestre.put(pair.getKey(), promediosemestre);
		}
		return promediosSemestre;
	}  
	
	public Float calcularPromedioAcumulado(Map<String, Float> promediosSemestre)
	{
		Iterator<Entry<String, Float>> it = promediosSemestre.entrySet().iterator();
		Float sumapromedios = (float) 0;
		int contador = 0;
		while (it.hasNext()) 
		{
			Map.Entry<String, Float> pair = (Entry<String, Float>)it.next();
			Float nota = pair.getValue();
			sumapromedios += nota;
			contador += 1;
		}
		float acumulado = sumapromedios / contador;
		return acumulado;
	}
	
	public boolean isFloat( String input ) {
		try {
			Float.parseFloat( input );
			return true;
		}
		catch( Exception e ) {
			return false;
		}
	}
}
