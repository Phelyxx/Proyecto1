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
import uniandes.dpoo.proyecto1.reporteador.CalculadoraReportes;

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
	
	
	private JTextField vacio;
	
	private JTextField txtpromedio;
	private JTextField txtsegunCreditos;
	private JTextField txtacomulado;
	private JTextField txtestado;
	private Estudiante estudiante;
	
	public ReporteDeNotas(Estudiante estudiante)
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
			setEstudiante(estudiante);
			
			Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
			
			if(cursosAprobados != null)
			{
				for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
				{
					List<Curso> cursos = entry.getValue();
					for(Curso curso: cursos)
					{
						String codigo = curso.darCodigo();
						int semestre = curso.darSemestre();
						String nota = curso.darNota();
						Integer creditos = curso.darCreditos();
						String cbu = "";
						String tipoI= "";
						String epsilon= "";
						String tipoE = "";
						if(curso.esCBU())
						{
							cbu = "CBU";
						}
						if(curso.esTipoI())
						{
							tipoI = "Tipo I";
						}
						if(curso.esTipoE())
						{
							tipoE = "Tipo E";
						}
						if(curso.esEpsilon())
						{
							epsilon = "Epsilon";
						}
						vacio = new JTextField(codigo + " Semestre " + String.valueOf(semestre) + " Nota " + nota +
								" Creditos " + creditos.toString() + " " + cbu +  " " + tipoI + "  " + epsilon + "  " + tipoE, 5);
						centro.add(vacio,BorderLayout.CENTER);

					}
					Float promedio = CalculadoraReportes.calcularPromedioSemestre(estudiante, entry.getKey());
					txtpromedio = new JTextField ("Promedio semestre " + entry.getKey() + ": " + promedio.toString());
					txtpromedio.setEditable(false);
					txtpromedio.setBackground(new Color (255,255,230));
					txtpromedio.setBorder(null);
					centro.add(txtpromedio,BorderLayout.CENTER);
				} 
				Map<String, Integer> creditos_semestre = CalculadoraReportes.calcularCreditosPorSemestre(estudiante);
				int sumacreditos = 0;
				for(Map.Entry<String, Integer> entry : creditos_semestre.entrySet()) 
				{
					System.out.println(entry.getValue());
					sumacreditos += entry.getValue();
				}
				Float semestre = (float) (((sumacreditos / 138) * 10) + 1);
				Integer semestreint = Math.round(semestre);
				txtsegunCreditos = new JTextField ("Semestre según creditos: " + semestreint.toString());
				txtsegunCreditos.setEditable(false);
				txtsegunCreditos.setBackground(new Color (255,255,230));
				txtsegunCreditos.setBorder(null);
				
				Float pga = CalculadoraReportes.calcularPGA(estudiante);
				txtacomulado = new JTextField ("Promedio General Acumulado: " + pga.toString());
				txtacomulado.setEditable(false);
				txtacomulado.setBackground(new Color (255,255,230));
				txtacomulado.setBorder(null);
			}
			
			txtestado = new JTextField ("Estado del estudiante: Activo");
			txtestado.setEditable(false);
			txtestado.setBackground(new Color (255,255,230));
			txtestado.setBorder(null);
			btnReiniciar = new JButton ("VOLVER");
			btnReiniciar.addActionListener(this);
			btnReiniciar.setActionCommand("V");
			
			
			titulo = new JTextField("Reporte De Notas",2);
			titulo.setEditable(false);
			titulo.setBorder(null);
			titulo.setBackground(new Color (255,255,230));
			
			centro.add(txtsegunCreditos, BorderLayout.CENTER);
			centro.add(txtacomulado, BorderLayout.CENTER);
			centro.add(txtestado, BorderLayout.CENTER);
			
			abajo.add(btnReiniciar, BorderLayout.CENTER);
		    add(imagenArriba, BorderLayout.NORTH);
		    imagenArriba.add(titulo, BorderLayout.NORTH);
	 
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
			MenuDelEstudiante menu = new MenuDelEstudiante(null);
			menu.setVisible(true);
			menu.setEstudiante(estudiante);
			this.dispose();
		} 
	 }


	
}
