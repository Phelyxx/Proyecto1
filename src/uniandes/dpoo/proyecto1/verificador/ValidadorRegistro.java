package uniandes.dpoo.proyecto2.verificador;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uniandes.dpoo.proyecto2.core.estudiante.CursoInscrito;
import uniandes.dpoo.proyecto2.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto2.core.pensum.Correquisito;
import uniandes.dpoo.proyecto2.core.pensum.Curso;
import uniandes.dpoo.proyecto2.core.pensum.Pensum;
import uniandes.dpoo.proyecto2.core.pensum.Prerrequisito;

public class ValidadorRegistro
{

	public static boolean validarRestriccionesCurso(String codigoDigitado, String numSemestre, 
			String nota, String caracteristicaEspecial, Estudiante estudiante, List<Curso> cursospensum) 
	{
		for(Curso cursopensum: cursospensum)
		{
			if(cursopensum.darCodigo().equals(codigoDigitado))
			{
				List<Correquisito> correquisitos = cursopensum.darCorrequisitos();
				List<Prerrequisito> prerrequisitos = cursopensum.darPrerrequisitos();
				boolean validarPrerreq = validarPrerrequisitos();
				boolean validarCorreq = validarCorrequisitos();
				boolean validarNivel = validarNivel();
				boolean validarRestriccionesPensum = validarRestriccionesPensum();
				boolean validarSemanas = validarRestriccionesPensum();
				if((validarPrerreq && validarCorreq && validarNivel && validarRestriccionesPensum && validarSemanas) == true)
				{
					return true;
				}
			}
		}		
		return false;

	}
	public static boolean validarPrerrequisitos()
	{
		return false;

	}
	public static boolean validarCorrequisitos()
	{
		return false;

	}	
	public static boolean validarNivel()
	{
		return false;

	}		
	public static boolean validarRestriccionesPensum()
	{
		return false;

	}	
	public static void validarOchoSemanas()
	{

	}			
}
