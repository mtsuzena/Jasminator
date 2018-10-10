package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Control;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.validation.ValidationResult;
import org.controlsfx.validation.ValidationSupport;
import org.controlsfx.validation.Validator;


public class Cadastrar_PessoaController implements Initializable {
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {      
        id_nome.setText("");
        id_idade.setText("");
        Pessoa pessoa = new Pessoa();
        List<Pessoa> lista_pessoa = new ArrayList<>(); 
        lista_pessoa = Capturar_pessoas();
       
        if(lista_pessoa != null){
            if(lista_pessoa.size()!=0)
                pessoa.setCodPessoa((lista_pessoa.get(lista_pessoa.size()-1).getCodPessoa()+1));
            else
                pessoa.setCodPessoa(1);
        }//else{
          // pessoa.setCodPessoa((lista_pessoa.get(lista_pessoa.size()-1).getCodPessoa()+1));  
        //}
           
            id_salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              
             //if(validacao()){
             pessoa.setNome(id_nome.getText());
             pessoa.setIdade(Integer.parseInt(id_idade.getText()));
             if(pessoa.getIdade() > 20){
                 pessoa.setMaior20(true);
             }else{
                 pessoa.setMaior20(false);
             }
             ArquivoTxt.salvaTxt("dados_pessoas.txt", pessoa);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Arquivo Salvo!");
            alert.setTitle(":)");
            alert.setContentText("A "+pessoa.getNome()+" Foi cadastrada! ");
            alert.show();
            //}
          }
            
        }
        );
        id_voltar.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
               try{
                Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
                TrocarCenas.trocarcena_direita(root, id_voltar, id_pane);
              
               }catch(Exception e){
                   e.printStackTrace();
               }
            }
        }
        );
        
         
      //Pergunta 1
        id_sim_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_1.setSelected(false);
            pessoa.setCalvo(true);
            }
        }
        );
        id_nao_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_1.setSelected(false);
            pessoa.setCalvo(false);
            
            }
        }
        );
        
       //Pergunta 2
       id_sim_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_2.setSelected(false);
            pessoa.setCabeloLongo(true);
            }
        }
        );
        id_nao_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_2.setSelected(false);
            pessoa.setCabeloLongo(false);
            
            }
        }
        );
        //Pergunta 3
        id_sim_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_3.setSelected(false);
            pessoa.setAlto(true);
            }
        }
        );
        id_nao_3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_3.setSelected(false);
            pessoa.setAlto(false);
            
            }
        }
        );
        //Pergunta 4
        id_sim_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_4.setSelected(false);
            pessoa.setBarba(true);
            }
        }
        );
        id_nao_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_4.setSelected(false);
            pessoa.setBarba(false);
            
            }
        }
        );
        //Pergunta 5
        id_sim_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_5.setSelected(false);
            pessoa.setProfessor(true);
            }
        }
        );
        id_nao_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_5.setSelected(false);
            pessoa.setProfessor(false);
            
            }
        }
        );
        //Pergunta 6
        id_sim_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_6.setSelected(false);
            pessoa.setMasculino(true);
            }
        }
        );
        id_nao_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_6.setSelected(false);
            pessoa.setMasculino(false);
            
            }
        }
        );
        //Pergunta 7
        id_sim_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_7.setSelected(false);
            pessoa.setCabeloClaro(true);
            }
        }
        );
        id_nao_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_7.setSelected(false);
            pessoa.setCabeloClaro(false);
            
            }
        }
        );
        
        //Pergunta 8
        id_sim_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_8.setSelected(false);
             pessoa.setOlhoEscuro(true);
            }
        }
        );
        id_nao_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_8.setSelected(false);
             pessoa.setOlhoEscuro(false);
            
            }
        }
        );
       
        
        
        
        
    }

    @FXML
    private AnchorPane id_pane;
    
    @FXML
    private JFXButton id_salvar;

    @FXML
    private JFXCheckBox id_nao_1;

    @FXML
    private JFXCheckBox id_sim_1;

    @FXML
    private JFXCheckBox id_sim_2;

    @FXML
    private JFXCheckBox id_nao_2;

    @FXML
    private JFXCheckBox id_sim_3;

    @FXML
    private JFXCheckBox id_nao_3;

    @FXML
    private JFXCheckBox id_sim_4;

    @FXML
    private JFXCheckBox id_nao_4;

    @FXML
    private JFXCheckBox id_sim_5;

    @FXML
    private JFXCheckBox id_nao_5;
    
    @FXML
    private JFXCheckBox id_sim_6;

    @FXML
    private JFXCheckBox id_nao_6;

    @FXML
    private JFXCheckBox id_sim_7;

    @FXML
    private JFXCheckBox id_nao_7;

    @FXML
    private JFXTextField id_nome;

    @FXML
    private JFXTextField id_idade;
     
    

    @FXML
    private JFXCheckBox id_sim_8;

    @FXML
    private JFXCheckBox id_nao_8;

    @FXML
    private JFXButton id_voltar;
    
    public List<Pessoa> Capturar_pessoas(){
        List<Pessoa> lista_pessoa = new ArrayList();
        lista_pessoa = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        return lista_pessoa;
    }
    public Boolean validacao(){
        ArrayList<Control> erros = new ArrayList<>();
       // StringBuilder sb = new StringBuilder();
//        for(Integer i=0 ; i<campos.size();i++){
//            if(i == 0){
//                campos.add("O campo nome é necessario!!");
//            }else if(i == 1){
//                campos.add("Campo idade é necessário!");
//            }
//            campos.add("Erros na checkBox!!");
//        }
        ValidationSupport validationSupport = new ValidationSupport();
       
        validationSupport.registerValidator(id_nome, Validator.createEmptyValidator("dsfsd"));
        erros.add(id_nome);
        
        validationSupport.registerValidator(id_idade, Validator.createEmptyValidator("Campo necessário!"));
        erros.add(id_idade);
        
        
        validationSupport.registerValidator(id_sim_1, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "KK EAE", !newValue));
        erros.add(id_sim_1);
//        validationSupport.registerValidator(id_nao_1, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_1);
        validationSupport.registerValidator(id_sim_2, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_2);
//        validationSupport.registerValidator(id_nao_2, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_2);
        
        validationSupport.registerValidator(id_sim_3, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_3);
//        validationSupport.registerValidator(id_nao_3, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_3);
        
        validationSupport.registerValidator(id_sim_4, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_4);
//        validationSupport.registerValidator(id_nao_4, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_4);
        
        validationSupport.registerValidator(id_sim_5, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_5);
//        validationSupport.registerValidator(id_nao_5, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_5);
        
        validationSupport.registerValidator(id_sim_6, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_6);
//        validationSupport.registerValidator(id_nao_6, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_6);
        
        validationSupport.registerValidator(id_sim_7, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_7);
//        validationSupport.registerValidator(id_nao_7, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_7);
//        
        validationSupport.registerValidator(id_sim_8, (Control c, Boolean newValue) ->
                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
        erros.add(id_sim_8);
//        validationSupport.registerValidator(id_nao_8, (Control c, Boolean newValue) ->
//                   ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue));
//        erros.add(id_nao_8);
//        
        if(!erros.isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro na aunteticação");
            alert.setTitle(":(");
            alert.setContentText("Problemas nos campos!");
            alert.show();
            return false;
        }else{
            return true;   
        }
            
        
        
        
//        validationSupport.registerValidator(textField, Validator.createEmptyValidator("Text is required"));
//        validationSupport.registerValidator(combobox, Validator.createEmptyValidator( "ComboBox Selection required"));
//        validationSupport.registerValidator(checkBox, (Control c, Boolean newValue) ->
//                    ValidationResult.fromErrorIf( c, "Checkbox should be checked", !newValue)
//      
   
    }
   
    
    
}
