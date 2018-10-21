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
    
    public static ArrayList retornaLista_New(){
        List<String> lista_perguntaPadrao = new ArrayList<String>();
        
        lista_perguntaPadrao.add(0,"O personagem é do primeiro periodo de ADS/SI?");
        lista_perguntaPadrao.add(1,"O personagem é do segundo periodo de Ands/SI?");
        lista_perguntaPadrao.add(2,"O personagem é do terceiro periodo de Ands/SI?");
        lista_perguntaPadrao.add(3,"O personagem é do sexo masculino?");
        
        // Perguntas sobre cabelo
        lista_perguntaPadrao.add(4,"O personagem tem estilo de corte careca?");
        lista_perguntaPadrao.add(5,"O personagem tem cabelo ondulado");
        lista_perguntaPadrao.add(6,"O personagem tem cabelo crespo");
        lista_perguntaPadrao.add(7,"O personagem tem cabelo liso");
        lista_perguntaPadrao.add(8,"O personagem tem cabelo curto?");
        lista_perguntaPadrao.add(9,"O personagem tem cabelo medio?");
        lista_perguntaPadrao.add(10,"O personagem tem cabelo longo?");
        lista_perguntaPadrao.add(11,"O personagem tem cabelo da cor loiro?");
        lista_perguntaPadrao.add(12,"O personagem tem cabelo da cor preto?");
        lista_perguntaPadrao.add(13,"O personagem tem cabelo da cor castanho?");
        lista_perguntaPadrao.add(14,"O personagem tem cabelo da cor avermelhado?");
        
        //Tom da pele
        lista_perguntaPadrao.add(15,"O personagem tem tom de pele claro?");
        lista_perguntaPadrao.add(16,"O personagem tem tom de pele escuro?");
        
        //Tom olhos
        lista_perguntaPadrao.add(17,"O personagem tem o tom dos olhos verde");
        lista_perguntaPadrao.add(18,"O personagem tem o tom dos olhos azuis?");
        lista_perguntaPadrao.add(19,"O personagem tem o tom dos olhos castanhos?");
        lista_perguntaPadrao.add(20," O personagem usa óculos?");
        
        //Caracteristicas gerais
        lista_perguntaPadrao.add(21,"O personagem é alto?");
        lista_perguntaPadrao.add(22,"O personagem tem barba ?");
        lista_perguntaPadrao.add(23,"O personagem usa chapeus/boné?");
        lista_perguntaPadrao.add(24,"O personagem usa roupa social?");
        lista_perguntaPadrao.add(25,"O personagem é professor?");
        lista_perguntaPadrao.add(26,"O personagem tem 20 anos ou mais?  ");
        
        // Jogos
        lista_perguntaPadrao.add(27,"O personagem joga League of Legends?");
        lista_perguntaPadrao.add(28,"O personagem joga CS:GO?");
        
        //Específicas
        lista_perguntaPadrao.add(29,"O personagem é graduado em química na UFPR?");
        lista_perguntaPadrao.add(30,"O personagem é do exercíto?");
        lista_perguntaPadrao.add(31,"O personagem leciona a disciplina Programacao Orietada a Objetos?");
        lista_perguntaPadrao.add(32,"O personagem leciona a disciplina Arquitetura de Computadores?");
        lista_perguntaPadrao.add(33,"O personagem leciona a disciplina Matematica Aplicada a Computacao?");
        lista_perguntaPadrao.add(34,"O personagem leciona a disciplina Banco de Dados?");
        lista_perguntaPadrao.add(35,"O personagem trabalha em um aviario?");
        lista_perguntaPadrao.add(36,"O personagem trabalha em uma mecanica?");
        lista_perguntaPadrao.add(37,"O personagem trabalha na Brafer?");
        lista_perguntaPadrao.add(38,"O personagem tem piercing?");
        
        
           
        
        return (ArrayList) lista_perguntaPadrao;
    }
}
