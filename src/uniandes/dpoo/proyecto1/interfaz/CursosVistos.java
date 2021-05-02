package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
	private JTextField vacio1;
	private JTextField vacio2;
	private JTextField vacio3;
	private JTextField vacio4;
	private JTextField vacio5;
	private JTextField vacio6;
	private JTextField vacio7;
	private JTextField vacio8;
	private JTextField vacio9;
	private JTextField vacio10;
	
	
	public CursosVistos()
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
			
			
			txtvariables = new JTextField ("Curso / Semestre / nota / Requisito: ");
			txtvariables.setEditable(false);
			txtvariables.setBackground(new Color (255,255,230));
			txtvariables.setBorder(null);
			
			vacio = new JTextField("ip, 2, 35",5);
			vacio1 = new JTextField("mel, 2 , 30",5);
			vacio2 = new JTextField("integral, 2, 40",5);
			vacio3 = new JTextField("vectorial, 3, 40",5);			
			vacio4= new JTextField("diferencial, 1, 40",5);
			vacio5 = new JTextField("cbu tipo colombia, 1, 46",5);
			vacio6= new JTextField("fisica 1, 1 ,30",5);
			vacio7= new JTextField("cbu ingles 6, 1,49",5);
			vacio8= new JTextField("fisica 2, 2, 39",5);
			vacio9= new JTextField("intro, 1, 50",5);
			vacio10= new JTextField("EDA, 2, 35",5);
			
			
			
			
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			
			titulo = new JTextField("Cursos vistos",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			centro.add(txtvariables,BorderLayout.CENTER);
			centro.add(vacio,BorderLayout.CENTER);
			centro.add(vacio1,BorderLayout.CENTER);
			centro.add(vacio2,BorderLayout.CENTER);
			centro.add(vacio3,BorderLayout.CENTER);
			centro.add(vacio4,BorderLayout.CENTER);
			centro.add(vacio5,BorderLayout.CENTER);
			centro.add(vacio6,BorderLayout.CENTER);
			centro.add(vacio7,BorderLayout.CENTER);
			centro.add(vacio8,BorderLayout.CENTER);
			centro.add(vacio9,BorderLayout.CENTER);
			centro.add(vacio10,BorderLayout.CENTER);
			
			
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
