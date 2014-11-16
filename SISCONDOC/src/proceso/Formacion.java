/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author daniel
 */
public class Formacion {
    private String university;
    private String title;
    /**
     * Las opciones de niveles son :
     * "Licenciado"
     * "Especializacion"
     * "EspecializacionTIC"
     * "Maestria"
     * "MaestriaTIC"
     * "Doctorado"
     * "DoctoradoTIC"
     */
    private String level;
    private String pathFile;
    private boolean state;
    
    public Formacion(){
        
    }
    public Formacion(String paramUni , String paramTitle, String paramLev, String paramPath){
        university = paramUni;
        title = paramTitle;
        level = paramLev;
        pathFile = paramPath;
        state=true;
    }
    /**
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the level
     */
    public String getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * @return the pathFile
     */
    public String getPathFile() {
        return pathFile;
    }

    /**
     * @param pathFile the pathFile to set
     */
    public void setPathFile(String pathFile) {
        this.pathFile = pathFile;
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
