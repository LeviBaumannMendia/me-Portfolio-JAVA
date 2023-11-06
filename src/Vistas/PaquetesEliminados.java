
package Vistas;

import AccesoData.PaqueteData;
import Entidades.Paquete;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PaquetesEliminados extends javax.swing.JFrame {

    
    private final DefaultTableModel modelo = new DefaultTableModel(){
    
    @Override
    public boolean isCellEditable(int f, int c){
        return false;
    }
};
    
    
    
    
    public PaquetesEliminados() {
        initComponents();
        this.setLocationRelativeTo(null);
        armarCabecera();
        llenarTabla();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEliminados = new javax.swing.JTable();
        jbVolver = new javax.swing.JButton();
        jbActivar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TablaEliminados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaEliminados);

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbActivar.setText("Activar Paquete");
        jbActivar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActivarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 641, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jbVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbActivar)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbVolver)
                    .addComponent(jbActivar))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    private void llenarTabla() {
        modelo.setRowCount(0);
        TablaEliminados.revalidate();
        PaqueteData paData = new PaqueteData();

     
        ArrayList<Paquete> paquetes = paData.obtenerPaquetesEliminados();
        //System.out.println(cliente);
         for (Paquete p: paquetes){
             modelo.addRow(new Object []{p.getIdPaquete(), p.getNombrePaquete(), p.getAlojamiento().getNombreHotel(), p.getPrecioTotal() });
         }
             
     
    }
    
    
    private void armarCabecera(){
             
      modelo.addColumn("id");
      modelo.addColumn("Nombre");
      modelo.addColumn("Hotel");
      modelo.addColumn("Precio");
      TablaEliminados.setModel(modelo);
    }
    
    
    
    
    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
        PaqueteElegido paele = new PaqueteElegido();
        paele.show();
        dispose();
        
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbActivarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActivarActionPerformed
        
        PaqueteData paquetedata = new PaqueteData();
        try{
        int idPaquete = (int) modelo.getValueAt(TablaEliminados.getSelectedRow(), 0);
        
        
        
        paquetedata.recuperarPaquete(idPaquete);
        llenarTabla();
        }catch (ArrayIndexOutOfBoundsException nu){
            JOptionPane.showMessageDialog(null, "Primero seleccioná un paquete");
        }
    }//GEN-LAST:event_jbActivarActionPerformed

    

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEliminados;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActivar;
    private javax.swing.JButton jbVolver;
    // End of variables declaration//GEN-END:variables
}
