package Maps.OperacoesBasicas.FeitoPorMim;

import java.util.HashMap;
import java.util.Map;

public class Dicionario {
    private Map<String, String> mapDicionario;

    public Dicionario() {
        this.mapDicionario = new HashMap<>();
    }

    public void adicionarPalavra(String palavra, String definicao) {
        mapDicionario.put(palavra, definicao);
    }

    public void removerPalavra(String palavra) {
        if (!mapDicionario.isEmpty()) {
            if (mapDicionario.remove(palavra) != null) {
                // mapDicionario.remove(palavra);
                // não é preciso fazer isto, pois já na verificação, o metodo remove a palvra
                System.out.println("A palavra '" + "', foi retirada do dicionário!");
            } else {
                System.out.println("A palavra não foi encontrada!");
            }
        } else {
            System.out.println("O dicionário se enconta vazio!");
        }
    }

    public void exibirPalavras() {
        if (!mapDicionario.isEmpty()) {
            System.out.println(mapDicionario);
        } else {
            System.out.println("O dicionário encontra-se vazio.");
        }
    }

    // a versão de baixo é mais bonita.
//    public String pesquisarPorPalavra(String palavra) {
//        String palavraPesquisada = null;
//        if (!mapDicionario.isEmpty()) {
//            if (mapDicionario.get(palavra) != null) {
//                return mapDicionario.get(palavra);
//            }
//        }
//        return "Palavra não encontrada no dicionário";
//    }

    public String pesquisarPorPalavra(String palavra) {
        String palavraPesquisada = mapDicionario.get(palavra);
        if (!mapDicionario.isEmpty()) {
            if (palavraPesquisada != null) {
                return palavraPesquisada;
            }
        }
        return "Palavra não encontrada no dicionário";
    }
    
}
