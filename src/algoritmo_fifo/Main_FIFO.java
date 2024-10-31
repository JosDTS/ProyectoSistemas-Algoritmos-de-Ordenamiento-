/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmo_fifo;

import java.util.Scanner;

/**
 *
 * @author ESTUDIANTE
 */
public class Main_FIFO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Algorithm_FIFO algoritmo = new Algorithm_FIFO(); 
        Scanner scanner = new Scanner(System.in); 
        
      while(true){
          System.out.println("Ingrese el Nombre del proceso (en caso de terminar ingrese 0): ");
          String nombre = scanner.nextLine(); 
          
          if (nombre.equals("0")) {
              break; 
          }
          
          System.out.println("Ingrese el tiempo de llegada: ");
          int tiempoLlegada = Integer.parseInt(scanner.nextLine()); 
          
          System.out.println("Ingrese el tiempode CPU: ");
          int tiempoCPU = Integer.parseInt(scanner.nextLine()); 
          
          algoritmo.añadirProceso(new Procesos (nombre, tiempoLlegada, tiempoCPU));
      }
      algoritmo.ejecutarProceso();
      algoritmo.tiempoSistema();
      algoritmo.tiempoEspera();
      scanner.close(); 
        
    }
    
}
