/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class NodoC<T> {
    T dato;
    NodoC<T> siguiente;

    public NodoC(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
