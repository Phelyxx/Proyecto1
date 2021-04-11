package uniandes.dpoo.proyecto1.ejecucion;

import  uniandes.dpoo.proyecto1.procesamiento.Loader;
import  uniandes.dpoo.proyecto1.procesamiento.InformacionPensum;
import java.io.FileNotFoundException;
import java.io.IOException;



public class Ejecucion 
	{
		
		private void ejecutarCargarArchivo()
		{
			try
			{
				InformacionPensum archivo = Loader.cargarArchivo("./data/");
				System.out.println(archivo.);
			}
				catch (FileNotFoundException e)
				{
					System.out.println("No se encontro el archivo".);
				}
				catch(IOException ie)
			{
		            ie.printStackTrace();
		            System.out.println("No se pudo leer el archivo.");
			}
		}
		public static void main(String[] args)
		{
			Ejecucion cargar = new Ejecucion();
			cargar.ejecutarCargarArchivo();
		}
	}
}
