package Set.OperacoesBasicas.FeitaPorMim;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoPalavrasUnicas {
    private Set<String> palavrasUnicasSet;

    public ConjuntoPalavrasUnicas() {
        this.palavrasUnicasSet = new HashSet<>();
    }

    public void adicionarPalavra(String palavra){
        palavrasUnicasSet.add(palavra);
    }

    public void removerPalavra (String palavra){
        if(!palavrasUnicasSet.isEmpty()){
            if(palavrasUnicasSet.contains(palavra)){
                palavrasUnicasSet.remove(palavra);
            }else {
                System.out.println("Esta palavra não está no conjunto de palavras");
            }
        }else {
            System.out.println("O conjunto está vazio");
        }

    }

    public void verificaPalavra(String palavra){
        if(!palavrasUnicasSet.isEmpty()){
            if(palavrasUnicasSet.contains(palavra)){
                System.out.println("A palavra: " + palavra + ", está presente no conjunto de palavras");
            }else{
                System.out.println("A palavra: " + palavra + ", NÃO está presente no conjunto de palavras");
            }
        }else{
            System.out.println("O conjunto está vazio");
        }
    }

    // outra forma:
//    public boolean verificarPalavra(String palavra) {
//        return palavrasUnicasSet.contains(palavra);
//    }

    public void exibirPalavras(){
        if(!palavrasUnicasSet.isEmpty()){
            System.out.println(this.palavrasUnicasSet);
        }else{
            System.out.println("O conjunto está vazio");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe ConjuntoPalavrasUnicas
        ConjuntoPalavrasUnicas conjuntoLinguagens = new ConjuntoPalavrasUnicas();

        // Adicionando linguagens únicas ao conjunto
        conjuntoLinguagens.adicionarPalavra("Java");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("JavaScript");
        conjuntoLinguagens.adicionarPalavra("Python");
        conjuntoLinguagens.adicionarPalavra("C++");
        conjuntoLinguagens.adicionarPalavra("Ruby");

        // Exibindo as linguagens únicas no conjunto
        conjuntoLinguagens.exibirPalavras();

        // Removendo uma linguagem do conjunto
        conjuntoLinguagens.removerPalavra("Python");
        conjuntoLinguagens.exibirPalavras();

        // Removendo uma linguagem inexistente
        conjuntoLinguagens.removerPalavra("Swift");

        // Verificando se uma linguagem está no conjunto
        conjuntoLinguagens.verificaPalavra("Java");
        conjuntoLinguagens.verificaPalavra("Python");

        // Exibindo as linguagens únicas atualizadas no conjunto
        conjuntoLinguagens.exibirPalavras();
    }
}
