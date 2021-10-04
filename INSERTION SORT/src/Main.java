public class Main {
    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int a[] = {1, 5, 6, 7, 8, 9, 2, 3, 4, 10};
        insertionSort.InsertionSort1(a); //Ascending
        insertionSort.printArray(a);
        insertionSort.InsertionSort2(a); //Descending
        insertionSort.printArray(a);
    }
}
