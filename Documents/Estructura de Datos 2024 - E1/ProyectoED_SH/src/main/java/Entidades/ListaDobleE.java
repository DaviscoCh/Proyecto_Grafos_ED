/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author hp
 */
public class ListaDobleE<T> {

    public NodoDoble<T> cabeza;
    public NodoDoble<T> cola;

    public ListaDobleE() {
        this.cabeza = null;
        this.cola = null;
    }

    public NodoDoble<T> getCabeza() {
        return cabeza;
    }

    public NodoDoble<T> getCola() {
        return cola;
    }

    public void insertarAlInicio(T dato) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.siguiente = cabeza;
            cabeza.anterior = nuevoNodo;
            cabeza = nuevoNodo;
        }
    }
    
    public NodoDoble<T> buscar(T dato) {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            if (actual.dato.equals(dato)) {
                return actual;
            }
            actual = actual.siguiente;
        }
        return null; // Retorna null si no se encuentra el dato
    }
    
    // Método para encontrar un bus por su número
    public T buscarPorNumero(String numeroBus) {
        NodoDoble<T> actual = cabeza;
        while (actual != null) {
            Bus bus = (Bus) actual.dato;
            if (bus.getNumeroBus().equals(numeroBus)) {
                return (T) bus;
            }
            actual = actual.siguiente;
        }
        return null; // Retorna null si no se encuentra el bus
    }

    // Método para agregar un nuevo bus al final de la lista
    public void insertarBus(T bus) {
        NodoDoble<T> nuevoNodo = new NodoDoble<>(bus);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.siguiente = nuevoNodo;
            nuevoNodo.anterior = cola;
            cola = nuevoNodo;
        }
    }
}