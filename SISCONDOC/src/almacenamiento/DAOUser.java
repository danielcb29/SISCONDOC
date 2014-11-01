 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento;
import proceso.*;
import java.sql.*;
import almacenamiento.accesodatos.*;
/**
 *
 * @author family
 */
public class DAOUser {
    private  BaseDatos db;
    Connection conn ;
    public DAOUser(){
        db=new BaseDatos();
        conn = db.getConnetion();
    }//fin constructor

	public int createUser(Usuario us){
        String sql_save;
        int numRows=0;

        sql_save="INSERT INTO usuario VALUES ('" +
                us.getCedula() + "' , '" + us.getName() + "', '" + us.getUserName() +  "', '" +
                us.getPassword() + "', '" + us.getMail() + "', '" + us.getProfile()+ "')";
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

	public Usuario readUser(String username){
        Usuario us= new Usuario();
        String sql_select;
        sql_select="SELECT usuario.cedula, usuario.nombre, usuario.nombre_usuario, usuario.password, usuario.email ,  perfil.nombre FROM  usuario, perfil WHERE usuario.id_perfil=perfil.id_perfil AND nombre_usuario='" + username +  "'";
         try{
            System.out.println("consultando en la bd");
            Statement sentence = conn.createStatement();
            ResultSet table = sentence.executeQuery(sql_select);
            
            while(table.next()){
                
                us.setCedula(table.getString(1));
               
                us.setName(table.getString(2));
                
                us.setUserName(table.getString(3));               

                us.setPassword(table.getString(4));

                us.setMail(table.getString(5));
 
                us.setProfile(table.getString(6));
              
                System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }//fin readUser

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
    }
    
    public Usuario[] listUsers(){
        
        String sql_select;
        sql_select="SELECT usuario.cedula, usuario.nombre, usuario.nombre_usuario, usuario.password, usuario.email ,  perfil.nombre FROM  usuario, perfil WHERE usuario.id_perfil=perfil.id_perfil";
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
                
                us[j].setUserName(table.getString(3));               

                us[j].setPassword(table.getString(4));
 
		us[j].setMail(table.getString(5));
 
                us[j].setProfile(table.getString(6));

              j++;
              System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
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
    }
    
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }


}
