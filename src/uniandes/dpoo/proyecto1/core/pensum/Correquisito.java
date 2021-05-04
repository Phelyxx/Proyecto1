package uniandes.dpoo.proyecto1.core.pensum;

import java.util.List;

public class Correquisito
{
	private List<Curso> correqs;
	
	public Correquisito(List<Curso> correqs)
	{
	this.correqs = correqs;	
	}
	public List<Curso> darCorreqs()
	{
		return correqs;
	}
	public List<Curso> add(Curso encontrado)
	{
		correqs.add(encontrado);
		return correqs;		
	}
}

