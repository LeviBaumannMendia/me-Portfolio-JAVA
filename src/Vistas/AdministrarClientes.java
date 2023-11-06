/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoData.ClienteData;
import AccesoData.ClientePaqueteData;
import Entidades.Cliente;
import Entidades.Paquete;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pato
 */
public class AdministrarClientes extends javax.swing.JFrame {

    
    private final DefaultTableModel modelo = new DefaultTableModel(){
    
    @Override
    public boolean isCellEditable(int f, int c){
        return false;
    }
};
    
    
    public AdministrarClientes() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboCliente();
        armarCabecera();
    }

    
    
    private void llenarComboCliente() {
    jcbClientes.removeAllItems();
    ClienteData clientedata = new ClienteData();


    

    Cliente seleccionInicial = new Cliente(-1, -1, "Seleccione Cliente", "", -1, null, null, null);
    ArrayList<Cliente> listaClientes = clientedata.obtenerClientes();

    listaClientes.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Cliente> cliente = new DefaultComboBoxModel<>(listaClientes.toArray(new Cliente[0]));
    jcbClientes.setModel(cliente);
   
    }
    
    
    
    
    
    private void llenarTabla() {
        TablaPaquetes.revalidate();
        ClientePaqueteData clipaData = new ClientePaqueteData();
        
        Cliente clienteSeleccionado = (Cliente) jcbClientes.getSelectedItem();
        int idcliente = clienteSeleccionado.getIdCliente();
        
        if (clipaData.existeCliente(idcliente)){
            
            ArrayList<Paquete> paquetes = clipaData.obtenerPaquetePorCliente(idcliente);
        
            for (Paquete p: paquetes){
             modelo.addRow(new Object []{p.getIdPaquete(), p.getNombrePaquete(), p.getAlojamiento().getNombreHotel(), p.getTransporte().getTipoTransporte(), (p.getCuposTotales() - p.getCuposOcupados()), p.getPrecioTotal() });
         }
            
        }else{
            
            modelo.addRow(new Object []{"No", "hay", "paquetes", "comprados", "por ese", "cliente" });
        }
              
    }
    
    
    
    
    private void armarCabecera(){
             
      modelo.addColumn("id");
      modelo.addColumn("Nombre");
      modelo.addColumn("Hotel");
      modelo.addColumn("Vehiculo");
      modelo.addColumn("Cupos Disponibles");
      modelo.addColumn("Precio");
      TablaPaquetes.setModel(modelo);
    }
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jcbClientes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaPaquetes = new javax.swing.JTable();
        jbAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jcbClientes.setBackground(new java.awt.Color(255, 255, 255));
        jcbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClientesActionPerformed(evt);
            }
        });

        TablaPaquetes.setBackground(new java.awt.Color(255, 255, 255));
        TablaPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaPaquetes);

        jbAtras.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbAtras.setForeground(new java.awt.Color(255, 102, 51));
        jbAtras.setText("Atrás");
        jbAtras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(342, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jcbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtrasActionPerformed
        
        Menu me = new Menu();
        me.show();
        dispose();
        
    }//GEN-LAST:event_jbAtrasActionPerformed

    private void jcbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClientesActionPerformed
        modelo.setRowCount(0);
        llenarTabla();
        
    }//GEN-LAST:event_jcbClientesActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaPaquetes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAtras;
    private javax.swing.JComboBox<Cliente> jcbClientes;
    // End of variables declaration//GEN-END:variables
}
