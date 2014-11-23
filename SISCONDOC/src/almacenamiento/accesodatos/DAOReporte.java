/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.accesodatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String sql = "SELECT nombre,apellido,cedula,municipio FROM Aspirante WHERE codigo = "+codigoConvocatoria+" AND puntuacion >= 50 ORDER BY puntuacion DESC LIMIT 5";
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
    
    /**
     * Metodo para consultar los seleccionados por orden de puntaje
     * @param codigoConvocatoria: convocatoria a consultar seleccionador
     * @return matriz con los datos de los aspirantes ordenados por puntuacion 
     */
    public ArrayList<ArrayList<String>> listadoAspi(int codigoConvocatoria){
        String sql = "SELECT nombre,apellido,cedula,municipio FROM Aspirante WHERE codigo = "+codigoConvocatoria+" ORDER BY puntuacion DESC";
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
        try {
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet table = sentencia.executeQuery(sql);
            int i = 0;
            
            while(table.next()){
                resultado.add(new ArrayList<String>()); 
                resultado.get(i).add(table.getString(1));
                System.out.println("Nombre:"+resultado.get(i).get(0)+"\n");
                resultado.get(i).add(table.getString(2));
                System.out.println("Apellido:"+resultado.get(i).get(1)+"\n");
                resultado.get(i).add(table.getString(3));
                System.out.println("Cedula:"+resultado.get(i).get(2)+"\n");
                resultado.get(i).add(table.getString(4));
                System.out.println("Municipio:"+resultado.get(i).get(3)+"\n");
                i++;
                                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
        
    }
    
    
    /**
     * Metodo para consultar el numero de aspirantes inscritos por municipio
     * @param codigoConvocatoria convocatoria a consultar seleccionador
     * @return  matriz con los aspirantes contador por municipio  
     */
    public ArrayList<ArrayList<String>> conteoMunicipio(int codigoConvocatoria){
        
        String sql = "SELECT municipio, count(*) from aspirante WHERE codigo = "+codigoConvocatoria+"GROUP BY municipio";
        ArrayList<ArrayList<String>> resultado = new ArrayList<>();
         try {
            System.out.println("consultando en la bd");
            Statement sentencia = conn.createStatement();
            ResultSet table = sentencia.executeQuery(sql);
            int i = 0;
            
            while(table.next()){ 
                resultado.add(new ArrayList<String>());
                resultado.get(i).add(table.getString(1));
                System.out.println("Municipio:"+resultado.get(i).get(0) +"\n");
                resultado.get(i).add(table.getString(2));
                System.out.println("Conteo:"+resultado.get(i).get(1) +"\n");
                i++;                       
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOReporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return resultado;
    }
}
