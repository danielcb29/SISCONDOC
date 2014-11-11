/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import proceso.Idioma;


/**
 *
 * @author alvaro
 */
public class DAOIdioma {
    private BaseDatos db;
    private Connection conn;
    
    public DAOIdioma(Connection paramConn){
        db = new BaseDatos();
        conn= paramConn;
    }
    /**
     * Metodo que permite crear un registro en la tabla idioma a partir de la cedula del aspitante
     * @param form objeto idioma que contiene la informacion a registrar en la tabla
     * @param cedula cedula a relacionar de la tabla idioma
     * @return -1 o -2 si hay errores al ingresar, si no se devolvera un numero entero positivo
     */
    public int createIdioma(Idioma form, String cedula){
        String sql_save;
        int numRows = 0;
        String lenguaje = form.getLenguaje();
        String nivelLee = form.getNivellee();
        String nivelEscribe = form.getNivelescribe();
        String nivelHabla = form.getNivelhabla();
        String path = form.getPatharchivo();
        
        sql_save="INSERT INTO Idioma VALUES ('" + lenguaje + "', '" + nivelLee + "', '" + nivelEscribe + "' , '" + nivelHabla +  "', '"  +path + "', '"+cedula+"', 'false');";
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);            
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            
            System.out.println(e);
        }
        return -1;
    }
    /**
     * Metodo que permite leer un registro por idioma aprendido en la tabla Idioma 
     * @param lenguaje : nombre del idioma
     * @param cedula: identificacion del aspirante a consultar
     * @return objeto dioma con la informacion consultada
     */
    public Idioma readIdioma(String lenguaje, String cedula){
        Idioma form = new Idioma();
        String sql_select;
        sql_select="SELECT lenguaje, nivelLee, nivelEscribe, nivelHabla, pathArchivo, estado FROM Idioma WHERE  cedula = '"+cedula+"' AND lenguaje = '"+lenguaje+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                form.setLenguaje(table.getString(1));               
                
                form.setNivellee(table.getString(2));               

                form.setNivelescribe(table.getString(3));

                form.setNivelhabla(table.getString(4));
                
                form.setPatharchivo(table.getString(5));
                
                form.setState(table.getBoolean(6));
      
                //System.out.println("ok");
            }
           
            return form;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao lenguaje tic");System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite actualizar la informacion de un registro Idioma de acuerdo al lenguaje y al aspirante
     * @param cedula: identificacion del aspirante al cual se le actulizara el registro
     * @param lenguaje : lenguaje, permite identificar el registro 
     * @param form : objeto Idioma que contiene la nueva informacion del registro
     * @return 
     */
    public int updateIdioma(String cedula,String lenguaje, Idioma form){
        String sql1,sql2,sql3, sql4, sql5;
        String nivelLee = form.getNivellee();
        String nivelEscribe = form.getNivelescribe();
        String nivelHabla = form.getNivelhabla();
        String path = form.getPatharchivo();
        Boolean state = form.getState();
        
        sql1="UPDATE Idioma SET experiencia="+nivelLee+" WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"';";
        sql2="UPDATE Idioma SET experiencia="+nivelEscribe+" WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"';";
        sql3="UPDATE Idioma SET experiencia="+nivelHabla+" WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"';";
        sql4="UPDATE Idioma SET experiencia="+path+" WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"';";
        sql5="UPDATE Idioma SET experiencia="+state+" WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"';";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            sentencia.executeUpdate(sql5);
            
            return 1;
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    /**
     * Metodo que permite listar los registros en la tabla Idioma de un aspirante
     * @param cedula: identificacion del aspirante al cual se listaran sus registros de formadortic
     * @return arreglo de objetos Idioma que contiene la informacion almacenada en la base de datos
     */
    public Idioma[] listIdioma(String cedula){
        String sql_select;
        sql_select="SELECT lenguaje, nivelLee, nivelEscribe, nivelHabla, pathArchivo, estado FROM Idioma WHERE  cedula = '"+cedula+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            int numRows=0;
            while(table.next()){
               numRows++;
            }
            ResultSet table2= sentence.executeQuery(sql_select);
            
            System.out.println(numRows);
            Idioma form[]= new Idioma[numRows];
            for(int i=0; i<numRows; i++){
                form[i]=new Idioma();
            }
            
            int j=0;
         
            while(table2.next()){
               
                form[j].setLenguaje(table2.getString(1));               
                
                form[j].setNivellee(table2.getString(2));               

                form[j].setNivelescribe(table2.getString(3));

                form[j].setNivelhabla(table2.getString(4));
                
                form[j].setPatharchivo(table2.getString(5));
                
                form[j].setState(table2.getBoolean(6));

                j++;
              System.out.println("ok");
            }
           
            return form;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite eliminar (cambiar estado a inactivo) un registro en la tabla Idioma de un aspirante
     * @param cedula: identificacion del aspitante a eliminar registro
     * @param lenguaje: clase de registro a eliminar , ya que depende del idioma
     * @return 
     */    
    public int deleteIdioma(String cedula, String lenguaje){
        String sql_save;
	sql_save="UPDATE Idioma SET estado=false WHERE cedula='" + cedula + "' AND lenguaje = '"+lenguaje+"'";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql_save);            
            
            return 1;
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }
    /**
     * Metodo que permite cerrar la conexion con la base de datos
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
    
    
}