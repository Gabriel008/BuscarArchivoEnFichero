/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaa;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author Gabriel Valenzuela
 */
public class Pruebaa {
    /**
     * 
     * @param args
     */

    /**
     * @param args the command line arguments
     */
    static boolean existe=false;
    public static void main(String[] args) {
        // TODO code application logic here
        File f;
        
          String files="";
          String ruta="C:\\\\Reportes1";

           Calendar c = Calendar.getInstance();
                    c.setTime(new Date(System.currentTimeMillis()));
                    int diaD = c.get(Calendar.DATE);
                    int mesD = c.get(Calendar.MONTH)+1;
                    int anoD = c.get(Calendar.YEAR);
                String Archivo=anoD+mesD+diaD+".pdf";
        File folder = new File(ruta+"\\");
        
        if (!folder.isDirectory()) { 
        folder.mkdir();
        }
   
        
        File[] listOfFiles = folder.listFiles(); 
        System.out.println("RUTA Origen:"+ruta);
        System.out.println("BUSCANDO ARCHIVO:"+Archivo);
        for (int i = 0; i < listOfFiles.length; i++) 
        {
            if (listOfFiles[i].isFile()) 
            {
                files = listOfFiles[i].getName();
                if (files.endsWith(Archivo))
                {
                    if(!files.equals("")){
                    System.out.println("Archivos encontrados: "+files);
                    existe=true;
                    break;
                    }
                }
            }
        }
        
         if(existe==false) {
        
                System.out.println("NO SE A ENCONTRADO ARCHIVO");  
                     
        } 
    else 
        { 
        
         
      Path origenPath = FileSystems.getDefault().getPath("C:\\\\Reportes1\\");
      Path destinoPath = FileSystems.getDefault().getPath("C:\\\\Reportes\\");
       
        try {
            Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println(e);
        }
	}
    }
    }
    

