/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOFormacion;
import java.sql.Connection;
import proceso.Formacion;

/**
 *
 * @author daniel
 */
public class ControlFormacion {
    
    DAOFormacion daoForm;
    
    public ControlFormacion(Connection conn){
        daoForm = new DAOFormacion(conn);
    }
    /**
     * Metodo que permite crear multiples formaciones para un aspirante en particular
     * @param form: arreglo de formaciones
     * @param cedula: identificacion del aspirante al cual pertenecen las formaciones
     * @return valor de la ultima formacion registrada exitosamente
     */
    public int createForm(Formacion[] form, String cedula){
        int size = form.length;
        int result = 0;

        for(int i = 0; i< size ; i++){
            result = daoForm.crateForm(form[i],cedula);
            
        }
        
        return result;
    }
    /**
     * Metodo que permite listar las formaciones de un aspirante en particular
     * @param cedula: identificacion del aspirante al cual se listaran sus formaciones
     * @return : arreglo de formaciones 
     */
    public Formacion[] listForm(String cedula){
        Formacion[] list = daoForm.listForm(cedula);
        return list;
    }
    /**
     * Metodo que permite leer una formacion en particular de un aspirante dado por su cedula y el nivel de la formacion
     * @param cedula: identificacion del aspirante
     * @param level: nivel de la formacion 
     * @return formacion
     */
    public Formacion readForm(String cedula, String level){
        Formacion form = daoForm.readForm(level, cedula);
        return form;
    }
    /**
     * Metodo que permite eliminar una formacion (poner en inactivo) 
     * @param cedula: cedula del aspirante al cual pertenece la formacion
     * @param level: nivel de la formacion a eliminar 
     * @return numero de confirmacion
     */
    public int deleteForm(String cedula , String level){
        int result = daoForm.deletForm(cedula, level);
        return result;
    }
    
    public int updateConv(String cedula,String level ,Formacion form){
        int result = daoForm.updateForm(cedula, level, form);
        return result;
    }
  
}
