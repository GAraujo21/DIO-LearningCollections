package list.Ordenacao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoPessoas {
    // Comparabele é uma interface que altera a classe que vai ser manipulada(o tipo do objeto). Por isso vai na classe Pessoa.


    List<Pessoa> listaPessoa = new ArrayList<>();

    public OrdenacaoPessoas() {
        this.listaPessoa = new ArrayList<>();
    }

    public void adicionarPessoa(String nome, int idade, double altura){
        listaPessoa.add(new Pessoa(nome, idade, altura));
    }

    public List<Pessoa> ordernarPorIdade(){
        // a duplicação da lista é proposital, para poder fazer uma comparação.
        List<Pessoa> pessoasPorIdade = new ArrayList<>(listaPessoa);
        Collections.sort(pessoasPorIdade);
        return pessoasPorIdade;
    }

    public List<Pessoa> ordernarPorAltura(){
        List<Pessoa> pessoasPorAltura = new ArrayList<>(listaPessoa);
        // Dessa forma, estou dizendo ao Collections que é para ele comparar pelo Comparator
        // Comparator do qual, fizemos um método especifico;
        Collections.sort(pessoasPorAltura, new ComparatorPorAltura());
        // Existe outra fomra de se fazer, por isso a mensagem no sort.
        return pessoasPorAltura;
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoPessoas
        OrdenacaoPessoas ordenacaoPessoas = new OrdenacaoPessoas();

        // Adicionando pessoas à lista
        ordenacaoPessoas.adicionarPessoa("Alice", 20, 1.56);
        ordenacaoPessoas.adicionarPessoa("Bob", 30, 1.80);
        ordenacaoPessoas.adicionarPessoa("Charlie", 25, 1.70);
        ordenacaoPessoas.adicionarPessoa("David", 17, 1.56);

        // Exibindo a lista de pessoas adicionadas
        System.out.println(ordenacaoPessoas.listaPessoa);

        // Ordenando e exibindo por idade
        System.out.println(ordenacaoPessoas.ordernarPorIdade());

        // Ordenando e exibindo por altura
        System.out.println(ordenacaoPessoas.ordernarPorAltura());
    }
}
