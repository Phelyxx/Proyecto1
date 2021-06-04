package interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panelimagen extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblimagen;
	public Panelimagen() 
	{
		setLayout(new BorderLayout());
		setLayout(new GridLayout(1,2));
		lblimagen = new JLabel();
		Image imagen = new ImageIcon("./data/logo.png").getImage().getScaledInstance(240, 130, 3);
		lblimagen.setIcon(new ImageIcon(imagen));
		
		
		setLayout(new BorderLayout());
		add(lblimagen, BorderLayout.EAST);
		
	}
}
