package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
	private JTextField vacio;
	private JTextField vacio1;
	private JTextField vacio2;
	private JTextField vacio3;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;
	//arriba
	private Panelimagen imagen;
	//centro
	private PanelCentro centro;
	//titulo
	private JTextField titulo;
	
	
	
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
		
		

		
		txtCursoTomado = new JTextField ("Curso que tomo: ");
		txtCursoTomado.setEditable(false);
		txtCursoTomado.setBackground(new Color (255,255,230));
		txtCursoTomado.setBorder(null);
		
		txtQueSemestre = new JTextField ("En que semestre vio el curso: ");
		txtQueSemestre.setEditable(false);
		txtQueSemestre.setBackground(new Color (255,255,230));
		txtQueSemestre.setBorder(null);
		
		txtNota = new JTextField ("nota: ");
		txtNota.setEditable(false);
		txtNota.setBackground(new Color (255,255,230));
		txtNota.setBorder(null);
		
		txtCaracteristicas = new JTextField ("Caracteristica especial (requisitos\r\n"
				+ "cumplidos): ");
		txtCaracteristicas.setEditable(false);
		txtCaracteristicas.setBackground(new Color (255,255,230));
		txtCaracteristicas.setBorder(null);
		
		
		titulo = new JTextField("Registro De Cursos",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		vacio = new JTextField(5);
		vacio1 = new JTextField(5);
		vacio2 = new JTextField(5);
		vacio3= new JTextField(5);
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		centro.add(txtCursoTomado,BorderLayout.CENTER);
		centro.add(vacio,BorderLayout.CENTER);
		centro.add(txtQueSemestre,BorderLayout.CENTER);
		centro.add(vacio1,BorderLayout.CENTER);
		centro.add(txtNota,BorderLayout.CENTER);
		centro.add(vacio2,BorderLayout.CENTER);
		centro.add(txtCaracteristicas,BorderLayout.CENTER);
		centro.add(vacio3,BorderLayout.CENTER);
		
		 
		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
		
	}
	
	
	
	public static void main(String[] args)
	{
		
      RegistroDeCursos ventana = new  RegistroDeCursos();
		ventana.setVisible(true);
		
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MenuDelEstudiante menu = new MenuDelEstudiante();
			menu.setVisible(true);
			this.dispose();
		} 
		
	}
}
