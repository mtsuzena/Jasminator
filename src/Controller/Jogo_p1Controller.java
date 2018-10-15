package Controller;

import Classes.ArquivoTxt;
import Classes.EliminaPessoas;
import Classes.ListaPerguntas;
import Classes.Pessoa;
import Telas.TrocarCenas;
import static Telas.TrocarCenas.cena_jogador;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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


public class Jogo_p1Controller implements Initializable {
    ArrayList<Integer> id = new ArrayList<>();
    ArrayList<String> perguntas = new ArrayList<>();
    List<Pessoa> lista_pessoas = new ArrayList<>();
    Integer resposta ;
    Integer k;
    Integer numero;
    Integer temCabelo;
    public static String nome;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limpar();
        lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
          
        embaralhar_pergunta();
            numero = id.get(k);
            id_label.setText(perguntas.get(numero));
       
        
        id_sim.setOnAction((ActionEvent event)->{

            resposta = 1;
             check();
             k++;
            if(k < 9){
             numero = id.get(k);
             id_label.setText(perguntas.get(numero));
            }
           
      }); 
       id_nao.setOnAction((ActionEvent event)->{
          
            resposta = 0 ;    
            
            check();
            k++;
            if(k < 9){
            numero = id.get(k);
            id_label.setText(perguntas.get(numero));
            }
          
      });
       
       id_voltar.setOnAction((ActionEvent event)->{
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
                TrocarCenas.trocarcena_baixo(root, id_voltar, id_pane);
                limpar();
            } catch (IOException ex) {
                Logger.getLogger(Jogo_p1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
      });
       
       
        
       
    }    
    
    @FXML
    private AnchorPane id_pane;
   
    @FXML
    private Text id_label;

    @FXML
    private JFXButton id_sim;

    @FXML
    private JFXButton id_nao;

    @FXML
    private JFXButton id_talvez;

    @FXML
    private JFXButton id_voltar;
    
    public void voltar () throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Menu_inicial.fxml"));
        TrocarCenas.trocarcena_baixo(root, id_voltar, id_pane);
    }
   
   
   
    
    public void embaralhar_pergunta(){
      
       
        ListaPerguntas lista_perguntas = new ListaPerguntas();
        perguntas = lista_perguntas.retornaLista();
        
        for(Integer j=0 ; j<9 ; j++)
            id.add(j);
        
        Collections.shuffle(id);
        Collections.shuffle(id);
    }
    public void check(){
        if(k < 9){
        if(!((temCabelo==0 || temCabelo==2) && (numero == 1 || numero== 6))){
                lista_pessoas=EliminaPessoas.getPredicaoPessoa(lista_pessoas, resposta, numero);
                
                if(numero==0 && resposta==0){
                    temCabelo=1;
                }
                
                if(numero==0 && resposta==1){
                    temCabelo=2;
                }
            }
        
         if(lista_pessoas.size()==1){
           Parent root;
            try {
                nome = lista_pessoas.get(0).getNome();
                root = FXMLLoader.load(getClass().getResource("/Fxml/Final_Jogo.fxml"));
                cena_jogador(root,id_pane);
                id_pane.getChildren().clear();
            } catch (IOException ex) {
                Logger.getLogger(Jogo_p1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
       
    } 
        
     if(k == 8){
        
         Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/Fxml/Final_Jogo_Unk.fxml"));
                cena_jogador(root,id_pane);
                id_pane.getChildren().clear();
            } catch (IOException ex) {
                Logger.getLogger(Jogo_p1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
            
     }   
        
        
        
    }
   
        
    
   

        public void limpar(){
                k = 0 ;
                temCabelo = 0;    
                id.clear();
                numero = 0;
                lista_pessoas.clear();
        }


}