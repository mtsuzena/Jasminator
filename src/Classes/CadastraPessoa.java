/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author vm_su
 */
public class CadastraPessoa {
    
    
    public static List<Pessoa> cadastraPessoa(List<Pessoa> lista_pessoas){ 
      
            Pessoa pessoa = new Pessoa();
            Scanner sc = new Scanner(System.in);
            System.out.printf("CADASTRAR PESSOA\n\n");
            System.out.printf("Informe o nome");
            pessoa.setNome(sc.nextLine());
            
            pessoa.setCodPessoa((lista_pessoas.get(lista_pessoas.size()-1).getCodPessoa()+1));
            
            System.out.printf("Informe a idade");
            pessoa.setIdade(sc.nextInt());
            
            if(pessoa.getIdade()>20){
                pessoa.setMaior20(true);
            }else{
                pessoa.setMaior20(false);
            }
            
            Integer resp;
            System.out.printf("A pessoa e calva? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setCalvo(true);
            }else{
                pessoa.setCalvo(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa tem cabelos longos? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setCabeloLongo(true);
            }else{
                pessoa.setCabeloLongo(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa e alta? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setAlto(true);
            }else{
                pessoa.setAlto(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa tem barba? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setBarba(true);
            }else{
                pessoa.setBarba(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa e professor? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setProfessor(true);
            }else{
                pessoa.setProfessor(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa e do sexo masculino? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setMasculino(true);
            }else{
                pessoa.setMasculino(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa tem cabelo claro? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setCabeloClaro(true);
            }else{
                pessoa.setCabeloClaro(false);
            }
            System.out.println("");
            
            System.out.printf("A pessoa tem olho escuro? ");
            resp = sc.nextInt();
            if(resp==1){
                pessoa.setOlhoEscuro(true);
            }else{
                pessoa.setOlhoEscuro(false);
            }
            System.out.println("");
        
        ArquivoTxt.salvaTxt("dados_pessoas.txt", pessoa);
        lista_pessoas.add(pessoa);
        return lista_pessoas;
    }
    
}
