public class Main {
    public static void main(String[] args) {
        int[] array = {100, 121, 1903, 5, 26, 78};

        System.out.println("Original array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted array:");
        printArray(array);
    }

    // This one merges two subarrays of array[]
    public static void merge(int array[], int leftIndex, int middleIndex, int rightIndex) {
        int sizeOfFirstSubarray = middleIndex - leftIndex + 1;
        int sizeOfSecondSubarray = rightIndex - middleIndex;

        int[] leftArray = new int[sizeOfFirstSubarray];
        int[] rightArray = new int[sizeOfSecondSubarray];

        // Copies data to temporary piles leftArray[] and rightArray[]
        for (int i = 0; i < sizeOfFirstSubarray; i++)
            leftArray[i] = array[leftIndex + i];
        for (int j = 0; j < sizeOfSecondSubarray; j++)
            rightArray[j] = array[middleIndex + 1 + j];

        // Merges the temporary piles back into array[leftIndex..rightIndex]
        int i = 0, j = 0;
        int k = leftIndex;

        while (i < sizeOfFirstSubarray && j < sizeOfSecondSubarray) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copies remaining elements of leftArray[] if any
        while (i < sizeOfFirstSubarray) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        // Copies remaining elements of rightArray[] if any
        while (j < sizeOfSecondSubarray) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
    }

    // This is the main function that sorts array - left pile and the right pile - using merge()
    public static void mergeSort(int array[], int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            // Find the middle point
            int middleIndex = (leftIndex + rightIndex) / 2;

            // Sort first and second halves
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);

            // Merge the sorted halves
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    // A utility function to print the array
    public static void printArray(int array[]) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
