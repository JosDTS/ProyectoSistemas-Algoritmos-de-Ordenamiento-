/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package algoritmo_fifo;

/**
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez
 */
public class Procesos {
    
    private String nombreProceso; 
    private int tiempoLlegada; //Timpo de Llegada del proceso
    private int tiempoCPU; //tiempo de CPU 

    public Procesos(String nombreProceso, int tiempoLllegada, int tiempoCPU) {
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLllegada;
        this.tiempoCPU = tiempoCPU;
    }

    public Procesos() {
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

    @Override
    public String toString() {
        return "Procesos{" + "nombreProceso=" + nombreProceso + ", tiempoLllegada=" + tiempoLlegada + ", tiempoCPU=" + tiempoCPU + '}';
    }

}
