package Maps.Ordenacao.FeitoPorMim;

import java.util.*;

public class LivrariaOnline {
    private Map<String, Livro> livrariaMap;


    // DESTAQUE: smp lembrar quando trabalhar com MAP, que está trabalhando com DOIS valores, uma chave e um value!
    // isso implica que, se usarmos o livrariaMap "sozinho", estaremos trabalhando apenas com a CHAVE!

    public LivrariaOnline() {
        this.livrariaMap = new HashMap<>();
    }

    // não pode ser (String link, String titulo, String autor, double preco)
    public void adicionarLivro(String link, Livro livro) {
        livrariaMap.put(link, livro);
    }

    public void removerLivroPorTitulo(String titulo) {
        if (!livrariaMap.isEmpty()) {
            String keyParaRemover = null;
            String tituloParaRemover = null;

            // por ser MAP e trabalhar com DOIS valores, é preciso, no for, passar o livrariaMap.entrySet()
            // o entrySet() -> tem acesso tanto à chave quanto ao valor de cada entrada.

            for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
                if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
                    keyParaRemover = entry.getKey();
                    break;
                }
            }
            livrariaMap.remove(keyParaRemover);

        }
    }

    // Abordagem feita por Camila, autora da postagem.
    // diferencial entre as duas é:
    // a que eu fiz, entende que os livros não tem titulos repetidos, ou seja que os titulos são unicos
    // camila, faz uma lista com todas as chaves que devem ser removidas, pois é possivel que existam diferentes livros com titulos iguais


//    public void removerLivro(String titulo) {
//        List<String> chavesRemover = new ArrayList<>();
//        for (Map.Entry<String, Livro> entry : livros.entrySet()) {
//            if (entry.getValue().getTitulo().equalsIgnoreCase(titulo)) {
//                chavesRemover.add(entry.getKey());
//            }
//        }
//        for (String chave : chavesRemover) {
//            livros.remove(chave);
//        }
//    }


    // Uma outra maneira de fazer este método era implementar na classe Livro o Comparable
    // dessa forma, os Livros já serão ordenanos, naturalmente pelo preço.
    public Map<String, Livro> exibirLivrosOrdenadosPorPreco() {

        // o TreeMap ordena os elementos durante a inserção, então precisa fornecer a ordem desejada no momento da criação do map.
        // A razão para seguir esse passo a passo, é ordernar os elementos do map em base de um critério ESPECIFICO,
        // no caso os PREÇOS, que não é a ordem natural dos valores do map.

        if (!livrariaMap.isEmpty()) {
            // Aqui, transforma as entradas do map 'livrariaMap' em uma lista, para ordená-la da forma especifica mais a frente
            List<Map.Entry<String, Livro>> listaLivrosParaOrdenar = new ArrayList<>(livrariaMap.entrySet());

            // Usamos o sort, metodo para ordernar uma lista.
            // Mas há duas opções: ou receber uma lista como parametro, ou receber a lista e um comparator,
            // para fornecer a maneira ESPECIFICA de ordenação, que é este caso.

            // Aqui temos uma LISTA ordenado por preço, mas estamos trabalahdno com MAP.
            Collections.sort(listaLivrosParaOrdenar, new ComparatorPorPreco());
            // também pode ficar desta forma:
            // livrosParaOrdenarPorPreco.sort(new ComparatorPorPreco());

            // Nesse momento, precisa-se criar outra variável, no formato map, iniciando um LinkdeHashMap.
            // LinkdeHashMap -> mantém a ordem de inserção dos elementos. Nesse contexto parece ser para preservar a ordem dos livros de acordo com a ordem em que foram ordenados por preço.
            Map<String, Livro> mapLivrosOrdenados = new LinkedHashMap<>();

            // Aqui vamos utilizar um for para percorrer a listaLivros e atualizar o mapLivros com os valores.
            for (Map.Entry<String, Livro> entry : listaLivrosParaOrdenar) {
                mapLivrosOrdenados.put(entry.getKey(), entry.getValue());
            }

            return mapLivrosOrdenados;
        } else {
            throw new RuntimeException("A livraria está vazia!");
        }

    }

    // no exercicio não pede, mas Camila faz, serve para treinar mais.
    //public Map<String, Livro> exibirLivrosOrdenadosPorAutor() {}

    public Map<String, Livro> pesquisarLivrosPorAutor(String autor) {
        Map<String, Livro> livrosPorAutor = new LinkedHashMap<>();

        for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
            if (entry.getValue().getAutor().equalsIgnoreCase(autor)) {
                livrosPorAutor.put(entry.getKey(), entry.getValue());
            }
        }
        return livrosPorAutor;
    }

    // O exercicio pede O livro mais caro, mas possa ser que haja mais de um livro com o mesmo valor, "mais caro"

//    public Map<String, Livro> obterLivroMaisCaro(){
//        double precoMaisCaro = Double.MIN_VALUE;
//        Map<String, Livro> livrosMaisCaros = new LinkedHashMap<>();
//
//        if(!livrariaMap.isEmpty()){
//            for(Livro livro : livrariaMap.values()){
//                if(livro.getPreco() > precoMaisCaro){
//                    precoMaisCaro = livro.getPreco();
//                }
//            }
//            for(Map.Entry<String, Livro> entry : livrariaMap.entrySet()){
//                if(entry.getValue().getPreco() == precoMaisCaro){
//                    livrosMaisCaros.put(entry.getKey(), entry.getValue());
//                }
//            }
//            return livrosMaisCaros;
//        }else{
//            throw new RuntimeException("A livraria está vazia!");
//        }
//
//    }

    // Mesmo método q acima, mas com retornos de tipos diferentes
    public List<Livro> obterLivroMaisCaro() {
        double precoMaisCaro = Double.MIN_VALUE;
        List<Livro> livrosMaisCaros = new ArrayList<>();

        if (!livrariaMap.isEmpty()) {
            for (Livro livro : livrariaMap.values()) {
                if (livro.getPreco() > precoMaisCaro) {
                    precoMaisCaro = livro.getPreco();
                }
            }
            for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
                if (entry.getValue().getPreco() == precoMaisCaro) {
                    livrosMaisCaros.add(entry.getValue());
                }
            }
            return livrosMaisCaros;
        } else {
            throw new RuntimeException("A livraria está vazia!");
        }
    }

    public List<Livro> exibirLivroMaisBarato() {
        double precoMaisBarato = Double.MAX_VALUE;
        List<Livro> livrosMaisBarato = new ArrayList<>();

        if (!livrariaMap.isEmpty()) {
            for (Livro livro : livrariaMap.values()) {
                if (livro.getPreco() < precoMaisBarato) {
                    precoMaisBarato = livro.getPreco();
                }
            }
            for (Map.Entry<String, Livro> entry : livrariaMap.entrySet()) {
                if (entry.getValue().getPreco() == precoMaisBarato) {
                    livrosMaisBarato.add(entry.getValue());
                }
            }
            return livrosMaisBarato;
        } else {
            throw new RuntimeException("A livraria está vazia!");
        }
    }

    public static void main(String[] args) {
        LivrariaOnline livrariaOnline = new LivrariaOnline();
        // Adiciona os livros à livraria online
        livrariaOnline.adicionarLivro("https://amzn.to/3EclT8Z", new Livro("1984", "George Orwell", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/47Umiun", new Livro("A Revolução dos Bichos", "George Orwell", 7.05d));
        livrariaOnline.adicionarLivro("https://amzn.to/3L1FFI6", new Livro("Caixa de Pássaros - Bird Box: Não Abra os Olhos", "Josh Malerman", 19.99d));
        livrariaOnline.adicionarLivro("https://amzn.to/3OYb9jk", new Livro("Malorie", "Josh Malerman", 5d));
        livrariaOnline.adicionarLivro("https://amzn.to/45HQE1L", new Livro("E Não Sobrou Nenhum", "Agatha Christie", 50d));
        livrariaOnline.adicionarLivro("https://amzn.to/45u86q4", new Livro("Assassinato no Expresso do Oriente", "Agatha Christie", 5d));

        // Exibe todos os livros ordenados por preço
        System.out.println("Livros ordenados por preço: \n" + livrariaOnline.exibirLivrosOrdenadosPorPreco());

        //Exibe todos os livros ordenados por autor
        //System.out.println("Livros ordenados por autor: \n" + livrariaOnline.exibirLivrosOrdenadosPorAutor());

        // Pesquisa livros por autor
        String autorPesquisa = "Josh Malerman";
        livrariaOnline.pesquisarLivrosPorAutor(autorPesquisa);

        // Obtém e exibe o livro mais caro
        System.out.println("Livro mais caro: " + livrariaOnline.obterLivroMaisCaro());

        // Obtém e exibe o livro mais barato
        System.out.println("Livro mais barato: " + livrariaOnline.exibirLivroMaisBarato());

        // Remover um livro pelo título
        livrariaOnline.removerLivroPorTitulo("1984");
        System.out.println(livrariaOnline.livrariaMap);
    }
}

