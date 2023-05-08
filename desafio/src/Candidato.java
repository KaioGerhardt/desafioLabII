public class Candidato {
    
    private String nome;
    private String partido;
    private int intencoesVotos;

    public Candidato(String nome, String prtido, int intencoesVotos){

        setNome(nome);
        setPartido(prtido);
        setIntencoesVotos(intencoesVotos);

    }

    public int getIntencoesVotos() {
        return this.intencoesVotos;
    }

    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPartido() {
        return this.partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    @Override
    public String toString(){
        return "Candidato [nome = " + this.nome + ", partido = " + this.partido + ", intencoesVotos = " + this.intencoesVotos + "]";
    }
}
