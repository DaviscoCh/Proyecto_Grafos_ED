/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 *
 * @author hp
 */
public class AlgoritmoE {

    public static class Resultado {
        private Map<Nodo, Integer> distancias;
        private Map<Nodo, Nodo> predecesores;

        public Resultado(Map<Nodo, Integer> distancias, Map<Nodo, Nodo> predecesores) {
            this.distancias = distancias;
            this.predecesores = predecesores;
        }

        public Map<Nodo, Integer> getDistancias() {
            return distancias;
        }

        public Map<Nodo, Nodo> getPredecesores() {
            return predecesores;
        }

        public List<Nodo> getRuta(Nodo destino) {
            List<Nodo> ruta = new ArrayList<>();
            for (Nodo nodo = destino; nodo != null; nodo = predecesores.get(nodo)) {
                ruta.add(nodo);
            }
            Collections.reverse(ruta);
            return ruta;
        }
    }

    public static Resultado dijkstra(List<Nodo> nodos, List<Enlace> enlaces, Nodo origen, Nodo destino) {
        Map<Nodo, Integer> distancias = new HashMap<>();
        Map<Nodo, Nodo> predecesores = new HashMap<>();
        PriorityQueue<Nodo> colaPrioridad = new PriorityQueue<>(Comparator.comparingInt(distancias::get));

        // Inicializar distancias
        for (Nodo nodo : nodos) {
            if (nodo.equals(origen)) {
                distancias.put(nodo, 0);
            } else {
                distancias.put(nodo, Integer.MAX_VALUE);
            }
            predecesores.put(nodo, null);
            colaPrioridad.add(nodo);
        }

        while (!colaPrioridad.isEmpty()) {
            Nodo actual = colaPrioridad.poll();

            for (Enlace enlace : enlaces) {
                if (enlace.getInicio().equals(actual)) {
                    Nodo vecino = enlace.getFin();
                    int nuevaDistancia = distancias.get(actual) + enlace.getPeso(); // Asegúrate de tener un método getPeso() en Enlace

                    if (nuevaDistancia < distancias.get(vecino)) {
                        distancias.put(vecino, nuevaDistancia);
                        predecesores.put(vecino, actual);
                        colaPrioridad.add(vecino);
                    }
                }
            }
        }

        return new Resultado(distancias, predecesores);
    }
}