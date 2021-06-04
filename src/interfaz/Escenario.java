package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import modelo.core.pensum.Curso;
import modelo.core.pensum.Estudiante;

public class Escenario extends JFrame implements ActionListener
{
    /**
 * 
 */
private static final long serialVersionUID = 5L;
	//abajo
private Panelimagen imagenArriba;
//centro
private PanelCentro centro;
//abajo
private PanelAbajo abajo;
private JButton btnReiniciar;  
//titulo
private JTextField titulo;

private JTextField txtvariables;
private JTextField vacio;
private Estudiante estudiante;
	
	
	public Escenario(Estudiante estudiante) 
	{
	setSize(900,700);
	setTitle("Mi Banner");
	setResizable(false);
	setDefaultCloseOperation(EXIT_ON_CLOSE);


	centro = new PanelCentro();
	centro.setLayout(new BorderLayout());
	centro.setLayout(new GridLayout(16,1));
	centro.setBackground(new Color (255,255,200));
	imagenArriba = new Panelimagen();
	imagenArriba.setBackground(new Color (255,255,200));
	add(centro, BorderLayout.CENTER);
	abajo = new PanelAbajo();
	add(abajo, BorderLayout.SOUTH);
	abajo.setBackground(new Color (255,255,200));
	setEstudiante(estudiante);

	Map<String, List<Curso>> cursosPlaneados = estudiante.darCursosPlaneados();
	txtvariables = new JTextField ("Codigo / Semestre ");
	txtvariables.setEditable(false);
	txtvariables.setBackground(new Color (255,255,230));
	txtvariables.setBorder(null);

	btnReiniciar = new JButton ("VOLVER");
	btnReiniciar.addActionListener(this);
	btnReiniciar.setActionCommand("V");


	titulo = new JTextField("Cursos vistos",2);
	titulo.setEditable(false);
	titulo.setBorder(null);
	titulo.setBackground(new Color (255,255,230));

	centro.add(txtvariables,BorderLayout.CENTER);
	if(cursosPlaneados != null)
	{
		for (Map.Entry<String, List<Curso>> entry : cursosPlaneados.entrySet()) 
		{
			List<Curso> cursos = entry.getValue();
			for(Curso curso: cursos)
			{
				String codigo = curso.darCodigo();
				int semestre = curso.darSemestre();
				vacio = new JTextField(codigo + " Semestre " + String.valueOf(semestre));
				centro.add(vacio,BorderLayout.CENTER);
			}
		} 
	}


	abajo.add(btnReiniciar, BorderLayout.CENTER);
	add(imagenArriba, BorderLayout.NORTH);
	imagenArriba.add(titulo, BorderLayout.NORTH);

	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			this.dispose();
			MenuDelEstudiante menu = new MenuDelEstudiante(null);
			menu.setEstudiante(estudiante);
			menu.setVisible(true);
			
		} 
		
	}

	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

}
