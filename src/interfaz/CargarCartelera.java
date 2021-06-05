package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import modelo.core.pensum.Estudiante;
import modelo.core.pensum.Pensum;
import modelo.persistencia.LoaderPensum;

public class CargarCartelera extends JFrame implements ActionListener
{

	private static final long serialVersionUID = 12L;
	//arriba
	private Panelimagen imagenArriba;
	//centro
	private PanelCentro centro;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;  
	//titulo
	private JTextField titulo;
	private JButton cargar;
	private Estudiante estudiante;

	public CargarCartelera (Estudiante estudiante)
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setEstudiante(estudiante);

		centro = new PanelCentro();
		centro.setBackground(new Color (255,255,200));
		imagenArriba = new Panelimagen();
		imagenArriba.setBackground(new Color (255,255,200));
		add(centro, BorderLayout.CENTER);
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));

		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");

		cargar = new JButton("Cargar Cartelera");
		cargar.addActionListener(this);
		cargar.setActionCommand("C");

		titulo = new JTextField("Cartelera",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));

		centro.add(cargar,BorderLayout.CENTER);
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
		else if(comando.equals("C"))
		{
			String nombre=JOptionPane.showInputDialog(null,"Ingrese nombre del archivo tipo cartelera:  ");
			cargarPensum(nombre);
		}
	}
	public void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
	}
	public void cargarPensum(String nombre)
	{
		try
		{
			Pensum pensum = estudiante.darPensum();
			if(pensum != null)
			{
				List<String> cartelera = LoaderPensum.cargarCartelera("./data/" + nombre);
				String codeSemestre = JOptionPane.showInputDialog(null,"Ingrese el semestre de la cartelera (Ej: 2021-1):  ");
				cartelera.add(0, codeSemestre);
				pensum.setCartelera(cartelera);
				JOptionPane.showMessageDialog( this, "Se cargó el archivo "  + "./data/" + nombre + " con la información de la cartelera", "Archivo cargado", JOptionPane.DEFAULT_OPTION );
				this.dispose();
				estudiante.setPensum(pensum);
				MenuDelEstudiante menu = new MenuDelEstudiante(null);
				menu.setVisible(true);
				menu.setEstudiante(estudiante);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Primero debe cargar el pensum.", "Error", JOptionPane.ERROR_MESSAGE );
			}

		}
		catch (FileNotFoundException d)
		{
			JOptionPane.showMessageDialog( this, "El archivo indicado no se encontró.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
			LoaderPensum.logError(d);
		}
	}
}
