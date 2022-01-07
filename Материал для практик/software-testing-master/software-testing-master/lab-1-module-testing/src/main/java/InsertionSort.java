import java.util.List;

public class InsertionSort {

    public void sortList(List<Integer> list) {
        for (int i = 1; i < list.size(); i++) {
            int current = list.get(i);
            int j = i - 1;

            while(j >= 0 && current < list.get(j)) {
                list.set(j+1, list.get(j));
                j--;
            }

            list.set(j+1, current);
        }
    }

}
