/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento;

import java.sql.Connection;



/**
 *
 * @author daniel
 */
public class DAOAdmin {
    private  BaseDatos db;
    public DAOAdmin(){
        db=new BaseDatos();
        Connection conn = db.getConnetion();
    }
    
}
