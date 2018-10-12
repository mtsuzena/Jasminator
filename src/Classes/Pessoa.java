package Classes;

public class Pessoa {
	private String texto;
        private Integer codPessoa;
	private String nome;
	private Integer idade;
	private boolean calvo;  //  A pessoa que você esta pensando é calvo?
	private boolean cabeloLongo;
	private boolean alto;   //  ?
	private boolean barba;  //  tem barba?
	private boolean professor;
        private boolean masculino;
        private boolean cabeloClaro;
        private boolean olhoEscuro;
        private boolean maior20;

    public Integer getCodPessoa(){
        return this.codPessoa;
    }
    
    public void setCodPessoa(Integer codPessoa){
        this.codPessoa=codPessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public boolean isCalvo() {
        return calvo;
    }

    public void setCalvo(boolean calvo) {
        this.calvo = calvo;
    }

    public boolean isCabeloLongo() {
        return cabeloLongo;
    }

    public void setCabeloLongo(boolean cabeloLongo) {
        this.cabeloLongo = cabeloLongo;
    }

    public boolean isAlto() {
        return alto;
    }

    public void setAlto(boolean alto) {
        this.alto = alto;
    }

    public boolean isBarba() {
        return barba;
    }

    public void setBarba(boolean barba) {
        this.barba = barba;
    }

    public boolean isProfessor() {
        return professor;
    }

    public void setProfessor(boolean professor) {
        this.professor = professor;
    }

    public boolean isMasculino() {
        return masculino;
    }

    public void setMasculino(boolean masculino) {
        this.masculino = masculino;
    }

    public boolean isCabeloClaro() {
        return cabeloClaro;
    }

    public void setCabeloClaro(boolean cabeloClaro) {
        this.cabeloClaro = cabeloClaro;
    }
 
    public boolean isOlhoEscuro() {
        return olhoEscuro;
    }

    public void setOlhoEscuro(boolean olhoEscuro) {
        this.olhoEscuro = olhoEscuro;
    }

    public boolean isMaior20() {
        return maior20;
    }

    public void setMaior20(boolean maior20) {
        this.maior20 = maior20;
    }	
}