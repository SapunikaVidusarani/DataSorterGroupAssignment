package datasorter;
public class BubbleSort {
    public static SortResult sort(int[] arr) {
        long steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                steps++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        return new SortResult(arr, end - start, steps);
    }
}