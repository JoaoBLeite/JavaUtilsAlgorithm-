import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main (String[] args) {
        // Should only be used on sorted collections
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        // Using our algorithm 
        System.out.println(
            "Index of value 5 is " + binartSearch(ints, 5));

        // Using our recursive algorithm 
        System.out.println(
            "Index of value 5 is " + binartSearchRecursive(ints, 5, 0, ints.length - 1));
 
        // Using Java provided method
        System.out.println(
            "Index of value 5 is " + Arrays.binarySearch(ints, 5));

        // Sorted Lists
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("a", "b", "c", "d", "e");

        // Using our algorithm
        System.out.println(
            "Index of value 5 is " + binartSearchList(integers, 5));
        System.out.println(
            "Index of value \"c\" is " + binartSearchList(strings, "c"));

    }

    private static int binartSearch (int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            int value = array[middlePosition];

            if (value == target) {
                return middlePosition;
            }

            if (value > target) {
                high = middlePosition - 1;
            } else { // value < target
                low = middlePosition + 1;
            }
        }
        // return -1; // or
        throw new RuntimeException("Fetched value is not contained in the collection!");
    }

    private static int binartSearchRecursive (int[] array, int target, int low, int high) {
        if (low <= high) {
            int middlePosition = (low + high) / 2;
            int value = array[middlePosition];

            if (value == target) {
                return middlePosition;
            }

            if (value > target) {
                return binartSearchRecursive(array, target, low, middlePosition - 1);
            } else { // value < target
                return binartSearchRecursive(array, target, middlePosition + 1, high);
            }
        }
        // return -1; // or
        throw new RuntimeException("Fetched value is not contained in the collection!");
    }

    private static <T extends Comparable<T>> int binartSearchList (List<T> list, T target) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int middlePosition = (low + high) / 2;
            T value = list.get(middlePosition);

            if (value.equals(target)) {
                return middlePosition;
            }

            if (value.compareTo(target) > 0) {
                high = middlePosition - 1;
            } else { // value.compareTo(target) < 0
                low = middlePosition + 1;
            }
        }
        // return -1; // or
        throw new RuntimeException("Fetched value is not contained in the collection!");
    }

}