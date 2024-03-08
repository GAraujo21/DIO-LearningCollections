package Set.Ordenacao.FeitaPorMim;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class GerenciadorAlunos {
    private Set<Aluno> alunoSet;

    public GerenciadorAlunos() {
        this.alunoSet = new HashSet<>();
    }

    public void adicionarAluno(String nome, String matricula, double nota){
        alunoSet.add(new Aluno(nome, matricula, nota));
    }

    public void removerAluno(String matricula){
        Aluno alunoParaRemover = null;
        if(!alunoSet.isEmpty()){
            for(Aluno a : alunoSet){
                if(a.getMatricula().equalsIgnoreCase(matricula)){
                    alunoParaRemover = a;
                    break;
                }
                // esse else não pode existir assim, pois logo apos a 1 verificação, se ela
                // não for igual, ela erá mostrar a exceção!
//                else{
//                    throw new RuntimeException("A matricula '" + matricula + "' foi encontrada!");
//                }
            }
            if(alunoParaRemover != null){
                alunoSet.remove(alunoParaRemover);
                System.out.println("O aluno:" + alunoParaRemover + ", foi removido do conjunto.");
            }else {
                throw new RuntimeException("A matricula '" + matricula + "' foi encontrada!");
            }
        }else{
            throw new RuntimeException("O conjunto está vazio!");
        }
    }

    public Set<Aluno> exibirAlunosPorNome(){
//        Set<Aluno> alunoOrdenadoPorNome = new TreeSet<>(alunoSet);
//        return alunoOrdenadoPorNome;
        // o resultado é o mesmo que em baixo:
        return new TreeSet<>(alunoSet);
    }

    public Set<Aluno> exibirAlunosPorNotaCrescente(){
        Set<Aluno> alunoOrdenadoPorNota = new TreeSet<>(new CompararNota());
        if(!alunoSet.isEmpty()){
            alunoOrdenadoPorNota.addAll(alunoSet);
            return alunoOrdenadoPorNota;
        }else{
            throw new RuntimeException("O conjunto está vazio");
        }

    }

    public void exibirAlunos(){
        System.out.println(this.alunoSet);
    }

    public static void main(String[] args) {
        // Criando uma instância do GerenciadorAlunos
        GerenciadorAlunos gerenciadorAlunos = new GerenciadorAlunos();

        // Adicionando alunos ao gerenciador
        gerenciadorAlunos.adicionarAluno("João", "123456", 7.5);
        gerenciadorAlunos.adicionarAluno("Maria", "123457", 9.0);
        gerenciadorAlunos.adicionarAluno("Carlos", "123458", 5.0);
        gerenciadorAlunos.adicionarAluno("Ana", "123459", 6.8);

        // Exibindo todos os alunos no gerenciador
        System.out.println("Alunos no gerenciador:");
        System.out.println(gerenciadorAlunos.alunoSet);

        // Removendo um aluno com matrícula inválida e outro pelo número de matrícula
        //gerenciadorAlunos.removerAluno("000");
        gerenciadorAlunos.removerAluno("123457");
        System.out.println(gerenciadorAlunos.alunoSet);

        // Exibindo alunos ordenados por nome
        gerenciadorAlunos.exibirAlunosPorNome();

        // Exibindo alunos ordenados por nota
        gerenciadorAlunos.exibirAlunosPorNotaCrescente();
    }
}
