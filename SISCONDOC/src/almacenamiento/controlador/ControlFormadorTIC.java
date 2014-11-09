/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOFormadorTIC;
import java.sql.Connection;
import proceso.FormadorTIC;

/**
 *
 * @author daniel
 */
public class ControlFormadorTIC {
    private DAOFormadorTIC daoForm; 
    
    public ControlFormadorTIC(Connection conn){
        daoForm = new DAOFormadorTIC(conn);
    }
    /**
     * Metodo que permite crear una serie de registros formadorTic a partir de un arreglo y la cedula del aspirante al cual pertenece
     * @param form : arreglo que contiene los distintos objetos FormadorTIC
     * @param cedula : identificacion del aspirante al cual se le asignaran esos registros
     * @return numero de confirmacion , 1 exitoso , -1 problema general , -2 problema de sql
     */
    public int createFormador(FormadorTIC[] form, String cedula){
        int size = form.length;
        int result = 0;

        for(int i = 0; i< size ; i++){
            result = daoForm.crateFormador(form[i],cedula);
            
        }
        
        return result;
    }
    /**
     * Metodo que permite listar todos los registros que estan en la tabla formadorTic de un aspirante en particular
     * @param cedula : cedula del aspirante a consultar
     * @return arreglo con los registros del aspirante
     */
    public FormadorTIC[] listFormador(String cedula){
        FormadorTIC[] list = daoForm.listFormador(cedula);
        return list;
    }
    /**
     * Metodo que permite leer un registro de la tabla formadorTic de un aspirante en un grupo de formados en especial
     * @param cedula: identificacion del aspirante a consultar
     * @param people: peronas que fueron formadas , son 3 categorias 
     * @return 
     */
    public FormadorTIC readFormador(String cedula, String people){
        FormadorTIC form = daoForm.readFormador(people, cedula);
        return form;
    }
    /**
     * Metodo que permite eliminar (cambiar estado a inactivo) un registro en la tabla formadorTic
     * @param cedula: cedula del aspirante al cual se elimina el registro 
     * @param people: categoria de formados a eliminar
     * @return numero de verificacion , 1 ok ,-1 error general, -2 error sql
     */
    public int deleteFormador(String cedula , String people){
        int result = daoForm.deletFormador(cedula, people);
        return result;
    }
    /**
     * Metodo que permite actualizar un registro de la tabla formadorTic en la base de datos de acuerdo al aspirante y a los formados
     * @param cedula: identificacion del aspirante a actualizar el registro
     * @param people : personas formadas , son 3 categorias , debe ser una de las 3
     * @param form : objeto FormadorTIC con la informacion actualizada
     * @return 
     */
    public int updateFormador(String cedula,String people ,FormadorTIC form){
        int result = daoForm.updateFormador(cedula, people, form);
        return result;
   }
}
