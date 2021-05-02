package uniandes.dpoo.proyecto1.interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class AvanceDeMateriasCo extends JFrame implements ActionListener
{
	   /**
	 * 
	 */
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
		
		private JTextField txtRequisitosCumplidos;
		private JTextField txtRequisitosPorCumplir;
		private JTextField vacio4;
		private JTextField vacio;
		private JTextField vacio1;
		private JTextField vacio2;
		private JTextField vacio3;
		private JTextField vacio10;
		private JTextField vacio9;
		private JTextField vacio8;
		private JTextField vacio7;
		private JTextField vacio6;
		private JTextField vacio5;
		private JTextField vacio11;
		private JTextField vacio12;
		private JTextField vacio13;
		private JTextField vacio14;
		private JTextField vacio15;
		
		public AvanceDeMateriasCo()
		{
			    setSize(900,700);
				setTitle("Mi Banner");
				setResizable(false);
				setDefaultCloseOperation(EXIT_ON_CLOSE);
				
				
				centro = new PanelCentro();
				centro.setLayout(new BorderLayout());
				centro.setLayout(new GridLayout(12,2));
				centro.setBackground(new Color (255,255,200));
				imagenArriba = new Panelimagen();
				imagenArriba.setBackground(new Color (255,255,200));
				add(centro, BorderLayout.CENTER);
				abajo = new PanelAbajo();
				add(abajo, BorderLayout.SOUTH);
				abajo.setBackground(new Color (255,255,200));
				
				
				txtRequisitosCumplidos = new JTextField ("Requisitos cumplidos ");
				txtRequisitosCumplidos.setEditable(false);
				txtRequisitosCumplidos.setBackground(new Color (255,255,230));
				txtRequisitosCumplidos.setBorder(null);
				
				txtRequisitosPorCumplir = new JTextField ("Requisitos por cumplir");
				txtRequisitosPorCumplir.setEditable(false);
				txtRequisitosPorCumplir.setBackground(new Color (255,255,230));
				txtRequisitosPorCumplir.setBorder(null);
				
				vacio = new JTextField(5);
				vacio1 = new JTextField(5);
				vacio2 = new JTextField(5);
				vacio3= new JTextField(5);
				vacio4 = new JTextField(5);
				vacio5 = new JTextField(5);
				vacio6 = new JTextField(5);
				vacio7= new JTextField(5);
				vacio8= new JTextField(5);
				vacio9 = new JTextField(5);
				vacio10 = new JTextField(5);
				vacio11= new JTextField(5);
				vacio12= new JTextField(5);
				vacio13= new JTextField(5);
				vacio14= new JTextField(5);
				vacio15= new JTextField(5);
				
				
				
				btnReiniciar = new JButton ("VOLVER");
				btnReiniciar.addActionListener(this);
				btnReiniciar.setActionCommand("V");
				
				
				titulo = new JTextField("Avance de carrera",2);
				titulo.setEditable(false);
				titulo.setBorder(null);
				titulo.setBackground(new Color (255,255,230));
				
				centro.add(txtRequisitosCumplidos,BorderLayout.CENTER);
				centro.add(txtRequisitosPorCumplir,BorderLayout.CENTER);
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
				centro.add(vacio11,BorderLayout.CENTER);
				centro.add(vacio12,BorderLayout.CENTER);
				centro.add(vacio13,BorderLayout.CENTER);
				centro.add(vacio14,BorderLayout.CENTER);
				centro.add(vacio15,BorderLayout.CENTER);
				
				
				
				abajo.add(btnReiniciar, BorderLayout.CENTER);
			    add(imagenArriba, BorderLayout.NORTH);
			    imagenArriba.add(titulo, BorderLayout.NORTH);
			
		}


		 public static void main(String[] args)
			{
				
		      AvanceDeMateriasCo ventana = new  AvanceDeMateriasCo();
				ventana.setVisible(true);
				
			}


		@Override
		public void actionPerformed(ActionEvent e) 
		 {
			String comando = e.getActionCommand();
			// TODO Auto-generated method stub
			if(comando.equals("V"))
			{
				Estudiante menu = new Estudiante();
				menu.setVisible(true);
				this.dispose();
			} 
		 }
}
