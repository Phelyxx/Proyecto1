package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.core.pensum.Correquisito;
import uniandes.dpoo.proyecto1.core.pensum.Curso;
import uniandes.dpoo.proyecto1.core.pensum.LoaderPensum;
import uniandes.dpoo.proyecto1.core.pensum.Pensum;
import uniandes.dpoo.proyecto1.core.pensum.Prerrequisito;
import uniandes.dpoo.proyecto1.reporteador.CalculadoraReportes;

public class MenuDelEstudiante extends JFrame implements ActionListener
{
     /**
	 * 
	 */
	private static final long serialVersionUID = 2L;
    private Panelimagen imagen;
    private JButton RegistrarCursos;
    private JButton VerCursosVistos;
    private JButton PlanearMaterias;
    private JButton VerCursosPlaneados;
    private JButton VerAvancesDeCarrera;
    private JButton VerPromedioGeneral;
    private JButton GenerarReporteDeNotas;
    private JButton HacerPractica;
    private JButton RetirarCurso;
    private JButton ActualizarCurso;
    private JButton cargar;
    private PanelCentro centro;
    private JTextField titulo;
  //abajo
  	private PanelAbajo abajo;
  	private JButton btnReiniciar;
  	private Estudiante estudiante;
  
  public MenuDelEstudiante(String codigo)
  {
	    
	    setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		centro = new PanelCentro();
		centro.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(4,2));
		centro.setBackground(new Color (255,255,200));
		imagen = new Panelimagen();
		imagen.setBackground(new Color (255,255,200));
		add(centro, BorderLayout.CENTER);
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));
		
		RegistrarCursos = new JButton("Registrar Cursos Vistos");
		VerCursosVistos = new JButton("Ver Cursos Vistos");
		PlanearMaterias = new JButton("Planear Materias");
		VerCursosPlaneados =new JButton("Ver Cursos Planeados");
		VerAvancesDeCarrera = new JButton("Ver Avances De Carrera");
		VerPromedioGeneral = new JButton("Ver Promedio General");
		GenerarReporteDeNotas = new JButton("Generar Reporte De Notas");
		HacerPractica = new JButton("Hacer práctica");
		RetirarCurso = new JButton("Retirar Curso");
		ActualizarCurso = new JButton("Actualizar Curso");
		cargar = new JButton("Cargar Pensum");
		
		
		
		RegistrarCursos.addActionListener(this);
		VerCursosVistos.addActionListener(this);
		PlanearMaterias.addActionListener(this);
		VerCursosPlaneados.addActionListener(this);
		VerAvancesDeCarrera.addActionListener(this);
		VerPromedioGeneral.addActionListener(this);
		GenerarReporteDeNotas.addActionListener(this);
		HacerPractica.addActionListener(this);
		RetirarCurso.addActionListener(this);
		ActualizarCurso.addActionListener(this);
		cargar.addActionListener(this);
		
		Map<String, List<Curso>> cursosAprobados = new HashMap<String, List<Curso>>();
		Map<String, List<Curso>> cursosPlaneados = new HashMap<String, List<Curso>>();
		Map<String, Boolean> estadoRequisitosPensum = new HashMap<String, Boolean>();
		estudiante = new Estudiante(codigo, cursosAprobados, cursosPlaneados, estadoRequisitosPensum, "Normal");
		
		RegistrarCursos.setActionCommand("R");
		VerCursosVistos.setActionCommand("VCV");
		PlanearMaterias.setActionCommand("P");
		VerCursosPlaneados.setActionCommand("VCP");
		VerAvancesDeCarrera.setActionCommand("VA");
		VerPromedioGeneral.setActionCommand("VP");
		GenerarReporteDeNotas.setActionCommand("G");
		cargar.setActionCommand("C");
		HacerPractica.setActionCommand("HP");
		RetirarCurso.setActionCommand("RC");
		ActualizarCurso.setActionCommand("AC");
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		centro.add(RegistrarCursos,BorderLayout.CENTER);
		centro.add(VerCursosVistos,BorderLayout.CENTER);
		centro.add(PlanearMaterias,BorderLayout.CENTER);
		centro.add(VerCursosPlaneados,BorderLayout.CENTER);
		centro.add(VerAvancesDeCarrera,BorderLayout.CENTER);
		centro.add(VerPromedioGeneral,BorderLayout.CENTER);
		centro.add(GenerarReporteDeNotas,BorderLayout.CENTER);
		centro.add(HacerPractica,BorderLayout.CENTER);
		centro.add(RetirarCurso,BorderLayout.CENTER);
		centro.add(ActualizarCurso,BorderLayout.CENTER);
		centro.add(cargar,BorderLayout.CENTER);
		
		titulo = new JTextField("Menu Del Estudiante",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		abajo.add(btnReiniciar, BorderLayout.CENTER);
	    add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
  }
  
  


@Override
public void actionPerformed(ActionEvent e) 
 {
	String comando = e.getActionCommand();
	// TODO Auto-generated method stub
	if(comando.equals("R"))
	{
		RegistroDeCursos menu = new RegistroDeCursos(estudiante);
		menu.setVisible(true);
		this.dispose();
	} 
	else if (comando.equals("VCV"))
	{
		CursosVistos menu = new CursosVistos(estudiante);
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("P"))
	{
		MateriasFuturas menu = new MateriasFuturas(estudiante);
		this.dispose();
		menu.setVisible(true);
		
	}	
	else if (comando.equals("VCP"))
	{
		Escenario menu = new Escenario(estudiante);
		this.dispose();
		menu.setEstudiante(estudiante);
		menu.setVisible(true);
	}	
	else if (comando.equals("VA"))
	{
		AvanceDeCarrera menu = new AvanceDeCarrera(estudiante);
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("VP"))
	{
		Float nota = CalculadoraReportes.calcularPGA(estudiante);
		JOptionPane.showMessageDialog(null, "Su promedio general es: " + String.valueOf(nota));
	}	
	else if (comando.equals("G"))
	{
		ReporteDeNotas menu = new ReporteDeNotas(estudiante);
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("V"))
	{
		PanelVentanaPrincipal menu = new PanelVentanaPrincipal();
		menu.setVisible(true);
		this.dispose();
	}
	else if (comando.equals("C"))
	{
        CargarPensum menu = new CargarPensum(estudiante);
		menu.setVisible(true);
		this.dispose();
	}
	else if (comando.equals("RC"))
	{
		String codigo  = JOptionPane.showInputDialog(null,"Ingrese el codigo del curso:  ");
		Curso curso = LoaderPensum.encontrarCurso(estudiante.darPensum().consultarCursos(), codigo);
		boolean retirado = estudiante.retirarCurso(curso);
		if(retirado)
		{
		JOptionPane.showMessageDialog(null, "Curso retirado");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No existe el curso");	
		}
	}
	else if (comando.equals("AC"))
	{
		String codigo  = JOptionPane.showInputDialog(null,"Ingrese el codigo del curso:  ");
		String nota  = JOptionPane.showInputDialog(null,"Ingrese la nota actualizada:  ");
		Curso curso = LoaderPensum.encontrarCurso(estudiante.darPensum().consultarCursos(), codigo);
		boolean actualizado = estudiante.actualizarCurso(curso, nota);
		if(actualizado)
		{
		JOptionPane.showMessageDialog(null, "Curso actualizado");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "No existe el curso");	
		}
	}
	else if (comando.equals("HP"))
	{
		List<Curso> cursospensum = estudiante.darPensum().consultarCursos();
		List<Prerrequisito> prerrequisitos = new ArrayList<Prerrequisito>();
		List<Correquisito> correquisitos = new ArrayList<Correquisito>();
		Curso practica = new Curso(	"Práctica Profesional","PRTC-0000",6,false,false,false,false,false,false,false,prerrequisitos,correquisitos,"0",0,0,"0");
		cursospensum.add(practica);
		JOptionPane.showMessageDialog(null, "Ahora puede registrar el curso de práctica PRTC-0000: ");
	}
 }
	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}
}
