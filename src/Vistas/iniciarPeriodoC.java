/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Datos.Cuentas;
import Datos.Periodo;
import Logica.Conexion;
import com.toedter.calendar.demo.DateChooserPanel;
import java.awt.TextField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Rodriguez
 */
public class iniciarPeriodoC extends javax.swing.JInternalFrame{
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String sentenciaSql = "";

    /**
     * Creates new form periodoC
     */
    public iniciarPeriodoC() {
        initComponents();
        setResizable(false); //no se maximice la pantalla
        setTitle("Período Contable"); //Título del Frame
        Calendar c2 = new GregorianCalendar();
        DateInicio.setCalendar(c2);
        DateFin.setCalendar(c2);
    }

    
    public void iniciarPeriodoContable(){
        
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
        btnIniciarPeriodo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        DateInicio = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DateFin = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setFrameIcon(null);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 0, 102));
        jPanel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnIniciarPeriodo.setText("Guardar Período");
        btnIniciarPeriodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarPeriodoActionPerformed(evt);
            }
        });
        jPanel2.add(btnIniciarPeriodo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, -1, -1));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 0, 102));
        jLabel2.setText("PERÍODO CONTABLE");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, -1, -1));

        DateInicio.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(DateInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 200, -1));

        jLabel3.setForeground(new java.awt.Color(153, 0, 102));
        jLabel3.setText("Fin:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel5.setForeground(new java.awt.Color(102, 0, 102));
        jLabel5.setText("Inicio:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, -1, -1));

        DateFin.setDateFormatString("yyyy-MM-dd");
        jPanel2.add(DateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 200, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 400, 180));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 420, 200));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondo.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 590, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarPeriodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarPeriodoActionPerformed
      
        
        try{
            Periodo periodo = new Periodo();
            sentenciaSql = "insert into periodo (inicio, fin) values (?,?)";
            PreparedStatement preparedStatement=cn.prepareStatement(sentenciaSql);
            preparedStatement.setString(1,((JTextField)DateInicio.getDateEditor().getUiComponent()).getText());
            preparedStatement.setString(2,((JTextField)DateFin.getDateEditor().getUiComponent()).getText());
            preparedStatement.executeUpdate();
            JOptionPane.showMessageDialog(null, "PERIODO CONTABLE GUARDADO");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
        
        /*
        DateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = this.vistaAlumno.getTxtFecha2().getText();
        Date date = fmt.parse(strDate);
        */
    }//GEN-LAST:event_btnIniciarPeriodoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(iniciarPeriodoC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(iniciarPeriodoC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(iniciarPeriodoC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(iniciarPeriodoC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new iniciarPeriodoC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public com.toedter.calendar.JDateChooser DateFin;
    public com.toedter.calendar.JDateChooser DateInicio;
    private javax.swing.JButton btnIniciarPeriodo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}