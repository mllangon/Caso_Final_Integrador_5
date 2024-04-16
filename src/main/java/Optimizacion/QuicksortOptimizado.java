package Optimizacion;

public class QuicksortOptimizado {

    public void sort(int[] arr) {
        quicksort(arr, 0, arr.length - 1);
    }

    private void quicksort(int[] arr, int low, int high) {
        if (high <= low) return;

        // Optimización: uso de inserción directa para pequeños subarreglos
        if (high - low < 10) {
            insertionSort(arr, low, high);
            return;
        }

        int pivotIndex = partition(arr, low, high);
        quicksort(arr, low, pivotIndex - 1);
        quicksort(arr, pivotIndex + 1, high);
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = medianOfThree(arr, low, high);
        int i = low;
        int j = high + 1;
        while (true) {
            while (arr[++i] < pivot) if (i == high) break;
            while (pivot < arr[--j]) if (j == low) break;
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, low, j);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int medianOfThree(int[] arr, int low, int high) {
        int center = (low + high) / 2;
        if (arr[low] > arr[center])
            swap(arr, low, center);
        if (arr[low] > arr[high])
            swap(arr, low, high);
        if (arr[center] > arr[high])
            swap(arr, center, high);
        swap(arr, center, low);
        return arr[low];
    }

    private void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }
}
