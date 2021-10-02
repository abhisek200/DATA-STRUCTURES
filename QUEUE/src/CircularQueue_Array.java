public class CircularQueue_Array {
    int arr[];
    int size;
    int beginningOfQueue;
    int topOfQueue;

    CircularQueue_Array(int size) {
        this.arr = new int[size];
        this.size = size;
        this.beginningOfQueue = -1;
        this.topOfQueue = -1;
    }

    boolean isEmpty() {
        if (topOfQueue == -1)
            return true;
        else
            return false;
    }

    boolean isFull() {
        if (topOfQueue + 1 == beginningOfQueue)
            return true;
        else if (beginningOfQueue == 0 && topOfQueue == size - 1)
            return true;
        else
            return false;
    }

    void enQueue(int value) {
        if (isFull())
            System.out.println("CQ is full.");
        else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println(value + " is inserted.");
        } else {
            if (topOfQueue + 1 == size)
                topOfQueue = 0;
            else
                topOfQueue++;
        }
        arr[topOfQueue] = value;
        System.out.println("Successfully inserted " + value + " in the queue");
    }

    int deQueue() {
        if (isEmpty()) {
            System.out.println("CQ is empty.");
            return -1;
        } else {
            int res = arr[beginningOfQueue];
            arr[beginningOfQueue] = Integer.MIN_VALUE; //or put 0
            if (beginningOfQueue == topOfQueue)
                beginningOfQueue = topOfQueue = -1;
            else if (beginningOfQueue + 1 == size)
                beginningOfQueue = 0;
            else
                beginningOfQueue++;
            return res;
        }
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("CQ is empty.");
            return -1;
        } else {
            return arr[beginningOfQueue];
        }
    }
    void deleteQueue(){
        arr=null;
        System.out.println("CQ is dissolved.");
    }
}
