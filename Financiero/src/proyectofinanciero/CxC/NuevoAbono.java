/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinanciero.CxC;

import DAO.DAO_Abono;
import DAO.DAO_Venta;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelos.Abono;
import modelos.DetalleCompra;
import proyectofinanciero.Menu;

/**
 *
 * @author pci
 */
public class NuevoAbono extends javax.swing.JFrame {

    /**
     * Creates new form NuevoAbono
     */
    DAO_Abono daoAbo;
    ArrayList<Abono> datosAbono;
    String factura;
    private String d;
    private SimpleDateFormat sd;
    private String dd;
    private Date fec;
    Abono datosC;
    String numero;
    DAO_Venta daoVenta;
    int posicion;
    private Date moratorio;

    public NuevoAbono() {
        initComponents();
        
        this.setLocationRelativeTo(this);
    }

    public NuevoAbono(String factura, Abono datos) {
        initComponents();
        this.setLocationRelativeTo(null);
        this.factura = factura;
        datosC = datos;
        numero = "";
        daoAbo = new DAO_Abono();
        daoVenta = new DAO_Venta();
        d = "dd-MM-yyyy";
        sd = new SimpleDateFormat(d);
        btnGuardar.setEnabled(false);
        try {
            datosAbono = daoAbo.getDatosClienteParaAbono(factura);
            txtFact.setText(factura);
            posicion = datosAbono.size() - 1;
            txtMora.setText(String.valueOf(datosAbono.get(posicion).getMora()));
            txtCuota.setText(String.format("%.2f", datosAbono.get(posicion).getCuota()));
            txtCliente.setText(datosC.getCliente());
            txtProducto.setText(datosC.getProducto());
            lblPending.setText(String.valueOf(datosC.getCredInicial() - datosC.getSaldoPendiente()));
            moratorio = datosAbono.get(posicion).getProxPago();
            txtPpago.setText(sd.format(datosAbono.get(posicion).getProxPago()));
            txtProxP.setText(sd.format(SigP(datosAbono.get(posicion).getProxPago(), 30)));
            Calendar fecha = new GregorianCalendar();
            dd = sd.format(fecha.getTime());
            try {
                fec = sd.parse(dd);
            } catch (ParseException ex) {
                Logger.getLogger(NuevoAbono.class.getName()).log(Level.SEVERE, null, ex);
            }
            jfecha.setDate(fec);
            jfecha.setMinSelectableDate(fec);
            mora(datosAbono.get(posicion).getCuota());
        } catch (SQLException ex) {
            Logger.getLogger(NuevoAbono.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMora = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jfecha = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        txtFact = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtCuota = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        spAbono = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        lblPending = new javax.swing.JLabel();
        txtPpago = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtProxP = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        spAbonoRec = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Abono a Cuenta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(148, 148, 148)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Mora $");

        txtMora.setEditable(false);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Cliente");

        txtCliente.setEditable(false);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Fecha");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("N° Factura");

        txtFact.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Monto a abonar");

        btnGuardar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/diskette (1).png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel7.setText("Cuota $");

        txtCuota.setEditable(false);

        spAbono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spAbono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spAbonoFocusLost(evt);
            }
        });
        spAbono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spAbonoActionPerformed(evt);
            }
        });
        spAbono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spAbonoKeyTyped(evt);
            }
        });

        jLabel8.setText("Saldo Pendiente Actual:");

        lblPending.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblPending.setText("aaaa");

        txtPpago.setEditable(false);
        txtPpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPpagoActionPerformed(evt);
            }
        });

        jLabel10.setText("Fecha maxima de pago");

        jLabel11.setText("Sig. Fecha de pago");

        txtProxP.setEditable(false);
        txtProxP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProxPActionPerformed(evt);
            }
        });

        jLabel9.setText("Producto");

        txtProducto.setEditable(false);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setText("Monto recibido");

        spAbonoRec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        spAbonoRec.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                spAbonoRecFocusLost(evt);
            }
        });
        spAbonoRec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spAbonoRecActionPerformed(evt);
            }
        });
        spAbonoRec.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                spAbonoRecKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/calculadora.png"))); // NOI18N
        jButton1.setText("Calcular Cambio");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setText("Cambio  $");

        lblCambio.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        lblCambio.setText("0.00");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFact, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(spAbono, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnGuardar)
                            .addComponent(spAbonoRec, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPending)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(txtPpago, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtProxP, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                                .addComponent(jLabel10)))
                        .addGap(58, 58, 58)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel5)
                        .addComponent(txtFact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jfecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtCuota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtMora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPpago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(lblPending)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtProxP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spAbono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spAbonoRec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(jButton1)
                    .addComponent(jLabel13)
                    .addComponent(lblCambio))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void spAbonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spAbonoKeyTyped
        // TODO add your handling code here:
        char[] p = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.'};
        int b = 0;
        for (int i = 0; i <= 10; i++) {
            if (p[i] == evt.getKeyChar()) {
                b = 1;
                numero += p[i];
            }
        }
        if (b == 0) {
            evt.consume();
            getToolkit().beep();
        }
    }//GEN-LAST:event_spAbonoKeyTyped

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        String monto = spAbono.getText();
        if ("".equals(monto)) {
            JOptionPane.showMessageDialog(this, "Ingrese monto ");
        } else {
            Double pendiente = Double.parseDouble(lblPending.getText());
            Double cuota = Double.parseDouble(txtCuota.getText());
            Date fecha = jfecha.getDate();
            Double abono = Double.parseDouble(spAbono.getText());
            String flag = txtProxP.getText();
            int idDetVenta = datosAbono.get(posicion).getId_detVenta();
            Double mora = Double.parseDouble(txtMora.getText());
            if (pendiente > cuota) {
                if (abono < cuota + mora) {
                    JOptionPane.showMessageDialog(this, "MONTO MENOR A CUOTA ESTABLECIDA,PRESTAR ATENCION A LA MORA");
                } else {
                    try {
                        daoAbo.GuardarAbono(new Abono(idDetVenta, fecha, (abono - mora), mora, sd.parse(flag)));
                    } catch (SQLException | ParseException ex) {
                        Logger.getLogger(NuevoAbono.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Exito");
                    Menu.rcc.uTabla(datosC.getDui());
                    factura(fecha, abono, pendiente, flag, mora);
                    dispose();
                }
            } else {
                if (abono > cuota + mora) {
                    JOptionPane.showMessageDialog(this, "Monto mayor al valor restante de credito");
                } else {
                    try {
                        daoAbo.GuardarAbono(new Abono(idDetVenta, fecha, (abono - mora), mora, sd.parse(flag)));
                        daoAbo.setEstado(idDetVenta);
                    } catch (SQLException | ParseException ex) {
                        Logger.getLogger(NuevoAbono.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    JOptionPane.showMessageDialog(this, "Exito");
                    Menu.rcc.uTabla(datosC.getDui());
                    factura(fecha, abono, pendiente, flag, mora);
                    dispose();
                }
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtPpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPpagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPpagoActionPerformed

    private void txtProxPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProxPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProxPActionPerformed

    private void spAbonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spAbonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spAbonoActionPerformed

    private void spAbonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spAbonoFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_spAbonoFocusLost

    private void spAbonoRecFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_spAbonoRecFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_spAbonoRecFocusLost

    private void spAbonoRecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spAbonoRecActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spAbonoRecActionPerformed

    private void spAbonoRecKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spAbonoRecKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_spAbonoRecKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Double abonar = Double.parseDouble(spAbono.getText());
        Double recibido = Double.parseDouble(spAbonoRec.getText());
        Double mora = Double.parseDouble(txtMora.getText());
        Double cambio;
        if (abonar == 0 || recibido == 0) {
            JOptionPane.showMessageDialog(this, "Por favor ingrese los respectivos montos");
        } else {
            cambio = recibido - (abonar + mora);
            if (cambio < 0) {
                JOptionPane.showMessageDialog(this, "Monto recibido no suficiente");
            } else {
                lblCambio.setText(String.format("%.2f", cambio));
                btnGuardar.setEnabled(true);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    private Date SigP(Date fechaE, int dias) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaE);
        calendar.add(calendar.DAY_OF_YEAR, dias);
        return calendar.getTime();
    }

    private void mora(Double morita) {
        if (moratorio.compareTo(fec) < 0) {
            Double mora = morita * 0.05;
            txtMora.setText(String.format("%.2f", mora));
        }
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JSeparator jSeparator1;
    private com.toedter.calendar.JDateChooser jfecha;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblPending;
    private javax.swing.JTextField spAbono;
    private javax.swing.JTextField spAbonoRec;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCuota;
    private javax.swing.JTextField txtFact;
    private javax.swing.JTextField txtMora;
    private javax.swing.JTextField txtPpago;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtProxP;
    // End of variables declaration//GEN-END:variables

    private void factura(Date fecha, Double abono, Double pendiente, String flag, Double mora) {
        Date fechaFact = fecha;
        Double montoAbonado = abono;
        Double pendActual = pendiente;
        String proxPago = flag;
        String cliente = datosC.getCliente();
        String productos = datosC.getProducto();
        String factura = this.factura;
        Double cambio = Double.parseDouble(lblCambio.getText());
        Double monto = montoAbonado + cambio;
        Double moraa = mora;
        FacturaAbono fact = new FacturaAbono(fechaFact, montoAbonado, pendActual, proxPago, cliente,
                productos, factura, cambio, monto, moraa);
        fact.setVisible(true);
    }

}
