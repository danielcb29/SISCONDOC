/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.*;
import java.sql.Connection;
import proceso.Aspirant;


/**
 *
 * @author fernando
 */
public class AspirantController 
{
    /**
     * Atributos de la clase 
     * daoAspirant: DAO del aspirante  para realizar las consultas
     */
    private DAOAspirant daoAspirant;
    /**
     * Constructor de la clase
     */
    public AspirantController(Connection conn){
        daoAspirant = new DAOAspirant(conn);
    }
    /**
     * Metodo que permite registrar los datos personales de un aspirante
     * @param aspirant: aspirante a crear
     * @return 
     */
    public int createAspirant(Aspirant aspirant){
        int result = daoAspirant.crateAspirant(aspirant);
        return result;
    }
    /**
     * Metodo que permite obtener la lista de aspirantes
     * @return: la lista con los aspirantes 
     */
    public Aspirant[] listConv(){
        Aspirant[] list = daoAspirant.listAspirants();
        return list;
    }
    /**
     * 
     * @param document: cedula del aspirante a buscar.
     * @return aspirante en la base de datos , null si hay error o name null si no existe 
     */
    public Aspirant readAspirant(String document){
        Aspirant aspirant = daoAspirant.readAspirant(document);
        return aspirant;
    }
    /**
     * Metodo que permite eliminar una aspirante de una convocatoria
     * @param aspirante : identificacion del aspirante a eliminar.
     */
    public void deleteAspirant(String document){
        daoAspirant.deletConv(document);
    }
    /**
     * Metodo que permite actualizar los datos de una aspirantocatoria 
     * @param exConv: nombre del aspirante a actualizar. 
     * @param aspirant: nuevos datos del aspirante
     */
    public void updateAspirant(Aspirant aspirant){
        daoAspirant.updateAspirant(aspirant);
    }
}

    
