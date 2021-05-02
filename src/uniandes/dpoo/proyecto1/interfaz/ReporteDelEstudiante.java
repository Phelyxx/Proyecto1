package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReporteDelEstudiante extends JFrame implements ActionListener
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
	
	
	 private JButton estudiante1;
	 private JButton estudiante2;
	 private JButton estudiante3;
	 private JButton estudiante4;
	
	
	public ReporteDelEstudiante()
	{
		    setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			centro = new PanelCentro();
			centro.setLayout(new BorderLayout());
			centro.setLayout(new GridLayout(2,2));
			centro.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.EAST);
			imagenArriba = new Panelimagen();
			imagenArriba.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.CENTER);
			abajo = new PanelAbajo();
			add(abajo, BorderLayout.SOUTH);
			abajo.setBackground(new Color (255,255,200));
			
			
			estudiante1 = new JButton("estudiante1");
			estudiante2 = new JButton("estudiante2");
			estudiante3 = new JButton("estudiante3");
			estudiante4 =new JButton("estudiante4");
			
			
			estudiante1.addActionListener(this);
			estudiante2.addActionListener(this);
			estudiante3.addActionListener(this);
			estudiante4.addActionListener(this);
			
			estudiante1.setActionCommand("1");
			estudiante2.setActionCommand("2");
			estudiante3.setActionCommand("3");
			estudiante4.setActionCommand("4");
			
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			
			titulo = new JTextField("Reporte del estudiante",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
		
			
			
			centro.add(estudiante1,BorderLayout.CENTER);
			centro.add(estudiante2,BorderLayout.CENTER);
			centro.add(estudiante3,BorderLayout.CENTER);
			centro.add(estudiante4,BorderLayout.CENTER);
		
			
			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);
		
	}


	 public static void main(String[] args)
		{
			
	      ReporteDelEstudiante ventana = new  ReporteDelEstudiante();
	      
	      
		  ventana.setVisible(true);
			
		}


	@Override
	public void actionPerformed(ActionEvent e) 
	 {
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MenuDelCoordinador menu = new MenuDelCoordinador();
			menu.setVisible(true);
			this.dispose();
		} 
		else if(comando.equals("1"))
		{
			JOptionPane.showInputDialog(null,"Ingrese nombre del estudiante:  ");
			Estudiante menu = new Estudiante();
			menu.setVisible(true);
			this.dispose();
		}
		else if(comando.equals("2"))
		{
			JOptionPane.showInputDialog(null,"Ingrese nombre del estudiante:  ");
			Estudiante menu = new Estudiante();
			menu.setVisible(true);
			this.dispose();
		}
		else if(comando.equals("3"))
		{
			JOptionPane.showInputDialog(null,"Ingrese nombre del estudiante:  ");
			Estudiante menu = new Estudiante();
			menu.setVisible(true);
			this.dispose();
		}
		else if(comando.equals("4"))
		{
			JOptionPane.showInputDialog(null,"Ingrese nombre del estudiante:  ");
			Estudiante menu = new Estudiante();
			menu.setVisible(true);
			this.dispose();
		}
	 }


	
}
