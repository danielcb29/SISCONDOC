/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import java.util.Date;

/**
 *
 * @author daniel
 */
public class Convocatoria {
    private int code;
    private String name;
    private String description;
    private boolean state;
    private Date dateInitial;
    private Date dateEnd;
    public Convocatoria(String paramName , String paramDescrip, Date paramDateIn, Date paramDateEnd){
        name = paramName;
        description = paramDescrip; 
        state = true;
        dateInitial = paramDateIn;
        dateEnd = paramDateEnd;
    }
    public Convocatoria(){
        
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public boolean getState(){
        return state;
    }
    public Date getDateIn(){
        return dateInitial;
    }
    public Date getDateEnd(){
        return dateEnd;
    }
    public void setName(String newName){
        name = newName;
    }
    public void setDescription(String newDescrip){
        description = newDescrip;
    }
    public void setState(boolean newState){
        state = newState;
    }
    public void setDateIn(Date newDateIn){
        dateInitial = newDateIn;
    }
    public void setDateEnd(Date newDateEnd){
        dateEnd = newDateEnd;
    }
    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(int code) {
        this.code = code;
    }
}
