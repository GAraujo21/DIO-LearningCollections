package Maps.Ordenacao;

public class Evento {
    private String nome;

    //poderia ser uma Collection: List ou Map.
    private String atracao;

    public Evento(String nome, String atracao) {
        this.nome = nome;
        this.atracao = atracao;
    }

    public String getNome() {
        return nome;
    }

    public String getAtracao() {
        return atracao;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "nome='" + nome + '\'' +
                ", atracao=" + atracao +
                '}';
    }
}
