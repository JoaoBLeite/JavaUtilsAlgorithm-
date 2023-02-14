package Sort;

public class Insertionsort extends SortUtils {
    
    private static final int LIMIT_VALUE = 100;
    private static final int ARRAY_SIZE = 10;

    public static void main (String[] args) {
        
        int[] array = getRandomArray(ARRAY_SIZE, LIMIT_VALUE);

        System.out.println("Before: ");
        printArray(array);
        
        insertionSort(array);

        System.out.println("\nAfter: ");
        printArray(array);

    }

    private static void insertionSort(int[] array) {
        // Note: i = 1 because the first value is already sorted with itself
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int j;
            for (j = i - 1; 
                j >= 0 && array[j] > currentValue; 
                j--) {
                    array[j + 1] = array[j];
            }
            array[j + 1] = currentValue;
        }
    }

}