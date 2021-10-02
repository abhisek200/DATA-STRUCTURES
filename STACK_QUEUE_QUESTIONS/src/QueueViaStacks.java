import java.util.Stack;

public class QueueViaStacks {
    Stack<Integer> stackNewest, stackOldest;

    QueueViaStacks() {
        stackNewest = new Stack<Integer>();
        stackOldest = new Stack<Integer>();
    }

    public int size() {
        return stackOldest.size() + stackNewest.size();
    }

    void enqueue(int value) {
        stackNewest.push(value);
    }

    //helper function
    //checks if old stack is empty, then elements of new stack will shift to old stack.
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                int poppedOut = stackNewest.pop();
                stackOldest.push(poppedOut);
            }
        }
    }

    int dequeue() {
        shiftStacks();
        return stackOldest.pop();
    }

    int peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    /*MAIN CLASS*/
    public static void main(String[] args) {
        QueueViaStacks queue = new QueueViaStacks();
        queue.enqueue(1);
        queue.enqueue(2);
        System.out.println(queue.dequeue());
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println(queue.peek());
    }
}
