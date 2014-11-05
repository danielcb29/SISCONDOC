/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author fernando
 */




public class Aspirant {
    
    private String document;
    private String name;
    private String lastname;
    private String city;
    private int puntuaction;
    private Convocatoria call;
    
    
    public Aspirant () {} 
    public Aspirant (String aspirantDocument , String aspirantName , String aspirantLastname, String aspirantCity ,int aspirantPunctuaction, Convocatoria call)
    {
        aspirantDocument = document;
        aspirantName = name;
        aspirantLastname = lastname;
        aspirantCity = city;
        aspirantPunctuaction = puntuaction;
        this.call =call;
                
    }

    /**
     * @return the document
     */
    public String getDocument() {
        return document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(String document) {
        this.document = document;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the puntuaction
     */
    public int getPuntuaction() {
        return puntuaction;
    }

    /**
     * @param puntuaction the puntuaction to set
     */
    public void setPuntuaction(int puntuaction) {
        this.puntuaction = puntuaction;
    }

    /**
     * @return the cod_call
     */
    public Convocatoria getConvocatoria() {
        return this.call;
    }

    /**
     * @param cod_call the cod_call to set
     */
    public void setConvocatoria(Convocatoria call) {
        this.call = call;
    }
    
        
}
