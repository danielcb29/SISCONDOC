/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author daniel
 */
public class Convocatoria {
    private String name;
    private String description;
    public Convocatoria(String paramName , String paramDescrip){
        name = paramName;
        description = paramDescrip; 
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setDescription(String newDescrip){
        description = newDescrip;
    }
}