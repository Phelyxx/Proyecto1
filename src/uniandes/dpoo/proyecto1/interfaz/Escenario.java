package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Escenario extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 6L;
	//abajo
	private PanelAbajo abajo;
	private JButton btnReiniciar;
	//arriba
	private Panelimagen imagen;
	//centro
	private PanelCentro centro;
	//titulo
	private JTextField titulo;
	
	private JTextField txtSemestre1;
	private JTextField txtSemestre2;
	private JTextField txtSemestre3;
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
	private JTextField vacio16;
	
	
	public Escenario()
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		centro = new PanelCentro();
		add(centro, BorderLayout.CENTER);
		centro.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(8,3));
		centro.setBackground(new Color (255,255,200));
		imagen = new Panelimagen();
		imagen.setBackground(new Color (255,255,200));
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));
		
		
		txtSemestre1 = new JTextField ("Semestre 1 ");
		txtSemestre1.setEditable(false);
		txtSemestre1.setBackground(new Color (255,255,230));
		txtSemestre1.setBorder(null);
		
		txtSemestre2 = new JTextField ("Semestre 2 ");
		txtSemestre2.setEditable(false);
		txtSemestre2.setBackground(new Color (255,255,230));
		txtSemestre2.setBorder(null);
		
		txtSemestre3 = new JTextField ("semestre 3");
		txtSemestre3.setEditable(false);
		txtSemestre3.setBackground(new Color (255,255,230));
		txtSemestre3.setBorder(null);
		
		vacio = new JTextField("ip",5);
		vacio1 = new JTextField(5);
		vacio2 = new JTextField("mel",5);
		vacio3= new JTextField(5);
		vacio4 = new JTextField("integral",5);
		vacio5 = new JTextField("vectorial",5);
		vacio6 = new JTextField(5);
		vacio7= new JTextField("diferencial",5);
		vacio8= new JTextField(5);
		vacio9 = new JTextField("cbu tipo colombia",5);
		vacio10 = new JTextField(5);
		vacio11= new JTextField("fisica 2",5);
		vacio12= new JTextField(5);
		vacio13= new JTextField("fisica 1",5);
		vacio14= new JTextField(5);
		vacio15= new JTextField("EDA",5);
		vacio16= new JTextField(5);
		
		titulo = new JTextField("Ver materias planeado",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));
		
		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");
		
		
		centro.add(txtSemestre1,BorderLayout.CENTER);
		centro.add(txtSemestre2,BorderLayout.CENTER);
		centro.add(txtSemestre3,BorderLayout.CENTER);
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
		centro.add(vacio16,BorderLayout.CENTER);
		

		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagen, BorderLayout.NORTH);
	    imagen.add(titulo, BorderLayout.NORTH);
		
	}
	
	public static void main(String[] args)
	{
		
      Escenario ventana = new  Escenario();
		ventana.setVisible(true);
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			MateriasFuturas menu = new MateriasFuturas();
			menu.setVisible(true);
			this.dispose();
		} 
		
	}

}
