/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;

/**
 *
 * @author daniel
 */
public class DAOReporte {
    private BaseDatos db;
    private Connection conn;
    public DAOReporte(Connection connect){
        conn = connect;
        db = new BaseDatos();
    }
    
    
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
}
