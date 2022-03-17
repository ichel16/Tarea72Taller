/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

import java.io.Serializable;

/**
 *
 * @author ichel
 */
//Hay que implementar que sea serializable la clase PADRE
public class Persona implements Serializable{
    
    protected String nif;
    protected String nombre;
    protected String apellidos;

    public Persona() {
    }

    public Persona(String nif, String nombre, String apellidos) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return "Persona{" + "NIF: " + nif + ", Nombre: " + nombre + ", Apellidos: " + apellidos + '}';
    }
    
    
}
