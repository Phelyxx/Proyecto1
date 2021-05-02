package uniandes.dpoo.proyecto2.core.estudiante;

import java.util.List;

import uniandes.dpoo.proyecto2.core.pensum.Correquisito;
import uniandes.dpoo.proyecto2.core.pensum.Curso;
import uniandes.dpoo.proyecto2.core.pensum.Prerrequisito;

public class CursoInscrito extends Curso
{

	public CursoInscrito(String nombre, String codigo, int creditos, boolean esObligatorio,
			boolean esElectivaIngenieria, boolean esElectivaProfesional, boolean esCBU, boolean esTipoI,
			boolean esTipoE, boolean esEpsilon, List<Prerrequisito> prerrequisitos, List<Correquisito> correquisitos,
			String semanas, int nivel, int semestre)
	{
		super(nombre, codigo, creditos, esObligatorio, esElectivaIngenieria, esElectivaProfesional, esCBU, esTipoI, esTipoE,
				esEpsilon, prerrequisitos, correquisitos, semanas, nivel, semestre);
		// TODO Auto-generated constructor stub
	}

}
