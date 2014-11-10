/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proceso;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author alvaro
 * Clase que contiene los atributos que maneja un aspirante en idiomas
 */
public class Idioma{

    /**
     * Los atributos de Idioma son el lenguaje(nombre), nivel de lectura, nivel de escritura
     * nivel de habla y la ruta del archivo soporte
     */
    private String lenguaje;
    private String nivellee;
    private String nivelescribe;
    private String nivelhabla;
    private String patharchivo;
    private Boolean state;

    public void setState(Boolean state) {
        this.state = state;
    }

    public Boolean getState() {
        return state;
    }

    public Idioma() {
    }


    public Idioma(String lenguaje, String nivellee, String nivelescribe, String nivelhabla, String patharchivo, boolean state) {
        this.lenguaje = lenguaje;
        this.nivellee = nivellee;
        this.nivelescribe = nivelescribe;
        this.nivelhabla = nivelhabla;
        this.patharchivo = patharchivo;
        this.state = state;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getLenguaje() {
        return lenguaje;
    }
    public String getNivellee() {
        return nivellee;
    }

    public void setNivellee(String nivellee) {
        this.nivellee = nivellee;
    }

    public String getNivelescribe() {
        return nivelescribe;
    }

    public void setNivelescribe(String nivelescribe) {
        this.nivelescribe = nivelescribe;
    }

    public String getNivelhabla() {
        return nivelhabla;
    }

    public void setNivelhabla(String nivelhabla) {
        this.nivelhabla = nivelhabla;
    }

    public String getPatharchivo() {
        return patharchivo;
    }

    public void setPatharchivo(String patharchivo) {
        this.patharchivo = patharchivo;
    }    
    
}
