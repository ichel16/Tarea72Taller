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
public class Mecanico extends Empleado implements Serializable{
    
    protected int precioHora;
    protected int horasTrabajadas;

    public Mecanico(int precioHora, int horasTrabajadas, String codigo, int sueldobase) {
        super(codigo, sueldobase);
        this.precioHora = precioHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public Mecanico(int precioHora, int horasTrabajadas, String codigo, int sueldobase, String nif, String nombre, String apellidos) {
        super(codigo, sueldobase, nif, nombre, apellidos);
        this.precioHora = precioHora;
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(int precioHora) {
        this.precioHora = precioHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }
    
        //Creamos un método para añadir horas trabajadas.
    public void agregarHoras(int horasExtras){
        this.horasTrabajadas = this.horasTrabajadas + horasExtras;
    }

    @Override
    public String toString() {
        return "Mecanico{" + "NIF: " + nif + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Codigo: " + codigo + ", Sueldo base: " + sueldobase + ", Precio Hora: " + precioHora + ", Horas trabajadas: " + horasTrabajadas + '}';
    }


    @Override
    public float calcularSueldo() {
        
        float sueldoMecanico;
        
        sueldoMecanico = (this.horasTrabajadas * this.precioHora) + super.calcularSueldo();
        
        return sueldoMecanico;
        
    }


    
    

    
}
