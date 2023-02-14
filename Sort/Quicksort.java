import java.util.Random;

/*
 * Quicksort algorithm
 * 
 * Quick Sort is an algorithm of the same complexity class as 
 * Merge Sort and Heap Sort, however it is the fastest of them. 
 * However, it is important to know that, in its worst case, 
 * Quick Sort is O(n2), while Merge Sort and Heap Sort guarantee 
 * n∗logn for all cases.
 */
public class Quicksort {

    private static final Random RANDOM = new Random();
    private static final int LIMIT_VALUE = 100;
    private static final int ARRAY_SIZE = 10;

    public static void main(String[] args) {
        
        int[] array = new int[ARRAY_SIZE];
        for (int i = 0; i < array.length; i++) {
            array[i] = RANDOM.nextInt(LIMIT_VALUE);
        }

        System.out.println("Before: ");
        printArray(array);

        quicksort(array);

        System.out.println("\nAfter: ");
        printArray(array);

    }

    private static void quicksort(int[] array) {
        quicksort(array, 0, array.length - 1);
    }

    private static void quicksort(int[] array, int low, int high) {

        // Unit array
        if (low >= high) {
            return;
        }

        // Choosing a pivot
        int pivotIndex = RANDOM.nextInt(high - low) + low;
        int pivot = array[pivotIndex];
        swap(array, pivotIndex, high);

        int leftPointer = low;
        int rightPointer = high;

        while (leftPointer < rightPointer) {

            while (array[leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }

            while (array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            swap(array, leftPointer, rightPointer);
        }

        swap(array, leftPointer, high);

        quicksort(array, low, leftPointer - 1);
        quicksort(array, rightPointer + 1, high);
    }

    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] array) {
        System.out.print("[");
        for (int i : array)
            System.out.print(" " + i + " ");
        System.out.println("]");
    }
}