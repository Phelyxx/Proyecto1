package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.core.pensum.Curso;
import uniandes.dpoo.proyecto1.core.pensum.LoaderPensum;
import uniandes.dpoo.proyecto1.core.pensum.Pensum;

public class RegistroDeCursos  extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4L;
	
	
	private JTextField txtCursoTomado;
	private JTextField txtQueSemestre;
	private JTextField txtNota;
	private JTextField txtCaracteristicas;
	private JTextField inputCodigo;
	private JTextField inputSemestre;
	private JTextField inputNota;
	private JTextField inputCaracteristica;
	private String nota;
	private String codigo;
	private String numSemestre; 
	private String caracteristicaEspecial;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;
	//arriba
	private Panelimagen imagen;
	//centro
	private PanelCentro centro;
	//titulo
	private JTextField titulo;

	private Pensum pensum;
	private Estudiante estudiante;
	
	
	
	public RegistroDeCursos()
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		centro = new PanelCentro();
		add(centro, BorderLayout.CENTER);
		centro.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(4,2));
		centro.setBackground(new Color (255,255,200));
		imagen = new Panelimagen();
		imagen.setBackground(new Color (255,255,200));
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));
		
		

		
		txtCursoTomado = new JTextField ("Curso que tomo (Ejemplo: MATE-1203): ");
		txtCursoTomado.setEditable(false);
		txtCursoTomado.setBackground(new Color (255,255,230));
		txtCursoTomado.setBorder(null);


		
		txtQueSemestre = new JTextField ("En que semestre vio el curso (Ejemplo: 1): ");
		txtQueSemestre.setEditable(false);
		txtQueSemestre.setBackground(new Color (255,255,230));
		txtQueSemestre.setBorder(null);
		
		txtNota = new JTextField ("Nota (Ejemplo: 4.8, A, R, I): ");
		txtNota.setEditable(false);
		txtNota.setBackground(new Color (255,255,230));
		txtNota.setBorder(null);
		
		txtCaracteristicas = new JTextField ("Caracteristica especial (requisitos\r\n"
				+ "cumplidos) (Ejemplo: No, Tipo I): ");
		txtCaracteristicas.setEditable(false);
		txtCaracteristicas.setBackground(new Color (255,255,230));
		txtCaracteristicas.setBorder(null);
		
		
		titulo = new JTextField("Registro De Cursos",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		inputCodigo = new JTextField(5);
		inputCodigo.addActionListener(this);
		inputSemestre = new JTextField(5);
		inputSemestre.addActionListener(this);
		inputNota = new JTextField(5);
		inputNota.addActionListener(this);
		inputCaracteristica = new JTextField(5);
		inputCaracteristica.addActionListener(this);
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		centro.add(txtCursoTomado,BorderLayout.CENTER);
		centro.add(inputCodigo,BorderLayout.CENTER);
		centro.add(txtQueSemestre,BorderLayout.CENTER);
		centro.add(inputSemestre,BorderLayout.CENTER);
		centro.add(txtNota,BorderLayout.CENTER);
		centro.add(inputNota,BorderLayout.CENTER);
		centro.add(txtCaracteristicas,BorderLayout.CENTER);
		centro.add(inputCaracteristica,BorderLayout.CENTER);
		
		 
		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
		
	}
	
	
	
	public static void main(String[] args)
	{
		
      RegistroDeCursos ventana = new  RegistroDeCursos();
		ventana.setVisible(true);
		
	}




	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		Object fuente = e.getSource();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MenuDelEstudiante menu = new MenuDelEstudiante();
			menu.setVisible(true);
			System.out.println(pensum);
			menu.setPensum(pensum);
			this.dispose();
		} 
		if(fuente == inputCodigo)
		{
			Curso encontrado = LoaderPensum.encontrarCurso(pensum.consultarCursos(), e.getActionCommand());
			System.out.println(encontrado);
			JOptionPane.showMessageDialog(rootPane, "Curso " + encontrado.darCodigo() + " encontrado");
			this.codigo = e.getActionCommand();
		}
		if(fuente == inputSemestre)
		{
			JOptionPane.showMessageDialog(rootPane, "Semestre digitado");
			System.out.println(e.getActionCommand());	
			this.numSemestre = e.getActionCommand();
		}
		if(fuente == inputNota)
		{
			JOptionPane.showMessageDialog(rootPane, "Nota digitada");
			System.out.println(e.getActionCommand());	
			this.nota = e.getActionCommand();
		}
		if(fuente == inputCaracteristica)
		{
			JOptionPane.showMessageDialog(rootPane, "Caracteristica digitada");
			caracteristicaEspecial = e.getActionCommand();
			estudiante.setPensum(pensum);
			estudiante.agregarCurso(codigo, numSemestre, nota, caracteristicaEspecial);
			System.out.println(estudiante.darCursosAprobados().entrySet());
			this.dispose();
			MenuDelEstudiante menu = new MenuDelEstudiante();
			menu.setVisible(true);
			menu.setEstudiante(estudiante);
			menu.setPensum(pensum);
		}
	}
	public void setPensum(Pensum pensum)
	{	
		this.pensum = pensum;
	}
	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}
}
