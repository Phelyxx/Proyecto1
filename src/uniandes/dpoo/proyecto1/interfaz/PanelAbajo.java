package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class PanelAbajo extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9L;
	private JPanel abajo;
	
	
	public PanelAbajo()
	{
		
		setLayout(new BorderLayout());
		setLayout(new GridLayout(1,1));
		abajo = new JPanel();
		setBackground(new Color (255,255,200));
		
		add(abajo, BorderLayout.SOUTH);
	
	}
}
