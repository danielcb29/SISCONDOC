/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import proceso.*;
import almacenamiento.accesodatos.*;
import java.sql.Connection;

/**
 *
 * @author Fernando
 */

public class UserController {
    

    DAOUser daoUser;
    ConvocatoriaController convocatoriaController;

    
    /**
     * constructor
     * **/
    public UserController(){
        daoUser=new DAOUser();
        convocatoriaController = new ConvocatoriaController(daoUser.getConn());
    }
    public void connectDB(){
        daoUser.connectDB();
    }
    public Connection getConn(){
        return daoUser.getConn();
    }
     /**
     * metodo encargado de pasar el usuario a ingresar a la base de
     * satos al DAOusuario. 
     * @param id: cedula del empleado
     * @param name: nombre del empleado
     * @param lastname : apellido del usuario
     * @param username: nombre de usuario del empleado 
     * @param password: contraseña de usuario del empleado
     * @param email: email del empleado
     * @param perfil: id del perfil que se le va a otorgar al empleado 
     * @return result: 0 si no fue posible crear el usuario.
     * @return result: 1 si se creo satisfactoriamente el usuario.
     * **/
    public int   createUser (String id, String  name, String lastname ,String username, String password, String email, String perfil,Convocatoria call)
    {
        //System.out.println(convocatoria.getName());
        Usuario U = new Usuario(name,lastname,username,password,email,perfil,id,call);        
        
        //Se llama al dao para guardar
        int result =daoUser.createUser(U);
        //int result = 0;
        return result;

    }
    /**
     * metodo encargado de pasar el username a Dao para que consulte si el 
     * usuario existe
     * @param username : nombre de usuario del empleado
     * @return Usuario : objeto con los atributos del empleado
     * es objeto es nulo en caso de no existir el usuario.
     */
    public Usuario   consultUser (String username, int tipoCon){
        Usuario U = new Usuario ();
        System.out.println("entramos al control");
        U= daoUser.readUser(username, tipoCon);
        
        return U;

    }
    
 
     
    /** metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
    public int countUsers ()  
    {
        Usuario [] users = new Usuario [5];
        int size =  users.length;
        return size;
                
    }
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoUser.closeConectionDB();
    }

    public int editUser(String cedula, String name, String lastName, String userName, String password, String email, String perfil, Convocatoria convo,boolean estado) {
        int result;
        result = 0;
        Usuario user = new Usuario(name,lastName,userName,password,email,perfil,cedula,convo);
        user.setState(estado);
        result = daoUser.updateUser(user, cedula);

        return result;
    }

    public int deleteUser(String text) {
        return daoUser.deleteUser(text);
    }

}//fin clase

