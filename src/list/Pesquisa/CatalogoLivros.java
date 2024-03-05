package list.Pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    List<Livros> listaLivros = new ArrayList<>();

    public CatalogoLivros() {
        this.listaLivros = new ArrayList<>();
    }

    public void adicionarLivro (String titulo, String autor, int anoPublicacao){
        listaLivros.add(new Livros(titulo, autor, anoPublicacao));
    }

    public List<Livros> pesquisarPorAutor(String autor){
      List<Livros> livrosPorAutor = new ArrayList<>();

      if (!listaLivros.isEmpty()) {
          for(Livros l : listaLivros){
              if(l.getAutor().equalsIgnoreCase(autor)){
                  livrosPorAutor.add(l);
              }
          }
      }
      return livrosPorAutor;
    }

    public List<Livros> pesquisarPorIntervaloDeAnos(int anoInicial, int anoFinal){
        List<Livros> livrosPorAno = new ArrayList<>();
        if(!listaLivros.isEmpty()){
            for(Livros l : listaLivros){
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal){
                    livrosPorAno.add(l);
                }
            }
        }
        return livrosPorAno;
    }

    public Livros pesquisaPorTitulo (String titulo){

        // Seria interessante tratar as exceções!
        Livros pesquisaPorTitulo = null;
        if (!listaLivros.isEmpty()){
            for(Livros l : listaLivros){
                if(l.getTitulo().equalsIgnoreCase(titulo)){
                    pesquisaPorTitulo = l;
                    break;
                }
            }
        }
        return pesquisaPorTitulo;
    }

    public static void main(String[] args) {
        // Criando uma instância do catálogo de livros
        CatalogoLivros catalogoLivros = new CatalogoLivros();

        // Adicionando livros ao catálogo
        catalogoLivros.adicionarLivro("Microsserviços Prontos Para a Produção", "Susan J. Fowler", 2017);
        catalogoLivros.adicionarLivro("Java Guia do Programador", "Peter Jandl Junior", 2021);
        catalogoLivros.adicionarLivro("Código Limpo", "Robert C. Martin", 2009);
        catalogoLivros.adicionarLivro("O Codificador Limpo", "Robert C. Martin", 2012);

        // Exibindo livros pelo mesmo autor
        System.out.println(catalogoLivros.pesquisarPorAutor("Robert C. Martin"));

        // Exibindo livros pelo mesmo autor (caso em que não há livros de um autor específico)
        System.out.println(catalogoLivros.pesquisarPorAutor("Autor Inexistente"));

        // Exibindo livros dentro de um intervalo de anos
        System.out.println(catalogoLivros.pesquisarPorIntervaloDeAnos(2010, 2022));

        // Exibindo livros dentro de um intervalo de anos (caso em que não há livros no intervalo)
        System.out.println(catalogoLivros.pesquisarPorIntervaloDeAnos(2025, 2030));

        // Exibindo livros por título
        System.out.println(catalogoLivros.pesquisaPorTitulo("Java Guia do Programador"));

        // Exibindo livros por título (caso em que não há livros com o título especificado)
        System.out.println(catalogoLivros.pesquisaPorTitulo("Título Inexistente"));
    }
}
