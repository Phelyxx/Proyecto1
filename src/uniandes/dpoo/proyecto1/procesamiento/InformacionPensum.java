package uniandes.dpoo.proyecto1.procesamiento;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class InformacionPensum 
{
    
	private int numeroCreditosMax;
	private String cursosObligatorios[];
	private String cursosElectivos[];
	private String cursosElectivosRegulados[];
	private TreeSet<String> restricciones;
	private String RequisitosAdicionales[];
	private String nombrePrograma;
	private HashMap<String, String[]> cronograma; 
	
	
	public InformacionPensum (int creditos, String[] cursosObligatorios, String[] cursosElectivos,String[] cursosElectivosRegulados,
			TreeSet<String> restricciones, String[] RequisitosAdicionales, String nombrePrograma, HashMap<String, String[]> cronograma)
	{
		this.numeroCreditosMax = creditos;
		this.cursosObligatorios = cursosObligatorios;
		this.cursosElectivos = cursosElectivos;
		this.cursosElectivosRegulados = cursosElectivosRegulados;
		this.restricciones = new TreeSet<>();
		this.RequisitosAdicionales = RequisitosAdicionales;
		this.nombrePrograma = nombrePrograma;
		this.cronograma = cronograma;
	}
}
