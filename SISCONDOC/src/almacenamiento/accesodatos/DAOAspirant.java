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
import java.text.SimpleDateFormat;
import java.util.Date;
import proceso.Convocatoria;
import proceso.*;

/**
 *
 * @author fernando
 */
public class DAOAspirant 
{
    private BaseDatos db;
    private Connection conn;
    //private Connection conn ;
    public DAOAspirant(Connection conect){
        db = new BaseDatos();
        conn = conect; 
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear un aspirante en la base de datos
     * @param aspirant el aspirante  a ser almacenado
     * @return -1 en caso de error , -2 si el aspirante ya existe y el numero de filas en caso contrario
     */
    
    public int crateAspirant(Aspirant aspirant){
        String sql_save;
        int numRows=0;
        
        sql_save = "INSERT INTO Aspirante VALUES ( '"+ aspirant.getDocument() + "','" + aspirant.getName() + "','" + aspirant.getLastname() + "'," +
                aspirant.getCity() + "," +  aspirant.getPuntuaction() + ","  + aspirant.getConvocatoria().getCode()+ ");";
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
     * Metodo que permite consultar la informacion de un aspirante
     * @param document: cedula del aspirante a consultar 
     * @return: el aspirante encontrado , con atributos null si no existe o null en caso de error
     */
    public Aspirant readAspirant(String document){
        Aspirant aspirant = new Aspirant();
        Convocatoria call = new Convocatoria ();
        String sql_select;
        sql_select="SELECT A.cedula,A.nombre,A.apellido,A.municipio,A.puntuacion,A.codigo" + 
                   "C.fecha_ini, C.fecha_fin, C.nombre,C.estado, C.descripcion FROM" +
                   "FROM Aspirante as A NATURAL JOIN Convocatoria as C WHERE cedula = '"+document+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm");
            while(table.next()){
                
                aspirant.setDocument(table.getString(1));
                aspirant.setName(table.getString(2));
                aspirant.setLastname(table.getString(3));
                aspirant.setCity(table.getString(4));
                aspirant.setPuntuaction(table.getInt(5));
                
                //asignacion de atributos al objeto convocatoria.
                call.setCode(table.getInt(6));
                Date datIn;
                datIn = format.parse(table.getString(7));
                call.setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table.getString(8));
                call.setDateEnd(datEnd);
                call.setName(table.getString(9));
                call.setState(table.getBoolean(10));               
                call.setDescription(table.getString(11));
                
                aspirant.setConvocatoria(call);            
            }
           
            return aspirant;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public void updateAspirant(Aspirant aspirant){
        String sql1,sql2,sql3,sql4,sql5;
	sql1="UPDATE convocatoria SET nombre='"+aspirant.getName()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        sql2 = "UPDATE convocatoria SET apellido ='"+aspirant.getLastname()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        sql3 = "UPDATE convocatoria SET municipio ='"+aspirant.getCity()+"'WHERE cedula='" + aspirant.getDocument() + "';";
        sql4 = "UPDATE convocatoria SET puntuacion='"+aspirant.getPuntuaction()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        sql5 = "UPDATE convocatoria SET codigo='"+aspirant.getConvocatoria().getCode()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        
        try{
                Statement sentencia = conn.createStatement();

                sentencia.executeUpdate(sql1);
                sentencia.executeUpdate(sql2);
                sentencia.executeUpdate(sql3);
                sentencia.executeUpdate(sql4);
                sentencia.executeUpdate(sql5);

            }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    /**
     * Metodo que permite listar los aspirantes de una convocatoria 
     * @return: Arreglo con los aspirantes en la base de datos que perteneces a la convocatoria especificada, null en caso de error
     */
    public Aspirant[] listAspirants(String callName){
        String sql_select;
        sql_select="SELECT A.cedula, A.nombre, A.apellido, A.municipio, A.puntuacion FROM Aspirante as A NATURAL JOIN Convocatoria as C WHERE C.nombre = '"
                    + callName + "';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            ResultSet table2= table;
            int numRows=0;
            while(table.next()){
               numRows++;
            }
            System.out.println(numRows);
            Aspirant aspirants[]= new Aspirant[numRows];
            for(int i=0; i<numRows; i++){
                aspirants[i]=new Aspirant();
            }
            
            int j=0;
            while(table2.next())
            {
               
                aspirants[j].setDocument(table.getString(1));   
                aspirants[j].setName(table.getString(2));   
                aspirants[j].setLastname(table.getString(3));   
                aspirants[j].setCity(table.getString(4)); 
                aspirants[j].setPuntuaction(table.getInt(5)); 
              j++;
              System.out.println("ok");
            }
           
            return aspirants;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }

    
}
