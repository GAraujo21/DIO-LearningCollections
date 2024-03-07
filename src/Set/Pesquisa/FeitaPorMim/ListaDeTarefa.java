package Set.Pesquisa.FeitaPorMim;

import java.util.HashSet;
import java.util.Set;

public class ListaDeTarefa {
    Set<Tarefa> tarefaSet;

    public ListaDeTarefa() {
        this.tarefaSet = new HashSet<>();
    }

    public void adicionarTarefa(String descricao) {
        if (descricao != null) {
            tarefaSet.add(new Tarefa(descricao));
        } else {
            System.out.println("A descrição passada foi nula! Por favor se atentar a isto");
        }
    }

    public void removerTarefa(String descricao) {
        Tarefa tarefasParaRemover = null;
        if (!tarefaSet.isEmpty()) {
            // tentei usar o contais, mas ela verifica se o conjunto tem o elemento IGUAL
            // contudo, o conjunto palavrasUnicasSet tem um objeto Tarefa
            // ou seja, não há como passar somente uma string(descricao).
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    tarefasParaRemover = t;
                    break;
                }
            }
            if (tarefasParaRemover != null) {
                tarefaSet.remove(tarefasParaRemover);
                System.out.println("A tarefa, '" + descricao + "' foi removida com sucesso.");
            } else {
                System.out.println("A descrição está vazia.");
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    public void exibirTarefas() {
        if (!tarefaSet.isEmpty()) {
            System.out.println(tarefaSet);
        } else {
            System.out.println("O conjunto de tarefas está vazio!");
        }
    }

    public void contarTarefa() {
        System.out.println("Existem " + tarefaSet.size() + " tarefas no conjunto!");
    }

    // Outra maneira
    /*
    public int contarTarefas() {
        return tarefasSet.size();
    }
     */

    public Set<Tarefa> obterTarefasConcluidas() {
        Set<Tarefa> tarefasConcluidas = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                // (t.isConcluidoOuNao() == true) é o mesmo que embaixo
                if (t.isConcluidoOuNao()) {
                    tarefasConcluidas.add(t);
                }
            }
            if (!tarefasConcluidas.isEmpty()) {
                return tarefasConcluidas;
            } else {
//                System.out.println("Não há tarefas concluídas");
                throw new RuntimeException("Não há tarefas concluídas");
            }

        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    // Outra forma
    /*
    public Set<Tarefa> obterTarefasConcluidas() {
    Set<Tarefa> tarefasConcluidas = new HashSet<>();
    for (Tarefa t : tarefasSet) {
      if (t.isConcluida()) {
        tarefasConcluidas.add(t);
      }
    }
    return tarefasConcluidas;
    }
     */

    public Set<Tarefa> obterTarefasPendentes() {
        Set<Tarefa> tarefasPendentes = new HashSet<>();
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                // (t.isConcluidoOuNao() == false) é o mesmo que embaixo
                if (!t.isConcluidoOuNao()) {
                    tarefasPendentes.add(t);
                }
            }
            if (!tarefasPendentes.isEmpty()) {
                return tarefasPendentes;
            } else {
                throw new RuntimeException("Não há tarefas pendentes");
            }

        } else {
            throw new RuntimeException("O conjunto está vazio");
        }
    }

    // Outra forma
    /*
    public Set<Tarefa> obterTarefasPendentes() {
    Set<Tarefa> tarefasNaoConcluidas = new HashSet<>();
    for (Tarefa t : tarefasSet) {
      if (!t.isConcluida()) {
        tarefasNaoConcluidas.add(t);
      }
    }
    return tarefasNaoConcluidas;
    }
     */

    public void marcarTarefaConcluida(String descricao) {
        if (!tarefaSet.isEmpty()) {
            for (Tarefa t : tarefaSet) {
                if (t.getDescricao().equalsIgnoreCase(descricao)) {
                    t.setConcluidoOuNao(true);
                    break;
                } else {
                    System.out.println("Não existe tarefa com esta descrição");
                }
            }
        } else {
            System.out.println("O conjunto está vazio!");
        }
    }

    // essa forma é maior e mais trabalhosa, mas funciona igual
//    public void marcarTarefaConcluida(String descricao){
//        Tarefa tarefaConcluida = null;
//        if(!tarefaSet.isEmpty()){
//            for(Tarefa t : tarefaSet){
//                if (t.getDescricao().equalsIgnoreCase(descricao)){
//                    tarefaConcluida = t;
//                    tarefaConcluida.setConcluidoOuNao(true);
//                    System.out.println("A tarefa " + descricao + " foi concluida com sucesso!");
//                }
//            }
//        }
//    }

    public void marcarTarefaPendente(String descricao) {
        for (Tarefa t : tarefaSet) {
            if (t.getDescricao().equalsIgnoreCase(descricao)) {
                t.setConcluidoOuNao(false);
                break;
            }
        }
    }
    // tem como aprofundar este método, verificando se a descrição não é nula, e só apos setar para false.

    public void limparListaTarefas() {
        if (tarefaSet.isEmpty()) {
            System.out.println("A lista já se encontra vazia!");
        } else {
            tarefaSet.clear();
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ListaTarefas
        ListaDeTarefa listaTarefas = new ListaDeTarefa();

        // Adicionando tarefas à lista
        listaTarefas.adicionarTarefa("Estudar Java");
        listaTarefas.adicionarTarefa("Fazer exercícios físicos");
        listaTarefas.adicionarTarefa("Organizar a mesa de trabalho");
        listaTarefas.adicionarTarefa("Ler livro");
        listaTarefas.adicionarTarefa("Preparar apresentação");

        // Exibindo as tarefas na lista
        listaTarefas.exibirTarefas();

        // Removendo uma tarefa
        listaTarefas.removerTarefa("Fazer exercícios físicos");
        listaTarefas.exibirTarefas();

        // Contando o número de tarefas na lista
        listaTarefas.contarTarefa();

        // Obtendo tarefas pendentes
        System.out.println(listaTarefas.obterTarefasPendentes());

        // Marcando tarefas como concluídas
        listaTarefas.marcarTarefaConcluida("Ler livro");
        listaTarefas.marcarTarefaConcluida("Estudar Java");

        // Obtendo tarefas concluídas
        System.out.println(listaTarefas.obterTarefasConcluidas());

        // Marcando tarefas como pendentes
        listaTarefas.marcarTarefaPendente("Estudar Java");
        listaTarefas.exibirTarefas();

        // Limpando a lista de tarefas
        listaTarefas.limparListaTarefas();
        listaTarefas.exibirTarefas();
    }
}
