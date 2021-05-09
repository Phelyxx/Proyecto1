package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto1.core.estudiante.Coordinador;
import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;

public class EstudiantePanel extends JFrame implements ActionListener
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
	
	 private JButton reporte;
	 private JButton escenarios;
	 private JButton avancePensum;
	 private Estudiante estudiante;
	 private Coordinador coordinador;
	
	public EstudiantePanel(Estudiante estudiante, Coordinador coordinador)
	{
		    setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			centro = new PanelCentro();
			centro.setBackground(new Color (255,255,200));
			imagenArriba = new Panelimagen();
			imagenArriba.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.CENTER);
			abajo = new PanelAbajo();
			add(abajo, BorderLayout.SOUTH);
			abajo.setBackground(new Color (255,255,200));
			setEstudiante(estudiante);
			setCoordinador(coordinador);
			
			reporte = new JButton("Reporte");
			escenarios = new JButton("Escenarios");
			avancePensum = new JButton("Avance de pensum");
			
			reporte.setActionCommand("1");
			escenarios.setActionCommand("2");
			avancePensum.setActionCommand("3");
			
			reporte.addActionListener(this);
			escenarios.addActionListener(this);
			avancePensum.addActionListener(this);
			
			
			
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			
			titulo = new JTextField("Estudiante reportado",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			centro.add(reporte,BorderLayout.CENTER);
			centro.add(escenarios,BorderLayout.CENTER);
			centro.add(avancePensum,BorderLayout.CENTER);
			
			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);
		
	}


	 private void setCoordinador(Coordinador coordinador)
	{
		 this.coordinador = coordinador;
	}


	private void setEstudiante(Estudiante estudiante)
	{
		 this.estudiante = estudiante;
	}



	@Override
	public void actionPerformed(ActionEvent e) 
	 {
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			ReporteDelEstudiante menu = new ReporteDelEstudiante(coordinador);
			menu.setVisible(true);
			this.dispose();
		} 
		else if(comando.equals("1"))
		{
			ReporteDeNotasCo menu = new ReporteDeNotasCo(estudiante, coordinador);
			menu.setVisible(true);
			this.dispose();
		}
		else if(comando.equals("2"))
		{
		    MateriasFuturasCo menu = new MateriasFuturasCo(estudiante, coordinador);
			menu.setVisible(true);
			this.dispose();
		}
		else if(comando.equals("3"))
		{
			AvanceDeCarreraCo menu = new AvanceDeCarreraCo(estudiante, coordinador);
			menu.setVisible(true);
			this.dispose();
		}
			
	 }


	
}
