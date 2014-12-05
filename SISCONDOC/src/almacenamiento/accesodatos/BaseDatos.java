package almacenamiento.accesodatos;
import java.sql.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
 * Nombre de la base de datos : SISCONDOC
 */
public class BaseDatos {
     private String url, usuario, password;
     private Connection conexion =null;
     private Statement instruccion;
     private ResultSet tabla; 
     BaseDatos(){
      url = "jdbc:postgresql://localhost:5432/bdbrayan";
      usuario="brayanrod";
      password="bryan1112";
      
    }
    public Connection conectar(){
            //System.out.println("Entro metodo");
            try {
            // Se carga el driver
              //Class.forName("PostgreSQL");
            Class.forName("org.postgresql.Driver");
            //Class.forName("/home/daniel/Documents/Work/GitProjects/SISCONDOC/postgresql-9.0-801.jdbc3.jar");
            System.out.println( "Driver Cargado" );
            } catch( Exception e ) {
                System.out.println( "No se pudo cargar el driver." );
            }

            try{
                     //Crear el objeto de conexion a la base de datos
                     conexion = DriverManager.getConnection(url, usuario, password);
                     System.out.println( "Conexion Abierta" );
                     return conexion;
                  //Crear objeto Statement para realizar queries a la base de datos
             } catch( Exception e ) {
                System.out.println( "No se pudo abrir la bd." );
                return null;
             }

        }
    
    public Connection getConnetion(){
            if (conexion == null) {
                return this.conectar();
            }
            else{
                  return conexion;      
            }
            
        }
        
        public void closeConection(Connection c){
            try{
                if (conexion != null){
                    c.close();
                }
                 
            } catch( Exception e ) {
                System.out.println( "No se pudo cerrar." );
            }
        }
        
}
