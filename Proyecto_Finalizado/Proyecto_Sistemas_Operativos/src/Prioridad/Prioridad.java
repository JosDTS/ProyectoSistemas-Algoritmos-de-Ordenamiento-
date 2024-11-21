/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prioridad;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import proyecto_sistemas_operativos.Proyecto_Sistemas_Operativos;
/**
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez 
 * Clase que implementa el algoritmo de planificación por
 * prioridad. Gestiona la ejecución de procesos y calcula métricas como tiempo
 * en el sistema y tiempo de espera.
 */

public class Prioridad {

    private ArrayList<Proceso> listaProcesos = new ArrayList<>();

    /**
     * Añade un proceso a la lista de procesos pendientes.
     *
     * @param proceso Proceso a añadir.
     */

    public void añadirProceso(Proceso proceso) {
        listaProcesos.add(proceso);
    }

    /**
     * Ejecuta los procesos según el algoritmo de prioridad. Los procesos se
     * seleccionan en base a su prioridad y tiempo de llegada.
     */
    public void ejecutarProceso() throws InterruptedException {
        int tiempoActual = 0;
        ArrayList<Proceso> procesosTerminados = new ArrayList<>();

        System.out.println("\n            ALGORITMO DE PRIORIDAD");
        System.out.println("| Nombre del Proceso | Tiempo de Llegada | Tiempo CPU | Prioridad |");
        System.out.println("-------------------------------------------------------------------");

        while (!listaProcesos.isEmpty()) {

            ArrayList<Proceso> disponibles = new ArrayList<>();
            for (Proceso proceso : listaProcesos) {
                if (proceso.getTiempoLlegada() <= tiempoActual) {
                    disponibles.add(proceso);
                }
            }

            if (!disponibles.isEmpty()) {
                Proceso procesoSeleccionado = Collections.min(disponibles, (p1, p2) -> Integer.compare(p1.getPrioridad(), p2.getPrioridad()));

                int tiempoInicial = tiempoActual;
                tiempoActual += procesoSeleccionado.getTiempoCPU();

                System.out.println("|     " + procesoSeleccionado.getNombreProceso() + "       |         "
                        + procesoSeleccionado.getTiempoLlegada() + "          |       "
                        + procesoSeleccionado.getTiempoCPU() + "        |      "
                        + procesoSeleccionado.getPrioridad() + "      |");

                procesosTerminados.add(procesoSeleccionado);

                listaProcesos.remove(procesoSeleccionado);
            } else {
                tiempoActual = listaProcesos.get(0).getTiempoLlegada();
            }
        }

        System.out.println("-------------------------------------------------------------------\n");
        tiempoSistema(procesosTerminados);
        tiempoEspera(procesosTerminados);
    }

    /**
     * Calcula y muestra el tiempo en el sistema para cada proceso.
     *
     * @param listaProcesos Lista de procesos ejecutados.
     */
    public void tiempoSistema(ArrayList<Proceso> listaProcesos) {
        System.out.println("           Tiempo en el Sistema");
        System.out.println("| Proceso | Tiempo Ejecución | Tiempo Llegada | T.Ej - T.Ll |");
        System.out.println("--------------------------------------------------------------");

        int tiempoSistemaTotal = 0;
        int temporal = 0;

        for (Proceso proceso : listaProcesos) {
            if (temporal < proceso.getTiempoLlegada()) {
                temporal = proceso.getTiempoLlegada();
            }

            int tiempoInicial = temporal;
            int tiempoEjecucionFinal = tiempoInicial + proceso.getTiempoCPU();
            temporal += proceso.getTiempoCPU();
            int tiempoSistema = tiempoEjecucionFinal - proceso.getTiempoLlegada();

            System.out.println("|     " + proceso.getNombreProceso() + "       |        " + tiempoEjecucionFinal + "          |       "
                    + proceso.getTiempoLlegada() + "       |       " + tiempoSistema + "         |");

            tiempoSistemaTotal += tiempoSistema;
        }

        System.out.println("--------------------------------------------------------------");
        double promedioTiempoSistema = (double) tiempoSistemaTotal / listaProcesos.size();
        System.out.println("Promedio de Tiempo en el Sistema: " + promedioTiempoSistema + "\n");
    }

    /**
     * Calcula y muestra el tiempo de espera para cada proceso.
     *
     * @param listaProcesos listaProcesos Lista de procesos ejecutados.
     */
    public void tiempoEspera(ArrayList<Proceso> listaProcesos) throws InterruptedException {
        System.out.println("              Tiempo de Espera");
        System.out.println("| Proceso | Tiempo Inicio | Tiempo Llegada | T.In - T.Ll |");
        System.out.println("----------------------------------------------------------");

        int tiempoEsperaTotal = 0;
        int temporal = 0;

        for (Proceso proceso : listaProcesos) {
            if (temporal < proceso.getTiempoLlegada()) {
                temporal = proceso.getTiempoLlegada();
            }

            int tiempoInicio = temporal;
            int tiempoEspera = tiempoInicio - proceso.getTiempoLlegada();
            temporal += proceso.getTiempoCPU();

            System.out.println("|     " + proceso.getNombreProceso() + "       |        " + tiempoInicio + "          |       "
                    + proceso.getTiempoLlegada() + "       |       " + tiempoEspera + "         |");

            tiempoEsperaTotal += tiempoEspera;
        }

        System.out.println("----------------------------------------------------------");
        double promedioTiempoEspera = (double) tiempoEsperaTotal / listaProcesos.size();
        System.out.println("Promedio de Tiempo de Espera: " + promedioTiempoEspera + "\n");
        Thread.sleep(5000);
        Proyecto_Sistemas_Operativos.menu();
    }
}
