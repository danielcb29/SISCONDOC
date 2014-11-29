/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import almacenamiento.controlador.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import proceso.Convocatoria;
/**
 *
 * @author USUARIO
 */
public class VistaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form VistaAdmin
     */

    private String name="User Default";
    private VistaCrearUsuario objVistaCrearUsuario;
    private UserController objUserController;
    private VistaConvocatoria vistaConvo;
    private ConvocatoriaController objConvController;
    private Connection conn;
    private VistaEditarUsuario objVistaEditarUsuario;
    
    public VistaAdmin(){}
    public VistaAdmin(String username,UserController controler){
        initComponents();
        this.setTitle("Panel Administrador: "+username);
        name=username;
        lbWelcome.setText("Bienvenido "+name+"!");
        objUserController= controler;
        conn = objUserController.getConn();
        objConvController = new ConvocatoriaController(conn);
        
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
        label2 = new java.awt.Label();
        label1 = new java.awt.Label();
        btCrearUsuario = new javax.swing.JButton();
        btEditarUsuario = new javax.swing.JButton();
        btEliminarUsuario = new javax.swing.JButton();
        label6 = new java.awt.Label();
        btCrearConvocatoria = new javax.swing.JButton();
        btEditarConvocatoria = new javax.swing.JButton();
        btEliminarConvocatoria = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbWelcome = new javax.swing.JLabel();
        btCerrarSesion = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setFocusTraversalPolicyProvider(true);
        setResizable(false);

        label2.setAlignment(1);
        label2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        label2.setText("Aqui encontrara el menu de administracion de la aplicacion");

        label1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label1.setText("Gestion de Usuarios:");

        btCrearUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCrearUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/add-user-icon.png"))); // NOI18N
        btCrearUsuario.setText("Crear Usuario");
        btCrearUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btCrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearUsuarioActionPerformed(evt);
            }
        });

        btEditarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEditarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/edit-user-icon.png"))); // NOI18N
        btEditarUsuario.setText("Editar Usuario");
        btEditarUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btEditarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarUsuarioActionPerformed(evt);
            }
        });

        btEliminarUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEliminarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/delete-user-icon.png"))); // NOI18N
        btEliminarUsuario.setText("Eliminar Usuario");
        btEliminarUsuario.setMaximumSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.setMinimumSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.setPreferredSize(new java.awt.Dimension(151, 25));
        btEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarUsuarioActionPerformed(evt);
            }
        });

        label6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        label6.setText("Gestion de Convocatorias:");

        btCrearConvocatoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btCrearConvocatoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Add-convo-icon.png"))); // NOI18N
        btCrearConvocatoria.setText("Crear Convocatoria");
        btCrearConvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCrearConvocatoriaActionPerformed(evt);
            }
        });

        btEditarConvocatoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEditarConvocatoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/edit-convo-icon.png"))); // NOI18N
        btEditarConvocatoria.setText("Editar Convocatoria");
        btEditarConvocatoria.setMaximumSize(new java.awt.Dimension(151, 25));
        btEditarConvocatoria.setMinimumSize(new java.awt.Dimension(151, 25));
        btEditarConvocatoria.setPreferredSize(new java.awt.Dimension(151, 25));
        btEditarConvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarConvocatoriaActionPerformed(evt);
            }
        });

        btEliminarConvocatoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btEliminarConvocatoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/delete-convo-icon.png"))); // NOI18N
        btEliminarConvocatoria.setText("Eliminar Convocatoria");
        btEliminarConvocatoria.setMaximumSize(new java.awt.Dimension(151, 25));
        btEliminarConvocatoria.setMinimumSize(new java.awt.Dimension(151, 25));
        btEliminarConvocatoria.setPreferredSize(new java.awt.Dimension(151, 25));
        btEliminarConvocatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEliminarConvocatoriaActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("<html><i>\nRecuerde que para crear Usuarios\ndebe haber creado como minimo\nuna convocatoria</i></html>");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("<html><i>\nPuede crear tantas convocatorias\ncomo necesite</i><html>");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/LogoSinFondo2.png"))); // NOI18N

        lbWelcome.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbWelcome.setText("Bienvenido");

        btCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Login-out-icon.png"))); // NOI18N
        btCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCerrarSesionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(btCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(78, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btEditarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                                .addComponent(btCrearUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btEliminarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btEditarConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btCrearConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(label6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btEliminarConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(122, 122, 122))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(43, 43, 43))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbWelcome)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(label2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btCerrarSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addComponent(btCrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEditarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(btCrearConvocatoria))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(label6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(btEditarConvocatoria, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btEliminarConvocatoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCerrarSesionActionPerformed
        // TODO add your handling code here:
        objUserController.cerrarConexionBD();
        System.exit(0); 
    }//GEN-LAST:event_btCerrarSesionActionPerformed

    private void btEditarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarUsuarioActionPerformed
        // TODO add your handling code here:
        
        if(objUserController.countUsers()== 0){
          JOptionPane.showMessageDialog(null, "No hay Usuarios para editar","", JOptionPane.INFORMATION_MESSAGE);  
        }
        else{
            objVistaEditarUsuario = new VistaEditarUsuario(objUserController, objConvController,1);
            objVistaEditarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_btEditarUsuarioActionPerformed

    private void btEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarUsuarioActionPerformed
        // TODO add your handling code here:
        if(objUserController.countUsers()== 0){
          JOptionPane.showMessageDialog(null, "No hay Usuarios para eliminar","", JOptionPane.INFORMATION_MESSAGE);  
        }
        else{
            //System.out.println("Por ahora no se ha implementado :)");
            objVistaEditarUsuario = new VistaEditarUsuario(objUserController, objConvController,2);
            objVistaEditarUsuario.setVisible(true);
        }
    }//GEN-LAST:event_btEliminarUsuarioActionPerformed

    private void btCrearConvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearConvocatoriaActionPerformed
        // TODO add your handling code here:
       
        vistaConvo = new VistaConvocatoria(objConvController,1);
        vistaConvo.setVisible(true);
        
    }//GEN-LAST:event_btCrearConvocatoriaActionPerformed

    private void btEditarConvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarConvocatoriaActionPerformed
        // TODO add your handling code here:
        Convocatoria[] convArray = objConvController.listConv();
        int sizeArray = convArray.length;
        if (sizeArray == 0){
            JOptionPane.showMessageDialog(this, "Por el momento no hay convocatorias en el sistema, prueba creando una!","Ups!",JOptionPane.WARNING_MESSAGE);
        }else{
            //System.out.println("No se ha implementado aun :)");
            vistaConvo = new VistaConvocatoria(objConvController,2);
            vistaConvo.setVisible(true);
        }
    }//GEN-LAST:event_btEditarConvocatoriaActionPerformed

    private void btEliminarConvocatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEliminarConvocatoriaActionPerformed
        // TODO add your handling code here
        Convocatoria[] convArray = objConvController.listConv();
        int sizeArray = convArray.length;
        if (sizeArray == 0){
            JOptionPane.showMessageDialog(this, "Por el momento no hay convocatorias en el sistema, prueba creando una!","Ups!",JOptionPane.WARNING_MESSAGE);
        }else{
            //System.out.println("No se ha implementado aun :)");
            vistaConvo = new VistaConvocatoria(objConvController,3);
            vistaConvo.setVisible(true);
        }
    }//GEN-LAST:event_btEliminarConvocatoriaActionPerformed

    private void btCrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCrearUsuarioActionPerformed
        // TODO add your handling code here:
        objVistaCrearUsuario = new VistaCrearUsuario(objUserController,objConvController);
        objVistaCrearUsuario.setVisible(true);
    }//GEN-LAST:event_btCrearUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */
    /*public static void main(String args[]) {
        //Set the Nimbus look and feel 
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */ /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        // Create and display the form 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaAdmin("Nelson").setVisible(true);
            }
        });
    }*/
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCerrarSesion;
    private javax.swing.JButton btCrearConvocatoria;
    private javax.swing.JButton btCrearUsuario;
    private javax.swing.JButton btEditarConvocatoria;
    private javax.swing.JButton btEditarUsuario;
    private javax.swing.JButton btEliminarConvocatoria;
    private javax.swing.JButton btEliminarUsuario;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private java.awt.Label label1;
    private java.awt.Label label2;
    private java.awt.Label label6;
    private javax.swing.JLabel lbWelcome;
    // End of variables declaration//GEN-END:variables

}