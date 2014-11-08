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
public class FormacionTic {
    private String institucion;
    private String titulo;
    private String horas;
    private String  url_soporte;

    
    public FormacionTic () 
    {
    }
    public FormacionTic (String institucionAspirante,String  tituloAspirante, String  horasAspirante, String  url) 
    {
        institucion = institucionAspirante;
        titulo = tituloAspirante;
        horas = horasAspirante;
        url_soporte = url;
    }
    
    
    /**
     * @return the institucion
     */
    public String getInstitucion() {
        return institucion;
    }

    /**
     * @param institucion the institucion to set
     */
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the horas
     */
    public String getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(String horas) {
        this.horas = horas;
    }

    /**
     * @return the url_soporte
     */
    public String getUrl_soporte() {
        return url_soporte;
    }

    /**
     * @param url_soporte the url_soporte to set
     */
    public void setUrl_soporte(String url_soporte) {
        this.url_soporte = url_soporte;
    }
    
}
