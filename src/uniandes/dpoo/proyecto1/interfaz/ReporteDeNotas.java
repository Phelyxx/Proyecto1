package uniandes.dpoo.proyecto1.interfaz;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ReporteDeNotas extends JFrame implements ActionListener
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
	
	
	private JTextField txtmaterias;
	private JTextField txtnotas;
	private JTextField txtmaterias1;
	private JTextField txtnotas1;
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
	private JTextField vacio17;
	private JTextField vacio18;
	private JTextField vacio19;
	
	private JTextField txtpromedio;
	private JTextField txtsegunCreditos;
	private JTextField txtacomulado;
	private JTextField txtestado;
	
	public ReporteDeNotas()
	{
		    setSize(900,700);
			setTitle("Mi Banner");
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			
			centro = new PanelCentro();
			centro.setLayout(new BorderLayout());
			centro.setLayout(new GridLayout(8,6));
			centro.setBackground(new Color (255,255,200));
			imagenArriba = new Panelimagen();
			imagenArriba.setBackground(new Color (255,255,200));
			add(centro, BorderLayout.CENTER);
			abajo = new PanelAbajo();
			add(abajo, BorderLayout.SOUTH);
			abajo.setBackground(new Color (255,255,200));
			
			txtmaterias = new JTextField ("Materias semestre 1 ");
			txtmaterias.setEditable(false);
			txtmaterias.setBackground(new Color (255,255,230));
			txtmaterias.setBorder(null);
			
			txtnotas = new JTextField ("Notas:  ");
			txtnotas.setEditable(false);
			txtnotas.setBackground(new Color (255,255,230));
			txtnotas.setBorder(null);
			
			txtnotas1 = new JTextField ("Notas: ");
			txtnotas1.setEditable(false);
			txtnotas1.setBackground(new Color (255,255,230));
			txtnotas1.setBorder(null);
			
			txtmaterias1 = new JTextField ("Materias semestre 2 ");
			txtmaterias1.setEditable(false);
			txtmaterias1.setBackground(new Color (255,255,230));
			txtmaterias1.setBorder(null);
			
			
			txtpromedio = new JTextField ("Promedio semestre 1: 38,2");
			txtpromedio.setEditable(false);
			txtpromedio.setBackground(new Color (255,255,230));
			txtpromedio.setBorder(null);
			
			txtsegunCreditos = new JTextField ("Semestre segun creditos: 2");
			txtsegunCreditos.setEditable(false);
			txtsegunCreditos.setBackground(new Color (255,255,230));
			txtsegunCreditos.setBorder(null);
			
			txtacomulado = new JTextField ("promedio acumulado: 38,8");
			txtacomulado.setEditable(false);
			txtacomulado.setBackground(new Color (255,255,230));
			txtacomulado.setBorder(null);
			
			txtestado = new JTextField ("Estado del estudiante: Activo");
			txtestado.setEditable(false);
			txtestado.setBackground(new Color (255,255,230));
			txtestado.setBorder(null);
			
			
			vacio = new JTextField("ip",5);
			vacio1 = new JTextField("35",5);
			vacio2 = new JTextField("mel",5);
			vacio3= new JTextField("30",5);
			vacio4 = new JTextField("ingles",5);
			vacio5 = new JTextField("41",5);
			vacio6 = new JTextField("lineal",5);
			vacio7= new JTextField("40",5);
			vacio8= new JTextField("diferencial",5);
			vacio9 = new JTextField("41",5);
			vacio10 = new JTextField("cbu tipo colombia",5);
			vacio11= new JTextField("49",5);
			vacio12= new JTextField("fisica 1",5);
			vacio13= new JTextField("39",5);
			vacio14= new JTextField("fisica 2",5);
			vacio15= new JTextField("40",5);
			vacio16= new JTextField("escritura 1",5);
			vacio17= new JTextField("35",5);
			vacio18= new JTextField("escritura 2",5);
			vacio19= new JTextField("50",5);
		
			
			
			
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			
			titulo = new JTextField("Reporte De Notas",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			centro.add(txtmaterias,BorderLayout.CENTER);
			centro.add(txtnotas,BorderLayout.CENTER);
			centro.add(txtmaterias1,BorderLayout.CENTER);
			centro.add(txtnotas1,BorderLayout.CENTER);
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
			centro.add(vacio17,BorderLayout.CENTER);
			centro.add(vacio18,BorderLayout.CENTER);
			centro.add(vacio19,BorderLayout.CENTER);
			
			centro.add(txtpromedio, BorderLayout.CENTER);
			centro.add(txtsegunCreditos, BorderLayout.CENTER);
			centro.add(txtacomulado, BorderLayout.CENTER);
			centro.add(txtestado, BorderLayout.CENTER);
			
			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);
	 
	}


	 public static void main(String[] args)
		{
			
	      ReporteDeNotas ventana = new  ReporteDeNotas();
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
