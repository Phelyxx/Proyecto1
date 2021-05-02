package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class MateriasFuturas extends JFrame implements ActionListener
{
	    /**
	 * 
	 */
	private static final long serialVersionUID = 5L;
		//abajo
		private PanelAbajo abajo;
		private JButton btnReiniciar;
		//arriba
		private Panelimagen imagen;
		//centro
		private PanelCentro centro;
		//titulo
		private JTextField titulo;
		
		private JTextField nombre;
		private JTextField semestre;
		private JTextField vacio;
		private JTextField vacio1;
		private JButton btnEscenario;
		
		
		public MateriasFuturas() 
		{
			setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			centro = new PanelCentro();
			add(centro, BorderLayout.CENTER);
			centro.setBackground(new Color (255,255,200));
			imagen = new Panelimagen();
			imagen.setBackground(new Color (255,255,200));
			abajo = new PanelAbajo();
			add(abajo, BorderLayout.SOUTH);
			abajo.setBackground(new Color (255,255,200));
			
			nombre = new JTextField ("Nombre del curso que desea ver: ");
			nombre.setEditable(false);
			nombre.setBackground(new Color (255,255,230));
			nombre.setBorder(null);
			
			semestre = new JTextField ("En que semestre desea ver curso: ");
			semestre.setEditable(false);
			semestre.setBackground(new Color (255,255,230));
			semestre.setBorder(null);
			
			vacio = new JTextField(5);
			vacio1 = new JTextField(5);
			
			
			titulo = new JTextField("Registro De Cursos Futuros",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			btnEscenario = new JButton ("Ver escenario");
			btnEscenario.addActionListener(this);
			btnEscenario.setActionCommand("E");
			
			
			centro.add(nombre,BorderLayout.CENTER);
			centro.add(vacio,BorderLayout.CENTER);
			centro.add(semestre,BorderLayout.CENTER);
			centro.add(vacio1,BorderLayout.CENTER);
			centro.add(btnEscenario,BorderLayout.CENTER);
			
			
			
			abajo.add(btnReiniciar, BorderLayout.CENTER);
			add(imagen, BorderLayout.NORTH);
		    imagen.add(titulo, BorderLayout.NORTH);
			
		}
	
	
		public static void main(String[] args)
		{
			
	      MateriasFuturas ventana = new  MateriasFuturas();
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
			else if (comando.equals("E"))
			{
				Escenario menu = new Escenario();
				menu.setVisible(true);
				this.dispose();
			} 
		}
	
}
