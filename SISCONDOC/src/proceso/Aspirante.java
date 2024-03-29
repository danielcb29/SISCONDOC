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




    public class Aspirante {
    
    private String document;
    private String name;
    private String lastname;
    private String city;
    private double puntaje;
    private Convocatoria call;
    private String genero;
    private String jornada;
    private String fecha_nac;
    private Formacion [] formaciones;
    private FormacionTic [] formacionesTic;
    private FormadorTIC [] formadores;
    private CEspecifico conocimientos;
    private Idioma [] idiomas; 
    
    
    public Aspirante () {} 
    public Aspirante (String aspiranteDocument , String aspiranteName , String aspiranteLastname, String aspiranteCity ,double puntajeAspirante, Convocatoria call,String gen, String jor, String nacimiento, Formacion [] formacionesAspirantes, FormacionTic [] formacionesTicAspirantes,FormadorTIC [] formadoresTic,CEspecifico conocimientosAspirante, Idioma []  idiomasAspirante)
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
        formaciones= formacionesAspirantes;
        formacionesTic= formacionesTicAspirantes;
        formadores = formadoresTic;
        conocimientos = conocimientosAspirante;
        idiomas = idiomasAspirante;
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
    public double getPuntaje() {
        return puntaje;
    }

    /**
     * @param puntaje puntaje set
     */
    public void setPuntaje(double puntaje) {
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

    /**
     * @return the formaciones
     */
    public Formacion[] getFormaciones() {
        return formaciones;
    }

    /**
     * @param formaciones the formaciones to set
     */
    public void setFormaciones(Formacion[] formaciones) {
        this.formaciones = formaciones;
    }

    /**
     * @return the formacionesTic
     */
    public FormacionTic[] getFormacionesTic() {
        return formacionesTic;
    }

    /**
     * @param formacionesTic the formacionesTic to set
     */
    public void setFormacionesTic(FormacionTic[] formacionesTic) {
        this.formacionesTic = formacionesTic;
    }

    /**
     * @return the formadores
     */
    public FormadorTIC[] getFormadores() {
        return formadores;
    }

    /**
     * @param formadores the formadores to set
     */
    public void setFormadores(FormadorTIC[] formadores) {
        this.formadores = formadores;
    }

    /**
     * @return the conocimientos
     */
    public CEspecifico getConocimientos() {
        return conocimientos;
    }

    /**
     * @param conocimientos the conocimientos to set
     */
    public void setConocimientos(CEspecifico conocimientos) {
        this.conocimientos = conocimientos;
    }

    /**
     * @return the idiomas
     */
    public Idioma[] getIdiomas() {
        return idiomas;
    }

    /**
     * @param idiomas the idiomas to set
     */
    public void setIdiomas(Idioma[] idiomas) {
        this.idiomas = idiomas;
    }
}
