/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Pato
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Menu");
    }

    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jbVerPaquetes = new javax.swing.JButton();
        jbAdministrarPaquetes = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jbCerrarSesion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jbAgregarAlojamiento = new javax.swing.JButton();
        jbAgregarTransporte = new javax.swing.JButton();
        jbAgregarCiudad = new javax.swing.JButton();
        jbCrearPaquete = new javax.swing.JButton();
        jbClientes = new javax.swing.JButton();
        jbAdministrarClientes = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        escritorio = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setOpaque(false);
        jPanel2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jbVerPaquetes.setBackground(new java.awt.Color(51, 51, 51));
        jbVerPaquetes.setForeground(new java.awt.Color(255, 255, 255));
        jbVerPaquetes.setText("Ver Paquetes");
        jbVerPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerPaquetesActionPerformed(evt);
            }
        });

        jbAdministrarPaquetes.setBackground(new java.awt.Color(255, 102, 51));
        jbAdministrarPaquetes.setText("Administrar Paquetes");
        jbAdministrarPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdministrarPaquetesActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 25, Short.MAX_VALUE)
        );

        jbCerrarSesion.setText("Cerrar Sesión");
        jbCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbCerrarSesionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbCerrarSesionMouseExited(evt);
            }
        });
        jbCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jbVerPaquetes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdministrarPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCerrarSesion)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbVerPaquetes)
                            .addComponent(jbAdministrarPaquetes)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jbCerrarSesion)))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/montaña.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFocusable(false);

        jbAgregarAlojamiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/h-cuadrado (1).png"))); // NOI18N
        jbAgregarAlojamiento.setText(" Alojamientos");
        jbAgregarAlojamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarAlojamientoActionPerformed(evt);
            }
        });

        jbAgregarTransporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/volante.png"))); // NOI18N
        jbAgregarTransporte.setText("Transporte");
        jbAgregarTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarTransporteActionPerformed(evt);
            }
        });

        jbAgregarCiudad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edificio.png"))); // NOI18N
        jbAgregarCiudad.setText(" Destinos");
        jbAgregarCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarCiudadActionPerformed(evt);
            }
        });

        jbCrearPaquete.setForeground(new java.awt.Color(0, 204, 153));
        jbCrearPaquete.setText("Crear Paquete");
        jbCrearPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbCrearPaqueteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbCrearPaqueteMouseExited(evt);
            }
        });
        jbCrearPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearPaqueteActionPerformed(evt);
            }
        });

        jbClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/picpersonas-llenas.png"))); // NOI18N
        jbClientes.setText(" Clientes");
        jbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbClientesActionPerformed(evt);
            }
        });

        jbAdministrarClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/id-insignia.png"))); // NOI18N
        jbAdministrarClientes.setText(" Administrar Clientes");
        jbAdministrarClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdministrarClientesActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(0, 204, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        escritorio.setOpaque(false);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jbAgregarCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregarTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAgregarAlojamiento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbCrearPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(401, 401, 401)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbAdministrarClientes)
                .addGap(1312, 1312, 1312))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(escritorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbAgregarCiudad)
                                .addComponent(jbAgregarTransporte)
                                .addComponent(jbAgregarAlojamiento)
                                .addComponent(jbCrearPaquete))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jbClientes)
                                .addComponent(jbAdministrarClientes))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAdministrarPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdministrarPaquetesActionPerformed
        AdministrarPaquetes ap = new AdministrarPaquetes();
        ap.show();
        dispose();
    }//GEN-LAST:event_jbAdministrarPaquetesActionPerformed

    private void jbVerPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerPaquetesActionPerformed
        PaqueteElegido paqueteElegido = new PaqueteElegido();
        paqueteElegido.show();
        dispose();
        //escritorio.removeAll();
        //escritorio.repaint();
        //VerPaquetes vp = new VerPaquetes();
        //vp.setVisible(true);
        //escritorio.add(vp);
        //escritorio.moveToFront(vp);
    }//GEN-LAST:event_jbVerPaquetesActionPerformed

    private void jbAdministrarClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdministrarClientesActionPerformed

        AdministrarClientes admiCli = new AdministrarClientes();
        admiCli.show();
        dispose();

    }//GEN-LAST:event_jbAdministrarClientesActionPerformed

    private void jbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbClientesActionPerformed

        Clientes vistaClientes = new Clientes();
        vistaClientes.show();
        dispose();

    }//GEN-LAST:event_jbClientesActionPerformed

    private void jbCrearPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearPaqueteActionPerformed
        CrearPaquete crearpaquete = new CrearPaquete();
        crearpaquete.show();
        dispose();
    }//GEN-LAST:event_jbCrearPaqueteActionPerformed

    private void jbAgregarCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarCiudadActionPerformed

        Ciudades ciu = new Ciudades();
        ciu.show();
        dispose();

    }//GEN-LAST:event_jbAgregarCiudadActionPerformed

    private void jbAgregarTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarTransporteActionPerformed
        AgregarTransporte agregarTransporte = new AgregarTransporte();
        agregarTransporte.show();
        dispose();
    }//GEN-LAST:event_jbAgregarTransporteActionPerformed

    private void jbAgregarAlojamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarAlojamientoActionPerformed
        Alojamientos aa = new Alojamientos();
        aa.show();
        dispose();
    }//GEN-LAST:event_jbAgregarAlojamientoActionPerformed

    private void jbCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCerrarSesionActionPerformed
        
        int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Seguro que querés cerrar sesión?",
                        "¿De verdad?",
                        JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    Inicio inicio = new Inicio();
                    inicio.show();
                    dispose(); // Cierra la ventana
                    
                }
        
    }//GEN-LAST:event_jbCerrarSesionActionPerformed

    private void jbCerrarSesionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarSesionMouseEntered
        
        jbCerrarSesion.setBackground(Color.RED);
        jbCerrarSesion.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbCerrarSesionMouseEntered

    private void jbCerrarSesionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCerrarSesionMouseExited
        
        jbCerrarSesion.setBackground(UIManager.getColor("Button.background"));
        jbCerrarSesion.setForeground(UIManager.getColor("Button.foreground"));
        
    }//GEN-LAST:event_jbCerrarSesionMouseExited

    private void jbCrearPaqueteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCrearPaqueteMouseEntered
        
        jbCrearPaquete.setBackground(new Color(0, 204, 153));
        jbCrearPaquete.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbCrearPaqueteMouseEntered

    private void jbCrearPaqueteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbCrearPaqueteMouseExited
        
        jbCrearPaquete.setBackground(UIManager.getColor("Button.background"));
        jbCrearPaquete.setForeground(new Color(0, 204, 153));
        
        
    }//GEN-LAST:event_jbCrearPaqueteMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JButton jbAdministrarClientes;
    private javax.swing.JButton jbAdministrarPaquetes;
    private javax.swing.JButton jbAgregarAlojamiento;
    private javax.swing.JButton jbAgregarCiudad;
    private javax.swing.JButton jbAgregarTransporte;
    private javax.swing.JButton jbCerrarSesion;
    private javax.swing.JButton jbClientes;
    private javax.swing.JButton jbCrearPaquete;
    private javax.swing.JButton jbVerPaquetes;
    // End of variables declaration//GEN-END:variables
}
