/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import static java.nio.file.Files.size;

/**
 *
 * @author hp
 */
public class Lista_Enlazada<T> {

    public NodoLE<T> cabeza;

    public Lista_Enlazada() {
        this.cabeza = null;
    }

    public NodoLE<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoLE<T> cabeza) {
        this.cabeza = cabeza;
    }

    // Método para insertar un nodo al inicio de la lista
    public void ingresar(T data) {
        NodoLE<T> newNode = new NodoLE<>(data);
        if (cabeza == null) {
            cabeza = newNode;
        } else {
            NodoLE<T> current = cabeza;
            while (current.getSiguiente()!= null) {
                current = current.getSiguiente();
            }
            current.setSiguiente(newNode);
        }
    }
}