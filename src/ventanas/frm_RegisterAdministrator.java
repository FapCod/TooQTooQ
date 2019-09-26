package ventanas;

import Clases.Administrador;
import Clases.Usuario;
import Controlador.bd_Conexion;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Frank
 */
public class frm_RegisterAdministrator extends javax.swing.JFrame {

    public frm_RegisterAdministrator() {
        initComponents();
        setTitle("Registrar nuevo Administrador");
        setSize(632, 380);//mantener el tamaño de la interfaz para que no se pueda editar
        setResizable(false);//para que no se pueda editar 
        setLocationRelativeTo(null);//centrar la interfaz para cuando se ejecute
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    //cambiar la imagen del logo de la taza 
    //Inicio
    @Override
    public Image getIconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono.png"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_username = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_password = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Registro de Administrador");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        txt_nombre.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombreActionPerformed(evt);
            }
        });
        txt_nombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombreKeyTyped(evt);
            }
        });
        getContentPane().add(txt_nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 210, -1));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 210, -1));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Telefono:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, -1, -1));

        txt_telefono.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txt_telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_telefonoActionPerformed(evt);
            }
        });
        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        getContentPane().add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 210, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, -1, -1));

        txt_username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        getContentPane().add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 210, -1));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Password:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, -1, -1));

        txt_password.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        txt_password.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        getContentPane().add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 210, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/registrar.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, 120, 100));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ra.jpg"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 632, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombreActionPerformed

    }//GEN-LAST:event_txt_nombreActionPerformed

    private void txt_nombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombreKeyTyped
        char c = evt.getKeyChar();
        if (Character.isDigit(c)) {
            evt.consume();
        }
    }//GEN-LAST:event_txt_nombreKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        int k = (int) evt.getKeyChar();
        int can = txt_telefono.getText().length();
        int tam = 11;
        if (k >= 97 && k <= 122 || k >= 65 && k <= 90 || can >= tam) {
            evt.setKeyChar((char) KeyEvent.VK_CLEAR);
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //variables de recuperacion de datos
        int validacion = 0;//variables
        String nombre = "", mail = "", telefono = "", username = "", pass = "", tipoNivel = "Administrador";

        //recuperar valores dentro de los texfile
        mail = txt_email.getText().trim();//metodo trim eliminamos los espacios que estan al inicio y al final de la cadena de texto
        username = txt_username.getText().trim();
        pass = txt_password.getText().trim();
        nombre = txt_nombre.getText().trim();
        telefono = txt_telefono.getText().trim();

        //se cambian de color a rojo
        //validamos los campos antes de enviar los datos
        if (mail.equals("")) {
            txt_email.setBackground(Color.red);
            validacion++;
        } else {
            txt_email.setBackground(Color.white);
        }
        if (nombre.equals("")) {
            txt_nombre.setBackground(Color.red);
            validacion++;
        } else {
            txt_nombre.setBackground(Color.white);
        }
        if (telefono.equals("")) {
            txt_telefono.setBackground(Color.red);
            validacion++;
        } else {
            txt_telefono.setBackground(Color.white);
        }
        if (username.equals("")) {
            txt_username.setBackground(Color.red);
            validacion++;
        } else {
            txt_username.setBackground(Color.white);
        }
        if (pass.equals("")) {
            txt_password.setBackground(Color.red);
            validacion++;
        } else {
            txt_password.setBackground(Color.white);
        }
        if (validacion == 0) {
            //JOptionPane.showMessageDialog(rootPane, "Datos ingresados correctamente");
            
            txt_email.setBackground(Color.white);
            txt_nombre.setBackground(Color.white);
            txt_telefono.setBackground(Color.white);
            txt_username.setBackground(Color.white);
            txt_password.setBackground(Color.white);

            //Enviamos los datos obtenidos a las clases que hemos creado
            Usuario usuario = new Usuario();
            Administrador administrador = new Administrador();
            bd_Conexion con = new bd_Conexion();
            administrador.setNombre(nombre);
            administrador.setMailUsuario(mail);
            administrador.setTelefono(telefono);
            administrador.setUsernameUsuario(username);
            administrador.setContrasenaUsuario(pass);
            //administrador.setTipoNivelUsuario(tipoNivel);
            //Usuario
            usuario.setNombre(nombre);
            usuario.setMailUsuario(mail);
            usuario.setTelefono(telefono);
            usuario.setUsernameUsuario(username);
            usuario.setContrasenaUsuario(pass);
            usuario.setTipoNivelUsuario(tipoNivel);

            if (con.insertarAdministrador(administrador) && con.insertarUsuarios(usuario)) {
                JOptionPane.showMessageDialog(null, "Administrador Registrado corecctamente");
                Limpiar();

            } else {
                JOptionPane.showMessageDialog(null, "Error Contacte con el Administrador");
            }

            //prueba de datos ingresados por consola
            System.out.println(administrador.getNombre()
                    + administrador.getMailUsuario()
                    + administrador.getTelefono()
                    + administrador.getUsernameUsuario()
                    + administrador.getContrasenaUsuario()
                    + administrador.getTipoNivelUsuario());

        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe de completar las casillas de rojo");
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_telefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_telefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_telefonoActionPerformed

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
            java.util.logging.Logger.getLogger(frm_RegisterAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_RegisterAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_RegisterAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_RegisterAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_RegisterAdministrator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel_Wallpaper;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_nombre;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables

    public void Limpiar() {
        txt_email.setText("");
        txt_nombre.setText("");
        txt_password.setText("");
        txt_telefono.setText("");
        txt_username.setText("");
    }
}
