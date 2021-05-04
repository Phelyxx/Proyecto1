package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto1.core.pensum.LoaderPensum;
import uniandes.dpoo.proyecto1.core.pensum.Pensum;

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
        private JTextField titulo;
		private JButton btnCargarPensum;  
  
  
  public MenuDelCoordinador()
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
		
		
		btnCargarMaterias = new JButton("Cargar Materias De Estudiante");
		btnCargarMaterias.addActionListener(this);
		btnCargarMaterias.setActionCommand("C");
		
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
		
		centro.add(btnCargarMaterias,BorderLayout.CENTER);
		centro.add(btnCargarPensum,BorderLayout.CENTER);
	    add(imagenArriba, BorderLayout.NORTH);
	    abajo.add(btnReiniciar, BorderLayout.CENTER);
	    imagenArriba.add(titulo, BorderLayout.NORTH);
	  
  }  
  
  public static void main(String[] args)
	{
		
        MenuDelCoordinador ventana = new  MenuDelCoordinador();
		ventana.setVisible(true);
		
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
	else if ( comando.equals("C"))
	{
		ReporteDelEstudiante menu = new ReporteDelEstudiante();
		menu.setVisible(true);
		this.dispose();
	}
	else if(comando.equals("P"))
	{
		String nombre=JOptionPane.showInputDialog(null,"Ingrese nombre del archivo tipo pensum:  ");
		try
		{
			Pensum archivo = LoaderPensum.cargarArchivo("./data/" + nombre);
			JOptionPane.showMessageDialog( this, "Se cargó el archivo "  + "./data/" + nombre + " con la información del Pensum", "Archivo cargado", JOptionPane.DEFAULT_OPTION );
		}
		catch (FileNotFoundException d)
		{
			JOptionPane.showMessageDialog( this, "El archivo indicado no se encontró.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
		}
		catch (IOException d)
		{
			System.out.println(d.getMessage());
			JOptionPane.showMessageDialog( this, "Hubo un problema leyendo el archivo.", d.getMessage(), JOptionPane.ERROR_MESSAGE );
			
		}
		System.out.println(nombre);
	}
  }
}
