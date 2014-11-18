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
    /**
     * Constructor vacio , sin funcion por ahora
     */
    public Puntuacion(){
        
    }
    /**
     * Constructor , requiere de un aspirante para funcionar
     * @param toRate : aspirante a calificar
     */
    public Puntuacion(Aspirante toRate){
        appliant = toRate; 
    }
    /**
     * Metodo que califica al aspirante ingresado por constructor
     * @return Aspirante con su calificacion asignada 
     */
    public Aspirante qualify(){
        double score = 0;
        Aspirante appliantPointed = appliant;
        Formacion[] form = appliant.getFormaciones();
        FormadorTIC[] exp = appliant.getFormadores();
        CEspecifico cEsp= appliant.getConocimientos();
        Idioma [] idiom = appliant.getIdiomas();
        
        int formPoint = qualifyFormacion(form);
        int expPoint = qualifyExperience(exp);
        double cEspPoint= qualifyCEspecifico(cEsp);
        double idiomPoint = qualifyIdiomas(idiom);
        
        score = formPoint + expPoint+ cEspPoint+idiomPoint;
        appliantPointed.setPuntaje(score);
        return appliantPointed;
        
    }
    /**
    * Metodo que permite calificar la formacion del aspirante
    * @param form: arreglo de formaciones del aspirante 
    * @return puntuacion asignada de acuerdo a la formacion mas alta que tenga el aspirante
    */
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
    /**
     * Metodo que permite calificar la experiencia de un aspirante , la experiencia significa las horas que ha ensenado cursos sobre TIC
     * @param exp : arreglo de FormadorTIC que contiene los parametros de su experiencia como formador de TIC
     * @return Puntuacion asignada de acuerdo a las horas ensenadas y las personas ensenadas 
     */
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
    /**
     * Metodo auxiliar que permite mirar la condicion de las personas formadas de un objeto FormadorTIC
     * @param form: objeto FormadorTIC que contiene la informacion de un grupo de personas formadas y el rango de horas
     * @return punto asignado a ese objeto en particular
     */
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
 
    /**
     * Metodo auxiliar que permite calificar los rangos de horas ensenadas a un grupo de estudiantes
     * @param time : tiempo de ensenanza : experiencia
     * @return puntaje asignado de acuerdo a las horas dedicadas a la formacion de estudiantes
     */
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
    /**
     * Metodo auxiliar que permite calificar los rangos de horas ensenadas a un grupo de profesores
     * @param time : tiempo de ensenanza : experiencia
     * @return puntaje asignado de acuerdo a las horas dedicadas a la formacion de profesores
     */
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
    /**
     * Metodo auxiliar que permite calificar los rangos de horas ensenadas a un grupo de formadores de tic
     * @param time : tiempo de ensenanza : experiencia
     * @return puntaje asignado de acuerdo a las horas dedicadas a la formacion de formadores de tic
     */
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
    
    
    /**
     * @author alvaro
     * Metodo que califica un listado de idiomas y retorna la puntuacion mayor 
     * @param idiom listado de idiomas
     * @return point con el puntaje (0-10)
     */
    private double qualifyIdiomas(Idioma[] idiom){
        
        double pointM, pointC;
        pointC = pointM = 0;
        // Recorriendo la lista contando los idiomas
        for(int i=0; i<idiom.length; i++){
             if(idiom[i].getState()){
                 pointC = qualifyIdioma(idiom[i]);
                 if(pointC>pointM){
                     pointM=pointC;
                 }
                 
             }
        }
        
        return pointM;
    }
    
    
    /**
     * @author alvaro
     * Metodo que permite calificar un idioma en especifico
     * @param idiom idioma a calificar
     * @return puntaje obtenido por el idioma
     */
    private double qualifyIdioma(Idioma idiom){
        double point;
        point = 0;
        String categ;
        categ = "";
        for (int i = 1; i < 4; i++) {
            switch (i) { // se hace para cada nivel
                case 1:
                    categ = idiom.getNivelescribe();
                    break;
                case 2:
                    categ = idiom.getNivellee();
                    break;
                case 3:
                    categ = idiom.getNivelhabla();
                    break;
            }
            switch (categ) { // calificacion del nivel
                case "Regular":
                    if ((i == 2) || (i == 1)) {
                        point += 0.8;
                    } else {
                        point += 1;
                    }
                    break;
                case "Bueno":
                    if ((i == 2) || (i == 1)) {
                        point += 1.5;
                    } else {
                        point += 2;
                    }
                    break;
                case "Muy Bueno":
                    if ((i == 2) || (i == 1)) {
                        point += 3;
                    } else {
                        point += 4;
                    }
                    break;

            }
        }
                
        
        
        return point;
    }
    
    /**
     * Metodo de prueba de calificacion de un idioma
     */
    public void pruebaQualIdiom(String lenguaje, String lee, String escribe, String habla, String path, boolean state){
        
        Idioma idiom = new Idioma(lenguaje, lee, escribe, habla, path, state);
        System.out.println("Calificacion del lenguaje"+qualifyIdioma(idiom));
        
    }
    
    /**
     * Metodo para probar la calificacion de varios idiomas
     */
    public void pruebaQualIdioms(){
        Idioma idiom1 = new Idioma("Ingles", "Bueno", "Muy Bueno", "Muy Bueno", "Muy Bueno", true);
        Idioma idiom4 = new Idioma("Frances", "Muy Bueno", "Muy Bueno", "Muy Bueno", "Muy Bueno", false);
        Idioma idiom2 = new Idioma("Aleman", "Bueno", "Regular", "Muy Bueno", "Muy Bueno", true);
        Idioma idiom3 = new Idioma("Portugues", "Regular", "Muy Bueno", "Bueno", "Muy Bueno", true);
        
        Idioma[] idioma= new Idioma[4];
        idioma[0]= idiom1;
        idioma[1]= idiom2;
        idioma[2]= idiom3;
        idioma[3]= idiom4;
        
        System.out.println("Mayor puntaje"+qualifyIdiomas(idioma));
    }

    
}
