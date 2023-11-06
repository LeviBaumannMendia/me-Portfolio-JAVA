
package Vistas;

import AccesoData.PaqueteData;
import AccesoData.TransporteData;
import Entidades.Paquete;
import Entidades.Transporte;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class AgregarTransporte extends javax.swing.JFrame {
    private  Transporte transporte;
    
    public AgregarTransporte() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboTransporte();
      
    }
    
        private void llenarComboTransporte() {
    jcbBuscarTransporte.removeAllItems();
    TransporteData transportedata = new TransporteData();

    Transporte seleccionInicial = new Transporte(-1, "Seleccione Transporte", "","", -1);
    
    ArrayList<Transporte> listaTransportes = transportedata.llenarComboTransporte();

    listaTransportes.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Transporte> transportes = new DefaultComboBoxModel<>(listaTransportes.toArray(new Transporte[0]));
    jcbBuscarTransporte.setModel(transportes);
}
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jcbBuscarTransporte = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtPrecio = new javax.swing.JTextField();
        jtEmpresa = new javax.swing.JTextField();
        jcServicio = new javax.swing.JComboBox<>();
        jcTipo = new javax.swing.JComboBox<>();
        jbAgregar = new javax.swing.JButton();
        jbEditarTransporte = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jcbBuscarTransporte.setBackground(new java.awt.Color(255, 255, 255));
        jcbBuscarTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarTransporteActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("TRANSPORTE");

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("SERVICIO");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("EMPRESA");

        jLabel3.setForeground(new java.awt.Color(255, 102, 51));
        jLabel3.setText("PRECIO");

        jtPrecio.setForeground(new java.awt.Color(51, 51, 51));
        jtPrecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));
        jtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPrecioKeyTyped(evt);
            }
        });

        jtEmpresa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtEmpresaKeyTyped(evt);
            }
        });

        jcServicio.setBackground(new java.awt.Color(255, 255, 255));
        jcServicio.setForeground(new java.awt.Color(255, 255, 255));
        jcServicio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "CAMA", "SEMICAMA", "SUITE", "TURISTA", "PRIMERA CLASE", "SEGUNDA CLASE" }));
        jcServicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jcServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcServicioActionPerformed(evt);
            }
        });

        jcTipo.setBackground(new java.awt.Color(255, 255, 255));
        jcTipo.setForeground(new java.awt.Color(255, 255, 255));
        jcTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "AVION", "COLECTIVO", "TREN" }));

        jbAgregar.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jbAgregar.setForeground(new java.awt.Color(0, 204, 102));
        jbAgregar.setText("Agregar");
        jbAgregar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbAgregarMouseExited(evt);
            }
        });
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbEditarTransporte.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbEditarTransporte.setText("Editar");
        jbEditarTransporte.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbEditarTransporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarTransporteActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(255, 0, 0));
        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbEliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbEliminarMouseExited(evt);
            }
        });
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbVolver.setFont(new java.awt.Font("sansserif", 0, 13)); // NOI18N
        jbVolver.setForeground(new java.awt.Color(255, 102, 51));
        jbVolver.setText("Volver al menú");
        jbVolver.setBorder(null);
        jbVolver.setBorderPainted(false);
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(jcbBuscarTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(101, 101, 101)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jcServicio, 0, 139, Short.MAX_VALUE)
                        .addComponent(jtPrecio)
                        .addComponent(jcTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbEditarTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jcbBuscarTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(45, 45, 45)
                                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel1)
                                            .addComponent(jcTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jbEditarTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(34, 34, 34)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jtEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(80, 80, 80)
                                .addComponent(jbAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53))))
        );

        jPanel8.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 19, Short.MAX_VALUE)
        );

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("AGREGAR TRANSPORTE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        Menu menu = new Menu();
        menu.show();
        dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        TransporteData trasData = new TransporteData();
        Transporte tras = new Transporte();
        
        
        try{
        
        if (jcTipo.getSelectedIndex() == 0 || jcServicio.getSelectedIndex() == 0 || "".equals(jtEmpresa.getText()) || jtPrecio.getText() == null || jtPrecio.getText().isEmpty()){
        
            JOptionPane.showMessageDialog(null, "No dejes campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        } else{
            
        tras.setTipoTransporte((String) jcTipo.getSelectedItem());
        tras.setServicio((String) jcServicio.getSelectedItem());
        tras.setEmpresa(jtEmpresa.getText());
        tras.setPrecioPasaje(Double.parseDouble(jtPrecio.getText()));
        
        String tipoTransporte = (String) jcTipo.getSelectedItem();
        String servicio = (String) jcServicio.getSelectedItem();
        String empresa =  jtEmpresa.getText();
        
      if (trasData.existeTransporte(tipoTransporte, servicio, empresa)) {
          
          JOptionPane.showMessageDialog(null, "Este transporte ya esta creado", "Error", JOptionPane.ERROR_MESSAGE);
          
      } else{

        trasData.guardarTransporte(tras);
        
        jcTipo.setSelectedIndex(0);
        jcServicio.setSelectedIndex(0);
        jtEmpresa.setText("");
        jtPrecio.setText("");
        
         llenarComboTransporte();
        }
    

        }
        }catch(NullPointerException nu){
            
        }
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jcServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcServicioActionPerformed

    private void jtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPrecioKeyTyped
      int key = evt.getKeyChar();

      char c = evt.getKeyChar();

    boolean esDigito = Character.isDigit(c);
    boolean esComa = (c == '.');

    if (!(esDigito || esComa || KeyEvent.VK_BACK_SPACE == evt.getKeyChar())) {
        evt.consume();
    }
    }//GEN-LAST:event_jtPrecioKeyTyped

    private void jtEmpresaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtEmpresaKeyTyped
       char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < 'á' || c >'ú') && (c < 'Á' || c >'Ú') && (c != 32) && (c!='\u00f1') && (c!='\u00d1') &&  (c != '.')) { 
            evt.consume();
        }
    }//GEN-LAST:event_jtEmpresaKeyTyped

    private void jcbBuscarTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarTransporteActionPerformed
        TransporteData traData = new TransporteData();
        
        try{
        transporte = (Transporte) jcbBuscarTransporte.getSelectedItem();
        
        Transporte transporteAMostrar = traData.buscarTransporte(transporte.getIdTransporte());
        
        
        String tipoTransporte = transporteAMostrar.getTipoTransporte().toUpperCase();
        String servicio = transporteAMostrar.getServicio().toUpperCase();
        String empresa = transporteAMostrar.getEmpresa();
        String precio = Double.toString(transporteAMostrar.getPrecioPasaje());
        
        jcTipo.setSelectedItem(tipoTransporte);
        jcServicio.setSelectedItem(servicio);
        jtEmpresa.setText(empresa);
        jtPrecio.setText(precio);
        
        }catch (NullPointerException nu){
            
        }
        
       
    }//GEN-LAST:event_jcbBuscarTransporteActionPerformed

    private void jbEditarTransporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarTransporteActionPerformed
        
        
        
        TransporteData editartransporte = new TransporteData();
        Transporte editar = new Transporte();
        
        
        Transporte transporteElegido = (Transporte) jcbBuscarTransporte.getSelectedItem();
        
        if (transporteElegido.getIdTransporte() < 1){
            
            JOptionPane.showMessageDialog(null, "Primero tenés que seleccionar un transporte", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }else if (jcTipo.getSelectedIndex() == 0 || jcServicio.getSelectedIndex() == 0 || "".equals(jtEmpresa.getText()) || jtPrecio.getText() == null || jtPrecio.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "No edites con campos vacíos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }else{
        
        editar.setTipoTransporte((String) jcTipo.getSelectedItem());
        editar.setServicio((String) jcServicio.getSelectedItem());
        editar.setEmpresa(jtEmpresa.getText());
        editar.setPrecioPasaje(Double.parseDouble(jtPrecio.getText()));
        editar.setIdTransporte(transporte.getIdTransporte());
        
        
        
        editartransporte.editarTransporte(editar);
        
        
        

        jcTipo.setSelectedIndex(0);
        jcServicio.setSelectedIndex(0);
        jtEmpresa.setText("");
        jtPrecio.setText("");
        llenarComboTransporte();
        
        }
        
    }//GEN-LAST:event_jbEditarTransporteActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        
        TransporteData transData = new TransporteData();
        
        
        
        
       transporte = (Transporte) jcbBuscarTransporte.getSelectedItem();
       int tra = transporte.getIdTransporte();
       
       
       if (tra < 1){
           JOptionPane.showMessageDialog(null, "Primero tenés que seleccionar un transporte", "Advertencia", JOptionPane.WARNING_MESSAGE);
           
           
       }else{
           
       
       if (transData.existePaqueteConTransporte(tra)){
           
           JOptionPane.showMessageDialog(null, "Este transporte está asociado a un paquete. No se puede eliminar", "Error", JOptionPane.ERROR_MESSAGE);
           
       }else{
           
           
           int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Seguro que querés eliminar este transporte?",
                        "Confirmación",
                        JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {

                    transData.elimninarTransporte(tra);
                    jcTipo.setSelectedIndex(0);
                    jcServicio.setSelectedIndex(0);
                    jtEmpresa.setText("");
                    jtPrecio.setText("");
                    llenarComboTransporte();
                }
       }
       }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbEliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarMouseEntered
        
        jbEliminar.setBackground(Color.RED);
        jbEliminar.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbEliminarMouseEntered

    private void jbEliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbEliminarMouseExited
        
        jbEliminar.setBackground(UIManager.getColor("Button.background"));
        jbEliminar.setForeground(Color.RED);
        
    }//GEN-LAST:event_jbEliminarMouseExited

    private void jbAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMouseEntered
        
        jbAgregar.setBackground(new Color(0, 204, 102));
        jbAgregar.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbAgregarMouseEntered

    private void jbAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAgregarMouseExited
        
        jbAgregar.setBackground(UIManager.getColor("Button.background"));
        jbAgregar.setForeground(new Color(0, 204, 102));
        
    }//GEN-LAST:event_jbAgregarMouseExited

   
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbEditarTransporte;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox<String> jcServicio;
    private javax.swing.JComboBox<String> jcTipo;
    private javax.swing.JComboBox<Transporte> jcbBuscarTransporte;
    private javax.swing.JTextField jtEmpresa;
    private javax.swing.JTextField jtPrecio;
    // End of variables declaration//GEN-END:variables
}
