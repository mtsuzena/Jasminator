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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;


public class Final_JogoController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Jogo_p1Controller.img_caminho.equals("null")){
            
        }else{
            Image imagem = new Image(Jogo_p1Controller.img_caminho);
            img_pessoa_encontrada.setImage(imagem);
        }
        
        id_label.setText(Jogo_p1Controller.nome);
        voltar();
        recomecar();
    } 
    
//    @FXML
//    private StackPane stack_pane_img;
    
    @FXML
    private ImageView img_pessoa_encontrada;
    
    @FXML
    private AnchorPane id_pane;

    @FXML
    private JFXButton id_jogar_nov;

    @FXML
    private JFXButton id_voltar;

    @FXML
    private ImageView id_img;

    @FXML
    private Text id_label;
    
    
    public void voltar()  {
        id_voltar.setOnAction((ActionEvent event)->{
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
                 TrocarCenas.trocarcena_baixo(root, id_voltar, id_pane);
                 id_pane.getChildren().clear();
            } catch (IOException ex) {
                Logger.getLogger(Final_JogoController.class.getName()).log(Level.SEVERE, null, ex);
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
                 Logger.getLogger(Final_JogoController.class.getName()).log(Level.SEVERE, null, ex);
             }
           
      });
    }
    
}