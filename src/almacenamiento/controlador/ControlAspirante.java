/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.*;
import java.sql.Connection;
import java.util.Date;
import javax.swing.JOptionPane;
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
    private ControlIdioma controlIdioma;
    /**
     * Constructor de la clase
     */
    public ControlAspirante(Connection conn){
        
        daoAspirante = new DAOAspirante(conn);
        controlFormacionTic = new ControlFormacionTic(conn);
        controlFormacion = new ControlFormacion(conn);
        controlFormador = new ControlFormadorTIC (conn);
        controlConocimientos = new CEspecificoController( conn);
        controlIdioma = new ControlIdioma (conn);
        
    }
    /**
     * Metodo que permite registrar los datos personales de un aspirante
     * @param aspirante: aspirante a crear
     * @return 
     */
    public int createAspirante(String document, String name, String lastName, String city,int puntaje,Convocatoria convocatoria,String genero,String jornada,String fecha_nac,Formacion [] formaciones, FormacionTic [] formacionesTic,FormadorTIC [] formadores,CEspecifico conocimientos,Idioma [] idiomas ){
        Aspirante aspirante = new Aspirante (document, name, lastName, city, puntaje,convocatoria,genero,jornada,fecha_nac,formaciones, formacionesTic,formadores,conocimientos,idiomas);
	//Prueba DANIEL 
        
        Puntuacion pun = new Puntuacion(aspirante);
        
        Aspirante aspPunted = pun.qualify();
        aspirante = aspPunted;
        JOptionPane.showMessageDialog(null, "La puntuacion fue: "+aspPunted.getPuntaje());
        /*int result = daoAspirante.crateAspirante(aspirante);

        int result = daoAspirante.crateAspirante(aspirante);
        int resultado2 = controlFormacionTic.insertarFormacion(formacionesTic,document);
        int resultado3 = controlFormacion.createForm(formaciones, document);
        int resultado4 = controlFormador.createFormador(formadores, document);
        int resultado5 = controlConocimientos.createCEspecifico(conocimientos, document);
        int resultado6 = controlIdioma.createForm(idiomas, document);*/
        int result=1;
        int resultado6 = controlIdioma.createForm(idiomas, document);
        //int result=1;
        return  result;
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
        Idioma [] idiomas = controlIdioma.listForm(document);
        aspirante.setFormaciones(formaciones);
        aspirante.setFormacionesTic(formacionesTic);
        aspirante.setFormadores(formados);
        aspirante.setConocimientos(conocimientos);
        aspirante.setIdiomas(idiomas);
        return aspirante;
    }
    
    
    /**
     * Metodo que permite actualizar los datos de una aspirante 
     * @param documento: cedula del aspirante. 
     * @param aspirante: nuevos datos del aspirante
     */
    public int updateAspirante(String documento, Aspirante aspirante)
    {
        int result = daoAspirante.updateAspirante(documento, aspirante);
        
        int result2 = controlConocimientos.updateForm(documento, aspirante.getConocimientos());
        /**
        Aspirante a = readAspirante(documento);
        Idioma [] idiom = a.getIdiomas();
        System.err.println("idiomas tamano : " + idiom.length );
        
        
        for (int i =0; i<idiom.length;i++)
        {
            System.err.println("lenguaje : " + idiom[i].getLenguaje() );
            controlIdioma.updateForm(documento,idiom[i].getLenguaje() , aspirante.getIdiomas()[i]);
        }
        
        Formacion [] form = a.getFormaciones();
        for (int i =0; i<form.length;i++)
        {
            controlFormacion.updateForm(documento,form[i].getLevel(), aspirante.getFormaciones()[i]);
        }
        
        FormacionTic [] formTic = a.getFormacionesTic();
        for (int i =0; i<formTic.length;i++)
        {
            controlFormacionTic.updateForm(documento,formTic[i].getTitulo(), aspirante.getFormacionesTic()[i]);
        }
        FormadorTIC [] formaTic = a.getFormadores();
        for (int i =0; i<formaTic.length;i++)
        {
                controlFormador.updateFormador(documento,formaTic[i].getPeople(), aspirante.getFormadores()[i]);
        }**/
        return result;
        
    }
}

    
