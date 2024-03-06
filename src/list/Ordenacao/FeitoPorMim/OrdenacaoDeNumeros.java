package list.Ordenacao.FeitoPorMim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrdenacaoDeNumeros {
    private List<Integer> listaNumeros;

    public OrdenacaoDeNumeros() {
        this.listaNumeros = new ArrayList<>();
    }

    public void adicionarNumero(int n){
        this.listaNumeros.add(n);
    }

    public List<Integer> ordenarAscendente(){
        List<Integer> numerosAscendentes = new ArrayList<>(this.listaNumeros);
        if(!listaNumeros.isEmpty()){
            Collections.sort(numerosAscendentes);
            return numerosAscendentes;
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public List<Integer> ordenarDecrescente(){
        List<Integer> numerosDecrescentes = new ArrayList<>(this.listaNumeros);
        if(!listaNumeros.isEmpty()){
            // temos dois metodos sort: um que retorna uma lista e outro q recebe list e retorna um comparator
            // o reverOrder só pode ser usado apos o collections e ele retorna um Comparator
            // por isso, para por em ordem decrescente, é preciso chamar o 2 metodo sort
            // para conseguir usar o Collections.reverseOrder.
            numerosDecrescentes.sort(Collections.reverseOrder());
            return numerosDecrescentes;
        }else{
            throw new RuntimeException("A lista está vazia!");
        }
    }

    public void exibirNumeros() {
        if (!listaNumeros.isEmpty()) {
            System.out.println(this.listaNumeros);
        } else {
            System.out.println("A lista está vazia!");
        }
    }

    public static void main(String[] args) {
        // Criando uma instância da classe OrdenacaoNumeros
        OrdenacaoDeNumeros numeros = new OrdenacaoDeNumeros();

        // Adicionando números à lista
        numeros.adicionarNumero(2);
        numeros.adicionarNumero(5);
        numeros.adicionarNumero(4);
        numeros.adicionarNumero(1);
        numeros.adicionarNumero(99);

        // Exibindo a lista de números adicionados
        numeros.exibirNumeros();

        // Ordenando e exibindo em ordem ascendente
        System.out.println(numeros.ordenarAscendente());

        // Exibindo a lista
        numeros.exibirNumeros();

        // Ordenando e exibindo em ordem descendente
        System.out.println(numeros.ordenarDecrescente());

        // Exibindo a lista
        numeros.exibirNumeros();
    }
}
