package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



public class PanelVentanaPrincipal extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 0L;
	private JButton btnEstudiante;
	private JButton btnCoordinador;	
	private JTextField txtEnunciado1;
	private JTextField txtEnunciado2;
	private JTextField titulo;
	//arriba
	private Panelimagen imagenArriba;
	//centro
	private PanelCentro centro;



	public PanelVentanaPrincipal()
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());



		imagenArriba = new Panelimagen();
		imagenArriba.setBackground(new Color (255,255,200));


		centro = new PanelCentro();

		add(centro, BorderLayout.CENTER);

		add(imagenArriba, BorderLayout.NORTH);


		btnEstudiante = new JButton("ESTUDIANTE");
		btnEstudiante.addActionListener(this);
		btnEstudiante.setActionCommand("E");

		btnCoordinador = new JButton ("COORDINADOR");
		btnCoordinador.addActionListener(this);
		btnCoordinador.setActionCommand("C");


		titulo = new JTextField("Mi Banner",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));

		txtEnunciado1 = new JTextField ("Bienvenido a Banner");
		txtEnunciado1.setEditable(false);
		txtEnunciado1.setBackground(new Color (255,255,200));
		txtEnunciado1.setForeground(Color.black);
		txtEnunciado1.setBorder(null);



		txtEnunciado2 = new JTextField ("Por favor identifiquese con un usuario: ");
		txtEnunciado2.setEditable(false);
		txtEnunciado2.setBackground(new Color (255,255,200));
		txtEnunciado2.setForeground(Color.black);
		txtEnunciado2.setBorder(null);




		centro.add(btnCoordinador, BorderLayout.CENTER);
		centro.add(btnEstudiante, BorderLayout.CENTER);
		imagenArriba.add(txtEnunciado1, BorderLayout.WEST);
		imagenArriba.add(txtEnunciado2, BorderLayout.SOUTH);
		imagenArriba.add(titulo, BorderLayout.NORTH);


	}

	public static void main(String[] args)
	{

		PanelVentanaPrincipal ventana = new  PanelVentanaPrincipal();
		ventana.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		if(comando.equals("E"))
		{
			String codigo  = JOptionPane.showInputDialog(null,"Ingrese el codigo del estudiante:  ");
			if (codigo.matches("[0-9]+") && codigo.length() > 2)
			{
				MenuDelEstudiante menu = new MenuDelEstudiante(codigo);		
				menu.setVisible(true);
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog( this, "El código debe contener solo números.", "ERROR", JOptionPane.ERROR_MESSAGE );
			}
		}
		else if(comando.equals("C"))
		{

			String codigo  = JOptionPane.showInputDialog(null,"Ingrese el codigo del coordinador:  ");
			if (codigo.matches("[0-9]+") && codigo.length() > 2)
			{
				MenuDelCoordinador menu1 = new MenuDelCoordinador(codigo);
				menu1.setVisible(true);
				this.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog( this, "El código debe contener solo números.", "ERROR", JOptionPane.ERROR_MESSAGE );
			}
		}
	}


}



/**
 * package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class extends JFrame implements ActionListener
{

private static final long serialVersionUID = L;
	//arriba
	private Panelimagen imagenArriba;
	//centro
	private PanelCentro centro;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;  
	//titulo
	private JTextField titulo;


	public ()
	{
		    setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);


			centro = new PanelCentro();
			centro.setLayout(new BorderLayout());
			centro.setLayout(new GridLayout(4,2));
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


			titulo = new JTextField("Avance de carrera",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));

			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);

	}


	 public static void main(String[] args)
		{

	      CursosVistos ventana = new  CursosVistos();
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
 */
