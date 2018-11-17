package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import Telas.AnimacaoCampos;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import org.apache.commons.lang3.StringUtils;

public class Tela_de_alterar_pessoasController extends Cadastrar_PessoaController implements Initializable {

    List<Pessoa> lista_pessoas = new ArrayList<>();
    public static Integer cod;
    Integer cod2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregar_campos();
        System.out.println(cod);
        carregar_dados_da_pessoa();
        combo_boxs_alterar();
        check_boxs_alterar();

        btn_voltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    voltar();
                } catch (IOException ex) {
                    Logger.getLogger(Tela_de_alterar_pessoasController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        btn_salvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (validar_campos()) {
                    ArquivoTxt.Write("dados_pessoas.txt", lista_pessoas);
                    System.out.println("Salvo com sucesso na minha pica");
                } else {
                    System.out.println("CARAIO MEMO");
                }
            }
        });
    }

    public void voltar() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
        TrocarCenas.trocarcena_baixo(root, btn_voltar, id_painel);

    }

    public void carregar_dados_da_pessoa() {

        lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        for (Integer i = 0; i < lista_pessoas.size(); i++) {
            if (Objects.equals(lista_pessoas.get(i).getCodPessoa(), cod)) {
                cod2 = i;
                txt_nome_alterar.setText(lista_pessoas.get(i).getNome());
                if (lista_pessoas.get(i).isJogaLOL()) {
                    checkb_sim_lol.setSelected(true);
                } else {
                    checkb_nao_lol.setSelected(true);
                }

                if (lista_pessoas.get(i).isUsaOculos()) {
                    checkb_sim_oculos.setSelected(true);
                } else {
                    checkb_nao_oculos.setSelected(true);
                }

                if (lista_pessoas.get(i).isUsaChapeu()) {
                    checkb_sim_chapeu.setSelected(true);
                } else {
                    checkb_nao_chapeu.setSelected(true);
                }

                if (lista_pessoas.get(i).isTemPiercing()) {
                    checkb_sim_piercing.setSelected(true);
                } else {
                    checkb_nao_piercing.setSelected(true);
                }

                if (lista_pessoas.get(i).isProfessor()) {
                    checkb_sim_professor.setSelected(true);
                    cmb_disciplinas.setVisible(true);

                } else {
                    cmb_disciplinas.setVisible(false);
                    checkb_nao_professor.setSelected(true);
                }
                
                if (lista_pessoas.get(i).isLecionaPOO()) {
                    cmb_disciplinas.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isLecionaMAC()) {
                    cmb_disciplinas.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isLecionaAC()) {
                    cmb_disciplinas.getSelectionModel().select(2);
                } else if (lista_pessoas.get(i).isLecionaBD()) {
                    cmb_disciplinas.getSelectionModel().select(3);
                }

                if (lista_pessoas.get(i).isJogaCSGO()) {
                    checkb_sim_cs.setSelected(true);
                } else {
                    checkb_nao_cs.setSelected(true);
                }

                if (lista_pessoas.get(i).isBarba()) {
                    checkb_sim_barba.setSelected(true);
                } else {
                    checkb_nao_barba.setSelected(true);
                }

               

                if (lista_pessoas.get(i).isUsaRoupaSocial()) {
                    checkb_sim_roupasocial.setSelected(true);
                } else {
                    checkb_nao_roupasocial.setSelected(true);
                }

                if (lista_pessoas.get(i).isMasculino()) {
                    checkb_masc_sexo.setSelected(true);
                } else {
                    checkb_femn_sexo.setSelected(true);
                }

                if (lista_pessoas.get(i).isMaior20()) {
                    cmb_idade.getSelectionModel().select(1);
                } else {
                    cmb_idade.getSelectionModel().select(0);
                }

                if (lista_pessoas.get(i).isP_periodo() && lista_pessoas.get(i).isProfessor() == false) {
                    cmb_periodo.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isS_periodo()) {
                    cmb_periodo.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isT_periodo()) {
                    cmb_periodo.getSelectionModel().select(2);
                } else {
                    cmb_periodo.getSelectionModel().select(3);
                }

                if (lista_pessoas.get(i).isCalvo()) {
                    cmb_estilo_cabelo.getSelectionModel().select(0);

                    cmb_cor_cabelo.setDisable(true);
                    cmb_cor_cabelo.setPromptText("Tu és calvo manito");
                } else if (lista_pessoas.get(i).isCabeloOndulado() && lista_pessoas.get(i).isCabeloCurto()) {
                    cmb_estilo_cabelo.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isCabeloOndulado() && lista_pessoas.get(i).isCabeloMedio()) {
                    cmb_estilo_cabelo.getSelectionModel().select(2);
                } else if (lista_pessoas.get(i).isCabeloOndulado() && lista_pessoas.get(i).isCabeloLongo()) {
                    cmb_estilo_cabelo.getSelectionModel().select(3);
                } else if (lista_pessoas.get(i).isCabeloCrespo() && lista_pessoas.get(i).isCabeloCurto()) {
                    cmb_estilo_cabelo.getSelectionModel().select(4);
                } else if (lista_pessoas.get(i).isCabeloCrespo() && lista_pessoas.get(i).isCabeloMedio()) {
                    cmb_estilo_cabelo.getSelectionModel().select(5);
                } else if (lista_pessoas.get(i).isCabeloCrespo() && lista_pessoas.get(i).isCabeloLongo()) {
                    cmb_estilo_cabelo.getSelectionModel().select(6);
                } else if (lista_pessoas.get(i).isCabeloLiso() && lista_pessoas.get(i).isCabeloCurto()) {
                    cmb_estilo_cabelo.getSelectionModel().select(7);
                } else if (lista_pessoas.get(i).isCabeloLiso() && lista_pessoas.get(i).isCabeloMedio()) {
                    cmb_estilo_cabelo.getSelectionModel().select(8);
                } else if (lista_pessoas.get(i).isCabeloLiso() && lista_pessoas.get(i).isCabeloLongo()) {
                    cmb_estilo_cabelo.getSelectionModel().select(9);
                }

                if (lista_pessoas.get(i).isCabeloLoiro()) {
                    cmb_cor_cabelo.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isCabeloPreto()) {
                    cmb_cor_cabelo.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isCabeloCastanho()) {
                    cmb_cor_cabelo.getSelectionModel().select(2);
                } else if (lista_pessoas.get(i).isCabeloAvermelhado()) {
                    cmb_cor_cabelo.getSelectionModel().select(3);
                }

                if (lista_pessoas.get(i).isTomOlhoVerde()) {
                    cmb_cor_olhos.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isTomOlhoAzul()) {
                    cmb_cor_olhos.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isTomOlhoCastanho()) {
                    cmb_cor_olhos.getSelectionModel().select(2);
                }

//                if (lista_pessoas.get(i).isTomPeleEscura()) {
//                    cmb_tom_pele.getSelectionModel().select(0);
//                } else if (lista_pessoas.get(i).isTomPeleClaro()) {
//                    cmb_tom_pele.getSelectionModel().select(1);
//                }

            }
        }

    }

    public void carregar_campos() {
        cmb_disciplinas.setItems(super.lista_disciplinas);
        cmb_cor_cabelo.setItems(super.list_cor_cabelo);
        cmb_idade.setItems(super.lista_idade);
        cmb_cor_olhos.setItems(super.lista_cor_olhos);
        cmb_estilo_cabelo.setItems(super.list_estilo_cabelo);
        cmb_periodo.setItems(super.list_periodos);
        cmb_tom_pele.setItems(super.lista_tom_pele);
        cmb_disciplinas.setVisible(false);
    }

    public void check_boxs_alterar() {
        checkb_sim_professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_professor.setSelected(false);
                lista_pessoas.get(cod2).setProfessor(true);
                cmb_disciplinas.setVisible(true);
            }
        });

        checkb_nao_professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_professor.setSelected(false);
                lista_pessoas.get(cod2).setProfessor(false);
                cmb_disciplinas.setVisible(false);
            }
        }
        );
        //2
        checkb_sim_roupasocial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_roupasocial.setSelected(false);
                lista_pessoas.get(cod2).setUsaRoupaSocial(true);
            }
        });

        checkb_nao_roupasocial.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_roupasocial.setSelected(false);
                lista_pessoas.get(cod2).setUsaRoupaSocial(false);
            }
        }
        );
        //3
        checkb_sim_alto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_alto.setSelected(false);
//                lista_pessoas.get(cod2).setAlto(true);
            }
        });

        checkb_nao_alto.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_alto.setSelected(false);
//                lista_pessoas.get(cod2).setAlto(false);
            }
        }
        );
        //4
        checkb_sim_barba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_barba.setSelected(false);
                lista_pessoas.get(cod2).setBarba(true);
            }
        });

        checkb_nao_barba.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_barba.setSelected(false);
                lista_pessoas.get(cod2).setBarba(false);
            }
        }
        );
        //5
        checkb_sim_oculos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_oculos.setSelected(false);
                lista_pessoas.get(cod2).setUsaOculos(true);
            }
        });

        checkb_nao_oculos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_oculos.setSelected(false);
                lista_pessoas.get(cod2).setUsaOculos(false);
            }
        }
        );
        //6
        checkb_sim_lol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_lol.setSelected(false);
                lista_pessoas.get(cod2).setJogaLOL(true);
            }
        });

        checkb_nao_lol.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_lol.setSelected(false);
                lista_pessoas.get(cod2).setJogaLOL(false);
            }
        }
        );
        //7
        checkb_sim_cs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_cs.setSelected(false);
                lista_pessoas.get(cod2).setJogaCSGO(true);
            }
        });

        checkb_nao_cs.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_cs.setSelected(false);
                lista_pessoas.get(cod2).setJogaCSGO(false);
            }
        }
        );
        //8
        checkb_sim_piercing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_piercing.setSelected(false);
                lista_pessoas.get(cod2).setTemPiercing(true);
            }
        });

        checkb_nao_piercing.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_piercing.setSelected(false);
                lista_pessoas.get(cod2).setTemPiercing(false);
            }
        }
        );
        //9
        checkb_sim_chapeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_chapeu.setSelected(false);
                lista_pessoas.get(cod2).setUsaChapeu(true);
            }
        });

        checkb_nao_chapeu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_chapeu.setSelected(false);
                lista_pessoas.get(cod2).setUsaChapeu(false);
            }
        }
        );
        //10
        checkb_masc_sexo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_femn_sexo.setSelected(false);
                lista_pessoas.get(cod2).setMasculino(true);
            }
        });

        checkb_femn_sexo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_masc_sexo.setSelected(false);
                lista_pessoas.get(cod2).setMasculino(false);
            }
        }
        );

    }

    public void combo_boxs_alterar() {
        cmb_idade.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_idade.getValue().equals("Menor de 20 anos")) {

                    lista_pessoas.get(cod2).setMaior20(false);

                } else if (cmb_idade.getValue().equals("20 anos ou mais")) {

                    lista_pessoas.get(cod2).setMaior20(true);
                }
            }
        });

        cmb_periodo.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (cmb_periodo.getValue().equals("1º Periodo")) {
                    System.out.println("1 perido selecionado");
                    lista_pessoas.get(cod2).setP_periodo(true);
                    lista_pessoas.get(cod2).setS_periodo(false);
                    lista_pessoas.get(cod2).setT_periodo(false);

                } else if (cmb_periodo.getValue().equals("2º Periodo")) {
                    System.out.println("2 perido selecionado");
                    lista_pessoas.get(cod2).setP_periodo(false);
                    lista_pessoas.get(cod2).setS_periodo(true);
                    lista_pessoas.get(cod2).setT_periodo(false);
                } else if (cmb_periodo.getValue().equals("3º Periodo")) {
                    System.out.println("3 perido selecionado");
                    lista_pessoas.get(cod2).setP_periodo(false);
                    lista_pessoas.get(cod2).setS_periodo(false);
                    lista_pessoas.get(cod2).setT_periodo(true);
                } else if (cmb_periodo.getValue().equals("Nao Sou Aluno")) {
                    System.out.println("Nao sou aluno selecionado");
                    lista_pessoas.get(cod2).setP_periodo(false);
                    lista_pessoas.get(cod2).setS_periodo(false);
                    lista_pessoas.get(cod2).setT_periodo(false);
                }
            }

        });

        System.out.println("ComboCabelEstilo: " + cmb_estilo_cabelo.getValue());;
        cmb_estilo_cabelo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_estilo_cabelo.getValue().equals("Raspado/Calvo")) {
                    System.out.println("Raspado/Calvo");

                    lista_pessoas.get(cod2).setCalvo(true);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    lista_pessoas.get(cod2).setCabeloLoiro(false);
                    lista_pessoas.get(cod2).setCabeloPreto(false);
                    lista_pessoas.get(cod2).setCabeloCastanho(false);
                    lista_pessoas.get(cod2).setCabeloAvermelhado(false);
                    cmb_cor_cabelo.setDisable(true);
                    cmb_cor_cabelo.setPromptText("Tu és calvo manito");
                } else if (cmb_estilo_cabelo.getValue().equals("Ondulado e Curto")) {
                    System.out.println("Ondulado e Curto");
                    //vereficar se n precisa setar o calvo aqui tbm

                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(true);
                    lista_pessoas.get(cod2).setCabeloCurto(true);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Ondulado e Medio")) {
                    System.out.println("Ondulado e Medio");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(true);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(true);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Ondulado e Longo")) {
                    System.out.println("Ondulado e Longo");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(true);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(true);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Crespo e Curto")) {
                    System.out.println("Crespo e Curto");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(true);
                    lista_pessoas.get(cod2).setCabeloCrespo(true);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Crespo e Medio")) {
                    System.out.println("Crespo e Medio");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(true);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(true);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Crespo e Longo")) {
                    System.out.println("Crespo e Longo");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(true);
                    lista_pessoas.get(cod2).setCabeloLiso(false);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(true);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Liso e Curto")) {
                    System.out.println("Liso e Curto");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(true);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(true);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Liso e Medio")) {
                    System.out.println("Liso e Medio");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(true);
                    lista_pessoas.get(cod2).setCabeloMedio(true);
                    lista_pessoas.get(cod2).setCabeloLongo(false);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                } else if (cmb_estilo_cabelo.getValue().equals("Liso e Longo")) {
                    System.out.println("Liso e Longo");
                    lista_pessoas.get(cod2).setCalvo(false);
                    lista_pessoas.get(cod2).setCabeloOndulado(false);
                    lista_pessoas.get(cod2).setCabeloCurto(false);
                    lista_pessoas.get(cod2).setCabeloCrespo(false);
                    lista_pessoas.get(cod2).setCabeloLiso(true);
                    lista_pessoas.get(cod2).setCabeloMedio(false);
                    lista_pessoas.get(cod2).setCabeloLongo(true);

                    cmb_cor_cabelo.setDisable(false);
                    cmb_cor_cabelo.setPromptText("Selecione a cor do cabelo");
                }
            }

        });

        System.out.println("ComboCorCabelo: " + cmb_cor_cabelo.getValue());
        cmb_cor_cabelo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_cor_cabelo.getValue().equals("Loiro")) {
                    System.out.println("Cabelo Loiro");
                    lista_pessoas.get(cod2).setCabeloLoiro(true);
                    lista_pessoas.get(cod2).setCabeloPreto(false);
                    lista_pessoas.get(cod2).setCabeloCastanho(false);
                    lista_pessoas.get(cod2).setCabeloAvermelhado(false);

                } else if (cmb_cor_cabelo.getValue().equals("Preto")) {
                    System.out.println("Cabelo Preto");
                    lista_pessoas.get(cod2).setCabeloLoiro(false);
                    lista_pessoas.get(cod2).setCabeloPreto(true);
                    lista_pessoas.get(cod2).setCabeloCastanho(false);
                    lista_pessoas.get(cod2).setCabeloAvermelhado(false);

                } else if (cmb_cor_cabelo.getValue().equals("Castanho")) {
                    System.out.println("Cabelo Castanho");
                    lista_pessoas.get(cod2).setCabeloLoiro(false);
                    lista_pessoas.get(cod2).setCabeloPreto(false);
                    lista_pessoas.get(cod2).setCabeloCastanho(true);
                    lista_pessoas.get(cod2).setCabeloAvermelhado(false);

                } else if (cmb_cor_cabelo.getValue().equals("Avermelhado")) {
                    System.out.println("Cabelo Avermelhado");
                    lista_pessoas.get(cod2).setCabeloLoiro(false);
                    lista_pessoas.get(cod2).setCabeloPreto(false);
                    lista_pessoas.get(cod2).setCabeloCastanho(false);
                    lista_pessoas.get(cod2).setCabeloAvermelhado(true);

                }
            }

        });

        cmb_cor_olhos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_cor_olhos.getValue().equals("Verde")) {
                    lista_pessoas.get(cod2).setTomOlhoCastanho(false);
                    lista_pessoas.get(cod2).setTomOlhoVerde(true);
                    lista_pessoas.get(cod2).setTomOlhoAzul(false);
                } else if (cmb_cor_olhos.getValue().equals("Azul")) {
                    lista_pessoas.get(cod2).setTomOlhoCastanho(false);
                    lista_pessoas.get(cod2).setTomOlhoVerde(false);
                    lista_pessoas.get(cod2).setTomOlhoAzul(true);
                } else if (cmb_cor_olhos.getValue().equals("Castanho")) {
                    lista_pessoas.get(cod2).setTomOlhoCastanho(true);
                    lista_pessoas.get(cod2).setTomOlhoVerde(false);
                    lista_pessoas.get(cod2).setTomOlhoAzul(false);

                }
            }
        }
        );

        cmb_tom_pele.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (cmb_tom_pele.getValue().equals("Escura")) {

//                    lista_pessoas.get(cod2).setTomPeleClaro(false);
//                    lista_pessoas.get(cod2).setTomPeleEscura(true);

                } else if (cmb_tom_pele.getValue().equals("Claro")) {

//                    lista_pessoas.get(cod2).setTomPeleClaro(true);
//                    lista_pessoas.get(cod2).setTomPeleEscura(true);

                }
            }
        });
    }

    public boolean validar_campos() {

        Boolean nome = StringUtils.isBlank(txt_nome_alterar.getText());

        Boolean flag = true;

        if (nome == true) {
            AnimacaoCampos.vibrar(txt_nome_alterar);
            flag = false;
        }

        if (nome == false) {
            lista_pessoas.get(cod2).setNome(txt_nome_alterar.getText());
        }

        if (checkb_sim_professor.isSelected() == false && checkb_nao_professor.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_nao_professor);
            AnimacaoCampos.vibrar(checkb_sim_professor);
            flag = false;
        }
        if (checkb_sim_roupasocial.isSelected() == false && checkb_nao_roupasocial.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_roupasocial);
            AnimacaoCampos.vibrar(checkb_nao_roupasocial);
            flag = false;
        }
        if (checkb_sim_alto.isSelected() == false && checkb_nao_alto.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_alto);
            AnimacaoCampos.vibrar(checkb_nao_alto);
            flag = false;
        }
        if (checkb_sim_barba.isSelected() == false && checkb_nao_barba.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_barba);
            AnimacaoCampos.vibrar(checkb_nao_barba);
            flag = false;
        }
        if (checkb_sim_oculos.isSelected() == false && checkb_nao_oculos.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_oculos);
            AnimacaoCampos.vibrar(checkb_nao_oculos);
            flag = false;
        }
        if (checkb_sim_lol.isSelected() == false && checkb_nao_lol.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_lol);
            AnimacaoCampos.vibrar(checkb_nao_lol);
            flag = false;

        }
        if (checkb_masc_sexo.isSelected() == false && checkb_femn_sexo.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_femn_sexo);
            AnimacaoCampos.vibrar(checkb_masc_sexo);
            flag = false;

        }
        if (checkb_sim_cs.isSelected() == false && checkb_nao_cs.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_cs);
            AnimacaoCampos.vibrar(checkb_nao_cs);
            flag = false;

        }
        if (checkb_sim_piercing.isSelected() == false && checkb_nao_piercing.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_piercing);
            AnimacaoCampos.vibrar(checkb_nao_piercing);
            flag = false;

        }
        if (checkb_sim_chapeu.isSelected() == false && checkb_nao_chapeu.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_chapeu);
            AnimacaoCampos.vibrar(checkb_nao_chapeu);
            flag = false;

        }

        if (cmb_periodo.getSelectionModel().getSelectedItem() == null) {
            System.out.println("SELECIONAR CAMPO PERIODO");
            AnimacaoCampos.vibrar(cmb_periodo);
            flag = false;
        }
        if (cmb_estilo_cabelo.getSelectionModel().getSelectedItem() == null) {
            System.out.println("SELECIONAR CAMPO ESTILO CABELO");
            AnimacaoCampos.vibrar(cmb_estilo_cabelo);
            flag = false;
        }
        boolean name = cmb_estilo_cabelo.getSelectionModel().getSelectedItem() != "Raspado/Calvo";
        if (cmb_cor_cabelo.getSelectionModel().getSelectedItem() == null && name) {
            System.out.println("SELECIONAR CAMPO COR CABELO");
            AnimacaoCampos.vibrar(cmb_cor_cabelo);
            flag = false;
        }

        if (cmb_cor_olhos.getSelectionModel().getSelectedItem() == null) {
            System.out.println("SELECIONAR CAMPO COR OLHOS");
            AnimacaoCampos.vibrar(cmb_cor_olhos);
            flag = false;
        }
        if (cmb_tom_pele.getSelectionModel().getSelectedItem() == null) {
            System.out.println("SELECIONAR CAMPO TOM PELE");
            AnimacaoCampos.vibrar(cmb_tom_pele);
            flag = false;
        }
        if (cmb_disciplinas.getSelectionModel().getSelectedItem() == null && checkb_sim_professor.isSelected()) {
            System.out.println("SELECIONAR CAMPO A DISCIPLINA!");
            AnimacaoCampos.vibrar(cmb_disciplinas);
            flag = false;
        }

        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private JFXTextField txt_nome_alterar;

    @FXML
    private JFXComboBox cmb_disciplinas;

    @FXML
    private JFXComboBox cmb_idade;

    @FXML
    private JFXComboBox cmb_periodo;

    @FXML
    private JFXComboBox cmb_estilo_cabelo;

    @FXML
    private JFXComboBox cmb_cor_cabelo;

    @FXML
    private JFXComboBox cmb_cor_olhos;

    @FXML
    private JFXComboBox cmb_tom_pele;

    @FXML
    private JFXCheckBox checkb_sim_professor;

    @FXML
    private JFXCheckBox checkb_nao_professor;

    @FXML
    private JFXCheckBox checkb_sim_roupasocial;

    @FXML
    private JFXCheckBox checkb_nao_roupasocial;

    @FXML
    private JFXCheckBox checkb_sim_alto;

    @FXML
    private JFXCheckBox checkb_nao_alto;

    @FXML
    private JFXCheckBox checkb_sim_barba;

    @FXML
    private JFXCheckBox checkb_nao_barba;

    @FXML
    private JFXCheckBox checkb_sim_oculos;

    @FXML
    private JFXCheckBox checkb_nao_oculos;

    @FXML
    private JFXCheckBox checkb_sim_lol;

    @FXML
    private JFXCheckBox checkb_nao_lol;

    @FXML
    private JFXCheckBox checkb_sim_cs;

    @FXML
    private JFXCheckBox checkb_nao_cs;

    @FXML
    private JFXCheckBox checkb_sim_piercing;

    @FXML
    private JFXCheckBox checkb_nao_piercing;

    @FXML
    private JFXCheckBox checkb_sim_chapeu;

    @FXML
    private JFXCheckBox checkb_nao_chapeu;

    @FXML
    private JFXCheckBox checkb_masc_sexo;

    @FXML
    private JFXCheckBox checkb_femn_sexo;

    @FXML
    private JFXButton btn_salvar;

    @FXML
    private JFXButton btn_voltar;

    @FXML
    private AnchorPane id_painel;

}
