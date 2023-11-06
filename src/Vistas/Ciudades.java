
package Vistas;

import AccesoData.CiudadData;
import Entidades.Ciudad;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


public class Ciudades extends javax.swing.JFrame {

    /**
     * Creates new form Ciudades
     */
    public Ciudades() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboCiudad();
    }

    
    
    
    
    
    
    
    
    private void llenarComboCiudad() {
    jcbCiudades.removeAllItems();
    CiudadData ciuData = new CiudadData();

    Ciudad seleccionInicial = new Ciudad(-1, "Seleccione Ciudad", null, "");
    
    ArrayList<Ciudad> listaCiudades = ciuData.obtenerCiudades();
    
    listaCiudades.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Ciudad> ciudades = new DefaultComboBoxModel<>(listaCiudades.toArray(new Ciudad[0]));
    jcbCiudades.setModel(ciudades);
}
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtNombreCiudad = new javax.swing.JTextField();
        jcbCiudades = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcbProvincias = new javax.swing.JComboBox<>();
        jbEditar = new javax.swing.JButton();
        jbListo = new javax.swing.JButton();
        jbMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 0));
        jLabel6.setText("AGREGAR CIUDADES");

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

        jPanel2.setForeground(new java.awt.Color(60, 63, 65));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre:");

        jtNombreCiudad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreCiudadKeyTyped(evt);
            }
        });

        jcbCiudades.setBackground(new java.awt.Color(255, 255, 255));
        jcbCiudades.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCiudadesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Provincia:");

        jcbProvincias.setBackground(new java.awt.Color(255, 255, 255));
        jcbProvincias.setForeground(new java.awt.Color(60, 63, 65));
        jcbProvincias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Provincia", "Buenos Aires", "Catamarca", "Chaco", "Chubut", "Córdoba", "Corrientes", "Entre Ríos", "Formosa", "Jujuy", "La Pampa", "La Rioja", "Mendoza", "Misiones", "Neuquén", "Río Negro", "Salta", "San Juan", "San Luis", "Santa Cruz", "Santa Fe", "Santiago del Estero", "Tierra del Fuego", "Tucumán" }));

        jbEditar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbEditar.setText("Editar");
        jbEditar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEditarActionPerformed(evt);
            }
        });

        jbListo.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbListo.setForeground(new java.awt.Color(0, 204, 102));
        jbListo.setText("Agregar");
        jbListo.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbListo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jbListoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jbListoMouseExited(evt);
            }
        });
        jbListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbListoActionPerformed(evt);
            }
        });

        jbMenu.setForeground(new java.awt.Color(255, 102, 51));
        jbMenu.setText("Volver al menú");
        jbMenu.setBorder(null);
        jbMenu.setBorderPainted(false);
        jbMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jcbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbListo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(112, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jcbCiudades, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombreCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jcbProvincias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(67, 67, 67)
                        .addComponent(jbEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jbListo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addComponent(jbMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuActionPerformed

        Menu menu = new Menu();
        menu.show();
        dispose();

    }//GEN-LAST:event_jbMenuActionPerformed

    private void jbListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbListoActionPerformed

        CiudadData ciuData = new CiudadData();
        Ciudad ciudad = new Ciudad();

        ciudad.setNombre(jtNombreCiudad.getText());
        ciudad.setPais("Argentina");
        ciudad.setProvincia(jcbProvincias.getSelectedItem().toString());

        String nombre = jtNombreCiudad.getText();
        String provincia = jcbProvincias.getSelectedItem().toString();

        if(ciudad.getNombre().isEmpty() || "Seleccione Provincia".equals(ciudad.getProvincia())){
            JOptionPane.showMessageDialog(null,"No existe ninguna ciudad o provincia sin nombre", "Error", JOptionPane.ERROR_MESSAGE);

        }else if (ciuData.existeNombreCiudad(nombre, provincia)){
            JOptionPane.showMessageDialog(null,"Ya existe esa ciudad", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            ciuData.guardarCiudad(ciudad);
            jtNombreCiudad.setText("");

            llenarComboCiudad();
        }

    }//GEN-LAST:event_jbListoActionPerformed

    private void jbEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEditarActionPerformed
        CiudadData ciuData = new CiudadData();

        Ciudad ciudadElegida = (Ciudad) jcbCiudades.getSelectedItem();

        String nombre = jtNombreCiudad.getText();
        String provincia = (String) jcbProvincias.getSelectedItem();

        if (ciudadElegida.getIdCiudad() < 1){

            JOptionPane.showMessageDialog(null, "Seleccioná una ciudad para poder editar", "Error", JOptionPane.ERROR_MESSAGE);

        }else if ("".equals(jtNombreCiudad.getText()) || jcbProvincias.getSelectedIndex() == 0){
            
            JOptionPane.showMessageDialog(null, "No se puede editar con un nombre o provincia vacíos", "Error", JOptionPane.ERROR_MESSAGE);
            
            
        }else{

            int idCiudad = ciudadElegida.getIdCiudad();
            ciuData.editarCiudad(idCiudad, nombre, provincia);
            jtNombreCiudad.setText("");
            jcbProvincias.setSelectedIndex(0);
            llenarComboCiudad();
        }

    }//GEN-LAST:event_jbEditarActionPerformed

    private void jcbCiudadesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCiudadesActionPerformed

        Ciudad ciudadElegida = (Ciudad) jcbCiudades.getSelectedItem();

        try{

            String nombreciudad = ciudadElegida.getNombre();
            String provincia = ciudadElegida.getProvincia();

            jtNombreCiudad.setText(nombreciudad);
            jcbProvincias.setSelectedItem(provincia);
        }catch (NullPointerException nu){

        }
    }//GEN-LAST:event_jcbCiudadesActionPerformed

    private void jtNombreCiudadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreCiudadKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < 'á' || c >'ú') && (c < 'Á' || c >'Ú') && (c != 32) && (c!='\u00f1') && (c!='\u00d1')) {
            evt.consume();
        }

    }//GEN-LAST:event_jtNombreCiudadKeyTyped

    private void jbListoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbListoMouseEntered
        
        jbListo.setBackground(new Color(0, 204, 102));
        jbListo.setForeground(Color.WHITE);
        
    }//GEN-LAST:event_jbListoMouseEntered

    private void jbListoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbListoMouseExited
        
        jbListo.setBackground(UIManager.getColor("Button.background"));
        jbListo.setForeground(new Color(0, 204, 102));
        
    }//GEN-LAST:event_jbListoMouseExited

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbEditar;
    private javax.swing.JButton jbListo;
    private javax.swing.JButton jbMenu;
    private javax.swing.JComboBox<Ciudad> jcbCiudades;
    private javax.swing.JComboBox<String> jcbProvincias;
    private javax.swing.JTextField jtNombreCiudad;
    // End of variables declaration//GEN-END:variables
}
