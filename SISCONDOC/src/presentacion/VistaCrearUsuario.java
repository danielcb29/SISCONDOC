/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;
<<<<<<< HEAD
import javax.swing.JOptionPane;
import proceso.*;
import almacenamiento.controlador.*;

/**
 * Clase VistaCrearUsuario. Clase con la interfaz grafica para 
 * crear un usario nuevo en el sistema
 * @author SISCONDOC Development team
 */
public class VistaCrearUsuario extends javax.swing.JFrame {

    UserController objControl;
    /**
     * Constructor de la clase
     */
    
    public VistaCrearUsuario(UserController controler) {
        initComponents();
        objControl=controler;
=======
//COMENTARIO DE PRUEBA
/**
 *
 * @author JuanD
 */
public class VistaCrearUsuario extends javax.swing.JFrame {

    /**
     * Creates new form VistaCrearUsuario
     */
    public VistaCrearUsuario() {
        initComponents();
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

<<<<<<< HEAD
        lblTitulo = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lblLogo = new javax.swing.JLabel();
        lblNombres = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        lblApellidos = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtMail = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtNomUsuario = new javax.swing.JTextField();
        lblNomUsuario = new javax.swing.JLabel();
        lblContrasena = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        txtCedula = new javax.swing.JTextField();
        lblCedula = new javax.swing.JLabel();
        lblPerfil = new javax.swing.JLabel();
        comboPerfil = new javax.swing.JComboBox();
        btnCrear = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Administrador: Crear Usuario");
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setText("Crear Usuario");

        lblDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblDescripcion.setText("Aquí encontrará el formulario de creación de usuarios");

        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/LogoSinFondo2.png"))); // NOI18N

        lblNombres.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombres.setText("Nombres:");

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");

        lblMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMail.setText("E-mail:");

        lblNomUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomUsuario.setText("Nombre de Usuario:");

        lblContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContrasena.setText("Contraseña:");

        lblCedula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCedula.setText("Número de cédula:");

        lblPerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPerfil.setText("Perfil:");

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Digitador", "Coordinador", "Administrador" }));

        btnCrear.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
=======
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Titulo");
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblDescripcion))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblLogo)
                        .addGap(102, 102, 102))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblContrasena)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNomUsuario)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblMail)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblApellidos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombres)
                                    .addGap(162, 162, 162)
                                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lblCedula)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lblPerfil)
                                            .addGap(189, 189, 189)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 62, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCrear)
                .addGap(42, 42, 42)
                .addComponent(btnCancelar)
                .addGap(36, 36, 36))
=======
                .addGap(170, 170, 170)
                .addComponent(jLabel1)
                .addContainerGap(204, Short.MAX_VALUE))
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
<<<<<<< HEAD
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(lblTitulo)
                        .addGap(18, 18, 18)
                        .addComponent(lblDescripcion))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombres)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellidos)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMail)
                    .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomUsuario)
                    .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCedula)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPerfil)
                    .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
=======
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addContainerGap(251, Short.MAX_VALUE))
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
<<<<<<< HEAD
    
    /**
     * Metodo que se ejecuta si se presiona el boton cancelar
     * @param evt Evento que dispara el metodo
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    
    /**
     * Metodo que se ejecuta si se presiona el boton crear
     * @param evt Evento que dispara el metodo
     */
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        //Se declara objeto de la clase usuario
        Usuario objUsuario;
        
        //Se guarda el nombre de usuario ingresado en una cadena de texto
        String username=txtNomUsuario.getText();
        
        //Se instancia la clase controlador para hacer uso de ella
       
        
        //Se consulta si el nombre de usuario ya existe en la base de datos
        objUsuario=objControl.consultUser(username);
        
        //Si no existe, se capturan los demas datos de la interfaz,
        //se envian al controlador para guardarlos y se informa al
        //usuario
        if(objUsuario.getPassword()==null){
            String nombres=txtNombres.getText();
            String apellidos=txtApellidos.getText();
            String contrasena=txtContrasena.getText();
            String email=txtMail.getText();
            String cedula=txtCedula.getText();
            int numPerfil=comboPerfil.getSelectedIndex()+1;
            String perfil=Integer.toString(numPerfil);
            int result = objControl.createUser(cedula, nombres, apellidos, username, contrasena, email, perfil);
            
            if(result == -1 || result == -2){
                JOptionPane.showMessageDialog(this, "Posiblemente estas ingresando a una persona que ya existe \nIntenta ingresar a una persona diferente (cedula diferente)\nSi el problema persiste ha ocurrido un error en la base de datos,consulta al personal encargado","Error!",JOptionPane.ERROR_MESSAGE);
            }else{
                //Se imprime el mensaje para informar el exito de la operacion
                JOptionPane.showMessageDialog(this, "El usuario "+ username+" se ha creado con exito", "Mensaje de exito",JOptionPane.INFORMATION_MESSAGE);
                //Se limpian los campos de la interfaz
                 /* txtNombres.setText("");
                txtApellidos.setText("");
                txtContrasena.setText("");
                txtMail.setText("");
                txtCedula.setText("");
                txtNomUsuario.setText("");*/
                //Cerrar la base de datos 
                //Cerramos la ventana
                this.dispose();
            }
                    
            
            
            
        }else{
            //Si ya existe el nombre de usuario en la base de datos se informa al
            //usuario del error
            JOptionPane.showMessageDialog(null, "El nombre de usuario "+username+" ya existe");
        }
    }//GEN-LAST:event_btnCrearActionPerformed
=======
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0

    /**
     * @param args the command line arguments
     */
<<<<<<< HEAD
    /*public static void main(String args[]) {
=======
    public static void main(String args[]) {
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
<<<<<<< HEAD
         *//*
=======
         */
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCrearUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

<<<<<<< HEAD
        /* Create and display the form *//*
=======
        /* Create and display the form */
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCrearUsuario().setVisible(true);
            }
        });
<<<<<<< HEAD
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JComboBox comboPerfil;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblCedula;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNomUsuario;
    private javax.swing.JLabel lblNombres;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNombres;
=======
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
>>>>>>> 369c56be444d9dddfcffb741d6e83b73a7a428d0
    // End of variables declaration//GEN-END:variables
}
