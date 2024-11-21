/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Round_Robin;

import java.util.Scanner;

/**
 *
 * Clase Main usado para ingresar los datos de los procesos y para llamar a las
 * clases
 *
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez
 */
public class Main_RR {

    /**
     *
     * @param args args
     */
    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        menu();

    }

    public static void menu() throws InterruptedException {
        RR algoritmo = new RR();
        Scanner scanner = new Scanner(System.in);
        System.out.println("---------------Algoritmo Round Robin--------------");
        while (true) {
            System.out.println("Ingrese el Nombre del proceso (en caso de terminar ingrese 0): ");
            String name = scanner.nextLine();

            if (name.equals("0")) {
                break;
            }

            System.out.println("Ingrese el tiempo de llegada: ");
            int tiempoLlegada = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el tiempo de CPU: ");
            int tiempoCPU = Integer.parseInt(scanner.nextLine());

            algoritmo.añadirProceso(new Procesos(name, tiempoLlegada, tiempoCPU, 0, 0));

        }
        algoritmo.mostrarProcesos();
        algoritmo.ejecutarRoundRobin();
        algoritmo.mostrarProcesosTerminados();

        algoritmo.tiempoSistema();
        algoritmo.tiempoEspera2();
        scanner.close();

    }
}
