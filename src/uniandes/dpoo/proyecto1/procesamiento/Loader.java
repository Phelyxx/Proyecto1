package uniandes.dpoo.proyecto1.procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uniandes.dpoo.proyecto1.modelo.Curso;
import uniandes.dpoo.taller0.modelo.Evento;

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
			String nombreCurso = partes[0];
			int creditos = Integer.parseInt(partes[1]);
			if(partes[2].equals("no"))
			{
				boolean esObligatorio = false;
			}
			else if(partes[2].equals("si"))
			{
				boolean esObligatorio = true;
			}
			if(partes[3].equals("no"))
			{
				boolean esElectivaIngenieria = false;
			}
			else if(partes[3].equals("si"))
			{
				boolean esElectivaIngenieria = true;
            }
			if(partes[4].equals("no"))
			{
				boolean esElectivaProfesional = false;
			}
			else if(partes[4].equals("si"))
			{
				boolean esElectivaProfesional = true;
            }
			if(partes[5].equals("no"))
			{
				boolean CBU = false;
			}
			else if(partes[5].equals("si"))
			{
				boolean CBU = true;
            }
			if(partes[6].equals("no"))
			{
				boolean esTipoI = false;
			}
			else if(partes[6].equals("si"))
			{
				boolean esTipoI = true;
            }
			if(partes[7].equals("no"))
			{
				boolean esTipoE = false;
			}
			else if(partes[7].equals("si"))
			{
				boolean esTipoE = true;
            }
			if(partes[8].equals("no"))
			{
				boolean esEpsilon = false;
			}
			else if(partes[8].equals("si"))
			{
				boolean esEPsilon = true;
            }
			if(partes[9].equals("no"))
			{
				boolean preRrequisitos = false;
			}
			else if(partes[9].equals("si"))
			{
				boolean preRrequisitos = true;
            }
			if(partes[10].equals("no"))
			{
				boolean correquisitos = false;
			}
			else if(partes[10].equals("si"))
			{
				boolean correquisitos = true;
            }
			String semanas = partes[11];
			int semestre = Integer.parseInt(partes[12]);
			
			List<Curso> cursos = new ArrayList<>();
			cursos.add(nombreCurso);
			
			linea = br.readLine(); 
		}  
		br.close();
    }
}
