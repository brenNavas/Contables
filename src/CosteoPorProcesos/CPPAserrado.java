/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CosteoPorProcesos;

import Logica.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import static Vistas.CGeneral.inicioCG;
import java.text.DecimalFormat;

/**
 *
 * @author Yeseliz
 */
public class CPPAserrado extends javax.swing.JInternalFrame {
public static final Double MOD =120.00 ;//considerando $100 de tala y 792.02 de aserrado (cedro) 1.98 CADA VARA
public static final Double MP= 150.00; //costo del árbol Plantado 
public static Double costoPrimo=0.0;
public static Double cifA=1073.65;
public static final Double CUMaterial = 0.38;
public static final Double ant=429.46;
/*public static final Double salario2=0.25; //por vara
public static final Double salario1=1.98;// por vara*/

private Conexion mysql = new Conexion();
private Connection cn = mysql.conectar();
private String sentenciaSql = "";
    /**
     * Creates new form CPPAserrado
     */
    public CPPAserrado() {
        initComponents();
        llenarComboBoxProducto();
    }
    public void llenarComboBoxProducto(){
        String materiaPrima,id;
       try {
           sentenciaSql= "SELECT nombreProducto FROM producto WHERE proceso = 'Corte y Costura'";
           Statement statement = this.cn.createStatement();
            ResultSet resultado = statement.executeQuery(sentenciaSql);
                while (resultado.next()) {
                materiaPrima=resultado.getString("nombreProducto");
                
                boxProducto1.addItem(materiaPrima);
               
            }
                } 
       catch (SQLException ex) {}
    }//Fin de método llenarCombos.
    public double costoPrimo(){
        costoPrimo=costoT1()+MOD;
        return costoPrimo;
    }
    
    /*public static Double cifAserrado(){
        DecimalFormat formateador = new DecimalFormat("####.##");
     
        Double cifDia= 2412.00/22.0; //CIF por dia
        cifA = cifDia/18.18; //18.18 es el total de varas que se hacen en un dia (4.42)
        String convertido1 = formateador.format(cifA);
        Double c = Double.parseDouble(convertido1);
        return c;
    }*/
    
    public static Double costoT1(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double total1= CUMaterial*400;
        String convertido2 = formateador.format(total1);
        Double c1 = Double.parseDouble(convertido2);
        return c1;  
    }
    
    /*public static Double costoT2(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double total2= (salario1+salario2)*400;
        String convertido3 = formateador.format(total2);
        Double c2 = Double.parseDouble(convertido3);
        return c2;  
    }*/
    
   /* public static double costoT3(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double total3 = cifAserrado()*400;
        String convertido4 = formateador.format(total3);
        Double c3 = Double.parseDouble(convertido4);
        return c3;
    }*/
    
    public static double Total(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double t= costoT1()+MOD+cifA;
        String convertido5 = formateador.format(t);
        Double total = Double.parseDouble(convertido5);
        return total;
    }
    
    public static double tot(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double tt=ant+Total();
        String convertido5 = formateador.format(tt);
        Double tota = Double.parseDouble(convertido5);
        return tota;
    }
    /*public double costoU(){
        DecimalFormat formateador = new DecimalFormat("####.##");
        Double cu= Total()/400;
        String convertido6 = formateador.format(cu);
        Double unitario = Double.parseDouble(convertido6);
        return unitario;
    }*/
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        txtCostoPrimo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        boxProducto1 = new javax.swing.JComboBox<>();
        costoUnitarioarbolplantado = new javax.swing.JLabel();
        LABEL3 = new javax.swing.JLabel();
        LABL2 = new javax.swing.JLabel();
        labelCTMO = new javax.swing.JLabel();
        labelCTM = new javax.swing.JLabel();
        labelCIF = new javax.swing.JLabel();
        labeltotal = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Producto en Proceso");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true), "COSTOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton2.setText("Ver CIF");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo Primo:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCostoPrimo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton2)
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCostoPrimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(79, 79, 79))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 140, 270));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true), "COSTOS  DEL DEPARTAMENTO DE CORTE Y COSTURA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12), new java.awt.Color(204, 204, 204)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        boxProducto1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cedro" }));
        boxProducto1.setOpaque(false);
        boxProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxProducto1ActionPerformed(evt);
            }
        });
        jPanel3.add(boxProducto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 160, 30));
        jPanel3.add(costoUnitarioarbolplantado, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 50, 20));

        LABEL3.setText("1073.65");
        jPanel3.add(LABEL3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, -1, -1));

        LABL2.setText("120");
        jPanel3.add(LABL2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));
        jPanel3.add(labelCTMO, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 70, 20));
        jPanel3.add(labelCTM, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 110, 60, 20));
        jPanel3.add(labelCIF, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 210, 70, 20));
        jPanel3.add(labeltotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 70, 20));

        jButton1.setText("Calcular Costos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jTextField1.setAutoscrolls(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTextField1PropertyChange(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 50, -1));
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 260, 60, 20));
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 340, 60, 20));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\Admin\\Documents\\sis\\sis\\SISTEMA CONTABLE\\SContable\\src\\Imagenes\\TABLA.png")); // NOI18N
        jLabel7.setText("jLabel7");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 470, 340));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 610, 410));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
       
        txtCostoPrimo.setText(Double.toString(costoPrimo()));
        
        /*COSTOumo.setText(Double.toString(salario1));*/
        costoUnitarioarbolplantado.setText(Double.toString(CUMaterial));
        labelCTM.setText(Double.toString(costoT1()));
        /*label2Salario.setText(Double.toString(salario2));*/
        labelCTMO.setText(Double.toString(MOD));
        /*labelCIF.setText(Double.toString(costoT3()));*/
        labeltotal.setText(Double.toString(Total()));
        jLabel5.setText(Double.toString(ant));
        jLabel6.setText(Double.toString(tot()));
        labelCIF.setText(Double.toString(cifA));
        
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CIF ase = new CIF();
         inicioCG.add(ase);
        ase.toFront();
        ase.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void boxProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_boxProducto1ActionPerformed

    private void jTextField1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTextField1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1PropertyChange

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LABEL3;
    private javax.swing.JLabel LABL2;
    private javax.swing.JComboBox<String> boxProducto1;
    private javax.swing.JLabel costoUnitarioarbolplantado;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelCIF;
    private javax.swing.JLabel labelCTM;
    private javax.swing.JLabel labelCTMO;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JTextField txtCostoPrimo;
    // End of variables declaration//GEN-END:variables
}