/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;
import almacenamiento.controlador.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import proceso.Convocatoria;
/**
 *
 * @author daniel
 */
public class VistaConvocatoria extends javax.swing.JFrame {

    /**
     * Creates new form VistaCrearConvocatoria
     */
    private ConvocatoriaController controller;
    private int type;
    
    public VistaConvocatoria(ConvocatoriaController controllerParam, int type) {
        initComponents();
        controller = controllerParam;
        
        this.type = type;
    
        if (type == 1){
            //Crean conv 
            lbSearch.setVisible(false);
            tfSearch.setVisible(false);
            btSearch.setVisible(false);
            //lbAdd.setText("Recuerde que cada convocatoria debe tener un nombre diferente");
        }else{
            if(type == 2){
                //Editar conv
                //lbAdd.setVisible(false);
                lbTitle.setText("Editar Convocatoria");
                lbInfo.setText("Busque la convocatoria que desea editar, cambie los parametros necesarios y guarde");
                btAction.setText("Guardar");
                this.setTitle("Panel Administrador: Editar Convoatoria");
            }else{
                //ELiminar conv
                //lbAdd.setVisible(false);
                lbTitle.setText("Eliminar Convocatoria");
                lbInfo.setText("Busque la convocatoria que desea eliminar, revise los parametros necesarios y borre");
                btAction.setText("Borrar");
                tfNombre.setEditable(false);
                taDescription.setEditable(false);
                tfDateIn.setEditable(false);
                tfTimeIn.setEditable(false);
                tfDateEnd.setEditable(false);
                tfTimeEnd.setEditable(false);
                this.setTitle("Panel Administrador: Eliminar Convocatoria");
            }
        }
        //JDatePanelImpl datePanel = new JDatePanelImpl(model);
        
        //JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
 
        //this.add(datePicker);
    }
    public VistaConvocatoria(){
        initComponents();
        type=1;
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
        jLabel2 = new javax.swing.JLabel();
        lbInfo = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        tfNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taDescription = new javax.swing.JTextArea();
        jSplitPane1 = new javax.swing.JSplitPane();
        btAction = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        tfDateIn = new javax.swing.JTextField();
        tfTimeIn = new javax.swing.JTextField();
        tfDateEnd = new javax.swing.JTextField();
        tfTimeEnd = new javax.swing.JTextField();
        tfSearch = new javax.swing.JTextField();
        lbSearch = new javax.swing.JLabel();
        btSearch = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Panel Administrador: Crear Convocatoria");
        setMaximumSize(new java.awt.Dimension(745, 495));
        setMinimumSize(new java.awt.Dimension(745, 495));
        setPreferredSize(new java.awt.Dimension(745, 495));
        setResizable(false);

        lbTitle.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        lbTitle.setText("Crear Convocatoria");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/LogoSinFondo2.png"))); // NOI18N

        lbInfo.setText("Aqui encontrara el formulario para la creacion de convocatorias");

        jLabel4.setText("Nombre:");

        tfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Duracion:");

        jLabel6.setText("Inicio:");

        jLabel7.setText("Fecha:");

        jLabel8.setText("Hora:");

        jLabel9.setText("Finalizacion:");

        jLabel10.setText("Fecha:");

        jLabel11.setText("Hora:");

        jLabel12.setText("Descripcion:");

        taDescription.setColumns(20);
        taDescription.setRows(5);
        jScrollPane1.setViewportView(taDescription);

        btAction.setText("Crear");
        btAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btActionActionPerformed(evt);
            }
        });
        jSplitPane1.setLeftComponent(btAction);

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jSplitPane1.setRightComponent(btCancelar);

        tfDateIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDateInActionPerformed(evt);
            }
        });

        tfSearch.setText("Busqueda por nombre de convocatoria");
        tfSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSearchActionPerformed(evt);
            }
        });

        lbSearch.setText("Buscar:");

        btSearch.setText("Buscar");
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cantarell", 2, 15)); // NOI18N
        jLabel1.setText("aaa/mm/dd");

        jLabel13.setText("ej: 13:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbTitle)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbInfo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(tfSearch)
                                .addGap(18, 18, 18)
                                .addComponent(btSearch)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(155, 155, 155)
                                                        .addComponent(jLabel5))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(12, 12, 12)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel10)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfDateEnd))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel7)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfDateIn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(26, 26, 26)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel8)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel11)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(tfTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(jLabel9))
                                                .addGap(51, 51, 51))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(47, 47, 47)
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel13)
                                                .addGap(67, 67, 67))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(188, 188, 188)
                                        .addComponent(jLabel4))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addComponent(lbSearch)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(32, 32, 32))
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 667, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(lbTitle)
                        .addGap(18, 18, 18)
                        .addComponent(lbInfo))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1)
                            .addComponent(jLabel13))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(tfDateIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(tfTimeIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tfDateEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(tfTimeEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombreActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelarActionPerformed

    private void tfSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSearchActionPerformed
        // TODO add your handling code here:
        
            
    }//GEN-LAST:event_tfSearchActionPerformed
    private boolean validateInformation(String firstDa, String firstTime, String secondDa, String secondTime, String name, String description) {
        //if ((((((firstDa.length() == 0) || (firstTime.length() == 0)) || (secondDa.length() == 0)) || (secondTime.length() == 0)) || (name.length() == 0)) || (description.length()==0)){
        if ((firstDa.length() == 0) || (firstTime.length() == 0) || (secondDa.length() == 0) || (secondTime.length() == 0) || (name.length() == 0) || (description.length()==0)){    
            return false;
        }else{
            return true;
        }
    }
    private void btActionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btActionActionPerformed
        // TODO add your handling code here:
        
        SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
        String firstDa = tfDateIn.getText();
        String firstTime = tfTimeIn.getText();
        String secondDa = tfDateEnd.getText();
        String secondTime = tfTimeEnd.getText();
        String name = tfNombre.getText();
        String description = taDescription.getText();
        //VALIDAMOS CAMPOS VACIOS
        boolean empty = validateInformation(firstDa,firstTime,secondDa,secondTime,name,description);
        if(empty){
            Date d1 = new Date();
            Date d2 = new Date();
            try {
                    d1 = format.parse(firstDa+" "+firstTime);
                    d2 = format.parse(secondDa+" "+secondTime);
            } catch (ParseException ex) {
                    Logger.getLogger(VistaConvocatoria.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(this,"Has ingresado una fecha invalida o con el formato incorrecto, vuelve a intentarlo","Error en las fechas",JOptionPane.ERROR_MESSAGE);
            }
            //VALIDAMOS FECHAS INGRESADAS (SEA LOGICO)
            if(d1.after(d2)){
                    JOptionPane.showMessageDialog(this,"La fecha de iniciacion no puede ser despues que la fecha de finalizacion","Error en las fechas",JOptionPane.ERROR_MESSAGE);
            }else{
                 Convocatoria newConv = new Convocatoria(name,description,d1,d2,0);   
                 if(type==1){
                     //crear convocatoria
                     int result = controller.createConv(newConv);
                     //VALIDAMOS INTEGRIDAD DE ENTIDAD
                     if((result != -1) && (result != -2)){
                         JOptionPane.showMessageDialog(this,"Convocatoria creada exitosamente!","Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
                         this.dispose();
                     }else{
                         JOptionPane.showMessageDialog(this,"Ha ocurrido un error en la base de datos, posiblemente estas intentando crear una convocatoria que ya existe","Ups!",JOptionPane.ERROR_MESSAGE);
                     }
                }else{
                    if(type==2){
                        //editar
                        controller.updateConv(tfSearch.getText(), newConv);
                        JOptionPane.showMessageDialog(this,"Convocatoria actualizada exitosamente!","Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
                        this.dispose();
                    }else{
                        if(type==3){
                            //eliminar
                            // no -> 1 , si -> 0
                            int r = JOptionPane.showConfirmDialog(this,"En realidad desea eliminar esta convocatoria?","Advertencia",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                            if(r == 0){
                                controller.deleteConv(newConv);
                                JOptionPane.showMessageDialog(this,"Convocatoria eliminada exitosamente!","Enhorabuena",JOptionPane.INFORMATION_MESSAGE);
                                this.dispose();
                            }
                            

                        }
                    }
                }
            }
            
        }else{
            JOptionPane.showMessageDialog(this,"No puedes realizar acciones con campos vacios","Termina de llenar los campos",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btActionActionPerformed

    private void tfDateInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDateInActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDateInActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        // TODO add your handling code here:
        String name = tfSearch.getText();
        if(name.length() != 0){
            Convocatoria convEdit = controller.readConv(name);
            System.out.println("primera fase");
            if(convEdit==null){
                JOptionPane.showMessageDialog(this,"Lo sentimos, a ocurrido en error en la base de datos, vuelve a intentarlo","Lo sentimos :(",JOptionPane.ERROR_MESSAGE);
            }else{
                if(convEdit.getName() == null){
                    tfNombre.setText("null");
                    tfDateIn.setText("null");
                    tfTimeIn.setText("null");
                    tfDateEnd.setText("null");
                    tfTimeEnd.setText("null");
                    taDescription.setText("null");
                    JOptionPane.showMessageDialog(this,"La convocatoria con nombre "+tfSearch.getText()+" no existe","Error",JOptionPane.ERROR_MESSAGE);
                }else{
                    System.out.println("segunda fase");
                    SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
                    String datIn[] = format.format(convEdit.getDateIn()).split(" ");
                    String datEnd[] = format.format(convEdit.getDateEnd()).split(" ");
                    tfNombre.setText(convEdit.getName());
                    tfDateIn.setText(datIn[0]);
                    tfTimeIn.setText(datIn[1]);
                    tfDateEnd.setText(datEnd[0]);
                    tfTimeEnd.setText(datEnd[1]);
                    taDescription.setText(convEdit.getDescription());
                }
            }
        }else{
            JOptionPane.showMessageDialog(this,"No puedes buscar una convocatoria con nombre vacio","Error en la busqueda",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btSearchActionPerformed

    /**
     * @param args the command line arguments
     *//*
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         *//*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaConvocatoria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         *//*
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaConvocatoria().setVisible(true);
            }
        });
    }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAction;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JLabel lbSearch;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JTextArea taDescription;
    private javax.swing.JTextField tfDateEnd;
    private javax.swing.JTextField tfDateIn;
    private javax.swing.JTextField tfNombre;
    private javax.swing.JTextField tfSearch;
    private javax.swing.JTextField tfTimeEnd;
    private javax.swing.JTextField tfTimeIn;
    // End of variables declaration//GEN-END:variables

    
}
