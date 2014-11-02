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
     * Metodo que permite crear una convocatoria en la base de datos
     * @param conv la convocatoria a ser almacenada
     * @return -1 en caso de error , -2 si la conv ya existe y el numero de filas en caso contrario
     */
    
    public int crateAspirant(Aspirant aspirant){
        String sql_save;
        int numRows=0;
        
        sql_save = "INSERT INTO Aspirante VALUES ( '"+ aspirant.getDocument() + "','" + aspirant.getName() + "','" + aspirant.getLastname() + "'," +
                aspirant.getCity() + "," +  aspirant.getPuntuaction() + ","  + aspirant.getConvocatoria().getId()+ ");";
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
     * Metodo que permite consultar la informacion de una convocatoria 
     * @param document: cedula del aspirante a consultar 
     * @return: la convocatora encontrada , con atributos null si no existe o null en caso de error
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
        String sql1,sql2,sql3,sql4;
	sql1="UPDATE convocatoria SET nombre='"+aspirant.getName()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        sql2 = "UPDATE convocatoria SET apellido ='"+aspirant.getLastname()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        sql3 = "UPDATE convocatoria SET municipio ='"+aspirant.getCity()+"'WHERE cedula='" + aspirant.getDocument() + "';";
        sql4 = "UPDATE convocatoria SET descripcion='"+aspirant.getDescription()+"' WHERE cedula='" + aspirant.getDocument() + "';";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            
            
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    /**
     * Metodo que permite listar las convocatorias activas en la base de datos 
     * @return: Arreglo con las convocatorias existentes en la base de datos, null en caso de error
     */
    public Aspirant[] listAspirants(){
        String sql_select;
        sql_select="SELECT nombre,fecha_Ini,fecha_Fin,estado,descripcion FROM Convocatoria WHERE estado=true ;";
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
            Convocatoria conv[]= new Convocatoria[numRows];
            for(int i=0; i<numRows; i++){
                conv[i]=new Convocatoria();
            }
            
            int j=0;
            SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
            while(table2.next()){
               
                conv[j].setName(table.getString(1));
                Date datIn;
                datIn = format.parse(table.getString(2));
                conv[j].setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table.getString(3));
                conv[j].setDateEnd(datEnd);
                
                conv[j].setState(table.getBoolean(4));               

                conv[j].setDescription(table.getString(5));


              j++;
              System.out.println("ok");
            }
           
            return conv;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite cambiar el estado de una convocatoria de activa a no activa 
     * @param name 
     */
    public void deletConv(String name){
        String sql_save;
	sql_save="UPDATE convocatoria SET estado=false WHERE nombre='" + name + "'";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql_save);            
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }

    
}
