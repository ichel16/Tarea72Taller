/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

/**
 *
 * @author ichel
 */
//Hacemos que sea hija de persona
//Como el objeto padre es serializable los hijos automáticamente lo son.
public class Empleado extends Persona implements Comparable<Empleado>{
    
    protected String codigo;
    protected int sueldobase;

    public Empleado(String codigo, int sueldobase) {
        this.codigo = codigo;
        this.sueldobase = sueldobase;
    }

    public Empleado(String codigo, int sueldobase, String nif, String nombre, String apellidos) {
        super(nif, nombre, apellidos);
        this.codigo = codigo;
        this.sueldobase = sueldobase;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getSueldobase() {
        return sueldobase;
    }

    public void setSueldobase(int sueldobase) {
        this.sueldobase = sueldobase;
    }
    
    public float calcularSueldo(){
        
        float sueldoTotal = this.sueldobase;
        
        return sueldoTotal;         
    }

    @Override
    public String toString() {
        return "Empleado{" + "NIF: " + nif + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Codigo: " + codigo + ", Sueldo base: " + sueldobase + '}';
    }

    //Implementamos comparar, y añadimos que esta clase pueda ser ordenada por código.
    @Override    
    public int compareTo(Empleado o) { 
        return codigo.compareTo(o.codigo);
    }
    
}
