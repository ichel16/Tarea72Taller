/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

import java.util.ArrayList;
import java.util.Collections;


import java.util.Scanner;

/**
 *
 * @author ichel
 */
public class Taller {
    
    ArrayList<Empleado> listaPersonal = new ArrayList<>();
    
    void pruebas(){
        
        Mecanico mecanicoPrueba = new Mecanico(20, 10, "15-5", 2000, "00000000T", "Leonardo", "Jaraiz Collado");
        Vendedor vendedorPrueba = new Vendedor("Mañana", 5, 15.5f, "11-1", 2000, "111111111R", "NombreVendedor", "ApellidosVendedor");

        listaPersonal.add(mecanicoPrueba);
        listaPersonal.add(mecanicoPrueba);
        listaPersonal.add(mecanicoPrueba);
        listaPersonal.add(vendedorPrueba);
        listaPersonal.add(vendedorPrueba);
        listaPersonal.add(mecanicoPrueba);
        listaPersonal.add(vendedorPrueba);
        listaPersonal.add(mecanicoPrueba);
        listaPersonal.add(vendedorPrueba);
        listaPersonal.add(vendedorPrueba);
        
    }
    
    boolean comprobarAlta(String nif){
        
        boolean existe=false;
        
        for (Empleado e : listaPersonal) {
            
            if (e.getNif().equals(nif)) {
                existe=true;
            }
        }
        
        return existe;        
    }
    
    void altaEmpleado(){
        
        
        Scanner teclado = new Scanner(System.in);        
                
        //Llamamos al método validar DNI de la clase Tarea72Taller
        String nif = Tarea72Taller.validarDni();
        
        comprobarAlta(nif);
        
        if (comprobarAlta(nif)==false) {
            
            System.out.println("Elige el tipo de empleado");
            int menu=0;
            
            while (menu!=3) {
                        
                System.out.println("¿Qué quieres dar de alta?"
                + "\n 1.- Mecánico"
                + "\n 2.- Vendedor"
                + "\n 3.- Salir");

                menu = Tarea72Taller.validarMenu();
            
                switch(menu){
                    //Creamos un objeto de tipo mecánico
                    case 1:
                        
                        System.out.println("Introduce el precio por horas");
                        int precioHora = Tarea72Taller.validarInt(teclado.next());
                        
                        System.out.println("Introduce las horas trabajadas");
                        int horasTrabajadas = Tarea72Taller.validarInt(teclado.next());
                        
                        String codigo = Tarea72Taller.validarCodigo();
                        
                        System.out.println("Introduce el sueldo base");
                        int sueldobase = Tarea72Taller.validarInt(teclado.next());
                        
                        //Limpiamos Scanner.
                        teclado.nextLine();
                        System.out.println("Introduce el nombre");
                        String nombre = teclado.nextLine();
                        
                        System.out.println("Introduce los apellidos");
                        String apellidos = teclado.nextLine();

                        Mecanico auxMecanico = new Mecanico(precioHora, horasTrabajadas, codigo, sueldobase, nif, nombre, apellidos);
                        
                        listaPersonal.add(auxMecanico);
                        menu=3;
                        
                        break;
                        
                    //Creamos un objeto de tipo Vendedor.
                    case 2:
                        
                        System.out.println("Introduce el turno");
                        String turno = Tarea72Taller.validarTurno();
                        
                        System.out.println("Introduce la comisión");
                        int comision = Tarea72Taller.validarInt(teclado.next());
                        
                        System.out.println("Introduce las ventas");
                        float ventas = Tarea72Taller.validarFloat(teclado.next());
                        
                        codigo = Tarea72Taller.validarCodigo();
                        
                        System.out.println("Introduce el sueldo base");
                        sueldobase = Tarea72Taller.validarInt(teclado.next());
                        
                        //Limpiamos Scanner.
                        teclado.nextLine();
                        System.out.println("Introduce el nombre");
                        nombre = teclado.nextLine();
                        
                        System.out.println("Introduce los apellidos");
                        apellidos = teclado.nextLine();
                        
                        Vendedor auxVendedor = new Vendedor(turno, comision, ventas, codigo, sueldobase, nif, nombre, apellidos);
                        
                        listaPersonal.add(auxVendedor);
                        menu=3;
                        
                        break;
                }
                
            }  
            
        }else{
            System.err.println("Esa persona ya está de alta");
        }
        
        
    }
    

    void mostrarEmpleado(){
        
        String nif = Tarea72Taller.validarDni();
        boolean existe = false;
        
        System.out.println("Los datos del trabajador son:");
        
        for (Empleado e : listaPersonal) {
            
            if (e.getNif().equals(nif)) {
                
                System.out.println(e.toString());
                existe = true;
                
            }
            
        }
        
        if (existe==false) {
            System.err.println("El trabajador no existe.");
        }
        
    }
    
    void ordenarEmpleado(){
        
        //Ordenamos los trabajadores por código.        
        Collections.sort(listaPersonal);
        
        for (Empleado e : listaPersonal) {
        
            System.out.println(e.toString());
            
        }
    }
    
    //Añadir venta: Esta opción nos solicitara el código del empleado y nos permitirá añadir la nueva venta.
    void ventaEmpleado(){
        
        Scanner teclado = new Scanner(System.in);
        String codigo = Tarea72Taller.validarCodigo();
        boolean existe = false;
        
        System.out.println("Los datos del trabajador son:");
        
        for (Empleado d : listaPersonal) {
            
            if (d.getCodigo().equals(codigo)) {
                
                System.out.println(d.toString());
                existe=true;
                
                try {
                    
                    System.out.println("Introduce las ventas realizadas.");
                    float ventasRealizadas = Tarea72Taller.validarFloat(teclado.next());
                    
                    ((Vendedor)d).agregaVenta(ventasRealizadas);
                    
                } catch (Exception e) {
                    System.err.println("Este empleado no puede realizar ventas.");
                }
                
            }
            
        }
        
        if (existe==false) {
            System.err.println("No hay ningún trabajador con ese código.");
        }
        
        
        
        
    }
    
    //Añadir trabajo: Esta opción nos solicitara el código del empleado y nos permitirá añadir horas trabajadas.
    void horasTrabajadas(){
        
        Scanner teclado = new Scanner(System.in);
        String codigo = Tarea72Taller.validarCodigo();
        boolean existe = false;
        
        System.out.println("Los datos del trabajador son:");
        
        for (Empleado d : listaPersonal) {
            
            if (d.getCodigo().equals(codigo)) {
                
                System.out.println(d.toString());
                existe=true;
                
                try {
                    
                    System.out.println("Introduce las horas que quieres añadir.");
                    int horas = Tarea72Taller.validarInt(teclado.next());
                    
                    ((Mecanico)d).agregarHoras(horas);
                    
                } catch (Exception e) {
                    System.err.println("Este empleado no puede realizar horas.");
                }
                
            }
            
        }
        
        if (existe==false) {
            System.err.println("No hay ningún trabajador con ese código.");
        }
    }
    
    //Calcular sueldo: Esta opción nos solicitara un nif y mostraremos el sueldo que el corresponde a esa persona
    void verSueldo(){
        
        String nif = Tarea72Taller.validarDni();
        boolean existe = false;
        
        System.out.println("Los datos del trabajador son:");
        
        for (Empleado e : listaPersonal) {
            
            if (e.getNif().equals(nif)) {
                
                System.out.println(e.toString());
                System.out.print("Y su sueldo es: ");
                //Aquí no es necesario la conversión de objetos, java usará polimorfismo y llamará al metodo de la clase correspondiente.
                System.out.println(e.calcularSueldo());
                existe = true;
                
            }
            
        }
        
        if (existe==false){
            System.err.println("El trabajador no existe.");
        }
        
    }
    
    //Guardar datos: Para garantizar la persistencia de los datos. Esta opción debe guardar la estructura de 
    //almacenamiento de datos en un fichero. (El fichero será datos.dat)
    void guardarDatos(){
        Tarea72LeerYEscribir guardar = new Tarea72LeerYEscribir();
        
        guardar.guardar(listaPersonal);
        
    }
    
    // Cargar datos: Cuando se inicie la aplicación cargaría esa estructura de almacenamiento de datos la 
    //estructura dinámica o lista de la aplicación. (El fichero será datos.dat)
    void cargarDatos(){
        
        listaPersonal.clear();
        
        Tarea72LeerYEscribir cargar = new Tarea72LeerYEscribir();
        //Probando donde falla
        //cargar.cargaDeDatos();

        //Cuando funcione
        listaPersonal.addAll(cargar.cargaDeDatos());
        
    }
    
}
