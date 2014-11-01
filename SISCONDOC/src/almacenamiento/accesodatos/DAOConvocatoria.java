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
        String dateOne = conv.getDateIn().toString();
        String dateTwo = conv.getDateEnd().toString();

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
        Convocatoria conv = new Convocatoria();
        String sql_select;
        sql_select="SELECT nombre,fecha_Ini,fecha_Fin,estado,descripcion FROM Convocatoria WHERE estado=true AND nombre = "+name+";";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            SimpleDateFormat format = new SimpleDateFormat("yyy/MM/dd HH:mm");
            while(table.next()){
                
                conv.setName(table.getString(1));
                Date datIn;
                datIn = format.parse(table.getString(2));
                conv.setDateIn(datIn);
                Date datEnd;
                datEnd = format.parse(table.getString(3));
                conv.setDateEnd(datEnd);
                
                conv.setState(table.getBoolean(4));               

                conv.setDescription(table.getString(5));

                
              
                //System.out.println("ok");
            }
           
            return conv;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    public void updateConv(){
        
    }
    /**
     * Metodo que permite listar las convocatorias activas en la base de datos 
     * @return: Arreglo con las convocatorias existentes en la base de datos, null en caso de error
     */
    public Convocatoria[] listConv(){
        return null;
    }
    /**
     * Metodo que permite cambiar el estado de una convocatoria de activa a no activa 
     * @param name 
     */
    public void deletConv(String name){
        
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
}
