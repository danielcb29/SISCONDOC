/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author daniel
 */
public class DAOReporte {
    private BaseDatos db;
    private Connection conn;
    public DAOReporte(Connection connect){
        conn = connect;
        db = new BaseDatos();
    }
    
    /**
     * Metodo para consultar los 5 mejores seleccionados
     * @param codigoConvocatoria: convocatoria a consultar seleccionador
     * @return matriz con los datos de los 5 mejores seleccionados
     */
    public String[][] cincoMejores(int codigoConvocatoria){
        String sql = "SELECT nombre,apellido,cedula,municipio FROM Aspirante WHERE codigo = "+codigoConvocatoria+" AND puntuacion >= 50 ORDER BY puntuacion LIMIT 5";
        String[][] resultado = new String[5][4];
        try {
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet table = sentencia.executeQuery(sql);
            int i = 0;
            while(table.next()){
                resultado[i][0] = table.getString(1);
                System.out.println("Nombre:"+resultado[i][0]+"\n");
                resultado[i][1] = table.getString(2);
                System.out.println("Apellido:"+resultado[i][1]+"\n");
                resultado[i][2] = table.getString(3);
                System.out.println("Cedula:"+resultado[i][2]+"\n");
                resultado[i][3] = table.getString(4);
                System.out.println("Municipio:"+resultado[i][3]+"\n");
                i++;
                        
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
        
    }
    public String[][] totalPorJornada(int codigoConvocatoria){
       String[][] resultado = new String[3][2];
       String sql = "SELECT jornada, count(*) FROM Aspirante WHERE codigo=1 GROUP BY jornada;";
        try {
            
                Statement sentencia = conn.createStatement();
                ResultSet table = sentencia.executeQuery(sql);
                int i = 0;
                while(table.next()){
                    resultado[i][0] = table.getString(1);
                    System.out.println("Jornada:"+resultado[i][0]+"\n");
                    resultado[i][1] = table.getString(2);
                    System.out.println("Total:"+resultado[i][1]+"\n");
                    i++;
                            
                }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    /**
     * cerrar la conexion con la base de datos.
     */
    public void closeConectionDB(){
        db.closeConection(db.getConnetion());
    }
}
