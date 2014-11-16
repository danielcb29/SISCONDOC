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
public class DAOAspirante 
{
    private BaseDatos db;
    private Connection conn;
    //private Connection conn ;
    public DAOAspirante(Connection conect){
        db = new BaseDatos();
        conn = conect; 
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear un aspirante en la base de datos
     * @param aspirante el aspirante  a ser almacenado
     * @return -1 en caso de error , -2 si el aspirante ya existe y el numero de filas en caso contrario
     */
    
    public int crateAspirante(Aspirante aspirante){
        String sql_save;
        int numRows=0;
        
        sql_save = "INSERT INTO Aspirante VALUES ( '"+ aspirante.getDocument() + "','" + aspirante.getName() + "','" + aspirante.getLastname() + "','" +
                aspirante.getCity() + "'," +  aspirante.getPuntaje() + ","  + aspirante.getConvocatoria().getCode()+ ",'" + aspirante.getGenero()+ "','" +
                aspirante.getJornada() + "','" + aspirante.getFecha_nac() +"');";
        System.out.println(sql_save);
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
    public Aspirante readAspirante(String document){
        Aspirante aspirante = new Aspirante();
        Convocatoria convocatoria = new Convocatoria ();
        String sql_select;
        sql_select="SELECT A.cedula, A.nombre, A.apellido, A.municipio, A.puntuacion, A.codigo, " + 
                   "C.fecha_ini, C.fecha_fin, C.nombre, C.estado, C.descripcion , A.genero, A.jornada, A.fecha_nac " +
                   "FROM Aspirante as A, Convocatoria as C WHERE A.codigo = C.codigo and cedula = '"+document+"';";
        System.out.println("consulta aspirante " + sql_select);
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm");
            while(table.next()){
                
                aspirante.setDocument(table.getString(1));
                aspirante.setName(table.getString(2));
                aspirante.setLastname(table.getString(3));
                aspirante.setCity(table.getString(4));
                aspirante.setPuntaje(table.getInt(5));
                
                //asignacion de atributos al objeto convocatoria.
                convocatoria.setCode(table.getInt(6));
                Date datIn;
                datIn = format.parse(table.getString(7));
                convocatoria.setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table.getString(8));
                convocatoria.setDateEnd(datEnd);
                convocatoria.setName(table.getString(9));
                convocatoria.setState(table.getBoolean(10));               
                convocatoria.setDescription(table.getString(11));
                //
                aspirante.setGenero(table.getString(12));
                aspirante.setJornada(table.getString(13));
                aspirante.setFecha_nac(table.getString(14));
                
                aspirante.setConvocatoria(convocatoria);            
            }
           
            return aspirante;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
    public void updateAspirante(String documento, Aspirante aspirante){
        String sql1,sql2,sql3,sql4,sql5,sql6,sql7,sql8,sql9;
	sql1="UPDATE convocatoria SET nombre='"+aspirante.getName()+"' WHERE cedula='" + documento + "';";
        sql2 = "UPDATE convocatoria SET apellido ='"+aspirante.getLastname()+"' WHERE cedula='" + documento + "';";
        sql3 = "UPDATE convocatoria SET municipio ='"+aspirante.getCity()+"'WHERE cedula='" + documento + "';";
        sql4 = "UPDATE convocatoria SET puntaje='"+aspirante.getPuntaje()+"' WHERE cedula='" + documento + "';";
        sql5 = "UPDATE convocatoria SET codigo='"+aspirante.getConvocatoria().getCode()+"' WHERE cedula='" + documento + "';";
        sql6 = "UPDATE convocatoria SET genero='"+aspirante.getGenero()+"' WHERE cedula='" + documento + "';";
        sql7 = "UPDATE convocatoria SET jornada='"+aspirante.getJornada()+"' WHERE cedula='" + documento + "';";
        sql8 = "UPDATE convocatoria SET fecha_nac='"+aspirante.getFecha_nac()+"' WHERE cedula='" + documento + "';";
        sql9 = "UPDATE convocatoria SET cedula='"+aspirante.getDocument()+"' WHERE cedula='" + documento + "';";
        
        
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
    public Aspirante[] listAspirantes(String callName){
        String sql_select;
        sql_select="SELECT A.cedula, A.nombre, A.apellido, A.municipio, A.puntaje FROM Aspirante as A NATURAL JOIN Convocatoria as C WHERE C.nombre = '"
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
            Aspirante aspirantes[]= new Aspirante[numRows];
            for(int i=0; i<numRows; i++){
                aspirantes[i]=new Aspirante();
            }
            
            int j=0;
            while(table2.next())
            {
               
                aspirantes[j].setDocument(table.getString(1));   
                aspirantes[j].setName(table.getString(2));   
                aspirantes[j].setLastname(table.getString(3));   
                aspirantes[j].setCity(table.getString(4)); 
                aspirantes[j].setPuntaje(table.getInt(5)); 
              j++;
              System.out.println("ok");
            }
           
            return aspirantes;
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
