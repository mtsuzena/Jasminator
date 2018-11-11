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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.text.Text;


public class Jogo_p1Controller implements Initializable {
    ArrayList<Integer> id_pergunta = new ArrayList<>();
    ArrayList<Integer> id_pergunta_NaoPermitidas = new ArrayList<>();
    ArrayList<String> lista_perguntas = new ArrayList<>();
    List<Pessoa> lista_pessoas = new ArrayList<>();
    ArrayList<String> lista_sons = ListaPerguntas.retornaLista_sons();
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
    
    // ## OBS: Todos os atributos para permissao serao inciados com 0
    // ####### FIM - Atributos para pertmissoes de perguntas
    
    public static String nome;
    
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
            if(k < 39){
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
            if(k < 39){
                boolean fim = set_pergunta();
                if(fim)
                    check();
            }
        });
       
        id_talvez.setOnAction((ActionEvent event)->{
           
            k++;
            
            if(k < 39){
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
        for(Integer j=0 ; j<39 ; j++)
            id_pergunta.add(j);
        
        Collections.shuffle(id_pergunta);
        Collections.shuffle(id_pergunta);
    }
    
    public void check(){
        
        if(k >38){
            final_jogo();
            
        }
        
        if(k < 39){
            
            lista_pessoas=EliminaPessoas.getPredicaoPessoa_NEW(lista_pessoas, resposta, numero);
            
            if(lista_pessoas.size()==0){
                lista_pessoas = ArquivoTxt.capturaTxt("dados_pessoas.txt");
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
                System.out.println("K DESGRACADO = "+k);
                
                numero = id_pergunta.get(k);
                
                permitido=permitir_pergunta(numero);
                if(permitido==false){
                    k++;
                }else{
                    id_label.setText(lista_perguntas.get(numero));
                    reproduzir_audio(0, lista_sons.get(5));  
                }
                
                if(k>38)
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
                    }
                    break;
                case 1:
                    if(resposta==1){
                        periodo.add(1,1);
                    }
                    break;
                case 2: 
                    if(resposta==1){
                        periodo.add(2,1);
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
                        tom_olho.add(1,1);
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
                    break;
                case 26:
                    break;
                case 27: 
                    break;
                case 28:
                    break;
                case 29:
                    break;
                case 30: 
                    break;
                case 31: 
                    if(resposta==1){
                        disc_lecionada.add(0,1);
                    }
                    break;
                case 32: 
                    if(resposta==1){
                        disc_lecionada.add(1,1);
                    }
                    break;
                case 33: 
                    if(resposta==1){
                        disc_lecionada.add(2,1);
                    }
                    break;
                case 34: 
                    if(resposta==1){
                        disc_lecionada.add(3,1);
                    }
                    break;
                case 35: 
                    break;
                case 36: 
                    break;
                case 37: 
                    break;
                case 38: 
                    
        }
    }
    private boolean permitir_pergunta(Integer id_pergunta){
        switch(id_pergunta){
                case 0:
                    if(((periodo.get(1)==0)||(periodo.get(1)==2))&&((periodo.get(2)==0)||(periodo.get(2)==2))){
                        System.out.println("Pergunta 0 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 0 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(0);
                    }
                    break;
                case 1:
                    if(((periodo.get(0)==0)||(periodo.get(0)==2))&&((periodo.get(2)==0)||(periodo.get(2)==2))){
                        System.out.println("Pergunta 1 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 1 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(1);
                    }
                    break;
                case 2: 
                    if((periodo.get(0)==0||periodo.get(0)==2)&&(periodo.get(1)==0||periodo.get(1)==2)){
                        System.out.println("Pergunta 2 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 2 nao permitida!!\n");
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
                    System.out.println("Pergunta 21 permitida!!\n");
                    return true;
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
                    System.out.println("Pergunta 24 permitida!!\n");
                    return true;
                case 25:
                    System.out.println("Pergunta 25 permitida!!\n");
                    return true;
                case 26:
                    System.out.println("Pergunta 26 permitida!!\n");
                    return true;
                case 27: 
                    System.out.println("Pergunta 27 permitida!!\n");
                    return true;
                case 28:
                    System.out.println("Pergunta 28 permitida!!\n");
                    return true;
                case 29:
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2);
                            
                            if(nome.equalsIgnoreCase("Dou")){
                                System.out.println("Pergunta 29 permitida!!\n");
                                return true;
                            }else{
                                System.out.println("Pergunta 35 nao permitida!!\n");
                                id_pergunta_NaoPermitidas.add(35); 
                            }
                        }
                    }else{
                        System.out.println("Pergunta 29 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(29);  
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
                                System.out.println("Pergunta 35 nao permitida!!\n");
                                id_pergunta_NaoPermitidas.add(35); 
                            }
                        }
                    }else{
                        System.out.println("Pergunta 30 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(30);  
                    }
                    break;
                case 31: 
                    if((disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 31 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 31 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(31);
                    }
                    break;
                case 32: 
                    if((disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 32 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 32 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(32);
                    }
                    break;
                case 33: 
                    if((disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(3)==0||disc_lecionada.get(3)==2)){
                        System.out.println("Pergunta 33 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 33 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(33);
                    }
                    break;
                case 34: 
                    if((disc_lecionada.get(0)==0||disc_lecionada.get(0)==2)&&
                            (disc_lecionada.get(1)==0||disc_lecionada.get(1)==2)&&
                            (disc_lecionada.get(2)==0||disc_lecionada.get(2)==2)){
                        System.out.println("Pergunta 34 permitida!!\n");
                        return true;
                    }else{
                        System.out.println("Pergunta 34 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(34);
                    }
                    break;
                case 35: 
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2)+p.getNome().charAt(3)+p.getNome().charAt(4);
                            if(nome.equalsIgnoreCase("Lucas")){
                                System.out.println("Pergunta 35 permitida!!\n");
                                return true;
                            }else{
                                System.out.println("Pergunta 35 nao permitida!!\n");
                                id_pergunta_NaoPermitidas.add(35); 
                            }
                        }
                    }else{
                        System.out.println("Pergunta 35 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(35);  
                    }
                    break;
                case 36: 
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2)+p.getNome().charAt(3)+p.getNome().charAt(4)+p.getNome().charAt(5);
                            if(nome.equalsIgnoreCase("Flavio")){
                                System.out.println("Pergunta 36 permitida!!\n");
                                return true;
                            }
                            else{
                                System.out.println("Pergunta 36 nao permitida!!\n");
                                id_pergunta_NaoPermitidas.add(36); 
                            }
                        }
                    }else{
                        System.out.println("Pergunta 36 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(36);  
                    }
                    break;
                case 37: 
                    if(lista_pessoas.size() < 4){
                        for(Pessoa p : lista_pessoas){
                            String nome= ""+p.getNome().charAt(0)+p.getNome().charAt(1)+p.getNome().charAt(2)+p.getNome().charAt(3)+p.getNome().charAt(4);
                            if(nome.equalsIgnoreCase("Kevin")){
                                System.out.println("Pergunta 37 permitida!!\n");
                                return true;
                            }
                            else{
                                System.out.println("Pergunta 37 nao permitida!!\n");
                                id_pergunta_NaoPermitidas.add(37); 
                            }
                        }
                    }else{
                        System.out.println("Pergunta 37 nao permitida!!\n");
                        id_pergunta_NaoPermitidas.add(37);  
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
                    
        }
        return false;
    }
}