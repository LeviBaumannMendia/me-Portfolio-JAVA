
package Vistas;

import AccesoData.ClienteData;
import AccesoData.ClientePaqueteData;
import AccesoData.PaqueteData;
import Entidades.Ciudad;
import Entidades.Cliente;
import Entidades.ClientePaquete;
import Entidades.Paquete;

import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;



public class AdministrarPaquetes extends javax.swing.JFrame {
    
    
    private String nombrepdf;
    private String nombreTablapdf;
   
    
     private final DefaultTableModel modelo = new DefaultTableModel(){
    
    @Override
    public boolean isCellEditable(int f, int c){
        return false;
    }
};


    public AdministrarPaquetes() {
        
        
        
        initComponents();
        
        Logger pdfBoxLogger = Logger.getLogger("org.apache.pdfbox");

        // Establecer el nivel de registro a un nivel superior, como WARNING, para evitar las advertencias
        pdfBoxLogger.setLevel(Level.WARNING);

        // También puedes configurar otros loggers de bibliotecas relacionadas aquí

        // Cargar la configuración del sistema de registro
        LogManager.getLogManager().reset();
        
        
        
        this.setLocationRelativeTo(null);
       armarCabecera();
       llenarComboPaquete();
    }
    
  private void llenarComboPaquete() {
    jcbBuscarPaquetes.removeAllItems();
    PaqueteData paquetedata = new PaqueteData();


    Ciudad ciudadfalsa = new Ciudad(-1, "", "", "");

    Paquete seleccionInicial = new Paquete(-1, "Seleccione Paquete", ciudadfalsa , null, null, null, null, "",-1, -1, -1, "", "", "", -1,-1,-1,true);
    ArrayList<Paquete> listaPaquetes = paquetedata.llenarComboBoxPaquetes();

    listaPaquetes.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Paquete> paquete = new DefaultComboBoxModel<>(listaPaquetes.toArray(new Paquete[0]));
    jcbBuscarPaquetes.setModel(paquete);
   
    }
  
  private void llenarTabla() {

     ClientePaqueteData clieData = new ClientePaqueteData();
     Paquete paqueteSelec = (Paquete) jcbBuscarPaquetes.getSelectedItem();
     
     
        int cuposTotales = paqueteSelec.getCuposTotales();
         int cuposOcupados = paqueteSelec.getCuposOcupados();
         int cuposDisponibles = (cuposTotales - cuposOcupados);
     
     if (clieData.existePaquete(paqueteSelec.getIdPaquete())){
         
         
         
         
         jlCupos.setText("Cupos disponibles: "+cuposDisponibles+"");
         
         ArrayList<Cliente> clientes = clieData.obtenerClientePorPaquete(paqueteSelec.getIdPaquete());
        //System.out.println(cliente);
         for (Cliente c: clientes){
             modelo.addRow(new Object []{c.getDni(), c.getNombre(), c.getApellido(), c.getTelefono(), c.getObservaciones() });
         }
         
     }else{
         
         jlCupos.setText("Cupos disponibles: "+cuposDisponibles+"");
         modelo.addRow(new Object []{"No", "hay", "clientes", "para ese", "paquete" });
         
     }
     
      
      
     
    }
  
  private void generarPDF() {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDRectangle.A4);
        document.addPage(page);
   
       
        Paquete paqueteSelec = (Paquete) jcbBuscarPaquetes.getSelectedItem();
        ClientePaqueteData clientepaquetedata = new ClientePaqueteData();
        ClientePaquete clienteSelec = clientepaquetedata.buscarClientePaquete(paqueteSelec.getIdPaquete());
       
        String nombrepaquete = paqueteSelec.getNombrePaquete();
        Double precioPaquete = paqueteSelec.getPrecioTotal();
        LocalDate fechaSalida = paqueteSelec.getFechaIda();
        LocalDate fechaRegreso = paqueteSelec.getFechaVuelta();
      
         int dni = clienteSelec.getCliente().getDni();
         long telefono = clienteSelec.getCliente().getTelefono();
         String email = clienteSelec.getCliente().getEmail();
          
        String nombrehotel = paqueteSelec.getAlojamiento().getNombreHotel();
       
       String transporteTipo = paqueteSelec.getTransporte().getTipoTransporte();
       String transporteEmpresa = paqueteSelec.getTransporte().getEmpresa();
        
  

        String nombrecliente = (String) modelo.getValueAt(jtTablaRegistro.getSelectedRow(), 1);
        String apellidocliente = (String) modelo.getValueAt(jtTablaRegistro.getSelectedRow(), 2);
       
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaEmision = dateFormat.format(new Date());
        

        nombrepdf = nombrecliente+" "+apellidocliente+" - "+nombrepaquete+".pdf";
        try {
            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            PDType0Font customFont = PDType0Font.load(document, new File("Roboto-Black.ttf"));   // Cargar una fuente personalizada desde un archivo TTF
            contentStream.setFont(customFont, 12);
            contentStream.beginText();
            contentStream.newLineAtOffset(50, 700);
            contentStream.showText("Fecha de Emisión: " + fechaEmision);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Pasajero: "+nombrecliente+" "+apellidocliente  );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("DNI: " + dni);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Teléfono: " + telefono );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Email: " + email);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Compro el paquete: " +nombrepaquete );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Al valor de: " + precioPaquete );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("En el alojamiento: " + nombrehotel );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Fecha de Salida: " + fechaSalida );
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("Fecha de Regreso: " + fechaRegreso);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("El transporte será: " + transporteTipo);
            contentStream.newLineAtOffset(0, -20);
            contentStream.showText("De la empresa: " + transporteEmpresa );
            contentStream.endText();
            contentStream.close();
            

            
                document.save("Facturas\\"+nombrepdf); // Nombre del archivo PDF
                document.close();
                JOptionPane.showMessageDialog(null, "El PDF se ha generado exitosamente.");
        }
           catch (IOException e) {

                JOptionPane.showMessageDialog(this, "Error al guardar el PDF.");
            } 
    }
  
public void TablaPDF(JTable jTable) {
    
    
    Paquete paqueteSelec = (Paquete) jcbBuscarPaquetes.getSelectedItem();
    int idPaquete = paqueteSelec.getIdPaquete();
    
    
    
    if (idPaquete == -1){
          JOptionPane.showMessageDialog(null, "Seleccione un paquete primero");
      }else{
    
    PDDocument document = new PDDocument();
    PDPage page = new PDPage(PDRectangle.A4);
    document.addPage(page);
    
    // se coloca el nombre del pdf tabla 
    
     String nombrepaquete = paqueteSelec.getNombrePaquete();
      nombreTablapdf = nombrepaquete+ " - Tabla" + ".pdf";

      
      
      
      
    try {
        PDPageContentStream contentStream = new PDPageContentStream(document, page);
        float margin = 50;
        float yStart = page.getMediaBox().getHeight() - margin;
        float tableWidth = page.getMediaBox().getWidth() - 2 * margin;
        float yPosition = yStart;
        float bottomMargin = 70;
        float tableHeight = jTable.getRowCount() * 20 + bottomMargin;
        
         PDType0Font customFont = PDType0Font.load(document, new File("Roboto-Black.ttf"));
        contentStream.setFont(customFont, 12);
        
        float nextTextX = margin;
        float nextTextY = yStart - 20;

        for (int i = 0; i < jTable.getColumnCount(); i++) {
            contentStream.beginText();
            contentStream.newLineAtOffset(nextTextX, nextTextY);
            contentStream.showText(jTable.getColumnName(i));
            contentStream.endText();
            nextTextX += tableWidth / jTable.getColumnCount();
        }
        
        nextTextY -= 20;

        for (int row = 0; row < jTable.getRowCount(); row++) {
            nextTextX = margin;
            for (int col = 0; col < jTable.getColumnCount(); col++) {
                contentStream.beginText();
                contentStream.newLineAtOffset(nextTextX, nextTextY);
                contentStream.showText(jTable.getValueAt(row, col).toString());
                contentStream.endText();
                nextTextX += tableWidth / jTable.getColumnCount();
            }
            nextTextY -= 20;
        }
        
    

        contentStream.close();
        document.save("PaquetesListados\\"+nombreTablapdf);
        document.close();

        System.out.println("PDF generado con éxito en " );
    } catch (IOException e) {

    }
      }
}
       
      private static void abrirPDF(String filePath) {
        try {
            File pdfFile = new File(filePath);

            if (pdfFile.exists()) {
                Desktop.getDesktop().open(pdfFile);
            } else {
                System.out.println("El archivo PDF no existe.");
            }
        } catch (IOException e) {
            System.out.println("Eror al abrir el archivo PDF");
        } 
    }

    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtTablaRegistro = new javax.swing.JTable();
        jbMenuPrincipal = new javax.swing.JButton();
        jbImprimir = new javax.swing.JButton();
        jbTablaImprimir = new javax.swing.JButton();
        jcbBuscarPaquetes = new javax.swing.JComboBox<>();
        jlCupos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtTablaRegistro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jtTablaRegistro);

        jbMenuPrincipal.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbMenuPrincipal.setForeground(new java.awt.Color(255, 102, 51));
        jbMenuPrincipal.setText("Menu Principal");
        jbMenuPrincipal.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMenuPrincipalActionPerformed(evt);
            }
        });

        jbImprimir.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbImprimir.setText("IMPRIMIR");
        jbImprimir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbImprimirActionPerformed(evt);
            }
        });

        jbTablaImprimir.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbTablaImprimir.setText("Tabla");
        jbTablaImprimir.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbTablaImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTablaImprimirActionPerformed(evt);
            }
        });

        jcbBuscarPaquetes.setBackground(new java.awt.Color(255, 255, 255));
        jcbBuscarPaquetes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbBuscarPaquetesActionPerformed(evt);
            }
        });

        jlCupos.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jlCupos.setForeground(new java.awt.Color(0, 204, 102));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(jbTablaImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(291, 291, 291))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jcbBuscarPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jlCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jbMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbBuscarPaquetes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbTablaImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jbMenuPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMenuPrincipalActionPerformed
        
        Menu menu = new Menu();
        menu.show();
        dispose();
        
    }//GEN-LAST:event_jbMenuPrincipalActionPerformed

    private void jcbBuscarPaquetesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbBuscarPaquetesActionPerformed
        modelo.setRowCount(0);
        
        
        
        llenarTabla();
    }//GEN-LAST:event_jcbBuscarPaquetesActionPerformed

    private void jbImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbImprimirActionPerformed
        
        try{
         generarPDF();
         abrirPDF("Facturas\\"+nombrepdf);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Debes seleccionar a una persona en la tabla");
        } catch(NullPointerException ne){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un paquete con clientes");
        }
         
         
    }//GEN-LAST:event_jbImprimirActionPerformed

    private void jbTablaImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTablaImprimirActionPerformed
      
        ClientePaqueteData clipaData = new ClientePaqueteData();
        Paquete paqueteSelec = (Paquete) jcbBuscarPaquetes.getSelectedItem();
        int idPaquete = paqueteSelec.getIdPaquete();
        
        if (!clipaData.existePaquete(idPaquete)){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un paquete con clientes");
        }else{
        
        try{
        TablaPDF(jtTablaRegistro);
       abrirPDF("PaquetesListados\\"+nombreTablapdf);
        }catch(ArrayIndexOutOfBoundsException ex){
            JOptionPane.showMessageDialog(null, "Debes seleccionar a una persona en la tabla");
        } catch(NullPointerException ne){
            JOptionPane.showMessageDialog(null, "Debes seleccionar un paquete con clientes");
        }
        }
    }//GEN-LAST:event_jbTablaImprimirActionPerformed

   
    private void armarCabecera(){
             
      modelo.addColumn("DNI");
      modelo.addColumn("Nombre");
      modelo.addColumn("Apellido");
      modelo.addColumn("Telefono");
      modelo.addColumn("Observaciones");
      jtTablaRegistro.setModel(modelo);
    }
   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbImprimir;
    private javax.swing.JButton jbMenuPrincipal;
    private javax.swing.JButton jbTablaImprimir;
    private javax.swing.JComboBox<Paquete> jcbBuscarPaquetes;
    private javax.swing.JLabel jlCupos;
    private javax.swing.JTable jtTablaRegistro;
    // End of variables declaration//GEN-END:variables
}

