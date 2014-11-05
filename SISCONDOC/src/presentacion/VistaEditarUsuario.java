/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentacion;
import almacenamiento.controlador.*;
import javax.swing.JOptionPane;
import proceso.*;

/**
 *
 * @author alvaro
 */
public class VistaEditarUsuario extends javax.swing.JFrame {

    
    private UserController objUserController;
    private ConvocatoriaController objConvoController;
    private Convocatoria list [];
    /**
     * Creates new form VistaEditarUsuario
     */
    public VistaEditarUsuario(UserController objUserController, ConvocatoriaController objConvoController) {
       this.objUserController = objUserController;
       this.objConvoController = objConvoController;
       list = objConvoController.listConv();
       initComponents();
       
       for(int i=0; i<list.length; i++){
           System.out.println("numero convo"+list[i].toString());
           comboConvo.addItem(list[i]);
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

        lbTitle = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbSearch = new javax.swing.JLabel();
        tfSearchCedula = new javax.swing.JTextField();
        btSearch = new javax.swing.JButton();
        lblConvocatoria = new javax.swing.JLabel();
        lblApellidos = new javax.swing.JLabel();
        txtContrasena = new javax.swing.JTextField();
        lblMail = new javax.swing.JLabel();
        txtNomUsuario = new javax.swing.JTextField();
        lblNomUsuario = new javax.swing.JLabel();
        txtMail = new javax.swing.JTextField();
        lblContrasena = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        txtNombres = new javax.swing.JTextField();
        lblPerfil = new javax.swing.JLabel();
        comboPerfil = new javax.swing.JComboBox();
        btCancelar = new javax.swing.JButton();
        bModificar = new javax.swing.JButton();
        lblNombres1 = new javax.swing.JLabel();
        comboConvo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(781, 480));

        lbTitle.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lbTitle.setText("Editar Usuario");

        lbInfo.setText("Busque el usuario a editar, haga las ediciones y guarde para modificar");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/LogoSinFondo2.png"))); // NOI18N

        lbSearch.setText("Buscar:");

        tfSearchCedula.setText("Busqueda por cedula del usuario");
        tfSearchCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchCedulaActionPerformed(evt);
            }
        });

        btSearch.setText("Buscar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        lblConvocatoria.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblConvocatoria.setText("Convocatoria");

        lblApellidos.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellidos.setText("Apellidos:");

        lblMail.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblMail.setText("E-mail:");

        lblNomUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNomUsuario.setText("Nombre de Usuario:");

        lblContrasena.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblContrasena.setText("Contraseña:");

        lblPerfil.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPerfil.setText("Perfil:");

        comboPerfil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Digitador", "Coordinador", "Administrador" }));
        comboPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPerfilActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        bModificar.setText("Modificar");
        bModificar.setMaximumSize(new java.awt.Dimension(74, 29));
        bModificar.setMinimumSize(new java.awt.Dimension(74, 29));
        bModificar.setPreferredSize(new java.awt.Dimension(74, 29));
        bModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bModificarActionPerformed(evt);
            }
        });

        lblNombres1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombres1.setText("Nombres:");

        comboConvo.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        comboConvo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboConvoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfSearchCedula)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNombres1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btSearch)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(comboConvo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lbTitle))
                            .addComponent(lbInfo))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(lbSearch)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNomUsuario)
                    .addComponent(lblContrasena)
                    .addComponent(lblMail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtMail, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                        .addComponent(txtNomUsuario)
                        .addComponent(txtContrasena)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblApellidos)
                    .addComponent(lblPerfil)
                    .addComponent(lblConvocatoria))
                .addGap(271, 271, 271))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbTitle)
                        .addGap(18, 18, 18)
                        .addComponent(lbInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSearch)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSearchCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(lblMail)
                        .addGap(32, 32, 32)
                        .addComponent(lblNomUsuario))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellidos)
                            .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombres1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPerfil)
                            .addComponent(comboPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblConvocatoria)
                            .addComponent(comboConvo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblContrasena)
                    .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bModificar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btCancelar))
                .addGap(37, 37, 37))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfSearchCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchCedulaActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tfSearchCedulaActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        
        Usuario user;
        user = objUserController.consultUser(tfSearchCedula.getText(), 2);
        if(user==null){
            JOptionPane.showMessageDialog(this, "No se encuentra el usuario en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }else{
            txtNombres.setText(user.getName());
            txtApellidos.setText(user.getLastName());
            txtContrasena.setText(user.getPassword());
            txtMail.setText(user.getMail());
            txtNomUsuario.setText(user.getUserName());
            comboPerfil.setSelectedItem(user.getProfile());
            comboConvo.setSelectedItem(user.getConvocatoria());
        }
       
    }//GEN-LAST:event_btSearchActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void bModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bModificarActionPerformed
        int result;
        
        result = objUserController.editUser(tfSearchCedula.getText(), txtNombres.getText(), txtApellidos.getText(),txtNomUsuario.getText(), txtContrasena.getText(), txtMail.getText(), Integer.toString(comboPerfil.getSelectedIndex()+1), list[comboConvo.getSelectedIndex()+1]);
        if(result==-1||result==-2){
            JOptionPane.showMessageDialog(this, "Error al modificar los datos. Verifica que no haya otro usuario con el mismo email o nombre de usuario. \n Si el problema persiste contacta al administrador","Error!",JOptionPane.ERROR_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "El usuario "+ txtNomUsuario.getText()+" se ha creado con exito", "Mensaje de exito",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bModificarActionPerformed

    private void comboConvoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboConvoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboConvoActionPerformed

    private void comboPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPerfilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboPerfilActionPerformed

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bModificar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox comboConvo;
    private javax.swing.JComboBox comboPerfil;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblApellidos;
    private javax.swing.JLabel lblContrasena;
    private javax.swing.JLabel lblConvocatoria;
    private javax.swing.JLabel lblMail;
    private javax.swing.JLabel lblNomUsuario;
    private javax.swing.JLabel lblNombres1;
    private javax.swing.JLabel lblPerfil;
    private javax.swing.JTextField tfSearchCedula;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtMail;
    private javax.swing.JTextField txtNomUsuario;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables
}