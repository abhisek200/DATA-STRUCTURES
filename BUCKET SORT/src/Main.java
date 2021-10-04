public class Main {
    public static void main(String[] args) {
        int a[]={8,9,6,3,2,4,5,1,11,10,15};
        BucketSort bucketSort=new BucketSort(a);
        bucketSort.printArray();
        bucketSort.bucketSort();
        bucketSort.printArray();
    }
}
