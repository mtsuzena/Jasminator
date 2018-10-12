package Classes;

import java.util.List;

public class EliminaPessoas {
    public static List<Pessoa> getPredicaoPessoa(List<Pessoa> lista_pessoas, Integer resp, Integer numPergunta){
            // switch com cases para cada pergunta do sistema
            // ** Sera entrado no case conforme a pergunta gerada acima
            //    logo em seguida faz as operacoes
            //    conforme a respota do usuario, o sistema tira ou nao determinadas
            //    pessoas do ArrayList de pessoas
        switch(numPergunta){
                case 0:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCalvo() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            }
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCalvo() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 1:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLongo() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLongo() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 2: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isAlto() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            }
                           //
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isAlto() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 3:                
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isBarba() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isBarba() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 4:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isProfessor() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isProfessor() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 5:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMasculino() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMasculino() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 6:  
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloClaro()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloClaro() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 7: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isOlhoEscuro() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isOlhoEscuro() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 8: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMaior20() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMaior20() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
        }
        
        return lista_pessoas;
    }
    
}
