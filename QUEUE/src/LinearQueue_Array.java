public class LinearQueue_Array {
    int arr[];
    int beginningOfQueue; //first element
    int topOfQueue;       //top of the queue

    LinearQueue_Array(int size) {   //constructor
        this.arr = new int[size];
        this.topOfQueue = -1;
        this.beginningOfQueue = -1;
        System.out.println("New Queue Array of size " + size + " is created.");
    }

    public boolean isFull() {
        if (topOfQueue == arr.length - 1)
            return true;
        else
            return false;
    }

    public boolean isEmpty() {
        if (beginningOfQueue == -1 || beginningOfQueue == arr.length)
            return true;
        else
            return false;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is Full");
        } else if (isEmpty()) {
            beginningOfQueue = 0;
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println(value + " is successfully inserted");
        } else {
            topOfQueue++;
            arr[topOfQueue] = value;
            System.out.println(value + " is successfully inserted");
        }
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty;");
            return -1;
        } else {
            int res = arr[beginningOfQueue];
            beginningOfQueue++; //pointer changed.
            if (beginningOfQueue > topOfQueue) {
                beginningOfQueue = -1;
                topOfQueue = -1; //both are empty
            }
            return res;
        }
    }

    //peek
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty;");
            return -1;
        } else {
            int res = arr[beginningOfQueue];
            topOfQueue = -1; //both are empty
            return res;
        }
    }
    public void deleteQueue(){
        arr=null;
        System.out.println("Queue is successfully deleted.");
    }
}
