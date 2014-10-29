/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;
import proceso.*;
import almacenamiento.accesodatos.*;

/**
 *
 * @author Fernando
 */

public class UserController {
    

    DAOUser daoUser;

    
    /**
     * constructor
     * **/
    public UserController()
    {
      daoUser=new DAOUser() ;
      
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
     * @param perfil: id del perfil que se le va a otorgar al empleado.
     * @return 1 si se creo satisfactoriamente el usuario.
     *         -2 si se ingresa una cedula que ya se encuentra en la BD
     *         -1 si ocurre un error.
     * **/
    public int   createUser (String id, String  name, String lastname ,String username, String password, String email, String perfil ){
        Usuario U = new Usuario(name,lastname,username,password,email,perfil,id);        
        
        //Se llama al dao para guardar
        int result =daoUser.createUser(U);
        return result;

    }
    /**
     * metodo encargado de pasar el username a Dao para que consulte si el 
     * usuario existe
     * @param username : nombre de usuario del empleado
     * @return Usuario : objeto con los atributos del empleado
     * es objeto es nulo en caso de no existir el usuario.
     */
    public Usuario   consultUser (String username){
        Usuario U = new Usuario ();
        //llamado para consultar el usuario  al DAOUsuaurio
        U= daoUser.readUser(username);
        return  U;
    }
    
    /**
     * metodo que llama al Dao para consultar cuantos usuarios existen
     * @return cantidad de usuarios existentes en la base de datos
     */
    public int countUsers ()  
    {
        Usuario [] users = new Usuario [5];
        int size =  users.length;
        return size;
                
    }
    
      public void cerrarConexionBD(){
        daoUser.closeConectionDB();
    }
   
}//fin clase