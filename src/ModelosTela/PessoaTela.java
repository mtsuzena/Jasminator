package ModelosTela;

public class PessoaTela {
    private Integer cod;
    private String nome;

    public PessoaTela(Integer cod, String nome){
        this.cod = cod;
        this.nome = nome;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}