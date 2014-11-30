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
import proceso.Aspirante;
import proceso.Convocatoria;
import proceso.FormacionTic;

/**
 *
 * @author fernando
 */
public class DAOFormacionTic 
{
     private BaseDatos db;
    private Connection conn;
    //private Connection conn ;
    public DAOFormacionTic(Connection conect){
        db = new BaseDatos();
        conn = conect; 
        //conn = db.getConnetion();
    }
    /**
     * Metodo que permite insertar la fomaciones en TIC del aspirante
     * @param formaciones formaciones  en TIc que ha realizado el aspirante
     * @param cedula cedula del aspirante
     * @return -1 en caso de error , -2 si el aspirante ya existe y 1 en caso contrario
     */
    
    public int insertarFormaciones (FormacionTic [] formaciones,String cedula){
        String sql_save;
        int numRows=0;
        int tamano = formaciones.length;
        int resultado =1 ;
        for (int i = 0 ; i< tamano ; i++ )
        {    
            sql_save = "INSERT INTO FormacionTic VALUES ( '"+ formaciones[i].getInstitucion()+ "','" + formaciones[i].getTitulo() + "','" + formaciones[i].getHoras() + "','" +
                    formaciones[i].getUrl_soporte()+ "','" +  cedula + "'," + formaciones[i].getEstado() +");";
            System.out.println(sql_save);
            try{
                Statement sentencia = conn.createStatement();

                numRows = sentencia.executeUpdate(sql_save);            
                System.out.println("numRowsDAO: " + numRows);

            }
            catch(SQLException e){

                System.out.println(e); 
                resultado = -2;
            }
            catch(Exception e){ 

                System.out.println(e);
                resultado = -1;
            }
        }
        return resultado;
    } 
    /**
     * Metodo que permite consultar la formaciones en TIC de un aspirante
     * @param document: cedula del aspirante
     * @return: el aspirante encontrado , con atributos null si no existe o null en caso de error
     */
    public FormacionTic [] consultarFormaciones(String cedula){
        FormacionTic [] formaciones;
        
        String sql_select;
        sql_select="SELECT Institucion, Titulo, horas, pathArchivo, estado " + 
                   "FROM FormacionTic Where cedula = '" + cedula + "';";
        System.out.println(sql_select);
         try{
            System.out.println("consultando en la bd para formaciones TIC");
            Statement sentence = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet table = sentence.executeQuery(sql_select);
            System.out.println("paso");
            table.last();
            int filas = table.getRow();
            System.out.println("filas" + filas);
            formaciones  = new FormacionTic [filas];
            int indice =0;
            table.first();
            table.previous();
        
            while(table.next())
            {
                System.out.println("prueba4");
                formaciones[indice] = new FormacionTic ();
                formaciones[indice].setInstitucion(table.getString(1));
                formaciones[indice].setTitulo(table.getString(2));
                System.out.println("titulo" + table.getString(2) );
                formaciones[indice].setHoras(table.getInt(3));
                formaciones[indice].setUrl_soporte(table.getString(4));
                formaciones[indice].setEstado(table.getBoolean(5));
                indice ++;
            }

            return formaciones;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
    
  
    /**
     * Metodo que permite actualizar una formacion de acuerdo a la cedula del aspirante 
     * @param cedula : cedula del aspirante a actualizar la formacion
     * @param titulo : dado que un aspirante puede tener varias formacionesTic , se especifica cual titulo se va a actualizar.
     * @param form : datos de la formacionTic a actualizar 
     * @return 
     */
    public int updateForm(String cedula,String titulo, FormacionTic form){
        String sql1,sql2,sql3,sql4,sql5;
        String institucion = form.getInstitucion();
        String tit = form.getTitulo();
        int horas = form.getHoras();
        //String level = form.getLevel();
        String path = form.getUrl_soporte();
        boolean estado = form.getEstado();
	sql1="UPDATE FormacionTic SET Institucion ='"+institucion+"' WHERE cedula='" + cedula + "' AND Titulo = '"+ titulo +"';";
        sql2 = "UPDATE FormacionTic SET horas ='"+horas+"' WHERE cedula='" + cedula + "' AND Titulo = '"+ titulo + "';";
        sql3 = "UPDATE FormacionTic SET pathArchivo ='"+path+"' WHERE cedula='" + cedula + "' AND Titulo = '"+ titulo + "';";
        sql4 = "UPDATE FormacionTic SET estado= "+estado+" WHERE cedula='" + cedula + "' AND Titulo = '"+ titulo + "';";
        sql5 = "UPDATE FormacionTic SET Titulo='"+titulo+"' WHERE cedula='" + cedula + "' AND Titulo = '"+ titulo + "';";
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
  
    
  public int eliminarForm(String cedula, String titulo){
        String sql_save;
	sql_save="UPDATE FormacionTic SET estado=false WHERE cedula='" + cedula + "' AND titulo = '"+titulo+"'";
        System.out.println(sql_save);
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