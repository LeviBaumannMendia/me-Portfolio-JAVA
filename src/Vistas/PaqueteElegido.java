/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import AccesoData.*;
import Entidades.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class PaqueteElegido extends javax.swing.JFrame {

    private int subPrecio;
    private int precioH;
    private int precioE;
    private int precio1;
    private int precio2;
    private int precio3;

    public PaqueteElegido() {
        initComponents();
        this.setLocationRelativeTo(null);
        llenarComboPaquete();

    }

    private void llenarComboPaquete() {
        jcbPaquete.removeAllItems();
        PaqueteData paquetedata = new PaqueteData();

        Ciudad ciudadfalsa = new Ciudad(-1, "", "", "");

        Paquete seleccionInicial = new Paquete(-1, "Seleccione Paquete", ciudadfalsa, null, null, null, null, "", -1, -1, -1, "", "", "", -1, -1, -1, true);

        ArrayList<Paquete> listaPaquetes = paquetedata.llenarComboBoxPaquetes();

        listaPaquetes.add(0, seleccionInicial);

        DefaultComboBoxModel<Paquete> paquete = new DefaultComboBoxModel<>(listaPaquetes.toArray(new Paquete[0]));
        jcbPaquete.setModel(paquete);

    }

    private void mostrarPaquete() {
        PaqueteData paquetedata = new PaqueteData();

        try {

            Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();

            Paquete paqueteAMostrar = paquetedata.buscarPaquete(paqueteSeleccionado.getIdPaquete());

            jtCuposTotales.setText(String.valueOf(paqueteAMostrar.getCuposTotales()));

            int cupoTotal = paqueteAMostrar.getCuposTotales();
            int cupoOcupado = paqueteAMostrar.getCuposOcupados();
            int disponibleTotal = cupoTotal - cupoOcupado;                                                           //Saca la cuenta de los cupos disponibles del viaje.
            jtCuposDisponibles.setText(String.valueOf(disponibleTotal));

            jtCiudad.setText("  " + String.valueOf(paqueteAMostrar.getCiudad()));
            jtAlojamiento.setText("  " + String.valueOf(paqueteAMostrar.getAlojamiento()));
            jtTransporte.setText("  " + String.valueOf(paqueteAMostrar.getTransporte()));

            LocalDate fechaIda = paqueteAMostrar.getFechaIda();                                                  // Obtiene la fecha del paquete
            DateTimeFormatter formatoFechaIda = DateTimeFormatter.ofPattern("dd/MM/yyyy");   // Da el nuevo formato "dd/MM/yyyy"
            String fechaFormateadaIda = fechaIda.format(formatoFechaIda);                                  // Convierte la fecha al formato 
            jtFechaIda.setText("  " + fechaFormateadaIda);                                                              // Asigna la fecha formateada al fieldText

            LocalDate fechaVuel = paqueteAMostrar.getFechaVuelta();
            DateTimeFormatter formatoFechaVuelta = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            String fechaFormateadaVuelta = fechaVuel.format(formatoFechaVuelta);
            jtFechaVuelta.setText("  " + fechaFormateadaVuelta);

            jtTemporada.setText("  " + paqueteAMostrar.getTemporada());
            jtPrecioTotal.setText("  " + String.valueOf(paqueteAMostrar.getPrecioTotal()));
            subPrecio = ((int) paqueteAMostrar.getPrecioTotal());

            jtPrecioFinal.setText(String.valueOf(subPrecio));
            
            jchExcursion1.setText(paqueteSeleccionado.getExcursion1());
            jchExcursion2.setText(paqueteSeleccionado.getExcursion2());
            jchExcursion3.setText(paqueteSeleccionado.getExcursion3());
            jlPrecio1.setText("$"+Double.toString(paqueteSeleccionado.getPrecioexcursion1()));
            precio1 = (int) paqueteSeleccionado.getPrecioexcursion1();
            jlPrecio2.setText("$"+Double.toString(paqueteSeleccionado.getPrecioexcursion2()));
            precio2 = (int) paqueteSeleccionado.getPrecioexcursion2();
            jlPrecio3.setText("$"+Double.toString(paqueteSeleccionado.getPrecioexcursion3()));
            precio3 = (int) paqueteSeleccionado.getPrecioexcursion3();
            
        } catch (NullPointerException nu) {

        }

    }

    private void Extra() {

        Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();
        
        try{
        
        int alojamiento = (int) paqueteSeleccionado.getAlojamiento().getPrecio();
        
        if (jcHabitacionExclu.isSelected() && !(jcExcursionAdicional.isSelected())) {
            precioH = alojamiento * 2 + subPrecio;
            jtPrecioFinal.setText(String.valueOf(precioH));
            
        } else if (jcExcursionAdicional.isSelected() && jcHabitacionExclu.isSelected()) {
            precioH = alojamiento * 2 + 2000 + subPrecio;
            jtPrecioFinal.setText(String.valueOf(precioH));
        
        } else if (jcExcursionAdicional.isSelected() && !(jcHabitacionExclu.isSelected())) {
            precioE = subPrecio + 2000;
            jtPrecioFinal.setText(String.valueOf(precioE));
            
        } else {
            jtPrecioFinal.setText(String.valueOf(subPrecio));
        }
        }catch (NullPointerException nu){
            
        }
    }

    private void crearCliente() {

        ClienteData nuevocliente = new ClienteData();
        Cliente cliente = new Cliente();

        try {
            cliente.setDni(Integer.parseInt(jtDNI.getText()));
            cliente.setNombre(jtNombre.getText());
            cliente.setApellido(jtApellido.getText());
            cliente.setTelefono(Long.parseLong(jtTelefono.getText()));
            cliente.setDireccion(jtDireccion.getText());
            cliente.setEmail(jtEmail.getText());
            cliente.setObservaciones(jtObservaciones.getText());

            if (cliente.getNombre().isEmpty() || cliente.getApellido().isEmpty() || cliente.getDireccion().isEmpty() || cliente.getEmail().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");

            } else if (nuevocliente.existeDNI(cliente.getDni())) {
                JOptionPane.showMessageDialog(null, "Ya hay un cliente con ese DNI");

            } else {
                nuevocliente.guardarCliente(cliente);

            }
        } catch (NumberFormatException nu) {

            JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
        }

        // PARA REINICIAR EL AUTO INCREMENTAL EN LA TABLA CLIENTE: ALTER TABLE cliente AUTO_INCREMENT = 0
    }

    private void vincularClientePaquete() {

        PaqueteData nuevavinculacion = new PaqueteData();
        ClientePaquete clientepaquete = new ClientePaquete();

        Cliente cliente = new Cliente();

        Paquete paqueteSelec = (Paquete) jcbPaquete.getSelectedItem();
        //String idclienteString = jtDNI.getText();
        //int dni = Integer.parseInt(idclienteString);

        Double preciofinal = Double.parseDouble(jtPrecioFinal.getText());

        cliente.setIdCliente(Integer.parseInt(jlIdCliente.getText()));
        cliente.setDni(Integer.parseInt(jtDNI.getText()));
        cliente.setNombre(jtNombre.getText());
        cliente.setApellido(jtApellido.getText());
        cliente.setTelefono(Long.parseLong(jtTelefono.getText()));
        cliente.setDireccion(jtDireccion.getText());
        cliente.setEmail(jtEmail.getText());
        cliente.setObservaciones(jtObservaciones.getText());

        clientepaquete.setCliente(cliente);

        clientepaquete.setPaquete(paqueteSelec);
        clientepaquete.setPrecioFinal(preciofinal);

        nuevavinculacion.asignarClienteAPaquete(clientepaquete);

    }

    private void restarUnCupo() {

        Paquete paquete = new Paquete();
        PaqueteData paquetedata = new PaqueteData();

        Paquete paqueteSelec = (Paquete) jcbPaquete.getSelectedItem();

        int cuposocupados = paqueteSelec.getCuposOcupados() + 1;
        int idDelPaquete = paqueteSelec.getIdPaquete();

        paquete.setCuposOcupados(cuposocupados);
        paquete.setIdPaquete(idDelPaquete);

        paquetedata.restarCupos(paquete);

    }

    private void limpiarCamposCliente() {

        jlIdCliente.setText("");
        jtDNI.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jtTelefono.setText("");
        jtDireccion.setText("");
        jtEmail.setText("");
        jtObservaciones.setText("");
        
        

    }

    private void limpiarCamposPaquete() {

        jtCiudad.setText("");
        jtAlojamiento.setText("");
        jtTransporte.setText("");
        jtFechaIda.setText("");
        jtFechaVuelta.setText("");
        jtTemporada.setText("");
        jtCuposTotales.setText("");
        jtCuposDisponibles.setText("");
        jtPrecioTotal.setText("");
        jtPrecioFinal.setText("");
        jcExcursionAdicional.setSelected(false);
        jcHabitacionExclu.setSelected(false);
        jchExcursion1.setText("");
        jchExcursion1.setSelected(false);      
        jchExcursion2.setText("");
        jchExcursion2.setSelected(false);
        jchExcursion3.setText("");
        jchExcursion3.setSelected(false);
        jlPrecio1.setText("");
        jlPrecio2.setText("");
        jlPrecio3.setText("");

    }
    
    
    
    /*private void llenarExcursiones(Paquete paquete) {
        jchExcursion1.setText(paquete.getExcursion1());
        jchExcursion2.setText(paquete.getExcursion2());
        jchExcursion3.setText(paquete.getExcursion3());
        jlPrecio1.setText("$"+Double.toString(paquete.getPrecioexcursion1()));
        precio1 = (int) paquete.getPrecioexcursion1();
        jlPrecio2.setText("$"+Double.toString(paquete.getPrecioexcursion2()));
        precio2 = (int) paquete.getPrecioexcursion2();
        jlPrecio3.setText("$"+Double.toString(paquete.getPrecioexcursion3()));
        precio3 = (int) paquete.getPrecioexcursion3();
    }*/
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jtCiudad = new javax.swing.JTextField();
        jtTransporte = new javax.swing.JTextField();
        jtFechaIda = new javax.swing.JTextField();
        jtFechaVuelta = new javax.swing.JTextField();
        jtTemporada = new javax.swing.JTextField();
        jtAlojamiento = new javax.swing.JTextField();
        jcbPaquete = new javax.swing.JComboBox<>();
        jtCuposTotales = new javax.swing.JLabel();
        jtCuposDisponibles = new javax.swing.JLabel();
        jbQuienes = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtObservaciones = new javax.swing.JTextField();
        jlIdCliente = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jcExcursionAdicional = new javax.swing.JCheckBox();
        jcHabitacionExclu = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtPrecioFinal = new javax.swing.JTextField();
        jbVerMasHabitacion = new javax.swing.JButton();
        jbVerMasEquipaje = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jbVolver = new javax.swing.JButton();
        jbVender = new javax.swing.JButton();
        jbEliminados = new javax.swing.JButton();
        jbDarDeBaja = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jtPrecioTotal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jchExcursion1 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jlPrecio1 = new javax.swing.JLabel();
        jchExcursion2 = new javax.swing.JCheckBox();
        jchExcursion3 = new javax.swing.JCheckBox();
        jlPrecio2 = new javax.swing.JLabel();
        jlPrecio3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtCiudad.setEditable(false);
        jtCiudad.setBorder(null);

        jtTransporte.setEditable(false);
        jtTransporte.setBorder(null);

        jtFechaIda.setEditable(false);
        jtFechaIda.setBorder(null);

        jtFechaVuelta.setEditable(false);
        jtFechaVuelta.setBorder(null);

        jtTemporada.setEditable(false);
        jtTemporada.setBorder(null);

        jtAlojamiento.setEditable(false);
        jtAlojamiento.setBorder(null);

        jcbPaquete.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcbPaqueteItemStateChanged(evt);
            }
        });

        jtCuposTotales.setBackground(new java.awt.Color(255, 255, 255));
        jtCuposTotales.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtCuposTotales.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtCuposDisponibles.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jtCuposDisponibles.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbQuienes.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbQuienes.setText("¿quienes compraron?");
        jbQuienes.setBorder(null);
        jbQuienes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbQuienesActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("C I U D A D");

        jLabel4.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("A L O J A M I E N T O");

        jLabel5.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("T R A N S P O R T E");

        jLabel6.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 102, 51));
        jLabel6.setText("F E C H A   S A L I D A");

        jLabel7.setFont(new java.awt.Font("Levenim MT", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 102, 51));
        jLabel7.setText("F E C H A   R E G R E S O");

        jLabel8.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel8.setText("T E M P O R A D A");

        jLabel2.setText("C U P O S  T O T A L E S ");

        jLabel16.setForeground(new java.awt.Color(0, 153, 153));
        jLabel16.setText("D I S P O N I B L E S");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Gautami", 0, 14)); // NOI18N
        jLabel1.setText("VER PAQUETE");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setText("C L I E N T E  NRO");

        jLabel15.setText("D N I");

        jLabel17.setText("N O M B R E");

        jLabel18.setText("A P E L L I D O");

        jLabel19.setText("T E L É F O N O");

        jLabel20.setText("E M A I L");

        jLabel21.setText("D I R E C C I Ó N");

        jtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtDNIActionPerformed(evt);
            }
        });
        jtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtDNIKeyTyped(evt);
            }
        });

        jtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtNombreKeyTyped(evt);
            }
        });

        jtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtApellidoKeyTyped(evt);
            }
        });

        jtTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtTelefonoKeyTyped(evt);
            }
        });

        jtDireccion.setMaximumSize(new java.awt.Dimension(20, 132));

        jLabel22.setText("O B S:");

        jlIdCliente.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlIdCliente.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlIdCliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel21))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                                .addComponent(jtNombre))
                            .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(18, 18, 18)
                        .addComponent(jlIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addGap(18, 18, 18)
                        .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(26, 26, 26))
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        jcExcursionAdicional.setText("Equipaje Adicional");
        jcExcursionAdicional.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcExcursionAdicionalItemStateChanged(evt);
            }
        });

        jcHabitacionExclu.setText("Habitación Exclusiva");
        jcHabitacionExclu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jcHabitacionExcluItemStateChanged(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel12.setText("PRECIO FINAL");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel13.setText("$");

        jbVerMasHabitacion.setText("ver más");
        jbVerMasHabitacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerMasHabitacionActionPerformed(evt);
            }
        });

        jbVerMasEquipaje.setText("ver más");
        jbVerMasEquipaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVerMasEquipajeActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));

        jbVolver.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbVolver.setText("volver");
        jbVolver.setBorder(null);
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbVender.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbVender.setForeground(new java.awt.Color(255, 102, 0));
        jbVender.setText("vender ");
        jbVender.setBorder(null);
        jbVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVenderActionPerformed(evt);
            }
        });

        jbEliminados.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbEliminados.setText("ver paquetes eliminados");
        jbEliminados.setBorder(null);
        jbEliminados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminadosActionPerformed(evt);
            }
        });

        jbDarDeBaja.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jbDarDeBaja.setText("Dar de baja");
        jbDarDeBaja.setBorder(null);
        jbDarDeBaja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbDarDeBajaActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                .addComponent(jbDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbEliminados, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(188, 188, 188)
                .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbVender, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jbDarDeBaja, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jbEliminados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jcHabitacionExclu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVerMasHabitacion)
                        .addGap(63, 63, 63)
                        .addComponent(jcExcursionAdicional)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbVerMasEquipaje)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcHabitacionExclu)
                    .addComponent(jbVerMasHabitacion, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcExcursionAdicional)
                    .addComponent(jbVerMasEquipaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13)
                    .addComponent(jtPrecioFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel9.setFont(new java.awt.Font("Levenim MT", 0, 12)); // NOI18N
        jLabel9.setText("SUBTOTAL");

        jtPrecioTotal.setEditable(false);
        jtPrecioTotal.setFont(new java.awt.Font("Levenim MT", 0, 14)); // NOI18N
        jtPrecioTotal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 12, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jPanel6.setBackground(new java.awt.Color(255, 102, 51));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 9, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 21, Short.MAX_VALUE)
        );

        jLabel11.setText("Excursiones");

        jchExcursion1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchExcursion1ItemStateChanged(evt);
            }
        });
        jchExcursion1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jchExcursion1PropertyChange(evt);
            }
        });

        jLabel23.setText("Precio");

        jchExcursion2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchExcursion2ItemStateChanged(evt);
            }
        });

        jchExcursion3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jchExcursion3ItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jchExcursion3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jchExcursion1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jchExcursion2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jbQuienes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(39, 39, 39))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(28, 28, 28))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtAlojamiento, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                .addComponent(jtCiudad))
                            .addComponent(jtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtFechaIda, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtFechaVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio1)
                            .addComponent(jLabel23)
                            .addComponent(jlPrecio2)
                            .addComponent(jlPrecio3))
                        .addGap(136, 136, 136)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCuposTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCuposDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jtCuposTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel16)
                        .addComponent(jtCuposDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jcbPaquete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbQuienes, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtAlojamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtTransporte, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jtFechaIda, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtFechaVuelta, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtTemporada, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPrecioTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(jLabel23))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jchExcursion1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jchExcursion2))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jlPrecio1)
                                .addGap(18, 18, 18)
                                .addComponent(jlPrecio2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlPrecio3)
                            .addComponent(jchExcursion3))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 85, Short.MAX_VALUE)))
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed

        if (!"".equals(jtDNI.getText()) || !"".equals(jtNombre.getText()) || !"".equals(jtApellido.getText()) || !"".equals(jtTelefono.getText()) || !"".equals(jtDireccion.getText()) || !"".equals(jtEmail.getText()) || !"".equals(jtObservaciones.getText())) {

            int opcion = JOptionPane.showConfirmDialog(null,
                    "¿Está seguro de que desea volver? Tiene cambios sin guardar",
                    "Confirmación",
                    JOptionPane.OK_CANCEL_OPTION);

            if (opcion == JOptionPane.OK_OPTION) {
                Menu menu = new Menu();
                menu.show();
                dispose();
            }
        } else {

            Menu menu = new Menu();
            menu.show();
            dispose();

        }


    }//GEN-LAST:event_jbVolverActionPerformed

    private void jcbPaqueteItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcbPaqueteItemStateChanged

        mostrarPaquete();
        //llenarExcursiones((Paquete) jcbPaquete.getSelectedItem());

    }//GEN-LAST:event_jcbPaqueteItemStateChanged

    private void jcHabitacionExcluItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcHabitacionExcluItemStateChanged
        Extra();
    }//GEN-LAST:event_jcHabitacionExcluItemStateChanged

    private void jcExcursionAdicionalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jcExcursionAdicionalItemStateChanged
        Extra();
    }//GEN-LAST:event_jcExcursionAdicionalItemStateChanged

    private void jbVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVenderActionPerformed

        ClienteData clienData = new ClienteData();
        ClientePaqueteData clipaData = new ClientePaqueteData();

        Paquete paqueteElegido = (Paquete) jcbPaquete.getSelectedItem();
        try {

            int iddelPaquete = paqueteElegido.getIdPaquete();
            Cliente clientequenecesito = clienData.buscarClientePorDni(Integer.parseInt(jtDNI.getText()));
            int iddelCliente;

            if (clientequenecesito != null) {
                iddelCliente = clientequenecesito.getIdCliente();
            } else {
                iddelCliente = -1;
            }

            System.out.println(iddelCliente);

            if (clipaData.existenAmbos(iddelPaquete, iddelCliente)) {

                String nombrecliente = clientequenecesito.getNombre();
                String apellidocliente = clientequenecesito.getApellido();
                String nombrepaquete = paqueteElegido.getNombrePaquete();

                JOptionPane.showMessageDialog(null, nombrecliente + " " + apellidocliente + " ya tenía comprado el paquete " + nombrepaquete);

            } else {

                int cupostotales = paqueteElegido.getCuposTotales();
                int cuposocupados = paqueteElegido.getCuposOcupados();

                if (cupostotales == cuposocupados) {

                    String nombredelpaquete = paqueteElegido.getNombrePaquete();

                    JOptionPane.showMessageDialog(null, "Ya no quedan cupos disponibles en el paquete " + nombredelpaquete, "Advertencia", JOptionPane.WARNING_MESSAGE);

                } else {

                    ClienteData clientedata = new ClienteData();

                    String idclienteString = jtDNI.getText();
                    int dni = Integer.parseInt(idclienteString);

                    if (clientedata.existeDNI(dni)) {

                        vincularClientePaquete();
                        restarUnCupo();
                        limpiarCamposCliente();
                        limpiarCamposPaquete();
                        llenarComboPaquete();

                    } else {

                        crearCliente();

                        Cliente cliente = clientedata.buscarClientePorDni(dni);
                        jlIdCliente.setText(Integer.toString(cliente.getIdCliente()));

                        vincularClientePaquete();
                        restarUnCupo();
                        limpiarCamposCliente();
                        limpiarCamposPaquete();
                        llenarComboPaquete();

                    }
                }
            }
        } catch (NumberFormatException number) {

            JOptionPane.showMessageDialog(null, "No dejes campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);

        } catch (NullPointerException nu) {

        }
    }//GEN-LAST:event_jbVenderActionPerformed

    // FUNCIONES PARA QUE NO DEJE ESCRIBIR LETRAS O NUMEROS EN LOS CAMPOS

    private void jtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtDNIKeyTyped

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtDNI.getText().trim().length() == 10) {
            evt.consume();
        }

    }//GEN-LAST:event_jtDNIKeyTyped

    private void jtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtNombreKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú') && (c != 32) && (c != '\u00f1') && (c != '\u00d1')) {
            evt.consume();
        }

    }//GEN-LAST:event_jtNombreKeyTyped

    private void jtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtApellidoKeyTyped

        char c = evt.getKeyChar();
        if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z') && (c < 'á' || c > 'ú') && (c < 'Á' || c > 'Ú') && (c != 32) && (c != '\u00f1') && (c != '\u00d1')) {
            evt.consume();
        }

    }//GEN-LAST:event_jtApellidoKeyTyped

    private void jtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefonoKeyTyped

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtDNI.getText().trim().length() == 10) {
            evt.consume();
        }

    }//GEN-LAST:event_jtTelefonoKeyTyped


    private void jtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtDNIActionPerformed
        ClienteData clientedata = new ClienteData();
        int dni = Integer.parseInt(jtDNI.getText());

        if (clientedata.existeDNI(dni) == true) {
            Cliente clienteExistente = clientedata.buscarClientePorDni(dni);

            jlIdCliente.setText(Integer.toString(clienteExistente.getIdCliente()));

            jtNombre.setText(clienteExistente.getNombre());
            jtApellido.setText(clienteExistente.getApellido());
            jtTelefono.setText(Long.toString(clienteExistente.getTelefono()));
            jtDireccion.setText(clienteExistente.getDireccion());
            jtEmail.setText(clienteExistente.getEmail());
            jtObservaciones.setText(clienteExistente.getObservaciones());
        } else {

            JOptionPane.showMessageDialog(null, "El cliente con el DNI " + jtDNI.getText() + " no existe en la base de datos", "Advertencia", JOptionPane.WARNING_MESSAGE);

        }


    }//GEN-LAST:event_jtDNIActionPerformed

    private void jbVerMasHabitacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerMasHabitacionActionPerformed

        String mensaje = "El cliente desea abonar un pago extra por reservar una habitación\n"
                + "asumiendo que las habitaciones pueden ser tanto dobles como triples.\n"
                + "Esta reserva se realiza de manera individual \n"
                + " \n"
                + "Se abonará el doble del precio de la habitación por noche. ";

        JOptionPane.showMessageDialog(null, mensaje, "Habitación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbVerMasHabitacionActionPerformed

    private void jbVerMasEquipajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVerMasEquipajeActionPerformed
        String mensaje = "El cliente puede abonar un extra por exceder la cantidad de equipaje permitido\n"
                + "Equipaje permitido 1 de 15 kilos, mas el equipaje de mano.\n"
                + "El pasajero puede llevar un maximo de 2 equipajes o 1 de 30 kilos, \n"
                + "mas el equipo de mano\n"
                + " \n"
                + "El bono por llevar mas equipajes de lo permitido es de $2000 \n";

        JOptionPane.showMessageDialog(null, mensaje, "Habitación", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jbVerMasEquipajeActionPerformed

    private void jbDarDeBajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDarDeBajaActionPerformed

        PaqueteData paquetedata = new PaqueteData();
        ClientePaqueteData clipadata = new ClientePaqueteData();

        Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();

        int idDelPaquete = paqueteSeleccionado.getIdPaquete();

        String nombrepaquete = paqueteSeleccionado.getNombrePaquete();

        if (idDelPaquete == -1) {

            JOptionPane.showMessageDialog(null, "Seleccioná un paquete antes de apretar este botón", "Advertencia", JOptionPane.WARNING_MESSAGE);

        } else {

            if (clipadata.existePaquete(idDelPaquete)) {

                int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Seguro que lo querés dar de baja? Hay uno o más clientes que compraron este paquete",
                        "Confirmación",
                        JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {

                    paquetedata.eliminarPaquete(paqueteSeleccionado);
                    clipadata.eliminarClientePaquete(idDelPaquete);

                    JOptionPane.showMessageDialog(null, "Se dió de baja el paquete " + nombrepaquete);

                    paqueteSeleccionado.setCuposOcupados(0);

                    paquetedata.volverCuposACero(idDelPaquete);

                    llenarComboPaquete();
                    limpiarCamposPaquete();

                }

            } else {

                paquetedata.eliminarPaquete(paqueteSeleccionado);
                clipadata.eliminarClientePaquete(idDelPaquete);

                JOptionPane.showMessageDialog(null, "Se dió de baja el paquete " + nombrepaquete);

                paqueteSeleccionado.setCuposOcupados(0);

                paquetedata.volverCuposACero(idDelPaquete);

                llenarComboPaquete();
                limpiarCamposPaquete();
            }
        }
    }//GEN-LAST:event_jbDarDeBajaActionPerformed

    private void jbEliminadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminadosActionPerformed

        PaquetesEliminados paeli = new PaquetesEliminados();
        paeli.show();
        dispose();

    }//GEN-LAST:event_jbEliminadosActionPerformed

    private void jbQuienesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbQuienesActionPerformed

        Paquete paqueteElegido = (Paquete) jcbPaquete.getSelectedItem();
        ClientePaqueteData clientepaquetedata = new ClientePaqueteData();
        String nombrepaquete = paqueteElegido.getNombrePaquete();

        ArrayList<ClientePaquete> listaClientesPaquete = clientepaquetedata.buscarClientesPorPaquete(paqueteElegido.getIdPaquete());

        if (!listaClientesPaquete.isEmpty()) {

            ArrayList<String> nombresClientes = new ArrayList<>();

            for (ClientePaquete clientePaquete : listaClientesPaquete) {
                Cliente cliente = clientePaquete.getCliente();
                if (cliente != null) {
                    String nombreCliente = cliente.getNombre();
                    String apellido = cliente.getApellido();
                    nombresClientes.add(nombreCliente + " " + apellido);
                }
            }
            if (nombresClientes.size() > 1) {
                JOptionPane.showMessageDialog(null, "Los clientes que compraron el paquete " + nombrepaquete + " son: \n" + nombresClientes);

            } else if (nombresClientes.size() == 1) {
                JOptionPane.showMessageDialog(null, "El cliente que compró el paquete " + nombrepaquete + " es: \n" + nombresClientes);
            }

        } else {

            JOptionPane.showMessageDialog(null, "Nadie compró el paquete " +nombrepaquete+" todavía");

        }

    }//GEN-LAST:event_jbQuienesActionPerformed

    private void jchExcursion1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jchExcursion1PropertyChange
//        if (jchExcursion1.isSelected()){
//                subPrecio = subPrecio +precio1;
//                System.out.println(subPrecio);
//                  jtPrecioFinal.setText(String.valueOf(subPrecio));
//                
//
//            }
    }//GEN-LAST:event_jchExcursion1PropertyChange

    private void jchExcursion1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchExcursion1ItemStateChanged
        Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();
        precio1 = (int) paqueteSeleccionado.getPrecioexcursion1();
        if (jchExcursion1.isSelected()) {
            subPrecio = subPrecio + precio1;
            jtPrecioFinal.setText(String.valueOf(subPrecio));
        }
        else {
                subPrecio = subPrecio - precio1;
                jtPrecioFinal.setText(String.valueOf(subPrecio));
            }

        

    }//GEN-LAST:event_jchExcursion1ItemStateChanged

    private void jchExcursion2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchExcursion2ItemStateChanged
        Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();
        precio2 = (int) paqueteSeleccionado.getPrecioexcursion2();
        if (jchExcursion2.isSelected()) {
            subPrecio = subPrecio + precio2;
            jtPrecioFinal.setText(String.valueOf(subPrecio));
        }
        else {
                subPrecio = subPrecio - precio2;
                jtPrecioFinal.setText(String.valueOf(subPrecio));
            }

    }//GEN-LAST:event_jchExcursion2ItemStateChanged

    private void jchExcursion3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jchExcursion3ItemStateChanged
         Paquete paqueteSeleccionado = (Paquete) jcbPaquete.getSelectedItem();
        precio3 = (int) paqueteSeleccionado.getPrecioexcursion3();
        if (jchExcursion3.isSelected()) {
           subPrecio = subPrecio + precio3;
            jtPrecioFinal.setText(String.valueOf(subPrecio));
        }
        else {
                subPrecio = subPrecio - precio3;
                jtPrecioFinal.setText(String.valueOf(subPrecio));
            }

    }//GEN-LAST:event_jchExcursion3ItemStateChanged

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JButton jbDarDeBaja;
    private javax.swing.JButton jbEliminados;
    private javax.swing.JButton jbQuienes;
    private javax.swing.JButton jbVender;
    private javax.swing.JButton jbVerMasEquipaje;
    private javax.swing.JButton jbVerMasHabitacion;
    private javax.swing.JButton jbVolver;
    private javax.swing.JCheckBox jcExcursionAdicional;
    private javax.swing.JCheckBox jcHabitacionExclu;
    private javax.swing.JComboBox<Paquete> jcbPaquete;
    private javax.swing.JCheckBox jchExcursion1;
    private javax.swing.JCheckBox jchExcursion2;
    private javax.swing.JCheckBox jchExcursion3;
    private javax.swing.JLabel jlIdCliente;
    private javax.swing.JLabel jlPrecio1;
    private javax.swing.JLabel jlPrecio2;
    private javax.swing.JLabel jlPrecio3;
    private javax.swing.JTextField jtAlojamiento;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtCiudad;
    private javax.swing.JLabel jtCuposDisponibles;
    private javax.swing.JLabel jtCuposTotales;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtFechaIda;
    private javax.swing.JTextField jtFechaVuelta;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtObservaciones;
    private javax.swing.JTextField jtPrecioFinal;
    private javax.swing.JTextField jtPrecioTotal;
    private javax.swing.JTextField jtTelefono;
    private javax.swing.JTextField jtTemporada;
    private javax.swing.JTextField jtTransporte;
    // End of variables declaration//GEN-END:variables
}
