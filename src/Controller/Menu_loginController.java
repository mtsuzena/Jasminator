package Controller;

import Classes.ArquivoTxt;
import Telas.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.glass.ui.View;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import org.bytedeco.javacv.FrameGrabber;
import reconhecimento.CapturaImagens;
import reconhecimento.Reconhecedor;
import reconhecimento.Treinamento;

public class Menu_loginController implements Initializable {
    private Boolean cont = true;
    private String adm_cadastrado = ArquivoTxt.readAdm();
    private Reconhecedor recog=null;
    private static int estagio_reproducao_audio;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        id_voltar.setOnAction((ActionEvent event)->{
          try {
              voltar_menu_principal();
          } catch (IOException ex) {
              Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
          }
        });
      
        id_entrar.setOnAction((ActionEvent event)->{
            entrar_usuario_senha();
        });
      
        id_textusuario.setOnKeyPressed(k ->{
              final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
              id_textsenha.requestFocus();
            }
        });

        id_textsenha.setOnKeyPressed(k ->{
            final KeyCombination ENTER = new KeyCodeCombination(KeyCode.ENTER);
            if (ENTER.match(k)) {
              entrar_usuario_senha();
            }
        });
      
        System.out.println("Maluco\n");
      
        id_reconhecimento.setOnAction((ActionEvent event)->{
            try {
                reconhedor_facial();
            } catch (Exception ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
                retorna_mensagem(":(","ERROR","Não foi possivel executar esta funcionalidade!!");
            }
        });
    
        id_reconhe_cads.setOnAction((ActionEvent event)->{
        
            try {  
              cadastrar_reconhecimento();
            } catch (InterruptedException ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
      
    }    
    
    @FXML
    private AnchorPane id_anchor;
    
    @FXML
    private JFXTextField id_textusuario;
    
    @FXML
    private JFXPasswordField id_textsenha;

    @FXML
    private JFXButton id_entrar;

    @FXML
    private JFXButton id_reconhecimento;
    
    @FXML
    private JFXButton id_reconhe_cads;

    @FXML
    private JFXButton id_voltar;
     
    public void voltar_menu_principal()throws IOException {
        id_anchor.setVisible(false);
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
        TrocarCenas.trocarcena_direita(root, id_voltar, id_anchor);
   }
    
    public void entrar_usuario_senha(){
        
        String usuario =  id_textusuario.getText();
        String senha =  id_textsenha.getText();
        if(((usuario.equals("admin")) && (senha.equals("123")))){  
            id_textusuario.setText("");
            id_textsenha.setText("");
            try {
                GerenciarCadastros();
            } catch (Exception ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            id_textusuario.setText("");
            id_textsenha.setText("");
            retorna_mensagem("Erro na aunteticação",":(","Usuário ou senha incorretos!");
            id_textusuario.requestFocus();
            
        }
        
    }
    public void reconhedor_facial()throws Exception{   
        
        recog = new Reconhecedor(); 
        
        if (recog.reconhece()){
               try {
                GerenciarCadastros();
               } catch (Exception ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
               }
        }else{
            retorna_mensagem(":(","ERROR","Desculpe, nao conseguimos reconhece-lo!");
        }
        
        
    }
    
     public void GerenciarCadastros() throws Exception{
//        GerenciarDados gerenciar = new GerenciarDados();
//        finalizar_stage();
//        gerenciar.start(new Stage());
       id_anchor.setVisible(false);
       Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
       TrocarCenas.trocarcena_direita(root, id_entrar, id_anchor);
       
    }
    
    public void cadastrar_reconhecimento() throws FrameGrabber.Exception, InterruptedException, Exception{
        //Menuinicial.getStage().close()
        /*adm_cadastrado = ArquivoTxt.readAdm();
        if(adm_cadastrado.equals("0")){
            retorna_mensagem("Cadastrar reconhecimento facial",":)","Segure a tecla Q para tirar fotos");
            try { Thread.sleep (2000); } catch (InterruptedException ex) {}
            CapturaImagens.capturaImg();
            System.out.println("KK EAE GERENTE DE PROJETO");
            //Menuinicial.getStage().show();
            ArquivoTxt.writeAdm();
        }else{
           recog = new Reconhecedor();     
           if (recog.reconhece()){
                retorna_mensagem("Cadastrar reconhecimento facial",":)","Segure a tecla Q para tirar fotos");
                try { Thread.sleep (3000); } catch (InterruptedException ex) {}
                CapturaImagens.capturaImg();
                System.out.println("KK EAE GERENTE DE PROJETO");
                //Menuinicial.getStage().show();
                ArquivoTxt.writeAdm();
           }else{
             retorna_mensagem("ERRO",":)","Administrador nao reconhecido!!!!");
           }
        }*/
        
        //retorna_mensagem("Cadastrar reconhecimento facial",":)","Segure a tecla Q para tirar fotos");
        
        CapturaImagens.capturaImg();
        try { Thread.sleep (3000); } catch (InterruptedException ex) {}
        System.out.println("KK EAE GERENTE DE PROJETO");
        setEstagio_reproducao_audio(0);
        reproduzir_audio(1800, "apresentacao_jasmine.m4a");
        //reproduzir_audio(8500, "posicione_rosto_centro.m4a");
        
        boolean verifica_estagio=true;
        
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==1){    
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "iniciando_captura_fotos.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        
        verifica_estagio=true;
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==2){    
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "vire_rosto_direita.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        
        
        reproduzir_audio(6500, "iniciando_captura_fotos.m4a");
        CapturaImagens.setIniciFotos(true);
        setEstagio_reproducao_audio(1);
                
        
        verifica_estagio=true;
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==3){ 
                CapturaImagens.setIniciFotos(false);
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "vire_rosto_esquerda.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        

        reproduzir_audio(6500, "iniciando_captura_fotos.m4a");
        setEstagio_reproducao_audio(1);
        CapturaImagens.setIniciFotos(true);
        
        verifica_estagio=true;
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==4){    
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "incline_cabeca_cima.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        
        reproduzir_audio(6500, "iniciando_captura_fotos.m4a");
        setEstagio_reproducao_audio(1);
        CapturaImagens.setIniciFotos(true);
        
        verifica_estagio=true;
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==5){    
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "incline_cabeca_baixo.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        
        reproduzir_audio(6500, "iniciando_captura_fotos.m4a");
        setEstagio_reproducao_audio(1);
        CapturaImagens.setIniciFotos(true);
        
        verifica_estagio=true;
        while(verifica_estagio){
            System.out.println("ESTAGIO = "+estagio_reproducao_audio);
            if(estagio_reproducao_audio==6){    
                System.out.println("ESTAGIO = "+estagio_reproducao_audio);
                reproduzir_audio(50, "finalizacao_cadastro.m4a");
                verifica_estagio=false;
                System.out.println("ESTAGIO_REPRODUCAO_AUDIO = "+estagio_reproducao_audio);
            }
        }
        
    }
    public static void retorna_mensagem(String header, String tittle, String mensagem){
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setHeaderText(header);
        alert.setTitle(tittle);
        alert.setContentText(mensagem);
        alert.show();
    }
    public void reproduzir_audio(Integer time,String musicFile){
        musicFile = getClass().getResource("/sons/"+musicFile).toString();
        AudioClip clip = new AudioClip(musicFile);
        try { Thread.sleep (time); } catch (InterruptedException ex) {}
        clip.play();
    }
    
    public static void setEstagio_reproducao_audio(int estagio){
        estagio_reproducao_audio=estagio;
    }
    public static int getEstagio_reproducao_audio(){
        return estagio_reproducao_audio;
    }
}
