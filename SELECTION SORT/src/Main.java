public class Main {
    public static void main(String[] args) {

        SelectionSort SelectionSort = new SelectionSort();
        int array[] = {1, 5, 4, 6, 7, 8, 9, 2, 10, 3};
        SelectionSort.SelectionSort1(array);//Ascending
        SelectionSort.printArray(array);
        SelectionSort.SelectionSort2(array);//Descending
        SelectionSort.printArray(array);
    }
}
