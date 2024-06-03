import java.util.*;

public class temp {

    public static void main(String[] args) {
        /* Integer list with 10 elements */
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        // array with 10
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        Integer myInteger = list.stream().min(Integer::compare).orElseGet(null);
        int myInt = Arrays.stream(arr).min().getAsInt();
    }
}
