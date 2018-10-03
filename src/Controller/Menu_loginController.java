
package Controller;

import Telas.GerenciarDados;
import Telas.MenuLogin;
import Telas.Menuinicial;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import org.bytedeco.javacv.FrameGrabber;
import reconhecimento.CapturaImagens;
import reconhecimento.Reconhecedor;
import reconhecimento.Treinamento;

public class Menu_loginController implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      id_voltar.setOnAction((ActionEvent event)->{
        voltar_menu_principal();
    });
      
      id_entrar.setOnAction((ActionEvent event)->{
        entrar_usuario_senha();
    });
      
      id_reconhecimento.setOnAction((ActionEvent event)->{
          try {
              reconhedor_facial();
          } catch (Exception ex) {
              Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
          }
    });
    
      id_reconhe_cads.setOnAction((ActionEvent event)->{
          
          try{
              
            cadastrar_reconhecimento();
            
          }catch(Exception e){
              e.printStackTrace();
          }        
          
          
          
        });
      
    }    
    
    
    @FXML
    private JFXTextField id_textusuario;

    @FXML
    private JFXButton id_entrar;

    @FXML
    private JFXButton id_reconhecimento;

    @FXML
    private JFXButton id_voltar;

    @FXML
    private JFXPasswordField id_textsenha;
    
     @FXML
    private JFXButton id_reconhe_cads;
     
    public void voltar_menu_principal(){
        MenuLogin.getStage().close();
        Menuinicial.getStage().show();
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
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Erro na aunteticação");
            alert.setTitle(":(");
            alert.setContentText("Usuário ou senha incorretos!");
            alert.show();
        }
        
    }
    public void reconhedor_facial()throws Exception{
        finalizar_stage();
        Reconhecedor recog = new Reconhecedor(); 
        
        if (recog.reconhece()){
               try {
                GerenciarCadastros();
               } catch (Exception ex) {
                Logger.getLogger(Menu_loginController.class.getName()).log(Level.SEVERE, null, ex);
               }
        }else{
            abrir_stage();
            System.out.println("Voce não foi reconhecido");
        }
        
        
    }
    
     public void GerenciarCadastros() throws Exception{
        GerenciarDados gerenciar = new GerenciarDados();
        finalizar_stage();
        gerenciar.start(new Stage());
    
    }
    public void finalizar_stage(){
        MenuLogin.getStage().close();
    }
    public void abrir_stage(){
        MenuLogin.getStage().show();
    }
    public void cadastrar_reconhecimento() throws FrameGrabber.Exception, InterruptedException, Exception{
        CapturaImagens.capturaImg();
        Treinamento.treinador();
        System.out.println("passei aki");
        
        //Menuinicial.start();
        
        
    }
    
}
