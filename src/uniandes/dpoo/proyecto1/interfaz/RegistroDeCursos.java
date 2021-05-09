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

import javax.swing.AbstractButton;
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
	private JButton btnAgregar;
	//arriba
	private Panelimagen imagen;
	//centro
	private PanelCentro centro;
	//titulo
	private JTextField titulo;

	private Estudiante estudiante;

	private JTextField txtCreditos;
	private JTextField inputCreditos;
	private int creditos;
	
	
	
	public RegistroDeCursos(Estudiante estudiante)
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		centro = new PanelCentro();
		add(centro, BorderLayout.CENTER);
		centro.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(16,1));
		centro.setBackground(new Color (255,255,200));
		imagen = new Panelimagen();
		imagen.setBackground(new Color (255,255,200));
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));
		setEstudiante(estudiante);
		

		
		txtCursoTomado = new JTextField ("Curso que tomo (Ejemplo: MATE-1203): ");
		txtCursoTomado.setEditable(false);
		txtCursoTomado.setBackground(new Color (255,255,230));
		txtCursoTomado.setBorder(null);


		
		txtQueSemestre = new JTextField ("En que semestre vio el curso (Ejemplo: 1): ");
		txtQueSemestre.setEditable(false);
		txtQueSemestre.setBackground(new Color (255,255,230));
		txtQueSemestre.setBorder(null);
		
		txtCreditos = new JTextField ("Creditos del curso: ");
		txtCreditos.setEditable(false);
		txtCreditos.setBackground(new Color (255,255,230));
		txtCreditos.setBorder(null);
		
		txtNota = new JTextField ("Nota (Ejemplo: 4.8, A, R, I): ");
		txtNota.setEditable(false);
		txtNota.setBackground(new Color (255,255,230));
		txtNota.setBorder(null);
		
		txtCaracteristicas = new JTextField ("Caracteristica especial (requisitos\r\n"
				+ "cumplidos) (Ejemplo: No, Tipo E): ");
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
		inputCreditos = new JTextField(5);
		inputCreditos.addActionListener(this);
		inputNota = new JTextField(5);
		inputNota.addActionListener(this);
		inputCaracteristica = new JTextField(5);
		inputCaracteristica.addActionListener(this);
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		btnAgregar = new JButton ("Agregar");
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("E");
		
		centro.add(txtCursoTomado,BorderLayout.CENTER);
		centro.add(inputCodigo,BorderLayout.CENTER);
		centro.add(txtQueSemestre,BorderLayout.CENTER);
		centro.add(inputSemestre,BorderLayout.CENTER);
		centro.add(txtCreditos, BorderLayout.CENTER);
		centro.add(inputCreditos, BorderLayout.CENTER);
		centro.add(txtNota,BorderLayout.CENTER);
		centro.add(inputNota,BorderLayout.CENTER);
		centro.add(txtCaracteristicas,BorderLayout.CENTER);
		centro.add(inputCaracteristica,BorderLayout.CENTER);
		abajo.add(btnAgregar,BorderLayout.CENTER);
		
		 
		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		Object fuente = e.getSource();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MenuDelEstudiante menu = new MenuDelEstudiante(null);
			menu.setVisible(true);
			menu.setEstudiante(estudiante);
			this.dispose();
		} 
		if (comando.equals("A"))
		{
			
		} 
		if(fuente == inputCodigo)
		{
			JOptionPane.showMessageDialog(rootPane, "Curso digitado");
			this.codigo = e.getActionCommand();
		}
		if(fuente == inputSemestre)
		{
			JOptionPane.showMessageDialog(rootPane, "Semestre digitado");
			this.numSemestre = e.getActionCommand();
		}
		if(fuente == inputCreditos)
		{
			JOptionPane.showMessageDialog(rootPane, "Creditos digitados");
			this.creditos = Integer.parseInt(e.getActionCommand());
		}
		if(fuente == inputNota)
		{
			JOptionPane.showMessageDialog(rootPane, "Nota digitada");
			this.nota = e.getActionCommand();
		}
		if(fuente == inputCaracteristica)
		{
			JOptionPane.showMessageDialog(rootPane, "Caracteristica digitada");
			this.caracteristicaEspecial = e.getActionCommand();
			String agregado = estudiante.agregarCurso(codigo, numSemestre, creditos, nota, caracteristicaEspecial);
			if(!agregado.equals("Curso añadido"))
			{
				JOptionPane.showMessageDialog( this, agregado, "Error", JOptionPane.ERROR_MESSAGE );
			}
			this.dispose();
			MenuDelEstudiante menu = new MenuDelEstudiante(null);
			menu.setVisible(true);
			menu.setEstudiante(estudiante);
		}
	}
	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}
}
