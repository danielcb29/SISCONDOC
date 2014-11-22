/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOReporte;
import java.sql.Connection;

/**
 *
 * @author daniel
 */
public class ControlReporte {
    private DAOReporte daoRepor;
    private int codigoConvo;
    
    public ControlReporte(Connection conn,int codigoConvocatoria){
        daoRepor = new DAOReporte(conn);
        codigoConvo = codigoConvocatoria;
    }
    
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoRepor.closeConectionDB();
    }
}
