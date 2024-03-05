package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class ListaTarefas {
    //atributo, lista vazia para poder adicionar com o tempo
    private List<Tarefa> tarefaList;

    public ListaTarefas() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao){
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao){
        List<Tarefa> tarefasParaRemover = new ArrayList<>();
        for(Tarefa t : tarefaList){
            if(t.getDescricao().equalsIgnoreCase(descricao)){
                tarefasParaRemover.add(t);
            }
        }
        //usasse o remove All para eliminar todas as descrições que forem iguais.
        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalDeTarefas(){
        //esse método retornará um número que indica quantas descrições há na tarefaList;
        return tarefaList.size();
    }

    public void obterDescricoesTarefas(){
        System.out.println(tarefaList);
    }


    // --------------------------------------------------------------------------------------


    //para poder testar, cria-se o método main
    public static void main(String[] args) {
        ListaTarefas listaTarefas = new ListaTarefas();

        System.out.println("o número total de elementos na lita é: " + listaTarefas.obterNumeroTotalDeTarefas());

        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 1");
        listaTarefas.adicionarTarefa("Tarefa 3");
        System.out.println("o número total de elementos na lita é: " + listaTarefas.obterNumeroTotalDeTarefas());

        listaTarefas.removerTarefa("Tarefa 1");
        System.out.println("o número total de elementos na lita é: " + listaTarefas.obterNumeroTotalDeTarefas());

        listaTarefas.obterDescricoesTarefas();
    }
}
