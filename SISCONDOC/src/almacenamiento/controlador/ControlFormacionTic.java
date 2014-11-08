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
    
    
  
    

    
    
    
}
