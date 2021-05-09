package uniandes.dpoo.proyecto1.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import uniandes.dpoo.proyecto1.core.estudiante.Coordinador;
import uniandes.dpoo.proyecto1.core.estudiante.Estudiante;
import uniandes.dpoo.proyecto1.core.pensum.Curso;
import uniandes.dpoo.proyecto1.verificador.RequisitosGrado;


public class AvanceDeCarreraCo extends JFrame implements ActionListener
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

	private JTextField txtRequisitos;
	private JTextField txtRequisito;
	private Estudiante estudiante;
	private Coordinador coordinador;

	public AvanceDeCarreraCo(Estudiante estudiante, Coordinador coordinador)
	{
		setSize(900,700);
		setTitle("Mi Banner");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setEstudiante(estudiante);
		setCoordinador(coordinador);
		centro = new PanelCentro();
		centro.setLayout(new BorderLayout());
		centro.setLayout(new GridLayout(16,1));
		centro.setBackground(new Color (255,255,200));
		imagenArriba = new Panelimagen();
		imagenArriba.setBackground(new Color (255,255,200));
		add(centro, BorderLayout.CENTER);
		abajo = new PanelAbajo();
		add(abajo, BorderLayout.SOUTH);
		abajo.setBackground(new Color (255,255,200));


		txtRequisitos = new JTextField ("Requisitos");
		txtRequisitos.setEditable(false);
		txtRequisitos.setBackground(new Color (255,255,230));
		txtRequisitos.setBorder(null);
		centro.add(txtRequisitos,BorderLayout.CENTER);


		Map<String, Boolean> requisitos = RequisitosGrado.verificarRequisitosGradoEstudiante(estudiante);
		if(requisitos != null)
		{
			String strReq = "";
			for (Map.Entry<String, Boolean> entry : requisitos.entrySet()) 
			{
				if(entry.getValue())
				{
					strReq = "CUMPLIDO";
				}
				else
				{
					strReq = "FALTA";
				}
				txtRequisito = new JTextField(entry.getKey() + " - " + strReq);
				centro.add(txtRequisito,BorderLayout.CENTER);
			}
		}

		btnReiniciar = new JButton ("VOLVER");
		btnReiniciar.addActionListener(this);
		btnReiniciar.setActionCommand("V");


		titulo = new JTextField("Avance de carrera",2);
		titulo.setEditable(false);
		titulo.setBorder(null);
		titulo.setBackground(new Color (255,255,230));

		abajo.add(btnReiniciar, BorderLayout.CENTER);
		add(imagenArriba, BorderLayout.NORTH);
		imagenArriba.add(titulo, BorderLayout.NORTH);

	}


	private void setEstudiante(Estudiante estudiante)
	{
		this.estudiante = estudiante;
		
	}
    private void setCoordinador(Coordinador coordinador)
{
	this.coordinador = coordinador;	
}


	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String comando = e.getActionCommand();
		// TODO Auto-generated method stub
		if(comando.equals("V"))
		{
			EstudiantePanel menu = new EstudiantePanel(estudiante, coordinador);
			menu.setVisible(true);
			this.dispose();
		} 
	}
}



