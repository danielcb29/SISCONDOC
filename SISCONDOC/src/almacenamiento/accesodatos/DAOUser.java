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
        * crear o agregar un usuario a la tabla.
        * @param us el objeto usuario a agregar.
        * @return devuelve el número de tuplas que se agregaron a la tabla.
        */
    public int createUser(Usuario us){
        String sql_save,sql_convo;
        int numRows=0;
        System.out.println("antes del get");
        String prof=us.getProfile();
        System.out.println("create obtenemos perfil: "+prof);
        switch(prof){
            case "Digitador":   sql_save="INSERT INTO usuario VALUES ('" + us.getName() + "' , '" + us.getLastName() + "', '" + us.getUserName() +  "', '" + us.getCedula() + "' , '"  +us.getPassword() + "', '" + us.getMail() + "', '1', " + us.getState()+ ")";
                                break;
            case "Coordinador": sql_save="INSERT INTO usuario VALUES ('" + us.getName() + "' , '" + us.getLastName() + "', '" + us.getUserName() +  "', '" + us.getCedula() + "' , '"  +us.getPassword() + "', '" + us.getMail() + "', '2', " + us.getState()+ ")";
                                break;
            case "Administrador":   sql_save="INSERT INTO usuario VALUES ('" + us.getName() + "' , '" + us.getLastName() + "', '" + us.getUserName() +  "', '" + us.getCedula() + "' , '"  +us.getPassword() + "', '" + us.getMail() + "', '3', " + us.getState()+ ")";
                                    break;
            default: return -3;
        }    
        
        try{
            Statement sentencia = conn.createStatement();

            numRows = sentencia.executeUpdate(sql_save);
            System.out.println("antes del if, prof : "+prof);
             if(!(prof.equals("Administrador"))){
                System.out.println("antes sentencia"); 
                sql_convo = "INSERT INTO convoUsuario VALUES ('"+us.getCedula()+"', '"+us.getConvocatoria().getCode()+"', true)";
                sentencia.executeUpdate(sql_convo);
                System.out.println("despues sentencia");
            } //el registro de convoUsuario se crea solo si el usuario es digitador o coordinador.
            System.out.println("numRowsDAO: " + numRows);
            return numRows;
            
        }
        catch(SQLException e){
            
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println("exception dao creare user");
            System.out.println(e);
        }
        return -1;
    }//fin saveUser
        /**
        * consultar el usuario que tiene como username el parametro.
        * @param username el username del usuario que se quiere consultar.
        * @return null si hay error en la consulta a la base de datos. Objeto tipo Usuario si el objeto del usuario que se consulto. Devuelve 
        */
    public Usuario readUser(String req, int tipoCon){
        Usuario us= new Usuario();
        String sql_select;
        if(tipoCon==1){
            //System.out.println("entramos al caso de username");
            sql_select="SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.contrasena, usuario.email ,  perfiles.nombre , usuario.estado FROM  usuario, perfiles WHERE usuario.id_perfil=perfiles.id_perfil AND userName='" + req +  "'";        
        }else{
            sql_select="SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.contrasena, usuario.email ,  perfiles.nombre , usuario.estado FROM  usuario, perfiles WHERE usuario.id_perfil=perfiles.id_perfil AND cedula='" + req +  "'";        
        }
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            //System.out.println("antes de la ejecucion");
            ResultSet table = statement.executeQuery(sql_select);
            //System.out.println("despues de la ejecucion");
            
            while(table.next()){
                //System.out.println("dentro del while");
                us.setCedula(table.getString(1));
               
                us.setName(table.getString(2));
                
                us.setLastName(table.getString(3));
                
                us.setUserName(table.getString(4));               

                us.setPassword(table.getString(5));

                us.setMail(table.getString(6));
 
                us.setProfile(table.getString(7));
                
                us.setState(table.getBoolean(8));
              
                //System.out.println("ok");
            }
           // System.out.println("despues del while antes del if");
            //System.out.println("perfil: "+us.getProfile());
            if(us.getProfile() == null){
                Convocatoria conv = null;
                us.setConvocatoria(conv);
                
            }else{
                    if(!us.getProfile().equals("Administrador")){
                        //System.out.println("entramos al if");
                        String sql_conv= "SELECT convocatoria.nombre FROM convoUsuario, convocatoria WHERE convoUsuario.cedula='"+us.getCedula() +"' AND convoUsuario.codigo=convocatoria.codigo";
                        table = statement.executeQuery(sql_conv);
                        //System.out.println("despues de la consulta convosa");
                        String nom="";
                        while(table.next()){

                            nom = table.getString(1);

                        //System.out.println("ok");
                        }

                        DAOConvocatoria daoc=new DAOConvocatoria(conn);
                        //System.out.println("inicializa dao conv");
                        Convocatoria conv = daoc.readConv(nom);
                        //System.out.println("se trae conv");
                        us.setConvocatoria(conv);
                        //System.out.println("set convo");
                    }
            }
            
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println("excepcion del dao"); System.out.println(e); }
        return null;
    }//fin readUser

    /**
     * actualizar la informacion de un usuario, con la cedula que entra por parametro.
     * @param us objeto de Usuario con los atributos a modificar en la base de datos.
     * @param cedula la cedula del usuario que se quiere actualizar.
     * @return 1 si el proceso ocurrio bien durante todo el metodo, -3 si el usuario entregado tiene un perfil inexistente, -2 si hay algun error de sql y -1 si hay cualquier otro error.
     */
    public int updateUser(Usuario us, String cedula){
        String sql_save1,  sql_save2,  sql_save3, sql_save4,  sql_save5,  sql_save6,  sql_save7,  sql_save8;
	sql_save1="UPDATE usuario SET name='"+us.getName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save2="UPDATE usuario SET lastname='"+us.getLastName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save3="UPDATE usuario SET userName='"+us.getUserName()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save4="UPDATE usuario SET contrasena='"+us.getPassword()+"' WHERE cedula='" + us.getCedula() + "'";
        sql_save5="UPDATE usuario SET email='"+us.getMail()+"' WHERE cedula='" + us.getCedula() + "'";
        switch(us.getProfile()){
            case "Digitador":   sql_save6="UPDATE usuario SET id_perfil='1' WHERE cedula='" + us.getCedula() + "'";
                                break;
            case "Coordinador": sql_save6="UPDATE usuario SET id_perfil='2' WHERE cedula='" + us.getCedula() + "'";
                                break;
            case "Administrador":   sql_save6="UPDATE usuario SET id_perfil='3' WHERE cedula='" + us.getCedula() + "'";
                                    break;
            default: return -3;
                       
        }
        
        
        

        try{
            Statement statement = conn.createStatement();

            statement.executeUpdate(sql_save1);
            statement.executeUpdate(sql_save2);
            statement.executeUpdate(sql_save3);
            statement.executeUpdate(sql_save4);
            statement.executeUpdate(sql_save5);
            statement.executeUpdate(sql_save6);
            
            if(!us.getProfile().equals("Administrador")){
                String sql_save= "SELECT codigo FROM convoUsuario WHERE cedula='"+us.getCedula()+"' AND estado=true";
                ResultSet table= statement.executeQuery(sql_save);
                String cod="";
                while(table.next()){
                    cod = table.getString(1);
                }
                String usCod=Integer.toString(us.getConvocatoria().getCode());
                if(!usCod.equals(cod)){
                    sql_save="UPDATE convoUsuario SET estado=false WHERE codigo= "+cod+" AND cedula = '"+us.getCedula()+"'";
                    statement.executeUpdate(sql_save);
                    sql_save= "SELECT codigo FROM convoUsuario WHERE cedula='"+us.getCedula()+"'";
                    table= statement.executeQuery(sql_save);
                    boolean flag=false;
                    while(table.next()){
                        cod = table.getString(1);
                        if(usCod.equals(cod)){
                            sql_save="UPDATE convoUsuario SET estado=true WHERE codigo= "+usCod+" AND cedula = '"+us.getCedula()+"'";
                            statement.executeUpdate(sql_save);
                            flag=true;
                            break;
                        }
                    }
                    if(!flag){
                        sql_save = "INSERT INTO convoUsuario VALUES('"+us.getCedula() +"', "+ usCod +", true )";
                        statement.executeUpdate(sql_save);
                    }
                }
            }
        }
        catch(SQLException e){
            System.out.println(e); 
            return -2;
        }
        catch(Exception e){ 
            System.out.println(e);
            return -1;
        }
        return 1;
    }//fin updateUser

   /**
     * listar todas las tuplas de los usuarios existentes.
     * @return los objetos tipo Usuario enlistados en un arreglo.
     */ 
   public Usuario[] listUsers(){
        
        String sql_select;
        sql_select="SELECT usuario.cedula, usuario.name, usuario.lastName,usuario.userName, usuario.contrasena, usuario.email ,  perfiles.nombre, usuario.estado FROM  usuario, perfiles WHERE usuario.id_perfil=perfiles.id_perfil";
        try{
            System.out.println("consultando en la bd");
            Statement statement = conn.createStatement();
            ResultSet table = statement.executeQuery(sql_select);
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
            String sql_conv="";
            int j=0;
            while(table2.next()){
                
                us[j].setCedula(table.getString(1));
               
                us[j].setName(table.getString(2));
                
                us[j].setLastName(table.getString(3));
                
                us[j].setUserName(table.getString(4));               

                us[j].setPassword(table.getString(5));

                us[j].setMail(table.getString(6));
 
                us[j].setProfile(table.getString(7));
                
                us[j].setState(table.getBoolean(8));
                
                if(!us[j].getProfile().equals("Administrador")){
                    sql_conv= "SELECT convocatoria.nombre FROM convoUsuario, convocatoria WHERE cedula='"+us[j].getCedula() +"' AND estado=true AND convoUsuario.codigo=convocatoria.codigo";
                    ResultSet table3= statement.executeQuery(sql_conv);
                    String cod="";
                    while(table3.next()){
                
                        cod = table3.getString(1);
              
                        //System.out.println("ok");
                    }
                    DAOConvocatoria daoc=new DAOConvocatoria(conn);
                    Convocatoria conv = daoc.readConv(cod);
                    us[j].setConvocatoria(conv);
                }


                j++;
                System.out.println("ok");
            }
           
            return us;
         }
         catch(SQLException e){ System.out.println(e); }
         catch(Exception e){ System.out.println(e); }
        return null;
    }
   /**
    * borrar un usuario de la tabla.
    * @param cedula la cedula del usuario que se quiere borrar.
    */
    public int deleteUser(String cedula){	
		String sql_save;

        sql_save="DELETE FROM usuario WHERE cedula='" + cedula + "'";
        try{
            Statement sentencia = conn.createStatement();

            sentencia.executeUpdate(sql_save);            
            
        }
        catch(SQLException e){
            System.out.println(e); 
            return -1;
            }
        catch(Exception e){ 
            System.out.println(e);
            return -2;
        }
        return 1;
    }
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }


}
