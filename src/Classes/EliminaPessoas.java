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
    
    public static List<Pessoa> getPredicaoPessoa_NEW(List<Pessoa> lista_pessoas, Integer resp, Integer numPergunta){
            // switch com cases para cada pergunta do sistema
            // ** Sera entrado no case conforme a pergunta gerada acima
            //    logo em seguida faz as operacoes
            //    conforme a respota do usuario, o sistema tira ou nao determinadas
            //    pessoas do ArrayList de pessoas
        switch(numPergunta){
                case 0:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isP_periodo() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            }
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isP_periodo()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 1:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isS_periodo() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isS_periodo() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 2: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isT_periodo() == true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            }
                           //
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isT_periodo() != true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 3:                
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMasculino()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMasculino()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 4:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCalvo()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCalvo()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 5:
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloOndulado()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloOndulado()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 6:  
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCrespo()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCrespo()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 7: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLiso()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLiso()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 8: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCurto()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCurto()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 9: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloMedio()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloMedio()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 10: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLongo()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLongo()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 11: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLoiro()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloLoiro()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 12: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloPreto()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloPreto()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 13: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCastanho()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloCastanho()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 14: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloAvermelhado()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isCabeloAvermelhado()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 15: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomPeleClaro()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomPeleClaro()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 16: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomPeleEscura()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomPeleEscura()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 17: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoVerde()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoVerde()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 18: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoAzul()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoAzul()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 19: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoCastanho()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTomOlhoCastanho()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 20: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaOculos()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaOculos()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 21: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isAlto()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isAlto()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 22: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isBarba()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isBarba()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 23: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaChapeu()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaChapeu()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 24: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaRoupaSocial()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isUsaRoupaSocial()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 25: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isProfessor()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isProfessor()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 26: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMaior20()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isMaior20()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 27: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isJogaLOL()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isJogaLOL()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 28: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isJogaCSGO()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isJogaCSGO()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 29: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isGraduadoQuimica()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isGraduadoQuimica()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 30: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).iseDoExercito()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).iseDoExercito()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 31: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaPOO()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaPOO()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 32: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaAC()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaAC()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 33: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaMAC()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaMAC()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 34: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaBD()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isLecionaBD()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 35: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaAviario()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaAviario()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 36: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaMecanica()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaMecanica()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 37: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaBrafer()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTrabalhaBrafer()!= true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        } 
                    }
                    break;
                case 38: 
                    if(resp==0){
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTemPiercing()== true){
                                lista_pessoas.remove(cont);
                                cont=cont-1;
                            } 
                        }
                    }else{
                        for (int cont = 0; cont < lista_pessoas.size(); cont++){
                           if(lista_pessoas.get(cont).isTemPiercing()!= true){
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
