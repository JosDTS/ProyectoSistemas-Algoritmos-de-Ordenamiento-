/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algoritmo_fifo;

import java.util.Scanner;

/**
 *
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 */
public class Main_FIFO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here
        
        menu();
        
    }
    public static void menu() throws InterruptedException{
        Algorithm_FIFO algoritmo = new Algorithm_FIFO(); 
        Scanner scanner = new Scanner(System.in); 
        System.out.println("---------------Algoritmo FIFO--------------");
      while(true){
          
          System.out.println("Ingrese el Nombre del proceso (en caso de terminar ingrese 0): ");
          String name = scanner.nextLine(); 
          
          if (name.equals("0")) {
              break; 
          }
          
          System.out.println("Ingrese el tiempo de llegada: ");
          int tiempoLlegada = Integer.parseInt(scanner.nextLine()); 
          
          System.out.println("Ingrese el tiempo de CPU: ");
          int tiempoCPU = Integer.parseInt(scanner.nextLine()); 
          
          algoritmo.añadirProceso(new Procesos (name, tiempoLlegada, tiempoCPU));
      }
      algoritmo.ejecutarProceso();
      algoritmo.tiempoSistema();
      algoritmo.tiempoEspera();
      scanner.close(); 
    
    }
    
}
