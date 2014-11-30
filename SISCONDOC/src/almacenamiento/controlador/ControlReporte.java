/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package almacenamiento.controlador;

import almacenamiento.accesodatos.DAOReporte;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class ControlReporte {
    private DAOReporte daoRepor;
    private int codigoConvo;
    
    public ControlReporte(Connection conn,int codigoConvocatoria){
        daoRepor = new DAOReporte(conn);
        codigoConvo = codigoConvocatoria;
    }
    /**
     * Metodo que permite consultar los 5 mejores seleccionados
     * @return Resultado
     */
    public String[][] cincoMejores(){
        String[][] consulta = daoRepor.cincoMejores(codigoConvo);
        if(consulta[0][0] == null){
            return null;
        }
        return consulta;
    }
    public String[][] totalPorJornada(){
        String[][] consulta = daoRepor.totalPorJornada(codigoConvo);
        if(consulta[0][0] == null){
            return null;
        }
        return consulta;
    }
    
    
    public int numSeleccionados(){
        int consulta;
        consulta=daoRepor.numSeleccionados(codigoConvo);
        return consulta;
    }
    
    public String[][] seleccionados(){
        String[][] consulta=daoRepor.seleccionados(codigoConvo);
        if(consulta[0][0]==null){
            return null;
        }
        return consulta;
    }
    
    public int hombresInscritos(){
        int consulta=0;
        consulta=daoRepor.hombresInscritos(codigoConvo);
        return consulta;
    }
    
    public int mujeresInscritas(){
        int consulta=0;
        consulta=daoRepor.mujeresInscritas(codigoConvo);
        return consulta;
    }
    
    
    /*
     * Cerrar conexion base de datos
     */
    public void cerrarConexionBD(){
        daoRepor.closeConectionDB();
    }
    
       /**
     * Metodo que permite consultar los aspirantes ordenados por puntacion
     * @return Resultado
     */
    public String[][] listadoAsp(){
        ArrayList< ArrayList<String>>  consultaPrev = daoRepor.listadoAspi(codigoConvo);
        String[][] consulta= new String[consultaPrev.size()][4];
        for(int i=0; i<consultaPrev.size(); i++){
            for(int j = 0; j<4; j++){
                consulta[i][j]= consultaPrev.get(i).get(j);
            }
            
        }
        if(consultaPrev.get(0).get(0) == null){
            return null;
        }
        return consulta;
    }
    
    
    public String[][] conteoMunic(){
        ArrayList< ArrayList<String>>  consultaPrev = daoRepor.conteoMunicipio(codigoConvo);
        String[][] consulta= new String[consultaPrev.size()][2];
        for(int i=0; i<consultaPrev.size(); i++){
            for(int j = 0; j<2; j++){
                consulta[i][j]= consultaPrev.get(i).get(j);
            }
            
        }
        if(consultaPrev.get(0).get(0) == null){
            return null;
        }
        return consulta;
    }
}
