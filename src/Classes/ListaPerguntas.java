package Classes;

import java.util.ArrayList;
import java.util.List;

public class ListaPerguntas {
    
    
    public ArrayList retornaLista(){
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
}
