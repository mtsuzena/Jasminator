package Controller;

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;


public class Final_Jogo_UnkController implements Initializable {

  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       voltar();
       recomecar();
    }    
    
    
     @FXML
    private AnchorPane id_pane;

    @FXML
    private Text id_text;

    @FXML
    private JFXButton id_jogar_nov;

    @FXML
    private JFXButton id_voltar;
    
    public void voltar(){
        id_voltar.setOnAction((ActionEvent event)->{
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
                 TrocarCenas.trocarcena_baixo(root, id_voltar, id_pane);
                 id_pane.getChildren().clear();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
      });
    }
    public void recomecar(){
          id_jogar_nov.setOnAction((ActionEvent event)->{
            Parent root;
             try {
                 root = FXMLLoader.load(getClass().getResource("/Fxml/Jogo_p1.fxml"));
                 TrocarCenas.trocarcena_baixo(root, id_voltar, id_pane);
                 id_pane.getChildren().clear();
             } catch (IOException ex) {
                ex.printStackTrace();
             }
           
      });
    }
    }
    
    
    

