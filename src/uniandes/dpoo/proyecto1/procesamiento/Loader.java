package uniandes.dpoo.proyecto1.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Loader
{
    public static InformacionPensum cargarArchivo(String nombre) throws FileNotFoundException, IOException
    {
    	BufferedReader br = new BufferedReader(new FileReader(nombre));
		String linea = br.readLine();
		linea = br.readLine();
		while (linea != null) 
		{
			String[] partes = linea.split(",");
        }
    }
}
