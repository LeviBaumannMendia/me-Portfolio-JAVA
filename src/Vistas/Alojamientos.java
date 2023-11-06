package Vistas;
import AccesoData.AlojamientoData;
import AccesoData.CiudadData;
import Entidades.Alojamiento;
import Entidades.Ciudad;
import java.awt.Color;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;


public class Alojamientos extends javax.swing.JFrame {
    
    
    private Connection con = null;
    AlojamientoData aloData = new AlojamientoData();
    CiudadData ciuData = new CiudadData();
    Alojamiento alo = new Alojamiento();
    
    
    
    private final DefaultTableModel modelo = new DefaultTableModel(){
    @Override
    public boolean isCellEditable(int f, int c){
        
        
        if (c == 2 || c== 4 ){
            return true;
        }
        return false;
    }
};
    
    public Alojamientos() {
      
    initComponents();
    this.setLocationRelativeTo(null);
    this.setTitle("Alojamientos");
    llenarComboCiudad();

        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jcbAlojamientos = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jcbCiudades = new javax.swing.JComboBox<>();
        jtNombre = new javax.swing.JTextField();
        jtServicio = new javax.swing.JTextField();
        jtPrecios = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jSpinnerEstrellas = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbGuardar = new javax.swing.JButton();
        jbLimpiar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jtServicioEditable = new javax.swing.JTextField();
        jtPrecioACambiar = new javax.swing.JTextField();
        jtNombreHotel = new javax.swing.JTextField();
        jbEditar = new javax.swing.JButton();
        jsEstrellas = new javax.swing.JSpinner();
        jPanel8 = new javax.swing.JPanel();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jPanel7.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 11, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel2.setText("MODIFICAR SERVICIOS O PRECIOS");

        jcbAlojamientos.setBackground(new java.awt.Color(255, 255, 255));
        jcbAlojamientos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlojamientosItemStateChanged(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("AGREGAR ALOJAMIENTO");

        jcbCiudades.setBackground(new java.awt.Color(255, 255, 255));
        jcbCiudades.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCiudadesItemStateChanged(evt);
            }
        });

        jtPrecios.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtPreciosKeyTyped(evt);
            }
        });

        jLabel8.setText("PRECIO");

        jSpinnerEstrellas.setModel(new javax.swing.SpinnerNumberModel(3, 1, 5, 1));
        jSpinnerEstrellas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSpinnerEstrellasStateChanged(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(255, 102, 0));
        jLabel7.setText("ESTRELLAS");

        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("SERVICIO");

        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("NOMBRE DEL HOTEL");

        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("CIUDAD ");

        jbGuardar.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jbGuardar.setForeground(new java.awt.Color(0, 204, 102));
        jbGuardar.setText("GUARDAR");
        jbGuardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbGuardarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbGuardarMouseExited(evt);
            }
        });
        jbGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGuardarActionPerformed(evt);
            }
        });

        jbLimpiar.setFont(new java.awt.Font("sansserif", 0, 10)); // NOI18N
        jbLimpiar.setText("LIMPIAR CAMPOS");
        jbLimpiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jbVolver.setForeground(new java.awt.Color(255, 102, 51));
        jbVolver.setText("Volver al Menú");
        jbVolver.setBorder(null);
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtNombre)))
                        .addGap(18, 18, 18)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSpinnerEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jtPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jtServicio)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbLimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbVolver, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                .addGap(32, 32, 32))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jSpinnerEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jtPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jbGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jbEditar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jsEstrellas.setModel(new javax.swing.SpinnerNumberModel(1, 1, 5, 1));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(193, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jtNombreHotel, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtPrecioACambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtServicioEditable, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(172, 172, 172))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jtNombreHotel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtServicioEditable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtPrecioACambiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jsEstrellas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jbEditar)
                .addGap(31, 31, 31))
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(7, 7, 7)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbAlojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbAlojamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void llenarComboCiudad() {
    jcbCiudades.removeAllItems();
    CiudadData ciudadata = new CiudadData();
    Ciudad ciu = new Ciudad(-1,"Seleccione Ciudad", "", "");
    ArrayList<Ciudad> lista = ciudadata.obtenerCiudades();
    lista.add(0, ciu); 
    DefaultComboBoxModel<Ciudad> ciudades = new DefaultComboBoxModel<>(lista.toArray(new Ciudad[0]));
    jcbCiudades.setModel(ciudades);
}
    
    
    
    private void llenarComboAlojamiento() {
    jcbAlojamientos.removeAllItems();

    
    Ciudad ciudadElegida = (Ciudad) jcbCiudades.getSelectedItem();
    int ciudadquenecesito = ciudadElegida.getIdCiudad();
    Alojamiento selec = new Alojamiento(-1,null, "Seleccione Hotel", null, -1, -1, false);
    
    
    ArrayList<Alojamiento> listaAloj = aloData.llenarComboAlojamientos(ciudadquenecesito);
    listaAloj.add(0, selec);
    DefaultComboBoxModel<Alojamiento> alobox = new DefaultComboBoxModel<>(listaAloj.toArray(new Alojamiento[0]));
    jcbAlojamientos.setModel(alobox);

}
    
    
    private void llenarCampos(){
    
        Alojamiento alojamientoElegido = (Alojamiento) jcbAlojamientos.getSelectedItem();
        
        try{
            
            
        
         if (alojamientoElegido.getIdAlojamiento() < 1){
             jtNombreHotel.setText("");
            jtServicioEditable.setText("");
            jtPrecioACambiar.setText("");
            jsEstrellas.setValue("");
         }else{
            
            
        jtNombreHotel.setText(alojamientoElegido.getNombreHotel());
        jtServicioEditable.setText(alojamientoElegido.getServicio());
        jtPrecioACambiar.setText(String.valueOf(alojamientoElegido.getPrecio()));
        jsEstrellas.setValue(alojamientoElegido.getEstrellas());
        
         }
        }catch (NullPointerException nu){
            
        }
            
    
}
    
    
    
    
    private void jbGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGuardarActionPerformed
    
     
        
        try{
        
        
        Ciudad ciu = (Ciudad) jcbCiudades.getSelectedItem();
        
        int idCiu = ciu.getIdCiudad();
            
        

        
        if( jcbCiudades.getSelectedIndex() == 0){
            
            JOptionPane.showMessageDialog(null, "Seleccioná un alojamiento primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        } else if ("".equals(jtNombre.getText()) || "".equals(jtServicio.getText()) || jtPrecios.getText() == null || jtPrecios.getText().isEmpty()){
        
        
             JOptionPane.showMessageDialog(null, "No debe haber ningun campo vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
        
        
    }else{
            
            
            if (aloData.existeAlojamiento(idCiu, jtNombre.getText())){
                
                JOptionPane.showMessageDialog(null, "Ya existe ese hotel en esa ciudad", "Advertencia", JOptionPane.WARNING_MESSAGE);
                
            }else{
        
    alo.setNombreHotel(jtNombre.getText());
    alo.setEstrellas((int) jSpinnerEstrellas.getValue());
    alo.setCiudadDestino((Ciudad) jcbCiudades.getSelectedItem());
    alo.setServicio(jtServicio.getText());
    alo.setPrecio(Double.parseDouble(jtPrecios.getText()));
     
    
    aloData.guardarAlojamiento(alo);
        
            }
        }
        }catch (NullPointerException nu){
                
        
        }
    }//GEN-LAST:event_jbGuardarActionPerformed

    
    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
    Menu menu = new Menu();
    menu.show();
    dispose();
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
    
    jcbCiudades.setSelectedIndex(0);
    jtNombre.setText("");
    jtServicio.setText("");
    jtPrecios.setText("");
    }//GEN-LAST:event_jbLimpiarActionPerformed

    
        
    private void jSpinnerEstrellasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSpinnerEstrellasStateChanged
//    SpinnerNumberModel nm=  new SpinnerNumberModel();
//    nm.setMaximum(5);
//    nm.setMinimum(1);
//    nm.setStepSize(1);
//    jSpinnerEstrellas.setModel(nm);
    }//GEN-LAST:event_jSpinnerEstrellasStateChanged

    private void jcbCiudadesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCiudadesItemStateChanged
        
        jtNombreHotel.setText("");
        jtServicioEditable.setText("");
        jtPrecioACambiar.setText("");
        jsEstrellas.setValue(0);
        llenarComboAlojamiento();
        
        
    }//GEN-LAST:event_jcbCiudadesItemStateChanged

    private void jcbAlojamientosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlojamientosItemStateChanged
        
        modelo.setRowCount(0);
        llenarCampos();
        
    }//GEN-LAST:event_jcbAlojamientosItemStateChanged

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        
        Alojamiento alojamiento =  new Alojamiento();
        AlojamientoData alojamientodata = new AlojamientoData();

        try{

         Alojamiento alojSeleccionado = (Alojamiento) jcbAlojamientos.getSelectedItem();

         if (alojSeleccionado.getIdAlojamiento() < 1){
            JOptionPane.showMessageDialog(null, "Tenes que editar un alojamiento que exista", "Advertencia", JOptionPane.WARNING_MESSAGE);

         }else{

            alojamiento.setIdAlojamiento(alojSeleccionado.getIdAlojamiento());
            alojamiento.setNombreHotel(jtNombreHotel.getText());
            alojamiento.setServicio(jtServicioEditable.getText());
            alojamiento.setEstrellas((int) jsEstrellas.getValue());
            alojamiento.setPrecio(Double.parseDouble(jtPrecioACambiar.getText()));



         if ("".equals(jtNombreHotel.getText()) || "".equals(jtServicioEditable.getText())){

                  int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Seguro que querés editar el alojamiento con campos vacíos?",
                        "Confirmación",
                        JOptionPane.OK_CANCEL_OPTION);

                  if (opcion == JOptionPane.OK_OPTION) {
                        alojamientodata.modificarAlojamiento(alojamiento);
                        jtNombreHotel.setText("");
                        jtServicioEditable.setText("");
                        jtPrecioACambiar.setText("");
                        jsEstrellas.setValue(0);
                        llenarComboAlojamiento();

                 }else{
                      
                      
                      
                        jtNombreHotel.setText(alojSeleccionado.getNombreHotel());
                        jtServicioEditable.setText(alojSeleccionado.getServicio());
                        jsEstrellas.setValue(alojSeleccionado.getEstrellas());
                        jtPrecioACambiar.setText(String.valueOf(alojSeleccionado.getPrecio()));
                  }

        }else{
            alojamientodata.modificarAlojamiento(alojamiento);
            jtNombreHotel.setText("");
            jtServicioEditable.setText("");
            jtPrecioACambiar.setText("");
            jsEstrellas.setValue(0);
            llenarComboAlojamiento();
        }

        }
         
        }catch (NumberFormatException num){
            JOptionPane.showMessageDialog(null, "No se puede poner un precio vacío", "Error", JOptionPane.ERROR_MESSAGE);
            
             Alojamiento alojSeleccionado = (Alojamiento) jcbAlojamientos.getSelectedItem();
             
              jtNombreHotel.setText(alojSeleccionado.getNombreHotel());
              jtServicioEditable.setText(alojSeleccionado.getServicio());
              jsEstrellas.setValue(alojSeleccionado.getEstrellas());
              jtPrecioACambiar.setText(String.valueOf(alojSeleccionado.getPrecio()));
        }catch (NullPointerException nu){
            
            JOptionPane.showMessageDialog(null, "Tenes que editar un alojamiento que exista", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }
        
        
        
    }//GEN-LAST:event_jbEditarActionPerformed

    private void jtPreciosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtPreciosKeyTyped
        
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;
        
        if (!numeros)
        {
            evt.consume();
        }
        
    }//GEN-LAST:event_jtPreciosKeyTyped

    private void jbGuardarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGuardarMouseEntered
        
        jbGuardar.setBackground(new Color(0, 204, 102));
        jbGuardar.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbGuardarMouseEntered

    private void jbGuardarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbGuardarMouseExited
        
        jbGuardar.setBackground(UIManager.getColor("Button.background"));
        jbGuardar.setForeground(new Color(0, 204, 102));
        
    }//GEN-LAST:event_jbGuardarMouseExited
    
    
    
    
    
    
    
    
    /*private void armarCabecera(){
   
    modelo.addColumn("CIUDAD");
    modelo.addColumn("NOMBRE");
    modelo.addColumn("SERVICIO");
    modelo.addColumn("CAT");
    modelo.addColumn("PRECIO");
   
    jTablaHoteles.setModel(modelo);
    } */
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JSpinner jSpinnerEstrellas;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbGuardar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox<Alojamiento> jcbAlojamientos;
    private javax.swing.JComboBox<Ciudad> jcbCiudades;
    private javax.swing.JSpinner jsEstrellas;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtNombreHotel;
    private javax.swing.JTextField jtPrecioACambiar;
    private javax.swing.JTextField jtPrecios;
    private javax.swing.JTextField jtServicio;
    private javax.swing.JTextField jtServicioEditable;
    // End of variables declaration//GEN-END:variables

  
}
