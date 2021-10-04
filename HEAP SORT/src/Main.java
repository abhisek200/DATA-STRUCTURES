public class Main {
    public static void main(String[] args) {
        int a[]={1,4,6,7,2,9,11,12};
        HeapSort hs=new HeapSort(a);
        hs.sort();
        hs.printArray(a);
    }
}
