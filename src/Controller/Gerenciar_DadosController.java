/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import ModelosTela.PessoaTela;
import Classes.ArquivoTxt;
import Classes.CadastraPessoa;
import Classes.Pessoa;
import Telas.GerenciarDados;
import Telas.MenuLogin;

import ModelosTela.PessoaTela;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.StyleableBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;


/**
 * FXML Controller class
 *
 * @author Flávio
 */
public class Gerenciar_DadosController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        carregarDados();
        
        
        
        id_voltar.setOnAction((ActionEvent event)->{
               voltar_login();
        });
        
        id_remover.setOnAction((ActionEvent event)->{
            
            String id = id_textfield.getText();
            Integer idInt = Integer.parseInt(id);
            excluirCadastro(idInt);
        
        });
        id_cadastrar.setOnAction((ActionEvent event )->{
        cadastrar();
    });
        
    }    
    
    @FXML
    private TableView<PessoaTela> tabela;
    @FXML
    private TableColumn<PessoaTela, Integer> coluna1;
    
    @FXML
    private TableColumn<PessoaTela, String> coluna2;
    
    @FXML
    private JFXButton id_voltar;
    
    @FXML
    private JFXButton id_remover;
    
    @FXML
    private JFXTextField id_textfield;
    
     @FXML
    private JFXButton id_ok;
      
    @FXML
    private JFXButton id_cadastrar;
     
    private List<PessoaTela> listClientes = new ArrayList();
    
    private ObservableList<PessoaTela> obsPerson;
   
    public void carregarDados(){
       id_textfield.setVisible(true);
       coluna1.setCellValueFactory(new PropertyValueFactory<>("cod"));
       coluna2.setCellValueFactory(new PropertyValueFactory<>("nome"));
       List<Pessoa> p2 = new ArrayList<>();
       p2 = ArquivoTxt.capturaTxt("dados_pessoas.txt");
      
       for(Integer i=0;i<p2.size();i++){
           
        PessoaTela pessoatela = new PessoaTela(p2.get(i).getCodPessoa(), p2.get(i).getNome());
        System.out.println(pessoatela.getCod());
        listClientes.add(pessoatela);
        
       }
       
       obsPerson = FXCollections.observableArrayList(listClientes);
       tabela.setItems(obsPerson);
      
       
    }

    public void voltar_login(){
        GerenciarDados.getStage().close();
        MenuLogin.getStage().show();
    }
    
    public void cadastrar(){
       List<Pessoa> p2 = new ArrayList<>();
       p2 = ArquivoTxt.capturaTxt("dados_pessoas.txt");
       p2 = CadastraPessoa.cadastraPessoa(p2);
    }
    public void excluirCadastro(Integer id){
        
       // Integer id = Integer.parseInt(id_textfield.getText());
      ArquivoTxt.excluirTxt("dados_pessoas.txt",id );
          
       
       
       
       System.out.println("Excluido com sucesso!");
        
    }
}
