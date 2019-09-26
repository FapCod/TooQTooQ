/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import Controlador.conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Frank
 */
public class frm_InformationAdministrator extends javax.swing.JFrame {
    String user_update = "";
    int ID;
    /**
     * Creates new form frm_InformationAdministrator
     */
    public frm_InformationAdministrator() {
        initComponents();
        user_update = frm_SearchAdministrator.user_update;
        setTitle("Editar Administrador");
        setSize(531,376);//mantener el tamaño de la interfaz para que no se pueda editar
        setResizable(false);//para que no se pueda editar 
        setLocationRelativeTo(null);//centrar la interfaz para cuando se ejecute
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
        
         try {

            Connection cn = conexion.Conectar();
            PreparedStatement pst = cn.prepareStatement(
                    "select * from administrador where username ='" + user_update + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                ID = rs.getInt("idadministrador");
                txt_nombre.setText(rs.getString("nombre"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_mail.setText(rs.getString("mail"));
                txt_contrasena.setText(rs.getString("contraseña"));
                txt_username.setText(rs.getString("username"));
            } else {
                System.out.println("nota");
            }
            cn.close();
        } catch (SQLException e) {
            System.err.println("error en cargar usuario" + e);
            JOptionPane.showMessageDialog(null, "Error contacte con el Admin");

        }
    }

     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_nombreer = new javax.swing.JLabel();
        txt_nombre1 = new javax.swing.JLabel();
        txt_nombre2 = new javax.swing.JLabel();
        txt_nombre4 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_mail = new javax.swing.JTextField();
        txt_contrasena = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_nombre5 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        btn_Actualizar = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar Administrador");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        txt_nombreer.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombreer.setText("Telefono:");
        getContentPane().add(txt_nombreer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        txt_nombre1.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre1.setText("Mail:");
        getContentPane().add(txt_nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        txt_nombre2.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre2.setText("Contraseña:");
        getContentPane().add(txt_nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        txt_nombre4.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre4.setText("Nombre:");
        getContentPane().add(txt_nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        txt_telefono.setBackground(new java.awt.Color(255, 255, 255));
        txt_telefono.setForeground(new java.awt.Color(0, 0, 0));
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 220, -1));

        txt_mail.setBackground(new java.awt.Color(255, 255, 255));
        txt_mail.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 220, -1));

        txt_contrasena.setBackground(new java.awt.Color(255, 255, 255));
        txt_contrasena.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_contrasena, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 220, -1));

        txt_nombre.setBackground(new java.awt.Color(255, 255, 255));
        txt_nombre.setForeground(new java.awt.Color(0, 0, 0));
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 220, -1));

        txt_nombre5.setForeground(new java.awt.Color(255, 255, 255));
        txt_nombre5.setText("UserName");
        getContentPane().add(txt_nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        txt_username.setBackground(new java.awt.Color(255, 255, 255));
        txt_username.setForeground(new java.awt.Color(0, 0, 0));
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 220, -1));

        btn_Actualizar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btn_Actualizar.setForeground(new java.awt.Color(0, 0, 0));
        btn_Actualizar.setText("Actualizar Admin");
        btn_Actualizar.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        btn_Actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ActualizarActionPerformed(evt);
            }
        });
        getContentPane().add(btn_Actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 250, 170, 70));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/FondoActualizar1.jpg"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 530, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ActualizarActionPerformed
        // TODO add your handling code here:

        String nombre, telefono, mail, username, contra;
        //Datos Obtenidos de las casillas del diseño de los txt
        // montoTotal =Double.parseDouble(txtPrecioTotal.getText());

        nombre = txt_nombre.getText();
        mail = txt_mail.getText();
        username = txt_username.getText();
        int validacion = 0;
        contra = txt_contrasena.getText();
        
        telefono = txt_telefono.getText();
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        } else {
            txt_nombre.setBackground(Color.white);
        }
        if (mail.equals("")) {
            txt_mail.setBackground(Color.red);
            validacion++;
        } else {
            txt_mail.setBackground(Color.white);
        }
        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        } else {
            txt_username.setBackground(Color.white);
        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        } else {
            txt_telefono.setBackground(Color.white);
        }
        if (contra.equals("")) {
            txt_contrasena.setBackground(Color.red);
            validacion++;
        } else {
            txt_contrasena.setBackground(Color.white);
        }
        

        if (validacion == 0) {
            
            try {
                Connection cn = conexion.Conectar();
                PreparedStatement pst = cn.prepareStatement(
                    "update administrador set nombre=?,telefono=?,mail=?,contraseña=?,username=?"
                    + "where idadministrador = '"+ ID+"'");
                pst.setString(1, nombre);
                pst.setString(2, telefono);
                pst.setString(3, mail);
                pst.setString(4, contra);
                pst.setString(5, username);
                pst.executeUpdate();

                cn.close();
                JOptionPane.showMessageDialog(null, "Modificacion correcta");
            } catch (SQLException e) {
            System.err.println(e);
            }
            
            Limpiar();
        }
            
    }//GEN-LAST:event_btn_ActualizarActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        // TODO add your handling code here:
         char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        int k = (int) evt.getKeyChar();
        int can = txt_telefono.getText().length();
        int tam = 11;
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90 || can >= tam) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

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
            java.util.logging.Logger.getLogger(frm_InformationAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_InformationAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_InformationAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_InformationAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_InformationAdministrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Actualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_contrasena;
    private javax.swing.JTextField txt_mail;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JLabel txt_nombre1;
    private javax.swing.JLabel txt_nombre2;
    private javax.swing.JLabel txt_nombre4;
    private javax.swing.JLabel txt_nombre5;
    private javax.swing.JLabel txt_nombreer;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

public void Limpiar() {
        txt_nombre.setText("");
        txt_telefono.setText("");
        txt_mail.setText("");
        txt_contrasena.setText("");
txt_username.setText("");


    }
}