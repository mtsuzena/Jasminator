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
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;


public class Jogo_p1Controller implements Initializable {
    ArrayList<Integer> id_pergunta = new ArrayList<>();
    ArrayList<Integer> id_pergunta_NaoPermitidas = new ArrayList<>();
    ArrayList<String> lista_perguntas = new ArrayList<>();
    List<Pessoa> lista_pessoas = new ArrayList<>();
//    ArrayList<String> lista_sons = ListaPerguntas.retornaLista_sons();
    Integer resposta ;
    Integer k;
    Integer numero;
    
    // ####### INICIO - Atributos para pertmissoes de perguntas
    // ## 0 - Pergunta nao foi feita
    // ## 1 - Pergunta foi respondida como "SIM"      // PARA INTEIROS OU CADA INDICE DOS VARRAYS De INTEIROS
    // ## 2 - Pergunta foi respondida como "NAO"
            private int calvo;
            // ## 0 - Pergunta nao foi feita
    // ## 0 - Ondulado
    // ## 1 - Crespo
    // ## 2 - Liso 
            private ArrayList<Integer> estilo_cabelo = new ArrayList<Integer>();
    // ## 0 - Curto
    // ## 1 - Medio
    // ## 2 - Longo
            private ArrayList<Integer> tamanho_cabelo = new ArrayList<Integer>();
    // ## 0 - Loiro
    // ## 1 - Preto
    // ## 2 - Castanho
    // ## 3 - Avermelhado
            private ArrayList<Integer> cor_cabelo = new ArrayList<Integer>(); 
    // ## 
    // ## 0 - P_periodo
    // ## 1 - S_periodo
    // ## 2 - T_periodo  
            private int periodo_feito;
            private ArrayList<Integer> periodo = new ArrayList<Integer>();
            
    // ## 0 - nao foi feita
    // ## 1 - foi feita
            private int tom_pele;
            
    // ## 0 - Verde
    // ## 1 - Azul
    // ## 2 - Castanho
            private ArrayList<Integer> tom_olho = new ArrayList<Integer>();
    
    // ## 0 - POO
    // ## 1 - AC
    // ## 2 - MAC
    // ## 3 - BD
            private ArrayList<Integer> disc_lecionada = new ArrayList<Integer>();
            
    //
            private boolean isMasculino;
            private int isProfessor; // 0 - neutro 0--> pode fazer pergunta de aluno e prof
                                     // 1 - nao pode fazer pergunta de aluno
                                     // 2 - nao pode fazer perguntar de prof
            private boolean isLeciona;
            
            private boolean permitir_jogo;
            private boolean permitir_trabalha;
            private boolean permitir_altura;
            private boolean permitir_curso;
    
    // ## OBS: Todos os atributos para permissao serao inciados com 0
    // ####### FIM - Atributos para pertmissoes de perguntas
    
    public static String nome;
    public static String img_caminho;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limpar();
        ini_atributos_verificadores();
        lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
        lista_perguntas = ListaPerguntas.retornaLista_New();
        embaralhar_pergunta();
        k=0;
        
        set_pergunta();
        
        // BOTOES TELA
        id_sim.setOnAction((ActionEvent event)->{

            resposta = 1;
            
            
            set_atributos_verificadores(id_pergunta.get(k), resposta);
             k++;
             check();
            if(k < 63){
                boolean fim = set_pergunta();
                if(fim)
                    check();
            }
        });
        
        id_nao.setOnAction((ActionEvent event)->{
          
            resposta = 0 ;    
            
            
            set_atributos_verificadores(id_pergunta.get(k), resposta);
            k++;
            check();
            if(k < 63){
                boolean fim = set_pergunta();
                if(fim)
                    check();
            }
        });
       
        id_talvez.setOnAction((ActionEvent event)->{
           
            k++;
            
            if(k < 63){
            set_pergunta();
            }else{
                check();
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
        // FIM BOTOES TELA
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
        for(Integer j=0 ; j<63 ; j++)
            id_pergunta.add(j);
        
        Collections.shuffle(id_pergunta);
        Collections.shuffle(id_pergunta);
    }
    
    public void check(){
        
        if(k >62){
            final_jogo();
        }
        
        if(k < 63){
            
            lista_pessoas=EliminaPessoas.getPredicaoPessoa_NEW(lista_pessoas, resposta, numero);
            
            if(lista_pessoas.size()==0){
                lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
            }
 
            if(lista_pessoas.size()==1){
                Parent root;
                try {
                    nome = lista_pessoas.get(0).getNome();
                    img_caminho = lista_pessoas.get(0).getCaminho_imagem();
                    root = FXMLLoader.load(getClass().getResource("/Fxml/Final_Jogo.fxml"));
           
                    cena_jogador(root,id_pane);
                    id_pane.getChildren().clear();
                } catch (IOException ex) {
                    Logger.getLogger(Jogo_p1Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
        
             
    }
    
    public void final_jogo(){
        Parent root;
            try {
              
                root = FXMLLoader.load(getClass().getResource("/Fxml/Final_Jogo_Unk.fxml"));
                cena_jogador(root,id_pane);
                id_pane.getChildren().clear();
            } catch (IOException ex) {
                Logger.getLogger(Jogo_p1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void limpar(){
 
            id_pergunta.clear();
            numero = 0;
 
    }
    
    public void ini_atributos_verificadores(){
        calvo=0;
        
        permitir_curso=true;
        permitir_altura=true;
        permitir_trabalha=true;
        permitir_jogo=true;
        
        isLeciona=false;
        isProfessor=0;
        isMasculino=true;
        
        periodo_feito=0;
        periodo.add(0,0);
        periodo.add(1,0);
        periodo.add(2,0);
        
        estilo_cabelo.add(0,0);
        estilo_cabelo.add(1,0);
        estilo_cabelo.add(2,0);
        estilo_cabelo.add(3,0);
        
        cor_cabelo.add(0,0);
        cor_cabelo.add(1,0);
        cor_cabelo.add(2,0);
        cor_cabelo.add(2,0);
        
        tamanho_cabelo.add(0,0);
        tamanho_cabelo.add(1,0);
        tamanho_cabelo.add(2,0);
        
        tom_pele=0;
        
        tom_olho.add(0,0);
        tom_olho.add(1,0);
        tom_olho.add(2,0);
        
        disc_lecionada.add(0,0);
        disc_lecionada.add(1,0);
        disc_lecionada.add(2,0);
        disc_lecionada.add(3,0);
    }
    
    public boolean set_pergunta(){
        int index=0;
        for(Pessoa pessoa : lista_pessoas){
            System.out.println(index+" - Nome: "+pessoa.getNome());
            index++;
        }
        boolean permitido=false;
        while(permitido==false){
            //if(k<39){    
                //check();
                System.out.println("K = "+k);
                
                numero = id_pergunta.get(k);
                
                permitido=permitir_pergunta(numero);
                if(permitido==false){
                    k++;
                }else{
                    id_label.setText(lista_perguntas.get(numero));
                    
                }
                
                if(k>61)
                    return true;
            //}else{
              // permitido=true;
           // }
           
        }
        return false; 
    }
    
    
    public void reproduzir_audio(Integer time,String musicFile){
        musicFile = getClass().getResource("/sons/"+musicFile).toString();
        AudioClip clip = new AudioClip(musicFile);
        try { Thread.sleep (time); } catch (InterruptedException ex) {}
        clip.play();
    }
    
    
    public void set_atributos_verificadores(Integer id_pergunta, Integer resposta){
        switch(id_pergunta){
                case 0:
                    if(resposta==1){
                        periodo.add(0,1);
                        isProfessor=2;
                    }
                    break;
                case 1:
                    if(resposta==1){
                        periodo.add(1,1);
                        isProfessor=2;
                    }
                    break;
                case 2: 
                    if(resposta==1){
                        periodo.add(2,1);
                        isProfessor=2;
                    }
                    break;
                case 3:                
                    if(resposta==0){
                        isMasculino=false;
                    }
                    break;
                case 4:
                    if(resposta==1){
                        calvo=1;
                    }else{
                        calvo=2;
                    }
                    break;
                case 5:
                    if(resposta==1){
                        estilo_cabelo.add(0,1);
                        calvo=2;
                    }
                    break;
                case 6:
                    if(resposta==1){
                        calvo=2;
                        estilo_cabelo.add(1,1);
                    }
                    break;
                case 7: 
                    if(resposta==1){
                        calvo=2;
                        estilo_cabelo.add(2,1);
                    }
                    break;
                case 8: 
                    if(resposta==1){
                        calvo=2;
                        tamanho_cabelo.add(0,1);
                    }
                    break;
                case 9: 
                    if(resposta==1){
                        calvo=2;
                        tamanho_cabelo.add(1,1);
                    }
                    break;
                case 10: 
                    if(resposta==1){
                        calvo=2;
                        tamanho_cabelo.add(2,1);
                    }
                    break;
                case 11: 
                    if(resposta==1){
                        calvo=2;
                        cor_cabelo.add(0,1);
                    }
                   break;
                case 12: 
                    if(resposta==1){
                        calvo=2;
                        cor_cabelo.add(1,1);
                    }
                    break;
                case 13: 
                    if(resposta==1){
                        calvo=2;
                        cor_cabelo.add(2,1);
                    }
                    break;
                case 14: 
                    if(resposta==1){
                        calvo=2;
                        cor_cabelo.add(3,1);
                    }
                    break;
                case 15: 
                    if(resposta==1){
                        tom_pele=1;
                    }
                    break;
                case 16: 
                    if(resposta==1){
                        tom_pele=1;
                    }
                    break;
                case 17: 
                    if(resposta==1){
                        tom_olho.add(0,1);
                    }
                    break;
                case 18: 
                    if(resposta==1){
                        tom_olho.add(1,1);
                    }
                    break;
                case 19: 
                    if(resposta==1){
                        tom_olho.add(2,1);
                    }
                    break;
                case 20:
                    break;
                case 21:
                    break;
                case 22:
                    break;
                case 23: 
                    break;
                case 24:
                    break;
                case 25:
                    if(resposta==1){
                        isProfessor=1;
                    }
                    break;
                case 26:
                    break;
                case 27:
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 28:
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 29:
                    break;
                case 30: 
                    break;
                case 31: 
                    if(resposta==1){
                        disc_lecionada.add(0,1);
                        isProfessor=1;
                        isLeciona=true;
                    }
                    break;
                case 32: 
                    if(resposta==1){
                        isProfessor=1;
                        disc_lecionada.add(1,1);
                        isLeciona=true;
                    }
                    break;
                case 33: 
                    if(resposta==1){
                        isProfessor=1;
                        disc_lecionada.add(2,1);
                        isLeciona=true;
                    }
                    break;
                case 34: 
                    if(resposta==1){
                        isProfessor=1;
                        disc_lecionada.add(3,1);
                        isLeciona=true;
                    }
                    break;
                case 35: 
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 36: 
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 37: 
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 38: 
                    break;
                case 39: 
                    if(resposta==1){
                        tom_pele=1;
                    }
                    break;
                case 40: 
                    break;
                case 41: 
                    break;
                case 42:
                    if(resposta==1){
                        permitir_altura=false;
                    }
                    break;
                case 43: 
                    if(resposta==1){
                        permitir_altura=false;
                    }
                    break;
                case 44: 
                    if(resposta==1){
                        permitir_altura=false;
                    }
                    break;
                case 45:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 46:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 47:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 48:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 49: 
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 50:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 51:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 52:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 53:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 54:
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                case 55: 
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 56: 
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 57: 
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 58: 
                    if(resposta==1){
                        permitir_jogo=false;
                    }    
                    break;
                case 59: 
                    if(resposta==1){
                        permitir_curso=false;
                    }    
                    break;
                case 60: 
                    if(resposta==1){
                        permitir_curso=false;
                    }    
                    break;
                case 61: 
                    break;
                case 62: 
                    if(resposta==1){
                        permitir_trabalha=false;
                    }
                    break;
                    
        }
    }
    private boolean permitir_pergunta(Integer id_pergunta){
        switch(id_pergunta){
                case 0:
                    if(isProfessor!=1&&((periodo.get(1)==0)||(periodo.get(1)==2))&&((periodo.get(2)==0)||(periodo.get(2)==2))){
                        System.out.println("Pergunta 0 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 0 nao permitida!!"+"isProfessor: "+isProfessor+"\n");
                        System.out.println("isProfessor: "+isProfessor);
                        id_pergunta_NaoPermitidas.add(0);
                    }
                    break;
                case 1:
                    if(isProfessor!=1&&((periodo.get(0)==0)||(periodo.get(0)==2))&&((periodo.get(2)==0)||(periodo.get(2)==2))){
                        System.out.println("Pergunta 1 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 1 nao permitida!!"+"isProfessor: "+isProfessor+"\n");
                       
                        id_pergunta_NaoPermitidas.add(1);
                    }
                    break;
                case 2: 
                    if(isProfessor!=1&&(periodo.get(0)==0||periodo.get(0)==2)&&(periodo.get(1)==0||periodo.get(1)==2)){
                        System.out.println("Pergunta 2 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 2 nao permitida!!"+"isProfessor: "+isProfessor+"\n");
                       
                        id_pergunta_NaoPermitidas.add(2);
                    }
                    break;
                case 3:                
                    System.out.println("Pergunta 3 permitida!!\n");
                    return true;
                case 4:
                    if(calvo!=2){
                        System.out.println("Pergunta 4 permitida!!\n");
                        return true;
                    }
                    break;
                case 5:
                    if((calvo!=1)&&(estilo_cabelo.get(1)==0||estilo_cabelo.get(1)==2)&&
                            (estilo_cabelo.get(2)==0||estilo_cabelo.get(2)==2)){
                        System.out.println("Pergunta 5 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 5 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(5);
                    }
                    break;
                case 6:  
                    if((calvo!=1)&&(estilo_cabelo.get(0)==0||estilo_cabelo.get(0)==2)&&
                            (estilo_cabelo.get(2)==0||estilo_cabelo.get(2)==2)){
                        System.out.println("Pergunta 6 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 6 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(6);
                    }
                    break;
                case 7: 
                    if((calvo!=1)&&(estilo_cabelo.get(1)==0||estilo_cabelo.get(1)==2)&&
                            (estilo_cabelo.get(0)==0||estilo_cabelo.get(0)==2)){
                        System.out.println("Pergunta 7 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 7 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(7);
                    }
                    break;
                case 8: 
                    if((calvo!=1)&&(tamanho_cabelo.get(1)==0||tamanho_cabelo.get(1)==2)&&
                            (tamanho_cabelo.get(2)==0||tamanho_cabelo.get(2)==2)){
                        System.out.println("Pergunta 8 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 8 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(8);
                    }
                    break;
                case 9: 
                    if((calvo!=1)&&(tamanho_cabelo.get(0)==0||tamanho_cabelo.get(0)==2)&&
                            (tamanho_cabelo.get(2)==0||tamanho_cabelo.get(2)==2)){
                        System.out.println("Pergunta 9 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 9 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(9);
                    }
                    break;
                case 10: 
                    if((calvo!=1)&&(tamanho_cabelo.get(0)==0||tamanho_cabelo.get(0)==2)&&
                            (tamanho_cabelo.get(1)==0||tamanho_cabelo.get(1)==2)){
                        System.out.println("Pergunta 10 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 10 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(10);
                    }
                    break;
                case 11: 
                    if((calvo!=1)&&(cor_cabelo.get(1)==0||cor_cabelo.get(1)==2)&&
                            (cor_cabelo.get(2)==0||cor_cabelo.get(2)==2)
                            &&(cor_cabelo.get(3)==0||cor_cabelo.get(3)==2)){
                        System.out.println("Pergunta 11 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 11 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(11);
                    }
                    break;
                case 12: 
                    if((calvo!=1)&&(cor_cabelo.get(0)==0||cor_cabelo.get(0)==2)&&
                            (cor_cabelo.get(2)==0||cor_cabelo.get(2)==2)
                            &&(cor_cabelo.get(3)==0||cor_cabelo.get(3)==2)){
                        System.out.println("Pergunta 12 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 12 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(12);
                    }
                    break;
                case 13: 
                    if((calvo!=1)&&(cor_cabelo.get(0)==0||cor_cabelo.get(0)==2)&&
                            (cor_cabelo.get(1)==0||cor_cabelo.get(1)==2)
                            &&(cor_cabelo.get(3)==0||cor_cabelo.get(3)==2)){
                        System.out.println("Pergunta 13 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 13 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(13);
                    }
                    break;
                case 14: 
                    if((calvo!=1)&&(cor_cabelo.get(0)==0||cor_cabelo.get(0)==2)&&
                            (cor_cabelo.get(1)==0||cor_cabelo.get(1)==2)
                            &&(cor_cabelo.get(2)==0||cor_cabelo.get(2)==2)){
                        System.out.println("Pergunta 14 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 14 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(14);
                    }
                    break;
                case 15: 
                    if(tom_pele==0){
                        System.out.println("Pergunta 15 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 15 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(15);
                    }
                    break;
                case 16: 
                    if(tom_pele==0){
                        System.out.println("Pergunta 16 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 16 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(16);
                    }
                    break;
                case 17: 
                    if((tom_olho.get(1)==0||tom_olho.get(1)==2)&&
                            (tom_olho.get(2)==0||tom_olho.get(2)==2)){
                        System.out.println("Pergunta 17 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 17 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(17);
                    }
                    break;
                case 18: 
                    if((tom_olho.get(0)==0||tom_olho.get(0)==2)&&
                            (tom_olho.get(2)==0||tom_olho.get(2)==2)){
                        System.out.println("Pergunta 18 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 18 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(18);
                    }
                    break;
                case 19: 
                    if((tom_olho.get(0)==0||tom_olho.get(0)==2)&&
                            (tom_olho.get(1)==0||tom_olho.get(1)==2)){
                        System.out.println("Pergunta 19 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 19 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(19);
                    }
                    break;
                case 20:
                    System.out.println("Pergunta 20 permitida!!\n");
                    return true;
                case 21:
                    break;
                case 22:
                    if(isMasculino){    
                        System.out.println("Pergunta 22 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 22 NAO permitida!!\n");
                    }
                    break;
                case 23: 
                    System.out.println("Pergunta 23 permitida!!\n");
                    return true;
                case 24:
                    if(isProfessor!=2){    
                        System.out.println("Pergunta 24 permitida!!\n");
                        System.out.println("isProfessor: "+isProfessor);
                        return true;
                    }
                    break;
                case 25:
                    if(isProfessor!=2&&isLeciona==false){
                        System.out.println("Pergunta 25 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 25 NAO permitida!!  isProfessor: "+isProfessor+"\n");
                    }
                    break;
                case 26:
                    System.out.println("Pergunta 26 permitida!!\n");
                    return true;
                case 27: 
                    if(permitir_jogo){
                        System.out.println("Pergunta 27 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 27 nao permitida!!\n");
                    }
                    break;
                case 28:
                    if(permitir_jogo){
                        System.out.println("Pergunta 28 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 28 nao permitida!!\n");
                    }
                    break;
                case 29:
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2);
                            
                            if(nome.equalsIgnoreCase("Dou")){
                                System.out.println("Pergunta 29 permitida!!\n");
                                return true;
                            }else{
                                System.out.println("Pergunta 29 nao permitida!!\n");
                            }
                        }
                    }
                    break;
                case 30: 
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2);
                            if(nome.equalsIgnoreCase("Dou")){
                                System.out.println("Pergunta 30 permitida!!\n");
                                return true;
                            }else{
                                System.out.println("Pergunta 30 nao permitida!!\n");
                            }
                        }
                    }
                    break;
                case 31: 
                    if(isProfessor!=2&&(disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 31 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 31 nao permitida!!\n");
                    }
                    break;
                case 32: 
                    if(isProfessor!=2&&(disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 32 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 32 nao permitida!!\n");
                    }
                    break;
                case 33: 
                    if(isProfessor!=2&&(disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 33 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 33 nao permitida!!\n");
                    }
                    break;
                case 34: 
                    if(isProfessor!=2&&(disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)){
                        System.out.println("Pergunta 34 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 34 nao permitida!!\n");
                    }
                    break;
                case 35: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 35 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 35 nao permitida!!\n");
                    }
                    break;
                case 36: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 36 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 36 nao permitida!!\n");
                    }
                    break;
                case 37: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 37 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 37 nao permitida!!\n");
                    }
                    break;
                case 38: 
//                    if(lista_pessoas.size() < 4){
//                        for(Pessoa p : lista_pessoas){
//                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2)+p.getNome().charAt(3)+p.getNome().charAt(4)+p.getNome().charAt(5);
//                            if(nome.equalsIgnoreCase("Carlos")){
                                System.out.println("Pergunta 38 permitida!!\n");
                                return true;
//                            }
//                            else{
//                                System.out.println("Pergunta 38 nao permitida!!\n");
//                                id_pergunta_NaoPermitidas.add(38); 
//                            }
//                        }
//                    }else{
//                        System.out.println("Pergunta 38 nao permitida!!\n");
//                        id_pergunta_NaoPermitidas.add(38);  
//                    }
//                    break;
                case 39: 
                    if(tom_pele==0){
                        System.out.println("Pergunta 39 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 39 nao permitida!!\n");
                    }
                    break;
                case 40: 
                    return true;
                case 41: 
                    return true;
                case 42: 
                    if(permitir_altura){
                        System.out.println("Pergunta 42 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 42 nao permitida!!\n");
                    }
                    break;
                case 43: 
                    if(permitir_altura){
                        System.out.println("Pergunta 43 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 43 nao permitida!!\n");
                    }
                    break;
                case 44: 
                    if(permitir_altura){
                        System.out.println("Pergunta 44 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 44 nao permitida!!\n");
                    }
                    break;
                case 45: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 45 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 45 nao permitida!!\n");
                    }
                    break;
                case 46: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 46 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 46 nao permitida!!\n");
                    }
                    break;
                case 47: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 47 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 47 nao permitida!!\n");
                    }
                    break;
                case 48: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 48 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 48 nao permitida!!\n");
                    }
                    break;
                case 49: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 49 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 49 nao permitida!!\n");
                    }
                    break;
                case 50: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 50 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 50 nao permitida!!\n");
                    }
                    break;
                case 51: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 51 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 51 nao permitida!!\n");
                    }
                    break;
                case 52: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 52 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 52 nao permitida!!\n");
                    }
                    break;
                case 53: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 53 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 53 nao permitida!!\n");
                    }
                    break;
                case 54: 
                    if(permitir_trabalha){
                        System.out.println("Pergunta 54 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 54 nao permitida!!\n");
                    }
                    break;
                case 55: 
                    if(permitir_jogo){
                        System.out.println("Pergunta 55 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 55 nao permitida!!\n");
                    }
                    break;
                case 56: 
                    if(permitir_jogo){
                        System.out.println("Pergunta 56 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 56 nao permitida!!\n");
                    }
                    break;
                case 57: 
                    if(permitir_jogo){
                        System.out.println("Pergunta 57 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 57 nao permitida!!\n");
                    }
                    break;
                case 58: 
                    if(permitir_jogo){
                        System.out.println("Pergunta 58 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 58 nao permitida!!\n");
                    }
                    break;
                case 59: 
                    if(permitir_curso){
                        System.out.println("Pergunta 59 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 59 nao permitida!!\n");
                    }
                    break;
                case 60: 
                    if(permitir_curso){
                        System.out.println("Pergunta 60 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 60 nao permitida!!\n");
                    }
                    break;
                case 61: 
                    return true;
                case 62:
                    if(permitir_trabalha){
                        System.out.println("Pergunta 62 permitida!!\n");          
                        return true;
                    }else{
                        System.out.println("Pergunta 62 nao permitida!!\n");
                    }
                    break;
                    
        }
        return false;
    }
}