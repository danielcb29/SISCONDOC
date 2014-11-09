/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author daniel
 */
public class FormadorTIC {
    /**
     * Los valores de people son : 
     * "Estudiantes"
     * "Profesores"
     * "Formadores"
     */
    private String people;
    private int time;
    private String path;
    private boolean state;
    
    public FormadorTIC(){
        
    }
    
    public FormadorTIC(String paramPeople,int paramTime, String paramPath){
        people = paramPeople;
        time = paramTime;
        path = paramPath;
        state=true;
                
    }

    /**
     * @return the people
     */
    public String getPeople() {
        return people;
    }

    /**
     * @param people the people to set
     */
    public void setPeople(String people) {
        this.people = people;
    }

    /**
     * @return the time
     */
    public int getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(int time) {
        this.time = time;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the state
     */
    public boolean getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(boolean state) {
        this.state = state;
    }
}
