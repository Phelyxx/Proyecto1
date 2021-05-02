package uniandes.dpoo.proyecto2.core.pensum;

import java.util.List;

public class Prerrequisito
{
	private List<Curso> prerreqs;
	
	public Prerrequisito(List<Curso> prerreqs)
	{
	this.prerreqs = prerreqs;	
	}
	public List<Curso> darPrerreqs()
	{
		return prerreqs;
	}
	public List<Curso> add(Curso encontrado)
	{
		prerreqs.add(encontrado);
		return prerreqs;		
	}
}

