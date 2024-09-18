/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Formulario;

import Entidades.AlgoritmoE;
import Entidades.Bus;
import Entidades.Enlace;
import Entidades.Lienzo;
import Entidades.ListaCircular;
import Entidades.ListaDobleE;
import Entidades.Lista_Enlazada;
import Entidades.Nodo;
import Entidades.ViajeDirecto;
import Entidades.ViajeIndirecto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class Principal extends javax.swing.JFrame {

    private Lienzo lienzo;
    private int clickX, clickY;
    private int clickX1, clickY1, clickX2, clickY2;
    private DefaultTableModel model;
    private DefaultTableModel model2;
    private DefaultTableModel model3;
    private Lista_Enlazada<ViajeDirecto> viajesDirectos;
    private ListaCircular<ViajeIndirecto> viajesIndirectos;
    private ListaDobleE<Bus> InfoBus;
    private boolean esCiudad;
    private boolean esViajeDirecto;
    private DecimalFormat df;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        setSize(895, 522);
        inicializarLienzo();
        inicializarNodos();
        inicializarTablas();
        deshabilitarCampos();
        setLocationRelativeTo(this);

        esCiudad = true;
        viajesDirectos = new Lista_Enlazada<>();
        viajesIndirectos = new ListaCircular<>();
        InfoBus = new ListaDobleE<>();
        df = new DecimalFormat("#,##0.00");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.US));
    }

    private void inicializarTablas() {
        String ViajesDirectos[] = {"Numero Bus", "Partida", "Destino", "Hora de Salida", "Hora de Retorno", "Kilometros", "Tarifa", "Tiempo", "CantP"};
        model = new DefaultTableModel();
        model.setColumnIdentifiers(ViajesDirectos);
        jTable1.setModel(model);

        // Hacer jTable1 y sus componentes no opacos
        jTable1.setOpaque(false);
        jTable1.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(255, 255, 255, 150)); // Fondo blanco con opacidad ajustada
                return c;
            }
        });
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        // Deshabilitar líneas de cuadrícula
        jTable1.setShowGrid(false);

        String ViajesInDirectos[] = {"Numero Bus", "Partida", "Destino", "Hora de Salida", "Hora de Retorno", "Kilometros", "Tarifa", "Tiempo", "CantP"};
        model2 = new DefaultTableModel();
        model2.setColumnIdentifiers(ViajesInDirectos);
        jTable2.setModel(model2);

        // Hacer jTable1 y sus componentes no opacos
        jTable2.setOpaque(false);
        jTable2.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(255, 255, 255, 150)); // Fondo blanco con opacidad ajustada
                return c;
            }
        });
        jScrollPane2.setOpaque(false);
        jScrollPane2.getViewport().setOpaque(false);

        // Deshabilitar líneas de cuadrícula
        jTable2.setShowGrid(false);

        String InformacionBuses[] = {"Numero Bus", "Kilometros Recorridos", "Tiempo Transcurrido", "Horas Laborales", "Cantidad de Pasajeros", "Ganancia Total"};
        model3 = new DefaultTableModel();
        model3.setColumnIdentifiers(InformacionBuses);
        jTable3.setModel(model3);

        // Hacer jTable1 y sus componentes no opacos
        jTable3.setOpaque(false);
        jTable3.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setBackground(new Color(255, 255, 255, 150)); // Fondo blanco con opacidad ajustada
                return c;
            }
        });
        jScrollPane3.setOpaque(false);
        jScrollPane3.getViewport().setOpaque(false);

        // Deshabilitar líneas de cuadrícula
        jTable3.setShowGrid(false);
    }

    private void inicializarNodos() {
        Nodo ciudad1 = new Nodo(180, 140, "Machala", true, Color.BLUE, Color.BLACK, "");
        ciudad1.setTooltip("<html>Machala: Capital de la Provincia del Oro<br>"
                + "Sus sectores principales son:<br>Puerto Bolivar<br>"
                + "UTMACH<br>Terminal Terrestre"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\parque-juan-montalvo2.jpg'</html>");
        Nodo ciudad2 = new Nodo(170, 240, "Santa Rosa", true, Color.BLUE, Color.BLACK, "");
        ciudad2.setTooltip("<html>Santa Rosa: El cantón Santa Rosa es una<br> "
                + "entidad territorial subnacional ecuatoriana."
                + "<br>Sus sectores principales son:<br>BellaMaria<br>La Avanzada"
                + "<br>BellaVista"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Santa Rosa2.jpg'></html>");
        Nodo ciudad3 = new Nodo(260, 170, "Pasaje", true, Color.BLUE, Color.BLACK, "");
        ciudad3.setTooltip("<html>Pasaje: Pasaje, también conocida<br> "
                + "como Pasaje de las Nieves es una ciudad ecuatoriana;<br> "
                + "cabecera cantonal del Cantón Pasaje, así como la<br> "
                + "segunda urbe más grande y poblada de la Provincia de El Oro.<br>  "
                + "Sus sectores principales son:<br>La Peaña<br>"
                + "BuenaVista<br>CañaQuemada"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Pasaje2.jpg'></html>");
        Nodo ciudad4 = new Nodo(270, 60, "El Guabo", true, Color.BLUE, Color.BLACK, "");
        ciudad4.setTooltip("<html>El Guabo: Es popularmente llamada \"La Perla Orense\".<br> "
                + "En el censo de 2022 tenía una población de 26.635 habitantes, lo que<br> "
                + "la convierte en la quincuagésima séptima ciudad más poblada del país.<br> "
                + "Sus sectores principales son:<br>La Iberia<br>"
                + "Rio Bonito<br>Tendales"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\El Guabo2.jpg'></html>");
        Nodo ciudad5 = new Nodo(65, 200, "Huaquillas", true, Color.BLUE, Color.BLACK, "");
        ciudad5.setTooltip("<html>Huaquillas: Es llamada \"Centinela sin relevo\" por<br> "
                + "su situación geográfica y sus antecedentes históricos en la defensa<br> "
                + "de la nación de los conflictos con Perú.<br> "
                + "Sus sectores principales son:<br>Hualtaco<br>"
                + "Union Lojana<br>El Paraiso"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Huaquillas2.png'></html>");
        Nodo ciudad6 = new Nodo(80, 280, "Arenillas", true, Color.BLUE, Color.BLACK, "");
        ciudad6.setTooltip("<html>Arenillas: Arenillas es un cantón de la provincia de<br>"
                + " El Oro. Su capital es Arenillas, ciudad que de acuerdo con el censo<br>"
                + " del año 2011 tiene una población de poco menos de 26000.<br>"
                + "Sus sectores principales son:<br>Chacras<br>"
                + "Palmales<br>Carcabon"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\arenillas2.jpg'></html>");
        Nodo ciudad7 = new Nodo(100, 380, "Las Lajas", true, Color.BLUE, Color.BLACK, "");
        ciudad7.setTooltip("<html>Las Lajas: El Cantón Las Lajas es un cantón de la provincia<br>"
                + "de El Oro. Su cabecera cantonal es la ciudad de La Victoria. Su población<br>"
                + "es de 4.794 habitantes,1​ tiene una superficie de 297 km². <br>"
                + "Sus sectores principales son:<br>La Victoria<br>"
                + "El Paraiso<br>La Libertad"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Las Lajas2.jpg'></html>");
        Nodo ciudad8 = new Nodo(180, 370, "Marcabeli", true, Color.BLUE, Color.BLACK, "");
        ciudad8.setTooltip("<html>Marcabeli: El Cantón Marcabelí está ubicado al sur de la<br> "
                + "provincia de El Oro. Es un lugar reconocido por su abundante vegetación,<br> "
                + "donde nos encontraremos con el popular Balneario llamado La Chorrera<br>"
                + "Sus sectores principales son:<br>El Ingenio<br>"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Marcabeli2.jpg'></html>");
        Nodo ciudad9 = new Nodo(240, 350, "Balsas", true, Color.BLUE, Color.BLACK, "");
        ciudad9.setTooltip("<html>Balsas: Balsas es un cantón situado en la Provincia de<br> "
                + "El Oro1​, en el Ecuador. Su nombre se deriva de la abundancia de árboles<br> "
                + "de balsa que históricamente han caracterizado la región.<br> "
                + "Sus sectores principales son:<br>La Esperanza<br>"
                + "El Palmal<br>San Jose"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Balsas2.jpg'></html>");
        Nodo ciudad10 = new Nodo(260, 300, "Piñas", true, Color.BLUE, Color.BLACK, "");
        ciudad10.setTooltip("<html>Piñas: La cabecera del cantón es la ciudad de Piñas<br>​ "
                + "comparten el apodo de «La Orquídea de los Andes» debido a la gran variedad<br>"
                + " de orquídeas silvestres encontradas en esta región del Ecuador meridional<br> "
                + "Sus sectores principales son:<br>Moro Moro<br>"
                + "El Cisne<br>La Merced"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Piñas2.jpg'></html>");
        Nodo ciudad11 = new Nodo(270, 250, "Atahualpa", true, Color.BLUE, Color.BLACK, "");
        ciudad11.setTooltip("<html>Atahualpa: Es uno de los cantones más importantes de El Oro,<br> "
                + "Antes de la llegada de los españoles, ya existieron asentamientos indígenas<br> "
                + "de ascendencia cañaris.<br>"
                + "Sus sectores principales son:<br>Paccha<br>"
                + "San Jose<br>San Juan"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Atahualpa2.jpg'></html>");
        Nodo ciudad12 = new Nodo(350, 340, "Portovelo", true, Color.BLUE, Color.BLACK, "");
        ciudad12.setTooltip("<html>Portovelo:Portovelo es un cantón de la Provincia de El Oro,<br> "
                + "en Ecuador. Conocido como “El Primer Centro Minero del Ecuador”, contiene<br> "
                + "4 parroquias.<br> "
                + "Sus sectores principales son:<br>Morales<br>"
                + "Salatí<br>CURTINCAPAC"
                + "<br><div style='text-align: center;'><img src='file:/C:\\Users\\hp\\Desktop\\Imagenes para Apache Netbeans IDE 21\\Portovelo2.jpg'></html>");

        lienzo.addNodo(ciudad1);
        lienzo.addNodo(ciudad2);
        lienzo.addNodo(ciudad3);
        lienzo.addNodo(ciudad4);
        lienzo.addNodo(ciudad5);
        lienzo.addNodo(ciudad6);
        lienzo.addNodo(ciudad7);
        lienzo.addNodo(ciudad8);
        lienzo.addNodo(ciudad9);
        lienzo.addNodo(ciudad10);
        lienzo.addNodo(ciudad11);
        lienzo.addNodo(ciudad12);
    }

    // Método para encontrar la fila del bus en jTable3
    private int EncontrarFilaBus(String busNumber) {
        for (int i = 0; i < model3.getRowCount(); i++) {
            if (model3.getValueAt(i, 0).equals(busNumber)) {
                return i;
            }
        }
        return -1; // Retorna -1 si no se encuentra el bus
    }

    private void ActualizarTablaBus(Bus bus) {
        int row = EncontrarFilaBus(bus.getNumeroBus());
        if (row != -1) {
            model3.setValueAt(bus.getKilometrosRecorridos(), row, 1);
            model3.setValueAt(bus.getTiempoTranscurrido(), row, 2);
            model3.setValueAt(bus.getHorasLaborales(), row, 3);
            model3.setValueAt(bus.getCPasajeros(), row, 4);
            String gananciaFormateada = String.format(Locale.US, "%.2f", bus.getGananciaTotal());
            model3.setValueAt(gananciaFormateada, row, 5);
        } else {
            model3.addRow(new Object[]{
                bus.getNumeroBus(), bus.getKilometrosRecorridos(), bus.getTiempoTranscurrido(),
                bus.getHorasLaborales(), bus.getCPasajeros(), df.format(bus.getGananciaTotal())
            });
        }
    }

    public void agregarVD(String NBus, String inicio, String destino, String horaSalida, String horaLlegada, int kilometros, double tarifa, int tiempo, int cantp) {
        // Agregar a la lista de viajes

        ViajeDirecto ViajeD = new ViajeDirecto(NBus, inicio, destino, horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp);
        viajesDirectos.ingresar(ViajeD);

        // Agregar al modelo de la tabla
        model.addRow(new Object[]{NBus, inicio, destino, horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp});
        lienzo.repaint();
    }

    public void agregarVID(String NBus, String inicio, String destino, String horaSalida, String horaLlegada, int kilometros, double tarifa, int tiempo, int cantp) {

        ViajeIndirecto viajeID = new ViajeIndirecto(NBus, inicio, destino, horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp);
        viajesIndirectos.insertar(viajeID);
        model2.addRow(new Object[]{NBus, inicio, destino, horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp});
        lienzo.repaint();
    }

    public void actualizarInfoBus(Bus bus, int kilometros, double tiempo, int pasajeros, double ganancia) {
        bus.setKilometrosRecorridos(bus.getKilometrosRecorridos() + kilometros);
        bus.setTiempoTranscurrido(bus.getTiempoTranscurrido() + tiempo);
        bus.setCPasajeros(bus.getCPasajeros() + pasajeros);
        bus.setGananciaTotal(bus.getGananciaTotal() + ganancia);
    }

    private void inicializarLienzo() {
        lienzo = new Lienzo(this);
        lienzo.setSize(600, 600);
        lienzo.setOpaque(false); // Hacer que el lienzo sea transparente
        lienzo.setBackground(Color.WHITE);
        lienzo.setVisible(true);
        jPanel1.setLayout(new BorderLayout());
        jPanel1.add(lienzo, BorderLayout.CENTER);
    }

    public void habilitarCampos(int x, int y) {
        clickX = x; // Guarda las coordenadas del clic
        clickY = y;
        jTextField1.setEnabled(true);
        jButton1.setEnabled(true);
    }

    public void habilitarCampos2(int x1, int y1, int x2, int y2) {
        clickX1 = x1; // Guarda las coordenadas del clic
        clickY1 = y1;
        clickX2 = x2; // Guarda las coordenadas del clic
        clickY2 = y2;
        jTextField2.setEnabled(true);
        jButton2.setEnabled(true);
    }

    public void deshabilitarCampos() {
        jTextField1.setEnabled(false);
        jButton1.setEnabled(false);
        jTextField2.setEnabled(false);
        jButton2.setEnabled(false);
    }

    public JTextField getJTextField1() {
        return jTextField1;
    }

    public JButton getJButton1() {
        return jButton1;
    }

    public void Table1() {
        jTabbedPane1.setSelectedIndex(0);
    }

    public void Table2() {
        jTabbedPane1.setSelectedIndex(1);
    }

    public void Table3() {
        jTabbedPane1.setSelectedIndex(2);
    }

    public void Table4() {
        jTabbedPane1.setSelectedIndex(3);
    }

    public void Table5() {
        jTabbedPane1.setSelectedIndex(4);
    }

    private Nodo obtenerNodoPorCoordenadas(int x, int y) {
        for (Nodo nodo : lienzo.getVectorNodos()) {
            if (nodo.getX() == x && nodo.getY() == y) {
                return nodo;
            }
        }
        return null;
    }

    private int mostrarCuadroSeleccionTipo() {
        String[] opciones = {"Viaje Directo", "Viaje Indirecto"};
        int seleccion = JOptionPane.showOptionDialog(this,
                "Seleccione el tipo de viaje:",
                "Tipo de Viaje",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]);

        if (seleccion == 0) {
            esViajeDirecto = true;
        } else if (seleccion == 1) {
            esViajeDirecto = false;
        }
        return 1;
    }

    //Algoritmo Dijkstra
    private Nodo buscarNodoPorNombre(String nombre) {
        for (Nodo nodo : lienzo.getVectorNodos()) {
            if (nodo.getNombre().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jButton3 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(54, 70, 78));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setBackground(new java.awt.Color(54, 70, 78));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Menu.png"))); // NOI18N
        jLabel6.setOpaque(true);
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 60, 60));

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Recorridos");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, 30));

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Bus1.png"))); // NOI18N
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 70, 50));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 50));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("V. Directos");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Bus2.png"))); // NOI18N
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 70, 50));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 190, 50));

        jLabel29.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Información");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 110, 30));

        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Bus3.png"))); // NOI18N
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 70, 50));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 190, 50));

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Informacion.png"))); // NOI18N
        jPanel2.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 50, 50));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 50));

        jLabel36.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("V.Indirectos");
        jPanel2.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, 30));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 420));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/TT.png"))); // NOI18N
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 280, 70));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Tte.png"))); // NOI18N
        jLabel11.setText("jLabel11");
        jPanel6.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 430, 50));

        jPanel3.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 70));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Terminal Terrestre de Machala");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Agregar Lugar:");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Agregar kilometros a recorrer:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jTextField1.setEnabled(false);
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 210, -1));

        jButton1.setText("Aceptar");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jTextField2.setEnabled(false);
        jPanel4.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 210, -1));

        jButton2.setText("Aceptar");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                jPanel1MouseWheelMoved(evt);
            }
        });
        jPanel1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPanel1KeyReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 460, 420));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mapa_de_localización_El_Oro3.png"))); // NOI18N
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, -40, 460, 500));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setText("Seleccionar Ciudad o Sector.");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Ciudad");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, -1));

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("Sector");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jButton3.setText("i");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 75, -1, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setText("Informacion del Lugar:");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, -1));

        jLabel21.setText("Obtenga informacion");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 140, -1));

        jLabel22.setText("adicional del lugar");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, -1));

        jLabel23.setText("al que desea llegar,");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, -1, -1));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Logo_Cursor.png"))); // NOI18N
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, 70, 90));

        jLabel24.setText("colocando el cursor ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, -1));

        jLabel25.setText("encima del Nodo. ");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo Celeste.png"))); // NOI18N
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 420));

        jTabbedPane1.addTab("Ventana", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel37.setText("Viajes Directos");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 650, 310));

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_Tablas.png"))); // NOI18N
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        jTabbedPane1.addTab("Ventana2", jPanel5);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel14.setText("Viajes Indirectos");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jPanel7.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 650, 310));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_Tablas.png"))); // NOI18N
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        jTabbedPane1.addTab("Ventana3", jPanel7);

        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        jLabel26.setText("Informacion del Transporte");
        jPanel8.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jPanel8.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 650, 310));

        jLabel34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_Tablas.png"))); // NOI18N
        jPanel8.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, 420));

        jTabbedPane1.addTab("Ventana4", jPanel8);

        jPanel3.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, -1, 450));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono_Menu2.png"))); // NOI18N
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel10.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 60, 60));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo_Informacion.png"))); // NOI18N
        jPanel10.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 410));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 190, 410));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 880, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    int x = 190;
    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        // TODO add your handling code here:
        if (x == 190) {
            jPanel2.setSize(190, 415);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 190; i >= 0; i--) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 415);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 0;
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        if (x == 0) {
            jPanel2.show();
            jPanel2.setSize(x, 415);
            Thread th = new Thread() {
                @Override
                public void run() {
                    try {
                        for (int i = 0; i <= x; i++) {
                            Thread.sleep(1);
                            jPanel2.setSize(i, 415);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }
                }
            };
            th.start();
            x = 190;
        }
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        Table1();
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        Table2();
    }//GEN-LAST:event_jLabel5MouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        Table3();
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        // TODO add your handling code here:
        Table4();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        esCiudad = false;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        esCiudad = true;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jPanel1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPanel1KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1KeyReleased

    private void jPanel1MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_jPanel1MouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseWheelMoved

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String nombreEnlace = jTextField2.getText();
        if (!nombreEnlace.isEmpty()) {
            Nodo nodoInicio = obtenerNodoPorCoordenadas(clickX1, clickY1);
            Nodo nodoFin = obtenerNodoPorCoordenadas(clickX2, clickY2);

            // Mostrar cuadro de selección de tipo de viaje
            mostrarCuadroSeleccionTipo();

            // Solicitar información adicional
            String numeroBus = JOptionPane.showInputDialog(this, "Ingrese el número del bus:");
            String kilometrosStr = JOptionPane.showInputDialog(this, "Ingrese los kilómetros:");
            int kilometros = Integer.parseInt(kilometrosStr);
            String tarifaStr = JOptionPane.showInputDialog(this, "Ingrese la tarifa:");
            double tarifa = Double.parseDouble(tarifaStr);
            String tiempoStr = JOptionPane.showInputDialog(this, "Ingrese el tiempo de viaje:");
            int tiempo = Integer.parseInt(tiempoStr);
            String cpasajeros = JOptionPane.showInputDialog(this, "Ingrese la cantidad de Pasajeros:");
            int cantp = Integer.parseInt(cpasajeros);
            String horaSalida = JOptionPane.showInputDialog(this, "Ingrese la hora de salida:");
            String horaLlegada = JOptionPane.showInputDialog(this, "Ingrese la hora de llegada:");

            // Crear la arista con colores diferentes según el tipo de viaje
            Color colorArista = esViajeDirecto ? Color.BLACK : Color.RED;
            lienzo.addArista(new Enlace(nodoInicio, nodoFin, clickX1, clickY1, clickX2, clickY2, nombreEnlace, colorArista, Color.BLACK, kilometros));

            // Agregar los datos a las tablas correspondientes según el tipo de viaje seleccionado
            if (esViajeDirecto) {
                agregarVD(numeroBus, nodoInicio.getNombre(), nodoFin.getNombre(), horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp);
            } else {
                agregarVID(numeroBus, nodoInicio.getNombre(), nodoFin.getNombre(), horaSalida, horaLlegada, kilometros, tarifa, tiempo, cantp);
            }

            Bus bus = InfoBus.buscarPorNumero(numeroBus);
            if (bus == null) {
                double gananciaTotal = tarifa * cantp;
                bus = new Bus(numeroBus, kilometros, tiempo, "06:00AM - 21:00PM", cantp, gananciaTotal);
                InfoBus.insertarBus(bus);
            } else {
                bus.setKilometrosRecorridos(bus.getKilometrosRecorridos() + kilometros);
                bus.setTiempoTranscurrido(bus.getTiempoTranscurrido() + tiempo);
                bus.setCPasajeros(bus.getCPasajeros() + cantp);
                double gananciaTotal = bus.getGananciaTotal() + (tarifa * cantp);
                bus.setGananciaTotal(gananciaTotal);
            }

            // Actualiza jTable3 con la información del bus
            ActualizarTablaBus(bus);

            jTextField2.setText("");
            deshabilitarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del enlace no puede estar vacío.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String nombreNodo = jTextField1.getText();
        if (!nombreNodo.isEmpty()) {
            boolean esCiudadSeleccionada = esCiudad;

            Nodo nodo = new Nodo(clickX, clickY, nombreNodo, esCiudadSeleccionada,
                    esCiudadSeleccionada ? Color.BLUE : Color.RED,
                    Color.BLACK, "");

            lienzo.addNodo(nodo);

            jTextField1.setText("");
            deshabilitarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "El nombre del nodo no puede estar vacío.");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String origen = JOptionPane.showInputDialog(this, "Ingrese el nombre del nodo de origen:");
        String destino = JOptionPane.showInputDialog(this, "Ingrese el nombre del nodo de destino:");

        Nodo nodoOrigen = buscarNodoPorNombre(origen);
        Nodo nodoDestino = buscarNodoPorNombre(destino);

        if (nodoOrigen == null || nodoDestino == null) {
            JOptionPane.showMessageDialog(this, "Nodo de origen o destino no encontrado.");
            return;
        }

        // Usar Dijkstra para encontrar la ruta más corta desde el nodo de origen
        AlgoritmoE.Resultado resultado = AlgoritmoE.dijkstra(lienzo.getVectorNodos(), lienzo.getVectorEnlace(), nodoOrigen, nodoDestino);

        // Obtener la distancia más corta al nodo de destino
        Integer distanciaMasCorta = resultado.getDistancias().get(nodoDestino);
        if (distanciaMasCorta == null || distanciaMasCorta == Integer.MAX_VALUE) {
            JOptionPane.showMessageDialog(this, "No hay una ruta disponible entre los nodos seleccionados.");
        } else {
            JOptionPane.showMessageDialog(this, "La ruta más corta desde " + origen + " hasta " + destino
                    + " es de " + distanciaMasCorta + " kilómetros.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    public static javax.swing.JTable jTable1;
    public static javax.swing.JTable jTable2;
    public static javax.swing.JTable jTable3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
