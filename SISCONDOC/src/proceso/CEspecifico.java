/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proceso;
/**
 *
 * @author family
 */
public class CEspecifico {
    /**
     * Cada uno de los atributos describe el nivel que se tiene del atributo nombrado (muy bueno, bueno, regular)
     */
    String ofimaticas;
    String web2;
    String educaDig;
    String multimedia;
    String elearning;
    String proyeTIC;
    String assessCompe;
    String digBook;
    
    boolean status;
    
    public CEspecifico(){}
    
    /**
     * Constructor.
     * @param pOfimaticas
     * @param pWeb2
     * @param pEducaDig
     * @param pMultimedia
     * @param pElearning
     * @param pProyeTIC
     * @param pAssessCompe
     * @param pDigBook
     * @param pStatus 
     */
    
    
    public CEspecifico(String pOfimaticas, String pWeb2, String pEducaDig, String pMultimedia, String pElearning, String pProyeTIC, String pAssessCompe, String pDigBook, boolean pStatus){
        ofimaticas=pOfimaticas;
        web2=pWeb2;
        educaDig=pEducaDig;
        multimedia= pMultimedia;
        elearning = pElearning;
        proyeTIC= pProyeTIC;
        assessCompe=pAssessCompe;
        digBook= pDigBook;
        status=pStatus;
    }
    
    
    /**GETTERS**/
    public String getOfimaticas(){
        return ofimaticas;
    }
    
    public String getWeb2(){
        return web2;
    }
    
    public String getEducaDig(){
        return educaDig;
    }
    
    public String getMultimedia(){
        return multimedia;
    }
    
    public String getElearning(){
        return elearning;
    }
    
    public String getProyeTIC(){
        return proyeTIC;
    }
    
    public String getAssessCompe(){
        return assessCompe;
    }
    
    public String getDigBook(){
        return digBook;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    /**SETTERS**/
    public void setOfimaticas(String pOfimaticas){
        ofimaticas=pOfimaticas;
    }
    
    public void setWeb2(String pWeb2){
        web2=pWeb2;
    }
    
    public void setEducaDig(String pEducaDig){
        educaDig=pEducaDig;
    }
    
    public void setMultimedia(String pMultimedia){
        multimedia=pMultimedia;
    }
    
    public void setElearning(String pElearning){
        elearning=pElearning;
    }
    
    public void setProyeTIC(String pProyeTIC){
        proyeTIC=pProyeTIC;
    }
    
    public void setAssessCompe(String pAssessCompe){
        assessCompe=pAssessCompe;
    }
    
    public void setDigBook(String pDigBook){
        digBook=pDigBook;
    }
                                                                            
    public void setStatus(boolean pStatus){
        status=pStatus;
    }
    
}