package list.OperacoesBasicas;

public class Tarefa {
    //atributo
    private String descricao;

    //atalho no intelliJ para criar construtor -> alt + insert
    public Tarefa(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
