/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prioridad;

/**
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez 
 * Clase que representa un proceso dentro del algoritmo de
 * planificación. Contiene información sobre el nombre, tiempo de llegada,
 * tiempo de CPU y prioridad.
 */
class Proceso {

    String nombreProceso;
    int tiempoLlegada;
    int tiempoCPU;
    int prioridad;

    /**
     * Constructor para crear un nuevo proceso.
     *
     * @param nombreProceso Nombre del proceso.
     * @param tiempoLlegada Tiempo de llegada del proceso al sistema.
     * @param tiempoCPU Tiempo de CPU requerido por el proceso.
     * @param prioridad Prioridad del proceso ( donde el menor valor indica
     * mayor prioridad).
     */
    public Proceso(String nombreProceso, int tiempoLlegada, int tiempoCPU, int prioridad) {
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoCPU = tiempoCPU;
        this.prioridad = prioridad;
    }

    public String getNombreProceso() {
        return nombreProceso;
    }

    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    public int getTiempoCPU() {
        return tiempoCPU;
    }

    public void setTiempoCPU(int tiempoCPU) {
        this.tiempoCPU = tiempoCPU;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

}
