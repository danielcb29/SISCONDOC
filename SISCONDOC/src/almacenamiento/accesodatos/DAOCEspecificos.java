/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;


import proceso.CEspecifico;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author family
 */
public class DAOCEspecificos {
      /**
     * @param db objeto encargado de la conexión a la base de datos.
     * @param conn objeto para ejecutar las sentencias de SQL
     * 
     */
    private  BaseDatos db;
    Connection conn ;
    /**
     * constructor, inicializa los atributos.
     * @param paramConn objeto tipo Connection
     */
    public DAOCEspecificos(Connection paramConn){
        db = new BaseDatos();
        conn = paramConn;
    }//fin constructor
    /**
     * Metodo que permite realizar la conexion a la base de datos
     */
    public void connectDB(){
        conn = db.getConnetion();
    }
    public Connection getConn(){
        return conn;
    }
        /**
        * crear o agregar un conocimiento específico a la tabla.
        * @param ce la cedula del aspirante al que se le agrega el CEspecifico
        * @param cedula la cedula del aspirante
        * @return 1 en caso que se cumpla todo en su flujo normal, -3 en caso de que el perfil del usuario este malo, -2 en caso de un error de integridad referencial o de entidad, y -1 en cualquier otro caso.
        */
    public int createCEspecifico(CEspecifico ce, String cedula){
        String sql_save;
        int numRows=0;
        sql_save="INSERT INTO conocimientosEspecificos VALUES ('"+ ce.getOfimaticas() +"', '"+ ce.getWeb2() +"', '"+ ce.getEducaDig()+"', '"+ ce.getMultimedia()+"', '"+ ce.getElearning()+"', '"+ ce.getProyeTIC()+"', '"+ ce.getAssessCompe()+"', '"+ ce.getDigBook()+"', '"+ cedula +"', "+ ce.getStatus() +")";
        
        try{
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql_save);
        
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            
            System.out.println(e+"jadlskf"); 
            return -2;
        }
        catch(Exception e){ 
            
            System.out.println(e);
        }
        return -1;
    }//fin saveUser
    /**
    * consultar el usuario que tiene como username el parametro.
    * @param cedula cedula del aspirante a consultar su CEspecifico.
    * @return null si hay algun error de cualquier tipo. Objeto tipo CEspecifico si el objeto del usuario que se consulto.
    */
     public CEspecifico readCEspecifico(String cedula){
        CEspecifico ce = new CEspecifico();
        String sql_select;
        sql_select="SELECT ofimaticas, web2, educadig, multimedia, elearning, proyetic, evaluacompe, librodig, estado FROM conocimientosEspecificos WHERE  cedula = '"+cedula+"'";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                ce.setOfimaticas(table.getString(1));
                                
                ce.setWeb2(table.getString(2));               

                ce.setEducaDig(table.getString(3));

                ce.setMultimedia(table.getString(4));
                
                ce.setElearning(table.getString(5));
                
                ce.setProyeTIC(table.getString(6));
                
                ce.setAssessCompe(table.getString(7));
                
                ce.setDigBook(table.getString(8));
                
                ce.setStatus(table.getBoolean(9));
      
                //System.out.println("ok");
            }
           
            return ce;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao form");System.out.println(e); }
        return null;
    }//fin readCEspecifico

    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param ce objeto de CEspecifico con los atributos a modificar en la base de datos.
     * @param cedula la cedula del aspirante al que se le quiere actualizar el CEspecifico.
     * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
     */
    public int updateCEspecifico(String cedula, CEspecifico ce){
        String sql1,sql2,sql3,sql4,sql5,sql6,sql7,sql8,sql9;
        
	sql1="UPDATE conocimientosEspecificos SET ofimaticas='"+ ce.getOfimaticas() +"' WHERE cedula='" + cedula + "'";
        sql2="UPDATE conocimientosEspecificos SET web2='"+ ce.getWeb2() +"' WHERE cedula='" + cedula + "'";
        sql3="UPDATE conocimientosEspecificos SET educaDig='"+ ce.getEducaDig() +"' WHERE cedula='" + cedula + "'";
        sql4="UPDATE conocimientosEspecificos SET multimedia='"+ ce.getMultimedia() +"' WHERE cedula='" + cedula + "'";
        sql5="UPDATE conocimientosEspecificos SET elearning='"+ ce.getElearning() +"' WHERE cedula='" + cedula + "'";
        sql6="UPDATE conocimientosEspecificos SET proyeTIC='"+ ce.getProyeTIC() +"' WHERE cedula='" + cedula + "'";
        sql7="UPDATE conocimientosEspecificos SET evaluaCompe='"+ ce.getAssessCompe() +"' WHERE cedula='" + cedula + "'";
        sql8="UPDATE conocimientosEspecificos SET libroDig='"+ ce.getDigBook() +"' WHERE cedula='" + cedula + "'";
        sql9="UPDATE conocimientosEspecificos SET estado='"+ ce.getStatus() +"' WHERE cedula='" + cedula + "'";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            sentencia.executeUpdate(sql5);
            sentencia.executeUpdate(sql6);
            sentencia.executeUpdate(sql7);
            sentencia.executeUpdate(sql8);
            sentencia.executeUpdate(sql9);
            
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
    }//fin updateCEspecifico
   /**
     * listar todas las tuplas de los usuarios existentes.
     * @param cedula cedula del aspirante al que se le listaran los CEspecificos
     * @return los objetos tipo CEspecifico enlistados en un arreglo.
     */ 
   public CEspecifico[] listCEspecifico(String cedula){
        String sql_select;
        sql_select="SELECT ofimaticas, web2, educadig, multimedia, elearning, proyetic, evaluacompe, librodig, estado FROM conocimientosEspecificos AND cedula='"+cedula+"'";
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
            CEspecifico ces[]= new CEspecifico[numRows];
            for(int i=0; i<numRows; i++){
                ces[i]=new CEspecifico();
            }
            
            int j=0;
         
            while(table2.next()){
               
                ces[j].setOfimaticas(table.getString(1));
                                
                ces[j].setWeb2(table.getString(2));               

                ces[j].setEducaDig(table.getString(3));

                ces[j].setMultimedia(table.getString(4));
                
                ces[j].setElearning(table.getString(5));
                
                ces[j].setProyeTIC(table.getString(6));
                
                ces[j].setAssessCompe(table.getString(7));
                
                ces[j].setDigBook(table.getString(8));
                
                ces[j].setStatus(table.getBoolean(9));

                j++;
              System.out.println("ok");
            }
           
            return ces;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }//fin listCEspecifico
   /**
    * borrar un CEspecifico de la tabla (pasa a inactivo).
    * @param cedula la cedula del aspirante al que se le quiere borrar el CEspecifico.
    * @return 1 si el método ocurre normalmente. -1 si hay una excepción de SQL. -2 en cualquier otro caso.
    */
     public int deleteCEspecifico(String cedula){	
        String sql_save;

        sql_save="UPDATE conocimientosEspecificos SET estado=false WHERE cedula='" + cedula + "'";
        
        try{
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql_save);
            return 1;
        }
        catch(SQLException e){
            System.out.println(e);
            return -1;
        }
        catch(Exception e){ 
            System.out.println(e);
            
        }
        return -2;
        
    }//fin deleteCEspecifico
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }


}