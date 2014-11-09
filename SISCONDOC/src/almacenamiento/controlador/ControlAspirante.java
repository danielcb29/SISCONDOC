/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.util.Date;
import proceso.*;


/**
 *
 * @author fernando
 */
public class ControlAspirante 
{
    /**
     * Atributos de la clase 
     * daoAspirante: DAO del aspirante  para realizar las consultas
     */
    private DAOAspirante daoAspirante;
    private ControlFormacionTic controlFormacionTic;
    private ControlFormacion controlFormacion;
    /**
     * Constructor de la clase
     */
    public ControlAspirante(Connection conn){
        
        daoAspirante = new DAOAspirante(conn);
        controlFormacionTic = new ControlFormacionTic(conn);
        controlFormacion = new ControlFormacion(conn);
        
    }
    /**
     * Metodo que permite registrar los datos personales de un aspirante
     * @param aspirante: aspirante a crear
     * @return 
     */
    public int createAspirante(String document, String name, String lastName, String city,int puntaje,Convocatoria convocatoria,String genero,String jornada,String fecha_nac,Formacion [] formaciones, FormacionTic [] formacionesTic ){
        Aspirante aspirante = new Aspirante (document, name, lastName, city, puntaje,convocatoria,genero,jornada,fecha_nac,formaciones, formacionesTic);
        int result = daoAspirante.crateAspirante(aspirante);
        int resultado2 = controlFormacionTic.insertarFormacion(formacionesTic,document);
        int resultado3 = controlFormacion.createForm(formaciones, document);
        return result;
    }
    /**
     * Metodo que permite obtener la lista de aspirantes
     * @return: la lista con los aspirantes 
     */
    public Aspirante[] listAspirantes(String callName){
        Aspirante[] list = daoAspirante.listAspirantes(callName);
        return list;
    }
    /**
     * 
     * @param document: cedula del aspirante a buscar.
     * @return aspirante en la base de datos , null si hay error o name null si no existe 
     */
    public Aspirante readAspirante(String document){
        Aspirante aspirante = daoAspirante.readAspirante(document);
        return aspirante;
    }
    
    
    /**
     * Metodo que permite actualizar los datos de una aspirante 
     * @param exConv: nombre del aspirante a actualizar. 
     * @param aspirante: nuevos datos del aspirante
     */
    public void updateAspirante(String documento, Aspirante aspirante){
        daoAspirante.updateAspirante(documento, aspirante);
    }
}

    