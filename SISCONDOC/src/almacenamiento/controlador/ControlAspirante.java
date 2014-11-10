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
    private ControlFormadorTIC controlFormador;
    private CEspecificoController controlConocimientos;
    /**
     * Constructor de la clase
     */
    public ControlAspirante(Connection conn){
        
        daoAspirante = new DAOAspirante(conn);
        controlFormacionTic = new ControlFormacionTic(conn);
        controlFormacion = new ControlFormacion(conn);
        controlFormador = new ControlFormadorTIC (conn);
        
    }
    /**
     * Metodo que permite registrar los datos personales de un aspirante
     * @param aspirante: aspirante a crear
     * @return 
     */
    public int createAspirante(String document, String name, String lastName, String city,int puntaje,Convocatoria convocatoria,String genero,String jornada,String fecha_nac,Formacion [] formaciones, FormacionTic [] formacionesTic,FormadorTIC [] formadores,CEspecifico conocimientos ){
        Aspirante aspirante = new Aspirante (document, name, lastName, city, puntaje,convocatoria,genero,jornada,fecha_nac,formaciones, formacionesTic,formadores,conocimientos);
        int result = daoAspirante.crateAspirante(aspirante);
        int resultado2 = controlFormacionTic.insertarFormacion(formacionesTic,document);
        int resultado3 = controlFormacion.createForm(formaciones, document);
        int resultado4 = controlFormador.createFormador(formadores, document);
        int resultado5 = controlConocimientos.createCEspecifico(conocimientos, document);
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
        Formacion [] formaciones = controlFormacion.listForm(document);
        FormacionTic [] formacionesTic = controlFormacionTic.consultarFomaciones(document);
        FormadorTIC [] formados = controlFormador.listFormador(document);
        CEspecifico conocimientos = controlConocimientos.readCEspecifico(document);
        System.out.println("tamano" +aspirante.getLastname());
        aspirante.setFormaciones(formaciones);
        aspirante.setFormacionesTic(formacionesTic);
        aspirante.setFormadores(formados);
        aspirante.setConocimientos(conocimientos);
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

    
