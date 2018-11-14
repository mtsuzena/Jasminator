package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import ModelosTela.PessoaTela;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Gerenciar_DadosController implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        coluna1.setCellValueFactory(new PropertyValueFactory<>("cod"));
        coluna2.setCellValueFactory(new PropertyValueFactory<>("nome"));
        carregarDados();
        
        id_voltar.setOnAction((ActionEvent event)->{
               voltar_login();
        });
        
        btn_alterar.setOnAction((ActionEvent event)->{
            alterar();
        });
        
        id_cadastrar.setOnAction((ActionEvent event )->{
            try {
                cadastrar();
            } catch (IOException ex) {
                Logger.getLogger(Gerenciar_DadosController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
//        tabela.getSelectionModel().selectedItemProperty().addListener((obsPerson,oldValue, newValue)-> {
//            Tela_de_alterar_pessoasController.carregar_dados(selecionar_item(newValue));
//        });
        
        tabela.getSelectionModel().selectedItemProperty().addListener((obsPerson,oldValue, newValue)-> {
            selecionar_item_2(newValue);
        });
                
        id_remover.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
                excluirCadastro();
            }
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
    private JFXButton id_ok;
     
    @FXML
    private JFXButton btn_alterar;
      
    @FXML
    private JFXButton id_cadastrar;
    @FXML
    private AnchorPane id_anchor;
     
    private List<PessoaTela> lista_pesssoa_tab = new ArrayList();
    
    private ObservableList<PessoaTela> obsPerson;
   
    public void carregarDados(){
        List<Pessoa> lista_pessoas = new ArrayList<>();
        lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        for(Integer i=0;i<lista_pessoas.size();i++){ 
            PessoaTela pessoatela = new PessoaTela(lista_pessoas.get(i).getCodPessoa(), lista_pessoas.get(i).getNome());
            System.out.println(pessoatela.getCod());
            lista_pesssoa_tab.add(pessoatela);
        }
        obsPerson = FXCollections.observableArrayList(lista_pesssoa_tab);
        tabela.setItems(obsPerson); 
    }

    public void voltar_login(){
        try{
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_login.fxml"));
            id_anchor.setVisible(false);
            TrocarCenas.trocarcena_baixo(root, id_voltar, id_anchor);
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void alterar(){
        try{
            PessoaTela pessoa = tabela.getSelectionModel().getSelectedItem(); 
            Tela_de_alterar_pessoasController.cod = pessoa.getCod();
            Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Tela_de_alterar_pessoas.fxml"));
            TrocarCenas.trocarcena_baixo(root,btn_alterar, id_anchor);
        }catch(Exception e){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Selecione alguém por favor caraiooo!");
            alert.setTitle(":(");
            alert.show();
        }
        
    }
    
    public void cadastrar() throws IOException{
//       List<Pessoa> p2 = new ArrayList<>();
//       p2 = ArquivoTxt.capturaTxt("dados_pessoas.txt");
//       p2 = CadastraPessoa.cadastraPessoa(p2);
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Cadastrar_Pessoa.fxml"));
        TrocarCenas.trocarcena_baixo(root, id_cadastrar, id_anchor);
    }
   
    
    public void excluirCadastro(){
      
        PessoaTela pessoa = tabela.getSelectionModel().getSelectedItem(); 
        if(pessoa != null){
            ArquivoTxt.excluirTxt("dados_pessoas.txt",pessoa.getCod() );
            System.out.println("Excluido com sucesso!");
            recarregar();
            carregarDados();
        }else{
            Image image = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/Emojione_1F62D.svg/64px-Emojione_1F62D.svg.png");
            ImageView imageView = new ImageView(image);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Seleciona ai ku!");
            alert.setTitle(":(");
            alert.setGraphic(imageView);
            alert.showAndWait();
        }
    }
    
//    public Integer selecionar_item(PessoaTela pessoa){
//
//         return pessoa.getCod();
//    }
    
    public void selecionar_item_2(PessoaTela pessoa){
       if(pessoa != null){   
        System.out.println("kk eae ");
       }
    }

    
    
    
    public void recarregar(){
        tabela.getItems().clear();
        tabela.refresh(); 
        lista_pesssoa_tab.clear();
    }
}