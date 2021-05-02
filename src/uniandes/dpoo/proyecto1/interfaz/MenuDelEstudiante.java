package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

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
    private JButton cargar;
    private PanelCentro centro;
    private JTextField titulo;
  //abajo
  	private PanelAbajo abajo;
  	private JButton btnReiniciar;
  
  public MenuDelEstudiante()
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
		cargar = new JButton("Cargar Pensum");
		
		
		
		RegistrarCursos.addActionListener(this);
		VerCursosVistos.addActionListener(this);
		PlanearMaterias.addActionListener(this);
		VerCursosPlaneados.addActionListener(this);
		VerAvancesDeCarrera.addActionListener(this);
		VerPromedioGeneral.addActionListener(this);
		GenerarReporteDeNotas.addActionListener(this);
		cargar.addActionListener(this);
		
		
		
		RegistrarCursos.setActionCommand("R");
		VerCursosVistos.setActionCommand("VCV");
		PlanearMaterias.setActionCommand("P");
		VerCursosPlaneados.setActionCommand("VCP");
		VerAvancesDeCarrera.setActionCommand("VA");
		VerPromedioGeneral.setActionCommand("VP");
		GenerarReporteDeNotas.setActionCommand("G");
		cargar.setActionCommand("C");
		
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
		centro.add(cargar,BorderLayout.CENTER);
		
		titulo = new JTextField("Menu Del Estudiante",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		abajo.add(btnReiniciar, BorderLayout.CENTER);
	    add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
  }
  
  
  public static void main(String[] args)
	{
		
      MenuDelEstudiante ventana = new  MenuDelEstudiante();
		ventana.setVisible(true);
		
	}


@Override
public void actionPerformed(ActionEvent e) 
 {
	String comando = e.getActionCommand();
	// TODO Auto-generated method stub
	if(comando.equals("R"))
	{
		RegistroDeCursos menu = new RegistroDeCursos();
		menu.setVisible(true);
		this.dispose();
	} 
	else if (comando.equals("VCV"))
	{
		CursosVistos menu = new CursosVistos();
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("P"))
	{
		MateriasFuturas menu = new MateriasFuturas();
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("VCP"))
	{
		Escenario menu = new Escenario();
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("VA"))
	{
		AvanceDeCarrera menu = new AvanceDeCarrera();
		menu.setVisible(true);
		this.dispose();
	}	
	else if (comando.equals("VP"))
	{
		JOptionPane.showMessageDialog(null, "Su promedio general es: 37");
	}	
	else if (comando.equals("G"))
	{
		ReporteDeNotas menu = new ReporteDeNotas();
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
        CargarPensum menu = new CargarPensum();
		menu.setVisible(true);
		this.dispose();
	}
 }
}
