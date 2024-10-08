import java.util.Comparator;

public class SelectionSort<T> {
    private long comparisonCount = 0;

    private int indiceMenorValor(T[] v, int posicao, Comparator<T> comparador) {
        int indiceMenor = posicao;
        for (int i = posicao + 1; i < v.length; i++) {
            comparisonCount++;
            if (comparador.compare(v[i], v[indiceMenor]) < 0) {
                indiceMenor = i;
            }
        }
        return indiceMenor;
    }

    void troca(T[] v, int i, int j) {
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public void sort(T[] v, Comparator<T> comparador) {
        comparisonCount = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = indiceMenorValor(v, i, comparador);
            troca(v, i, indiceMenor);
        }
    }

    public void sort(T[] v) {
        comparisonCount = 0;
        int n = v.length;
        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++;
                Comparable<T> elementoAtual = (Comparable<T>) v[j];
                if (elementoAtual.compareTo(v[indiceMenor]) < 0) {
                    indiceMenor = j;
                }
            }
            troca(v, i, indiceMenor);
        }
    }

    public long getComparisonCount() {
        return comparisonCount;
    }
}
