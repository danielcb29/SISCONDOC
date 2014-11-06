/*
 * To change this template, choose Tools | Templates
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
import proceso.Usuario;


/**
 *
 * @author daniel
 */
public class DAOConvocatoria {
    private BaseDatos db;
    private Connection conn;
    //private Connection conn ;
    public DAOConvocatoria(Connection conect){
        db = new BaseDatos();
        conn = conect; 
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite crear una convocatoria en la base de datos
     * @param conv la convocatoria a ser almacenada
     * @return -1 en caso de error , -2 si la conv ya existe y el numero de filas en caso contrario
     */
    
    public int crateConv(Convocatoria conv){
        String sql_save;
        int numRows=0;
        Date dOne = conv.getDateIn();
        Date dTwo = conv.getDateEnd();
        SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
        format.format(dOne);
        format.format(dTwo);
        String dateOne = dOne.toString();
        String dateTwo = dTwo.toString();
        
        System.out.println("date one :"+dateOne);
        System.out.println("date two :"+dateTwo);

        sql_save="INSERT INTO convocatoria VALUES ( NEXTVAL('convo_seq')  , '" + dateOne +  "', '" + dateTwo + "', '" + conv.getName() + "' , "  +conv.getState() + ", '" + conv.getDescription() + "');";
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
     * @param name: nombre de la convocatoria a consultar 
     * @return: la convocatora encontrada , con atributos null si no existe o null en caso de error
     */
    public Convocatoria readConv(String name){
        System.out.println("nombre convo en dao conv:"+name);
        Convocatoria conv = new Convocatoria();
        String sql_select;
        sql_select="SELECT nombre,fecha_Ini,fecha_Fin,estado,descripcion,codigo,estado FROM Convocatoria WHERE  nombre = '"+name+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            System.out.println("despues de sentence pero antes del resultset");
            ResultSet table = sentence.executeQuery(sql_select);
            System.out.println("despues del resultset");
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm");
            
            while(table.next()){
                
                conv.setName(table.getString(1));
                Date datIn;
                System.out.println("fecha posle null pointer:"+table.getString(2));
                datIn = format.parse(table.getString(2));
                conv.setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table.getString(3));
                conv.setDateEnd(datEnd);
                
                conv.setState(table.getBoolean(4));               

                conv.setDescription(table.getString(5));

                conv.setCode(table.getInt(6));
                
                conv.setState(table.getBoolean(7));
              
                //System.out.println("ok");
            }
           
            return conv;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao conv");System.out.println(e); }
        return null;
    }
    public void updateConv(String exCon, Convocatoria conv){
        String sql_save1,sql2,sql3,sql4,sql5;
	sql_save1="UPDATE convocatoria SET nombre='"+conv.getName()+"' WHERE nombre='" + exCon + "';";
        sql2 = "UPDATE convocatoria SET fecha_Ini='"+conv.getDateIn().toString()+"' WHERE nombre='" + exCon + "';";;
        sql3 = "UPDATE convocatoria SET fecha_Fin='"+conv.getDateEnd().toString()+"' WHERE nombre='" + exCon + "';";
        sql4 = "UPDATE convocatoria SET descripcion='"+conv.getDescription()+"' WHERE nombre='" + exCon + "';";
        sql5 = "UPDATE convocatoria SET estado="+conv.getState()+" WHERE nombre='" + exCon + "';";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql2);
            sentencia.executeUpdate(sql3);
            sentencia.executeUpdate(sql4);
            sentencia.executeUpdate(sql5);
            sentencia.executeUpdate(sql_save1);
            
            
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
    public Convocatoria[] listConv(){
        String sql_select;
        sql_select="SELECT nombre,fecha_Ini,fecha_Fin,estado,descripcion,codigo FROM Convocatoria WHERE estado=true ;";
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
            Convocatoria conv[]= new Convocatoria[numRows];
            for(int i=0; i<numRows; i++){
                conv[i]=new Convocatoria();
            }
            
            int j=0;
            SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
         
            while(table2.next()){
               
                conv[j].setName(table2.getString(1));
                Date datIn;
                datIn = format.parse(table2.getString(2));
                conv[j].setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table2.getString(3));
                conv[j].setDateEnd(datEnd);
                
                conv[j].setState(table2.getBoolean(4));               

                conv[j].setDescription(table2.getString(5));
                
                conv[j].setCode(table2.getInt(6));


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
