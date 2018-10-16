package Classes;

public class Pessoa {
	private String texto;
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
	
	
        
        private boolean cabeloClaro;
        private boolean olhoEscuro;

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

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the p_periodo
     */
    public boolean isP_periodo() {
        return p_periodo;
    }

    /**
     * @param p_periodo the p_periodo to set
     */
    public void setP_periodo(boolean p_periodo) {
        this.p_periodo = p_periodo;
    }

    /**
     * @return the s_periodo
     */
    public boolean isS_periodo() {
        return s_periodo;
    }

    /**
     * @param s_periodo the s_periodo to set
     */
    public void setS_periodo(boolean s_periodo) {
        this.s_periodo = s_periodo;
    }

    /**
     * @return the t_periodo
     */
    public boolean isT_periodo() {
        return t_periodo;
    }

    /**
     * @param t_periodo the t_periodo to set
     */
    public void setT_periodo(boolean t_periodo) {
        this.t_periodo = t_periodo;
    }

    /**
     * @return the cabeloOndulado
     */
    public boolean isCabeloOndulado() {
        return cabeloOndulado;
    }

    /**
     * @param cabeloOndulado the cabeloOndulado to set
     */
    public void setCabeloOndulado(boolean cabeloOndulado) {
        this.cabeloOndulado = cabeloOndulado;
    }

    /**
     * @return the cabeloCrespo
     */
    public boolean isCabeloCrespo() {
        return cabeloCrespo;
    }

    /**
     * @param cabeloCrespo the cabeloCrespo to set
     */
    public void setCabeloCrespo(boolean cabeloCrespo) {
        this.cabeloCrespo = cabeloCrespo;
    }

    /**
     * @return the cabeloLiso
     */
    public boolean isCabeloLiso() {
        return cabeloLiso;
    }

    /**
     * @param cabeloLiso the cabeloLiso to set
     */
    public void setCabeloLiso(boolean cabeloLiso) {
        this.cabeloLiso = cabeloLiso;
    }

    /**
     * @return the cabeloCurto
     */
    public boolean isCabeloCurto() {
        return cabeloCurto;
    }

    /**
     * @param cabeloCurto the cabeloCurto to set
     */
    public void setCabeloCurto(boolean cabeloCurto) {
        this.cabeloCurto = cabeloCurto;
    }

    /**
     * @return the cabeloMedio
     */
    public boolean isCabeloMedio() {
        return cabeloMedio;
    }

    /**
     * @param cabeloMedio the cabeloMedio to set
     */
    public void setCabeloMedio(boolean cabeloMedio) {
        this.cabeloMedio = cabeloMedio;
    }

    /**
     * @return the cabeloLoiro
     */
    public boolean isCabeloLoiro() {
        return cabeloLoiro;
    }

    /**
     * @param cabeloLoiro the cabeloLoiro to set
     */
    public void setCabeloLoiro(boolean cabeloLoiro) {
        this.cabeloLoiro = cabeloLoiro;
    }

    /**
     * @return the cabeloPreto
     */
    public boolean isCabeloPreto() {
        return cabeloPreto;
    }

    /**
     * @param cabeloPreto the cabeloPreto to set
     */
    public void setCabeloPreto(boolean cabeloPreto) {
        this.cabeloPreto = cabeloPreto;
    }

    /**
     * @return the cabeloCastanho
     */
    public boolean isCabeloCastanho() {
        return cabeloCastanho;
    }

    /**
     * @param cabeloCastanho the cabeloCastanho to set
     */
    public void setCabeloCastanho(boolean cabeloCastanho) {
        this.cabeloCastanho = cabeloCastanho;
    }

    /**
     * @return the cabeloAvermelhado
     */
    public boolean isCabeloAvermelhado() {
        return cabeloAvermelhado;
    }

    /**
     * @param cabeloAvermelhado the cabeloAvermelhado to set
     */
    public void setCabeloAvermelhado(boolean cabeloAvermelhado) {
        this.cabeloAvermelhado = cabeloAvermelhado;
    }

    /**
     * @return the tomPeleClaro
     */
    public boolean isTomPeleClaro() {
        return tomPeleClaro;
    }

    /**
     * @param tomPeleClaro the tomPeleClaro to set
     */
    public void setTomPeleClaro(boolean tomPeleClaro) {
        this.tomPeleClaro = tomPeleClaro;
    }

    /**
     * @return the tomPeleEscura
     */
    public boolean isTomPeleEscura() {
        return tomPeleEscura;
    }

    /**
     * @param tomPeleEscura the tomPeleEscura to set
     */
    public void setTomPeleEscura(boolean tomPeleEscura) {
        this.tomPeleEscura = tomPeleEscura;
    }

    /**
     * @return the tomOlhoVerde
     */
    public boolean isTomOlhoVerde() {
        return tomOlhoVerde;
    }

    /**
     * @param tomOlhoVerde the tomOlhoVerde to set
     */
    public void setTomOlhoVerde(boolean tomOlhoVerde) {
        this.tomOlhoVerde = tomOlhoVerde;
    }

    /**
     * @return the tomOlhoAzul
     */
    public boolean isTomOlhoAzul() {
        return tomOlhoAzul;
    }

    /**
     * @param tomOlhoAzul the tomOlhoAzul to set
     */
    public void setTomOlhoAzul(boolean tomOlhoAzul) {
        this.tomOlhoAzul = tomOlhoAzul;
    }

    /**
     * @return the tomOlhoCastanho
     */
    public boolean isTomOlhoCastanho() {
        return tomOlhoCastanho;
    }

    /**
     * @param tomOlhoCastanho the tomOlhoCastanho to set
     */
    public void setTomOlhoCastanho(boolean tomOlhoCastanho) {
        this.tomOlhoCastanho = tomOlhoCastanho;
    }

    /**
     * @return the usaOculos
     */
    public boolean isUsaOculos() {
        return usaOculos;
    }

    /**
     * @param usaOculos the usaOculos to set
     */
    public void setUsaOculos(boolean usaOculos) {
        this.usaOculos = usaOculos;
    }

    /**
     * @return the usaChapeu
     */
    public boolean isUsaChapeu() {
        return usaChapeu;
    }

    /**
     * @param usaChapeu the usaChapeu to set
     */
    public void setUsaChapeu(boolean usaChapeu) {
        this.usaChapeu = usaChapeu;
    }

    /**
     * @return the usaRoupaSocial
     */
    public boolean isUsaRoupaSocial() {
        return usaRoupaSocial;
    }

    /**
     * @param usaRoupaSocial the usaRoupaSocial to set
     */
    public void setUsaRoupaSocial(boolean usaRoupaSocial) {
        this.usaRoupaSocial = usaRoupaSocial;
    }

    /**
     * @return the jogaLOL
     */
    public boolean isJogaLOL() {
        return jogaLOL;
    }

    /**
     * @param jogaLOL the jogaLOL to set
     */
    public void setJogaLOL(boolean jogaLOL) {
        this.jogaLOL = jogaLOL;
    }

    /**
     * @return the jogaCSGO
     */
    public boolean isJogaCSGO() {
        return jogaCSGO;
    }

    /**
     * @param jogaCSGO the jogaCSGO to set
     */
    public void setJogaCSGO(boolean jogaCSGO) {
        this.jogaCSGO = jogaCSGO;
    }

    /**
     * @return the graduadoQuimica
     */
    public boolean isGraduadoQuimica() {
        return graduadoQuimica;
    }

    /**
     * @param graduadoQuimica the graduadoQuimica to set
     */
    public void setGraduadoQuimica(boolean graduadoQuimica) {
        this.graduadoQuimica = graduadoQuimica;
    }

    /**
     * @return the eDoExercito
     */
    public boolean iseDoExercito() {
        return eDoExercito;
    }

    /**
     * @param eDoExercito the eDoExercito to set
     */
    public void seteDoExercito(boolean eDoExercito) {
        this.eDoExercito = eDoExercito;
    }

    /**
     * @return the lecionaPOO
     */
    public boolean isLecionaPOO() {
        return lecionaPOO;
    }

    /**
     * @param lecionaPOO the lecionaPOO to set
     */
    public void setLecionaPOO(boolean lecionaPOO) {
        this.lecionaPOO = lecionaPOO;
    }

    /**
     * @return the lecionaAC
     */
    public boolean isLecionaAC() {
        return lecionaAC;
    }

    /**
     * @param lecionaAC the lecionaAC to set
     */
    public void setLecionaAC(boolean lecionaAC) {
        this.lecionaAC = lecionaAC;
    }

    /**
     * @return the lecionaMAC
     */
    public boolean isLecionaMAC() {
        return lecionaMAC;
    }

    /**
     * @param lecionaMAC the lecionaMAC to set
     */
    public void setLecionaMAC(boolean lecionaMAC) {
        this.lecionaMAC = lecionaMAC;
    }

    /**
     * @return the lecionaBD
     */
    public boolean isLecionaBD() {
        return lecionaBD;
    }

    /**
     * @param lecionaBD the lecionaBD to set
     */
    public void setLecionaBD(boolean lecionaBD) {
        this.lecionaBD = lecionaBD;
    }

    /**
     * @return the trabalhaAviario
     */
    public boolean isTrabalhaAviario() {
        return trabalhaAviario;
    }

    /**
     * @param trabalhaAviario the trabalhaAviario to set
     */
    public void setTrabalhaAviario(boolean trabalhaAviario) {
        this.trabalhaAviario = trabalhaAviario;
    }

    /**
     * @return the trabalhaMecanica
     */
    public boolean isTrabalhaMecanica() {
        return trabalhaMecanica;
    }

    /**
     * @param trabalhaMecanica the trabalhaMecanica to set
     */
    public void setTrabalhaMecanica(boolean trabalhaMecanica) {
        this.trabalhaMecanica = trabalhaMecanica;
    }

    /**
     * @return the trabalhaBrafer
     */
    public boolean isTrabalhaBrafer() {
        return trabalhaBrafer;
    }

    /**
     * @param trabalhaBrafer the trabalhaBrafer to set
     */
    public void setTrabalhaBrafer(boolean trabalhaBrafer) {
        this.trabalhaBrafer = trabalhaBrafer;
    }

    /**
     * @return the temPiercing
     */
    public boolean isTemPiercing() {
        return temPiercing;
    }

    /**
     * @param temPiercing the temPiercing to set
     */
    public void setTemPiercing(boolean temPiercing) {
        this.temPiercing = temPiercing;
    }
}