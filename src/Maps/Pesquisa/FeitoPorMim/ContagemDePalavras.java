package Maps.Pesquisa.FeitoPorMim;

import java.util.HashMap;
import java.util.Map;

public class ContagemDePalavras {
    Map<String, Integer> contagemPalavrasMap;

    public ContagemDePalavras() {
        this.contagemPalavrasMap = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, Integer contagem) {
        contagemPalavrasMap.put(palavra, contagem);
    }

    public void removerPalavra(String palavra) {
        if (!contagemPalavrasMap.isEmpty()) {
            if (contagemPalavrasMap.remove(palavra) != null) {
                // mapDicionario.remove(palavra);
                // não é preciso fazer isto, pois já na verificação, o metodo remove a palvra
                System.out.println("A palavra '" + palavra + "', foi retirada da contagem!");
            } else {
                System.out.println("A palavra não foi encontrada!");
            }
        } else {
            System.out.println("A contagem se enconta vazia!");
        }
    }

    public void exibirContagemPalavras() {
        System.out.println(contagemPalavrasMap);
    }

    public String encontrarPalavraMaisFrequente() {
        // o .key -> me retorna o conteúdo da key
        // o VALUES retorna uma coleção de values (lembrando, um MAP é coposto por <K, V>
        // K = key e V = .values
        // IMPORTANTE, esses métodos acima, não conseguem se interligarem, ficam "soltos" um do outro

        String palavraMaisFrequente = null;
        Integer maiorContagem = Integer.MIN_VALUE;
        for(Map.Entry<String, Integer> entry : contagemPalavrasMap.entrySet()){
            // não pode ser entry.getKey() > palavraMaisFrequente -> pois não tem como uma key ser maior que a outra. mais os valores podem!
            if(entry.getValue() > maiorContagem){
                maiorContagem = entry.getValue();
                palavraMaisFrequente = entry.getKey();
            }
        }
        return palavraMaisFrequente;
    }

    public static void main(String[] args) {
        ContagemDePalavras contagemLinguagens = new ContagemDePalavras();

        // Adiciona linguagens e suas contagens
        contagemLinguagens.adicionarPalavra("Java", 2);
        contagemLinguagens.adicionarPalavra("Python", 8);
        contagemLinguagens.adicionarPalavra("JavaScript", 1);
        contagemLinguagens.adicionarPalavra("C#", 6);

        // Exibe a contagem total de linguagens
        contagemLinguagens.exibirContagemPalavras();

        // Encontra e exibe a linguagem mais frequente
        String linguagemMaisFrequente = contagemLinguagens.encontrarPalavraMaisFrequente();
        System.out.println("A linguagem mais frequente é: " + linguagemMaisFrequente);
    }
}
