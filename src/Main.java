public class Main {
    static void swap(int[] arr, int index_i, int index_j) {
        int temp = arr[index_i];
        arr[index_i] = arr[index_j];
        arr[index_j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int correct_pivot_position = low - 1;

        for (int current_index = low; current_index < high; current_index++) {
            if (arr[current_index] < pivot) {
                correct_pivot_position++;
                swap(arr, correct_pivot_position, current_index);
            }
        }

        swap(arr, correct_pivot_position + 1, high);

        return correct_pivot_position + 1;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partition_index = partition(arr, low, high);

            quickSort(arr, low, partition_index - 1);
            quickSort(arr, partition_index + 1, high);
        }
    }

    static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[100];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100);
        }

        printArray(arr);
        System.out.println("\n");
        quickSort(arr, 0, (arr.length - 1));
        printArray(arr);
    }
}