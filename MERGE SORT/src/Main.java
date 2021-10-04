public class Main {
    public static void main(String[] args) {
        int arr[] = {12,10,14,11,1,21,13,2};
        MergeSort m=new MergeSort();
        m.mergeSort(arr,0,arr.length-1);
        m.printArray(arr);
    }
}
