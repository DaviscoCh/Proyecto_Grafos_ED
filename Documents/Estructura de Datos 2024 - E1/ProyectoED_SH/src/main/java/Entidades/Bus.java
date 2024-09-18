/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class Bus {

    private String NumeroBus;
    private int kilometrosRecorridos;
    private double TiempoTranscurrido;
    private String HorasLaborales;
    private int CPasajeros;
    private double GananciaTotal;

    public Bus() {
        this.NumeroBus = "";
    }

    public Bus(String NumeroBus, int kilometrosRecorridos, double TiempoTranscurrido, String HorasLaborales, int CPasajeros, double GananciaTotal) {
        this.NumeroBus = NumeroBus;
        this.kilometrosRecorridos = kilometrosRecorridos;
        this.TiempoTranscurrido = TiempoTranscurrido;
        this.HorasLaborales = HorasLaborales;
        this.CPasajeros = CPasajeros;
        this.GananciaTotal = GananciaTotal;
    }

    public String getNumeroBus() {
        return NumeroBus;
    }

    public void setNumeroBus(String NumeroBus) {
        this.NumeroBus = NumeroBus;
    }

    public int getKilometrosRecorridos() {
        return kilometrosRecorridos;
    }

    public void setKilometrosRecorridos(int kilometrosRecorridos) {
        this.kilometrosRecorridos = kilometrosRecorridos;
    }

    public double getTiempoTranscurrido() {
        return TiempoTranscurrido;
    }

    public void setTiempoTranscurrido(double TiempoTranscurrido) {
        this.TiempoTranscurrido = TiempoTranscurrido;
    }

    public String getHorasLaborales() {
        return HorasLaborales;
    }

    public void setHorasLaborales(String HorasLaborales) {
        this.HorasLaborales = HorasLaborales;
    }

    public int getCPasajeros() {
        return CPasajeros;
    }

    public void setCPasajeros(int CPasajeros) {
        this.CPasajeros = CPasajeros;
    }

    public double getGananciaTotal() {
        return GananciaTotal;
    }

    public void setGananciaTotal(double GananciaTotal) {
        this.GananciaTotal = GananciaTotal;
    }
}
