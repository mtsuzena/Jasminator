package Classes;

public class Pessoa {
        private Integer codPessoa;
	private String nome;
        
        private boolean p_periodo; // Primeiro periodo
        private boolean s_periodo; 
        private boolean t_periodo;
        
        private boolean masculino;
        
        private boolean calvo;  //  A pessoa que você esta pensando é calvo?
        private boolean cabeloOndulado;
        private boolean cabeloCrespo;
        private boolean cabeloLiso;
        
        private boolean cabeloCurto;
        private boolean cabeloMedio;
        private boolean cabeloLongo;
        
        private boolean cabeloLoiro;
        private boolean cabeloPreto;
        private boolean cabeloCastanho;
        private boolean cabeloAvermelhado;
        
        private boolean tomPeleClaro;
        private boolean tomPeleEscura;
        
        private boolean tomOlhoVerde;
        private boolean tomOlhoAzul;
        private boolean tomOlhoCastanho;
        private boolean usaOculos;
        
        private boolean alto; 
        
        private boolean barba;  //  tem barba?
        
        private boolean usaChapeu;
        
        private boolean usaRoupaSocial;
        
        private boolean professor;
        
        private boolean maior20;
	private Integer idade;
	
	private boolean jogaLOL;
        private boolean jogaCSGO;
        
        private boolean graduadoQuimica;
        
        private boolean eDoExercito;
        
        private boolean lecionaPOO;
        private boolean lecionaAC;
        private boolean lecionaMAC;
        private boolean lecionaBD;
        
        private boolean trabalhaAviario;
        private boolean trabalhaMecanica;
        private boolean trabalhaBrafer;
        
        private boolean temPiercing;
	
	

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

    public boolean isMaior20() {
        return maior20;
    }

    public void setMaior20(boolean maior20) {
        this.maior20 = maior20;
    }	

    
    public boolean isP_periodo() {
        return p_periodo;
    }

   
    public void setP_periodo(boolean p_periodo) {
        this.p_periodo = p_periodo;
    }

    
    public boolean isS_periodo() {
        return s_periodo;
    }

    
    public void setS_periodo(boolean s_periodo) {
        this.s_periodo = s_periodo;
    }

  
    public boolean isT_periodo() {
        return t_periodo;
    }

    
    public void setT_periodo(boolean t_periodo) {
        this.t_periodo = t_periodo;
    }

    
    public boolean isCabeloOndulado() {
        return cabeloOndulado;
    }

    
    public void setCabeloOndulado(boolean cabeloOndulado) {
        this.cabeloOndulado = cabeloOndulado;
    }

    
    public boolean isCabeloCrespo() {
        return cabeloCrespo;
    }

   
    public void setCabeloCrespo(boolean cabeloCrespo) {
        this.cabeloCrespo = cabeloCrespo;
    }

    
    public boolean isCabeloLiso() {
        return cabeloLiso;
    }

    
    public void setCabeloLiso(boolean cabeloLiso) {
        this.cabeloLiso = cabeloLiso;
    }

    
    public boolean isCabeloCurto() {
        return cabeloCurto;
    }

 
    public void setCabeloCurto(boolean cabeloCurto) {
        this.cabeloCurto = cabeloCurto;
    }

    
    public boolean isCabeloMedio() {
        return cabeloMedio;
    }

    
    public void setCabeloMedio(boolean cabeloMedio) {
        this.cabeloMedio = cabeloMedio;
    }

    
    public boolean isCabeloLoiro() {
        return cabeloLoiro;
    }

    
    public void setCabeloLoiro(boolean cabeloLoiro) {
        this.cabeloLoiro = cabeloLoiro;
    }

    
    public boolean isCabeloPreto() {
        return cabeloPreto;
    }

    
    public void setCabeloPreto(boolean cabeloPreto) {
        this.cabeloPreto = cabeloPreto;
    }

   
    public boolean isCabeloCastanho() {
        return cabeloCastanho;
    }

    
    public void setCabeloCastanho(boolean cabeloCastanho) {
        this.cabeloCastanho = cabeloCastanho;
    }

    
    public boolean isCabeloAvermelhado() {
        return cabeloAvermelhado;
    }

   
    public void setCabeloAvermelhado(boolean cabeloAvermelhado) {
        this.cabeloAvermelhado = cabeloAvermelhado;
    }

    
    public boolean isTomPeleClaro() {
        return tomPeleClaro;
    }

    
    public void setTomPeleClaro(boolean tomPeleClaro) {
        this.tomPeleClaro = tomPeleClaro;
    }

    
    public boolean isTomPeleEscura() {
        return tomPeleEscura;
    }

   
    public void setTomPeleEscura(boolean tomPeleEscura) {
        this.tomPeleEscura = tomPeleEscura;
    }

    
    public boolean isTomOlhoVerde() {
        return tomOlhoVerde;
    }

    
    public void setTomOlhoVerde(boolean tomOlhoVerde) {
        this.tomOlhoVerde = tomOlhoVerde;
    }

   
    public boolean isTomOlhoAzul() {
        return tomOlhoAzul;
    }

    
    public void setTomOlhoAzul(boolean tomOlhoAzul) {
        this.tomOlhoAzul = tomOlhoAzul;
    }

    
    public boolean isTomOlhoCastanho() {
        return tomOlhoCastanho;
    }

   
    public void setTomOlhoCastanho(boolean tomOlhoCastanho) {
        this.tomOlhoCastanho = tomOlhoCastanho;
    }

    
    public boolean isUsaOculos() {
        return usaOculos;
    }

    
    public void setUsaOculos(boolean usaOculos) {
        this.usaOculos = usaOculos;
    }

    
    public boolean isUsaChapeu() {
        return usaChapeu;
    }

    
    public void setUsaChapeu(boolean usaChapeu) {
        this.usaChapeu = usaChapeu;
    }

    
    public boolean isUsaRoupaSocial() {
        return usaRoupaSocial;
    }

    
    public void setUsaRoupaSocial(boolean usaRoupaSocial) {
        this.usaRoupaSocial = usaRoupaSocial;
    }

    
    public boolean isJogaLOL() {
        return jogaLOL;
    }

   
    public void setJogaLOL(boolean jogaLOL) {
        this.jogaLOL = jogaLOL;
    }

    
    public boolean isJogaCSGO() {
        return jogaCSGO;
    }

    
    public void setJogaCSGO(boolean jogaCSGO) {
        this.jogaCSGO = jogaCSGO;
    }

    
    public boolean isGraduadoQuimica() {
        return graduadoQuimica;
    }

   
    public void setGraduadoQuimica(boolean graduadoQuimica) {
        this.graduadoQuimica = graduadoQuimica;
    }

    
    public boolean iseDoExercito() {
        return eDoExercito;
    }

    
    public void seteDoExercito(boolean eDoExercito) {
        this.eDoExercito = eDoExercito;
    }

    
    public boolean isLecionaPOO() {
        return lecionaPOO;
    }

   
    public void setLecionaPOO(boolean lecionaPOO) {
        this.lecionaPOO = lecionaPOO;
    }

    
    public boolean isLecionaAC() {
        return lecionaAC;
    }

    
    public void setLecionaAC(boolean lecionaAC) {
        this.lecionaAC = lecionaAC;
    }

    
    public boolean isLecionaMAC() {
        return lecionaMAC;
    }

    
    public void setLecionaMAC(boolean lecionaMAC) {
        this.lecionaMAC = lecionaMAC;
    }

    
    public boolean isLecionaBD() {
        return lecionaBD;
    }

   
    public void setLecionaBD(boolean lecionaBD) {
        this.lecionaBD = lecionaBD;
    }

    
    public boolean isTrabalhaAviario() {
        return trabalhaAviario;
    }

  
    public void setTrabalhaAviario(boolean trabalhaAviario) {
        this.trabalhaAviario = trabalhaAviario;
    }

    public boolean isTrabalhaMecanica() {
        return trabalhaMecanica;
    }

   
    public void setTrabalhaMecanica(boolean trabalhaMecanica) {
        this.trabalhaMecanica = trabalhaMecanica;
    }

    
    public boolean isTrabalhaBrafer() {
        return trabalhaBrafer;
    }

   
    public void setTrabalhaBrafer(boolean trabalhaBrafer) {
        this.trabalhaBrafer = trabalhaBrafer;
    }

    
    public boolean isTemPiercing() {
        return temPiercing;
    }

    
    public void setTemPiercing(boolean temPiercing) {
        this.temPiercing = temPiercing;
    }
}