/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOCEspecificos;
import proceso.CEspecifico;
import java.sql.Connection;
/**
 *
 * @author family
 */
public class CEspecificoController {
    DAOCEspecificos daoCe;
    
    public CEspecificoController(Connection conn){
        daoCe = new DAOCEspecificos(conn);
    }
    /**
        * crear o agregar un conocimiento específico a la tabla.
        * @param ce el CEspecifico a agregar del aspirante.
        * @param cedula la cedula del aspirante
        * @return 1 en caso que se cumpla todo en su flujo normal, -3 en caso de que el perfil del usuario este malo, -2 en caso de un error de integridad referencial o de entidad, y -1 en cualquier otro caso.
    */
    public int createCEspecifico(CEspecifico[] ce, String cedula){
        
        int result = 0;

       
        result = daoCe.createCEspecifico(ce[i],cedula);
            
       
        
        return result;
    }
    /**
     * listar todas las tuplas de los usuarios existentes.
     * @param cedula cedula del aspirante al que se le listaran los CEspecificos
     * @return los objetos tipo CEspecifico enlistados en un arreglo.
     */ 
    public CEspecifico[] listForm(String cedula){
        CEspecifico[] list = daoCe.listCEspecifico(cedula);
        return list;
    }
   /**
    * consultar el usuario que tiene como username el parametro.
    * @param cedula cedula del aspirante a consultar su CEspecifico.
    * @return null si hay algun error de cualquier tipo. Objeto tipo CEspecifico si el objeto del usuario que se consulto.
    */
    public CEspecifico readCEspecifico(String cedula){
        CEspecifico form = daoCe.readCEspecifico(cedula);
        return form;
    }
    /**
     * Metodo que permite eliminar una el CEspecifico de un aspirante
     * @param cedula: cedula del aspirante al cual pertenece el CEspecifico
     * @return numero de confirmacion
     */
    public int deleteForm(String cedula){
        int result = daoCe.deleteCEspecifico(cedula);
        return result;
    }
    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param ce objeto de CEspecifico con los atributos a modificar en la base de datos.
     * @param cedula la cedula del aspirante al que se le quiere actualizar el CEspecifico.
     * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
     */
    public int updateForm(String cedula, CEspecifico ce){
        int result = daoCe.updateCEspecifico(cedula, ce);
        return result;
    }
}
