/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import proceso.Convocatoria;

/**
 *
 * @author daniel
 */
public class DAOConvocatoria {
    private BaseDatos db;
    //private Connection conn ;
    public DAOConvocatoria(){
        db = new BaseDatos();
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear una convocatoria en la base de datos
     * @param conv la convocatoria a ser almacenada
     * @return -1 en caso de error , -2 si la conv ya existe y el numero de filas en caso contrario
     */
    
    public int crateConv(Convocatoria conv){
        return -1;
    } 
    /**
     * Metodo que permite consultar la informacion de una convocatoria 
     * @param name: nombre de la convocatoria a consultar 
     * @return: la convocatora encontrada , con atributos null si no existe o null en caso de error
     */
    public Convocatoria readConv(String name){
        return null;
    }
    public void updateConv(){
        
    }
    /**
     * Metodo que permite listar las convocatorias activas en la base de datos 
     * @return: Arreglo con las convocatorias existentes en la base de datos, null en caso de error
     */
    public Convocatoria[] listConv(){
        return null;
    }
    /**
     * Metodo que permite cambiar el estado de una convocatoria de activa a no activa 
     * @param name 
     */
    public void deletConv(String name){
        
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
}
