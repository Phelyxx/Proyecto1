package uniandes.dpoo.proyecto1.procesamiento;

import java.util.HashMap;
import java.util.TreeSet;

public class InformacionPensum {

	private int numeroCreditosMax;
	private String cursosObligatorios[];
	private String cursosElectivos[];
	private String cursosElectivosRegulados[];
	private TreeSet<String> restricciones;
	private String RequisitosAdicionales[];
	private String nombrePrograma;
	private HashMap<String, String[]> cronograma; 
}
