package almacenamiento.accesodatos;
import java.sql.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniel
<<<<<<< HEAD
 * Nombre de la base de datos : SISCONDOC
=======
 * Nombre de la base de datos : clinicaDB
>>>>>>> 56c654460aee9dc025726851cecd05750f2bb6ca
 */
public class BaseDatos {
     private String url, usuario, password;
     private Connection conexion =null;
     private Statement instruccion;
     private ResultSet tabla; 
     BaseDatos(){
<<<<<<< HEAD
      url = "jdbc:postgresql://localhost/SISCONDOC";
=======
      url = "jdbc:postgresql://localhost:5432/SISCONDOC";
>>>>>>> 56c654460aee9dc025726851cecd05750f2bb6ca
      usuario="danielcb";
      password="1144067772";
      
    }
    public Connection conectar(){
<<<<<<< HEAD
            //System.out.println("Entro metodo");
            try {
            // Se carga el driver
              //Class.forName("PostgreSQL");
            Class.forName("org.postgresql.Driver");
            //Class.forName("/home/daniel/Documents/Work/GitProjects/SISCONDOC/postgresql-9.0-801.jdbc3.jar");
=======
            System.out.println("Entro metodo");
            try {
            // Se carga el driver
            //Class.forName("org.postgresql.Driver");postgresql-9.0-801.jdbc3.jar
            Class.forName("/home/daniel/Documents/Work/GitProjects/SISCONDOC/postgresql-9.0-801.jdbc3.jar");
>>>>>>> 56c654460aee9dc025726851cecd05750f2bb6ca
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
