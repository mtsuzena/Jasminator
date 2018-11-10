package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import Telas.AnimacaoCampos;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.apache.commons.lang3.StringUtils;

public class Cadastrar_PessoaController implements Initializable {
    private List<Pessoa> lista_pessoa = new ArrayList<>(); 
    Pessoa pessoa=null;  
    
    @FXML
    private GridPane id_grid;
    @FXML
    private Text id_label;
    
    @FXML
    private Label label_op_n_per_cor_cabelo;
    
    @FXML
    private JFXComboBox periodo_combobox; // Combo box para cadastrar o periodo do curso
    ObservableList<String> list_periodos = FXCollections.observableArrayList("1º Periodo","2º Periodo",
            "3º Periodo","Nao Sou Aluno");
    
    @FXML
    private JFXComboBox estilo_cabelo_combobox;
    ObservableList<String> list_estilo_cabelo = FXCollections.observableArrayList("Raspado/Calvo","Ondulado e Curto",
            "Ondulado e Medio","Ondulado e Longo","Crespo e Curto","Crespo e Medio","Crespo e Longo",
                "Liso e Curto","Liso e Medio","Liso e Longo");
    
    @FXML
    private JFXComboBox cor_cabelo_combobox;
    ObservableList<String> list_cor_cabelo = FXCollections.observableArrayList("Loiro","Preto",
            "Castanho","Avermelhado");
    
    @FXML
    private JFXComboBox cor_dos_olhos_combobox;
    ObservableList<String> lista_cor_olhos = FXCollections.observableArrayList("Verde","Azul","Castanho");
    
    @FXML
    private JFXComboBox tom_pele_combobox;
    ObservableList<String> lista_tom_pele = FXCollections.observableArrayList("Escura","Claro");
    
    @FXML
    private JFXComboBox disciplinas_combobox;
    ObservableList<String> lista_disciplinas = FXCollections.observableArrayList("Programação orientada a ódios",
            "Matemática aplicada a compieter", "Arquitetura de compiter","Banco de dados");
    
    @FXML
    private ImageView tela_cad_s_dis;

    @FXML
    private ImageView tela_cad_c_dis;
    
    @FXML
    private JFXComboBox cmb_idade;
    ObservableList<String> lista_idade = FXCollections.observableArrayList("Menor de 20 anos",
            "20 anos ou mais");
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tela_cad_s_dis.setVisible(true);
        tela_cad_c_dis.setVisible(false);
        
        disciplinas_combobox.setVisible(false);
        id_label_disciplinas.setVisible(false);
        
        pessoa= new Pessoa(); 
        lista_pessoa = Capturar_pessoas();
        cmb_idade.setItems(lista_idade);
        disciplinas_combobox.setItems(lista_disciplinas);
        periodo_combobox.setItems(list_periodos);
        estilo_cabelo_combobox.setItems(list_estilo_cabelo);
        cor_cabelo_combobox.setItems(list_cor_cabelo);
        cor_dos_olhos_combobox.setItems(lista_cor_olhos);
        tom_pele_combobox.setItems(lista_tom_pele);
        label_op_n_per_cor_cabelo.setVisible(false);
        disciplinas_combobox.setVisible(false);
        
        //System.out.println("INDEX DO COMBO: "+cor_cabelo_combobox.getVisibleRowCount());
        
        
        id_salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if(validacao()){
     
                    if(lista_pessoa != null){
                        if(lista_pessoa.size()!=0)
                            pessoa.setCodPessoa((lista_pessoa.get(lista_pessoa.size()-1).getCodPessoa()+1));
                        else
                            pessoa.setCodPessoa(1);
                    } 
                    
                     pessoa.setGraduadoQuimica(true);
                     pessoa.seteDoExercito(true);
                     pessoa.setTrabalhaBrafer(true);
                     pessoa.setTrabalhaMecanica(true);
                     pessoa.setTrabalhaAviario(true);
        
    
                    
                    ArquivoTxt.salvaTxt("dados_pessoas.txt", pessoa);
                    
                    //mensagem_salvar();
                    limpar_campos();
                    lista_pessoa = Capturar_pessoas();
                    pessoa= new Pessoa();
                    
                 }else{
                    
                    //Setar delay na mensagem 
                    Timeline timeline = new Timeline(new KeyFrame(
                    Duration.millis(5000),
                    kk -> mensagem_erro()));
                        timeline.play();
                    //limpar_campos();
                 }
            }
        });
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
        
        System.out.println("ComboPeriodo: "+periodo_combobox.getValue());
        
        cmb_idade.setOnAction(new EventHandler<ActionEvent>(){  
            @Override
            public void handle(ActionEvent event) {
                if(cmb_idade.getValue().equals("Menor de 20 anos")){
                    pessoa.setIdade(null);
                    pessoa.setMaior20(false);
                }else if(cmb_idade.getValue().equals("20 anos ou mais")){
                    pessoa.setIdade(null);
                    pessoa.setMaior20(true);
                }
            }
        });
        
        
        periodo_combobox.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event) {
                if(periodo_combobox.getValue().equals("1º Periodo")){
                    System.out.println("1 perido selecionado");
                    pessoa.setP_periodo(true);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(false);
                }else if (periodo_combobox.getValue().equals("2º Periodo")){
                    System.out.println("2 perido selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(true);
                    pessoa.setT_periodo(false);
                }else if (periodo_combobox.getValue().equals("3º Periodo")){
                    System.out.println("3 perido selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(true);
                }else if (periodo_combobox.getValue().equals("Nao Sou Aluno")){
                    System.out.println("Nao sou aluno selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(false);
                }
            }
            
        });
        
        System.out.println("ComboCabelEstilo: "+estilo_cabelo_combobox.getValue());;
        estilo_cabelo_combobox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(estilo_cabelo_combobox.getValue().equals("Raspado/Calvo")){
                    System.out.println("Raspado/Calvo");
                    pessoa.setCalvo(true);
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(false);   // seta as cores como falso, pois nao tem cabelo
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(false);
                    
                    System.out.println("ComboCorCabelo: "+cor_cabelo_combobox.getValue());
                    label_op_n_per_cor_cabelo.setVisible(true);
                    cor_cabelo_combobox.setVisible(false);
                }else if(estilo_cabelo_combobox.getValue().equals("Ondulado e Curto")){
                    System.out.println("Ondulado e Curto");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Ondulado e Medio")){
                    System.out.println("Ondulado e Medio");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Ondulado e Longo")){
                    System.out.println("Ondulado e Longo");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Crespo e Curto")){
                    System.out.println("Crespo e Curto");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Crespo e Medio")){
                    System.out.println("Crespo e Medio");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Crespo e Longo")){
                    System.out.println("Crespo e Longo");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Liso e Curto")){
                    System.out.println("Liso e Curto");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Liso e Medio")){
                    System.out.println("Liso e Medio");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }else if (estilo_cabelo_combobox.getValue().equals("Liso e Longo")){
                    System.out.println("Liso e Longo");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);
                    label_op_n_per_cor_cabelo.setVisible(false);
                    cor_cabelo_combobox.setVisible(true);
                }
            }
            
        });
        
        System.out.println("ComboCorCabelo: "+cor_cabelo_combobox.getValue());
        cor_cabelo_combobox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(cor_cabelo_combobox.getValue().equals("Loiro")){
                    System.out.println("Cabelo Loiro");
                    pessoa.setCabeloLoiro(true);
                    pessoa.setCabeloPreto(false);
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(false);
                }else if(cor_cabelo_combobox.getValue().equals("Preto")){
                    System.out.println("Cabelo Preto");
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(true);
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(false);
                }else if(cor_cabelo_combobox.getValue().equals("Castanho")){
                    System.out.println("Cabelo Castanho");
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(false);
                    pessoa.setCabeloCastanho(true);
                    pessoa.setCabeloAvermelhado(false);
                }else if(cor_cabelo_combobox.getValue().equals("Avermelhado")){
                    System.out.println("Cabelo Avermelhado");
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(false);
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(true);
                }
            }
            
        });
        
        cor_dos_olhos_combobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(cor_dos_olhos_combobox.getValue().equals("Verde")){
                    pessoa.setTomOlhoVerde(true);
                    pessoa.setTomOlhoAzul(false);
                    pessoa.setTomOlhoCastanho(false);   
                }else if (cor_dos_olhos_combobox.getValue().equals("Azul")){
                    pessoa.setTomOlhoVerde(false);
                    pessoa.setTomOlhoAzul(true);
                    pessoa.setTomOlhoCastanho(false);   
                }else if (cor_dos_olhos_combobox.getValue().equals("Castanho")){
                    pessoa.setTomOlhoVerde(false);
                    pessoa.setTomOlhoAzul(false);
                    pessoa.setTomOlhoCastanho(true);
                }
            }
        }
        );
        
        tom_pele_combobox.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
               if(tom_pele_combobox.getValue().equals("Escura")){
                   
                   pessoa.setTomPeleClaro(false);
                   pessoa.setTomPeleEscura(true);
                   
                   
               }else if(tom_pele_combobox.getValue().equals("Claro")){
                  
                   pessoa.setTomPeleClaro(true);
                   pessoa.setTomPeleEscura(false);
                   
               }
            }
        });
        
        
     
         
       
      //Pergunta 1
        id_sim_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_1.setSelected(false);
            pessoa.setMasculino(true);
            }
        });
        
        id_nao_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_1.setSelected(false);
            pessoa.setMasculino(false);
            }
        }
        );
        
       //Pergunta 2
       id_sim_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_2.setSelected(false);
            pessoa.setUsaRoupaSocial(true);
            
            }
        }
        );
        id_nao_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_sim_2.setSelected(false);
            pessoa.setUsaRoupaSocial(false);
            
            
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
            if(id_sim_5.isSelected()){
                disciplinas_combobox.setVisible(true);
                id_label_disciplinas.setVisible(true);
                tela_cad_s_dis.setVisible(false);
                tela_cad_c_dis.setVisible(true);
            }else{
                tela_cad_s_dis.setVisible(true);
                tela_cad_c_dis.setVisible(false);
                disciplinas_combobox.setVisible(false);
                id_label_disciplinas.setVisible(false);
            
            }
            
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
                pessoa.setJogaLOL(true);
            }
        }
                
        );
        id_nao_6.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_sim_6.setSelected(false);
                pessoa.setJogaLOL(false);    
            }
        }
        );
        //Pergunto 7
        id_sim_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_7.setSelected(false);
                pessoa.setJogaCSGO(true);
            }
        }
                
        );
        
        id_nao_7.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_sim_7.setSelected(false);
                pessoa.setJogaCSGO(false);    
            }
        }
        );
        
         id_sim_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_nao_8.setSelected(false);
                pessoa.setTemPiercing(true);
            }
        }
                
        );
        id_nao_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_sim_8.setSelected(false);
                pessoa.setTemPiercing(false);  
            }
        }
        );
        
        id_oculos_sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            id_oculos_nao.setSelected(false);
                pessoa.setUsaOculos(true);
            }
        }
                
        );
        id_oculos_nao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_oculos_sim.setSelected(false);
                pessoa.setUsaOculos(false);
            }
        }
        );
        
        id_chapeu_sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_chapeu_nao.setSelected(false);
                pessoa.setUsaChapeu(true);
            }
        }
                
        );
        id_chapeu_nao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                id_chapeu_sim.setSelected(false);
                pessoa.setUsaChapeu(false);
            }
        }
        );
        
           //if(id_sim_5.isSelected() == true && id_nao_5.isSelected() == false){
           
            
            disciplinas_combobox.setOnAction(new EventHandler<ActionEvent> () {
            @Override
            public void handle(ActionEvent event) {
            
                    if(disciplinas_combobox.getValue().equals("Programação orientada a ódios")){
                        pessoa.setLecionaPOO(true);
                        pessoa.setLecionaAC(false);
                        pessoa.setLecionaBD(false);
                        pessoa.setLecionaMAC(false);
                    }else if(disciplinas_combobox.getValue().equals("Matemática aplicada a compieter")){
                        pessoa.setLecionaPOO(false);
                        pessoa.setLecionaAC(false);
                        pessoa.setLecionaBD(false);
                        pessoa.setLecionaMAC(true);
                    }else if(disciplinas_combobox.getValue().equals("Banco de dados")){
                        pessoa.setLecionaPOO(false);
                        pessoa.setLecionaAC(false);
                        pessoa.setLecionaBD(true);
                        pessoa.setLecionaMAC(false);
                    }else if(disciplinas_combobox.getValue().equals("Arquitetura de compiter")){
                        pessoa.setLecionaPOO(false);
                        pessoa.setLecionaAC(true);
                        pessoa.setLecionaBD(false);
                        pessoa.setLecionaMAC(false);
                    }   
            }
            
        });
       //}
        
        
        
        
      
    }

    @FXML
    private Text id_label_disciplinas;

    
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
    private JFXTextField id_nome;
    
    
    @FXML
    private JFXButton id_voltar;
    
   
   
    @FXML
    private JFXCheckBox id_sim_7;

    @FXML
    private JFXCheckBox id_nao_7;
     
    @FXML
    private JFXCheckBox id_sim_8;

    @FXML
    private JFXCheckBox id_nao_8;
    
    @FXML
    private JFXCheckBox id_oculos_nao;
    
    @FXML
    private JFXCheckBox id_oculos_sim;
    
    @FXML
    private JFXCheckBox id_chapeu_nao;
    
    @FXML
    private JFXCheckBox id_chapeu_sim;
    
    
    
    public List<Pessoa> Capturar_pessoas(){
        List<Pessoa> lista_pessoa = new ArrayList();
        lista_pessoa = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        return lista_pessoa;
    
    }
    public Boolean validacao(){
       
        Boolean nome = StringUtils.isBlank(id_nome.getText());
        
        Boolean flag = true;
        
        if(nome == true){
                AnimacaoCampos.vibrar(id_nome);
                flag = false;
        }
        
        if(nome == false) {
            pessoa.setNome(id_nome.getText());
        }
        
          
        if(id_sim_1.isSelected() == false && id_nao_1.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_1);
                  AnimacaoCampos.vibrar(id_nao_1);  
                 flag = false;
            }
        if(id_sim_2.isSelected() == false && id_nao_2.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_2);
                  AnimacaoCampos.vibrar(id_nao_2); 
                  flag = false;
        }
        if(id_sim_3.isSelected() == false && id_nao_3.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_3);
                  AnimacaoCampos.vibrar(id_nao_3); 
                  flag = false;
        }
        if(id_sim_4.isSelected() == false && id_nao_4.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_4);
                  AnimacaoCampos.vibrar(id_nao_4); 
                 flag = false;
        }
        if(id_sim_5.isSelected() == false && id_nao_5.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_5);
                  AnimacaoCampos.vibrar(id_nao_5); 
                  flag = false;
        }
        if(id_sim_6.isSelected() == false && id_nao_6.isSelected() == false){
                  AnimacaoCampos.vibrar(id_sim_6);
                  AnimacaoCampos.vibrar(id_nao_6); 
                  flag = false;
       
        }
              
        if(flag){
            return true;
        }else{  
            return false;
        }
   }
   
    //Tirar msg de salvo com sucesso!
    public void mensagem_salvar(){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Arquivo Salvo!");
            alert.setTitle(":)");
            alert.setContentText("Cadastro realizado! ");
            alert.show();
            
    }
    public void mensagem_erro(){   
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("Erro ao tentar cadastrar uma nova pessoa");
            alert.setTitle(":(");
            alert.setContentText("Nome, idade inválidos ou checkboxs em brancos!");
            alert.show();
    }
    
    public void limpar_campos(){
        id_nome.clear();
        
        id_sim_1.setSelected(false);
        id_sim_2.setSelected(false);
        id_sim_3.setSelected(false);
        id_sim_4.setSelected(false);
        id_sim_5.setSelected(false);
        id_sim_6.setSelected(false);
        id_sim_7.setSelected(false);
        id_sim_8.setSelected(false);
        id_chapeu_sim.setSelected(false);
        id_oculos_sim.setSelected(false);
        
        id_nao_1.setSelected(false);
        id_nao_2.setSelected(false);
        id_nao_3.setSelected(false);
        id_nao_4.setSelected(false);
        id_nao_5.setSelected(false);
        id_nao_6.setSelected(false);
        id_nao_7.setSelected(false);
        id_nao_8.setSelected(false);
        id_chapeu_nao.setSelected(false);
        id_oculos_nao.setSelected(false);
        
        
        label_op_n_per_cor_cabelo.setVisible(false);
        cor_cabelo_combobox.setVisible(true);
        cor_cabelo_combobox.getSelectionModel().clearSelection();
        cor_dos_olhos_combobox.getSelectionModel().clearSelection();
        estilo_cabelo_combobox.getSelectionModel().clearSelection();
        disciplinas_combobox.getSelectionModel().clearSelection();
        tom_pele_combobox.getSelectionModel().clearSelection();
        periodo_combobox.getSelectionModel().clearSelection();
        
        
        
    }
    
    
}