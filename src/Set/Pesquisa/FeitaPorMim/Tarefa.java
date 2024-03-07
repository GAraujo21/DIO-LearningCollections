package Set.Pesquisa.FeitaPorMim;

public class Tarefa {
    private String descricao;
    private boolean concluidoOuNao;

    // ao meu ver, poderia criar uma tarefa dizendo se ela foi concluida ou não, mas
    // a questão pede que a classe tarefa tenha somente um paramentro como construtor
    // logo, como valor "default" direi que a conclusão é false;
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluidoOuNao = false;
    }

    public String getDescricao() {
        return descricao;
    }

    public boolean isConcluidoOuNao() {
        return concluidoOuNao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setConcluidoOuNao(boolean concluidoOuNao) {
        this.concluidoOuNao = concluidoOuNao;
    }

    @Override
    public String toString() {
        return "Tarefa{" +
                "descricao='" + descricao + '\'' +
                ", concluidoOuNao=" + concluidoOuNao +
                '}';
    }
}
