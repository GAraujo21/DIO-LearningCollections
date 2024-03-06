package Set.Ordenacao;

import java.util.Comparator;

public class ComparatorPorPreco implements Comparator<Produto> {
    @Override
    public int compare(Produto p1, Produto p2) {
        // colocamos Double pois vamos comparar os Preços do produto!
        return Double.compare(p1.getPreco(), p2.getPreco());
    }
}
