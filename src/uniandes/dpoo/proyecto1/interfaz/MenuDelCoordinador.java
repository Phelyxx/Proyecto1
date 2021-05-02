package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
	
  }
}
