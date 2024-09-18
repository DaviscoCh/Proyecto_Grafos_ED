/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author hp
 */
public class Nodo {

    private int x, y;
    private String nombre;
    private boolean esCiudad;
    public int d = 10;
    private Color colorFondo;
    private Color colorTexto;
    private Font font;
    private String tooltip; // Nueva variable para almacenar el tooltip

    public Nodo(int x, int y, String nombre, boolean esCiudad, Color colorFondo, Color colorTexto, String tooltip) {
        this.x = x;
        this.y = y;
        this.nombre = nombre;
        this.d = esCiudad ? 10 : 8; // Tamaño diferente según el tipo
        this.colorFondo = esCiudad ? Color.BLUE : Color.RED; // Color diferente según el tipo
        this.colorTexto = Color.BLACK; // Color del texto
        this.font = new Font("Verdana", esCiudad ? Font.BOLD : Font.PLAIN, esCiudad ? 10 : 8);
        this.tooltip = "";
    }
    
    public String getTooltip() {
        return tooltip;
    }

    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    public Color getColorFondo() {
        return colorFondo;
    }

    public void setColorFondo(Color colorFondo) {
        this.colorFondo = colorFondo;
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    // Método para verificar si es ciudad
    public boolean isEsCiudad() {
        return esCiudad;
    }

    public void setEsCiudad(boolean esCiudad) {
        this.esCiudad = esCiudad;
    }

    // Método para obtener el diámetro
    public int getD() {
        return d;
    }

    public void Pintar(Graphics g) {
        g.setColor(colorFondo);
        g.fillOval(x - d / 2, y - d / 2, d, d);

        g.setColor(Color.BLACK);
        g.drawOval(x - d / 2, y - d / 2, d, d);

        g.setFont(font); // Aplicar la fuente antes de dibujar el texto
        g.setColor(colorTexto);
        g.drawString(nombre, x + d / 2, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean contains(int px, int py) {
        // Cálculo de la distancia desde el centro del nodo al punto
        double distance = Math.sqrt(Math.pow(px - (x + d / 2), 2) + Math.pow(py - (y + d / 2), 2));
        return distance <= d / 2;
    }

}
