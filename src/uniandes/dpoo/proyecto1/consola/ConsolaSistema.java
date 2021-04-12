package uniandes.dpoo.proyecto1.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uniandes.dpoo.proyecto1.procesamiento.InformacionPensum;

public class ConsolaSistema
{
	
  private InformacionPensum pensum;
  
  
  public void ejecutarAplicacion()
  {
	  System.out.println("sistema para la administración y seguimiento del pénsum de\r\n"
	  		+ "un estudiante.\n");

		boolean continuar = true;
		while (continuar)
		{
			try
			{
				mostrarMenu();
				int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
				if (opcion_seleccionada == 1)
					ejecutarCargarPensum();
				else if (opcion_seleccionada == 2 && pensum != null)
					ejecutarRegistrarCursoYRequisitos();
				else if (opcion_seleccionada == 3 && pensum != null)
					ejecutarPlaneacionDeCurso();
				else if (opcion_seleccionada == 4 && pensum != null)
					ejecutarGenerarReporteDeNotas();
				else if (opcion_seleccionada == 5 && pensum != null)
					ejecutarCandidatoAGrado();
				else if (opcion_seleccionada == 6 && pensum != null)
					ejecutarCompletarNotasCoordinador();
				else if (opcion_seleccionada == 7 && pensum != null)
					ejecutarSeleccionarEstudianteCoordinador();
			
				else if (opcion_seleccionada == 8)
				{
					System.out.println("Saliendo de la aplicacion");
					continuar = false;
				}
				else if (pensum == null)
				{
					System.out.println("Para poder ejecutar esta opcion primero debe cargar un archivo de pensum.");
				}
				else
				{
					System.out.println("Por favor seleccione una opción valida.");
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los numeros de las opciones.");
			}
		}
	}
  
  
       private void ejecutarRegistrarCursoYRequisitos()
{
	// TODO Auto-generated method stub
	
}


	public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
{
}


	public void mostrarMenu()
	{
		System.out.println("\nOpciones de la aplicación");
		System.out.println("1. Cargar un archivo de pensum");
		System.out.println("2. Registrar cursos y requisitos del estudiante");
		System.out.println("3. Planear los cursos que se van a ver en los siguientes semestres");
		System.out.println("4. Generar reporte de notas del estudiante");
		System.out.println("5. Verificar si un estudiantes es candidato a grado");
		System.out.println("6. Completar a mano las notas de un estudiante(coordinador)");
		System.out.println("7. Seleccionar estudiante para hacer planeacion, reporte, etc...");
		System.out.println("8. Salir de la aplicación\n");
	}
	
       
       private void ejecutarRegistarCursoYRequisitos()
       {
    	   
       }
       
       
       private void ejecutarPlaneacionDeCurso()
       {
    	   //System.out.println("\n" + Loder.+"\n")
    	   System.out.println("\n" + "por favor ingrese las materias que desea ver"+ "\n" );
    	   
       }
    	   
       
       
       
       private void ejecutarGenerarReporteDeNotas()
       {
    	   
       }
       
       
       
       private void ejecutarCandidatoAGrado()
       {
    	   
       }
       
       
       private void ejecutarCompletarNotasCoordinador()
       {
    	   
       }
       
       private void ejecutarSeleccionarEstudianteCoordinador()
       {
    	   
       }
       
       
      
       private void ejecutarCargarPensum()
   	{
   		System.out.println("\n" + "Cargar un archivo de pensum" + "\n");
   		
   		}
   		public static void main(String[] args)
   		{
   			ConsolaSistema consola = new ConsolaSistema();
   			consola.ejecutarAplicacion();
   		}
       
  }

