import java.util.Comparator;
import java.util.Random;

public class Main {
    public static Integer[] geraArrayAleatorio(int size, int min, int max) {
        Random random = new Random();
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    public static void main(String[] args) {
        int tamanho = 10000, min = 1, max = 100;
        Integer[] vetor1 = geraArrayAleatorio(tamanho, min, max);
        Integer[] vetor2 = vetor1.clone();
        Integer[] vetor3 = vetor1.clone();
        Integer[] vetor4 = vetor1.clone();

        BubbleSort<Integer> bsortIntegers = new BubbleSort<>();
        SelectionSort<Integer> ssortIntegers = new SelectionSort<>();

        Comparator<Integer> comparatorInteiro = Integer::compareTo;

        long inicioBubble = System.currentTimeMillis();
        bsortIntegers.sort(vetor1, comparatorInteiro);
        long tfinalBubble = System.currentTimeMillis();
        long tempoBubble = tfinalBubble - inicioBubble;
        System.out.println("Tempo do BubbleSort (Comparator): " + tempoBubble + " ms");
        System.out.println("Comparações BubbleSort (Comparator): " + bsortIntegers.getComparisonCount());

        long inicioSelection = System.currentTimeMillis();
        ssortIntegers.sort(vetor2, comparatorInteiro);
        long tfinalSelection = System.currentTimeMillis();
        long tempoSelection = tfinalSelection - inicioSelection;
        System.out.println("Tempo do SelectionSort (Comparator): " + tempoSelection + " ms");
        System.out.println("Comparações SelectionSort (Comparator): " + ssortIntegers.getComparisonCount());

        // BubbleSort com Comparable
        inicioBubble = System.currentTimeMillis();
        bsortIntegers.sort(vetor3);
        tfinalBubble = System.currentTimeMillis();
        tempoBubble = tfinalBubble - inicioBubble;
        System.out.println("Tempo do BubbleSort (Comparable): " + tempoBubble + " ms");
        System.out.println("Comparações BubbleSort (Comparable): " + bsortIntegers.getComparisonCount());

        inicioSelection = System.currentTimeMillis();
        ssortIntegers.sort(vetor4);
        tfinalSelection = System.currentTimeMillis();
        tempoSelection = tfinalSelection - inicioSelection;
        System.out.println("Tempo do SelectionSort (Comparable): " + tempoSelection + " ms");
        System.out.println("Comparações SelectionSort (Comparable): " + ssortIntegers.getComparisonCount());
    }
}
