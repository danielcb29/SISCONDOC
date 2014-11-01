/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import javax.swing.JOptionPane;
import almacenamiento.controlador.*;
import java.io.UnsupportedEncodingException;
import proceso.*;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
                }else{
                    //Enviar correo electronico
                    System.out.println("Llegamos al envio de correo");
                    /*String host = "correounivalle.edu.co";
                    Properties props =  new Properties();
                    //props.setProperty("mail.smtp.correounivalle.edu.co", "correounivalle.edu.co");
                    props.setProperty("mail.smtp.gmail.com", "gmail.com");
                    Session session = Session.getDefaultInstance(props);

                    String msgBody = "Datos de recuperacion de cuenta SISCONDOC \nNombre Completo: "+user.getName()+" "+user.getLastName()+" \nNombre de Usuario: "+user.getUserName()+" \nContraseña: "+user.getPassword()+" \nPerfil: "+user.getProfile()  ;

                    try {
                        //System.out.println("Antes del msg");
                        Message msg = new MimeMessage(session);
                        
                        msg.setFrom(new InternetAddress("daniel.correa@correounivalle.edu.co", "Correounivalle.edu.co Daniel Correa"));
                        
                        msg.addRecipient(Message.RecipientType.TO,
                                        new InternetAddress(user.getMail(), user.getName()));
                        msg.setSubject("Datos de recuperacion cuenta SISCONDOC");
                        msg.setText(msgBody);
                        
                        Transport.send(msg);
                        System.out.println("despues del msg");

                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (AddressException e) {
                        // ...
                        System.out.println("Error con su correo electronico , contacte al admin");
                    } catch (MessagingException e) {
                        // ...
                        System.out.println("Error enviando el mensaje , fallas de conexion a internet? x(");
                        e.printStackTrace();
                    }*/  
                }
/*import javax.mail.Message;
        //System.out.println(this.getSize().getHeight() + " " +this.getSize().getWidth());
                }else{
                    //Enviar correo electronico
                    System.out.println("Llegamos al envio de correo");
                    /*String host = "correounivalle.edu.co";
                    Properties props =  new Properties();
                    //props.setProperty("mail.smtp.correounivalle.edu.co", "correounivalle.edu.co");
                    props.setProperty("mail.smtp.gmail.com", "gmail.com");
                    Session session = Session.getDefaultInstance(props);

                    String msgBody = "Datos de recuperacion de cuenta SISCONDOC \nNombre Completo: "+user.getName()+" "+user.getLastName()+" \nNombre de Usuario: "+user.getUserName()+" \nContraseña: "+user.getPassword()+" \nPerfil: "+user.getProfile()  ;


                    try {
                        //System.out.println("Antes del msg");
                        Message msg = new MimeMessage(session);
                        
                        msg.setFrom(new InternetAddress("daniel.correa@correounivalle.edu.co", "Correounivalle.edu.co Daniel Correa"));
                        
                        msg.addRecipient(Message.RecipientType.TO,
                                        new InternetAddress(user.getMail(), user.getName()));
                        msg.setSubject("Datos de recuperacion cuenta SISCONDOC");
                        msg.setText(msgBody);
                        
                        Transport.send(msg);
                        System.out.println("despues del msg");

                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(VistaLogin.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (AddressException e) {
                        // ...
                        System.out.println("Error con su correo electronico , contacte al admin");
                    } catch (MessagingException e) {
                        // ...
                        System.out.println("Error enviando el mensaje , fallas de conexion a internet? x(");
                        e.printStackTrace();
                    }*/  
                }
            }
        }
        
        
        
    }//GEN-LAST:event_lbForgetMouseClicked

    private void btSignInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSignInActionPerformed
        // TODO add your handling code here:
        //Aqui va lo de ingresar
        System.out.println("init");
        
        
        userName = tfUserName.getText();
        password = pfPassword.getText();
        Usuario user = controlerU.consultUser(userName);
        
        if (user==null){ 
            JOptionPane.showMessageDialog(this, "Lo sentimos ha ocurrido un error en la conexion con la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            System.out.println("local:"+password);
            if(user.getPassword()==null || !(user.getPassword() .equals(password))){
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña invalida", "Error!", JOptionPane.ERROR_MESSAGE);
            }else{
                String profile = user.getProfile();
                System.out.println("profile " + profile );
                if (profile.equals("Digitador")){
                    System.out.println("No se ha implementado aun :)");
                    System.exit(0);
                }else{
                    if(profile.equals("Coordinador")){
                        System.out.println("No se ha implementado aun :)");
                        System.exit(0);
                    }else{
                        if(profile.equals("Adiministrador")){
                            System.out.println("paso");
                            //Clase nelsini
                            System.out.println("Iniciamo sesion : "+ user.getName());
                            this.dispose();
                            vAdmin = new VistaAdmin(userName,controlerU);
                            vAdmin.setVisible(true);
                            //vAdmin.show();
                            
                        }
                    }
=======
        
        userName = tfUserName.getText();
        password = pfPassword.getText();
        Usuario user = controlerU.consultUser(userName);
        
        if (user==null){ 
            JOptionPane.showMessageDialog(this, "Lo sentimos ha ocurrido un error en la conexion con la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            //System.out.println("local:"+password);
            if(user.getPassword()==null || !(user.getPassword() .equals(password))){
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña invalida", "Error!", JOptionPane.ERROR_MESSAGE);
            }else{
                boolean state = user.getState();
                System.out.println("estado: "+state);
                if(state){
                    String profile = user.getProfile();
                    if (profile.equals("Digitador")){
                        System.out.println("No se ha implementado aun :)");
                        System.exit(0);
                    }else{
                        if(profile.equals("Coordinador")){
                            System.out.println("No se ha implementado aun :)");
                            System.exit(0);
                        }else{
                            if(profile.equals("Administrador")){
                                //Clase nelsini
                                System.out.println("Iniciamo sesion : "+ user.getName());
                                this.dispose();
                                vAdmin = new VistaAdmin(userName,controlerU);
                                vAdmin.setVisible(true);
                                //vAdmin.show();
                            }

                            
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Lo sentimos, el usuario "+user.getUserName()+" fue eliminado por el administrador","Contacta al admin",JOptionPane.ERROR_MESSAGE);
        
        userName = tfUserName.getText();
        password = pfPassword.getText();
        Usuario user = controlerU.consultUser(userName);
        
        if (user==null){ 
            JOptionPane.showMessageDialog(this, "Lo sentimos ha ocurrido un error en la conexion con la base de datos", "Error!", JOptionPane.ERROR_MESSAGE);
        }else {
            //System.out.println("local:"+password);
            if(user.getPassword()==null || !(user.getPassword() .equals(password))){
                JOptionPane.showMessageDialog(this, "Nombre de usuario o contraseña invalida", "Error!", JOptionPane.ERROR_MESSAGE);
            }else{
                boolean state = user.getState();
                System.out.println("estado: "+state);
                if(state){
                    String profile = user.getProfile();
                    if (profile.equals("Digitador")){
                        System.out.println("No se ha implementado aun :)");
                        System.exit(0);
                    }else{
                        if(profile.equals("Coordinador")){
                            System.out.println("No se ha implementado aun :)");
                            System.exit(0);
                        }else{
                            if(profile.equals("Administrador")){
                                //Clase nelsini
                                System.out.println("Iniciamo sesion : "+ user.getName());
                                this.dispose();
                                vAdmin = new VistaAdmin(userName,controlerU);
                                vAdmin.setVisible(true);
                                //vAdmin.show();
                            }

                            
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(this, "Lo sentimos, el usuario "+user.getUserName()+" fue eliminado por el administrador","Contacta al admin",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btSignInActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new VistaLogin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Logo;
    private javax.swing.JButton btSignIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbForget;
    private javax.swing.JPasswordField pfPassword;
    private javax.swing.JTextField tfUserName;
    // End of variables declaration//GEN-END:variables
}