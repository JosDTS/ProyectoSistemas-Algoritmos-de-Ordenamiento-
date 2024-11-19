/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Algoritmo_Prioridad;

import java.util.Scanner;

/**
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez 
 * Clase principal para ejecutar el algoritmo de
 * planificación por prioridad. Permite al usuario ingresar procesos con sus
 * características y ejecutarlos según su prioridad.
 */
public class MainPrioridad {

    public static void main(String[] args) {

        Prioridad algoritmo = new Prioridad();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Ingrese el Nombre del proceso (Si desea terminar ingrese 0): ");
            String name = scanner.nextLine();

            if (name.equals("0")) {
                break;
            }

            System.out.println("Ingrese el tiempo de llegada: ");
            int tiempoLlegada = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese el tiempo de CPU: ");
            int tiempoCPU = Integer.parseInt(scanner.nextLine());

            System.out.println("Ingrese la prioridad del proceso (menor valor indica mayor prioridad): ");
            int prioridad = Integer.parseInt(scanner.nextLine());

            /**
             * Añade el proceso ingresado al algoritmo de prioridad
             */
            algoritmo.añadirProceso(new Proceso(name, tiempoLlegada, tiempoCPU, prioridad));
        }

        /**
         * Ejecuta los procesos según el algoritmo de prioridad
         */
        algoritmo.ejecutarProceso();

        scanner.close();
    }
}
