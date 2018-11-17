package Classes;

import java.util.ArrayList;
import java.util.List;

public class ListaPerguntas {
    
    
    public static ArrayList retornaLista(){
        List<String> lista_perguntaPadrao = new ArrayList<String>();
        
        lista_perguntaPadrao.add(0,"A pessoa que você esta pensando e calva? ");
        lista_perguntaPadrao.add(1,"A pessoa que você esta pensando tem cabelos longos?");
        lista_perguntaPadrao.add(2,"A pessoa que você esta pensando é alta?");
        lista_perguntaPadrao.add(3,"A pessoa que você esta pensando tem barba?");
        lista_perguntaPadrao.add(4,"A pessoa que você esta pensando e professor");
        lista_perguntaPadrao.add(5,"A pessoa que voce esta pensando e do sexo masculino?");
        lista_perguntaPadrao.add(6,"A pessoa que você esta pensando tem o cabelo claro?");
        lista_perguntaPadrao.add(7,"A pessoa que você esta pensango tem olhos escuros?");
        lista_perguntaPadrao.add(8,"A pessoa que você esta pensando tem 20 anos ou mais?");
        
        return (ArrayList) lista_perguntaPadrao;
    }
    
    public static ArrayList retornaLista_sons(){
        List<String> lista_sons = new ArrayList<String>();
        
        lista_sons.add(0,"p_periodo.m4a");
        lista_sons.add(1,"s_periodo.m4a");
        lista_sons.add(2,"3_periodo.m4a");
        lista_sons.add(3,"masculino.m4a");
        
        // Perguntas sobre cabelo
        lista_sons.add(4,"careca.m4a");
        lista_sons.add(5,"cabelo_ondulado.m4a");
        lista_sons.add(6,"cabelo_crespo.m4a");
        lista_sons.add(7,"cabelo_liso.m4a");
        lista_sons.add(8,"cabelo_curto.m4a");
        lista_sons.add(9,"cabelo_medio.m4a");
        lista_sons.add(10,"cabelo_longo.m4a");
        lista_sons.add(11,"cabelo_loiro.m4a");
        lista_sons.add(12,"cabelo_preto.m4a");
        lista_sons.add(13,"cabelo_castanho.m4a");
        lista_sons.add(14,"cabelo_avermelhado.m4a");
        
        //Tom da pele
        lista_sons.add(15,"pele_clara.m4a");
        lista_sons.add(16,"pele_escura.m4a");
        
        //Tom olhos
        lista_sons.add(17,"olho_verde.m4a");
        lista_sons.add(18,"olho_verde.m4a");
        lista_sons.add(19,"olho_castanho.m4a");
        lista_sons.add(20,"usa_oculos.m4a");
        
        //Caracteristicas gerais
        lista_sons.add(21,"alto.m4a");
        lista_sons.add(22,"barba.m4a");
        lista_sons.add(23,"chapeu.m4a");
        lista_sons.add(24,"roupa_social.m4a");
        lista_sons.add(25,"professor.m4a");
        lista_sons.add(26,"20anos.m4a");
        
        // Jogos
        lista_sons.add(27,"jogaLOL.m4a");
        lista_sons.add(28,"jogaCSGO.m4a");
        
        //Específicas
        lista_sons.add(29,"quimica.m4a");
        lista_sons.add(30,"exercito.m4a");
        lista_sons.add(31,"leciona_POO.m4a");
        lista_sons.add(32,"leciona_AC.m4a");
        lista_sons.add(33,"leciona_MAC.m4a");
        lista_sons.add(34,"leciona_BD.m4a");
        lista_sons.add(35,"trabalha_aviario.m4a");
        lista_sons.add(36,"trabalha_mecanica.m4a");
        lista_sons.add(37,"trabalha_brafer.m4a");
        lista_sons.add(38,"tem_piercing.m4a");
                
                
        return (ArrayList) lista_sons;
    }
    
    public static ArrayList retornaLista_New(){
        List<String> lista_perguntaPadrao = new ArrayList<String>();
        
        lista_perguntaPadrao.add(0,"A pessoa esta no primeiro periodo?");
        lista_perguntaPadrao.add(1,"A pessoa esta no segundo periodo?");
        lista_perguntaPadrao.add(2,"A pessoa esta no terceiro periodo?");
        lista_perguntaPadrao.add(3,"A pessoa é do sexo masculino?");
        
        // Perguntas sobre cabelo
        lista_perguntaPadrao.add(4,"A pessoa tem estilo de corte careca?");
        lista_perguntaPadrao.add(5,"A pessoa tem cabelo ondulado?");
        lista_perguntaPadrao.add(6,"A pessoa tem cabelo crespo?");
        lista_perguntaPadrao.add(7,"A pessoa tem cabelo liso?");
        lista_perguntaPadrao.add(8,"A pessoa tem cabelo curto?");
        lista_perguntaPadrao.add(9,"A pessoa tem cabelo medio?");
        lista_perguntaPadrao.add(10,"A pessoa tem cabelo longo?");
        lista_perguntaPadrao.add(11,"A pessoa tem cabelo da cor loiro?");
        lista_perguntaPadrao.add(12,"A pessoa tem cabelo da cor preto?");
        lista_perguntaPadrao.add(13,"A pessoa tem cabelo da cor castanho?");
        lista_perguntaPadrao.add(14,"A pessoa tem cabelo da cor avermelhado?");
        
        //Tom da pele
        lista_perguntaPadrao.add(15,"A pessoa é branca?");
        lista_perguntaPadrao.add(16,"A pessoa é negra?");
        
        //Tom olhos
        lista_perguntaPadrao.add(17,"A pessoa tem o tom dos olhos verde?");
        lista_perguntaPadrao.add(18,"A pessoa tem o tom dos olhos azul?");
        lista_perguntaPadrao.add(19,"A pessoa tem o tom dos olhos castanhos");
        lista_perguntaPadrao.add(20,"A pessoa usa óculos?");
        
        //Caracteristicas gerais
        lista_perguntaPadrao.add(21,"A pessoa é alta?");
        lista_perguntaPadrao.add(22,"A pessoa tem barba ?");
        lista_perguntaPadrao.add(23,"A pessoa usa chapeu/boné?");
        lista_perguntaPadrao.add(24,"A pessoa usa roupa social?");
        lista_perguntaPadrao.add(25,"A pessoa é professor?");
        lista_perguntaPadrao.add(26,"A pessoa tem 20 anos ou mais?");
        
        // Jogos
        lista_perguntaPadrao.add(27,"A pessoa joga League of Legends?");
        lista_perguntaPadrao.add(28,"A pessoa joga CS:GO?");
        
        //Específicas
        lista_perguntaPadrao.add(29,"A pessoa é graduado em química na UFPR?");
        lista_perguntaPadrao.add(30,"A pessoa é do exercíto?");
        lista_perguntaPadrao.add(31,"A pessoa leciona a disciplina Programacao Orietada a Objetos?");
        lista_perguntaPadrao.add(32,"A pessoa leciona a disciplina Arquitetura de Computadores?");
        lista_perguntaPadrao.add(33,"A pessoa leciona a disciplina Matematica Aplicada a Computacao?");
        lista_perguntaPadrao.add(34,"A pessoa leciona a disciplina Banco de Dados?");
        lista_perguntaPadrao.add(35,"A pessoa trabalha em um aviario?");
        lista_perguntaPadrao.add(36,"A pessoa trabalha em uma mecanica?");
        lista_perguntaPadrao.add(37,"A pessoa trabalha na Brafer?");
        lista_perguntaPadrao.add(38,"A pessoa tem piercing?");
        // novas perguntas
        lista_perguntaPadrao.add(39,"A pessoa e parda?");
        lista_perguntaPadrao.add(40,"Tatuado?");
        lista_perguntaPadrao.add(41,"Faz dependencia");
        lista_perguntaPadrao.add(42,"Altura ate 1.69");
        lista_perguntaPadrao.add(43,"Altura ate 1.79");
        lista_perguntaPadrao.add(44,"Altura ate 1.90");
        lista_perguntaPadrao.add(45,"Trabalha banco brasil");
        lista_perguntaPadrao.add(46,"Trabalha delta cable");
        lista_perguntaPadrao.add(47,"Trabalha mundo cell");
        lista_perguntaPadrao.add(48,"Trabalha renault");
        lista_perguntaPadrao.add(49,"Trabalha refrio");
        lista_perguntaPadrao.add(50,"Trabalha prefeit lapa");
        lista_perguntaPadrao.add(51,"Trabalha gelopar");
        lista_perguntaPadrao.add(52,"Trabalha na empresa abra");
        lista_perguntaPadrao.add(53,"Trabalha prefeit araucity");
        lista_perguntaPadrao.add(54,"Trabalha camera araucaria");
        lista_perguntaPadrao.add(55,"jogada foritinite");
        lista_perguntaPadrao.add(56,"joga fifa");
        lista_perguntaPadrao.add(57,"joga overwatch");
        lista_perguntaPadrao.add(58,"joga pubg");
        lista_perguntaPadrao.add(59,"cursa SI");
        lista_perguntaPadrao.add(60,"cursa ADS");
        lista_perguntaPadrao.add(61,"usa aparelho");
        lista_perguntaPadrao.add(62,"Trabalha Alta Rail Technology");
           
        
        return (ArrayList) lista_perguntaPadrao;
    }
}
