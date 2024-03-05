package list.OperacoesBasicas.FeitasPorMim;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {
    private List<Item> listaItem;

    public CarrinhoDeCompras() {
        // a ideia é que sempre que for instanciar um objeto no carrinho de compras, esse objeto já seja instanciado com um atributo E um ArrayList vazio.
        this.listaItem = new ArrayList<>();
    }

    public void adicionarItens(String nome, double preco, int quantidade){
        //necessario instanciar um objeto da classe item, para usar o seu construtor e depois colocalo dentro da lista do carrinho de compras.
        Item item = new Item(nome, preco, quantidade);
        listaItem.add(item);
    }

    public void removeItemPorNome(String nome){

        //foi feita esse laço de repetição para, caso haja mais de um objeto com o mesmo nome
        // todos eles sejam retirados do carrinho de compras;
        List<Item> itensParaRemover = new ArrayList<>();

        if(listaItem.isEmpty()){
            System.out.println("A lista está vázia");
        }else{
            for(Item i : listaItem){
                if(i.getNome().equalsIgnoreCase(nome)){
                    itensParaRemover.add(i);
                }
            }
        }
        listaItem.removeAll(itensParaRemover);
    }

    public double calcularValorTotal(){
        //a lógica é criar uma variavel para a soma total dos preços
        // verificar se a listaItem está vazia
        // percorrer toda a lista vendo os preços dos produtos e multiplicando pela quantidade
        // mas para isso é necessario coloca-los em uma outra variavel
        // por fim, somar esta variavel ao preço total e retornar essa variavel.
        double valorTotal = 0d;
        if(!listaItem.isEmpty()){
            for(Item i : listaItem){
                double valorX = i.getPreco() * i.getQuantidade();
                valorTotal += valorX;
            }
            return valorTotal;
        }else{
            throw new RuntimeException("A lista está vázia");
        }
    }

    public void exibirItens(){
        if(!listaItem.isEmpty()){
            System.out.println(this.listaItem);
        }else{
            System.out.println("A lista está vazia!");
        }
    }

//    @Override
//    public String toString() {
//        return "CarrinhoDeCompras{" +
//                "itens=" + listaItem +
//                '}';
//    }

    public static void main(String[] args) {
        // Criando uma instância do carrinho de compras
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();

        // Adicionando itens ao carrinho
        carrinhoDeCompras.adicionarItens("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItens("Lápis", 2d, 3);
        carrinhoDeCompras.adicionarItens("Caderno", 35d, 1);
        carrinhoDeCompras.adicionarItens("Borracha", 2d, 2);

        // Exibindo os itens no carrinho
        carrinhoDeCompras.exibirItens();

        // Removendo um item do carrinho
        carrinhoDeCompras.removeItemPorNome("Lápis");

        // Exibindo os itens atualizados no carrinho
        carrinhoDeCompras.exibirItens();

        // Calculando e exibindo o valor total da compra
        System.out.println("O valor total da compra é = " + carrinhoDeCompras.calcularValorTotal());
    }

}
