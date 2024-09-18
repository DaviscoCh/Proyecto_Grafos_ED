/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class NodoLE<T> {

    T dato;
    NodoLE<T> siguiente;

    public NodoLE(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoLE<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoLE<T> siguiente) {
        this.siguiente = siguiente;
    }
    
}
