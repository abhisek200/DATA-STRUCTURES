public class Main {
    public static void main(String[] args) {
        int arr[] = {10, 3, 44, 12, 11, 1, 12, 42, 22};
        QuickSort q = new QuickSort();
        q.quickSort(arr, 0, arr.length - 1);
        q.printArray(arr);
    }
}
