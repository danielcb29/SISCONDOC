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
    public UserController(){
        daoUser=new DAOUser();
    }
    
    /**
     *  @param id: cedula del empleado
     * @param name: nombre del empleado
     * @param username: nombre de usuario del empleado 
     * @param password: contraseña de usuario del empleado
     * @param email: email del empleado
     * @param perfil: perfil que se le va a otorgar al empleado 
     * @return result: 0 si no fue posible crear el usuario.
     * @return result: 1 si se creo satisfactoriamente el usario.
     * **/
    public int   createUser (String id, String  name, String lastname ,String username, String password, String email, String perfil ){
        Usuario U = new Usuario(name,lastname,username,password,email,perfil,id);        
        
        //Se llama al dao para guardar
        int result =daoUser.createUser(U);
        return result;

    }

    public Usuario   consultUser (String username){
        Usuario U = new Usuario ();
        
        U= daoUser.readUser(username);
        return  U;
    }
   

}//fin clase

