package uniandes.dpoo.proyecto1.interfaz;

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

import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.core.pensum.Curso;
import uniandes.dpoo.proyecto1.core.pensum.LoaderPensum;
import uniandes.dpoo.proyecto1.core.pensum.Pensum;

public class CursosVistos extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 7L;
	//arriba
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


	public CursosVistos(Estudiante estudiante)
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setEstudiante(estudiante);

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

		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		txtvariables = new JTextField ("Codigo / Semestre / Nota / RequisitoEspecial: ");
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
		if(cursosAprobados != null)
		{
			for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
			{
				List<Curso> cursos = entry.getValue();
				for(Curso curso: cursos)
				{
					String codigo = curso.darCodigo();
					int semestre = curso.darSemestre();
					String nota = curso.darNota();
					String cbu = "";
					String tipoI= "";
					String epsilon= "";
					String tipoE = "";
					System.out.println(curso.esCBU());
					if(curso.esCBU())
					{
						cbu = "CBU";
					}
					if(curso.esTipoI())
					{
						tipoI = "Tipo I";
					}
					if(curso.esTipoE())
					{
						tipoE = "Tipo E";
					}
					if(curso.esEpsilon())
					{
						epsilon = "Epsilon";
					}
					vacio = new JTextField(codigo + " Semestre " + String.valueOf(semestre) + " Nota " + nota + " " + cbu +  
							" " + tipoI + "  " + epsilon + "  " + tipoE, 5);
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
			MenuDelEstudiante menu = new MenuDelEstudiante(null);
			menu.setVisible(true);
			menu.setEstudiante(estudiante);
			this.dispose();
		} 
	}


	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}

	



}
