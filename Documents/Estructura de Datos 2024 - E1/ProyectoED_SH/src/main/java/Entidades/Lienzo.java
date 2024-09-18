/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Formulario.Principal;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author hp
 */
public class Lienzo extends JPanel implements MouseListener, MouseMotionListener {

    private Vector<Nodo> vectorNodos;
    private Vector<Enlace> vectorEnlace;
    private Point p1, p2;//Almacenara
    private Nodo nodoMover;
    private int iNodo;
    private Principal pr;

    public Lienzo(Principal pr) {
        this.vectorNodos = new Vector<>();
        this.vectorEnlace = new Vector<>();
        this.pr = pr;
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        setOpaque(false); // Hacer que el JPanel sea transparente para ver la imagen debajo
    }

    //Etiquetas
    private void mostrarTooltip(int mouseX, int mouseY) {
        for (Nodo nodo : vectorNodos) {
            if (estaSobreNodo(mouseX, mouseY, nodo)) {
                setToolTipText(nodo.getTooltip());
                return;
            }
        }
        setToolTipText(null); // Oculta el tooltip si no está sobre ningún nodo
    }

    private boolean estaSobreNodo(int mouseX, int mouseY, Nodo nodo) {
        int radio = nodo.getD() / 2;
        return mouseX >= nodo.getX() - radio && mouseX <= nodo.getX() + radio
                && mouseY >= nodo.getY() - radio && mouseY <= nodo.getY() + radio;
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        for (Nodo nodos : vectorNodos) {
            nodos.Pintar(g);
        }
        for (Enlace enlace : vectorEnlace) {
            enlace.pintar(g);
        }
    }

    public void reiniciar() {
        vectorNodos.clear();
        vectorEnlace.clear();
        repaint();
    }

    public void addNodo(Nodo nodo) {
        this.vectorNodos.add(nodo);
        repaint();
    }

    public void addArista(Enlace enlace) {
        this.vectorEnlace.add(enlace);
        repaint();
    }

    public Vector<Nodo> getVectorNodos() {
        return vectorNodos;
    }

    public Vector<Enlace> getVectorEnlace() {
        return vectorEnlace;
    }

    public Nodo getNodoPorPosicion(int x, int y) {
        for (Nodo nodo : vectorNodos) {
            if (nodo.getX() == x && nodo.getY() == y) {
                return nodo;
            }
        }
        return null;
    }

    //Agregar
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            JOptionPane.showMessageDialog(null, "Por favor Proceda a llenar la casilla del destino");
            pr.habilitarCampos(e.getX(), e.getY());
            repaint();
        }
        if (e.getButton() == MouseEvent.BUTTON3) {
            for (Nodo nodo : vectorNodos) {
                int nodoD = nodo.getD(); // Obtener el diámetro del nodo
                if (new Rectangle(nodo.getX() - nodoD / 2, nodo.getY() - nodoD / 2, nodoD, nodoD).contains(e.getPoint())) {
                    if (p1 == null) {
                        p1 = new Point(nodo.getX(), nodo.getY());
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor Proceda a llenar la casilla del enlace");
                        p2 = new Point(nodo.getX(), nodo.getY());
                        pr.habilitarCampos2(p1.x, p1.y, p2.x, p2.y);
                        repaint();
                        p1 = null;
                        p2 = null;
                    }
                }
            }
        }
    }

    //Presiona
    @Override
    public void mousePressed(MouseEvent e) {
        int iN = 0;
        for (Nodo nodo : vectorNodos) {
            int nodoD = nodo.getD(); // Obtener el diámetro del nodo
            if (new Rectangle(nodo.getX() - nodoD / 2, nodo.getY() - nodoD / 2, nodoD, nodoD).contains(e.getPoint())) {
                nodoMover = nodo;
                iNodo = iN;
                break;
            }
            iN++;
        }
    }

    //Fin del Movimiento
    @Override
    public void mouseReleased(MouseEvent e) {
        nodoMover = null;
        iNodo = -1;
    }

    @Override
    public void mouseEntered(MouseEvent e
    ) {
    }

    @Override
    public void mouseExited(MouseEvent e
    ) {
    }

    //MOver
    @Override
    public void mouseDragged(MouseEvent e) {
        if (nodoMover != null) {
            int nodoD = nodoMover.getD();
            Nodo nuevoNodo = new Nodo(e.getX(), e.getY(), nodoMover.getNombre(), true, Color.BLACK, Color.BLACK, "");
            this.vectorNodos.set(iNodo, nuevoNodo);

            int iE = 0;
            for (Enlace enlace : vectorEnlace) {
                if (new Rectangle(enlace.getX1() - nodoD / 2, enlace.getY1() - nodoD / 2, nodoD, nodoD).contains(e.getPoint())) {
                    this.vectorEnlace.set(iE, new Enlace(nuevoNodo, enlace.getFin(), e.getX(), e.getY(), enlace.getX2(), enlace.getY2(), enlace.getNombre(), enlace.getColorLinea(), enlace.getColorTexto(), enlace.getPeso()));
                } else if (new Rectangle(enlace.getX2() - nodoD / 2, enlace.getY2() - nodoD / 2, nodoD, nodoD).contains(e.getPoint())) {
                    this.vectorEnlace.set(iE, new Enlace(enlace.getInicio(), nuevoNodo, enlace.getX1(), enlace.getY1(), e.getX(), e.getY(), enlace.getNombre(), enlace.getColorLinea(), enlace.getColorTexto(), enlace.getPeso()));
                }
                iE++;
            }
        }
        repaint();
    }

    //ToolTip
    @Override
    public void mouseMoved(MouseEvent e) {
        mostrarTooltip(e.getX(), e.getY());
    }

}
