public class HeapSort {
    int a[] = null;
    HeapSort(int a[]){
        this.a=a;
    }
    void sort(){
        BinaryHeap bh=new BinaryHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            bh.insert(a[i],"Min");
        }
        for (int i = 0; i < a.length; i++) {
            a[i]=bh.extractHeadOfHeap("Min");
        }
    }

    //display elements
    void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "  ");
        }
    }
}
