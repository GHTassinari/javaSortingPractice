import java.util.Comparator;

public class BubbleSort<T> {
    private long comparisonCount = 0;

    void troca(T[] v, int i, int j) {
        T temp = v[i];
        v[i] = v[j];
        v[j] = temp;
    }

    public T[] sort(T[] v, Comparator<T> comparador) {
        comparisonCount = 0;
        int n = v.length;
        for (int fase = 1; fase < n; fase++) {
            for (int j = 0; j < n - fase; j++) {
                comparisonCount++;
                if (comparador.compare(v[j], v[j + 1]) > 0) {
                    troca(v, j, j + 1);
                }
            }
        }
        return v;
    }

    public T[] sort(T[] v) {
        comparisonCount = 0;
        int n = v.length;
        for (int fase = 1; fase < n; fase++) {
            for (int j = 0; j < n - fase; j++) {
                comparisonCount++;
                Comparable<T> elementoAtual = (Comparable<T>) v[j];
                if (elementoAtual.compareTo(v[j + 1]) > 0) {
                    troca(v, j, j + 1);
                }
            }
        }
        return v;
    }

    public long getComparisonCount() {
        return comparisonCount;
    }
}
