/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Round_Robin;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Clase que realiza todos los calculos necesarios para el algoritmo Round RObin
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria 
 * @author Katlyn Lopez
 */
public class RR {

    private final ArrayList<Procesos> listaProcesos;
    private final ArrayList<Procesos> cola;
    private final ArrayList<String> procesosTerminados;
    private final ArrayList<Procesos> calculosProceso;
    private int tiempoActual;
    private int quantum;
    private final Scanner sc = new Scanner(System.in);
    Procesos calculos = new Procesos();

    /**
     * Constructor de array y solicita el quantum
     */
    public RR() {
        listaProcesos = new ArrayList<>();
        cola = new ArrayList<>();
        procesosTerminados = new ArrayList<>();
        calculosProceso = new ArrayList<>();
        tiempoActual = 0;

        System.out.println("Ingrese el QUANTUM");
        quantum = sc.nextInt();
    }

    /**
     *
     * @param proceso
     */
    public void añadirProceso(Procesos proceso) {
        listaProcesos.add(proceso);
    }

    /**
     *
     */
    public void ordenarProcesosPorLlegada() {
        listaProcesos.sort((p1, p2) -> Integer.compare(p1.getTiempoLlegada(), p2.getTiempoLlegada()));
    }

    /**
     *
     */
    public void ejecutarRoundRobin() {
        ordenarProcesosPorLlegada();
        int tiempoInicio = 0;
        int temporal = 0;
        int tiempoInicialSumado = 0;
        int tiempoEjecSumado = 0;
        int tiempoEjec = 0;

        System.out.println("------------Diagrama de Gahn---------------");
        System.out.println("Proceso | Tiempo restante | Tiempo inicial | Tiempo Ejecucion");
        while (!listaProcesos.isEmpty() || !cola.isEmpty()) {
            // Mover procesos que han llegado a la cola
            while (!listaProcesos.isEmpty() && listaProcesos.get(0).getTiempoLlegada() <= tiempoActual) {
                cola.add(listaProcesos.remove(0));

            }

            if (!cola.isEmpty()) {
                Procesos procesoActual = cola.remove(0);

                if (temporal < procesoActual.getTiempoLlegada()) {
                    temporal = procesoActual.getTiempoLlegada();

                }
                tiempoInicio = temporal;

                if (procesoActual.getTiempoCPU() == procesoActual.getTiempoRestante()) {

                    calculos = new Procesos(procesoActual.getNombreProceso(),
                            procesoActual.getTiempoLlegada(),
                            procesoActual.getTiempoCPU(), tiempoEjec,
                            tiempoInicio, tiempoEjecSumado);
                    calculosProceso.add(calculos);
                }

                // Ejecutar el proceso actual por un quantum o menos
                int tiempoEjecutado = Math.min(quantum, procesoActual.getTiempoRestante());

                procesoActual.setTiempoRestante(procesoActual.getTiempoRestante() - tiempoEjecutado);

                tiempoActual += tiempoEjecutado;

                System.out.println("-----------------------------------------------------------------------------");
                System.out.println(procesoActual.getNombreProceso() + "      |      "
                        + procesoActual.getTiempoRestante() + "       |       " + tiempoInicio + "         |       " + tiempoActual);
                temporal = tiempoActual;
                // Mover más procesos que llegaron durante la ejecución
                while (!listaProcesos.isEmpty() && listaProcesos.get(0).getTiempoLlegada() <= tiempoActual) {
                    cola.add(listaProcesos.remove(0));
                }

                tiempoInicialSumado += (tiempoActual - tiempoInicio);
                // Si el proceso aún tiene tiempo restante, se añade al final de la cola
                if (procesoActual.getTiempoRestante() > 0) {

                    calculos.setTiempoEjecSumado(tiempoInicialSumado);
                    cola.add(procesoActual);
                } else {
                    if (cola.isEmpty()) {
                        procesoActual.setTiempoEjecSumado(tiempoEjecSumado-tiempoActual);
                    }
                    calculos.setTiempoEjecSumado(tiempoInicialSumado);
                    
                    setEjecucion(procesoActual.getNombreProceso(), tiempoActual);

                    procesosTerminados.add("Proceso " + procesoActual.getNombreProceso() + " completado en tiempo: " + tiempoActual);
                }
            } else {
                // Avanzar el tiempo si no hay procesos en la cola
                tiempoActual++;
            }
        }
    }

    /**
     *
     * @param nombre
     * @param ejec
     */
    public void setEjecucion(String nombre, int ejec) {
        for (Procesos procesos : calculosProceso) {
            if (procesos.getNombreProceso().equals(nombre)) {
                procesos.setTiempoEjecucion(ejec);
            }
        }

    }

    /**
     *
     */
    public void mostrarProcesosTerminados() {
        System.out.println("\n--- Procesos Completados ---");
        for (String proceso : procesosTerminados) {
            System.out.println(proceso);
        }
    }

    /**
     *
     */
    public void mostrarProcesos() {
        System.out.println("         ALGORITMO ROUND ROBIN");
        System.out.println("|Nombre Proceso  |  Tiempo de Llegada  |  CPU  |");
        System.out.println("--------------------------------------------------");

        for (Procesos proceso : listaProcesos) {
            System.out.println("|     " + proceso.getNombreProceso() + "      |         "
                    + proceso.getTiempoLlegada() + "         |      "
                    + proceso.getTiempoCPU() + "       |");
        }
        System.out.println("--------------------------------------------------");
    }

    /**
     *
     */
    public void tiempoSistema() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                        Tiempo Sistema");
        System.out.println("|Proceso | Tiempo Ejecución | Tiempo Llegada | T.Ej - T.Ll|");
        System.out.println("--------------------------------------------------------------------------");
        int tiempoSistemaTotal = 0;

        for (Procesos proceso : calculosProceso) {

            int tiempoSistema = proceso.getTiempoEjecucion() - proceso.getTiempoLlegada();

            System.out.println("|     " + proceso.getNombreProceso() + "       |        " + proceso.getTiempoEjecucion() + "         |       "
                    + proceso.getTiempoLlegada() + "       |       " + tiempoSistema + "         |");

            tiempoSistemaTotal += tiempoSistema;
        }

        System.out.println("--------------------------------------------------------------------------");
        double promedioTiempoSistema = calculosProceso.isEmpty() ? 0 : (double) tiempoSistemaTotal / calculosProceso.size();
        System.out.println("Promedio Tiempo Sistema: " + promedioTiempoSistema);
    }

    /**
     *
     */
    public void tiempoEspera2() {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("                        Tiempo Espera");
        System.out.println("|Proceso | Tiempo Inicio | Tiempo Llegada | Acumulado | ( T.Ini - T.Lleg )+Acumulado| ");
        System.out.println("--------------------------------------------------------------------------");

        int tiempoEsperaTotal = 0;

        for (Procesos proceso : calculosProceso) {

            int tiempoEspera = proceso.getTiempoinicial() - proceso.getTiempoLlegada();

            int tiempoFinal = (proceso.getTiempoEjecSumado()) + tiempoEspera;
            int acumulado = (proceso.getTiempoEjecSumado());

            System.out.println("|   " + proceso.getNombreProceso() + "   |     "
                    + proceso.getTiempoinicial() + "         |        " + proceso.getTiempoLlegada()
                    + "      |     " + acumulado + "     |       " + tiempoFinal + "       |     ");
            tiempoEsperaTotal += tiempoFinal;

        }

        System.out.println("--------------------------------------------------------------------------");
        double promedioTiempoEspera = calculosProceso.isEmpty() ? 0 : (double) tiempoEsperaTotal / calculosProceso.size();
        System.out.println("Promedio Tiempo de Espera: " + promedioTiempoEspera);
    }

}
