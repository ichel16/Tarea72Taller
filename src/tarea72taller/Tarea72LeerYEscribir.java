/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author ichel
 */
public class Tarea72LeerYEscribir {
    
    void guardar(ArrayList<Empleado> listaEmpleados){
        
        File fichero = new File("datos.dat");
        fichero.delete();
        
        try {
            
            boolean primerObjeto = false;
            
            for (Empleado e : listaEmpleados) {
                
                if (primerObjeto==false) {
                    
                    FileOutputStream fos = new FileOutputStream("datos.dat");
                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    oos.writeObject(e);
                    oos.close();
                    fos.close();
                    primerObjeto=true;

                }else{
                    
                    //Se usa noSobreescribirObjetos.No escribe una cabecera.
                    FileOutputStream fos = new FileOutputStream("datos.dat",true);
                    Tarea72NoSobreescribirObjetos noos = new Tarea72NoSobreescribirObjetos(fos);

                    noos.writeUnshared(e);
                    noos.close();
                    fos.close();
                    
                }
                
            }
            
        } catch (Exception e) {
            System.err.println("Error al guardar el archivo.");
        }
        
    }
    
    //MAL no llega a leer.
    ArrayList<Empleado> cargaDeDatos(){
        
        ArrayList<Empleado> importarDatos = new ArrayList<>();
        
        File fichero = new File("datos.dat");
        
        try {
                
            
            FileInputStream fis = new FileInputStream(fichero);
            ObjectInputStream ois = new ObjectInputStream(fis); 
            // Se lee el primer objeto
                    
            Empleado aux;
            aux = (Empleado)ois.readObject();
                  
            while (aux!=null) {

                importarDatos.add(aux);
                
                try{
                    //seguimos intentando leer objetos
                    aux = (Empleado)ois.readObject();
                    //ois.close();
                    //fis.close();
                }catch (IOException e) {
                    //No hay más objetos en el fichero, salimos del while
                    ois.close();
                    fis.close();
                    break;
                }       
            }
            
            
            
        } catch (Exception e) {
            System.err.println("Los datos no se han cargado");
        }
        
        return importarDatos;
        
    }
    
}
