/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosTela;

/**
 *
 * @author Flávio
 */
public class PessoaTela {
    private Integer cod;
    private String nome;

    public PessoaTela(Integer cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }
    /**
     * @return the cod
     */
    public Integer getCod() {
        return cod;
    }

    /**
     * @param cod the cod to set
     */
    public void setCod(Integer cod) {
        this.cod = cod;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
