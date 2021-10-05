public class Main {
    public static void main(String[] args) {
        int[] arr1 ={1,2,4,5,12,22,23,21,10};
        int[] arr2 ={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Searching.linearSearch(arr1,10);
        Searching.binarySearch(arr2,12); //must be a sorted array.
    }
}
