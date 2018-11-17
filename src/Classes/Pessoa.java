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
        
        private boolean tomPeleClaro;   // BRANCO
        private boolean tomPeleEscura; // NEGRO
        
        
        private boolean tomOlhoVerde;
        private boolean tomOlhoAzul;
        private boolean tomOlhoCastanho;
        private boolean usaOculos;
        
        
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
        
        private boolean tomPelePardo;
        
        private boolean tatuado;
        
        private boolean dependencia;
        
        private boolean alturaAte69;
        private boolean alturaAte79;
        private boolean alturaAte90;
        
        private boolean trabalhaBancoBrasil;
        private boolean trabalhaDeltaCable;
        private boolean trabalhaMundoCell;
        private boolean trabalhaRenault;
        private boolean trabalhaRefrio;
        private boolean trabalhaPrefeituraLapa;
        private boolean trabalhaGelopar;
        private boolean trabalhaAbra;
        private boolean trabalhaPrefeituraAraucaria;
        private boolean trabalhaCameraAraucaria;
        private boolean trabalhaART;
        
	private boolean jogaFortinite;
        private boolean jogaFifa;
        private boolean jogaOverwatch;
        private boolean jogaPubg;
        
        private boolean cursoSI;
        private boolean cursoADS;
        
        private boolean usaAparelho;
        
	private String caminho_imagem;
        
        
        

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

    /**
     * @return the tomPelePardo
     */
    public boolean isTomPelePardo() {
        return tomPelePardo;
    }

    /**
     * @param tomPelePardo the tomPelePardo to set
     */
    public void setTomPelePardo(boolean tomPelePardo) {
        this.tomPelePardo = tomPelePardo;
    }

    
    public boolean isTrabalhaBancoBrasil() {
        return trabalhaBancoBrasil;
    }

    /**
     * @param trabalhaBancoBrasil the trabalhaBancoBrasil to set
     */
    public void setTrabalhaBancoBrasil(boolean trabalhaBancoBrasil) {
        this.trabalhaBancoBrasil = trabalhaBancoBrasil;
    }

    /**
     * @return the trabalhaDeltaCable
     */
    public boolean isTrabalhaDeltaCable() {
        return trabalhaDeltaCable;
    }

    /**
     * @param trabalhaDeltaCable the trabalhaDeltaCable to set
     */
    public void setTrabalhaDeltaCable(boolean trabalhaDeltaCable) {
        this.trabalhaDeltaCable = trabalhaDeltaCable;
    }

    /**
     * @return the trabalhaMundoCell
     */
    public boolean isTrabalhaMundoCell() {
        return trabalhaMundoCell;
    }

    /**
     * @param trabalhaMundoCell the trabalhaMundoCell to set
     */
    public void setTrabalhaMundoCell(boolean trabalhaMundoCell) {
        this.trabalhaMundoCell = trabalhaMundoCell;
    }

    /**
     * @return the trabalhaRenault
     */
    public boolean isTrabalhaRenault() {
        return trabalhaRenault;
    }

    /**
     * @param trabalhaRenault the trabalhaRenault to set
     */
    public void setTrabalhaRenault(boolean trabalhaRenault) {
        this.trabalhaRenault = trabalhaRenault;
    }

    /**
     * @return the trabalhaRefrio
     */
    public boolean isTrabalhaRefrio() {
        return trabalhaRefrio;
    }

    /**
     * @param trabalhaRefrio the trabalhaRefrio to set
     */
    public void setTrabalhaRefrio(boolean trabalhaRefrio) {
        this.trabalhaRefrio = trabalhaRefrio;
    }

    /**
     * @return the trabalhaPrefeituraLapa
     */
    public boolean isTrabalhaPrefeituraLapa() {
        return trabalhaPrefeituraLapa;
    }

    /**
     * @param trabalhaPrefeituraLapa the trabalhaPrefeituraLapa to set
     */
    public void setTrabalhaPrefeituraLapa(boolean trabalhaPrefeituraLapa) {
        this.trabalhaPrefeituraLapa = trabalhaPrefeituraLapa;
    }

    /**
     * @return the trabalhaGelopar
     */
    public boolean isTrabalhaGelopar() {
        return trabalhaGelopar;
    }

    /**
     * @param trabalhaGelopar the trabalhaGelopar to set
     */
    public void setTrabalhaGelopar(boolean trabalhaGelopar) {
        this.trabalhaGelopar = trabalhaGelopar;
    }

    /**
     * @return the trabalhaAbra
     */
    public boolean isTrabalhaAbra() {
        return trabalhaAbra;
    }

    /**
     * @param trabalhaAbra the trabalhaAbra to set
     */
    public void setTrabalhaAbra(boolean trabalhaAbra) {
        this.trabalhaAbra = trabalhaAbra;
    }

    /**
     * @return the trabalhaPrefeituraAraucaria
     */
    public boolean isTrabalhaPrefeituraAraucaria() {
        return trabalhaPrefeituraAraucaria;
    }

    /**
     * @param trabalhaPrefeituraAraucaria the trabalhaPrefeituraAraucaria to set
     */
    public void setTrabalhaPrefeituraAraucaria(boolean trabalhaPrefeituraAraucaria) {
        this.trabalhaPrefeituraAraucaria = trabalhaPrefeituraAraucaria;
    }

    /**
     * @return the trabalhaCameraAraucaria
     */
    public boolean isTrabalhaCameraAraucaria() {
        return trabalhaCameraAraucaria;
    }

    /**
     * @param trabalhaCameraAraucaria the trabalhaCameraAraucaria to set
     */
    public void setTrabalhaCameraAraucaria(boolean trabalhaCameraAraucaria) {
        this.trabalhaCameraAraucaria = trabalhaCameraAraucaria;
    }

    /**
     * @return the jogaFortinite
     */
    public boolean isJogaFortinite() {
        return jogaFortinite;
    }

    /**
     * @param jogaFortinite the jogaFortinite to set
     */
    public void setJogaFortinite(boolean jogaFortinite) {
        this.jogaFortinite = jogaFortinite;
    }

    /**
     * @return the jogaFifa
     */
    public boolean isJogaFifa() {
        return jogaFifa;
    }

    /**
     * @param jogaFifa the jogaFifa to set
     */
    public void setJogaFifa(boolean jogaFifa) {
        this.jogaFifa = jogaFifa;
    }

    /**
     * @return the jogaOverwatch
     */
    public boolean isJogaOverwatch() {
        return jogaOverwatch;
    }

    /**
     * @param jogaOverwatch the jogaOverwatch to set
     */
    public void setJogaOverwatch(boolean jogaOverwatch) {
        this.jogaOverwatch = jogaOverwatch;
    }

    /**
     * @return the jogaPubg
     */
    public boolean isJogaPubg() {
        return jogaPubg;
    }

    /**
     * @param jogaPubg the jogaPubg to set
     */
    public void setJogaPubg(boolean jogaPubg) {
        this.jogaPubg = jogaPubg;
    }

    /**
     * @return the tatuado
     */
    public boolean isTatuado() {
        return tatuado;
    }

    /**
     * @param tatuado the tatuado to set
     */
    public void setTatuado(boolean tatuado) {
        this.tatuado = tatuado;
    }

    /**
     * @return the dependencia
     */
    public boolean isDependencia() {
        return dependencia;
    }

    /**
     * @param dependencia the dependencia to set
     */
    public void setDependencia(boolean dependencia) {
        this.dependencia = dependencia;
    }

    /**
     * @return the alturaAte69
     */
    public boolean isAlturaAte69() {
        return alturaAte69;
    }

    /**
     * @param alturaAte69 the alturaAte69 to set
     */
    public void setAlturaAte69(boolean alturaAte69) {
        this.alturaAte69 = alturaAte69;
    }

    /**
     * @return the alturaAte79
     */
    public boolean isAlturaAte79() {
        return alturaAte79;
    }

    /**
     * @param alturaAte79 the alturaAte79 to set
     */
    public void setAlturaAte79(boolean alturaAte79) {
        this.alturaAte79 = alturaAte79;
    }

    /**
     * @return the alturaAte90
     */
    public boolean isAlturaAte90() {
        return alturaAte90;
    }

    /**
     * @param alturaAte90 the alturaAte90 to set
     */
    public void setAlturaAte90(boolean alturaAte90) {
        this.alturaAte90 = alturaAte90;
    }

    /**
     * @return the cursoSI
     */
    public boolean isCursoSI() {
        return cursoSI;
    }

    /**
     * @param cursoSI the cursoSI to set
     */
    public void setCursoSI(boolean cursoSI) {
        this.cursoSI = cursoSI;
    }

    /**
     * @return the cursoADS
     */
    public boolean isCursoADS() {
        return cursoADS;
    }

    /**
     * @param cursoADS the cursoADS to set
     */
    public void setCursoADS(boolean cursoADS) {
        this.cursoADS = cursoADS;
    }

    /**
     * @return the usaAparelho
     */
    public boolean isUsaAparelho() {
        return usaAparelho;
    }

    /**
     * @param usaAparelho the usaAparelho to set
     */
    public void setUsaAparelho(boolean usaAparelho) {
        this.usaAparelho = usaAparelho;
    }

    /**
     * @return the trabalhaART
     */
    public boolean isTrabalhaART() {
        return trabalhaART;
    }

    /**
     * @param trabalhaART the trabalhaART to set
     */
    public void setTrabalhaART(boolean trabalhaART) {
        this.trabalhaART = trabalhaART;
    }

    /**
     * @return the caminho_imagem
     */
    public String getCaminho_imagem() {
        return caminho_imagem;
    }

    /**
     * @param caminho_imagem the caminho_imagem to set
     */
    public void setCaminho_imagem(String caminho_imagem) {
        this.caminho_imagem = caminho_imagem;
    }
}