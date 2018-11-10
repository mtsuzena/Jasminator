/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Classes.ArquivoTxt;
import Telas.AnimacaoCampos;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.lang3.StringUtils;

/**
 * FXML Controller class
 *
 * @author vm_su
 */
public class Tela_cadastro_userController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane pane_tela_cadatro_user;

     @FXML
    private JFXTextField txtfd_user;

    @FXML
    private JFXPasswordField txtfd_passwd;

    @FXML
    private JFXButton btn_finalizar_cadastro;

    @FXML
    private JFXButton btn_cancelar;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        btn_finalizar_cadastro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(validacao()){
                    finalizar_cadastro();
                    voltar_tela();
                }else{
                    System.out.println("Cadastro user finalizado");
                }
            }
        }
        );
        
//        btn_cancelar.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                voltar_tela();
//            }
//        }
//        ); 
    }
    
    public void finalizar_cadastro(){
        ArquivoTxt.writeLogin(txtfd_user.getText(), txtfd_passwd.getText(), "autenticacao_adm.txt");
    }
    
    public void voltar_tela(){
        try {
             pane_tela_cadatro_user.setVisible(false);
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_login.fxml"));
            Telas.TrocarCenas.trocarcena_direita(root,btn_finalizar_cadastro,pane_tela_cadatro_user);
           
        } catch (IOException ex) {
            Logger.getLogger(Tela_cadastro_userController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validacao(){
       
        Boolean user = StringUtils.isBlank(txtfd_user.getText());
        Boolean password = StringUtils.isBlank(txtfd_passwd.getText());
        
        Boolean flag = true;
        
        if(user == true){
                AnimacaoCampos.vibrar(txtfd_user);
                flag = false;
        }
        
        if(password == true){
                flag = false;
        }
              
        if(flag){
            return true;
        }else{  
            return false;
        }
    }
}
