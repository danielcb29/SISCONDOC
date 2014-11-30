/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import almacenamiento.controlador.*;
import proceso.*;
import almacenamiento.controlador.ConvocatoriaController;
import proceso.Convocatoria;
import java.sql.Connection;
import almacenamiento.controlador.UserController;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.StandardCopyOption;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import javax.swing.ButtonModel;
import java.util.Vector;

/**
 *
 * @author USUARIO
 */
public class PanelValidaAspirante extends javax.swing.JFrame {
    String coorname;
    /*OBJETOS DE OTRAS CLASES*/
    public ControlAspirante objAspirantController;
    public Convocatoria objConvocatoria;
    public Connection Conexion;
    public Aspirante Aspirante;
    boolean estadoLicenciado,estadoEspecializacion,estadoEspecializacionTic,
    estadoMaestria,estadoMaestriaTic,estadoDoctorado,estadoDoctoradoTic,
    estadoFormacion,estadoIdioma,estadoFormEstudiantes, estadoFormProfesores,estadoFormFormadores;
    int firstForm,firstIdiom = 0;
    
    
    /*Constructor*/
    public PanelValidaAspirante() {
    }
    
    public PanelValidaAspirante(String username,Aspirante aspirante, Connection conn){
        estadoLicenciado = true; estadoEspecializacion = true;
        estadoEspecializacionTic = true; estadoMaestria  = true;
        estadoMaestriaTic = true; estadoDoctorado = true; 
        estadoDoctoradoTic = true; estadoFormacion = true;
        estadoIdioma = true; estadoFormEstudiantes = true;  
        estadoFormProfesores = true; estadoFormFormadores = true;
        Conexion=conn;
        objAspirantController = new ControlAspirante (Conexion);
        initComponents();
        System.out.println("panel");
        coorname=username;
        this.Aspirante=aspirante;
        labelForTicmsj.setVisible(false);
        jLabelidiomamsj.setVisible(false);
        WelcomeLabel.setText("¡Bienvenido "+coorname+"!");
        jLabelWelcome2.setText("A continuacion se presenta los datos del aspirante: "+Aspirante.getName()
                                                                                 +" "+Aspirante.getLastname());
        LabelConfirmacion.setText("Desea Validar datos del Aspirante: "+Aspirante.getName()
                                                                   +" "+Aspirante.getLastname()+" ?");
        /**
         * Cargamos los datos de formacion
         */
        for(int i=0; i<Aspirante.getFormaciones().length; i++){
        switch(Aspirante.getFormaciones()[i].getLevel()){
            case "Licenciado":  jTextLicUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break ;
            case "Especializacion":   jTextEspeUrl.setText(Aspirante.getFormaciones()[i].getPathFile()) ; break;
            case "EspecializacionTIC":   jTextEspeTicUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break;
            case "Maestria" :   jTextMaesUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break;
            case "MaestriaTIC" :   jTextMaesTicUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break;
            case "Doctorado":   jTextDocUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break;
            case "DoctoradoTIC":   jTextDocTicUrl.setText(Aspirante.getFormaciones()[i].getPathFile()); break;            
        }
        }
        /**
         * Cargamos los datos de formacion TIC
         */
        //Aspirante.setFormacionesTic(aspirante.getFormacionesTic());
        for(int j=0;j<Aspirante.getFormacionesTic().length;j++){
            jComboFormacionTic.addItem(j+". "+Aspirante.getFormacionesTic()[j].getTitulo());
        }
        
        /**
        * Cargamos los datos de Idiomas
        */
        for(int j=0;j<Aspirante.getIdiomas().length;j++){
            ComboIdioma.addItem(j+". "+aspirante.getIdiomas()[j].getLenguaje());
        }
        
        /**
         * Cargamos los datos de Experiencia:
         */
        for(int i=0; i<Aspirante.getFormadores().length; i++){
        switch(Aspirante.getFormadores()[i].getPeople()){
            case "Estudiantes":  lbForEst.setText(""+Aspirante.getFormadores()[i].getTime());break ;
            case "Profesores":   lbForProf.setText(""+Aspirante.getFormadores()[i].getTime());break;
            case "Formadores":   lbForFor.setText(""+Aspirante.getFormadores()[i].getTime());break;
        }
        }
        
        
       /* lbCurso.setText(Aspirante.getCity());
        jTextCursoUrl.setText(Aspirante.getFormacionesTic()[0].getUrl_soporte());
        lbInstitucion.setText(Aspirante.getFormacionesTic()[0].getInstitucion());
        lbCurso.setText(Aspirante.getFormacionesTic()[0].getTitulo());
        lbHoras.setText(""+Aspirante.getFormacionesTic()[0].getHoras());   */             
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        buttonGroup12 = new javax.swing.ButtonGroup();
        buttonGroup13 = new javax.swing.ButtonGroup();
        buttonGroup14 = new javax.swing.ButtonGroup();
        buttonGroup15 = new javax.swing.ButtonGroup();
        buttonGroup16 = new javax.swing.ButtonGroup();
        buttonGroup17 = new javax.swing.ButtonGroup();
        buttonGroup18 = new javax.swing.ButtonGroup();
        buttonGroup19 = new javax.swing.ButtonGroup();
        buttonGroup20 = new javax.swing.ButtonGroup();
        jTabbedDigitador = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        btAbrirLic = new javax.swing.JButton();
        btAbrirEspe = new javax.swing.JButton();
        btAbrirEspeTic = new javax.swing.JButton();
        btAbrirMaes = new javax.swing.JButton();
        btAbrirMaesTic = new javax.swing.JButton();
        btAbrirDoc = new javax.swing.JButton();
        btAbrirDocTic = new javax.swing.JButton();
        jLabelLicUrl = new javax.swing.JLabel();
        jTextLicUrl = new javax.swing.JLabel();
        jTextEspeUrl = new javax.swing.JLabel();
        jTextEspeTicUrl = new javax.swing.JLabel();
        jTextMaesUrl = new javax.swing.JLabel();
        jTextMaesTicUrl = new javax.swing.JLabel();
        jTextDocUrl = new javax.swing.JLabel();
        jTextDocTicUrl = new javax.swing.JLabel();
        btAbrirLic1 = new javax.swing.JButton();
        rbtLic1 = new javax.swing.JRadioButton();
        rbtLic2 = new javax.swing.JRadioButton();
        rbtEspe1 = new javax.swing.JRadioButton();
        rbtEspe2 = new javax.swing.JRadioButton();
        rbtEspeTic1 = new javax.swing.JRadioButton();
        rbtEspeTic2 = new javax.swing.JRadioButton();
        rbtMaes1 = new javax.swing.JRadioButton();
        rbtMaes2 = new javax.swing.JRadioButton();
        rbtMaesTic1 = new javax.swing.JRadioButton();
        rbtMaesTic2 = new javax.swing.JRadioButton();
        rbtDoc1 = new javax.swing.JRadioButton();
        rbtDoc2 = new javax.swing.JRadioButton();
        rbtDocTic1 = new javax.swing.JRadioButton();
        rbtDocTic2 = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextCursoUrl = new javax.swing.JLabel();
        btAbrirFormacionTic = new javax.swing.JButton();
        btMasCursos = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        btAgregarForTicActual = new javax.swing.JButton();
        labelForTicmsj = new javax.swing.JLabel();
        jComboFormacionTic = new javax.swing.JComboBox();
        jRadioButton17 = new javax.swing.JRadioButton();
        jRadioButton18 = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        lbCurso = new javax.swing.JLabel();
        lbInstitucion = new javax.swing.JLabel();
        lbHoras = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextEscribe = new javax.swing.JLabel();
        btSubirIdioma = new javax.swing.JButton();
        btAgregarIdioma = new javax.swing.JButton();
        btAgregarActualIdioma = new javax.swing.JButton();
        jLabelidiomamsj = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        ComboIdioma = new javax.swing.JComboBox();
        jTextIdiomaUrl = new javax.swing.JLabel();
        jTextLee = new javax.swing.JLabel();
        jTextHabla = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jTextEstudiantesUrl = new javax.swing.JLabel();
        jTextProfesoresUrl = new javax.swing.JLabel();
        jTextformadoresUrl = new javax.swing.JLabel();
        btAbrirEstudiantes = new javax.swing.JButton();
        btAbrirProfes = new javax.swing.JButton();
        btAbrirFormadores = new javax.swing.JButton();
        lbForProf = new javax.swing.JLabel();
        lbForFor = new javax.swing.JLabel();
        jRadioButton19 = new javax.swing.JRadioButton();
        rbtForEst = new javax.swing.JRadioButton();
        jRadioButton21 = new javax.swing.JRadioButton();
        rbtForPro = new javax.swing.JRadioButton();
        jRadioButton23 = new javax.swing.JRadioButton();
        rbtForFor = new javax.swing.JRadioButton();
        lbForEst = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        LabelConfirmacion = new javax.swing.JLabel();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonCancelar = new javax.swing.JButton();
        WelcomeLabel = new javax.swing.JLabel();
        jLabelWelcome2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Coordinador");
        setResizable(false);

        jTabbedDigitador.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTabbedDigitador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTabbedDigitadorMousePressed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel19.setText("NIVEL");

        btAbrirLic.setText("Adjuntar Archivo Soporte");
        btAbrirLic.setEnabled(false);
        btAbrirLic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirLicActionPerformed(evt);
            }
        });

        btAbrirEspe.setText("Abrir Soporte");
        btAbrirEspe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirEspeActionPerformed(evt);
            }
        });

        btAbrirEspeTic.setText("Abrir Soporte");
        btAbrirEspeTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirEspeTicActionPerformed(evt);
            }
        });

        btAbrirMaes.setText("Abrir Soporte");
        btAbrirMaes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirMaesActionPerformed(evt);
            }
        });

        btAbrirMaesTic.setText("Abrir Soporte");
        btAbrirMaesTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirMaesTicActionPerformed(evt);
            }
        });

        btAbrirDoc.setText("Abrir Soporte");
        btAbrirDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirDocActionPerformed(evt);
            }
        });

        btAbrirDocTic.setText("Abrir Soporte");
        btAbrirDocTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirDocTicActionPerformed(evt);
            }
        });

        jTextLicUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextLicUrl.setText("No hay soporte");
        jTextLicUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Licenciado en educacion o areas afines:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextLicUrl.setFocusable(false);

        jTextEspeUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextEspeUrl.setText("No hay soporte");
        jTextEspeUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Especializacion:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextEspeUrl.setFocusable(false);

        jTextEspeTicUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextEspeTicUrl.setText("No hay soporte");
        jTextEspeTicUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Especialización en áreas afines a TIC:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextEspeTicUrl.setFocusable(false);

        jTextMaesUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextMaesUrl.setText("No hay soporte");
        jTextMaesUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maestria:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextMaesUrl.setFocusable(false);

        jTextMaesTicUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextMaesTicUrl.setText("No hay soporte");
        jTextMaesTicUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maestría en áreas afines a TIC:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextMaesTicUrl.setFocusable(false);

        jTextDocUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextDocUrl.setText("No hay soporte");
        jTextDocUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doctorado:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextDocUrl.setFocusable(false);

        jTextDocTicUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextDocTicUrl.setText("No hay soporte");
        jTextDocTicUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doctorado en áreas afines a TIC:", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextDocTicUrl.setFocusable(false);

        btAbrirLic1.setText("Abrir Soporte");
        btAbrirLic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirLic1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtLic1);
        rbtLic1.setSelected(true);
        rbtLic1.setText("Si");
        rbtLic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtLic1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtLic2);
        rbtLic2.setText("No");
        rbtLic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtLic2ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtEspe1);
        rbtEspe1.setSelected(true);
        rbtEspe1.setText("Si");
        rbtEspe1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEspe1ActionPerformed(evt);
            }
        });

        buttonGroup2.add(rbtEspe2);
        rbtEspe2.setText("No");
        rbtEspe2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEspe2ActionPerformed(evt);
            }
        });

        buttonGroup3.add(rbtEspeTic1);
        rbtEspeTic1.setSelected(true);
        rbtEspeTic1.setText("Si");
        rbtEspeTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEspeTic1ActionPerformed(evt);
            }
        });

        buttonGroup3.add(rbtEspeTic2);
        rbtEspeTic2.setText("No");
        rbtEspeTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtEspeTic2ActionPerformed(evt);
            }
        });

        buttonGroup4.add(rbtMaes1);
        rbtMaes1.setSelected(true);
        rbtMaes1.setText("Si");
        rbtMaes1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMaes1ActionPerformed(evt);
            }
        });

        buttonGroup4.add(rbtMaes2);
        rbtMaes2.setText("No");
        rbtMaes2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMaes2ActionPerformed(evt);
            }
        });

        buttonGroup5.add(rbtMaesTic1);
        rbtMaesTic1.setSelected(true);
        rbtMaesTic1.setText("Si");
        rbtMaesTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMaesTic1ActionPerformed(evt);
            }
        });

        buttonGroup5.add(rbtMaesTic2);
        rbtMaesTic2.setText("No");
        rbtMaesTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtMaesTic2ActionPerformed(evt);
            }
        });

        buttonGroup6.add(rbtDoc1);
        rbtDoc1.setSelected(true);
        rbtDoc1.setText("Si");
        rbtDoc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDoc1ActionPerformed(evt);
            }
        });

        buttonGroup6.add(rbtDoc2);
        rbtDoc2.setText("No");
        rbtDoc2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDoc2ActionPerformed(evt);
            }
        });

        buttonGroup7.add(rbtDocTic1);
        rbtDocTic1.setSelected(true);
        rbtDocTic1.setText("Si");
        rbtDocTic1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDocTic1ActionPerformed(evt);
            }
        });

        buttonGroup7.add(rbtDocTic2);
        rbtDocTic2.setText("No");
        rbtDocTic2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtDocTic2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel21.setText("Validar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1017, 1017, 1017)
                .addComponent(jLabelLicUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btAbrirLic)
                .addGap(996, 996, 996))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel19)
                .addGap(343, 343, 343)
                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextEspeTicUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextEspeUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextLicUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btAbrirLic1)
                                .addGap(18, 18, 18)
                                .addComponent(rbtLic1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtLic2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btAbrirEspe)
                                .addGap(18, 18, 18)
                                .addComponent(rbtEspe1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtEspe2)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(btAbrirEspeTic)
                                .addGap(18, 18, 18)
                                .addComponent(rbtEspeTic1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtEspeTic2)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextMaesTicUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                            .addComponent(jTextMaesUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btAbrirMaesTic)
                                .addGap(18, 18, 18)
                                .addComponent(rbtMaesTic1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtMaesTic2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btAbrirMaes)
                                .addGap(18, 18, 18)
                                .addComponent(rbtMaes1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtMaes2)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextDocTicUrl, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                    .addComponent(jTextDocUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btAbrirDoc)
                    .addComponent(btAbrirDocTic))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtDoc1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtDoc2))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbtDocTic1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rbtDocTic2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextLicUrl)
                    .addComponent(rbtLic1)
                    .addComponent(rbtLic2)
                    .addComponent(btAbrirLic1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextEspeUrl)
                            .addComponent(btAbrirEspe)
                            .addComponent(rbtEspe1)
                            .addComponent(rbtEspe2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextEspeTicUrl)
                            .addComponent(btAbrirEspeTic)
                            .addComponent(rbtEspeTic1)
                            .addComponent(rbtEspeTic2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelLicUrl)
                            .addComponent(btAbrirLic, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMaesUrl)
                    .addComponent(btAbrirMaes, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtMaes1)
                    .addComponent(rbtMaes2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMaesTicUrl)
                    .addComponent(btAbrirMaesTic, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtMaesTic1)
                    .addComponent(rbtMaesTic2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDocUrl)
                    .addComponent(btAbrirDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtDoc2)
                    .addComponent(rbtDoc1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDocTicUrl)
                    .addComponent(btAbrirDocTic, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtDocTic2)
                    .addComponent(rbtDocTic1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedDigitador.addTab("Formacion", jPanel2);

        jTextCursoUrl.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTextCursoUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextCursoUrl.setText("No hay soporte");
        jTextCursoUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jTextCursoUrl.setFocusable(false);
        jTextCursoUrl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jTextCursoUrl.setInheritsPopupMenu(false);

        btAbrirFormacionTic.setText("Abrir Soporte");
        btAbrirFormacionTic.setEnabled(false);
        btAbrirFormacionTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirFormacionTicActionPerformed(evt);
            }
        });

        btMasCursos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Add-Asp-icon.png"))); // NOI18N
        btMasCursos.setText("Validar Otra Formacion Tic");
        btMasCursos.setEnabled(false);
        btMasCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMasCursosActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Elija la formacion en TIC:");

        btAgregarForTicActual.setText("Validar Formacion TIC");
        btAgregarForTicActual.setEnabled(false);
        btAgregarForTicActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarForTicActualActionPerformed(evt);
            }
        });

        labelForTicmsj.setForeground(java.awt.Color.red);
        labelForTicmsj.setText("Validado Exitosamente!");

        jComboFormacionTic.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elejir formacion TIC..." }));
        jComboFormacionTic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboFormacionTicItemStateChanged(evt);
            }
        });
        jComboFormacionTic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFormacionTicActionPerformed(evt);
            }
        });

        buttonGroup8.add(jRadioButton17);
        jRadioButton17.setSelected(true);
        jRadioButton17.setText("Si");
        jRadioButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton17ActionPerformed(evt);
            }
        });

        buttonGroup8.add(jRadioButton18);
        jRadioButton18.setText("No");
        jRadioButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton18ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Válida:");

        lbCurso.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbCurso.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Curso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lbInstitucion.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbInstitucion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Institucion", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lbHoras.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lbHoras.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Horas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextCursoUrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addComponent(lbCurso, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbInstitucion, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btAbrirFormacionTic)
                                .addGap(0, 1570, Short.MAX_VALUE))
                            .addComponent(lbHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel46)
                        .addGap(18, 18, 18)
                        .addComponent(jComboFormacionTic, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton17)
                        .addGap(18, 18, 18)
                        .addComponent(jRadioButton18))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btMasCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(btAgregarForTicActual, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(labelForTicmsj, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(jComboFormacionTic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbCurso, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(lbInstitucion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHoras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextCursoUrl)
                    .addComponent(btAbrirFormacionTic))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(jRadioButton17)
                    .addComponent(jRadioButton18))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarForTicActual, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelForTicmsj))
                .addGap(18, 18, 18)
                .addComponent(btMasCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jTabbedDigitador.addTab("Formacion en TIC", jPanel3);

        jLabel35.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel35.setText("Seleccione un idioma");

        buttonGroup19.add(jRadioButton1);
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Si");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup19.add(jRadioButton2);
        jRadioButton2.setText("No");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        jTextEscribe.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextEscribe.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextEscribe.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Escribe", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btSubirIdioma.setText("Abrir Soporte");
        btSubirIdioma.setEnabled(false);
        btSubirIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSubirIdiomaActionPerformed(evt);
            }
        });

        btAgregarIdioma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Add-Asp-icon.png"))); // NOI18N
        btAgregarIdioma.setText("Validar Otro Idioma");
        btAgregarIdioma.setEnabled(false);
        btAgregarIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarIdiomaActionPerformed(evt);
            }
        });

        btAgregarActualIdioma.setText("Validar Idioma");
        btAgregarActualIdioma.setEnabled(false);
        btAgregarActualIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgregarActualIdiomaActionPerformed(evt);
            }
        });

        jLabelidiomamsj.setForeground(java.awt.Color.red);
        jLabelidiomamsj.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelidiomamsj.setText("Validado Correcatamente!");
        jLabelidiomamsj.setFocusable(false);
        jLabelidiomamsj.setInheritsPopupMenu(false);

        jLabel49.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel49.setText("Válida:");

        ComboIdioma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Elejir idioma..." }));
        ComboIdioma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboIdiomaItemStateChanged(evt);
            }
        });
        ComboIdioma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboIdiomaActionPerformed(evt);
            }
        });

        jTextIdiomaUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextIdiomaUrl.setText("No hay Soporte");
        jTextIdiomaUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTextLee.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextLee.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextLee.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lee", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTextHabla.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jTextHabla.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextHabla.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Habla", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel35)
                                .addGap(18, 18, 18)
                                .addComponent(ComboIdioma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btAgregarActualIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelidiomamsj))
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(jRadioButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jRadioButton2))
                                    .addComponent(btAgregarIdioma))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextIdiomaUrl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jTextLee, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextHabla, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextEscribe, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(btSubirIdioma)
                        .addGap(0, 1681, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(ComboIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextLee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jTextHabla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextEscribe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextIdiomaUrl)
                    .addComponent(btSubirIdioma))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jLabel49))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btAgregarActualIdioma)
                    .addComponent(jLabelidiomamsj))
                .addGap(18, 18, 18)
                .addComponent(btAgregarIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148))
        );

        jTabbedDigitador.addTab("Idiomas", jPanel5);

        jLabel41.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel41.setText("CATEGORIA");

        jLabel48.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        jLabel48.setText("Validar");

        jTextEstudiantesUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextEstudiantesUrl.setText("No Hay Soporte");
        jTextEstudiantesUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTextProfesoresUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextProfesoresUrl.setText("No Hay Soporte");
        jTextProfesoresUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jTextformadoresUrl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jTextformadoresUrl.setText("No Hay Soporte");
        jTextformadoresUrl.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "URL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        btAbrirEstudiantes.setText("Abrir Soporte");
        btAbrirEstudiantes.setEnabled(false);
        btAbrirEstudiantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirEstudiantesActionPerformed(evt);
            }
        });

        btAbrirProfes.setText("Abrir Soporte");
        btAbrirProfes.setEnabled(false);
        btAbrirProfes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirProfesActionPerformed(evt);
            }
        });

        btAbrirFormadores.setText("Abrir Soporte");
        btAbrirFormadores.setEnabled(false);
        btAbrirFormadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAbrirFormadoresActionPerformed(evt);
            }
        });

        lbForProf.setText("No tiene Experiencia");
        lbForProf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formador TIC a Profesores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        lbForFor.setText("No tiene Experiencia");
        lbForFor.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formador TIC a formadores", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        buttonGroup9.add(jRadioButton19);
        jRadioButton19.setSelected(true);
        jRadioButton19.setText("Si");
        jRadioButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton19ActionPerformed(evt);
            }
        });

        buttonGroup9.add(rbtForEst);
        rbtForEst.setText("No");
        rbtForEst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtForEstActionPerformed(evt);
            }
        });

        buttonGroup10.add(jRadioButton21);
        jRadioButton21.setSelected(true);
        jRadioButton21.setText("Si");
        jRadioButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton21ActionPerformed(evt);
            }
        });

        buttonGroup10.add(rbtForPro);
        rbtForPro.setText("No");
        rbtForPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtForProActionPerformed(evt);
            }
        });

        buttonGroup11.add(jRadioButton23);
        jRadioButton23.setSelected(true);
        jRadioButton23.setText("Si");
        jRadioButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton23ActionPerformed(evt);
            }
        });

        buttonGroup11.add(rbtForFor);
        rbtForFor.setText("No");
        rbtForFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtForForActionPerformed(evt);
            }
        });

        lbForEst.setText("No tiene Experiencia");
        lbForEst.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formador TIC a estudiantes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbForProf, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextformadoresUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(lbForFor, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextProfesoresUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel41)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbForEst, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextEstudiantesUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btAbrirFormadores, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtForFor, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btAbrirProfes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtForPro))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(btAbrirEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButton19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtForEst)))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(jLabel48))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton19)
                        .addComponent(rbtForEst))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btAbrirEstudiantes)
                        .addComponent(lbForEst)
                        .addComponent(jTextEstudiantesUrl)))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbForProf)
                    .addComponent(jTextformadoresUrl)
                    .addComponent(btAbrirProfes)
                    .addComponent(jRadioButton21)
                    .addComponent(rbtForPro))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbForFor)
                    .addComponent(jTextProfesoresUrl)
                    .addComponent(btAbrirFormadores)
                    .addComponent(jRadioButton23)
                    .addComponent(rbtForFor))
                .addContainerGap(234, Short.MAX_VALUE))
        );

        jTabbedDigitador.addTab("Experiencia", jPanel6);

        LabelConfirmacion.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        LabelConfirmacion.setText("Desea Validar datos del Aspirante ?");

        jButtonRegistrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Add-Asp-icon.png"))); // NOI18N
        jButtonRegistrar.setText("Validar Aspirante");
        jButtonRegistrar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonCancelar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Back-Asp-icon.png"))); // NOI18N
        jButtonCancelar.setText("Salir");
        jButtonCancelar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jButtonRegistrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(LabelConfirmacion, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(194, 194, 194))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(LabelConfirmacion)
                .addGap(18, 18, 18)
                .addComponent(jButtonRegistrar)
                .addGap(30, 30, 30)
                .addComponent(jButtonCancelar)
                .addGap(256, 256, 256))
        );

        jTabbedDigitador.addTab("Validar", jPanel7);

        WelcomeLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        WelcomeLabel.setText("¡Bienvenido !");

        jLabelWelcome2.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        jLabelWelcome2.setText("A continuacion se presenta los datos del aspirante:");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/LogoSinFondo2.png"))); // NOI18N

        jButtonLogout.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButtonLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Login-out-icon.png"))); // NOI18N
        jButtonLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(WelcomeLabel)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addComponent(jButtonLogout))
                            .addComponent(jLabelWelcome2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11))
                    .addComponent(jTabbedDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(WelcomeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelWelcome2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(20, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jButtonLogout))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jTabbedDigitador, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoutActionPerformed
        // TODO add your handling code here:+
        System.exit(0);
    }//GEN-LAST:event_jButtonLogoutActionPerformed

    private void jTabbedDigitadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedDigitadorMousePressed

    }//GEN-LAST:event_jTabbedDigitadorMousePressed

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
     
        for (int i=0;i<Aspirante.getFormaciones().length;i++)
        {
            switch(Aspirante.getFormaciones()[i].getLevel())
        {
            case "Licenciado": Aspirante.getFormaciones()[i].setState(estadoLicenciado); break;
            case "Especializacion": Aspirante.getFormaciones()[i].setState(estadoEspecializacion); break;
            case "EspecializacionTIC": Aspirante.getFormaciones()[i].setState(estadoEspecializacionTic); break;
            case "Maestria" : Aspirante.getFormaciones()[i].setState(estadoMaestria); break; 
            case "MaestriaTIC" : Aspirante.getFormaciones()[i].setState(estadoMaestriaTic); break;
            case "Doctorado": Aspirante.getFormaciones()[i].setState(estadoDoctorado); break;
            case "DoctoradoTIC": Aspirante.getFormaciones()[i].setState(estadoDoctoradoTic); break;            
        }
        }
        
        for (int i=0;i<Aspirante.getFormadores().length;i++)
        {
            switch(Aspirante.getFormadores()[i].getPeople())
        {
            case "Estudiantes": Aspirante.getFormadores()[i].setState(estadoFormEstudiantes); break;
            case "Profesores": Aspirante.getFormadores()[i].setState(estadoFormProfesores); break;
            case "Formadores": Aspirante.getFormadores()[i].setState(estadoFormFormadores); break;
        }
            objAspirantController.updateAspirante(Aspirante.getDocument(), Aspirante);
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void btAbrirFormadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirFormadoresActionPerformed
        
    }//GEN-LAST:event_btAbrirFormadoresActionPerformed

    private void btAbrirProfesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirProfesActionPerformed
        
    }//GEN-LAST:event_btAbrirProfesActionPerformed

    private void btAbrirEstudiantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirEstudiantesActionPerformed
        
    }//GEN-LAST:event_btAbrirEstudiantesActionPerformed

    private void btAgregarActualIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarActualIdiomaActionPerformed
        jLabelidiomamsj.setVisible(true);
        btAgregarActualIdioma.setEnabled(false);
        Aspirante.getIdiomas()[firstIdiom].setState(estadoIdioma);
    }//GEN-LAST:event_btAgregarActualIdiomaActionPerformed

    private void btAgregarIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarIdiomaActionPerformed
        

    }//GEN-LAST:event_btAgregarIdiomaActionPerformed

    private void btSubirIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSubirIdiomaActionPerformed
        
    }//GEN-LAST:event_btSubirIdiomaActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        estadoIdioma = false;
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        estadoIdioma = true;
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void btAgregarForTicActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgregarForTicActualActionPerformed
        
        labelForTicmsj.setVisible(true);
        btAgregarForTicActual.setEnabled(false);
        Aspirante.getFormacionesTic()[firstForm].setEstado(estadoFormacion);
    }//GEN-LAST:event_btAgregarForTicActualActionPerformed

    private void btMasCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMasCursosActionPerformed
        lbCurso.setText("");
        lbInstitucion.setText("");
        lbHoras.setText("");
        jTextCursoUrl.setText("No Hay Soporte");
        labelForTicmsj.setVisible(false);
    }//GEN-LAST:event_btMasCursosActionPerformed

    private void btAbrirFormacionTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirFormacionTicActionPerformed
        
    }//GEN-LAST:event_btAbrirFormacionTicActionPerformed

    private void btAbrirDocTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirDocTicActionPerformed
        
    }//GEN-LAST:event_btAbrirDocTicActionPerformed

    private void btAbrirDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirDocActionPerformed
       
    }//GEN-LAST:event_btAbrirDocActionPerformed

    private void btAbrirMaesTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirMaesTicActionPerformed
        
    }//GEN-LAST:event_btAbrirMaesTicActionPerformed

    private void btAbrirMaesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirMaesActionPerformed
        
    }//GEN-LAST:event_btAbrirMaesActionPerformed

    private void btAbrirEspeTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirEspeTicActionPerformed
       
    }//GEN-LAST:event_btAbrirEspeTicActionPerformed

    private void btAbrirEspeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirEspeActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(jTextCursoUrl.getText());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("ERROR: "+ex);
            }
        }
    }//GEN-LAST:event_btAbrirEspeActionPerformed

    private void btAbrirLicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirLicActionPerformed
        
    }//GEN-LAST:event_btAbrirLicActionPerformed

    private void jRadioButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton19ActionPerformed
        // TODO add your handling code here:
        estadoFormEstudiantes = true;
    }//GEN-LAST:event_jRadioButton19ActionPerformed

    private void rbtForEstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtForEstActionPerformed
        // TODO add your handling code here:
        estadoFormEstudiantes = false;
    }//GEN-LAST:event_rbtForEstActionPerformed

    private void jRadioButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton21ActionPerformed
        // TODO add your handling code here:
        estadoFormProfesores = true;
    }//GEN-LAST:event_jRadioButton21ActionPerformed

    private void rbtForProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtForProActionPerformed
        // TODO add your handling code here:
        estadoFormProfesores = false;
        
    }//GEN-LAST:event_rbtForProActionPerformed

    private void jRadioButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton23ActionPerformed
        // TODO add your handling code here:
        estadoFormFormadores = true;
    }//GEN-LAST:event_jRadioButton23ActionPerformed

    private void rbtForForActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtForForActionPerformed
        // TODO add your handling code here:
        estadoFormFormadores = false;
    }//GEN-LAST:event_rbtForForActionPerformed

    private void jComboFormacionTicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboFormacionTicItemStateChanged
        //Obtenemos la cadena del combo
        String vartemp=evt.getItem().toString();
        //Obtenemos la primera letra de la cadena
        char temp=vartemp.charAt(0);
        System.out.println("Combo "+temp);
       
        if(temp != 'E'){
            firstForm=(int) temp - 48;
            System.out.println("Adentro "+firstForm);
            btAbrirFormacionTic.setEnabled(true);
            btAgregarForTicActual.setEnabled(true);
            btAbrirFormacionTic.setEnabled(true);
            lbCurso.setText(Aspirante.getFormacionesTic()[firstForm].getTitulo());            
            lbInstitucion.setText(Aspirante.getFormacionesTic()[firstForm].getInstitucion());
            lbHoras.setText(""+Aspirante.getFormacionesTic()[firstForm].getHoras());
            jTextCursoUrl.setText(Aspirante.getFormacionesTic()[firstForm].getUrl_soporte());
        }
        else{
            lbCurso.setText("");
            lbInstitucion.setText("");
            lbHoras.setText("");
            jTextCursoUrl.setText("No Hay Soporte");
            btAbrirFormacionTic.setEnabled(false);
            btAgregarForTicActual.setEnabled(false);
            btAbrirFormacionTic.setEnabled(false);
        }
    }//GEN-LAST:event_jComboFormacionTicItemStateChanged

    private void ComboIdiomaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboIdiomaItemStateChanged
        //Obtenemos la cadena del combo
        String vartemp=evt.getItem().toString();
        //Obtenemos la primera letra de la cadena
        char temp=vartemp.charAt(0);        
       
        if(temp != 'E'){
            firstIdiom=(int) temp - 48;            
            btAgregarActualIdioma.setEnabled(true);
            btAgregarIdioma.setEnabled(true);
            btSubirIdioma.setEnabled(true);
            jTextLee.setText(Aspirante.getIdiomas()[firstIdiom].getNivellee());            
            jTextEscribe.setText(Aspirante.getIdiomas()[firstIdiom].getNivelescribe());
            jTextHabla.setText(""+Aspirante.getIdiomas()[firstIdiom].getNivelhabla());
            jTextIdiomaUrl.setText(Aspirante.getIdiomas()[firstIdiom].getPatharchivo());
        }
        else{
            lbCurso.setText("");
            lbInstitucion.setText("");
            lbHoras.setText("");
            jTextCursoUrl.setText("No Hay Soporte");
            btAgregarActualIdioma.setEnabled(false);
            btAgregarIdioma.setEnabled(false);
            btSubirIdioma.setEnabled(false);
        }
    }//GEN-LAST:event_ComboIdiomaItemStateChanged

    private void btAbrirLic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAbrirLic1ActionPerformed
        // TODO add your handling code here:
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File(jTextCursoUrl.getText());
                Desktop.getDesktop().open(myFile);
            } catch (IOException ex) {
                System.out.println("ERROR: "+ex);
            }
        }
    }//GEN-LAST:event_btAbrirLic1ActionPerformed

    private void jComboFormacionTicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboFormacionTicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboFormacionTicActionPerformed

    private void ComboIdiomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboIdiomaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboIdiomaActionPerformed

    private void rbtLic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtLic1ActionPerformed
        // TODO add your handling code here:
        estadoLicenciado = true;
        
    }//GEN-LAST:event_rbtLic1ActionPerformed

    private void rbtLic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtLic2ActionPerformed
        // TODO add your handling code here:
        estadoLicenciado = false;
    }//GEN-LAST:event_rbtLic2ActionPerformed

    private void rbtEspe1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEspe1ActionPerformed
        // TODO add your handling code here:
        estadoEspecializacion = true;
    }//GEN-LAST:event_rbtEspe1ActionPerformed

    private void rbtEspe2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEspe2ActionPerformed
        // TODO add your handling code here:
        estadoEspecializacion = false;
    }//GEN-LAST:event_rbtEspe2ActionPerformed

    private void rbtEspeTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEspeTic1ActionPerformed
        // TODO add your handling code here:
        estadoEspecializacionTic = true;
    }//GEN-LAST:event_rbtEspeTic1ActionPerformed

    private void rbtEspeTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtEspeTic2ActionPerformed
        // TODO add your handling code here:
        estadoEspecializacionTic = false;
    }//GEN-LAST:event_rbtEspeTic2ActionPerformed

    private void rbtMaes1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMaes1ActionPerformed
        // TODO add your handling code here:
        estadoMaestria = true;
    }//GEN-LAST:event_rbtMaes1ActionPerformed

    private void rbtMaes2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMaes2ActionPerformed
        // TODO add your handling code here:
        estadoMaestria = false ;
    }//GEN-LAST:event_rbtMaes2ActionPerformed

    private void rbtMaesTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMaesTic1ActionPerformed
        // TODO add your handling code here:
        estadoMaestriaTic = true;
    }//GEN-LAST:event_rbtMaesTic1ActionPerformed

    private void rbtMaesTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtMaesTic2ActionPerformed
        // TODO add your handling code here:
        estadoMaestriaTic = false;
    }//GEN-LAST:event_rbtMaesTic2ActionPerformed

    private void rbtDoc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDoc1ActionPerformed
        // TODO add your handling code here:
        estadoDoctorado = true;
    }//GEN-LAST:event_rbtDoc1ActionPerformed

    private void rbtDoc2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDoc2ActionPerformed
        // TODO add your handling code here:
        estadoDoctorado = false;
    }//GEN-LAST:event_rbtDoc2ActionPerformed

    private void rbtDocTic1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDocTic1ActionPerformed
        // TODO add your handling code here:
        estadoDoctoradoTic = true;
    }//GEN-LAST:event_rbtDocTic1ActionPerformed

    private void rbtDocTic2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtDocTic2ActionPerformed
        // TODO add your handling code here:
        estadoDoctoradoTic = false;
    }//GEN-LAST:event_rbtDocTic2ActionPerformed

    private void jRadioButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton17ActionPerformed
        // TODO add your handling code here:
        estadoFormacion = true;
    }//GEN-LAST:event_jRadioButton17ActionPerformed

    private void jRadioButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton18ActionPerformed
        // TODO add your handling code here:
        estadoFormacion = false;
    }//GEN-LAST:event_jRadioButton18ActionPerformed

    
        
    /*METODO PARA OBTENER LA DIRECCION DEL ARCHIVO SOPORTE
    *Crea el directorio para el soporte del respectivo aspirante
    *Copia los archivos seleccionados a la URL de soportes
    */
    private String obtenerurl(JButton boton, String foldername){
        return "";
    }
    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(PanelDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(PanelDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(PanelDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(PanelDigitador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//       java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                Formacion objforma1=new Formacion("Uni1", "Licenciado en XY", "Licenciado", "PathEspecializacion");
//                Formacion objforma2=new Formacion("Uni2", "Mestria en xx", "Maestria", "PathMestria");
//                Formacion objforma3=new Formacion("Uni3", "Doctorado en mean", "Doctorado", "PathDoctorado");
//                Formacion [] formArray = new Formacion[3];
//                formArray[0]=objforma1;
//                formArray[1]=objforma2;
//                formArray[2]=objforma3;
//                
//                FormacionTic objform1=new FormacionTic("Instituto1", "Titulo1", 001, "url1", true);
//                FormacionTic objform2=new FormacionTic("Instituto2", "Titulo2", 002, "url2", true);
//                FormacionTic [] form=new FormacionTic[2];
//                form[0]=objform1;
//                form[1]=objform2;
//                
//                Aspirante asp=new Aspirante();
//                asp.setName("Carlos Alejandro");
//                asp.setLastname("Sandobal Hernandez");
//                asp.setCity("Santiago de Cali");
//                asp.setFormacionesTic(form);
//                asp.setFormaciones(formArray);
//                UserController objControl = new UserController();
//                new PanelValidaAspirante("Nelson", asp, objControl).setVisible(true);
//            }
//        });
//    }//END MAIN


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ComboIdioma;
    private javax.swing.JLabel LabelConfirmacion;
    private javax.swing.JLabel WelcomeLabel;
    private javax.swing.JButton btAbrirDoc;
    private javax.swing.JButton btAbrirDocTic;
    private javax.swing.JButton btAbrirEspe;
    private javax.swing.JButton btAbrirEspeTic;
    private javax.swing.JButton btAbrirEstudiantes;
    private javax.swing.JButton btAbrirFormacionTic;
    private javax.swing.JButton btAbrirFormadores;
    private javax.swing.JButton btAbrirLic;
    private javax.swing.JButton btAbrirLic1;
    private javax.swing.JButton btAbrirMaes;
    private javax.swing.JButton btAbrirMaesTic;
    private javax.swing.JButton btAbrirProfes;
    private javax.swing.JButton btAgregarActualIdioma;
    private javax.swing.JButton btAgregarForTicActual;
    private javax.swing.JButton btAgregarIdioma;
    private javax.swing.JButton btMasCursos;
    private javax.swing.JButton btSubirIdioma;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup12;
    private javax.swing.ButtonGroup buttonGroup13;
    private javax.swing.ButtonGroup buttonGroup14;
    private javax.swing.ButtonGroup buttonGroup15;
    private javax.swing.ButtonGroup buttonGroup16;
    private javax.swing.ButtonGroup buttonGroup17;
    private javax.swing.ButtonGroup buttonGroup18;
    private javax.swing.ButtonGroup buttonGroup19;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup20;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonLogout;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox jComboFormacionTic;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabelLicUrl;
    private javax.swing.JLabel jLabelWelcome2;
    private javax.swing.JLabel jLabelidiomamsj;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton17;
    private javax.swing.JRadioButton jRadioButton18;
    private javax.swing.JRadioButton jRadioButton19;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton21;
    private javax.swing.JRadioButton jRadioButton23;
    private javax.swing.JTabbedPane jTabbedDigitador;
    private javax.swing.JLabel jTextCursoUrl;
    private javax.swing.JLabel jTextDocTicUrl;
    private javax.swing.JLabel jTextDocUrl;
    private javax.swing.JLabel jTextEscribe;
    private javax.swing.JLabel jTextEspeTicUrl;
    private javax.swing.JLabel jTextEspeUrl;
    private javax.swing.JLabel jTextEstudiantesUrl;
    private javax.swing.JLabel jTextHabla;
    private javax.swing.JLabel jTextIdiomaUrl;
    private javax.swing.JLabel jTextLee;
    private javax.swing.JLabel jTextLicUrl;
    private javax.swing.JLabel jTextMaesTicUrl;
    private javax.swing.JLabel jTextMaesUrl;
    private javax.swing.JLabel jTextProfesoresUrl;
    private javax.swing.JLabel jTextformadoresUrl;
    private javax.swing.JLabel labelForTicmsj;
    private javax.swing.JLabel lbCurso;
    private javax.swing.JLabel lbForEst;
    private javax.swing.JLabel lbForFor;
    private javax.swing.JLabel lbForProf;
    private javax.swing.JLabel lbHoras;
    private javax.swing.JLabel lbInstitucion;
    private javax.swing.JRadioButton rbtDoc1;
    private javax.swing.JRadioButton rbtDoc2;
    private javax.swing.JRadioButton rbtDocTic1;
    private javax.swing.JRadioButton rbtDocTic2;
    private javax.swing.JRadioButton rbtEspe1;
    private javax.swing.JRadioButton rbtEspe2;
    private javax.swing.JRadioButton rbtEspeTic1;
    private javax.swing.JRadioButton rbtEspeTic2;
    private javax.swing.JRadioButton rbtForEst;
    private javax.swing.JRadioButton rbtForFor;
    private javax.swing.JRadioButton rbtForPro;
    private javax.swing.JRadioButton rbtLic1;
    private javax.swing.JRadioButton rbtLic2;
    private javax.swing.JRadioButton rbtMaes1;
    private javax.swing.JRadioButton rbtMaes2;
    private javax.swing.JRadioButton rbtMaesTic1;
    private javax.swing.JRadioButton rbtMaesTic2;
    // End of variables declaration//GEN-END:variables

}
