/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import almacenamiento.accesodatos.*;
import java.sql.Connection;
import proceso.Convocatoria;
/**
 *
 * @author daniel
 */
public class ConvocatoriaController {
    /**
     * Atributos de la clase 
     * daoConv: DAO de la convocatoria para realizar las consultas
     */
    private DAOConvocatoria daoConv;
    /**
     * Constructor de la clase
     */
    public ConvocatoriaController(Connection conn){
        daoConv = new DAOConvocatoria(conn);
    }
    /**
     * Metodo que permite crear una convocatoria
     * @param conv: convocatoria a crear
     * @return 
     */
    public int createConv(Convocatoria conv){
        int result = daoConv.crateConv(conv);
        return result;
    }
    /**
     * Metodo que permite obtener la lista de convocatorias 
     * @return: la lista con las convocatorias 
     */
    public Convocatoria[] listConv(){
        Convocatoria[] list = daoConv.listConv();
        return list;
    }
    /**
     * 
     * @param name: nombre de la convocatoria a buscar
     * @return Convocatoria en la base de datos , null si hay error o name null si no existe 
     */
    public Convocatoria readConv(String name){
        Convocatoria conv = daoConv.readConv(name);
        return conv;
    }
    /**
     * Metodo que permite eliminar una convocatoria
     * @param conv : nombre de la convocatoria a eliminar
     */
    public void deleteConv(Convocatoria conv){
        String name = conv.getName();
        daoConv.deletConv(name);
    }
    /**
     * Metodo que permite actualizar los datos de una convocatoria 
     * @param exConv: nombre de la convocatoria a actualizar 
     * @param conv: nuevos datos de convocatoria
     */
    public void updateConv(String exConv, Convocatoria conv){
        daoConv.updateConv(exConv, conv);
    }
}