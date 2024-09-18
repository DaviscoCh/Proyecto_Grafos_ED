/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author hp
 */
public class ListaCircular<T> {

    private NodoC<T> cabeza;
    private NodoC<T> ultimo;

    public ListaCircular() {
        this.cabeza = null;
        this.ultimo = null;
    }

    public void insertar(T dato) {
        NodoC<T> nuevo = new NodoC<>(dato);
        if (ultimo == null) {
            ultimo = nuevo;
            ultimo.siguiente = ultimo;
        } else {
            nuevo.siguiente = ultimo.siguiente;
            ultimo.siguiente = nuevo;
            ultimo = nuevo;
        }
    }
}
