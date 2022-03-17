/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author ichel
 */
public class Tarea72NoSobreescribirObjetos extends ObjectOutputStream{
    
        // Constructor que recibe OutputStream */
    public Tarea72NoSobreescribirObjetos(OutputStream out) throws IOException
        { super(out); }
    
    //Constructor sin parámetros */
    protected Tarea72NoSobreescribirObjetos() throws IOException, SecurityException
        { super(); }
    
    // Redefinición del método de escribir la cabecera para que no haga nada. */
    protected void writeStreamHeader() throws IOException{
    }
    
    
}
