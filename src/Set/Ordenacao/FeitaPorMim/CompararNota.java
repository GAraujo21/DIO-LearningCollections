package Set.Ordenacao.FeitaPorMim;

import java.util.Comparator;

public class CompararNota implements Comparator<Aluno> {
    @Override
    public int compare(Aluno nota1, Aluno nota2) {
        return Double.compare(nota1.getNota(), nota2.getNota());
    }
}
