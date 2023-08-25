/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cmdlab2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AdminColeexz
 */
public class CMD extends javax.swing.JFrame {

    static CMDLogic cmdlogic = new CMDLogic();
    static String[] lines;

    public CMD(CMDLogic cmdlogic) {
        initComponents();
        this.cmdlogic = cmdlogic;
        textareacmd.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    try {
                        String lastLine = getLastLine(textareacmd.getText());
                        String comando = getPenultimateWord(textareacmd.getText());
                        String ultima = getUltimateWord(textareacmd.getText());
                        System.out.println("Ultima linea ingresada: " + lastLine);
                        System.out.println("Comando ingresado: " + comando);
                        System.out.println("Ultima palabra ingresada: " + ultima);

                        switch (comando) {
                            case "cd":
                                cmdlogic.setFile(ultima);
                                System.out.println("Archivo seteado en " + ultima);

                                break;

                            case "mkdir":

                                cmdlogic.setFile(ultima);
                                System.out.println("Archivo seteado en " + ultima);
                                cmdlogic.crearFolder();
                                System.out.println("Folder creado.");

                                break;

                            case "mfile":
                                cmdlogic.setFile(ultima);
                                System.out.println("Archivo seteado en " + ultima);
                                cmdlogic.crearFile();
                                break;

                            case "rm":
                                cmdlogic.eliminarArchivo(ultima);
                                System.out.println("Carpeta o archivo eliminado.");
                                break;

                            case "...":
                                cmdlogic.regresar();
                                System.out.println("Has regresado.");
                                break;
                                
                            case "dir":
                                cmdlogic.Dir();
                                
                                break;
                                
                            case "date":
                                cmdlogic.toStringFecha();
                                break;
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(CMD.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    private static String getLastLine(String text) {
        lines = text.split("\n");
        if (lines.length > 0) {
            return lines[lines.length - 1];
        }
        return "";
    }

    private static String getPenultimateWord(String text) {
        String[] comando = text.split("\\s+");
        if (comando.length > 1) {
            return comando[comando.length - 2];
        }
        return "";
    }

    private static String getUltimateWord(String text) {
        String[] comando = text.split("\\s+");
        if (comando.length > 1) {
            return comando[comando.length - 1];
        }
        return "";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textareacmd = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        textareacmd.setBackground(new java.awt.Color(0, 0, 0));
        textareacmd.setColumns(20);
        textareacmd.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        textareacmd.setForeground(new java.awt.Color(255, 255, 255));
        textareacmd.setRows(5);
        textareacmd.setText("\n");
        jScrollPane1.setViewportView(textareacmd);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 994, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CMD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CMD(cmdlogic).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textareacmd;
    // End of variables declaration//GEN-END:variables
}
