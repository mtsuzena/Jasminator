package Controller;

import Classes.ArquivoTxt;
import Classes.Pessoa;
import Telas.AnimacaoCampos;
import Telas.TrocarCenas;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import org.apache.commons.lang3.StringUtils;

public class Tela_de_alterar_pessoasController extends Cadastrar_PessoaController implements Initializable {

    ArrayList<String> erros_alterar = new ArrayList<>();
   
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
                
                    
                    Parent root;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/Fxml/Gerenciar_Dados.fxml"));
                        TrocarCenas.trocarcena_baixo(root, btn_voltar, id_painel);
                    } catch (IOException ex) {
                        Logger.getLogger(Tela_de_alterar_pessoasController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } else {
                   msg_erro();
                }
            }
        });
        
        btn_carregar_imagem.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
               buscar_imagem();
            }
        });
    }
    
    
    public void msg_erro(){
        super.mensagem_erro(erros);
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
                if(!lista_pessoas.get(i).getCaminho_imagem().equals("null")){
                    Image img = new Image(lista_pessoas.get(i).getCaminho_imagem());
                    img_view.setImage(img);
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
                    cmb_disciplinas.setDisable(false);

                } else {
                    cmb_disciplinas.setDisable(true);
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
                }else{
                    cmb_disciplinas.getSelectionModel().select(4);
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

                if (lista_pessoas.get(i).isP_periodo()) {
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

                if (lista_pessoas.get(i).isCursoSI()) {
                    cmb_curso.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isCursoADS()) {
                    cmb_curso.getSelectionModel().select(0);
                } else {
                    cmb_periodo.setDisable(true);
                    cmb_curso.getSelectionModel().select(2);
                }

                if (lista_pessoas.get(i).isDependencia()) {
                    checkbox_sim_depedencia.setSelected(true);
                } else {
                    checkbox_nao_depedencia.setSelected(true);
                }
                
                if (lista_pessoas.get(i).isTrabalhaDeltaCable()) {
                    cmb_local_trabalho.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isTrabalhaMundoCell()) {
                    cmb_local_trabalho.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isTrabalhaRenault()) {
                    cmb_local_trabalho.getSelectionModel().select(2);
                } else if (lista_pessoas.get(i).isTrabalhaBancoBrasil()) {
                    cmb_local_trabalho.getSelectionModel().select(3);
                } else if (lista_pessoas.get(i).isTrabalhaRefrio()) {
                    cmb_local_trabalho.getSelectionModel().select(4);
                } else if (lista_pessoas.get(i).isTrabalhaPrefeituraLapa()) {
                    cmb_local_trabalho.getSelectionModel().select(5);
                } else if (lista_pessoas.get(i).isTrabalhaPrefeituraAraucaria()) {
                    cmb_local_trabalho.getSelectionModel().select(6);
                } else if (lista_pessoas.get(i).isTrabalhaCameraAraucaria()) {
                    cmb_local_trabalho.getSelectionModel().select(7);
                } else if (lista_pessoas.get(i).isTrabalhaGelopar()) {
                    cmb_local_trabalho.getSelectionModel().select(8);
                } else if (lista_pessoas.get(i).isTrabalhaAbra()) {
                    cmb_local_trabalho.getSelectionModel().select(9);
                } else if (lista_pessoas.get(i).isTrabalhaBrafer()) {
                    cmb_local_trabalho.getSelectionModel().select(10);
                } else if (lista_pessoas.get(i).isTrabalhaAviario()) {
                    cmb_local_trabalho.getSelectionModel().select(11);
                } else if (lista_pessoas.get(i).isTrabalhaMecanica()) {
                    cmb_local_trabalho.getSelectionModel().select(12);
                } else if (lista_pessoas.get(i).isTrabalhaART()) {
                    cmb_local_trabalho.getSelectionModel().select(13);
                }else{
                    cmb_local_trabalho.getSelectionModel().select(14);
                }

//terminar o combobox de local trabalho
                if (lista_pessoas.get(i).isTomPeleClaro()) {
                    cmb_tom_pele.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isTomPelePardo()) {
                    cmb_tom_pele.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isTomPeleEscura()) {
                    cmb_tom_pele.getSelectionModel().select(2);
                }
                if (lista_pessoas.get(i).isTatuado()) {
                    checkbox_sim_tatuagem.setSelected(true);
                } else {
                    checkbox_nao_tatuagem.setSelected(true);
                }

                if (lista_pessoas.get(i).isAlturaAte69()) {
                    cmb_altura.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isAlturaAte79()) {
                    cmb_altura.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isAlturaAte90()) {
                    cmb_altura.getSelectionModel().select(2);
                }

                if (lista_pessoas.get(i).isUsaAparelho()) {
                    checkbox_sim_aparelho.setSelected(true);
                } else {
                    checkbox_nao_aparelho.setSelected(true);
                }

                if (lista_pessoas.get(i).isJogaCSGO()) {
                    cmb_jogos.getSelectionModel().select(0);
                } else if (lista_pessoas.get(i).isJogaLOL()) {
                    cmb_jogos.getSelectionModel().select(1);
                } else if (lista_pessoas.get(i).isJogaFifa()) {
                    cmb_jogos.getSelectionModel().select(2);
                } else if (lista_pessoas.get(i).isJogaOverwatch()) {
                    cmb_jogos.getSelectionModel().select(3);
                } else if (lista_pessoas.get(i).isJogaPubg()) {
                    cmb_jogos.getSelectionModel().select(4);
                } else if (lista_pessoas.get(i).isJogaFortinite()) {
                    cmb_jogos.getSelectionModel().select(5);
                }else{
                    cmb_jogos.getSelectionModel().select(6);
                }

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
        cmb_curso.setItems(super.lista_curso);
        cmb_local_trabalho.setItems(super.lista_trabalho);
        cmb_altura.setItems(lista_alturas);
        cmb_jogos.setItems(lista_jogos);

    }

    public void check_boxs_alterar() {
        checkbox_sim_aparelho.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_nao_aparelho.setSelected(false);
                lista_pessoas.get(cod2).setUsaAparelho(true);
            }
        });
        checkbox_nao_aparelho.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_sim_aparelho.setSelected(false);
                lista_pessoas.get(cod2).setUsaAparelho(false);
            }
        });

        checkbox_sim_tatuagem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_nao_tatuagem.setSelected(false);
                lista_pessoas.get(cod2).setTatuado(true);
            }
        }
        );
        checkbox_nao_tatuagem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_sim_tatuagem.setSelected(false);
                lista_pessoas.get(cod2).setTatuado(false);
            }
        }
        );

        checkbox_sim_depedencia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_nao_depedencia.setSelected(false);
                lista_pessoas.get(cod2).setDependencia(true);
            }
        });
        checkbox_nao_depedencia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkbox_sim_depedencia.setSelected(false);
                lista_pessoas.get(cod2).setDependencia(false);
            }
        });

        checkb_sim_professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_nao_professor.setSelected(false);
                lista_pessoas.get(cod2).setProfessor(true);
                cmb_disciplinas.setDisable(false);
            }
        });

        checkb_nao_professor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                checkb_sim_professor.setSelected(false);
                lista_pessoas.get(cod2).setProfessor(false);
                cmb_disciplinas.setDisable(true);
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

        //7
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
        cmb_jogos.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (cmb_jogos.getValue().equals("Counter - Strike Global Offensive")) {
                    lista_pessoas.get(cod2).setJogaCSGO(true);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(false);

                } else if (cmb_jogos.getValue().equals("Legue of Legends")) {
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(true);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(false);
                } else if (cmb_jogos.getValue().equals("Fifa")) {
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(true);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(false);
                } else if (cmb_jogos.getValue().equals("Overwatch")) {
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(true);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(false);
                } else if (cmb_jogos.getValue().equals("Playerunknown's Battlegrounds")) {
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(true);
                    lista_pessoas.get(cod2).setJogaFortinite(false);
                } else if (cmb_jogos.getValue().equals("Fortnite")) {
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(true);
                }else if(cmb_jogos.getValue().equals("Não jogo/Não listado")){
                    
                    lista_pessoas.get(cod2).setJogaCSGO(false);
                    lista_pessoas.get(cod2).setJogaLOL(false);
                    lista_pessoas.get(cod2).setJogaFifa(false);
                    lista_pessoas.get(cod2).setJogaOverwatch(false);
                    lista_pessoas.get(cod2).setJogaPubg(false);
                    lista_pessoas.get(cod2).setJogaFortinite(false);
                }
            }
        });

        cmb_local_trabalho.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (cmb_local_trabalho.getValue().equals("Delta cable")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(true);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);

                } else if (cmb_local_trabalho.getValue().equals("Mundo cell")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(true);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Renault")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(true);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Banco do Brasil")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(true);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Refrio")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(true);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Prefeitura da lapa")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(true);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Prefeitura de Araucária")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(true);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Camera municipal de Araucária")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(true);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Gelopar")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(true);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Abra")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(true);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Brafer")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(true);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Aviário")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(true);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Mecânica")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(true);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                } else if (cmb_local_trabalho.getValue().equals("Alta Rail Technology")) {
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(true);
                }else if(cmb_local_trabalho.getValue().equals("Empresa não listada/Não trabalho")){
                    lista_pessoas.get(cod2).setTrabalhaDeltaCable(false);
                    lista_pessoas.get(cod2).setTrabalhaMundoCell(false);
                    lista_pessoas.get(cod2).setTrabalhaRenault(false);
                    lista_pessoas.get(cod2).setTrabalhaBancoBrasil(false);
                    lista_pessoas.get(cod2).setTrabalhaRefrio(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraLapa(false);
                    lista_pessoas.get(cod2).setTrabalhaPrefeituraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaCameraAraucaria(false);
                    lista_pessoas.get(cod2).setTrabalhaGelopar(false);
                    lista_pessoas.get(cod2).setTrabalhaAbra(false);
                    lista_pessoas.get(cod2).setTrabalhaBrafer(false);
                    lista_pessoas.get(cod2).setTrabalhaAviario(false);
                    lista_pessoas.get(cod2).setTrabalhaMecanica(false);
                    lista_pessoas.get(cod2).setTrabalhaART(false);
                }

            }
        });

        cmb_disciplinas.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (cmb_disciplinas.getValue().equals("Programação orientada a objetos e Projeto Integrador")) {
                    lista_pessoas.get(cod2).setLecionaPOO(true);
                    lista_pessoas.get(cod2).setLecionaAC(false);
                    lista_pessoas.get(cod2).setLecionaBD(false);
                    lista_pessoas.get(cod2).setLecionaMAC(false);

                } else if (cmb_disciplinas.getValue().equals("Matemática aplicada a computação")) {
                    lista_pessoas.get(cod2).setLecionaPOO(false);
                    lista_pessoas.get(cod2).setLecionaAC(false);
                    lista_pessoas.get(cod2).setLecionaBD(false);
                    lista_pessoas.get(cod2).setLecionaMAC(true);
                } else if (cmb_disciplinas.getValue().equals("Banco de dados")) {
                    lista_pessoas.get(cod2).setLecionaPOO(false);
                    lista_pessoas.get(cod2).setLecionaAC(false);
                    lista_pessoas.get(cod2).setLecionaBD(true);
                    lista_pessoas.get(cod2).setLecionaMAC(false);
                } else if (cmb_disciplinas.getValue().equals("Arquitetura de computadores")) {
                    lista_pessoas.get(cod2).setLecionaPOO(false);
                    lista_pessoas.get(cod2).setLecionaAC(true);
                    lista_pessoas.get(cod2).setLecionaBD(false);
                    lista_pessoas.get(cod2).setLecionaMAC(false);
                } else if (cmb_disciplinas.getValue().equals("Não listado")) {
                    lista_pessoas.get(cod2).setLecionaPOO(false);
                    lista_pessoas.get(cod2).setLecionaAC(false);
                    lista_pessoas.get(cod2).setLecionaBD(false);
                    lista_pessoas.get(cod2).setLecionaMAC(false);
                }

            }
        });

        cmb_altura.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (cmb_altura.getValue().equals("Entre 1.50 e 1.69")) {
                    lista_pessoas.get(cod2).setAlturaAte69(true);
                    lista_pessoas.get(cod2).setAlturaAte79(false);
                    lista_pessoas.get(cod2).setAlturaAte90(false);

                } else if (cmb_altura.getValue().equals("Entre 1.70 e 1.79")) {
                    lista_pessoas.get(cod2).setAlturaAte69(false);
                    lista_pessoas.get(cod2).setAlturaAte79(true);
                    lista_pessoas.get(cod2).setAlturaAte90(false);
                } else if (cmb_altura.getValue().equals("Entre 1.80 e 1.90")) {
                    lista_pessoas.get(cod2).setAlturaAte69(false);
                    lista_pessoas.get(cod2).setAlturaAte79(false);
                    lista_pessoas.get(cod2).setAlturaAte90(true);
                }
            }
        });

        cmb_curso.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                if (cmb_curso.getValue().equals("Análise e Desenvolvimento de Sistemas")) {
                    lista_pessoas.get(cod2).setCursoADS(true);
                    lista_pessoas.get(cod2).setCursoSI(false);
                    cmb_periodo.setDisable(false);
                } else if (cmb_curso.getValue().equals("Sistemas de Informação")) {
                    lista_pessoas.get(cod2).setCursoADS(false);
                    lista_pessoas.get(cod2).setCursoSI(true);
                    cmb_periodo.setDisable(false);
                } else if (cmb_curso.getValue().equals("Nao Sou Aluno")) {
                    lista_pessoas.get(cod2).setP_periodo(false);
                    lista_pessoas.get(cod2).setS_periodo(false);
                    lista_pessoas.get(cod2).setT_periodo(false);
                    lista_pessoas.get(cod2).setCursoADS(false);
                    lista_pessoas.get(cod2).setCursoSI(false);
                    cmb_periodo.setDisable(true);

                }
            }
        });

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
                if (cmb_tom_pele.getValue().equals("Branca")) {
                    lista_pessoas.get(cod2).setTomPeleClaro(true);
                    lista_pessoas.get(cod2).setTomPelePardo(false);
                    lista_pessoas.get(cod2).setTomPeleEscura(false);

                } else if (cmb_tom_pele.getValue().equals("Pardo")) {
                    lista_pessoas.get(cod2).setTomPeleClaro(false);
                    lista_pessoas.get(cod2).setTomPelePardo(true);
                    lista_pessoas.get(cod2).setTomPeleEscura(false);

                } else if (cmb_tom_pele.getValue().equals("Negro")) {
                    lista_pessoas.get(cod2).setTomPeleClaro(false);
                    lista_pessoas.get(cod2).setTomPelePardo(false);
                    lista_pessoas.get(cod2).setTomPeleEscura(true);

                }
            }
        });
    }

    public void buscar_imagem(){
       FileChooser fc = new FileChooser();
       fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("jpg", "*.jpg","pnj","*.png"));
       File seletedFile = fc.showOpenDialog(null);
       if(seletedFile != null){
           Image img = new Image(seletedFile.toURI().toString());
           System.out.println(seletedFile.toURI().toString());
           img_view.setImage(img);
           lista_pessoas.get(cod2).setCaminho_imagem(seletedFile.toURI().toString());
       }
    }
    

    
    public boolean validar_campos() {
       
        Boolean nome = StringUtils.isBlank(txt_nome_alterar.getText());

        Boolean flag = true;

        if (nome == true) {
            AnimacaoCampos.vibrar(txt_nome_alterar);
            flag = false;
            erros.add("Nome");
        }

        if (nome == false) {
            lista_pessoas.get(cod2).setNome(txt_nome_alterar.getText());
        }

        if (checkb_sim_professor.isSelected() == false && checkb_nao_professor.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_nao_professor);
            AnimacaoCampos.vibrar(checkb_sim_professor);
            flag = false;
             erros.add("Professor");
        }
        if (checkb_sim_roupasocial.isSelected() == false && checkb_nao_roupasocial.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_roupasocial);
            AnimacaoCampos.vibrar(checkb_nao_roupasocial);
            flag = false;
            erros.add("Usa roupa social");
        }

        if (checkb_sim_barba.isSelected() == false && checkb_nao_barba.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_barba);
            AnimacaoCampos.vibrar(checkb_nao_barba);
            flag = false;
             erros.add("Tem barba");
        }
        if (checkb_sim_oculos.isSelected() == false && checkb_nao_oculos.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_oculos);
            AnimacaoCampos.vibrar(checkb_nao_oculos);
            flag = false;
            erros.add("Usa óculos");
        }

        if (checkb_masc_sexo.isSelected() == false && checkb_femn_sexo.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_femn_sexo);
            AnimacaoCampos.vibrar(checkb_masc_sexo);
            flag = false;
            erros.add("Sexo");
        }

        if (checkb_sim_piercing.isSelected() == false && checkb_nao_piercing.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_piercing);
            AnimacaoCampos.vibrar(checkb_nao_piercing);
            flag = false;
            erros.add("Tem Piercing");
        }
        if (checkb_sim_chapeu.isSelected() == false && checkb_nao_chapeu.isSelected() == false) {
            AnimacaoCampos.vibrar(checkb_sim_chapeu);
            AnimacaoCampos.vibrar(checkb_nao_chapeu);
            flag = false;
            erros.add("Usa boné/chapeu");
        }
        if (checkbox_sim_tatuagem.isSelected() == false && checkbox_nao_tatuagem.isSelected() == false) {
            AnimacaoCampos.vibrar(checkbox_sim_tatuagem);
            AnimacaoCampos.vibrar(checkbox_nao_tatuagem);
            flag = false;
            erros.add("Tem tatuagem");
        }
        if (checkbox_sim_aparelho.isSelected() == false && checkbox_nao_aparelho.isSelected() == false) {
            AnimacaoCampos.vibrar(checkbox_nao_aparelho);
            AnimacaoCampos.vibrar(checkbox_sim_aparelho);
            flag = false;
            erros.add("Usa aparelho");
        }
        if(checkbox_nao_depedencia.isSelected() == false && checkbox_sim_depedencia.isSelected() == false){
            AnimacaoCampos.vibrar(checkbox_nao_depedencia);
            AnimacaoCampos.vibrar(checkbox_sim_depedencia);
            flag = false;
            erros.add("Faz dependência");
        }
        
        if (cmb_idade.getSelectionModel().getSelectedItem() == null) {
            
            AnimacaoCampos.vibrar(cmb_idade);
            flag = false;
            erros.add("Idade");
        }
        
        if(cmb_curso.getSelectionModel().getSelectedItem() == null){
            AnimacaoCampos.vibrar(cmb_curso);
            erros.add("Curso");
            flag = false;
        }else{
          if(!cmb_curso.getValue().equals("Nao Sou Aluno")){
            if (cmb_periodo.getSelectionModel().getSelectedItem() == null) {
                AnimacaoCampos.vibrar(cmb_periodo);
                erros.add("Periodo");
                flag = false;
          }  
          
          }
        }
        
         if (cmb_disciplinas.getSelectionModel().getSelectedItem() == null && checkb_sim_professor.isSelected()) {
            AnimacaoCampos.vibrar(cmb_disciplinas);
             erros.add("Disciplinas");
            flag = false;
        }
        if (cmb_local_trabalho.getSelectionModel().getSelectedItem() == null ) {
            AnimacaoCampos.vibrar(cmb_local_trabalho);
            erros.add("Local de trabalho");
            flag = false;
        }
        
        if(cmb_tom_pele.getSelectionModel().getSelectedItem() == null){
            AnimacaoCampos.vibrar(cmb_tom_pele);
            erros.add("Local de trabalho");
            flag = false;
        }
         if (cmb_estilo_cabelo.getSelectionModel().getSelectedItem() == null) {
            AnimacaoCampos.vibrar(cmb_estilo_cabelo);
             erros.add("Estilo de cabelo");
            flag = false;
        }else{
            if(!cmb_estilo_cabelo.getValue().equals("Raspado/Calvo"))
            if (cmb_cor_cabelo.getSelectionModel().getSelectedItem() == null) {
                AnimacaoCampos.vibrar(cmb_cor_cabelo); 
                erros.add("Cor de cabelo");
                 flag = false;
                
            }
        }
         if (cmb_cor_olhos.getSelectionModel().getSelectedItem() == null) {
             AnimacaoCampos.vibrar(cmb_cor_olhos);    
             erros.add("Cor dos olhos");
                 flag = false;
            }
         
         if (cmb_altura.getSelectionModel().getSelectedItem() == null) {
             AnimacaoCampos.vibrar(cmb_altura);    
             erros.add("Altura");
                 flag = false;
            }
         if(cmb_jogos.getSelectionModel().getSelectedItem() == null){
             AnimacaoCampos.vibrar(cmb_jogos);
             erros.add("Jogo favorito");
             flag = false;
         }
              

     

        if (flag) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    private ImageView img_view;
    
    @FXML
    private AnchorPane id_painel;

    @FXML
    private JFXTextField txt_nome_alterar;

    @FXML
    private JFXComboBox cmb_idade;

    @FXML
    private JFXCheckBox checkb_masc_sexo;

    @FXML
    private JFXCheckBox checkb_femn_sexo;

    @FXML
    private JFXComboBox cmb_curso;

    @FXML
    private JFXComboBox cmb_periodo;

    @FXML
    private JFXCheckBox checkbox_sim_depedencia;

    @FXML
    private JFXCheckBox checkbox_nao_depedencia;

    @FXML
    private JFXCheckBox checkb_sim_professor;

    @FXML
    private JFXCheckBox checkb_nao_professor;

    @FXML
    private JFXComboBox cmb_disciplinas;

    @FXML
    private JFXComboBox cmb_local_trabalho;

    @FXML
    private JFXComboBox cmb_tom_pele;

    @FXML
    private JFXCheckBox checkbox_sim_tatuagem;

    @FXML
    private JFXCheckBox checkbox_nao_tatuagem;

    @FXML
    private JFXCheckBox checkb_sim_piercing;

    @FXML
    private JFXCheckBox checkb_nao_piercing;

    @FXML
    private JFXComboBox cmb_estilo_cabelo;

    @FXML
    private JFXComboBox cmb_cor_cabelo;

    @FXML
    private JFXComboBox cmb_cor_olhos;

    @FXML
    private JFXComboBox cmb_altura;

    @FXML
    private JFXCheckBox checkb_sim_oculos;

    @FXML
    private JFXCheckBox checkb_sim_barba;

    @FXML
    private JFXCheckBox checkb_nao_barba;

    @FXML
    private JFXCheckBox checkbox_sim_aparelho;

    @FXML
    private JFXCheckBox checkbox_nao_aparelho;

    @FXML
    private JFXCheckBox checkb_sim_roupasocial;

    @FXML
    private JFXCheckBox checkb_nao_roupasocial;

    @FXML
    private JFXCheckBox checkb_nao_oculos;

    @FXML
    private JFXCheckBox checkb_sim_chapeu;

    @FXML
    private JFXCheckBox checkb_nao_chapeu;

    @FXML
    private JFXComboBox cmb_jogos;

    @FXML
    private JFXButton btn_salvar;

    @FXML
    private JFXButton btn_voltar;

    @FXML
    private JFXButton btn_carregar_imagem;

}
