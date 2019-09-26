package ventanas;
import calculadora.CalculadoraGUI;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;
/**
 *
 * @author Frank
 */
public class frm_Admin extends javax.swing.JFrame {
    String user, nombre_usuario;
    public static int session_usuario;//enviar datos entreinterfacez
    public frm_Admin() {
        initComponents();
        user = frm_Login.user;
        session_usuario = 1;//bandera 
        setSize(650, 430);
        setResizable(false);
        setTitle("Administrador - Sesión " + user);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//al ser cerrada el programa dejara de ejecutarla(evita que se ejecute en segundo plano)
       
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

        jButton_RegistrarUsuario = new javax.swing.JButton();
        jButton_Menu = new javax.swing.JButton();
        jButton_Factura = new javax.swing.JButton();
        jButton_AcercaDe = new javax.swing.JButton();
        jButton_Calculadora = new javax.swing.JButton();
        jButton_Reportes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_RegistrarUsuario.setBackground(new java.awt.Color(255, 153, 153));
        jButton_RegistrarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/add_user_male_96px.png"))); // NOI18N
        jButton_RegistrarUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_RegistrarUsuarioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_RegistrarUsuarioMouseExited(evt);
            }
        });
        jButton_RegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RegistrarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RegistrarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 71, 120, 100));

        jButton_Menu.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Menu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/restaurant_menu_96px.png"))); // NOI18N
        jButton_Menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_MenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_MenuMouseExited(evt);
            }
        });
        jButton_Menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_MenuActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 71, 120, 100));

        jButton_Factura.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Factura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/bill_100px.png"))); // NOI18N
        jButton_Factura.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_FacturaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_FacturaMouseExited(evt);
            }
        });
        jButton_Factura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_FacturaActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 71, 120, 100));

        jButton_AcercaDe.setBackground(new java.awt.Color(255, 153, 153));
        jButton_AcercaDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/man_in_blue_jacket_information_100px.png"))); // NOI18N
        jButton_AcercaDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_AcercaDeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_AcercaDeMouseExited(evt);
            }
        });
        jButton_AcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AcercaDeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AcercaDe, new org.netbeans.lib.awtextra.AbsoluteConstraints(495, 241, 120, 100));

        jButton_Calculadora.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Calculadora.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/calculator_100px.png"))); // NOI18N
        jButton_Calculadora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_CalculadoraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_CalculadoraMouseExited(evt);
            }
        });
        jButton_Calculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_CalculadoraActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Calculadora, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 241, 120, 100));

        jButton_Reportes.setBackground(new java.awt.Color(255, 153, 153));
        jButton_Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/statistics_100px.png"))); // NOI18N
        jButton_Reportes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton_ReportesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton_ReportesMouseExited(evt);
            }
        });
        jButton_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ReportesActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 241, 120, 100));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Registrar Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 171, -1, -1));

        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Menu ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(309, 171, -1, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Buscar comprobante");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Acerca de");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 341, -1, -1));

        jLabel7.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Calculadora");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(285, 341, -1, -1));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Reportes");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, -1, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Cambiar de cuenta");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabel1MouseExited(evt);
            }
        });
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/adminFondo.jpg"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RegistrarUsuarioActionPerformed
       //Cuando el usuario da click en el boton abrira esta  ventana
        frm_RegistrationOption ro=new  frm_RegistrationOption();
        ro.setVisible(true);    
    }//GEN-LAST:event_jButton_RegistrarUsuarioActionPerformed

    private void jButton_MenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_MenuActionPerformed
       //Cuando el usuario da click en el boton abrira esta  ventana
        frm_Menu menu = new frm_Menu();
        menu.setVisible(true);
    }//GEN-LAST:event_jButton_MenuActionPerformed

    private void jButton_FacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_FacturaActionPerformed
       //Cuando el usuario da click en el boton abrira esta  ventana
        frm_ChooseVoucher CV = new frm_ChooseVoucher();
        CV.setVisible(true);
    }//GEN-LAST:event_jButton_FacturaActionPerformed

    private void jButton_AcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AcercaDeActionPerformed
       //Cuando el usuario da click en el boton abrira esta  ventana
        frm_About acerca=new frm_About();
        acerca.setVisible(true);
    }//GEN-LAST:event_jButton_AcercaDeActionPerformed

    private void jButton_CalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_CalculadoraActionPerformed
      //Cuando el usuario da click en el boton abrira esta  ventana 
       CalculadoraGUI calc = new CalculadoraGUI();
       calc.setVisible(true);
    }//GEN-LAST:event_jButton_CalculadoraActionPerformed

    private void jButton_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ReportesActionPerformed
      //Cuando el usuario da click en el boton abrira esta  ventana 
       frm_Reports rp = new frm_Reports();
       rp.setVisible(true);
               
    }//GEN-LAST:event_jButton_ReportesActionPerformed

    private void jButton_RegistrarUsuarioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegistrarUsuarioMouseEntered
        // TODO add your handling code here:
        jButton_RegistrarUsuario.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_RegistrarUsuarioMouseEntered

    private void jButton_RegistrarUsuarioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_RegistrarUsuarioMouseExited
        // TODO add your handling code here:
        jButton_RegistrarUsuario.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_RegistrarUsuarioMouseExited

    private void jButton_MenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_MenuMouseEntered
        // TODO add your handling code here:
        jButton_Menu.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_MenuMouseEntered

    private void jButton_MenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_MenuMouseExited
        // TODO add your handling code here:
        jButton_Menu.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_MenuMouseExited

    private void jButton_FacturaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_FacturaMouseEntered
        // TODO add your handling code here:
        jButton_Factura.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_FacturaMouseEntered

    private void jButton_FacturaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_FacturaMouseExited
        // TODO add your handling code here:
        jButton_Factura.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_FacturaMouseExited

    private void jButton_ReportesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ReportesMouseEntered
        // TODO add your handling code here:
        jButton_Reportes.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_ReportesMouseEntered

    private void jButton_ReportesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_ReportesMouseExited
        // TODO add your handling code here:
         jButton_Reportes.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_ReportesMouseExited

    private void jButton_CalculadoraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CalculadoraMouseEntered
        // TODO add your handling code here:
        jButton_Calculadora.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_CalculadoraMouseEntered

    private void jButton_CalculadoraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_CalculadoraMouseExited
        // TODO add your handling code here:
        jButton_Calculadora.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_CalculadoraMouseExited

    private void jButton_AcercaDeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AcercaDeMouseEntered
        // TODO add your handling code here:
        jButton_AcercaDe.setBackground(new Color(255, 87, 51));
    }//GEN-LAST:event_jButton_AcercaDeMouseEntered

    private void jButton_AcercaDeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton_AcercaDeMouseExited
        // TODO add your handling code here:
        jButton_AcercaDe.setBackground(new Color(255,153,153));
    }//GEN-LAST:event_jButton_AcercaDeMouseExited

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        frm_Login login = new frm_Login();
        dispose();
        login.setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setBackground(Color.green);
        jLabel1.setForeground(Color.red);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseExited
        // TODO add your handling code here:
         jLabel1.setBackground(new Color(187,187,187));
         jLabel1.setForeground(Color.white);
    }//GEN-LAST:event_jLabel1MouseExited

    
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
            java.util.logging.Logger.getLogger(frm_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_AcercaDe;
    private javax.swing.JButton jButton_Calculadora;
    private javax.swing.JButton jButton_Factura;
    private javax.swing.JButton jButton_Menu;
    private javax.swing.JButton jButton_RegistrarUsuario;
    private javax.swing.JButton jButton_Reportes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
