/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea72taller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ichel
 */
public class Tarea72Taller {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        menu();
        
    }
    
    public static void menu(){
        
        int menu=0;
        Taller taller = new Taller();
        
        
        /*
        taller.pruebas();
        taller.guardarDatos();
        taller.ordenarEmpleado();
        */
        //Cargamos los datos almacenados en el fihcero datos.dat
        taller.cargarDatos();
        
        System.out.println("Bienvenido a la Aplicacion del Taller, elige una opción");
        
        while (menu!=8) {
            
            
            System.out.println("Menu operaciones del Taller."
                    + "\n 1.- Alta empleado"
                    + "\n 2.- Listar"
                    + "\n 3.- Buscar empleado"
                    + "\n 4.- Añadir venta"
                    + "\n 5.- Añadir trabajo"
                    + "\n 6.- Calcular sueldo"
                    + "\n 7.- Guardar datos"
                    + "\n 8.- Salir");
            
            Scanner teclado = new Scanner(System.in);
            menu = validarMenu();
            
            switch(menu){
                
                //Alta empleado.
                case 1:
                    
                    taller.altaEmpleado();
                    
                    break;
                
                //Listado ordenado por código
                case 2:
                    
                    taller.ordenarEmpleado();
                    
                    break;
                
                //Buscar empleado.
                case 3:
                    
                    taller.mostrarEmpleado();
                    
                    break;
                
                //Añadir venta.
                case 4:
                    
                    taller.ventaEmpleado();
                    
                    break;
                
                //Añadir trabajo.
                case 5:
                    
                    taller.horasTrabajadas();
                    
                    break;
                
                //Calcular sueldo.
                case 6:
                    
                    taller.verSueldo();
                    
                    break;
                
                //Guardar datos.
                case 7:
                    
                    taller.guardarDatos();
                    
                    break;
                    
            }
        }
    }
    
    public static String validarDni(){
        
        Scanner teclado = new Scanner(System.in);
        String nif;
        
        System.out.println("Introduce el DNI");
        nif = teclado.next();
        
        //Tiene que haber mínimo 8 y máximo 8 números.
        //Seguido de mínimo 1 y máximo 1 letra.
        Pattern p = Pattern.compile("[0-9]{8,8}[A-Z]{1,1}");
        Matcher m = p.matcher(nif);
        
        while (!m.matches()) {            
            
            System.err.println("DNI erróneo, introduce otro.");
            nif = teclado.next();
            m = p.matcher(nif);
            
        }
        
        System.out.println("El DNI es: " + nif);
        return nif;
    }
    
    public static String validarCodigo(){
    
        Scanner teclado = new Scanner(System.in);
        String codigo;
        
        System.out.println("Introduce el codigo del trabajador");
        codigo = teclado.next();
        
        //Tiene que haber mínimo 2 y máximo 2 números
        //Seguido de un guión.
        //Seguido de minimo 1 y máximo 1 número.
        Pattern p = Pattern.compile("[0-9]{2,2}-[0-9]{1,1}");
        Matcher m = p.matcher(codigo);
        
        while (!m.matches()) {            
            
            System.err.println("Código erróneo, introduce otro.");
            codigo = teclado.next();
            m = p.matcher(codigo);
            
        }
        
        System.out.println("El codigo es: " + codigo);
        return codigo;
    }
    
    public static String validarTurno(){
        
        Scanner teclado = new Scanner(System.in);
        String turno;
        
        System.out.println("Introduce el turno del trabajador (Mañana o Tarde)");
        turno = teclado.next();
        
        Pattern p = Pattern.compile("(?i)(manana|tarde)");
        Matcher m = p.matcher(turno);
        
        
        while (!m.matches()) {

            System.err.println("Turno erróneo, introduce Mañana o Tarde.");
            turno = teclado.next();
            m = p.matcher(turno);
            
        }
        
        System.out.println("El turno es: " + turno);
        return turno;
        
    }
    
    public static int validarInt (String valor){
            
        int entero=-1;
        Boolean control=false;

        while (control==false) {                
            try {
            entero=Integer.parseInt(valor);
        } catch (Exception e) {
            System.out.println("Error, introduce un número.");
            }
            control=true;
        }

        return entero;
    }
    
    public static int validarMenu(){
        Scanner teclado = new Scanner(System.in);
        int menu = 0;
        boolean control = false;
        
        while (control == false) {            
            try {
                String convertir;
                convertir=teclado.next();
                menu = Integer.parseInt(convertir);
                control=true;

            } catch (Exception e) {
                System.err.println("Error, introduce una opción correcta.");
            }
        }
        
        return menu;
    }
    
    public static float validarFloat (String valor){
        float decimal=-1f;
        Boolean control=false;

        while (control==false) {                
            try {
            decimal=Float.parseFloat(valor);

        } catch (Exception e) {
            System.out.println("Error, introduce un número.");
            }
            control=true;
        }

        return decimal;
    }
    
}
