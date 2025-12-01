/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinal.Vista;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import proyectofinal.Controlador.ControladorOrdenes;

/**
 *
 * @author hilary fernando
 */
public class Principal {
        
    
    private static final String NOMBRE_ARCHIVO_DATOS = "Data/Datos.txt";
    private static final String NOMBRE_ARCHIVO_USUARIO = "Data/Usuario.txt";

    public static void main(String[] args) {
        
       
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("\ndd/MM/yyyy HH:mm:ss a");
        String fechaHoraActual = ahora.format(formato);
     

        ControladorOrdenes controlador = new ControladorOrdenes();
      
        Scanner lector = new Scanner(System.in); 

        System.out.println("--- EJECUCION REPORTES ---");
        System.out.println("Fecha y Hora : " + fechaHoraActual); 
        
        
        String usuarioIngresado = "";
        String contraseñaIngresada = "";

        try {
            System.out.print("\nIngrese su nombre de usuario: ");
            usuarioIngresado = lector.nextLine();
    
            System.out.print("Ingrese su contraseña: ");
            contraseñaIngresada = lector.nextLine();
        
            

           
            boolean autenticado = controlador.validarCredenciales(usuarioIngresado, contraseñaIngresada, NOMBRE_ARCHIVO_USUARIO);

            if (autenticado) {
                System.out.println("\nLogin exitoso. Acceso concedido.");
                mostrarMenuReportes(controlador, lector); 
                
            } else {
                System.out.println("\n ERROR DE AUTENTICACION: Usuario o contraseña incorrectos.");
            }

        } catch (ExcepcionProcesamientoDatos e) {
         
            System.out.println("\n\n ERROR CRITICO DEL SISTEMA:");
            System.out.println("Mensaje: " + e.getMessage());
            if (e.esCritico()) {
                System.out.println("Tipo: ERROR FATAL. La ejecucion ha sido detenida.");
            }
        } catch (Exception e) {
            System.out.println("\nError inesperado durante el login: " + e.getMessage());
        } finally {
           
      
            System.out.println("\n--- Proceso finalizado. ---");
        }
    }


