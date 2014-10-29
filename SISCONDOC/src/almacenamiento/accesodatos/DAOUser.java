/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;
import proceso.*;

import java.sql.*;

/**
 *
 * @author family
 */
public class DAOUser {
    /**
     * @param db objeto encargado de la conexión a la base de datos.
     * @param conn objeto para ejecutar las sentencias de SQL
     * 
     */
    private  BaseDatos db;
    Connection conn ;
    /**
     * constructor, inicializa los atributos.
     */
    public DAOUser(){
        db=new BaseDatos();
        conn = db.getConnetion();
    }//fin constructor
    /**
    * crear o agregar un usuario a la tabla.
    * @param us el objeto usuario a agregar.
    * @return devuelve el número de tuplas que se agregaron a la tabla.
    */
    public int createUser(Usuario us){
        String sql_save;
        int numRows=0;

        sql_save="INSERT INTO usuario VALUES ('" +
                us.getName() + "' , '" + us.getLastName() + "', '" + us.getUserName() +  "', '" + us.getCedula() + "' , '"  +us.getPassword() + "', '" + us.getMail() + "', '" + us.getProfile()+ "')";
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);            
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            System.out.println(e); 
            }
        catch(Exception e){ 
            System.out.println(e);
        }
        return -1;
    }//fin saveUser
    /**
    * consultar el usuario que tiene como username el parametro.
    * @param username el username del usuario que se quiere consultar.
    * @return null si hay error en la consulta a la base de datos. Objeto tipo Usuario si el objeto del usuario que se consulto. Devuelve 
    */
	public Usuario readUser(String username){
            Usuario us= new Usuario();
            String sql_select;
            sql_select="SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.contrasena, usuario.email ,  perfiles.nombre FROM  usuario, perfiles WHERE usuario.id_perfil=perfiles.id_perfil AND userName='" + username +  "'";
            try{
                System.out.println("consultando en la bd");
                Statement sentence = conn.createStatement();
                ResultSet table = sentence.executeQuery(sql_select);
                
            while(table.next()){
                
                us.setCedula(table.getString(1));
               
                us.setName(table.getString(2));
                
                us.setLastName(table.getString(3));
                
                us.setUserName(table.getString(4));               

                us.setPassword(table.getString(5));

                us.setMail(table.getString(6));
 
                us.setProfile(table.getString(7));
              
                System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }//fin readUser

    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param campoAModificar nombre igual que en la base de datos del campo que se quiere actualizar.
     * @param modificacion como se quiere que quede el campo modificado.
     * @param cedula la cedula del usuario que se quiere actualizar.
     */
    public void updateUser(String campoAModificar, String modificacion, String cedula){
        String sql_save;
	sql_save="UPDATE usuario SET "+campoAModificar+"='"+modificacion+" WHERE cedula='" + cedula + "'";

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
    }//fin updateUser
    /**
     * listar todas las tuplas de los usuarios existentes.
     * @return los objetos tipo Usuario enlistados en un arreglo.
     */
    public Usuario[] listUsers(){
        
        String sql_select;
        sql_select="SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.contrasena, usuario.email ,  perfiles.nombre FROM  usuario, perfiles WHERE usuario.id_perfil=perfiles.id_perfil";
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
            Usuario us[]= new Usuario[numRows];
            for(int i=0; i<numRows; i++){
                us[i]=new Usuario();
            }
            
            int j=0;
            while(table2.next()){
               
                us[j].setCedula(table.getString(1));
               
                us[j].setName(table.getString(2));
                
                us[j].setLastName(table.getString(3));
                
                us[j].setUserName(table.getString(4));               

                us[j].setPassword(table.getString(5));

                us[j].setMail(table.getString(6));
 
                us[j].setProfile(table.getString(7));


              j++;
              System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }//fin listUser
   
   /**
    * borrar un usuario de la tabla.
    * @param cedula la cedula del usuario que se quiere borrar.
    */
    public void deleteUser(String cedula){	
		String sql_save;

        sql_save="DELETE FROM usuario WHERE cedula='" + cedula + "'";
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
    }//fin deleteUser
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }//fin closeConectionDB


}
