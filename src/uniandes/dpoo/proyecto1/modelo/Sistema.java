package uniandes.dpoo.proyecto1.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sistema {

	private boolean conflicto;
	private Estudiante estudiante;

	public boolean detectarConflicto(Map<String, List<Curso>> cursosAprobados) 
	{
		for (List<Curso> cursos : cursosAprobados.values()) 
		{
			if (cumpleRequisitos(cursos))
				return true;
		}
		return false;
	}
	public boolean cumpleRequisitos(List<Curso> cursos)
	{
		HashMap<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		for (int i = 0; i < cursos.size(); i++) 
		{
			List<Curso> prerrequisitos = cursos.get(i).darPrerrequisitos();
			for (List<Curso> aprobados : cursosAprobados.values()) 
			{
				for (int j = 0; j < aprobados.size(); i++) 
				{
					Curso aprobado = aprobados.get(i);
					if (prerrequisitos.contains(aprobado))
					{
						return true;
					}
				}	
			}
		}
		return false;
	}	
}

