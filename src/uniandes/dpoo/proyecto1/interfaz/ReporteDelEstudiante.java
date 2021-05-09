package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.dpoo.proyecto1.core.estudiante.Coordinador;
import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.interfaz.ListDemo.FireListener;
import uniandes.dpoo.proyecto1.interfaz.ListDemo.HireListener;

public class ReporteDelEstudiante extends JFrame implements ListSelectionListener, ActionListener
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
	private JTextField instruccion;
	
	private JButton selectButton;
	private Coordinador coordinador;
    private static final String selectString = "Seleccionar";
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ReporteDelEstudiante(Coordinador coordinador)
	{
		    setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			centro = new PanelCentro();
			centro.setLayout(new BorderLayout());
			centro.setLayout(new GridLayout(16,1));
			centro.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.EAST);
			imagenArriba = new Panelimagen();
			imagenArriba.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.CENTER);
			abajo = new PanelAbajo();
			add(abajo, BorderLayout.SOUTH);
			abajo.setBackground(new Color (255,255,200));
			
			setCoordinador(coordinador);
			listaEstudiantes = new DefaultListModel<String>();
			List<Estudiante> lista_estudiantes = coordinador.darEstudiantes();
			for(Estudiante estudiante: lista_estudiantes)
			{
				String codigo = estudiante.darCodigo();
				listaEstudiantes.addElement(codigo);
			}
	        list = new JList(listaEstudiantes);
	        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	        list.setSelectedIndex(0);
	        list.addListSelectionListener(this);
	        list.setVisibleRowCount(5);
	        JScrollPane listScrollPane = new JScrollPane(list);
	        
	        selectButton = new JButton(selectString);
	        selectButton.setActionCommand(selectString);
	        selectButton.addActionListener(this);
	        selectButton.setActionCommand("S");

	        
	        String name = listaEstudiantes.getElementAt(
	                              list.getSelectedIndex()).toString();
	        
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);	
			btnReiniciar.setActionCommand("V");
			
			titulo = new JTextField("Reporte del estudiante",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			instruccion = new JTextField("Seleccione el código del estudiante:",2);
			instruccion.setEditable(false);
			instruccion.setBackground(new Color (255,255,230));
			instruccion.setBorder(null);
		    centro.add(instruccion, BorderLayout.CENTER);
	
			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);
		    centro.add(listScrollPane, BorderLayout.CENTER);
		    centro.add(selectButton, BorderLayout.CENTER);
		
	}

	    private void setCoordinador(Coordinador coordinador)
	{
		this.coordinador = coordinador;	
	}

		private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("ListDemo");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Create and set up the content pane.
	        JComponent newContentPane = new ListDemo();
	        newContentPane.setOpaque(true); //content panes must be opaque
	        frame.setContentPane(newContentPane);
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
	 
	    public static void main(String[] args) {
	        //Schedule a job for the event-dispatching thread:
	        //creating and showing this application's GUI.
	        javax.swing.SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI();
	            }
	        });
	    }


	@Override
	public void actionPerformed(ActionEvent e) 
	 {

		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MenuDelCoordinador menu = new MenuDelCoordinador(null);
			menu.setCoordinador(coordinador);
			menu.setVisible(true);
			this.dispose();
		} 
		else if(comando.equals("S"))
		{
	        int index = list.getSelectedIndex();
			List<Estudiante> lista_estudiantes = coordinador.darEstudiantes();
			for(Estudiante estudiante: lista_estudiantes)
			{
				String codigo = estudiante.darCodigo();
				if(codigo.equals(listaEstudiantes.getElementAt(index)))
				{
					EstudiantePanel menu = new EstudiantePanel(estudiante, coordinador);
					menu.setVisible(true);
					this.dispose();
				}
			
			}
		}
		
	 }

  

	public void valueChanged(ListSelectionEvent e)
	{
        if (e.getValueIsAdjusting() == false) {
        	 
            if (list.getSelectedIndex() == -1) {
            //No selection, disable fire button.
            selectButton.setEnabled(false);
 
            } else {
            selectButton.setEnabled(true);
            //Selection, enable the fire button.
            }
        }
	}
	



	
}
