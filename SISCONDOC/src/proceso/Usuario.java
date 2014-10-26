/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author daniel
 */
public class Usuario {
    /*
     * Elements of class Usuario which es an abstraction of person who will uses the system 
     * Atributos necesarios para que la clase exista 
     */
    private String name;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    
    /*
     * One user has one "Convocatoria" 
     */
    //private Convocatoria convocatoria;
    
    public Usuario(String nameUser , String lastNameUser , String userName , String passwordUser, String mailUser){
        name = nameUser;
        lastName = lastNameUser;
        this.userName = userName;
        password=passwordUser;
        email = mailUser;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    
    public void setUserName(String newUserName){
        userName = newUserName; 
    }
    public void setPassword(String newPassword){
        password=newPassword;
    }
    /*
     * One user can be on multiple "Convocatoria" in a time frame
     * 
     * public void setConvocatoria(Convocatoria newConvocatoria){
     *      convocatoria = newConvocatoria;
     * }
     */
    
            
            
    
}
