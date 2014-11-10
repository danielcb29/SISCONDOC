/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

/**
 *
 * @author USUARIO
 */
public class Validador {
    
    public Validador(){
        
    }
    
    public int ValidaVacios(String cadena){
        int bandera=1;
        if (cadena.length()==0){
            bandera=0;
        }else{
            bandera=1;
        }
        return bandera;
    }
    
    public int ValidaSoloLetra(String prueba){
       /* int bandera=1;
        char ejemplo='0';
        int valorAscii=0;
        int longitud=prueba.length();
        int i=0;
        while((i+1<=longitud)&&(bandera==1)){
                        valorAscii=0;
                        ejemplo=prueba[i];
                        valorAscii=Integer.parse(ejemplo);
                        if (!(((valorAscii>=65)&&(valorAscii<=90))||((valorAscii>=97)&&(valorAscii<=122)))){
                                bandera=0;
                        }
                        i++;
                }*/
                return 0;
    }
    
}
