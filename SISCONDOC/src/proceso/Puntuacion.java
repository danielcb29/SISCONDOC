/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package proceso;

/**
 *
 * @author daniel
 */
public class Puntuacion {
    Aspirante appliant;
    public Puntuacion(Aspirante toRate){
        appliant = toRate; 
    }
    
    public Aspirante qualify(){
        double score = 0;
        Aspirante appliantPointed = appliant;
        Formacion[] form = appliant.getFormaciones();
        FormadorTIC[] exp = appliant.getFormadores();
        CEspecifico cEsp= appliant.getConocimientos();
        
        int formPoint = qualifyFormacion(form);
        int expPoint = qualifyExperience(exp);
        double cEspPoint= qualifyCEspecifico(cEsp);
        
        score = formPoint + expPoint+ cEspPoint;
        appliantPointed.setPuntaje(score);
        return appliantPointed;
        
    }

    private int qualifyFormacion(Formacion[] form) {
        int len = form.length;
        System.out.println("tamano de formacion !!!  "+len);
        int point = 0;
        loop : for (int i=0 ; i< len ; i++){
            String level = form[i].getLevel();
            switch(level){
                case "Licenciado": 
                    point = 10;
                    break;
                case "Especializacion":
                    point = 15;
                    break;
                case "EspecializacionTIC" :
                    point = 20;
                    break;
                case "Maestria" :
                    point = 24;
                    break;
                case "MaestriaTIC": 
                    point = 26;
                    break;
                case "Doctorado":
                    point = 28;
                    break;
                case "DoctoradoTIC":
                    point = 30;
                    break loop;
                    
            }
             
        }
        System.out.println("Resultado de formacion !! "+point);
        return point;
        
    }
    
    private int qualifyExperience(FormadorTIC[] exp) {
        int len = exp.length;
        System.out.println("tamano de experiencia !!!  "+len);
        int point =0;
        for(int i =0 ; i<len;i++){
            int subPoint = qualifyExperienceCondition(exp[i]);
            point+=subPoint;
        }
        System.out.println("Resultado de experiencia !! "+point);
                
        return point;
    }
    
    private int qualifyExperienceCondition(FormadorTIC form){
        int subPoint = 0;
        int time = form.getTime();
        String people = form.getPeople();
        switch (people){
            case "Estudiantes" : 
                subPoint = qualifyExperienceEstud(time);
                break;
            case "Profesores" : 
                subPoint = qualifyExperienceProf(time);
                break;
            case "Formadores":
                subPoint = qualifyExperienceForm(time);
                break;
        }
        
        return subPoint;       
    }
 
    //revisar inclusion en los rangos
    private int qualifyExperienceEstud(int time) {
        System.out.println("Entramos a estu");
        int subPoint = 0;
        if(time >= 1 && time <= 2){
            //rango de 1 a dos a;os
            //System.out.println("deberia entrar estudiante a aqui");
            subPoint = 2;
        }else{
            if(time >2 && time <= 3){
                //rango de 1 a 2 a;os
                subPoint = 3;
            }else{
                if(time >3 && time <=5){
                    //ranto de 3 a 5 a;os
                    subPoint = 4;
                }else{
                    //rango de mas 5 a;os
                    subPoint = 5;
                    
                }
            }
        }
        System.out.println("punto del estu-- "+subPoint);
        return subPoint;
    }

    private int qualifyExperienceProf(int time) {
        System.out.println("Entramos a prof");
        int subPoint =0;
        if(time >= 80 && time <= 200){
            //rengo de 80 a 200 horas
            subPoint =5;
        }else{
            if(time > 200 && time <=300){
                //rango de 200 a 300 horas 
                subPoint =10;
            }else{
                if(time > 300 && time <= 450){
                    //rango de 300 a 450 horas
                    subPoint =15;
                }else{
                    //rango mas de 450 horas
                    subPoint =20;
                }
            }
        }
        System.out.println("Punto del profe -- "+subPoint);
        return subPoint;
    }

    private int qualifyExperienceForm(int time) {
        System.out.println("Entramos a form");
        int subPoint =0;
        if(time >= 80 && time <= 120){
            //rango de 80 a 120 horas
            subPoint =3;
        }else{
            //rango mas de 120 horas
            subPoint =5;
        }
        System.out.println("Punto del form-- "+subPoint);
        return subPoint;
    }
    /**
     * 
     * @param CEspecifico el objeto CEspecifico al cual se le va a sacar la puntuacion.
     * @return puntuacion a asignar por este campo.
     */
    private double qualifyCEspecifico(CEspecifico objCE){
        System.out.println("Entramos a CEsp");
        double point=0;
        String topicToQ="";//Este es el tema a calificar, dependiendo de la numero de ciclo
        for(int i=0;i<8;i++){
            switch(i){
                case 0: 
                    topicToQ=objCE.getOfimaticas();
                    break;
                case 1: 
                    topicToQ=objCE.getWeb2();
                    break;
                case 2: 
                    topicToQ=objCE.getEducaDig();
                    break;
                case 3: 
                    topicToQ=objCE.getMultimedia();
                    break;
                case 4: 
                    topicToQ=objCE.getElearning();
                    break;
                case 5: 
                    topicToQ=objCE.getProyeTIC();
                    break;
                case 6: 
                    topicToQ=objCE.getAssessCompe();
                    break;                    
                case 7: 
                    topicToQ=objCE.getDigBook();
                    break;                                        
            }
            switch(topicToQ){
                case "Regular":
                    point+=0.7;
                    break;
                case "Bueno":
                    point+=1.3;
                    break;
                case "Muy Bueno":
                    point+=2.5;
                    break;                    
            }
        }
        return point;
    }
}
