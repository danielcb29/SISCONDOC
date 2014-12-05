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
    /**
     * Metodo que permite consultar los 5 mejores seleccionados
     * @return Resultado
     */
    public String[][] cincoMejores(){
        String[][] consulta = daoRepor.cincoMejores(codigoConvo);
        if(consulta[0][0] == null){
            return null;
        }
        return consulta;
    }
    public String[][] totalPorJornada(){
        String[][] consulta = daoRepor.totalPorJornada(codigoConvo);
        if(consulta[0][0] == null){
            return null;
        }
        return consulta;
    }
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoRepor.closeConectionDB();
    }
}
