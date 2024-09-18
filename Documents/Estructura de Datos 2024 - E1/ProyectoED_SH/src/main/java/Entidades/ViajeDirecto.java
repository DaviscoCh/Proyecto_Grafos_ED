/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class ViajeDirecto {
    private String NBus;
    private String partida;
    private String destino;
    private String HoraSalida;
    private String HoraRetorno;
    private int kilometros;
    private double tarifa;
    private int tiempo;
    private int CPasajeros;

    public ViajeDirecto() {
    }

    public ViajeDirecto(String NBus, String partida, String destino, String HoraSalida, String HoraRetorno, int kilometros, double tarifa, int tiempo, int CPasajeros) {
        this.NBus = NBus;
        this.partida = partida;
        this.destino = destino;
        this.HoraSalida = HoraSalida;
        this.HoraRetorno = HoraRetorno;
        this.kilometros = kilometros;
        this.tarifa = tarifa;
        this.tiempo = tiempo;
        this.CPasajeros = CPasajeros;
    }

    public String getNBus() {
        return NBus;
    }

    public void setNBus(String NBus) {
        this.NBus = NBus;
    }

    public String getPartida() {
        return partida;
    }

    public void setPartida(String partida) {
        this.partida = partida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getHoraSalida() {
        return HoraSalida;
    }

    public void setHoraSalida(String HoraSalida) {
        this.HoraSalida = HoraSalida;
    }

    public String getHoraRetorno() {
        return HoraRetorno;
    }

    public void setHoraRetorno(String HoraRetorno) {
        this.HoraRetorno = HoraRetorno;
    }

    public int getKilometros() {
        return kilometros;
    }

    public void setKilometros(int kilometros) {
        this.kilometros = kilometros;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getCPasajeros() {
        return CPasajeros;
    }

    public void setCPasajeros(int CPasajeros) {
        this.CPasajeros = CPasajeros;
    }
    
    
}
