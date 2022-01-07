import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Вычисление функции
//        System.out.println(new FunctionCalculator().calculateArctangent(2));

        // Сортировка методом вставки
        InsertionSort insertionSort = new InsertionSort();
        List<Integer> listA = new ArrayList<>(Arrays.asList(353, 104, 189, 950, 610, 196,  46, 469, 896, 349, 816, 526, 876, 151, 555, 984, 454, 162, 959, 712));

        System.out.println(listA);

        insertionSort.sortList(listA);

        System.out.println(listA);

    }

}
