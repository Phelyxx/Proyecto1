package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.core.pensum.Coordinador;
import modelo.core.pensum.Estudiante;
import modelo.core.pensum.Pensum;
import modelo.persistencia.LoaderPensum;

public class MenuDelCoordinador extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 3L;
	//arriba
	private Panelimagen imagenArriba;
	//centro
	private PanelCentro centro;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;
	private JButton btnCargarMaterias;
	private JButton btnSeleccionarEstudiante;
	private JTextField titulo;
	private JButton btnCargarPensum;  
	private Coordinador coordinador;
	private Pensum pensum;


	public MenuDelCoordinador(String codigo)
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setBackground(new Color (255,255,200));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		imagenArriba = new Panelimagen();
		imagenArriba.setBackground(new Color (255,255,200));



		centro = new PanelCentro();
		add(centro, BorderLayout.CENTER);

		List<Estudiante> estudiantes = new ArrayList<Estudiante>();
		coordinador = new Coordinador(estudiantes, codigo);

		btnCargarMaterias = new JButton("Cargar Materias De Estudiante");
		btnCargarMaterias.addActionListener(this);
		btnCargarMaterias.setActionCommand("C");

		btnSeleccionarEstudiante = new JButton("Seleccionar estudiante");
		btnSeleccionarEstudiante.addActionListener(this);
		btnSeleccionarEstudiante.setActionCommand("S");

		btnCargarPensum = new JButton("Cargar Pensum");
		btnCargarPensum.addActionListener(this);
		btnCargarPensum.setActionCommand("P");


		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));

		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");

		titulo = new JTextField("Menu Coordinador",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));

		centro.add(btnCargarPensum,BorderLayout.CENTER);
		centro.add(btnCargarMaterias,BorderLayout.CENTER);
		centro.add(btnSeleccionarEstudiante, BorderLayout.CENTER);
		add(imagenArriba, BorderLayout.NORTH);
		abajo.add(btnReiniciar, BorderLayout.CENTER);
		imagenArriba.add(titulo, BorderLayout.NORTH);

	}  


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			PanelVentanaPrincipal menu = new PanelVentanaPrincipal();
			menu.setVisible(true);
			this.dispose();
		} 
		else if ( comando.equals("S"))
		{
			List<Estudiante> lista_estudiantes = coordinador.darEstudiantes();
			if(lista_estudiantes.isEmpty())
			{
				JOptionPane.showMessageDialog( this, "No hay estudiantes cargados.", "", JOptionPane.ERROR_MESSAGE );
			}
			else
			{
				ReporteDelEstudiante menu = new ReporteDelEstudiante(coordinador);
				menu.setVisible(true);
				this.dispose();	
			}
		}
		else if ( comando.equals("C"))
		{
			String nombre=JOptionPane.showInputDialog(null,"Ingrese el archivo con la informacion del estudiante:  ");
			try
			{
				coordinador.cargarMateriasEstudiantes("./data/" + nombre);
				JOptionPane.showMessageDialog( this, "Se cargó el archivo "  + "./data/" + nombre + " con la información del estudiante", "Archivo cargado", JOptionPane.DEFAULT_OPTION );
			}
			catch (FileNotFoundException d)
			{
				JOptionPane.showMessageDialog( this, "El archivo indicado no se encontró.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
				LoaderPensum.logError(d);
			}
			catch (IOException d)
			{
				JOptionPane.showMessageDialog( this, "Hubo un problema leyendo el archivo.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
				LoaderPensum.logError(d);

			}	
		}
		else if(comando.equals("P"))
		{
			try
			{
				String nombre=JOptionPane.showInputDialog(null,"Ingrese nombre del archivo tipo pensum:  ");
				pensum = LoaderPensum.cargarArchivo("./data/" + nombre);
				coordinador.setPensum(pensum);
				JOptionPane.showMessageDialog( this, "Se cargó el archivo "  + "./data/" + nombre + " con la información del Pensum", "Archivo cargado", JOptionPane.DEFAULT_OPTION );			}
			catch (FileNotFoundException d)
			{
				JOptionPane.showMessageDialog( this, "El archivo indicado no se encontró.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
				LoaderPensum.logError(d);
			}
			catch (IOException d)
			{
				JOptionPane.showMessageDialog( this, "Hubo un problema leyendo el archivo.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
				LoaderPensum.logError(d);

			}	
		}
	}

	public void setCoordinador(Coordinador coordinador)
	{
		this.coordinador = coordinador;
		
	}

}
