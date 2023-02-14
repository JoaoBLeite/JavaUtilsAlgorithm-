package Sort;

import java.util.Random;

/**
 * Sort Utils Class
 * Class containing some methods to avoid repetition
 */
public class SortUtils {

    private static final Random RANDOM = new Random();

    /**
     * Method that returns an array of random numbers
     * @param size - size of the array
     * @param limitValue - limit value for those values
     * @return a random array
     */
    protected static int[] getRandomArray(int size, int limitValue) {
        int[] array = new int[size]; 
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(limitValue);
        }
        return array;
    }

    /**
     * Method that returns a random number
     * @param limitValue - limit value
     * @return random number
     */
    protected static int getRandomNumber(int limitValue) {
        return RANDOM.nextInt(limitValue);
    }

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
