/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOIdioma;
import java.sql.Connection;
import proceso.Idioma;

/**
 *
 * @author alvaro
 */
public class ControlIdioma {
    
        
    DAOIdioma daoForm;
    
    public ControlIdioma(Connection conn){
        daoForm = new DAOIdioma(conn);
    }
    /**
     * Metodo que permite crear multiples idiomas para un aspirante en particular
     * @param form: arreglo de idiomas
     * @param cedula: identificacion del aspirante al cual pertenecen los idiomas
     * @return valor del ultimo idioma registrado exitosamente
     */
    public int createForm(Idioma[] form, String cedula){
        
 
        int size = form.length;
        int result = 0;
        
        System.out.println("idioma");
        for(int i = 0; i< size ; i++){
            result = daoForm.createIdioma(form[i],cedula);
            
        }
        
        return result;
    }
    /**
     * Metodo que permite listar las Idiomas de un aspirante en particular
     * @param cedula: identificacion del aspirante al cual se listaran sus formaciones
     * @return : arreglo de formaciones 
     */
    public Idioma[] listForm(String cedula){
        Idioma[] list = daoForm.listIdioma(cedula);
        return list;
    }
    /**
     * Metodo que permite leer un Idioma en particular de un aspirante dado por su cedula y el nombre del lenguaje
     * @param cedula: identificacion del aspirante
     * @param lenguaje: nombre del lenguaje 
     * @return idioma
     */
    public Idioma readForm(String cedula, String lenguaje){
        Idioma form = daoForm.readIdioma(lenguaje, cedula);
        return form;
    }
    /**
     * Metodo que permite eliminar una idioma (poner en inactivo) 
     * @param cedula: cedula del aspirante al cual pertenece el idioma
     * @param lenguaje: nombre del lenguaje a eliminar 
     * @return numero de confirmacion
     */
    public int deleteForm(String cedula , String level){
        int result = daoForm.deleteIdioma(cedula, level);
        return result;
    }
    /**
     * Metodo que permite actualizar una formacion en la base de datos 
     * @param cedula: cedula del aspirante al cual se actulizara el registro
     * @param lenguaje : nombre lenguaje a actualizar
     * @param form : objeto Idioma con toda la informacion actualizada
     * @return 
     */
    public int updateForm(String cedula,String lenguaje, Idioma form){
        int result = daoForm.updateIdioma(cedula, lenguaje, form);
        return result;
    }
    
}