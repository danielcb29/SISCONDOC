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

import proceso.Formacion;

/**
 *
 * @author daniel
 */
public class DAOFormacion {
    /**
     * Atributos de la clase , base de datos para realizar la gestion y la conexion que se maneja en el sistema
     */
    private BaseDatos db;
    private Connection conn;
    public DAOFormacion(Connection paramConn){
        db = new BaseDatos();
        conn = paramConn;
    }
    /**
     * Metodo encargado de crear una formacion en la base de datos
     * @param form: objeto formacion con la info a almacenar 
     * @param cedula: cedula del aspirante al cual pertenece esa formacion
     * @return : 1 para todo OK , -1 error general , -2 error en la implementacion del metodo o algo respecto a la db
     */
    public int crateForm(Formacion form, String cedula){
        String sql_save;
        int numRows=0;
        String university = form.getUniversity();
        String title = form.getTitle();
        String level = form.getLevel();
        String path = form.getPathFile();
        
        
        sql_save="INSERT INTO formacion VALUES (  '" + university +  "', '" + title + "', '" + level + "' , '"  +path + "', '" + cedula + "','true');";
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
     * Metodo que permite leer una formacion de acuerdo a un nivel y una cedula
     * @param level : nivel de la formacion
     * @param cedula : cedula del aspirante
     * @return formacion leida
     */
    public Formacion readForm(String level, String cedula){
        Formacion form = new Formacion();
        String sql_select;
        sql_select="SELECT Universidad,Titulo,nivel,pathArchivo, estado FROM Formacion WHERE  cedula = '"+cedula+"' AND nivel = '"+level+"';";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                form.setUniversity(table.getString(1));
                
                
                form.setTitle(table.getString(2));               

                form.setLevel(table.getString(3));

                form.setPathFile(table.getString(4));
                
                form.setState(table.getBoolean(5));
      
                //System.out.println("ok");
            }
           
            return form;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("exception dao form");System.out.println(e); }
        return null;
    }
    /**
     * Metodo que permite actualizar una formacion de acuerdo a la cedula del aspirante 
     * @param cedula : cedula del aspirante a actualizar la formacion
     * @param level : dado que un aspirante puede tener varias formaciones , se especifica que nivel de formacion es que se actualizara
     * @param form : datos de la formacion a actualizar 
     * @return 
     */
    public int updateForm(String cedula,String exLevel, Formacion form){
        String sql1,sql2,sql4,sql5;
        String university = form.getUniversity();
        String title = form.getTitle();
        //String level = form.getLevel();
        String path = form.getPathFile();
        boolean state = form.getState();
	sql1="UPDATE formacion SET Universidad='"+university+"' WHERE cedula='" + cedula + "' AND nivel = '"+exLevel+"';";
        sql2 = "UPDATE formacion SET Titulo='"+title+"' WHERE cedula='" + cedula + "' AND nivel = '"+exLevel+"';";
        //sql3 = "UPDATE formacion SET nivel='"+level+"' WHERE nombre='" + cedula + "';";
        sql4 = "UPDATE formacion SET pathArchivo='"+path+"' WHERE cedula='" + cedula + "' AND nivel = '"+exLevel+"';";
        sql5 = "UPDATE formacion SET estado='"+state+"' WHERE cedula='" + cedula + "' AND nivel = '"+exLevel+"';";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql1);
            sentencia.executeUpdate(sql2);
            //sentencia.executeUpdate(sql3);
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
     * Metodo que permite listar una serie de formaciones de acuerdo a un aspirante , es decir , retorna todas las formaciones de un aspirante particular dado por su cedula
     * @param cedula : cedula del aspirante a consultar sus formaciones  
     * @return Arreglo de formaciones de un aspirante
     */
    public Formacion[] listForm(String cedula){
        String sql_select;
        sql_select="SELECT Universidad,Titulo,nivel,pathArchivo,estado FROM Formacion WHERE cedula='"+cedula+"' ;";
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
            Formacion form[]= new Formacion[numRows];
            for(int i=0; i<numRows; i++){
                form[i]=new Formacion();
            }
            
            int j=0;
         
            while(table2.next()){
               
                form[j].setUniversity(table2.getString(1));
                
                form[j].setTitle(table2.getString(2));
                
                form[j].setLevel(table2.getString(3));
                
                form[j].setPathFile(table2.getString(4));  
                
                form[j].setState(table2.getBoolean(5));

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
     * Metodo que permite eliminar una formacion (ponerla en estado inactivo)
     * @param cedula: identificacion del aspirante al cual pertenece la formacion
     * @param level : nivel de la formacion a inactivar
     * @return 
     */
    public int deletForm(String cedula, String level){
        String sql_save;
	sql_save="UPDATE formacion SET estado=false WHERE cedula='" + cedula + "' AND nivel = '"+level+"'";
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
