/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import java.sql.Connection;
import proceso.FormacionTic;
import almacenamiento.accesodatos.DAOFormacionTic;

/**
 *
 * @author fernando
 */
public class ControlFormacionTic 
{
    /**
     * Atributos de la clase 
     * daoAspirante: DAO del aspirante  para realizar las consultas
     */
    private DAOFormacionTic daoTic;
    /**
     * Constructor de la clase
     */
    public ControlFormacionTic(Connection conn){
        daoTic = new DAOFormacionTic(conn);
        
    }
    
    public int insertarFormacion ( FormacionTic [] formaciones, String cedula)
    {
       int resultado = daoTic.insertarFormaciones(formaciones,cedula);
       return resultado;
    }
    
    public FormacionTic [] consultarFomaciones(String cedula){
       FormacionTic [] formaciones = daoTic.consultarFormaciones(cedula);
       return formaciones;
    }
    
        /**
     * Metodo que permite actualizar una formacion en la base de datos 
     * @param cedula: cedula del aspirante al cual se actulizara el registro
     * @param titulo  : titulo que va a ser actualizado
     * @param form : objeto Formacion con toda la informacion actualizada
     * @return 
     */
    public int updateForm(String cedula,String titulo ,FormacionTic formsTic){
        int result = daoTic.updateForm(cedula, titulo, formsTic);
        return result;
    }

      
    
        /**
     * Metodo que permite eliminar una formacion en tic (poner en inactivo) 
     * @param cedula: cedula del aspirante al cual pertenece la formacion
     * @param titulo: titulo a eliminar. 
     * @return numero de confirmacion
     */
    public int eliminarFormacion(String cedula , String titulo){
        int result = daoTic.eliminarForm(cedula, titulo);
        return result;
    }

  
    

    
    
    
}
