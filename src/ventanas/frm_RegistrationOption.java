package ventanas;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.WindowConstants;

/**
 *
 * @author Frank
 */
public class frm_RegistrationOption extends javax.swing.JFrame {

   
    public frm_RegistrationOption() {
        initComponents();
        setTitle("Registrar nuevo Usuario");
        setSize(400, 199);//mantener el tamaño de la interfaz para que no se pueda editar
        setResizable(false);//para que no se pueda editar 
        setResizable(false);
        setLocationRelativeTo(null);//centrar la interfaz para cuando se ejecute
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        
    }

    //cambiar la imagen del logo de la taza 
    //Inicio 
    @Override
    public Image getIconImage(){
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("imagenes/icono.png"));
        return retValue;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cmb_opcion = new javax.swing.JComboBox<>();
        jLabel_Wallpaper = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("¿Qué desea registrar?");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmb_opcion.setBackground(new java.awt.Color(255, 255, 255));
        cmb_opcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "----------------", "Administrador", "Mesero" }));
        cmb_opcion.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        cmb_opcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_opcionActionPerformed(evt);
            }
        });
        getContentPane().add(cmb_opcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, -1, -1));

        jLabel_Wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/opcionR.jpg"))); // NOI18N
        getContentPane().add(jLabel_Wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 199));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmb_opcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_opcionActionPerformed
        // TODO add your handling code here:
        int cmb;
        cmb = cmb_opcion.getSelectedIndex();
        System.out.println(cmb);
        if (cmb==1) {
           new frm_RegisterAdministrator().setVisible(true);
        }else if (cmb==2) {
           new frm_RegisterEmployee().setVisible(true);
        }
    }//GEN-LAST:event_cmb_opcionActionPerformed

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
            java.util.logging.Logger.getLogger(frm_RegistrationOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_RegistrationOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_RegistrationOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_RegistrationOption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_RegistrationOption().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cmb_opcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_Wallpaper;
    // End of variables declaration//GEN-END:variables
}
