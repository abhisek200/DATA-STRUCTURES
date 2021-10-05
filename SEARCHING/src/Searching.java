public class Searching {

    public static int linearSearch(int arr[], int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                System.out.println(value + " is found at index: " + i);
                return i;
            }
        }
        System.out.println(value + " is not found in the array.");
        return -1;
    }

    static int binarySearch(int arr[], int value) {
        int start = 0;
        int end = arr.length - 1;
        int middle = (start + end) / 2;
        System.out.println(start + " " + middle + " " + end); //for better explanation
        while (arr[middle] != value && start <= end) {
            if (value < arr[middle]) {
                end = middle - 1;
            } else if (value > arr[middle]) {
                start = middle + 1;
            }
            System.out.println(start + " " + middle + " " + end); //for better explanation
            middle = (start + end) / 2;
        }
        if (arr[middle] == value) {
            System.out.println(value + " found at index: " + middle);
            return middle;
        }
        else{
            System.out.println(value+" not found.");
            return -1;
        }
    }
}
