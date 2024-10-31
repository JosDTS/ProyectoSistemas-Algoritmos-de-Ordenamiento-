/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmo_fifo;

import java.util.Comparator;
import java.util.ArrayList;

/**
 *
 * @author ESTUDIANTE
 */
public class Algorithm_FIFO {

    private ArrayList<Procesos> listaProcesos;  //Lista de los procesos
    private int tiempoActual; //tiempo actual
  

    public Algorithm_FIFO() {
        listaProcesos = new ArrayList<>();
        tiempoActual = 0;
      

    }

    //metodo  que agrega nuevos procesos en la lista de los procesos. 
    public void añadirProceso(Procesos proceso) {
        listaProcesos.add(proceso);

    }

    public void ejecutarProceso() {
        for (int i = 0; i < listaProcesos.size() - 1; i++) {
            for (int j = 0; j < listaProcesos.size() - 1 - i; j++) {

                if (listaProcesos.get(j).getTiempoLlegada() > listaProcesos.get(j + 1).getTiempoLlegada()) {
                    Procesos temporal = listaProcesos.get(j);
                    listaProcesos.set(j, listaProcesos.get(j + 1));
                    listaProcesos.set(j + 1, temporal);
                }

            }

        }

        ArrayList<String> procesosTerminados = new ArrayList<>();
        System.out.println("            ALGORITMO FIFO");
        System.out.println("|Nombre Proceso | Tiempo de Llegada | CPU |");
        System.out.println("-------------------------------------------------");

           
            int tiempoEjecucionFinal = 0;
        for (Procesos proceso : listaProcesos) {
            if (tiempoActual < proceso.getTiempoLlegada()) {
                tiempoActual = proceso.getTiempoLlegada();
            }
            int tiempoInicial = tiempoActual;
            tiempoEjecucionFinal += proceso.getTiempoCPU(); 
            tiempoActual+= proceso.getTiempoCPU(); 

            System.out.println("|     " + proceso.getNombreProceso() + "      |         "
                    + proceso.getTiempoLlegada() + "         |      "
                    + proceso.getTiempoCPU() + "       |");

            procesosTerminados.add("Proceso: " + proceso.getNombreProceso() + " Tiempo Inicio: " + tiempoInicial + " Tiempo Ejecucion: " + tiempoEjecucionFinal);
        }

        System.out.println("----------------------------------------------");

        for (String listaFinalizado : procesosTerminados) {
            System.out.println(listaFinalizado);
        }
    }

    public void tiempoSistema() {
        System.out.println("Tiempo Sistema");
        System.out.println("|Proceso | Tiempo Ejecución | Tiempo Llegada | T.Ej - T.Ll|");
        System.out.println("--------------------------------------------------------------------------");

        int tiempoSistemaTotal = 0;
        int tiempoEjecucion = 0; 
        for (Procesos proceso : listaProcesos) {
           
            tiempoEjecucion += proceso.getTiempoCPU(); 
            int tiempoLlegada = proceso.getTiempoLlegada();
            int tiempoSistema = tiempoEjecucion - tiempoLlegada;

            System.out.println("|      " + proceso.getNombreProceso() + "       |        " + tiempoEjecucion + "         |       "
                    + tiempoLlegada + "       |       " + tiempoSistema + "         |");

            tiempoSistemaTotal += tiempoSistemaTotal;
        }

        System.out.println("------------------------------------------------------------------------");

        double promedioTiempoSistema = (double) tiempoSistemaTotal / listaProcesos.size();
        System.out.println("Pormedio Tiempo Sistema: " + promedioTiempoSistema);
    }

}

