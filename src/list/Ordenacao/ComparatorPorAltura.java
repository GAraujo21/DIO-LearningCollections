package list.Ordenacao;

import java.util.Comparator;

public class ComparatorPorAltura implements Comparator<Pessoa> {

    // msm ideia de usar o Wrapper do double -> Double;
    @Override
    public int compare(Pessoa p1, Pessoa p2) {
        return Double.compare(p1.getAltura(), p2.getAltura());
    }
}
