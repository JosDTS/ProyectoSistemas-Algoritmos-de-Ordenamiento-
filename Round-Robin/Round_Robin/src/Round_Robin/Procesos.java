/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Round_Robin;

/**
 *
 * Clase que tiene dos constructores de procesos y metodos getter y setter
 *
 * @author Jeison Alvarez
 * @author Joselyn Abarca
 * @author Adrian Chavarria
 * @author Katlyn Lopez
 */
public class Procesos {

    private String nombreProceso;
    private int tiempoLlegada;
    private int tiempoCPU;
    private int tiempoRestante;
    private int tiempoEjecucion;
    private int tiempoinicial;
    private int tiempoInicialSumado;
    private int tiempoEjecSumado;

    /**
     * Constructor usado al crear la lista de procesos
     *
     * @param nombreProceso
     * @param tiempoLllegada
     * @param tiempoCPU
     * @param tiempoEjecucion
     * @param tiempoInicial
     */
    public Procesos(String nombreProceso, int tiempoLllegada, int tiempoCPU, int tiempoEjecucion, int tiempoInicial) {
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLllegada;
        this.tiempoCPU = tiempoCPU;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoCPU;
        this.tiempoinicial = tiempoInicial;
    }

    /**
     * Constructor usado a la hora de armar el diagrama de Gahn
     *
     * @param nombreProceso
     * @param tiempoLlegada
     * @param tiempoCPU
     * @param tiempoEjecucion
     * @param tiempoinicial
     * @param tiempoEjecS
     */
    public Procesos(String nombreProceso, int tiempoLlegada, int tiempoCPU, int tiempoEjecucion, int tiempoinicial, int tiempoEjecS) {
        this.nombreProceso = nombreProceso;
        this.tiempoLlegada = tiempoLlegada;
        this.tiempoCPU = tiempoCPU;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoinicial = tiempoinicial;
        this.tiempoEjecSumado = tiempoEjecS;
    }

    /**
     * Constructor vacio
     */
    public Procesos() {
    }

    /**
     *
     * @return
     */
    public String getNombreProceso() {
        return nombreProceso;
    }

    /**
     *
     * @param nombreProceso
     */
    public void setNombreProceso(String nombreProceso) {
        this.nombreProceso = nombreProceso;
    }

    /**
     *
     * @return
     */
    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    /**
     *
     * @param tiempoLlegada
     */
    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    /**
     *
     * @return
     */
    public int getTiempoCPU() {
        return tiempoCPU;
    }

    /**
     *
     * @param tiempoCPU
     */
    public void setTiempoCPU(int tiempoCPU) {
        this.tiempoCPU = tiempoCPU;
    }

    /**
     *
     * @return
     */
    public int getTiempoRestante() {
        return tiempoRestante;
    }

    /**
     *
     * @param tiempoRestante
     */
    public void setTiempoRestante(int tiempoRestante) {
        this.tiempoRestante = tiempoRestante;
    }

    /**
     *
     * @return
     */
    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    /**
     *
     * @param tiempoEjecucion
     */
    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }

    /**
     *
     * @return
     */
    public int getTiempoinicial() {
        return tiempoinicial;
    }

    /**
     *
     * @param tiempoinicial 
     */
    public void setTiempoinicial(int tiempoinicial) {
        this.tiempoinicial = tiempoinicial;
    }

    /**
     *
     * @return
     */
    public int getTiempoEspera() {
        return tiempoInicialSumado;
    }

    /**
     * \
     *
     * @param tiempoEspera
     */
    public void setTiempoEspera(int tiempoEspera) {
        this.tiempoInicialSumado = tiempoEspera;
    }

    /**
     * \
     *
     * @return
     */
    public int getTiempoInicialSumado() {
        return tiempoInicialSumado;
    }

    /**
     *
     * @param tiempoInicialSumado
     */
    public void setTiempoInicialSumado(int tiempoInicialSumado) {
        this.tiempoInicialSumado = tiempoInicialSumado;
    }

    /**
     *
     * @return
     */
    public int getTiempoEjecSumado() {
        return tiempoEjecSumado;
    }

    /**
     *
     * @param tiempoEjecSumado
     */
    public void setTiempoEjecSumado(int tiempoEjecSumado) {
        this.tiempoEjecSumado = tiempoEjecSumado;

    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Procesos{" + "nombreProceso=" + nombreProceso + ", tiempoLllegada=" + tiempoLlegada + ", tiempoCPU=" + tiempoCPU + '}';
    }

}
