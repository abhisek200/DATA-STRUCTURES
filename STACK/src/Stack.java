public class Stack {
    int[] arr;
    int topOfStack; //index of top element

    public Stack(int size) {
        this.arr = new int[size];
        this.topOfStack = -1;
        System.out.println("Stack is created of size: " + size);
    }

    public boolean isEmpty() {
        if (topOfStack == -1)
            return true;
        else
            return false;
    }

    public boolean isFull() {
        if (topOfStack == arr.length - 1)
            return true;
        else
            return false;
    }

    //Push method
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is Full");
        } else {
            arr[topOfStack + 1] = value;
            topOfStack++;
            System.out.println("Value is Successfully inserted.");
        }
    }

    //Pop method
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            int topElement = arr[topOfStack];
            topOfStack--;
            return topElement;
        }
    }

    //Peek method
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return arr[topOfStack];
        }
    }
    //delete stack
    public void deleteStack(){
        arr=null;
        System.out.println("Stack successfully deleted.");
    }

}
