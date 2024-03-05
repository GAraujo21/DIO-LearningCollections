package list.Pesquisa.FeitoPorMim;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros = new ArrayList<>();

    public SomaNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int n){
        listaNumeros.add(n);
    }

    public int calcularSoma(){
        int somaNumeros = 0;
        if(!listaNumeros.isEmpty()){
            for(Integer i : listaNumeros){
                somaNumeros += i;
            }
        }
        return somaNumeros;
    }

    public int encontrarMaiorNumero(){
        // para iterar uma lista, é mais recomendado utilizar o for each, fica mais limpo.
        int maiorNumero = Integer.MIN_VALUE;
        if(!listaNumeros.isEmpty()){
            for(Integer n : listaNumeros){
                if(n >= maiorNumero){
                    maiorNumero = n;
                }
            }
        }
        return maiorNumero;
    }

//    public int encontrarMaiorNumero(){
//        int maiorNumero = 0;
//        if (!listaNumeros.isEmpty()){
//            for(int i = 0; i <= listaNumeros.size(); i++){
//                int numeroAtual = listaNumeros.get(i);
//
//                // a OUTRA maneira que pensei, aqui no if seria:
//                // if (numeroAtual >= listaNumeros[i]). PORÉM, no java as List ñ suporta
//                // indexação direta!
//                if(numeroAtual > maiorNumero){
//                    maiorNumero = numeroAtual;
//                }
//            }
//        }
//        return maiorNumero;
//    }

    public int encontrarMenorNumero(){
        int menorNumero = Integer.MAX_VALUE;
        if (!listaNumeros.isEmpty()){
            for (Integer n : listaNumeros){
                if(n < menorNumero){
                    menorNumero = n;
                }
            }
        }
        return menorNumero;
    }

    public void exibirNumeros(){
        if(listaNumeros.isEmpty()){
            System.out.println(this.listaNumeros);
        }else{
            System.out.println("A lista está vazia");
        }
    }
}
