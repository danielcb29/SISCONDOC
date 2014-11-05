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
    private String profile;
    private String cedula;
    private boolean state;
    private Convocatoria convocatoria;
    /*
     * One user has one "Convocatoria" 
     */
    //private Convocatoria convocatoria;
    
    public Usuario(String nameUser , String lastNameUser , String userName , String passwordUser,
            String mailUser, String profileUser, String cedulaUser, Convocatoria convocatoria )
    {
        name = nameUser;
        lastName = lastNameUser;
        this.userName = userName;
        password=passwordUser;
        email = mailUser;
        profile = profileUser;
        cedula = cedulaUser;
        state = true;
        this.convocatoria = convocatoria;
    }
    public Usuario(){
        
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
    public String getMail(){
        return email;
    }
    public String getProfile(){
        return profile;
    }
    public String getCedula(){
        return cedula;
    }
    public boolean getState(){
        return state;
    }
    public void setCedula(String newCedula){
        cedula = newCedula;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setLastName(String newLastName){
        lastName = newLastName;
    }
    public void setProfile(String newProfile){
        profile = newProfile;
    }
    public void setUserName(String newUserName){
        userName = newUserName; 
    }
    public void setPassword(String newPassword){
        password=newPassword;
    }
    public void setMail(String newMail){
        email = newMail;
    }
    public void setState(boolean newState){
        state=newState;
    }
     /*
     * One user can be on multiple "Convocatoria" in a time frame
     * 
     * public void setConvocatoria(Convocatoria newConvocatoria){
     *      convocatoria = newConvocatoria;
     * }
     */

    /**
     * @return the convocatoria
     */
    public Convocatoria getConvocatoria() {
        return convocatoria;
    }

    /**
     * @param convocatoria the convocatoria to set
     */
    public void setConvocatoria(Convocatoria convocatoria) {
        this.convocatoria = convocatoria;
    }
    
            
            
    
}
