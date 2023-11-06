package Vistas;

import AccesoData.ClienteData;
import AccesoData.ClientePaqueteData;
import AccesoData.PaqueteData;
import Entidades.Cliente;
import Entidades.ClientePaquete;
import Entidades.Paquete;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Clientes extends javax.swing.JFrame {

    private Cliente clienteBuscado = new Cliente();

    public Clientes() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtDNI = new javax.swing.JTextField();
        jtNombre = new javax.swing.JTextField();
        jtApellido = new javax.swing.JTextField();
        jtDireccion = new javax.swing.JTextField();
        jtTelefono = new javax.swing.JTextField();
        jtEmail = new javax.swing.JTextField();
        jtObservaciones = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jbLimpiar = new javax.swing.JButton();
        jButtonBuscar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jbContinuar = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

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

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 102, 0));
        jLabel8.setText("AGREGAR CLIENTE");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("DNI:");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(51, 51, 51));
        jLabel6.setText("Telefono:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 51, 51));
        jLabel4.setText("Direccion:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("Apellido:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("Nombre:");

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

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Observaciones:");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 51, 51));
        jLabel7.setText("Email:");

        jbLimpiar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jbLimpiar.setText("Limpiar");
        jbLimpiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        jButtonBuscar.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jButtonModificar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jButtonModificar.setText("Editar");
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jbContinuar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbContinuar.setForeground(new java.awt.Color(0, 204, 102));
        jbContinuar.setText("Agregar");
        jbContinuar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbContinuarActionPerformed(evt);
            }
        });

        jbVolver.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbVolver.setForeground(new java.awt.Color(255, 102, 0));
        jbVolver.setText("Volver al menú");
        jbVolver.setBorder(null);
        jbVolver.setBorderPainted(false);
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        jbEliminar.setFont(new java.awt.Font("Dialog", 0, 13)); // NOI18N
        jbEliminar.setForeground(new java.awt.Color(255, 0, 0));
        jbEliminar.setText("Eliminar");
        jbEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(53, 53, 53))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                            .addComponent(jtDNI)
                            .addComponent(jtDireccion)
                            .addComponent(jtTelefono)
                            .addComponent(jtEmail)
                            .addComponent(jtApellido))
                        .addGap(134, 134, 134)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jbContinuar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(84, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jbContinuar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel3)
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(12, 12, 12)
                        .addComponent(jtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jbVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    
    
    
    
    private void Limpiar(){
        jtDNI.setText("");
        jtNombre.setText("");
        jtApellido.setText("");
        jtTelefono.setText("");
        jtDireccion.setText("");
        jtEmail.setText("");
        jtObservaciones.setText("");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void jbContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbContinuarActionPerformed

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
                Limpiar();

            }
        } catch (NumberFormatException nu) {

            JOptionPane.showMessageDialog(null, "No puede haber campos vacíos");
        }


    }//GEN-LAST:event_jbContinuarActionPerformed


    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed

        Limpiar();

    }//GEN-LAST:event_jbLimpiarActionPerformed

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

    private void jtTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtTelefonoKeyTyped

        int key = evt.getKeyChar();

        boolean numeros = key >= 48 && key <= 57;

        if (!numeros) {
            evt.consume();
        }

        if (jtTelefono.getText().trim().length() == 10) {
            evt.consume();
        }

    }//GEN-LAST:event_jtTelefonoKeyTyped

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

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed

        Menu menu = new Menu();
        menu.show();
        dispose();

    }//GEN-LAST:event_jbVolverActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        ClienteData buscarCliente = new ClienteData();
        
        
        
        if (jtDNI.getText() == null || jtDNI.getText().isEmpty() && jtNombre.getText().isEmpty() && jtApellido.getText().isEmpty()){
            
            JOptionPane.showMessageDialog(null, "No vas a encontrar nada con un DNI vacío", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
            
        }else{
        
        
        
        if (!(jtDNI.getText().isEmpty()) && (buscarCliente.existeDNI(Integer.parseInt(jtDNI.getText())) == false)){
            
            JOptionPane.showMessageDialog(null, "El DNI "+jtDNI.getText()+" no se registra en nuestra base de datos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }
        
        
        else if (!jtDNI.getText().isEmpty()) {

            
                clienteBuscado = buscarCliente.buscarClientePorDni(Integer.parseInt(jtDNI.getText()));

                jtApellido.setText(clienteBuscado.getApellido());
                jtNombre.setText(clienteBuscado.getNombre());
                jtDireccion.setText(clienteBuscado.getDireccion());
                jtTelefono.setText(String.valueOf(clienteBuscado.getTelefono()));
                jtObservaciones.setText(clienteBuscado.getObservaciones());
                jtEmail.setText(clienteBuscado.getEmail());

                clienteBuscado.setDni(Integer.parseInt(jtDNI.getText()));
            
            
            
        } else if (!(jtNombre.getText().isEmpty()) && jtApellido.getText().isEmpty()) {

            

                Cliente cliente;
                
                ArrayList<Cliente> listaClientes = buscarCliente.obtenerClientesPorNombre(jtNombre.getText());
                
                
                

                int cantidad = listaClientes.size();
                
                
                
                ArrayList<String> nombresClientes = new ArrayList<>();

            for (Cliente c : listaClientes) {


                    String nombreCliente = c.getNombre();
                    String apellido = c.getApellido();
                    int dni = c.getDni();
                    String domi = c.getDireccion();
                    nombresClientes.add("\n"+nombreCliente+" "+apellido+" con DNI: " +dni+ " y vive en: "+domi);
                
            }
            

            

                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(null, "No existen clientes que se llamen " + jtNombre.getText());
                } else if (cantidad == 1) {
                    
                    String nombrecliente = jtNombre.getText();
                    
                    cliente = buscarCliente.buscarClientePorNombre(nombrecliente);
                    
                    
                    jtApellido.setText(cliente.getApellido());
                    jtDNI.setText(String.valueOf(cliente.getDni()));
                    jtDireccion.setText(cliente.getDireccion());
                    jtTelefono.setText(String.valueOf(cliente.getTelefono()));
                    jtObservaciones.setText(cliente.getObservaciones());
                    jtEmail.setText(cliente.getEmail());

                    cliente.setNombre(jtNombre.getText());

                }else{
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Hay "+cantidad+" clientes con ese nombre, ellos son: \n"+nombresClientes);
                    
                }

            
        }else if (jtNombre.getText().isEmpty() && !(jtApellido.getText().isEmpty())) {
            
            
            Cliente cliente;
                
                ArrayList<Cliente> listaClientes = buscarCliente.obtenerClientesPorApellido(jtApellido.getText());
                
                
                

                int cantidad = listaClientes.size();
                
                
                
                ArrayList<String> nombresClientes = new ArrayList<>();

            for (Cliente c : listaClientes) {


                    String nombreCliente = c.getNombre();
                    String apellido = c.getApellido();
                    int dni = c.getDni();
                    String domi = c.getDireccion();
                    nombresClientes.add("\n"+nombreCliente+" "+apellido+" con DNI: " +dni+ " y vive en: "+domi);
                
            }
            

            

                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(null, "No existen clientes con el apellido " + jtApellido.getText());
                } else if (cantidad == 1) {
                    
                    String apellidocliente = jtApellido.getText();
                    
                    cliente = buscarCliente.buscarClientePorApellido(apellidocliente);
                    
                    
                    jtNombre.setText(cliente.getNombre());
                    jtDNI.setText(String.valueOf(cliente.getDni()));
                    jtDireccion.setText(cliente.getDireccion());
                    jtTelefono.setText(String.valueOf(cliente.getTelefono()));
                    jtObservaciones.setText(cliente.getObservaciones());
                    jtEmail.setText(cliente.getEmail());

                    cliente.setNombre(jtNombre.getText());

                }else{
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Hay "+cantidad+" clientes con ese apellido, ellos son: \n"+nombresClientes);
                    
                }
            
            
            
            
                
                
        } else if (!(jtNombre.getText().isEmpty()) && !(jtApellido.getText().isEmpty())) {

            
            
            Cliente cliente;
            
            String nombrecliente = jtNombre.getText();
            String apellidocliente = jtApellido.getText();
            
                
                ArrayList<Cliente> listaClientes = buscarCliente.obtenerClientesPorNombreApellido(nombrecliente, apellidocliente);
                
                
                

                int cantidad = listaClientes.size();
                
                
                
                ArrayList<String> nombresClientes = new ArrayList<>();

            for (Cliente c : listaClientes) {


                    String nombreCliente = c.getNombre();
                    String apellido = c.getApellido();
                    int dni = c.getDni();
                    String domi = c.getDireccion();
                    nombresClientes.add("\n"+nombreCliente+" "+apellido+" con DNI: " +dni+ " y vive en: "+domi);
                
            }
            

            

                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(null, "No existen clientes que se llamen " +nombrecliente+ " " +apellidocliente);
                } else if (cantidad == 1) {
                    
                    
                    
                    cliente = buscarCliente.buscarClientePorNombreApellido(nombrecliente, apellidocliente);
                    
                    
                    jtDNI.setText(String.valueOf(cliente.getDni()));
                    jtDireccion.setText(cliente.getDireccion());
                    jtTelefono.setText(String.valueOf(cliente.getTelefono()));
                    jtObservaciones.setText(cliente.getObservaciones());
                    jtEmail.setText(cliente.getEmail());

                    cliente.setNombre(jtNombre.getText());

                }else{
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Hay "+cantidad+" clientes con ese nombre y apellido, ellos son: \n"+nombresClientes);
                    
                }
                 
            
                /*clienteBuscado = buscarCliente.buscarClientePorApellido(jtApellido.getText());

                jtNombre.setText(clienteBuscado.getNombre());
                jtDNI.setText(String.valueOf(clienteBuscado.getDni()));
                jtDireccion.setText(clienteBuscado.getDireccion());
                jtTelefono.setText(String.valueOf(clienteBuscado.getTelefono()));
                jtObservaciones.setText(clienteBuscado.getObservaciones());
                jtEmail.setText(clienteBuscado.getEmail());

                clienteBuscado.setApellido(jtApellido.getText());*/
                }
        }
        
        
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        
        if (jtDNI.getText() == null || jtDNI.getText().isEmpty() || "".equals(jtNombre.getText()) || "".equals(jtApellido.getText()) || "".equals(jtDireccion.getText()) || jtTelefono.getText() == null || jtTelefono.getText().isEmpty() || "".equals(jtEmail.getText()) || "".equals(jtObservaciones.getText())){
            
            JOptionPane.showMessageDialog(null, "No debe haber ningun campo vacío para editar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            
        }else{
        
        
        
        
        
        Cliente cliente = new Cliente();
        ClienteData clientedata = new ClienteData();

        
            cliente.setDni(Integer.parseInt(jtDNI.getText()));
            cliente.setApellido(jtApellido.getText());
            cliente.setNombre(jtNombre.getText());
            cliente.setDireccion(jtDireccion.getText());
            cliente.setEmail(jtEmail.getText());
            cliente.setTelefono(Long.parseLong(jtTelefono.getText()));
            cliente.setObservaciones(jtObservaciones.getText());

            if (clienteBuscado.getDni() != cliente.getDni()) {
                JOptionPane.showMessageDialog(null, "El dni no puede ser modificado");
            } else {
                clientedata.modificarCliente(cliente);
                Limpiar();
            }
        }

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed

        ClienteData clientedata = new ClienteData();
        ClientePaqueteData clientepaquetedata = new ClientePaqueteData();
        PaqueteData paquetedata = new PaqueteData();
        
        if (jtDNI.getText() == null || jtDNI.getText().isEmpty() || "".equals(jtNombre.getText()) || "".equals(jtApellido.getText()) || "".equals(jtDireccion.getText()) || jtTelefono.getText() == null || jtTelefono.getText().isEmpty() || "".equals(jtEmail.getText()) || "".equals(jtObservaciones.getText())){
            
            JOptionPane.showMessageDialog(null, "Para eliminar a un cliente, primero tenés que haberlo buscado", "Advertencia", JOptionPane.WARNING_MESSAGE);
        }else{
            
            Cliente clienteaeliminar = clientedata.buscarClientePorDni(Integer.parseInt(jtDNI.getText()));
            
            int idcliente = clienteaeliminar.getIdCliente();
            int dnicliente = clienteaeliminar.getDni();
            String nombrecliente = clienteaeliminar.getNombre();
            String apellidocliente = clienteaeliminar.getApellido();
            
            int opcion = JOptionPane.showConfirmDialog(null,
                        "¿Está seguro de que desea eliminar a " +nombrecliente+ " " +apellidocliente+ "?\nEsto romperá la relacion con los paquetes que "+nombrecliente+" tenga comprados",
                        "Confirmación",
                        JOptionPane.OK_CANCEL_OPTION);

                if (opcion == JOptionPane.OK_OPTION) {

                    ArrayList<ClientePaquete> listaClientePaquete = clientepaquetedata.buscarPaquetesPorCliente(idcliente);
                    
                    ArrayList<String> nombresPaquetes = new ArrayList<>();
                    
                    for (ClientePaquete cp : listaClientePaquete) {
                        
                        int cuposocupados = cp.getPaquete().getCuposOcupados() - 1;
                        cp.getPaquete().setCuposOcupados(cuposocupados);
                        
                        paquetedata.restarCupos(cp.getPaquete());
                        
                        
                        
                        
                        
                        nombresPaquetes.add("\n"+cp.getPaquete().getNombrePaquete());
                    
                
            }
                    
                    clientepaquetedata.eliminarClientePaquete_PorCliente(idcliente);
                    clientedata.elimninarCliente(dnicliente);
                    JOptionPane.showMessageDialog(null, "Se eliminó a "+nombrecliente+" "+apellidocliente+" y se eliminaron las relaciones con: "+nombresPaquetes); 
                    Limpiar();
                    
                }
            
            
        
            
        
        }
    }//GEN-LAST:event_jbEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JButton jbContinuar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JButton jbVolver;
    private javax.swing.JTextField jtApellido;
    private javax.swing.JTextField jtDNI;
    private javax.swing.JTextField jtDireccion;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtObservaciones;
    private javax.swing.JTextField jtTelefono;
    // End of variables declaration//GEN-END:variables
}
