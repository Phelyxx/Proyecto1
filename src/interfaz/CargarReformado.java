package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.core.pensum.Curso;
import modelo.core.pensum.Estudiante;
import modelo.persistencia.LoaderPensum;

public class CargarReformado extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 7L;
	//arriba
	private Panelimagen imagenArriba;
	//centro
	private PanelCentro centro;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;  
	private JButton btnReformado;  
	//titulo
	private JTextField titulo;

	private JTextField txtvariables;
	private JTextField txtAvance;
	private JTextField txtReformado;
	private JTextField vacio;
	private Estudiante estudiante;
	private List<String> homologados;


	public CargarReformado(Estudiante estudiante, String nombreArchivo) throws FileNotFoundException
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


		txtAvance = new JTextField ("Avance en el programa actual: ");
		txtAvance.setEditable(false);
		txtAvance.setBackground(new Color (255,255,230));
		txtAvance.setBorder(null);

		txtReformado = new JTextField ("Cursos a homologar en el programa reformado: ");
		txtReformado.setEditable(false);
		txtReformado.setBackground(new Color (255,255,230));
		txtReformado.setBorder(null);

		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		txtvariables = new JTextField ("Codigo / Semestre / Nota / RequisitoEspecial: ");
		txtvariables.setEditable(false);
		txtvariables.setBackground(new Color (255,255,230));
		txtvariables.setBorder(null);

		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");

		btnReformado = new JButton("Acepto el cambio a programa reformado");
		btnReformado.addActionListener(this);
		btnReformado.setActionCommand("A");


		titulo = new JTextField("Cursos vistos",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));

		centro.add(txtAvance,BorderLayout.CENTER);
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

		centro.add(txtReformado,BorderLayout.CENTER);
		try 
		{
			List<String> homologados = LoaderPensum.cargarReformado("./data/" + nombreArchivo, estudiante);
			if(homologados != null)
			{
				for(String homologado: homologados)
				{
					vacio = new JTextField(homologado);
					centro.add(vacio,BorderLayout.CENTER);
				}
				this.homologados = homologados;
				centro.add(btnReformado,BorderLayout.CENTER);
			}
		}
		catch (FileNotFoundException d)
		{
			JOptionPane.showMessageDialog( this, "El archivo indicado no se encontró.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
			LoaderPensum.logError(d);
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

		if(comando.equals("A"))
		{
			List<Curso> cursosHomologados = new ArrayList<>();
			Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
			int tamaniolista = cursosAprobados.entrySet().size();

			for(String homologado: homologados)
			{
				Curso curso = LoaderPensum.encontrarCurso(estudiante.darPensum().consultarCursos(), homologado);
				cursosHomologados.add(curso);
				curso.setSemestre(tamaniolista);

			}
			cursosAprobados.put(String.valueOf(tamaniolista), cursosHomologados);
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
