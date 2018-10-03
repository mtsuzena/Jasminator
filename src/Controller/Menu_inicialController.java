
package Controller;

import Classes.GameRun;
import Telas.MenuLogin;
import Telas.Menuinicial;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Menu_inicialController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       id_jogar.setOnAction((ActionEvent event)->{
        iniciar_jogo(); });
       
      id_sairjogo.setOnAction((ActionEvent event)->{
          sair_jogo(); }); 
      
      id_entrar.setOnAction((ActionEvent event)->{
           try {
               entrar_administrador();
           }catch (Exception ex) {
              ex.printStackTrace();} });
        
    }    
    
        @FXML
        private AnchorPane id_anchor;

        @FXML
        private StackPane id_stackpane;
        @FXML
        private JFXButton id_jogar;
        @FXML
        private JFXButton id_entrar;
        @FXML
        private JFXButton id_sairjogo;
    
       public void iniciar_jogo(){
           finalizar_stage(); 
           GameRun.start();
           abrirstage();
       }
           
       
       public void entrar_administrador() throws Exception{
            MenuLogin login = new MenuLogin();//instanciar a nova  tela
            finalizar_stage(); // finalizar atual
            login.start(new Stage()); 
            
           //Setar variando cenas, estudar mais 
//            Scene scena = id_entrar.getScene();
//            Menuinicial.getRoot().translateYProperty().set(scena.getHeight());
//            id_stackpane.getChildren().add(Menuinicial.getRoot());
//            Timeline timeline = new Timeline();
//            KeyValue kv = new KeyValue(Menuinicial.getRoot().translateYProperty(),0,Interpolator.EASE_IN);
//            
            
       } 
       
       public void finalizar_stage(){
            Menuinicial.getStage().close();}
       
       public void abrirstage(){
             Menuinicial.getStage().show();
       }
    
       public void sair_jogo(){
            System.exit(0); }
            
   
    
    
}
