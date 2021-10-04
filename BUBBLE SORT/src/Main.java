public class Main {
    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int arr[] = {1, 4, 5, 6, 2, 8, 9, 3};
        bubbleSort.bubbleSort1(arr);     //Ascending
        bubbleSort.printArray(arr);
        bubbleSort.bubbleSort2(arr);    //Descending
        bubbleSort.printArray(arr);
    }
}
