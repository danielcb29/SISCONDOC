/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import proceso.FormadorTIC;


/**
 *
 * @author daniel
 */
public class DAOFormadorTIC {
    private BaseDatos db;
    private Connection conn;
    
    public DAOFormadorTIC(Connection paramConn){
        db = new BaseDatos();
        conn= paramConn;
    }
    /**
     * Metodo que permite crear un registro en la tabla formador en tic a partir de la cedula del aspitante
     * @param form : objeto formador tic 
     * @param cedula: cedula del aspirante
     * @return numero de confirmacion , 1 para ok , -2 para error sql , -1 error general
     */
    public int crateFormador(FormadorTIC form, String cedula){
        String sql_save;
        int numRows=0;
        String people = form.getPeople();
        int time = form.getTime();
        String path = form.getPath();
        
        
        sql_save="INSERT INTO formadorTic VALUES (  '" + people +  "', " + time + ", '" + cedula + "' , '"  +path + "', true);";
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
     * Metodo que permite leer un registro por personas formadas en la tabla formadortic 
     * @param people : personas formadas
     * @param cedula: identificacion del aspirante a consultar
     * @return objeto FormadorTIC con la informacion consultada
     */
    public FormadorTIC readFormador(String people, String cedula){
        FormadorTIC form = new FormadorTIC();
        String sql_select;
        sql_select="SELECT formados,experiencia,pathArchivo, estado FROM formadorTic WHERE  cedula = '"+cedula+"' AND formados = '"+people+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                form.setPeople(table.getString(1));
                
                
                form.setTime(table.getInt(2));               

                form.setPath(table.getString(3));

                form.setState(table.getBoolean(4));
      
                //System.out.println("ok");
            }
           
            return form;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao formador tic");System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite actualizar la informacion de un registro formadorTic de acuerdo a los formados y al aspirante
     * @param cedula: identificacion del aspirante al cual se le actulizara el registro
     * @param people : personas formadas, permite identificar el registro 
     * @param form : objeto FormadorTIC que contiene la nueva informacion del registro
     * @return 
     */
    public int updateFormador(String cedula,String people, FormadorTIC form){
        String sql1,sql2,sql3;
        //String people = form.getPeople();
        int time = form.getTime();
        String path = form.getPath();
        boolean state = form.getState();
        sql1="UPDATE formadorTic SET experiencia="+time+" WHERE cedula='" + cedula + "' AND formados = '"+people+"';";
        sql2 = "UPDATE formadorTic SET pathArchivo='"+path+"' WHERE cedula='" + cedula + "' AND formados = '"+people+"';";
        sql3 = "UPDATE formadorTic SET estado="+state+" WHERE cedula='" + cedula + "' AND formados = '"+people+"';";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            
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
     * Metodo que permite listar los registros en la tabla formadortic de un aspirante
     * @param cedula: identificacion del aspirante al cual se listaran sus registros de formadortic
     * @return arreglo de objetos FormadorTIC que contiene la informacion almacenada en la base de datos
     */
    public FormadorTIC[] listFormador(String cedula){
        String sql_select;
        sql_select="SELECT formados,experiencia,pathArchivo, estado FROM formadorTic WHERE  cedula = '"+cedula+"' ;";
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
            FormadorTIC form[]= new FormadorTIC[numRows];
            for(int i=0; i<numRows; i++){
                form[i]=new FormadorTIC();
            }
            
            int j=0;
         
            while(table2.next()){
               
                form[j].setPeople(table2.getString(1));
                
                form[j].setTime(table2.getInt(2));
                
                form[j].setPath(table2.getString(3));
                
                form[j].setState(table2.getBoolean(4));

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
     * Metodo que permite eliminar (cambiar estado a inactivo) un registro en la tabla formadorTic de un aspirante
     * @param cedula: identificacion del aspitante a eliminar registro
     * @param people: clase de registro a eliminar , ya que depende de las personas formadas
     * @return 
     */    
    public int deletFormador(String cedula, String people){
        String sql_save;
	sql_save="UPDATE formadorTic SET estado=false WHERE cedula='" + cedula + "' AND formados = '"+people+"'";
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
