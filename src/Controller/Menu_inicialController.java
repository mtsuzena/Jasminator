package Controller;

import Telas.Menuinicial;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

public class Menu_inicialController implements Initializable {
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       id_jogar.setOnAction((ActionEvent event)->{
           try {
               iniciar_jogo();
               id_anchor.getChildren().clear();
           } catch (IOException ex) {
               Logger.getLogger(Menu_inicialController.class.getName()).log(Level.SEVERE, null, ex);
           }
});
       
      id_sairjogo.setOnAction((ActionEvent event)->{
          sair_jogo(); }); 
      
//      id_entrar.setOnAction((ActionEvent event)->{
//           try {
//               entrar_administrador();
//           }catch (Exception ex) {
//              ex.printStackTrace();} });
        id_entrar.setOnAction((ActionEvent event)->{
           try {
               entrar_administrador();
           } catch (IOException ex) {
               Logger.getLogger(Menu_inicialController.class.getName()).log(Level.SEVERE, null, ex);
           }
    });
        
    }    
    
   
    @FXML
    private StackPane id_stackpane;
    
    @FXML
    private ImageView layout_menu_inicial;

    @FXML
    private AnchorPane id_anchor;

    @FXML
    private JFXButton id_jogar;

    @FXML
    private JFXButton id_entrar;

    @FXML
    private JFXButton id_sairjogo;
    
       public void iniciar_jogo() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Jogo_p1.fxml"));
          TrocarCenas.trocarcena_baixo(root, id_jogar, id_anchor);
       }
           
       
//       public void entrar_administrador() throws Exception{
//            MenuLogin login = new MenuLogin();//instanciar a nova  tela
//            finalizar_stage(); // finalizar atual
//            login.start(new Stage());           
//       } 
       
       
       @FXML
    private void entrar_administrador() throws IOException {
        layout_menu_inicial.setVisible(false);
        id_entrar.setVisible(false);
        id_jogar.setVisible(false);
        id_sairjogo.setVisible(false);
         Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_login.fxml"));
         TrocarCenas.trocarcena_baixo(root, id_entrar, id_anchor);
    }
       
    public void finalizar_stage(){
         Menuinicial.getStage().close();
    }

    public void abrirstage(){
          Menuinicial.getStage().show();
    }

    public void sair_jogo(){
         System.exit(0);
    }
}