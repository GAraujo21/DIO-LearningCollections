package Maps.Ordenacao.FeitoPorMim;

public class Livro {
    // Precisamos implementar o Comparator, mas, como vamos utilizálo mais de uma vez, tems mais vantagens criar outras classes para este propósito!
    // Dessa forma temos uma maior reusabilidade, um código mais organizado e tira uma complexidade da classe "principal", a Livro.


    private String titulo;
    private String autor;
    private double preco;

    public Livro(String titulo, String autor, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", preco=" + preco +
                '}';
    }
}
