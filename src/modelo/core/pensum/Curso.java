package modelo.core.pensum;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Curso
{
	private String nombre;
	private String codigo;
	private double creditos;
	private String nota;
	private boolean esObligatorio;
	private boolean esElectivaIngenieria;
	private boolean esElectivaProfesional;
	private boolean esCBU;
	private boolean esTipoI;
	private boolean esTipoE;
	private boolean esEpsilon;
	private List<Prerrequisito> prerrequisitos;
	private List<Correquisito> correquisitos;
	private String semanas;
	private int nivel;
	private int semestre;
	public Curso(String nombre, String codigo, double creditos, boolean esObligatorio, boolean esElectivaIngenieria, boolean esElectivaProfesional,
			boolean esCBU, boolean esTipoI, boolean esTipoE, boolean esEpsilon,  List<Prerrequisito> prerrequisitos,
			List<Correquisito> correquisitos, String semanas, int nivel, int semestre, String nota )
	{
		this.nombre = nombre;
		this.codigo = codigo;
		this.creditos = creditos;
		this.esObligatorio = esObligatorio;
		this.esElectivaIngenieria = esElectivaIngenieria;
		this.esElectivaProfesional = esElectivaProfesional;
		this.esCBU = esCBU;
		this.esTipoI = esTipoI;
		this.esTipoE = esTipoE;
		this.esEpsilon = esEpsilon;
		this.prerrequisitos = prerrequisitos;
		this.correquisitos =  correquisitos;
		this.semanas = semanas;
		this.nivel = nivel;
		this.semestre = semestre;
		this.nota = nota;
	}
	public List<Prerrequisito> darPrerrequisitos()
	{
		return prerrequisitos;
	}
	
	public List<Correquisito> darCorrequisitos()
	{
		return correquisitos;
	}
	
	public String darCodigo()
	{
		return codigo;
	}
	public String darNombre()
	{
		return nombre;
	}
	public String darNota()
	{
		return nota;
	}
	public int darSemestre()
	{
		return semestre;
	}
	public double darCreditos()
	{
		return creditos;
	}
	public boolean darEsElectivaIngenieria()
	{
		return esElectivaIngenieria;
	}
	public boolean esCBU()
	{
		return esCBU;
	}
	public boolean esTipoE()
	{
		return esTipoE;
	}
	public boolean esEpsilon()
	{
		return esEpsilon;
	}
	public boolean EsElectivaProfesional()
	{
		return esElectivaProfesional;
	}
	public boolean esTipoI()
	{
		return esTipoI;
	}
	public boolean esObligatorio()
	{
		return esObligatorio;
	}
	public void setCorrequisitos(List<Correquisito> correquisitos)
	{
		this.correquisitos = correquisitos;
	}
	public void setPrerrequisitos(List<Prerrequisito> prerrequisitos)
	{
		this.prerrequisitos = prerrequisitos;
	}
	public void setSemestre(int semestre)
	{
		this.semestre = semestre;
	}
	public void setNota(String nota)
	{
		this.nota = nota;
	}
	public int darNivel()
	{
		return nivel;
	}
	public String darSemanas()
	{
		return semanas;
	}
	public void setTipoE(boolean b)
	{
		this.esTipoE = b;
	}
	public void setCreditos(double creditos)
	{
		this.creditos = creditos;
		
	}
}

