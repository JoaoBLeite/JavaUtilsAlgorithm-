import java.util.Arrays;
import java.util.List;

public class SequentialSearch {

    public static void main(String[] args) {
        // Array
        int[] ints = {3, 7, 4, 1, 2, 9, 6, 5, 8, 10};

        // Using our algorithm 
        System.out.println(
            "Index of value 5 is " + sequentialSearch(ints, 5));

        // Lists
        List<Integer> integers = Arrays.asList(3, 7, 4, 1, 2, 9, 6, 5, 8, 10);
        List<String> strings = Arrays.asList("b", "a", "d", "c", "e");

        // Using our algorithm
        System.out.println(
            "Index of value 5 is " + sequentialSearchList(integers, 5));
        System.out.println(
            "Index of value \"c\" is " + sequentialSearchList(strings, "c"));
    }

    public static int sequentialSearch (int[] array, int target) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == target) {
                return index;
            }
        }
        // return -1; // or
        throw new RuntimeException("Fetched value is not contained in the collection!");
    }

    private static <T extends Comparable<T>> int sequentialSearchList (List<T> list, T target) {
        for (int index = 0; index < list.size(); index++) {
            if (list.get(index).equals(target)) {
                return index;
            }
        }
        // return -1; // or
        throw new RuntimeException("Fetched value is not contained in the collection!");
    }

}