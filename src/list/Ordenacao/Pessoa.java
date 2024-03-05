package list.Ordenacao;

public class Pessoa implements Comparable<Pessoa> {

    // Comparabele é uma interface que altera a classe que vai ser manipulada(o tipo do objeto). Por isso vai na classe Pessoa.
    private String nome;

    // como idade é um interiro, pode-se usar o wrapper Integer,
    // um "wrapper" (ou invólucro) refere-se a uma classe que encapsula os tipos primitivos
    // para que possam ser usados como objetos.
    private int idade;
    private double altura;

    public Pessoa(String nome, int idade, double altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public int compareTo(Pessoa p) {
        return Integer.compare(idade, p.getIdade());
    }
    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", altura=" + altura +
                '}';
    }



}
