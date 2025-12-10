package proyectofinal.Vista;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TXT {

    public static void main(String[] args) {

        try {
           
            PrintWriter pw = new PrintWriter(new FileWriter("reporte_orden.txt"));

            pw.println("===== REPORTE DE PRUEBA =====");
            pw.println("ID ORDEN: 1001");
            pw.println("PRODUCTO: Audífonos");
            pw.println("CANTIDAD: 4");
            pw.println("IMPORTE: S/ 150.00");
            pw.println("==============================");

            pw.close(); 

            System.out.println("Archivo creado: reporte_orden.txt");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

}
