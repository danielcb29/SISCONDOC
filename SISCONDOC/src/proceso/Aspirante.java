/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

import java.util.Date;

/**
 *
 * @author fernando
 */




public class Aspirante {
    
    private String document;
    private String name;
    private String lastname;
    private String city;
    private int puntaje;
    private Convocatoria call;
    private String genero;
    private String jornada;
    private String fecha_nac;
    
    
    public Aspirante () {} 
    public Aspirante (String aspiranteDocument , String aspiranteName , String aspiranteLastname, String aspiranteCity ,int puntajeAspirante, Convocatoria call,String gen, String jor, String nacimiento)
    {
        document = aspiranteDocument;
        name = aspiranteName;
        lastname = aspiranteLastname;
        city = aspiranteCity;
        puntaje = puntajeAspirante;
        this.call =call;
        genero = gen;
        jornada = jor;
        fecha_nac = nacimiento;
   
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
     * @return the puntaje
     */
    public int getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje puntaje set
     */
    public void setPuntaje(int puntaje) {
        this.puntaje= puntaje;
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

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the jornada
     */
    public String getJornada() {
        return jornada;
    }

    /**
     * @param jornada the jornada to set
     */
    public void setJornada(String jornada) {
        this.jornada = jornada;
    }

    /**
     * @return the fecha_nac
     */
    public String getFecha_nac() {
        return fecha_nac;
    }

    /**
     * @param fecha_nac the fecha_nac to set
     */
    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }
    
        
}
