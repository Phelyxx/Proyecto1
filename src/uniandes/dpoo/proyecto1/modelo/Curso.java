package uniandes.dpoo.proyecto1.modelo;

import java.util.ArrayList;
import java.util.List;


public class Curso 
{
	private String nombre;
	private int creditos;
	private boolean esObligatorio;
	private boolean esElectivaIngenieria;
	private boolean esElectivaProfesional;
	private String CBU;
	private boolean esTipoI;
	private boolean esTipoE;
	private boolean esEpsilon;
	private List<Curso> prerrequisitos;
	private List<Curso> correquisitos;
	private int semestre;
   
	public Curso(String nombre, int creditos, boolean esObligatorio, boolean esElectivaIngenieria, boolean esElectivaProfesional,
			String CBU, boolean esTipoI, boolean esTipoE, boolean esEpsilon, List<Curso> prerrequisitos, List<Curso> correquisitos, int semestre)
	{
		this.nombre = nombre;
		this.creditos = creditos;
		this.esObligatorio = esObligatorio;
		this.esElectivaIngenieria = esElectivaIngenieria;
		this.esElectivaProfesional = esElectivaProfesional;
		this.CBU = CBU;
		this.esTipoI = esTipoI;
		this.esTipoE = esTipoE;
		this.esEpsilon = esEpsilon;
		this.prerrequisitos = new ArrayList<>();
		this.correquisitos = new ArrayList<>();
		this.semestre = semestre;
	}
}
