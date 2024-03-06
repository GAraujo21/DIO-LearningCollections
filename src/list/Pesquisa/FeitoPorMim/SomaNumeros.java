package list.Pesquisa.FeitoPorMim;

import java.util.ArrayList;
import java.util.List;

public class SomaNumeros {
    private List<Integer> listaNumeros;

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
        if(!listaNumeros.isEmpty()){
            System.out.println(this.listaNumeros);
        }else{
            System.out.println("A lista está vazia");
        }
    }


    public static void main(String[] args) {
        // Criando uma instância da classe SomaNumeros
        SomaNumeros somaNumeros = new SomaNumeros();

        // Adicionando números à lista
        somaNumeros.adicionarNumero(5);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(0);
        somaNumeros.adicionarNumero(-2);
        somaNumeros.adicionarNumero(10);

        // Exibindo a lista de números adicionados
        System.out.println("Números adicionados:");
        somaNumeros.exibirNumeros();

        // Calculando e exibindo a soma dos números na lista
        System.out.println("Soma dos números = " + somaNumeros.calcularSoma());

        // Encontrando e exibindo o maior número na lista
        System.out.println("Maior número = " + somaNumeros.encontrarMaiorNumero());

        // Encontrando e exibindo o menor número na lista
        System.out.println("Menor número = " + somaNumeros.encontrarMenorNumero());
    }
}
