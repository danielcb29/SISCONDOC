/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import almacenamiento.accesodatos.*;
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
    public ConvocatoriaController(){
        daoConv = new DAOConvocatoria();
    }
    /**
     * Metodo que permite obtener la lista de convocatorias 
     * @return: la lista con las convocatorias 
     */
    public Convocatoria[] listConv(){
        Convocatoria[] list = daoConv.listConv();
        return list;
    }
}
