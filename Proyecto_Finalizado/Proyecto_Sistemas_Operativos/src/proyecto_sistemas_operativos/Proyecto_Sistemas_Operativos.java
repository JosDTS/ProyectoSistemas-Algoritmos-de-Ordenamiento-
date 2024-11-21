/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_sistemas_operativos;
import java.util.Scanner;
import Prioridad.MainPrioridad;
import Round_Robin.Main_RR;
import algoritmo_fifo.Main_FIFO;
/**
 *
 * @author Sheys
 */
public class Proyecto_Sistemas_Operativos {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        menu();
    }
    public static void menu() throws InterruptedException{
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido al sistema de algoritmos de planificacion");
        System.out.println("1.FIFO");
        System.out.println("2.Prioridad");
        System.out.println("3.Round Robin");
        System.out.println("0.Salir");
        System.out.print("Seleccione una opcion: ");
        int op = scanner.nextInt();
        switch (op) {
            case 1 -> Main_FIFO.menu();
            case 2 -> MainPrioridad.menu();
            case 3 -> Main_RR.menu();
            case 0 -> System.out.println("Saliendo...");
            default -> System.out.println("Opcion incorrecta");           
        }
    
    }
    
}
