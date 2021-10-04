import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BucketSort {
    int arr[];

    public BucketSort(int arr[]) {
        this.arr = arr;
    }

    void printArray() {     //Display elements
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //helper
    //Print Buckets
    void printBucket(ArrayList<Integer>[] bucket) {
        for (int i = 0; i < bucket.length; i++) {
            System.out.println("\nBucket #" + i + ":");
            for (int j = 0; j < bucket[i].size(); j++) {
                System.out.println(bucket[i].get(j) + " ");
            }
        }
    }

    //BucketSorting
    void bucketSort() {
        int numberOfBuckets = (int) Math.ceil(Math.sqrt(arr.length));
        int maxValue = Integer.MIN_VALUE; //maxValue required for bucketNumber
        for (int value : arr) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        ArrayList<Integer>[] buckets = new ArrayList[numberOfBuckets];
        for (int i = 0; i < buckets.length; i++) { //creating no of buckets required.
            buckets[i] = new ArrayList<Integer>();
        }
        for (int value : arr) {
            int bucketNumber = (int) Math.ceil((float) value * numberOfBuckets / (float) maxValue);
            buckets[bucketNumber - 1].add(value); //arraylist stored in index position
        }

        System.out.println("\n\nPrinting Buckets before Sorting...");
        printBucket(buckets);

        for (ArrayList<Integer> bucket : buckets) { //sorting inside buckets
            Collections.sort(bucket);
        }

        System.out.println("\n\nPrinting Buckets after Sorting...");
        printBucket(buckets);

        int index = 0;
        for (ArrayList<Integer> bucket : buckets) { //storing bucket values to array.
            for (int value : bucket) {
                arr[index] = value;
                index++;
            }
        }
    }

}
