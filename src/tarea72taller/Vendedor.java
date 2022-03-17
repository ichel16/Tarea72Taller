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
public class Vendedor extends Empleado{
    
    protected String turno;
    protected int comision;
    protected float ventas;

    public Vendedor(String turno, int comision, float ventas, String codigo, int sueldobase) {
        super(codigo, sueldobase);
        this.turno = turno;
        this.comision = comision;
        this.ventas = ventas;
    }

    public Vendedor(String turno, int comision, float ventas, String codigo, int sueldobase, String nif, String nombre, String apellidos) {
        super(codigo, sueldobase, nif, nombre, apellidos);
        this.turno = turno;
        this.comision = comision;
        this.ventas = ventas;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public float getVentas() {
        return ventas;
    }

    public void setVentas(float ventas) {
        this.ventas = ventas;
    }
    
    //Creamos un método para añadir ventas.
    public void agregaVenta(float ventaRealizada){
        this.ventas = this.ventas + ventaRealizada;
    }

    @Override
    public String toString() {
        return "Vendedor{" + "NIF: " + nif + ", Nombre: " + nombre + ", Apellidos: " + apellidos + ", Codigo: " + codigo + ", Sueldo base: " + sueldobase + ", Turno: " + turno + ", Comision: " + comision + ", Ventas: " + ventas + '}';
    }
    

    @Override
    public float calcularSueldo() {
        
        float sueldoVendedor;
        
        sueldoVendedor = (this.comision * this.ventas)/100 + super.calcularSueldo();
        
        return sueldoVendedor;
        
    }
    
}
