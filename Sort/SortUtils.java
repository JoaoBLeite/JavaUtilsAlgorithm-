package Sort;

/**
 * Sort Utils Class
 * Class containing some methods to avoid repetition
 */
public class SortUtils {

    /**
     * Method to swap position values in an array
     * @param array
     * @param index1 - index of first value
     * @param index2 - index of second value
     */
    protected static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    /**
     * Method to display an array in terminal output
     * @param array
     */
    protected static void printArray(int[] array) {
        System.out.print("[");
        for (int i : array)
            System.out.print(" " + i + " ");
        System.out.println("]");
    }
}
