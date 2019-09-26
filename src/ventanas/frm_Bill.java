/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Clases.Cliente;
import Clases.Factura;
import Controlador.bd_Conexion;
import Controlador.conexion;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.scene.control.ButtonBar.ButtonData.YES;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Frank
 */
public class frm_Bill extends javax.swing.JFrame {

    static double subtotal, igv1, igv2, montoTotal1, montoTotal2;
    DefaultTableModel modelo = new DefaultTableModel();
    public static String nombreM = "";

    /**
     * Creates new form frm_Bill
     */
    public frm_Bill() {
        initComponents();
        setSize(685, 560);
        setResizable(false);
        setTitle("Factura");
        setLocationRelativeTo(null);
        setVisible(true);
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        try {
            mostrar();
        } catch (Exception e) {
            System.out.println(e);
        }
        txt_subtotal.setText(Double.toString(subTotal()));
        subtotal = Double.parseDouble(txt_subtotal.getText());
        igv1 = subtotal * 0.18;
        igv2 = redondearDecimales(igv1, 2);
        txt_igv.setText(Double.toString(igv2));
        montoTotal1 = subtotal + igv2;
        montoTotal2 = redondearDecimales(montoTotal1, 2);
        txt_montototal.setText(Double.toString(montoTotal2));
        System.out.println(tablaFactura.getRowCount());
//        bd_Conexion cone = new bd_Conexion();
//        cone.vaciarTabla();
    }

    public double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        factura = new javax.swing.JLabel();
        TooqTooq = new javax.swing.JLabel();
        PiuraPERU = new javax.swing.JLabel();
        celular = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFactura = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        txt_ruc = new javax.swing.JTextField();
        txt_ciudad = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_fecha = new com.toedter.calendar.JDateChooser();
        generarFactura = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel_igv1 = new javax.swing.JLabel();
        cmb_nm = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_atendidoP = new javax.swing.JLabel();
        jLabel_igv2 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_igv = new javax.swing.JTextField();
        txt_montototal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setForeground(new java.awt.Color(0, 204, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        factura.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        factura.setText("FACTURA");
        jPanel1.add(factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        TooqTooq.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        TooqTooq.setText("TooQTooQ");
        jPanel1.add(TooqTooq, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

        PiuraPERU.setText("Piura-Perú");
        jPanel1.add(PiuraPERU, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 72, -1, -1));

        celular.setText("957188427");
        jPanel1.add(celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(68, 89, -1, -1));

        jLabel5.setText("Fecha:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, -1, -1));

        jLabel6.setText("Nombre:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel7.setText("RUC:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

        jLabel8.setText("Ciudad:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        jLabel9.setText("Telefono:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        jLabel10.setText("Correo/Gmail:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, -1, -1));

        tablaFactura.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cantidad", "Descripcion", "Precio Unitario", "Monto"
            }
        ));
        jScrollPane1.setViewportView(tablaFactura);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 680, 140));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 123, 35));
        jLabel11.setText("TooQ");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, -1, -1));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(234, 121, 61));
        jLabel12.setText("TooQ");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        txt_nombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 200, 20));

        txt_ruc.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ruc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_rucActionPerformed(evt);
            }
        });
        txt_ruc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_rucKeyTyped(evt);
            }
        });
        jPanel1.add(txt_ruc, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 200, 20));

        txt_ciudad.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_ciudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_ciudadKeyTyped(evt);
            }
        });
        jPanel1.add(txt_ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, 200, 20));

        txt_telefono.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 200, 20));

        txt_correo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        txt_correo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_correoActionPerformed(evt);
            }
        });
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 200, 20));
        jPanel1.add(txt_fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 150, 200, -1));

        generarFactura.setText("Generar Factura");
        generarFactura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                generarFacturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                generarFacturaMouseExited(evt);
            }
        });
        generarFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarFacturaActionPerformed(evt);
            }
        });
        jPanel1.add(generarFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 140, 50));

        jLabel3.setText("MONTO TOTAL   :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, -1, -1));

        jLabel_igv1.setText("SUB TOTAL  :");
        jPanel1.add(jLabel_igv1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 390, -1, -1));

        cmb_nm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        cmb_nm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_nmActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_nm, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 100, -1));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setText("Num. Mesa    :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, -1, -1));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Atendido por  :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, -1, -1));

        txt_atendidoP.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.add(txt_atendidoP, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 210, 130, 20));

        jLabel_igv2.setText("IGV    :");
        jPanel1.add(jLabel_igv2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 420, -1, -1));

        txt_subtotal.setEditable(false);
        txt_subtotal.setForeground(new java.awt.Color(255, 255, 255));
        txt_subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_subtotalActionPerformed(evt);
            }
        });
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 60, -1));

        txt_igv.setEditable(false);
        txt_igv.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_igv, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 420, 60, -1));

        txt_montototal.setEditable(false);
        txt_montototal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(txt_montototal, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 450, 60, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 560));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_ciudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_ciudadKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_ciudadKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        int can = txt_telefono.getText().length();
        int tam = 11;
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90 || can >= tam) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void generarFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarFacturaActionPerformed
        //variables para recuperar datos
        try {
            String fecha;
            String nombre, ruc, correo, ciudad, telefono;
            //Datos Obtenidos de las casillas del diseño de los txt
            // montoTotal =Double.parseDouble(txtPrecioTotal.getText());
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
            fecha = df.format(txt_fecha.getDate());
            nombre = txt_nombre.getText();
            correo = txt_correo.getText();
            ciudad = txt_ciudad.getText();
            int validacion = 0;
            ruc = txt_ruc.getText();
            telefono = txt_telefono.getText();
            if (nombre.equals("")) {
                txt_nombre.setBackground(Color.red);
                validacion++;
            } else {
                txt_nombre.setBackground(Color.white);
            }
            if (ruc.equals("")) {
                txt_ruc.setBackground(Color.red);
                validacion++;
            } else {
                txt_ruc.setBackground(Color.white);
            }
            if (telefono.equals("")) {
                txt_telefono.setBackground(Color.red);
                validacion++;
            } else {
                txt_telefono.setBackground(Color.white);
            }
            if (correo.equals("")) {
                txt_correo.setBackground(Color.red);
                validacion++;
            } else {
                txt_correo.setBackground(Color.white);
            }
            if (ciudad.equals("")) {
                txt_ciudad.setBackground(Color.red);
                validacion++;
            } else {
                txt_ciudad.setBackground(Color.white);
            }
            if (fecha.equals("")) {
                txt_fecha.setBackground(Color.red);
                validacion++;
            } else {
                txt_fecha.setBackground(Color.white);
            }
            if (validacion == 0) {
                //JOptionPane.showMessageDialog(null, "Datos ingresados correctamente");
                
                txt_nombre.setBackground(Color.green);
                txt_ruc.setBackground(Color.green);
                txt_telefono.setBackground(Color.green);
                txt_correo.setBackground(Color.green);
                txt_ciudad.setBackground(Color.green);
                //        /*VERIFICACION DEL COMBOBOX*/
                //
                bd_Conexion con = new bd_Conexion();
                int cmbNM;
                String nombreM = "";
                cmbNM = cmb_nm.getSelectedIndex() + 1;

                if (cmbNM == 1 || cmbNM == 2 || cmbNM == 3) {
                    int numeroMesero = 1;
                    nombreM = con.seleccionarNM(numeroMesero);
                    txt_atendidoP.setText(nombreM);
                    //motrar
                    txt_atendidoP.getText();
                } else if (cmbNM == 4 || cmbNM == 5 || cmbNM == 6) {
                    int numeroMesero = 2;
                    nombreM = con.seleccionarNM(numeroMesero);
                    txt_atendidoP.setText(nombreM);
                    //motrar
                    txt_atendidoP.getText();
                } else if (cmbNM == 7 || cmbNM == 8 || cmbNM == 9) {
                    int numeroMesero = 3;
                    nombreM = con.seleccionarNM(numeroMesero);
                    txt_atendidoP.setText(nombreM);
                    //motrar
                    txt_atendidoP.getText();
                } else if (cmbNM == 10 || cmbNM == 11 || cmbNM == 12) {
                    int numeroMesero = 4;
                    nombreM = con.seleccionarNM(numeroMesero);
                    txt_atendidoP.setText(nombreM);
                    //motrar
                    txt_atendidoP.getText();
                } else if (cmbNM == 13 || cmbNM == 14 || cmbNM == 15) {
                    int numeroMesero = 5;
                    nombreM = con.seleccionarNM(numeroMesero);
                    txt_atendidoP.setText(nombreM);
                    //motrar
                    txt_atendidoP.getText();
                }
                //enviar datos obtenidos a la clase factura
                Cliente cliente = new Cliente();
                // bd_Conexion con = new bd_Conexion();
                Factura factura = new Factura();
                //cliente
                cliente.setNombre(nombre);
                cliente.setDni("00000000");
                cliente.setTelefono(telefono);
                cliente.setRuc(ruc);
                cliente.setCorreo(correo);
                cliente.setCiudad(ciudad);
                //factura
                factura.setNombre(nombre);
                factura.setRuc(ruc);
                factura.setCiudad(ciudad);
                factura.setTelefono(telefono);
                factura.setCorreo(correo);
                factura.setFecha(fecha);
                factura.setAtendidoPor(nombreM);
                //valores
                factura.setIgv(igv2);
                factura.setSubtotal(subtotal);
                factura.setMontoTotal(montoTotal2);

                if (con.insertarFactura(factura) && con.insertarCliente(cliente)) {
                    JOptionPane.showMessageDialog(null, "Factura Registrada corecctamente");
                     Limpiar();

                } else {
                    JOptionPane.showMessageDialog(null, "Error Contacte con el Administrador");
                }

                //MOSTRAR DATOS DE PRUEBA
                System.out.println(factura.getNombre()
                        + factura.getRuc()
                        + factura.getCiudad()
                        + factura.getTelefono()
                        + factura.getCorreo()
                        + factura.getFecha());
               

                /*Generar factura codigo prueba*/
                /*Generar factura codigo prueba
                -Codigo de  implementacion*/
                //
                int seleccion = JOptionPane.showOptionDialog(null, "DESEA DESCARGAR FACTURA?", "Imprimir Factura", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
                if (seleccion == 0) {
                    Document doc = new Document();
                    ResultSet rs = conexion.getTabla("select * from pedido;");

                    try {

                        String ruta = System.getProperty("user.home");
                        PdfWriter.getInstance(doc, new FileOutputStream(ruta + "/Desktop/Factura"+factura.getNombre()+".pdf"));
                        Image header = Image.getInstance("src/imagenes/CabeceraF.jpg");
                        header.scaleToFit(650, 1000);//1000 iba mil
                        header.setAlignment(Chunk.ALIGN_CENTER);

                        Paragraph parrafo = new Paragraph();
                        parrafo.setAlignment(Paragraph.ALIGN_LEFT);
                        parrafo.setFont(FontFactory.getFont("Tahoma", 18, Font.BOLD, BaseColor.DARK_GRAY));
                        parrafo.add("Nombre: " + factura.getNombre().concat("                " + "Ciudad: " + factura.getCiudad()) + "\n \n");
                        parrafo.add("Ruc: " + factura.getRuc().concat("                            " + "Correo: " + factura.getCorreo()) + " \n \n");
                        parrafo.add("Telefono: " + factura.getTelefono().concat("                      " + "Fecha: " + factura.getFecha()) + "\n \n");
                        doc.open();
                        doc.add(header);
                        doc.add(parrafo);


                        /*creacion de las columnas de la table falta la base de datos*/
                        PdfPTable tabla = new PdfPTable(4);

                        String rotulosColumnas[] = {"Descripcion", "Cantidad", "Precio Unitario", "Total"};
                        tabla.setHorizontalAlignment(Element.ALIGN_CENTER);
                        tabla.setWidthPercentage(100);

                        PdfPCell CeldaFinal = new PdfPCell(new Paragraph());
                        CeldaFinal.setColspan(4);
                        for (int i = 0; i < rotulosColumnas.length; i++) {
                            CeldaFinal = new PdfPCell(new Paragraph(rotulosColumnas[i]));
                            CeldaFinal.setVerticalAlignment(Element.ALIGN_MIDDLE);
                            CeldaFinal.setHorizontalAlignment(Element.ALIGN_CENTER);
                            tabla.addCell(CeldaFinal);
                        }
                        while (rs.next()) {
                            CeldaFinal = new PdfPCell(new Paragraph(String.valueOf(rs.getString("descripcion"))));
                            tabla.addCell(CeldaFinal);
                            CeldaFinal = new PdfPCell(new Paragraph(String.valueOf(rs.getString("cantidad"))));
                            tabla.addCell(CeldaFinal);
                            CeldaFinal = new PdfPCell(new Paragraph(String.valueOf(rs.getString("precio"))));
                            tabla.addCell(CeldaFinal);
                            CeldaFinal = new PdfPCell(new Paragraph(String.valueOf(rs.getString("monto"))));
                            tabla.addCell(CeldaFinal);
                        }
                        Paragraph parrafo1 = new Paragraph();
                        parrafo1.setAlignment(Paragraph.ALIGN_RIGHT);
                        parrafo1.setFont(FontFactory.getFont("Tahoma", 14, Font.BOLD, BaseColor.DARK_GRAY));
                        parrafo1.add("SubTotal: " + factura.getSubtotal() + "\n \n");
                        parrafo1.add("IGV 18%: " + factura.getIgv() + " \n \n");
                        parrafo1.add("Total: " + factura.getMontoTotal() + "\n \n");

                        doc.add(tabla);
                        doc.add(parrafo1);
                        doc.close();
                        JOptionPane.showMessageDialog(null, "FACTURA DESCARGADA EN INICIO");
                        this.dispose();

//                mostrar();
                    } catch (DocumentException | IOException e) {
                        System.out.println("error" + e);
                    } catch (SQLException ex) {
                        Logger.getLogger(frm_Bill.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    //JOptionPane.showMessageDialog(null, "FACTURA COMPLETA");
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "COMPLETA LAS CASILLAS EN ROJO");
            }

            bd_Conexion cone = new bd_Conexion();
            cone.vaciarTabla();

        } catch (Exception e) {
            if (txt_nombre.getText().equals("")) {
                txt_nombre.setBackground(Color.red);
            } else {
                txt_nombre.setBackground(Color.white);
            }
            if (txt_ruc.getText().equals("")) {
                txt_ruc.setBackground(Color.red);
            } else {
                txt_ruc.setBackground(Color.white);
            }
            if (txt_ciudad.getText().equals("")) {
                txt_ciudad.setBackground(Color.red);
            } else {
                txt_ciudad.setBackground(Color.white);
            }
            if (txt_correo.getText().equals("")) {
                txt_correo.setBackground(Color.red);
            } else {
                txt_correo.setBackground(Color.white);
            }
            if (txt_telefono.getText().equals("")) {
                txt_telefono.setBackground(Color.red);
            } else {
                txt_telefono.setBackground(Color.white);
            }
            if (txt_fecha.getDate() == null) {
                txt_fecha.setBackground(Color.red);
            } else {
                txt_fecha.setBackground(Color.white);
            }
            if (txt_atendidoP.getText().equals("")) {
                txt_atendidoP.setBackground(Color.red);
            } else {
                txt_atendidoP.setBackground(Color.white);
            }
            if (cmb_nm.getSelectedItem() == "----") {
                cmb_nm.setBackground(Color.red);
            } else {
                cmb_nm.setBackground(Color.white);
            }
            JOptionPane.showMessageDialog(rootPane, "Debe completa las casillas de rojo");
        }
    }//GEN-LAST:event_generarFacturaActionPerformed

    private void txt_rucKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_rucKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        int can = txt_ruc.getText().length();
        int tam = 11;
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90 || can >= tam) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txt_rucKeyTyped

    private void generarFacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarFacturaMouseEntered
        // TODO add your handling code here:
        generarFactura.setBackground(Color.GREEN);
    }//GEN-LAST:event_generarFacturaMouseEntered

    private void generarFacturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_generarFacturaMouseExited
        // TODO add your handling code here:
        generarFactura.setBackground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_generarFacturaMouseExited

    private void cmb_nmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_nmActionPerformed

            bd_Conexion co = new bd_Conexion();
        if(cmb_nm.getSelectedIndex() == 1 || cmb_nm.getSelectedIndex() == 2 || cmb_nm.getSelectedIndex() == 3 ){
           txt_atendidoP.setText(String.valueOf(co.seleccionarNM(1)));
       }else if(cmb_nm.getSelectedIndex() == 4 || cmb_nm.getSelectedIndex() == 5 || cmb_nm.getSelectedIndex() == 6 ){
           txt_atendidoP.setText(String.valueOf(co.seleccionarNM(2)));
       }else if(cmb_nm.getSelectedIndex() == 7 || cmb_nm.getSelectedIndex() == 8 || cmb_nm.getSelectedIndex() == 9 ){
           txt_atendidoP.setText(String.valueOf(co.seleccionarNM(3)));
       }else if(cmb_nm.getSelectedIndex() == 10 || cmb_nm.getSelectedIndex() == 11 || cmb_nm.getSelectedIndex() == 12 ){
           txt_atendidoP.setText(String.valueOf(co.seleccionarNM(4)));
       }else if(cmb_nm.getSelectedIndex() == 13 || cmb_nm.getSelectedIndex() == 14 || cmb_nm.getSelectedIndex() == 15 ){
           txt_atendidoP.setText(String.valueOf(co.seleccionarNM(5)));
       }
        
    }//GEN-LAST:event_cmb_nmActionPerformed

    private void txt_rucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_rucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_rucActionPerformed

    private void txt_correoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_correoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoActionPerformed

    private void txt_subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_subtotalActionPerformed
    public void mostrar() {

        ResultSet rs = conexion.getTabla("select * from pedido;");
        try {
            while (rs.next()) {
                modelo.setColumnIdentifiers(new Object[]{"Descripcion", "Cantidad", "Precio", "Monto"});
                //añade los resultados a el modelo de tabla  
                modelo.addRow(new Object[]{rs.getString("descripcion"), rs.getInt("cantidad"), rs.getDouble("precio"), rs.getDouble("monto")});
                tablaFactura.setModel(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(frm_Bill.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double subTotal() {
        int contar = tablaFactura.getRowCount();
        double subTotal = 0;
        for (int i = 0; i < contar; i++) {
            subTotal = subTotal + Double.parseDouble(tablaFactura.getValueAt(i, 3).toString());
        }
        return subTotal;
    }

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
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel PiuraPERU;
    private javax.swing.JLabel TooqTooq;
    private javax.swing.JLabel celular;
    private javax.swing.JComboBox<String> cmb_nm;
    private javax.swing.JLabel factura;
    private javax.swing.JButton generarFactura;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_igv1;
    private javax.swing.JLabel jLabel_igv2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaFactura;
    private javax.swing.JLabel txt_atendidoP;
    private javax.swing.JTextField txt_ciudad;
    private javax.swing.JTextField txt_correo;
    private com.toedter.calendar.JDateChooser txt_fecha;
    private javax.swing.JTextField txt_igv;
    private javax.swing.JTextField txt_montototal;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JTextField txt_ruc;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_nombre.setText("");
        txt_ruc.setText("");
        txt_ciudad.setText("");
        txt_telefono.setText("");
        txt_correo.setText("");

    }

}
