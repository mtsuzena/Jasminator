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
import java.io.File;
import java.io.IOException;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import org.apache.commons.lang3.StringUtils;

public class Cadastrar_PessoaController implements Initializable {
    ArrayList<String> erros = new ArrayList<>();
    private List<Pessoa> lista_pessoa = new ArrayList<>();
    Pessoa pessoa = null;

    
      @FXML
    private JFXComboBox periodo_combobox; // Combo box para cadastrar o periodo do curso
    ObservableList<String> list_periodos = FXCollections.observableArrayList("1º Periodo", "2º Periodo",
            "3º Periodo");

    @FXML
    private JFXComboBox estilo_cabelo_combobox;
    ObservableList<String> list_estilo_cabelo = FXCollections.observableArrayList("Raspado/Calvo", "Ondulado e Curto",
            "Ondulado e Medio", "Ondulado e Longo", "Crespo e Curto", "Crespo e Medio", "Crespo e Longo",
            "Liso e Curto", "Liso e Medio", "Liso e Longo");

    @FXML
    private JFXComboBox cor_cabelo_combobox;
    ObservableList<String> list_cor_cabelo = FXCollections.observableArrayList("Loiro", "Preto",
            "Castanho", "Ruivo");

    @FXML
    private JFXComboBox cor_dos_olhos_combobox;
    ObservableList<String> lista_cor_olhos = FXCollections.observableArrayList("Verde", "Azul", "Castanho");

    @FXML
    private JFXComboBox tom_pele_combobox;
    ObservableList<String> lista_tom_pele = FXCollections.observableArrayList("Branca", "Pardo", "Negro");

    @FXML
    private JFXComboBox disciplinas_combobox;
    ObservableList<String> lista_disciplinas = FXCollections.observableArrayList("Programação orientada a objetos e Projeto Integrador",
            "Matemática aplicada a computação", "Arquitetura de computadores", "Banco de dados", "Não listado");

    @FXML
    private JFXComboBox cmb_idade;
    ObservableList<String> lista_idade = FXCollections.observableArrayList("Menor de 20 anos",
            "20 anos ou mais");

    //Cmb altura implement
    @FXML
    private JFXComboBox cmb_alturas;
    ObservableList<String> lista_alturas = FXCollections.observableArrayList("Entre 1.50 e 1.69",
            "Entre 1.70 e 1.79", "Entre 1.80 e 1.90");

    @FXML
    private JFXComboBox cmb_jogos;
    ObservableList<String> lista_jogos = FXCollections.observableArrayList("Counter - Strike Global Offensive",
            "Legue of Legends", "Fifa", "Overwatch",
            "Playerunknown's Battlegrounds","Fortnite",
            "Não jogo","Não listado");

    @FXML
    private JFXComboBox cmb_local_trabalho;
    ObservableList<String> lista_trabalho = FXCollections.observableArrayList("Delta cable", 
            "Mundo cell", "Renault",
            "Banco do Brasil", "Refrio", "Prefeitura da lapa", 
            "Prefeitura de Araucária", "Camera municipal de Araucária", 
            "Gelopar", "Abra","Brafer",
            "Aviário", "Mecânica","Alta Rail Technology","Empresa não listada","Não trabalho");

    @FXML
    private JFXComboBox cmb_curso;
    ObservableList<String> lista_curso = FXCollections.observableArrayList("Análise e Desenvolvimento de Sistemas", "Sistemas de Informação", "Nao Sou Aluno");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
       
        pessoa = new Pessoa();
        disciplinas_combobox.setDisable(true);
        
        lista_pessoa = Capturar_pessoas();
        cmb_idade.setItems(lista_idade);
        cmb_alturas.setItems(lista_alturas);
        disciplinas_combobox.setItems(lista_disciplinas);
        periodo_combobox.setItems(list_periodos);
        estilo_cabelo_combobox.setItems(list_estilo_cabelo);
        cor_cabelo_combobox.setItems(list_cor_cabelo);
        cor_dos_olhos_combobox.setItems(lista_cor_olhos);
        tom_pele_combobox.setItems(lista_tom_pele);
        
        cor_cabelo_combobox.setDisable(true);
        periodo_combobox.setDisable(true);
        cmb_jogos.setItems(lista_jogos);
        cmb_local_trabalho.setItems(lista_trabalho);
        cmb_curso.setItems(lista_curso);
        //System.out.println("INDEX DO COMBO: "+cor_cabelo_combobox.getVisibleRowCount());

        id_salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (validacao()) {

                    if (lista_pessoa != null) {
                        if (lista_pessoa.size() != 0) {
                            pessoa.setCodPessoa((lista_pessoa.get(lista_pessoa.size() - 1).getCodPessoa() + 1));
                        } else {
                            pessoa.setCodPessoa(1);
                        }
                    }

                    System.out.println("ART: "+pessoa.isTrabalhaART());
                    ArquivoTxt.salvaTxt("dados_pessoas.txt", pessoa);

                    //mensagem_salvar();
                    limpar_campos();
                    lista_pessoa = Capturar_pessoas();
                    pessoa = new Pessoa();
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
                        TrocarCenas.trocarcena_direita(root, id_voltar, id_pane);
                    } catch (IOException ex) {
                        Logger.getLogger(Cadastrar_PessoaController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } else {
                    mensagem_erro(erros);
                    //Setar delay na mensagem 
//                    Timeline timeline = new Timeline(new KeyFrame(
//                            Duration.millis(5000),
//                            kk -> mensagem_erro()));
//                    timeline.play();
                    //limpar_campos();
                }
            }
        });
        id_voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {

                    Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
                    TrocarCenas.trocarcena_direita(root, id_voltar, id_pane);

                    id_pane.getChildren().clear();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );
        
        btn_buscar_imagem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                buscar_imagem();
            }
        }
        );

        System.out.println("ComboPeriodo: " + periodo_combobox.getValue());

        cmb_idade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_idade.getValue().equals("Menor de 20 anos")) {
                    System.out.println("Menor 20");
                    pessoa.setIdade(0);
                    pessoa.setMaior20(false);
                } else if (cmb_idade.getValue().equals("20 anos ou mais")) {
                    pessoa.setIdade(0);
                    System.out.println("20 anos ou mais");
                    pessoa.setMaior20(true);
                }
            }
        });

        cmb_curso.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_curso.getValue().equals("Análise e Desenvolvimento de Sistemas")) {
                    System.out.println("KK EAE BAUM");
                    pessoa.setCursoADS(true);
                    pessoa.setCursoSI(false);
                    periodo_combobox.setDisable(false);
                } else if (cmb_curso.getValue().equals("Sistemas de Informação")) {
                    System.out.println("KK EAE BAUM 2");
                    pessoa.setCursoADS(false);
                    pessoa.setCursoSI(true);
                    periodo_combobox.setDisable(false);
                } else if (cmb_curso.getValue().equals("Nao Sou Aluno")) {
                    System.out.println("Nao sou aluno selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(false);
                    pessoa.setCursoADS(false);
                    pessoa.setCursoSI(false);
                    periodo_combobox.setDisable(true);
                }
            }
        });

        cmb_jogos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_jogos.getValue().equals("Counter - Strike Global Offensive")) {
                    System.out.println("Joga CS");
                    pessoa.setJogaCSGO(true);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                    
                } else if (cmb_jogos.getValue().equals("Legue of Legends")) {
                    System.out.println("Joga LOL");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(true);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                } else if (cmb_jogos.getValue().equals("Fifa")) {
                    System.out.println("Joga Fifa");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(true);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                } else if (cmb_jogos.getValue().equals("Fortnite")) {
                    System.out.println("Joga FortisNite");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(true);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                } else if (cmb_jogos.getValue().equals("Overwatch")) {
                    System.out.println("Joga Overwatch");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(true);
                    pessoa.setJogaPubg(false);
                } else if (cmb_jogos.getValue().equals("Playerunknown's Battlegrounds")) {
                    System.out.println("Joga PUBG");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(true);
                } else if (cmb_jogos.getValue().equals("Não jogo")) {
                    System.out.println("Não jogo");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                }else if (cmb_jogos.getValue().equals("Não listado")) {
                    System.out.println("Não listado");
                    pessoa.setJogaCSGO(false);
                    pessoa.setJogaLOL(false);
                    pessoa.setJogaFifa(false);
                    pessoa.setJogaFortinite(false);
                    pessoa.setJogaOverwatch(false);
                    pessoa.setJogaPubg(false);
                }
            }
        });

        cmb_alturas.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_alturas.getValue().equals("Entre 1.50 e 1.69")) {
                    System.out.println("Entre 1.50 e 1.69 selecionado");
                    pessoa.setAlturaAte69(true);
                    pessoa.setAlturaAte79(false);
                    pessoa.setAlturaAte90(false);
                } else if (cmb_alturas.getValue().equals("Entre 1.70 e 1.79")) {
                    System.out.println("Entre 1.70 e 1.79 selecionado");
                     pessoa.setAlturaAte69(false);
                    pessoa.setAlturaAte79(true);
                    pessoa.setAlturaAte90(false);
                } else if (cmb_alturas.getValue().equals("Entre 1.80 e 1.90")) {
                    System.out.println("Entre 1.80 e 1.90 selecionado");
                    pessoa.setAlturaAte69(false);
                    pessoa.setAlturaAte79(false);
                    pessoa.setAlturaAte90(true);
                }
            }
        });

        cmb_local_trabalho.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_local_trabalho.getValue().equals("Delta cable")) {
                    System.out.println("Delta cable");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(true);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Mundo cell")) {
                    System.out.println("Mundo cell");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(true);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Renault")) {
                    System.out.println("Renault");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(true);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Banco do Brasil")) {
                    System.out.println("Banco do Brasil");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(true);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Refrio")) {
                    System.out.println("Refrio");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(true);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Prefeitura da lapa")) {
                    System.out.println("Prefeitura da lapa");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(true);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Prefeitura de Araucária")) {
                    System.out.println("Prefeitura de araucaria");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(true);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Camera municipal de Araucária")) {
                    System.out.println("Camera municipal de Araucária");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(true);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Gelopar")) {
                    System.out.println("Gelopar");
                       pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(true);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Abra")) {
                    System.out.println("Abra");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(true);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } 
                else if (cmb_local_trabalho.getValue().equals("Aviário")) {
                    System.out.println("Aviário");
                    pessoa.setTrabalhaAviario(true);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                }else if (cmb_local_trabalho.getValue().equals("Brafer")) {
                    System.out.println("Brafer");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(true);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Mecânica")) {
                    System.out.println("Mecânica");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(true);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Alta Rail Technology")) {
                    System.out.println("Alta Rail Technology");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(true);
                }else if (cmb_local_trabalho.getValue().equals("Empresa não listada")) {
                    System.out.println("Alta Rail Technology");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                }else if (cmb_local_trabalho.getValue().equals("Não trabalho")) {
                    System.out.println("Não trabalho");
                    pessoa.setTrabalhaAviario(false);
                    pessoa.setTrabalhaMecanica(false);
                    pessoa.setTrabalhaBrafer(false);
                    pessoa.setTrabalhaBancoBrasil(false);
                    pessoa.setTrabalhaDeltaCable(false);
                    pessoa.setTrabalhaMundoCell(false);
                    pessoa.setTrabalhaRenault(false);
                    pessoa.setTrabalhaRefrio(false);
                    pessoa.setTrabalhaPrefeituraLapa(false);
                    pessoa.setTrabalhaGelopar(false);
                    pessoa.setTrabalhaAbra(false);
                    pessoa.setTrabalhaPrefeituraAraucaria(false);
                    pessoa.setTrabalhaCameraAraucaria(false);
                    pessoa.setTrabalhaART(false);
                }

            }
        });

        periodo_combobox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (periodo_combobox.getValue().equals("1º Periodo")) {
                    System.out.println("1 perido selecionado");
                    pessoa.setP_periodo(true);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(false);
                } else if (periodo_combobox.getValue().equals("2º Periodo")) {
                    System.out.println("2 perido selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(true);
                    pessoa.setT_periodo(false);
                } else if (periodo_combobox.getValue().equals("3º Periodo")) {
                    System.out.println("3 perido selecionado");
                    pessoa.setP_periodo(false);
                    pessoa.setS_periodo(false);
                    pessoa.setT_periodo(true);
                }
            }

        });

        System.out.println("ComboCabelEstilo: " + estilo_cabelo_combobox.getValue());;
        estilo_cabelo_combobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (estilo_cabelo_combobox.getValue().equals("Raspado/Calvo")) {
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

                    System.out.println("ComboCorCabelo: " + cor_cabelo_combobox.getValue());

                    cor_cabelo_combobox.setDisable(true);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Ondulado e Curto")) {
                    System.out.println("Ondulado e Curto");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Ondulado e Medio")) {
                    System.out.println("Ondulado e Medio");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Ondulado e Longo")) {
                    System.out.println("Ondulado e Longo");
                    pessoa.setCabeloOndulado(true);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Crespo e Curto")) {
                    System.out.println("Crespo e Curto");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Crespo e Medio")) {
                    System.out.println("Crespo e Medio");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Crespo e Longo")) {
                    System.out.println("Crespo e Longo");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(true);
                    pessoa.setCabeloLiso(false);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Liso e Curto")) {
                    System.out.println("Liso e Curto");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(true);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Liso e Medio")) {
                    System.out.println("Liso e Medio");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(true);
                    pessoa.setCabeloLongo(false);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                } else if (estilo_cabelo_combobox.getValue().equals("Liso e Longo")) {
                    System.out.println("Liso e Longo");
                    pessoa.setCabeloOndulado(false);
                    pessoa.setCabeloCurto(false);
                    pessoa.setCabeloCrespo(false);
                    pessoa.setCabeloLiso(true);
                    pessoa.setCabeloMedio(false);
                    pessoa.setCabeloLongo(true);
                    pessoa.setCalvo(false);

                    cor_cabelo_combobox.setDisable(false);
                    cor_cabelo_combobox.setPromptText("Selecione a cor de cabelo");
                }
            }

        });

        System.out.println("ComboCorCabelo: " + cor_cabelo_combobox.getValue());
        cor_cabelo_combobox.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (cor_cabelo_combobox.getValue().equals("Loiro")) {
                    System.out.println("Cabelo Loiro");
                    pessoa.setCabeloLoiro(true);
                    pessoa.setCabeloPreto(false);
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(false);
                } else if (cor_cabelo_combobox.getValue().equals("Preto")) {
                    System.out.println("Cabelo Preto");
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(true);
                    pessoa.setCabeloCastanho(false);
                    pessoa.setCabeloAvermelhado(false);
                } else if (cor_cabelo_combobox.getValue().equals("Castanho")) {
                    System.out.println("Cabelo Castanho");
                    pessoa.setCabeloLoiro(false);
                    pessoa.setCabeloPreto(false);
                    pessoa.setCabeloCastanho(true);
                    pessoa.setCabeloAvermelhado(false);
                } else if (cor_cabelo_combobox.getValue().equals("Ruivo")) {
                    System.out.println("Ruivo");
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
                if (cor_dos_olhos_combobox.getValue().equals("Verde")) {
                    System.out.println("Verde");
                    pessoa.setTomOlhoVerde(true);
                    pessoa.setTomOlhoAzul(false);
                    pessoa.setTomOlhoCastanho(false);
                } else if (cor_dos_olhos_combobox.getValue().equals("Azul")) {
                    System.out.println("Azul");
                    pessoa.setTomOlhoVerde(false);
                    pessoa.setTomOlhoAzul(true);
                    pessoa.setTomOlhoCastanho(false);
                } else if (cor_dos_olhos_combobox.getValue().equals("Castanho")) {
                    System.out.println("Castanho");
                    pessoa.setTomOlhoVerde(false);
                    pessoa.setTomOlhoAzul(false);
                    pessoa.setTomOlhoCastanho(true);
                }
            }
        }
        );

        tom_pele_combobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tom_pele_combobox.getValue().equals("Branca")) {

                    pessoa.setTomPeleClaro(true);
                    pessoa.setTomPeleEscura(false);
                    pessoa.setTomPelePardo(false);

                } else if (tom_pele_combobox.getValue().equals("Pardo")) {

                    pessoa.setTomPeleClaro(false);
                    pessoa.setTomPeleEscura(false);
                    pessoa.setTomPelePardo(true);

                } else if (tom_pele_combobox.getValue().equals("Negro")) {
                    System.out.println("PAU NO CU DESTE PROJETO DOCARAIO");
                    pessoa.setTomPeleClaro(false);
                    pessoa.setTomPeleEscura(true);
                    pessoa.setTomPelePardo(false);
                }
            }
        });

        //Pergunta 1 - CHECKBOX SEXO
        id_sim_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_sexo");
                id_nao_1.setSelected(false);
                pessoa.setMasculino(true);
            }
        });

        id_nao_1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_sexo");
                id_sim_1.setSelected(false);
                pessoa.setMasculino(false);
            }
        }
        );

        //Pergunta 2 = CHECK BOX USA ROUPA SOCIAL
        id_sim_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_roupa");
                id_nao_2.setSelected(false);
                pessoa.setUsaRoupaSocial(true);

            }
        }
        );
        id_nao_2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_roupa");
                id_sim_2.setSelected(false);
                pessoa.setUsaRoupaSocial(false);

            }
        }
        );

        //Pergunta 4 - CHECKBOX USA BARBA
        id_sim_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_barba");
                id_nao_4.setSelected(false);
                pessoa.setBarba(true);
            }
        }
        );
        id_nao_4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_barba");
                id_sim_4.setSelected(false);
                pessoa.setBarba(false);

            }
        }
        );

        //Pergunta 5 - CHECK BOX PROFESSOR
        id_sim_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_prof");
                id_nao_5.setSelected(false);
                pessoa.setProfessor(true);
                if (id_sim_5.isSelected()) {
                    disciplinas_combobox.setDisable(false);
                    disciplinas_combobox.setPromptText("Selecione a disciplina");
//                    disciplinas_combobox.setVisible(true);
//                    id_label_disciplinas.setVisible(true);

                } else {
                    disciplinas_combobox.setDisable(true);
                    disciplinas_combobox.setPromptText("Selecione a disciplina");
                }

            }
        }
        );
        id_nao_5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_prof");
                id_sim_5.setSelected(false);
                pessoa.setProfessor(false);
                disciplinas_combobox.setDisable(true);
                disciplinas_combobox.setPromptText("Selecione a disciplina");

            }
        }
        );

        //CHECKBOX - TEM PIERCING?
        id_sim_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim piercing");
                id_nao_8.setSelected(false);
                pessoa.setTemPiercing(true);
            }
        }
        );
        id_nao_8.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_pierc");
                id_sim_8.setSelected(false);
                pessoa.setTemPiercing(false);
            }
        }
        );

        id_oculos_sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_oculos");
                id_oculos_nao.setSelected(false);
                pessoa.setUsaOculos(true);
            }
        }
        );
        id_oculos_nao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_oculos");
                id_oculos_sim.setSelected(false);
                pessoa.setUsaOculos(false);
            }
        }
        );

        id_chapeu_sim.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_chapeu");
                id_chapeu_nao.setSelected(false);
                pessoa.setUsaChapeu(true);
            }
        }
        );
        id_chapeu_nao.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_chape");
                id_chapeu_sim.setSelected(false);
                pessoa.setUsaChapeu(false);
            }
        }
        );

        checkb_sim_depedencia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_depend");
                checkb_nao_depedencia.setSelected(false);
                pessoa.setDependencia(true);
            }
        }
        );
        
        checkb_nao_depedencia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_depend");
                checkb_sim_depedencia.setSelected(false);
                pessoa.setDependencia(false);
            }
        }
        );

        checkb_sim_aparelho.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_apaelho");
                checkb_nao_aparelho.setSelected(false);
                pessoa.setUsaAparelho(true);
            }
        }
        );
        checkb_nao_aparelho.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_apaelho");
                checkb_sim_aparelho.setSelected(false);
                pessoa.setUsaAparelho(false);
            }
        }
        );
        checkb_sim_tatuagem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Sim_tatu");
                checkb_nao_tatuagem.setSelected(false);
                pessoa.setTatuado(true);
            }
        }
        );
        checkb_nao_tatuagem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Nao_tatu");
                checkb_sim_tatuagem.setSelected(false);
                pessoa.setTatuado(false);
            }
        }
        );
        //if(id_sim_5.isSelected() == true && id_nao_5.isSelected() == false){

        disciplinas_combobox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (disciplinas_combobox.getValue().equals("Programação orientada a objetos e Projeto Integrador")) {
                    System.out.println("Programação orientada a objetos e Projeto Integrador");
                    pessoa.setLecionaPOO(true);
                    pessoa.setLecionaAC(false);
                    pessoa.setLecionaBD(false);
                    pessoa.setLecionaMAC(false);
                } else if (disciplinas_combobox.getValue().equals("Matemática aplicada a computação")) {
                    System.out.println("Matemática aplicada a computação");
                    pessoa.setLecionaPOO(false);
                    pessoa.setLecionaAC(false);
                    pessoa.setLecionaBD(false);
                    pessoa.setLecionaMAC(true);
                } else if (disciplinas_combobox.getValue().equals("Banco de dados")) {
                    System.out.println("Banco de dados");
                    pessoa.setLecionaPOO(false);
                    pessoa.setLecionaAC(false);
                    pessoa.setLecionaBD(true);
                    pessoa.setLecionaMAC(false);
                } else if (disciplinas_combobox.getValue().equals("Arquitetura de computadores")) {
                    System.out.println("Arquitetura de computadores");
                    pessoa.setLecionaPOO(false);
                    pessoa.setLecionaAC(true);
                    pessoa.setLecionaBD(false);
                    pessoa.setLecionaMAC(false);
                } else if (disciplinas_combobox.getValue().equals("Não listado")) {
                    System.out.println("Não listado");
                    pessoa.setLecionaPOO(false);
                    pessoa.setLecionaAC(false);
                    pessoa.setLecionaBD(false);
                    pessoa.setLecionaMAC(false);
                }

            }

        });
        //}

    }

    @FXML
    private AnchorPane id_pane;

    @FXML
    private JFXButton id_voltar;

    @FXML
    private JFXButton id_salvar;



    @FXML
    private JFXCheckBox id_sim_1;

    @FXML
    private JFXCheckBox id_nao_1;

    @FXML
    private JFXCheckBox id_sim_2;

    @FXML
    private JFXCheckBox id_nao_2;

    @FXML
    private JFXCheckBox id_sim_4;

    @FXML
    private JFXCheckBox id_nao_4;

    @FXML
    private JFXCheckBox id_oculos_sim;

    @FXML
    private JFXCheckBox id_oculos_nao;

    @FXML
    private JFXCheckBox id_sim_8;

    @FXML
    private JFXCheckBox id_nao_8;

    @FXML
    private JFXCheckBox id_chapeu_sim;

    @FXML
    private JFXCheckBox id_chapeu_nao;

    @FXML
    private JFXCheckBox id_sim_5;

    @FXML
    private JFXCheckBox id_nao_5;

    @FXML
    private JFXTextField id_nome;

    @FXML
    private JFXCheckBox checkb_sim_depedencia;

    @FXML
    private JFXCheckBox checkb_nao_depedencia;

    @FXML
    private JFXCheckBox checkb_sim_aparelho;

    @FXML
    private JFXCheckBox checkb_nao_aparelho;

    @FXML
    private JFXCheckBox checkb_sim_tatuagem;

    @FXML
    private JFXCheckBox checkb_nao_tatuagem;
    
    @FXML
    private JFXButton btn_buscar_imagem;

    @FXML
    private ImageView img_pessoa;

    public List<Pessoa> Capturar_pessoas() {
        List<Pessoa> lista_pessoa = new ArrayList();
        lista_pessoa = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        return lista_pessoa;

    }

    public Boolean validacao() {
        
        Boolean nome = StringUtils.isBlank(id_nome.getText());

        Boolean flag = true;

        if (nome == true) {
            AnimacaoCampos.vibrar(id_nome);
            flag = false;
            erros.add("Nome");
        }

        if (nome == false) {
            pessoa.setNome(id_nome.getText());
        }

        if (id_sim_1.isSelected() == false && id_nao_1.isSelected() == false) {
            AnimacaoCampos.vibrar(id_sim_1);
            AnimacaoCampos.vibrar(id_nao_1);
            flag = false;
            erros.add("Sexo");
        }
        if (id_sim_2.isSelected() == false && id_nao_2.isSelected() == false) {
            AnimacaoCampos.vibrar(id_sim_2);
            AnimacaoCampos.vibrar(id_nao_2);
            flag = false;
            erros.add("Usa roupa social");
        }

        if (id_sim_4.isSelected() == false && id_nao_4.isSelected() == false) {
            AnimacaoCampos.vibrar(id_sim_4);
            AnimacaoCampos.vibrar(id_nao_4);
            flag = false;
            erros.add("Tem barba");
        }
        if (id_sim_5.isSelected() == false && id_nao_5.isSelected() == false) {
            AnimacaoCampos.vibrar(id_sim_5);
            AnimacaoCampos.vibrar(id_nao_5);
            flag = false;
            erros.add("Professor");
        }
       if (id_sim_8.isSelected() == false && id_nao_8.isSelected() == false) {
            AnimacaoCampos.vibrar(id_sim_8);
            AnimacaoCampos.vibrar(id_nao_8);
            flag = false;
            erros.add("Tem piercing");
        }
        if (id_oculos_sim.isSelected() == false && id_oculos_nao.isSelected() == false) {
            AnimacaoCampos.vibrar(id_oculos_nao);
            AnimacaoCampos.vibrar(id_oculos_sim);
            flag = false;
            erros.add("Usa óculos");
        }
         if (id_chapeu_sim.isSelected() == false && id_chapeu_nao.isSelected() == false) {
            AnimacaoCampos.vibrar(id_chapeu_nao);
            AnimacaoCampos.vibrar(id_chapeu_sim);
            flag = false;
            erros.add("Usa boné/chapeu");
        }
        
        if(checkb_sim_depedencia.isSelected() == false && checkb_nao_depedencia.isSelected() == false){
            AnimacaoCampos.vibrar(checkb_sim_depedencia);
            AnimacaoCampos.vibrar(checkb_nao_depedencia);
            flag = false;
            erros.add("Faz depedencia");
        }
         if(checkb_nao_tatuagem.isSelected() == false && checkb_sim_tatuagem.isSelected() == false){
            AnimacaoCampos.vibrar(checkb_nao_tatuagem);
            AnimacaoCampos.vibrar(checkb_sim_tatuagem);
            flag = false;
            erros.add("Tem tatuagem");
        }
         if(checkb_nao_aparelho.isSelected() == false && checkb_sim_aparelho.isSelected() == false){
            AnimacaoCampos.vibrar(checkb_sim_aparelho);
            AnimacaoCampos.vibrar(checkb_sim_aparelho);
            flag = false;
            erros.add("Usa aparelho");
        }
         
         
         
        if(cmb_idade.getSelectionModel().getSelectedItem() == null){
            erros.add("Idade");
            flag = false;
        }
        
        if(cmb_curso.getSelectionModel().getSelectedItem() == null){
            erros.add("Curso");
            flag = false;
        }else{
          if(!cmb_curso.getValue().equals("Nao Sou Aluno")){
            if (periodo_combobox.getSelectionModel().getSelectedItem() == null) {
                erros.add("Periodo");
                flag = false;
          }  
          
          }
        }
        
      
          
    
         
        
        if (estilo_cabelo_combobox.getSelectionModel().getSelectedItem() == null) {
            erros.add("Estilo de cabelo");
            flag = false;
        }else{
            if(!estilo_cabelo_combobox.getValue().equals("Raspado/Calvo"))
            if (cor_cabelo_combobox.getSelectionModel().getSelectedItem() == null) {
                 erros.add("Cor de cabelo");
                 flag = false;
                
            }
        }
        
         
           
         
         
        
        if (cor_dos_olhos_combobox.getSelectionModel().getSelectedItem() == null) {
            erros.add("Cor dos olhos");
            flag = false;
        }
        if (tom_pele_combobox.getSelectionModel().getSelectedItem() == null) {
             erros.add("Tom de pele");
             flag = false;
        }
        if (disciplinas_combobox.getSelectionModel().getSelectedItem() == null && id_sim_5.isSelected()) {
            erros.add("Disciplinas");
            flag = false;
        }
        if (cmb_local_trabalho.getSelectionModel().getSelectedItem() == null ) {
            erros.add("Local de trabalho");
            flag = false;
        }
        
        if(cmb_alturas.getSelectionModel().getSelectedItem() == null){
            erros.add("Altura");
            
            flag = false;
        }
        if(cmb_jogos.getSelectionModel().getSelectedItem() == null){
             erros.add("Jogo favorito");
             flag = false;
        }
        
        
        
        
        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    //Tirar msg de salvo com sucesso!
    public void mensagem_salvar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Arquivo Salvo!");
        alert.setTitle(":)");
        alert.setContentText("Cadastro realizado! ");
        alert.show();

    }

    public void mensagem_erro(ArrayList<String> erro) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setHeaderText("Os seguintes campos precisão ser preenchidos!");
        alert.setTitle(":(");
        alert.setContentText(erro.toString());
        alert.show();
        erros.clear();
    }

    public void limpar_campos() {
        id_nome.clear();

        id_sim_1.setSelected(false);
        id_sim_2.setSelected(false);
        id_sim_4.setSelected(false);
        id_sim_5.setSelected(false);

        id_sim_8.setSelected(false);
        id_chapeu_sim.setSelected(false);
        id_oculos_sim.setSelected(false);

        id_nao_1.setSelected(false);
        id_nao_2.setSelected(false);

        id_nao_4.setSelected(false);
        id_nao_5.setSelected(false);
        id_nao_8.setSelected(false);
        id_chapeu_nao.setSelected(false);
        id_oculos_nao.setSelected(false);

    }
    
    public void buscar_imagem(){
       FileChooser fc = new FileChooser();
       fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg", "*.jpg","pnj","*.png"));
       File seletedFile = fc.showOpenDialog(null);
       if(seletedFile != null){
           Image img = new Image(seletedFile.toURI().toString());
           System.out.println(seletedFile.toURI().toString());
           img_pessoa.setImage(img);
           pessoa.setCaminho_imagem(seletedFile.toURI().toString());
       }
    }

}
