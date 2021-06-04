package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import modelo.core.pensum.Estudiante;

public class MateriasFuturas extends JFrame implements ActionListener
{
    /**
 * 
 */
private static final long serialVersionUID = 5L;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;
	//arriba
	private Panelimagen imagen;
	//centro
	private PanelCentro centro;
	//titulo
	private JTextField titulo;
	
	private JTextField nombre;
	private JTextField semestre;
	private JTextField codigoCurso;
	private JTextField numSemestre;
	private JButton btnEscenario;
	private Estudiante estudiante;
	
	
	public MateriasFuturas(Estudiante estudiante) 
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		centro = new PanelCentro();
		add(centro, BorderLayout.CENTER);
		centro.setBackground(new Color (255,255,200));
		imagen = new Panelimagen();
		imagen.setBackground(new Color (255,255,200));
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));
		setEstudiante(estudiante);
		
		nombre = new JTextField ("Codigo del curso que desea ver: ");
		nombre.setEditable(false);
		nombre.setBackground(new Color (255,255,230));
		nombre.setBorder(null);
		
		semestre = new JTextField ("En que semestre desea ver curso: ");
		semestre.setEditable(false);
		semestre.setBackground(new Color (255,255,230));
		semestre.setBorder(null);
		
		codigoCurso = new JTextField(10);
		numSemestre = new JTextField(10);
		
		
		titulo = new JTextField("Registro De Cursos Futuros",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		btnEscenario = new JButton ("Ver escenario");
		btnEscenario.addActionListener(this);
		btnEscenario.setActionCommand("E");
		
		
		centro.add(nombre,BorderLayout.CENTER);
		centro.add(codigoCurso,BorderLayout.CENTER);
		centro.add(semestre,BorderLayout.CENTER);
		centro.add(numSemestre,BorderLayout.CENTER);
		centro.add(btnEscenario,BorderLayout.CENTER);
		
		
		
		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
		
	}
	
		@Override
		public void actionPerformed(ActionEvent e)
		{
			String comando = e.getActionCommand();
			// TODO Auto-generated method stub
			if(comando.equals("V"))
			{
				MenuDelEstudiante menu = new MenuDelEstudiante(null);
				menu.setVisible(true);
				this.dispose();
				menu.setEstudiante(estudiante);
			} 
			else if (comando.equals("E"))
			{
				String inputCodigo = codigoCurso.getText();
				String inputSemestre = numSemestre.getText();
				estudiante.planearCurso(inputCodigo, inputSemestre);
				this.dispose();
				Escenario menu = new Escenario(estudiante);
				menu.setVisible(true);
			} 
		}
		public void setEstudiante(Estudiante estudiante)
		{
			this.estudiante = estudiante;
		}
	
}
