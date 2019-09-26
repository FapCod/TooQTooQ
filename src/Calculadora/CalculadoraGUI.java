package calculadora;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;


public final class CalculadoraGUI extends JFrame {

    String Historial = "";
    String entrada = "";

    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }
        new CalculadoraGUI().setVisible(true);
    }

    public CalculadoraGUI() {
        initComponents();
        RefrescarPantalla();
        setTitle("Calculadora básica");
        //para evitar que el programa finalice al cerrar la interfaz de registro de usuario
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//al ser cerrada el programa dejara de ejecutarla(evita que se ejecute en segundo plano)
        new Thread() {
            @Override
            public void run() {
                 /*metodo camiar icono de tasita*/
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("src/imagenes/icono.png"));
        } catch (IOException ex) {
            Logger.getLogger(CalculadoraGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        setIconImage(image);
        /*Fin de metodo*/
            }
        }.start();
        setLocationRelativeTo(null);
        AgregarAcciones();
        
    }

    void AgregarAcciones() {
        ((BotónTeclado) jLabel7).acción = new Acción() {
            @Override
            public void Ejecutar() {
                entrada = "";
                RefrescarPantalla();
            }
        };
        ((BotónTeclado) jLabel8).acción = () -> {
            Historial = "";
            entrada = "";
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel9).acción = () -> {
            try {
                entrada = entrada.substring(0, entrada.length() - 1);
            } catch (Exception e) {
            }
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel5).acción = () -> {
            try {
                double n = Double.parseDouble(entrada);
                n = n * n;
                if (n == (long) n) {
                    entrada = (long) n + "";
                } else {
                    entrada = String.format("%.4f", n).replace(",", ".");
                }
            } catch (Exception e) {
            }
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel6).acción = () -> {
            try {
                double n = Double.parseDouble(entrada);
                n = n * n * n;
                if (n == (long) n) {
                    entrada = (long) n + "";
                } else {
                    entrada = String.format("%.4f", n).replace(",", ".");
                }
            } catch (Exception e) {
            }
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel3).acción = () -> {
            try {
                String p = entrada;
                double n = Double.parseDouble(p);
                n /= 100;
                if (n == (long) n) {
                    entrada = (long) n + "";
                } else {
                    entrada = String.format("%.2f", n).replace(",", ".");
                }
                RefrescarPantalla();
                jLabel2.setText(p + "%");
            } catch (Exception e) {
            }
        };
        ((BotónTeclado) jLabel4).acción = () -> {
            try {
                double n = Double.parseDouble(entrada);
                double sqrt = Math.sqrt(n);
                if (sqrt == (long) sqrt) {
                    entrada = (long) sqrt + "";
                } else {
                    entrada = String.format("%.4f", sqrt).replace(",", ".");
                }
            } catch (Exception e2) {
            }
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel23).acción = () -> {
            try {
                double n = Double.parseDouble(entrada);
                if (n == (long) n) {
                    entrada = (long) (-n) + "";
                } else {
                    entrada = -n + "";
                }
            } catch (Exception e) {
            }
            RefrescarPantalla();
        };
        ((BotónTeclado) jLabel25).acción = () -> {
            if (!entrada.contains(".")) {
                entrada += ".";
            }
            RefrescarPantalla();
        };
        BotónTeclado[] operadores = {
            (BotónTeclado) jLabel10, (BotónTeclado) jLabel14, (BotónTeclado) jLabel18,
            (BotónTeclado) jLabel22
        };
        for (BotónTeclado operador : operadores) {
            operador.acción = () -> {
                BorrarNaN();
                if (entrada.isEmpty()) {
                    if (operador.getText().equals("-")) {
                        entrada = "-";
                    }
                } else {
                    if (!entrada.equals("-")) {
                        Historial += entrada;
                        Historial += operador.getText();
                        entrada = "";
                    }
                }
                RefrescarPantalla();
                if (!entrada.equals("-")) {
                    String resultado = Interpretar();
                    if (resultado.length() >= 48) {
                        jLabel2.setText("..." + resultado.substring(resultado.length() - 48));
                    } else {
                        jLabel2.setText(resultado);
                    }
                }
            };
        }
        BotónTeclado[] números = {
            (BotónTeclado) jLabel11, (BotónTeclado) jLabel12, (BotónTeclado) jLabel13,
            (BotónTeclado) jLabel15, (BotónTeclado) jLabel16, (BotónTeclado) jLabel17,
            (BotónTeclado) jLabel19, (BotónTeclado) jLabel20, (BotónTeclado) jLabel21,
            (BotónTeclado) jLabel24
        };
        for (BotónTeclado número : números) {
            número.acción = () -> {
                BorrarNaN();
                if (número.getText().equals("0")) {
                    if (entrada.isEmpty()) {
                        return;
                    }
                }
                entrada += número.getText();
                RefrescarPantalla();
            };
        }
        ((BotónTeclado) jLabel26).acción = () -> {
            if (Historial.isEmpty()) {
                return;
            }
            Historial += entrada;
            entrada = Interpretar() + "";
            Historial = "";
            RefrescarPantalla();
        };
    }

    void BorrarNaN() {
        if (entrada.equals("NaN")) {
            entrada = "";
        }
    }

    String Interpretar() {
        return InterpretadorExpresionesMatemáticas_Básicas.Interpretar(Historial);
    }

    public void RefrescarPantalla() {
        if (Historial.length() >= 100) {
            jLabel1.setText("..." + Historial.substring(Historial.length() - 100));
        } else {
            jLabel1.setText(Historial);
        }
        if (entrada.equals("")) {
            jLabel2.setText("0");
        } else {
            if (entrada.length() >= 50) {
                jLabel2.setText("..." + entrada.substring(entrada.length() - 50));
            } else {
                jLabel2.setText(entrada);
            }
        }
    }

    JLabel lblPantalla() {
        return new JLabel() {
            @Override
            public void paint(Graphics grphcs) {
                Graphics2D g = (Graphics2D) grphcs;
                g.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                );
                super.paint(g);
            }
        };
    }

    JRadioButton SiempreVisible() {
        return new JRadioButton() {
            @Override
            public void paint(Graphics grphcs) {
                BufferedImage f = new BufferedImage(getWidth(), getHeight(), 2);
                {
                    Graphics2D g = f.createGraphics();
                    g.setRenderingHint(
                            RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON
                    );
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());
                    super.paint(g);
                }
                Graphics2D g = (Graphics2D) grphcs;
                g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, .4f));
                g.drawImage(f, 0, 0, null);
            }
        };
    }

    JLabel lblTeclado() {
        return new BotónTeclado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = lblTeclado();
        jLabel5 = lblTeclado();
        jLabel6 = lblTeclado();
        jLabel3 = lblTeclado();
        jLabel7 = lblTeclado();
        jLabel8 = lblTeclado();
        jLabel9 = lblTeclado();
        jLabel10 = lblTeclado();
        jLabel11 = lblTeclado();
        jLabel12 = lblTeclado();
        jLabel13 = lblTeclado();
        jLabel14 = lblTeclado();
        jLabel15 = lblTeclado();
        jLabel16 = lblTeclado();
        jLabel17 = lblTeclado();
        jLabel18 = lblTeclado();
        jLabel19 = lblTeclado();
        jLabel20 = lblTeclado();
        jLabel21 = lblTeclado();
        jLabel22 = lblTeclado();
        jLabel23 = lblTeclado();
        jLabel24 = lblTeclado();
        jLabel25 = lblTeclado();
        jLabel26 = lblTeclado();
        jLabel2 =  lblPantalla();
        jLabel1 =  lblPantalla();
        jRadioButton1 = SiempreVisible();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        jPanel2.setBackground(new java.awt.Color(151, 158, 170));

        jPanel1.setBackground(new java.awt.Color(151, 158, 170));
        jPanel1.setLayout(new java.awt.GridLayout(6, 4, 3, 3));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("√");
        jPanel1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("x²");
        jPanel1.add(jLabel5);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("x³");
        jPanel1.add(jLabel6);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("%");
        jPanel1.add(jLabel3);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CE");
        jPanel1.add(jLabel7);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("C");
        jPanel1.add(jLabel8);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("◄");
        jPanel1.add(jLabel9);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("÷");
        jPanel1.add(jLabel10);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("7");
        jPanel1.add(jLabel11);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("8");
        jPanel1.add(jLabel12);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("9");
        jPanel1.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("×");
        jPanel1.add(jLabel14);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("4");
        jPanel1.add(jLabel15);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("5");
        jPanel1.add(jLabel16);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("6");
        jPanel1.add(jLabel17);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("+");
        jPanel1.add(jLabel18);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("1");
        jPanel1.add(jLabel19);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("2");
        jPanel1.add(jLabel20);

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("3");
        jPanel1.add(jLabel21);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("-");
        jPanel1.add(jLabel22);

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("±");
        jPanel1.add(jLabel23);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("0");
        jPanel1.add(jLabel24);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText(".");
        jPanel1.add(jLabel25);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("=");
        jPanel1.add(jLabel26);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 44)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("8893");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(229, 229, 229));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("4444+4444+5");

        jRadioButton1.setBackground(new java.awt.Color(151, 158, 170));
        jRadioButton1.setText("Siempre visible");
        jRadioButton1.setBorder(null);
        jRadioButton1.setFocusable(false);
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jRadioButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 331, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        int ascii = evt.getKeyCode();
        if (ascii >= KeyEvent.VK_NUMPAD0 && ascii <= KeyEvent.VK_NUMPAD9) {
            ascii = ascii - KeyEvent.VK_NUMPAD0 + KeyEvent.VK_0;
        }
        BotónTeclado btn = null;
        switch (ascii) {
            case KeyEvent.VK_0:
            case KeyEvent.VK_1:
            case KeyEvent.VK_2:
            case KeyEvent.VK_3:
            case KeyEvent.VK_4:
            case KeyEvent.VK_5:
            case KeyEvent.VK_6:
            case KeyEvent.VK_7:
            case KeyEvent.VK_8:
            case KeyEvent.VK_9:
                String número = (char) ascii + "";
                if (número.equals("0")) {
                    if (entrada.isEmpty()) {
                        return;
                    }
                }
                entrada += número;
                RefrescarPantalla();
                return;
            case KeyEvent.VK_PLUS:
            case KeyEvent.VK_ADD:
                btn = (BotónTeclado) jLabel18;
                break;
            case KeyEvent.VK_MINUS:
            case KeyEvent.VK_SUBTRACT:
                btn = (BotónTeclado) jLabel22;
                break;
            case KeyEvent.VK_ASTERISK:
            case KeyEvent.VK_MULTIPLY:
                btn = (BotónTeclado) jLabel14;
                break;
            case KeyEvent.VK_SLASH:
            case KeyEvent.VK_DIVIDE:
                btn = (BotónTeclado) jLabel10;
                break;
            case KeyEvent.VK_EQUALS:
            case KeyEvent.VK_ENTER:
                btn = (BotónTeclado) jLabel26;
                break;
            case KeyEvent.VK_PERIOD:
            case KeyEvent.VK_DECIMAL:
            case KeyEvent.VK_COMMA:
                btn = (BotónTeclado) jLabel25;
                break;
            case KeyEvent.VK_BACK_SPACE:
                btn = (BotónTeclado) jLabel9;
                break;
        }
        if (btn != null) {
            btn.acción.Ejecutar();
        }
    }//GEN-LAST:event_formKeyReleased

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        setAlwaysOnTop(jRadioButton1.isSelected());
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables

}
