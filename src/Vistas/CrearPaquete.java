
package Vistas;

import AccesoData.*;
import Entidades.Alojamiento;
import Entidades.Ciudad;
import Entidades.Paquete;
import Entidades.Transporte;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class CrearPaquete extends javax.swing.JFrame {

  
    public CrearPaquete() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboCiudad();


    }
    
    
    private String temporadaElegida;
    private Double precioTemporada;
    private Double precioAlojamiento;
    private Double precioTransporte;
    private Double precioPorDias;
    
    
    
    private void llenarComboCiudad() {
    jcbCiudad.removeAllItems();
    CiudadData ciudaddata = new CiudadData();

    
    

    
    Ciudad seleccionInicial = new Ciudad(-1, "Seleccione ciudad", "", "");
    
    ArrayList<Ciudad> listaCiudades = ciudaddata.obtenerCiudades();
    
    listaCiudades.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Ciudad> ciudades = new DefaultComboBoxModel<>(listaCiudades.toArray(new Ciudad[0]));
    
    
    
    jcbCiudad.setModel(ciudades);
}
    
    
    
    
    private void llenarComboAlojamiento() {
    jcbAlojamiento.removeAllItems();
    AlojamientoData alojamientonuevo = new AlojamientoData();

    Ciudad ciudadSeleccionada = (Ciudad) jcbCiudad.getSelectedItem();
 
    int idDeLaCiudad = ciudadSeleccionada.getIdCiudad();
    
    Alojamiento seleccionInicial = new Alojamiento(-1, ciudadSeleccionada, "Seleccione Alojamiento", null, -1, -1, false);
    
    ArrayList<Alojamiento> listaAlojamientos = alojamientonuevo.llenarComboAlojamientos(idDeLaCiudad);

    listaAlojamientos.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Alojamiento> alojamiento = new DefaultComboBoxModel<>(listaAlojamientos.toArray(new Alojamiento[0]));
    jcbAlojamiento.setModel(alojamiento);
}
    
    
    
    
    
    
    
    
    private void llenarComboTransporte() {
    jcbTransporte.removeAllItems();
    TransporteData transportedata = new TransporteData();

    Transporte seleccionInicial = new Transporte(-1, "Seleccione Transporte", "","", -1);
    
    ArrayList<Transporte> listaTransportes = transportedata.llenarComboTransporte();

    listaTransportes.add(0, seleccionInicial);
    
    DefaultComboBoxModel<Transporte> transporte = new DefaultComboBoxModel<>(listaTransportes.toArray(new Transporte[0]));
    jcbTransporte.setModel(transporte);
}
    
    
    
    
    private void determinarTemporada() {
    LocalDate fechaIda = jdcIda.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    if (fechaIda != null) {
        int mes = fechaIda.getMonthValue();


        if (mes == 1 || mes == 7) {
            temporadaElegida = "Alta";
            jtTemporada.setText(temporadaElegida);
            precioTemporada = 3.0;
        } else if (mes == 2 || mes == 6) {
            temporadaElegida = "Media";
            jtTemporada.setText(temporadaElegida);
             precioTemporada = 2.0;
        } else {
            temporadaElegida = "Baja";
            jtTemporada.setText(temporadaElegida);
             precioTemporada = 1.0;
        }
        
    }
}
    
    
    private void cambiarPrecio(){
        
        try{
        
        if(!(jtPrecioAlojamiento.getText() == null || jtPrecioTransporte.getText() == null || jtTemporada.getText() == null) ){
        
        Double precioPaquete = ((-precioAlojamiento * precioPorDias )+ precioTransporte) * precioTemporada;
        
        jtPrecioTotal.setText(precioPaquete.toString());
        
        }else{
            
            JOptionPane.showMessageDialog(null,"No puede haber campos vacíos");
            
        }
        }catch(NullPointerException nu){
            JOptionPane.showMessageDialog(null,"No se puede generar el total si no hay campos completos");
        }
    }
    
    private void precioAloj(){
        try{
      Alojamiento alojamientoSeleccionado = (Alojamiento) jcbAlojamiento.getSelectedItem();
        
       precioAlojamiento = (Double) alojamientoSeleccionado.getPrecio();
        
     jtPrecioAlojamiento.setText(precioAlojamiento.toString());
        }
        catch(NullPointerException nul){
            
        }
}
    
    private void precioTranspo(){
        
        try{
        
       Transporte transporteSeleccionado = (Transporte) jcbTransporte.getSelectedItem();
        
      precioTransporte = (Double) transporteSeleccionado.getPrecioPasaje();
        
     jtPrecioTransporte.setText(precioTransporte.toString());
     
        }catch(NullPointerException nu){
            
        }
}
    
      private void diasDeViaje () {
      try {
           if (!(jdcIda.getDate() == null && jdcVuelta.getDate() == null )){
              
           Date  FechaIda =  jdcIda.getDate();
           Date  FechaVuelta =  jdcVuelta.getDate();
           
            long diferenciaMilisegundos = FechaIda.getTime() - FechaVuelta.getTime();
    
            // Convierte la diferencia a días
           long diasDiferencia = diferenciaMilisegundos / (1000 * 60 * 60 * 24);
           
           
           precioPorDias = (double) diasDiferencia;
           
            if (precioPorDias <= -1) {
                 System.out.println("La cantidad de dias son " +precioPorDias * -1);
                 if(precioPorDias <= -40){
                       JOptionPane.showMessageDialog(null, "¡Son muchos dias!  \n   \n ¿Estas Seguro?");
                       
                                                                           
                 }
            } else if (precioPorDias >=1 || precioPorDias == 0){
                JOptionPane.showMessageDialog(null, "¡¡Revisa bien las fechas!!, no hay cohesión.");
                jdcVuelta.setDate(null);
            }
           
            
           
        } 
      } catch (NullPointerException nu){
          
      }
       
    }
    

    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBox3 = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jcbCiudad = new javax.swing.JComboBox<>();
        jcbAlojamiento = new javax.swing.JComboBox<>();
        jcbTransporte = new javax.swing.JComboBox<>();
        jdcVuelta = new com.toedter.calendar.JDateChooser();
        jtCupos = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jdcIda = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jtTemporada = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jtexcursion1 = new javax.swing.JTextField();
        jtexcursion3 = new javax.swing.JTextField();
        jtexcursion2 = new javax.swing.JTextField();
        jtprecioex2 = new javax.swing.JTextField();
        jtprecioex1 = new javax.swing.JTextField();
        jtprecioex3 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jbVolver = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jbTotal = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jtPrecioAlojamiento = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtPrecioTransporte = new javax.swing.JTextField();
        jtPrecioTotal = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jbCrearPaquete = new javax.swing.JButton();

        jCheckBox3.setText("jCheckBox3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jcbCiudad.setName(""); // NOI18N
        jcbCiudad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbCiudadItemStateChanged(evt);
            }
        });

        jcbAlojamiento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbAlojamientoItemStateChanged(evt);
            }
        });

        jcbTransporte.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbTransporteItemStateChanged(evt);
            }
        });

        jdcVuelta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcVueltaPropertyChange(evt);
            }
        });

        jtCupos.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel3.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("C I U D A D");

        jLabel4.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("A L O J A M I E N T O");

        jLabel5.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("T R A N S P O R T E");

        jLabel14.setForeground(new java.awt.Color(0, 204, 153));
        jLabel14.setText("CUPOS:");

        jdcIda.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jdcIdaPropertyChange(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("F E C H A   S A L I D A");

        jLabel7.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("F E C H A   R E G R E S O");

        jPanel5.setBackground(new java.awt.Color(221, 220, 220));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("CARGAR UN PAQUETE NUEVO");

        jtNombre.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jtNombre.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 23, Short.MAX_VALUE)
        );

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("NOMBRE");

        jPanel8.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel11)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(3, 3, 3))))
        );

        jtTemporada.setEditable(false);
        jtTemporada.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        jtTemporada.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setText("TEMPORADA");

        jLabel9.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("E X C U R S I O N E S");

        jtexcursion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtexcursion1ActionPerformed(evt);
            }
        });

        jtprecioex2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtprecioex2KeyTyped(evt);
            }
        });

        jtprecioex1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtprecioex1KeyTyped(evt);
            }
        });

        jtprecioex3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtprecioex3KeyTyped(evt);
            }
        });

        jLabel1.setText("Precio");

        jLabel16.setText("Excursion");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(207, 207, 207)
                        .addComponent(jLabel16))
                    .addComponent(jtexcursion2, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE)
                    .addComponent(jtexcursion1)
                    .addComponent(jtexcursion3))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtprecioex2, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(jtprecioex1)
                            .addComponent(jtprecioex3))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(62, 62, 62))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel16))
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtexcursion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtprecioex1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtexcursion2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtprecioex2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtexcursion3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtprecioex3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jbVolver.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbVolver.setText("volver");
        jbVolver.setBorder(null);
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcIda, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(41, 41, 41)
                                .addComponent(jdcVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(28, 28, 28)
                                                .addComponent(jcbAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(46, 46, 46)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jcbTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel9)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCupos, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(396, 396, 396)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jtTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jcbAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)
                                    .addComponent(jtCupos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jcbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(5, 5, 5)
                                .addComponent(jcbTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdcVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jdcIda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(53, 53, 53)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(496, 496, 496)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));

        jbTotal.setText("Generar Total");
        jbTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbTotalActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel13.setText("$");

        jtPrecioAlojamiento.setEditable(false);
        jtPrecioAlojamiento.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        jtPrecioAlojamiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel12.setText("$");

        jtPrecioTransporte.setEditable(false);
        jtPrecioTransporte.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        jtPrecioTransporte.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jtPrecioTotal.setEditable(false);
        jtPrecioTotal.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        jtPrecioTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel10.setText("$");

        jbCrearPaquete.setBackground(new java.awt.Color(255, 255, 255));
        jbCrearPaquete.setForeground(new java.awt.Color(0, 153, 153));
        jbCrearPaquete.setText("Crear Paquete");
        jbCrearPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPrecioAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPrecioTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(265, 265, 265)
                .addComponent(jbTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbCrearPaquete)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(jtPrecioTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jtPrecioAlojamiento)
                    .addComponent(jLabel13)
                    .addComponent(jbCrearPaquete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        
           if (!"".equals(jtNombre.getText()) || !"".equals(jtPrecioTotal.getText()) || !"".equals(jtTemporada.getText())){
        
                int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea volver? Tiene cambios sin guardar",
                        "Confirmación",
                        JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {
                    Menu menu = new Menu();
                    menu.show();
                    dispose();
                }
         }else{
            
         Menu menu = new Menu();
         menu.show();
         dispose();
            
                }
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbCrearPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearPaqueteActionPerformed
         
        PaqueteData nuevopaquete = new PaqueteData();
        Paquete paquete = new Paquete();
        
        
        
        try{
            paquete.setNombrePaquete(jtNombre.getText());
            paquete.setCiudad( (Ciudad) jcbCiudad.getSelectedItem());
            paquete.setAlojamiento((Alojamiento) jcbAlojamiento.getSelectedItem());
            paquete.setTransporte((Transporte) jcbTransporte.getSelectedItem());
            paquete.setFechaIda(jdcIda.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            paquete.setFechaVuelta(jdcVuelta.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            paquete.setTemporada(jtTemporada.getText());   //Esta variable temporadaElegida está creada al inicio de la vista, y se usa en el método determinarTemporada. Esto devuelve "Alta", "Media" o "Baja" según el mes
            paquete.setCuposTotales(((int) jtCupos.getValue()));
            paquete.setPrecioTotal(Double.parseDouble(jtPrecioTotal.getText()));
            paquete.setExcursion1(jtexcursion1.getText());
            paquete.setExcursion2(jtexcursion2.getText());
            paquete.setExcursion3(jtexcursion3.getText());
            paquete.setPrecioexcursion1(Double.parseDouble(jtprecioex1.getText()));
            paquete.setPrecioexcursion2(Double.parseDouble(jtprecioex2.getText()));
            paquete.setPrecioexcursion3(Double.parseDouble(jtprecioex3.getText()));
            paquete.setEstado(true);
            
            
            //JOptionPane.showMessageDialog(null,"Paquete creado");
            
            
            
              
            
             if(paquete.getNombrePaquete().isEmpty() || paquete.getFechaIda() == null || paquete.getFechaVuelta() == null || paquete.getTemporada().isEmpty()){
                   
            JOptionPane.showMessageDialog(null,"No puede haber campos vacíos");
            
        }else{
             nuevopaquete.crearPaquete(paquete);
         
             } 
            
             
        }catch(NullPointerException nu){
             JOptionPane.showMessageDialog(null,"No puede haber campos vacíos");
             
        }   catch(NumberFormatException num){
             JOptionPane.showMessageDialog(null,"No puede haber campos vacíos");
        }
    }//GEN-LAST:event_jbCrearPaqueteActionPerformed

    private void jcbAlojamientoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbAlojamientoItemStateChanged
        precioAloj(); 
        llenarComboTransporte();
    }//GEN-LAST:event_jcbAlojamientoItemStateChanged

    private void jcbTransporteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbTransporteItemStateChanged
        precioTranspo();        
    }//GEN-LAST:event_jcbTransporteItemStateChanged

    private void jcbCiudadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbCiudadItemStateChanged
        llenarComboAlojamiento();  
    }//GEN-LAST:event_jcbCiudadItemStateChanged

    private void jbTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbTotalActionPerformed

        
       Alojamiento alojSelec = (Alojamiento) jcbAlojamiento.getSelectedItem();
       Transporte transSelec = (Transporte) jcbTransporte.getSelectedItem();
       
       int alojQueNecesito = alojSelec.getIdAlojamiento();
       int traQueNecesito = transSelec.getIdTransporte();
       
        if (alojQueNecesito < 1 || traQueNecesito < 1) {
            
            JOptionPane.showMessageDialog(null,"Deberías ingresar un alojamiento y/o un transporte válido");
        }else{
        
        cambiarPrecio();
        }
    }//GEN-LAST:event_jbTotalActionPerformed

    private void jdcIdaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcIdaPropertyChange
        
        if (evt.getNewValue() instanceof Date) {
                    // Acción a realizar cuando se selecciona una fecha
                    Date fechaSeleccionada = (Date) evt.getNewValue();
                    
                    if (fechaSeleccionada == null){
                        
                        //System.out.println("No anda burro");
                    }else{
                        
                        determinarTemporada();
                        
                    }
        }
                      
        
    }//GEN-LAST:event_jdcIdaPropertyChange

    private void jdcVueltaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jdcVueltaPropertyChange
        diasDeViaje ();
    }//GEN-LAST:event_jdcVueltaPropertyChange

    private void jtexcursion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtexcursion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtexcursion1ActionPerformed

    private void jtprecioex1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprecioex1KeyTyped
       int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtprecioex1.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtprecioex1KeyTyped

    private void jtprecioex2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprecioex2KeyTyped
        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtprecioex2.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtprecioex2KeyTyped

    private void jtprecioex3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtprecioex3KeyTyped
         int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtprecioex3.getText().trim().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_jtprecioex3KeyTyped

 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbCrearPaquete;
    private javax.swing.JButton jbTotal;
    private javax.swing.JButton jbVolver;
    private javax.swing.JComboBox<Alojamiento> jcbAlojamiento;
    private javax.swing.JComboBox<Ciudad> jcbCiudad;
    private javax.swing.JComboBox<Transporte> jcbTransporte;
    private com.toedter.calendar.JDateChooser jdcIda;
    private com.toedter.calendar.JDateChooser jdcVuelta;
    private javax.swing.JSpinner jtCupos;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPrecioAlojamiento;
    private javax.swing.JTextField jtPrecioTotal;
    private javax.swing.JTextField jtPrecioTransporte;
    private javax.swing.JTextField jtTemporada;
    private javax.swing.JTextField jtexcursion1;
    private javax.swing.JTextField jtexcursion2;
    private javax.swing.JTextField jtexcursion3;
    private javax.swing.JTextField jtprecioex1;
    private javax.swing.JTextField jtprecioex2;
    private javax.swing.JTextField jtprecioex3;
    // End of variables declaration//GEN-END:variables
}
