public class BinaryHeap {
    int arr[];
    int sizeOfTree;

    BinaryHeap(int size) {
        this.arr = new int[size + 1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created.");
    }

    public boolean isEmpty() {
        if (sizeOfTree == 0)
            return true;
        return false;
    }

    public Integer peek() {
        if (isEmpty()) {
            System.out.println("Binary Heap is empty.");
            return null;
        }
        return arr[1];
    }

    public int sizeOfBH() {
        return sizeOfTree;
    }

    void levelOrder() {
        for (int i = 1; i <= sizeOfTree; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("\n");
    }

    //Heapify for insert                                rearranges min to top, max to below
    void heapifyBottomToTop(int index, String heapType) {
        int parent = index / 2;
        if (index <= 1) {
            return; //value already at root
        }
        if (heapType == "Min") {
            if (arr[index] < arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        } else if (heapType == "Max") {
            if (arr[index] > arr[parent]) {
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    void insert(int value, String heapType) {
        arr[sizeOfTree + 1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, heapType); //bcs element added at size of tree
        System.out.println(value + " is inserted");
    }

    //heapify TopToBottom   extracting node
    void heapifyTopToBottom(int index, String heapType) {
        int left = index * 2;
        int right = index * 2 + 1;
        int swapChild = 0;
        if (sizeOfTree < left) {//no child
            return;
        }
        if (heapType == "Max") {//searches for max value among child
            if (sizeOfTree == left) {   //one child
                if (arr[index] < arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else {                   //two child
                if (arr[left] > arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] < arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        } else if (heapType == "Min") {//searches for minimum values among child
            if (sizeOfTree == left) {   //one child
                if (arr[index] > arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            } else {                   //two child
                if (arr[left] < arr[right]) {
                    swapChild = left;
                } else {
                    swapChild = right;
                }
                if (arr[index] > arr[swapChild]) {
                    int temp = arr[index];
                    arr[index] = arr[swapChild];
                    arr[swapChild] = temp;
                }
            }
        }
        heapifyTopToBottom(swapChild, heapType);
    }

    //extract head of heap
    int extractHeadOfHeap(String heapType) {
        if (isEmpty())
            return -1;
        else {
            int extractedValue = arr[1];
            arr[1] = arr[sizeOfTree];
            sizeOfTree--;
            heapifyTopToBottom(1, heapType);
            return extractedValue;
        }
    }

    //delete heap
    void deleteHeap() {
        arr = null;
        System.out.println("Binary heap is deleted");
    }
}


