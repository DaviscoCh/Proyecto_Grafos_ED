/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author hp
 */
public class Enlace {

    private Nodo inicio;
    private Nodo fin;
    private int x1, y1, x2, y2;
    private String nombre;
    private Color colorLinea;
    private Color colorTexto;
    private static final Font FUENTE = new Font("Trebuchet MS", Font.PLAIN, 10); // Fuente más pequeña
    private int peso;

    public Enlace() {
    }

    public Enlace(Nodo inicio, Nodo fin, int x1, int y1, int x2, int y2, String nombre, Color colorLinea, Color colorTexto, int peso) {
        this.inicio = inicio;
        this.fin = fin;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.nombre = nombre;
        this.colorLinea = colorLinea;
        this.colorTexto = colorTexto;
        this.peso = peso;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public Color getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(Color colorLinea) {
        this.colorLinea = colorLinea;
    }

    public Color getColorTexto() {
        return colorTexto;
    }

    public void setColorTexto(Color colorTexto) {
        this.colorTexto = colorTexto;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public void pintar(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(1));  // Grosor de la línea

        // Dibujar la línea con el color especificado
        g2.setColor(colorLinea);
        g2.drawLine(x1, y1, x2, y2);

        // Dibujar la flecha
        drawArrow(g, x1, y1, x2, y2);

        // Dibujar el texto de la arista con el color especificado
        g2.setFont(FUENTE);
        g2.setColor(colorTexto);
        if (x1 > x2 && y1 > y2) {
            g.drawString(nombre, x1 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 < y2) {
            g.drawString(nombre, x2 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 > x2 && y1 < y2) {
            g.drawString(nombre, x1 - Math.abs((x1 - x2) / 2), y2 - Math.abs((y1 - y2) / 2));
        }
        if (x1 < x2 && y1 > y2) {
            g.drawString(nombre, x2 - Math.abs((x1 - x2) / 2), y1 - Math.abs((y1 - y2) / 2));
        }
        // Dibujar la línea con el color especificado
        g.setColor(colorLinea);
        g.drawLine(x1, y1, x2, y2);

        // Dibujar la flecha
        drawArrow(g, x1, y1, x2, y2);

        // Dibujar el texto de la arista con el color especificado
        g.setFont(FUENTE);
        g.setColor(colorTexto);
    }

    private void drawArrow(Graphics g, int x1, int y1, int x2, int y2) {
        Graphics2D g2d = (Graphics2D) g.create();

        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowHeadLength = 10;
        int arrowHeadWidth = 5;

        int xArrow1 = (int) (x2 - arrowHeadLength * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowHeadLength * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowHeadLength * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowHeadLength * Math.sin(angle + Math.PI / 6));

        g2d.drawLine(x1, y1, x2, y2);
        g2d.drawLine(x2, y2, xArrow1, yArrow1);
        g2d.drawLine(x2, y2, xArrow2, yArrow2);

        g2d.dispose();
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
