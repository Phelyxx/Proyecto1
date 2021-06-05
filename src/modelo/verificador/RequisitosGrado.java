package modelo.verificador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import modelo.core.pensum.Curso;
import modelo.core.pensum.Estudiante;
import modelo.reporteador.CalculadoraReportes;

public class RequisitosGrado
{
	public static Map<String, Boolean> darRequisitosGradoEstudiante(Estudiante estudiante)
	{
		Map<String, Boolean> requisitos = new HashMap<String, Boolean>();
		requisitos.put("TOTAL REQUERIDO DE CREDITOS", false);
		requisitos.put("REQUISITO DE ESPAÑOL", false);
		requisitos.put("CONSTITUCIÓN Y DEMOCRACIA", false);
		requisitos.put("REQUISITO IDIOMA EXTRANJERO", false);
		requisitos.put("CUMPLIMIENTO CURSO ÉPSILON", false);
		requisitos.put("CUMPLIMIENTO CURSOS TIPO E", false);
		requisitos.put("CURSO CON COMPONENTE EN INGLES", false);
		requisitos.put("MATEMÁTICAS Y CIENC. BÁSICAS", false);
		requisitos.put("FUNDAMENTACIÓN EN ISIS", false);
		requisitos.put("PROFUNDIZACIÓN", false);
		requisitos.put("FUNDAMENTOS GRALES EN INGEN.", false);
		requisitos.put("PROYECTOS", false);
		requisitos.put("NUEVO REGLAMENTO CBU", false);
		requisitos.put("CLES CON 6 CREDITOS", false);
		requisitos.put("CUMPLIMIENTO SABER PRO ISIS", false);
		return requisitos;
	}

	public static Map<String, Boolean> verificarRequisitosGradoEstudiante(Estudiante estudiante)
	{
		Map<String, Boolean> estadoRequisitosPensum = estudiante.darEstadoRequisitos();
		Map<String, List<Curso>> cursosAprobados = estudiante.darCursosAprobados();
		Map<String, Double> creditosSemestre = CalculadoraReportes.calcularCreditosPorSemestre(estudiante);
		int total_creditos = 0;
		for(Entry<String, Double> entry : creditosSemestre.entrySet())
		{
			total_creditos += entry.getValue();
		}
		if(total_creditos >= 134)
		{
			estadoRequisitosPensum.replace("TOTAL REQUERIDO DE CREDITOS", true);
		}
		int conteoReqTipoE = 0;
		int conteoReqElePro = 0;
		int conteoCBU = 0;
		int conteoCLE = 0;
		List<String> codigoCursos = new ArrayList<String>();
		boolean electivaCiencias = false;
		boolean electivaIngenieria = false;
		boolean cbca = false;
		boolean cbpc = false;
		boolean cbco = false;
		for (Map.Entry<String, List<Curso>> entry : cursosAprobados.entrySet()) 
		{
			List<Curso> cursos = entry.getValue();
			for(Curso curso: cursos)
			{
				String codigo = curso.darCodigo();
				codigoCursos.add(codigo);
				if(curso.esEpsilon() == true);
				{
					estadoRequisitosPensum.replace("CUMPLIMIENTO CURSO ÉPSILON", true);
				}
				if(curso.esTipoE() == true);
				{
					conteoReqTipoE += 1;
				}
				if(curso.esTipoI() == true);
				{
					estadoRequisitosPensum.replace("CURSO CON COMPONENTE EN INGLES", true);
				}
				if(curso.EsElectivaProfesional() == true)
				{
					conteoReqElePro += curso.darCreditos();
				}
				if(curso.darEsElectivaIngenieria() == true)
				{
					electivaIngenieria = true;
				}
				String caracteresCod = codigo.substring(0,6);
				if(caracteresCod.equals("MATE-1") || caracteresCod.equals("FISI-1")  || caracteresCod.equals("QUIM-1") 
						|| caracteresCod.equals("MBIO-1") && curso.darSemestre() == 6)  
				{
					electivaCiencias = true;
				}
				if(curso.esCBU() == true)
				{
					conteoCBU += 1;
				}
				String caracteresCBU = codigo.substring(0,4);
				if(caracteresCBU.equals("CBCA"))
				{
					cbca = true;
				}
				if(caracteresCBU.equals("CBPC"))
				{
					cbpc = true;
				}
				if(caracteresCBU.equals("CBCO"))
				{
					cbco = true;
				}
				if(!curso.esObligatorio() && !curso.esCBU())
				{
					conteoCLE += curso.darCreditos();
				}

			}
		}
			int conteoReqEspaniol = 0;
			if(codigoCursos.contains("LENG-1511") || codigoCursos.contains("LENG-1512") || codigoCursos.contains("LITE-1621") ||
					codigoCursos.contains("LITE-162") )
			{
				conteoReqEspaniol += 1;
			}
			if(conteoReqEspaniol >= 2)
			{
				estadoRequisitosPensum.replace("REQUISITO DE ESPAÑOL", true);
			}
			if(codigoCursos.contains("DERE-1300"))
			{
				estadoRequisitosPensum.replace("CONSTITUCIÓN Y DEMOCRACIA", true);
			}
			if(codigoCursos.contains("LENG-3999") || codigoCursos.contains("LENG-1161") || codigoCursos.contains("LENG1162"))
			{
				estadoRequisitosPensum.replace("REQUISITO IDIOMA EXTRANJERO", true);
			}
			if(codigoCursos.contains("MATE-1203") && codigoCursos.contains("MATE-1214") && codigoCursos.contains("FISI-1018") &&
					codigoCursos.contains("FISI-1019") && codigoCursos.contains("MATE-1105") && codigoCursos.contains("MATE-1207") &&
					codigoCursos.contains("FISI-1028") && codigoCursos.contains("FISI-1029") && codigoCursos.contains("MBIO-1100") &&
					codigoCursos.contains("QUIM-1103") && electivaCiencias == true)
			{
				estadoRequisitosPensum.replace("MATEMÁTICAS Y CIENC. BÁSICAS", true);
			}
			if(codigoCursos.contains("ISIS-1221") && codigoCursos.contains("ISIS-1225") && codigoCursos.contains("ISIS-1104") &&
					codigoCursos.contains("ISIS-1105") && codigoCursos.contains("ISIS-1106") && codigoCursos.contains("ISIS-1304") &&
					codigoCursos.contains("ISIS-1404"))
			{
				estadoRequisitosPensum.replace("FUNDAMENTACIÓN EN ISIS", true);
			}
			if(codigoCursos.contains("ISIS-2304") && codigoCursos.contains("ISIS-2203") && codigoCursos.contains("ISIS-3204") &&
					codigoCursos.contains("ISIS-2007") && codigoCursos.contains("ISIS-2403") && codigoCursos.contains("ISIS-2503") &&
					codigoCursos.contains("ISIS-3302") && (codigoCursos.contains("ISIS-3425") || codigoCursos.contains("ISIS-3710")) &&
					codigoCursos.contains("ISIS-3301")  && codigoCursos.contains("ISIS-3510") && conteoReqElePro >= 9)
			{
				estadoRequisitosPensum.replace("PROFUNDIZACIÓN", true);
			}
			if(codigoCursos.contains("IIND-2401") && codigoCursos.contains("IIND-2106") && electivaIngenieria == true)
			{
				estadoRequisitosPensum.replace("FUNDAMENTOS GRALES EN INGEN.", true);
			}
			if(codigoCursos.contains("ISIS-1001") && codigoCursos.contains("ISIS-2007") && codigoCursos.contains("ISIS-3007"))
			{
				estadoRequisitosPensum.replace("PROYECTOS", true);
			}
			if(conteoCBU >= 7 && cbca == true && cbco == true && cbpc == true && codigoCursos.contains("CBCC-1177"))
			{
				estadoRequisitosPensum.replace("NUEVO REGLAMENTO CBU", true);
			}
			if(conteoCLE >= 6)
			{
				estadoRequisitosPensum.replace("CLES CON 6 CREDITOS", true);
			}
			if(codigoCursos.contains("SABER-PRO"))
			{
				estadoRequisitosPensum.replace("CUMPLIMIENTO SABER PRO ISIS", true);
			}
			if(conteoReqTipoE >= 2)
			{
				estadoRequisitosPensum.replace("CUMPLIMIENTO CURSOS TIPO E", true);
			}
		return estadoRequisitosPensum;
	}

}
