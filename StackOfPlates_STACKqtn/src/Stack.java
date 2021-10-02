import java.util.EmptyStackException;

public class Stack {
    private int capacity;
    public StackNode top;
    public StackNode bottom;
    int size = 0;

    Stack(int capacity) { //stack threshold
        this.capacity = capacity;
    }

    boolean isFull() {
        return capacity == size;
    }

    public void join(StackNode above, StackNode below) {
        if (below != null)
            below.above = above;
        if (above != null)
            above.below = below;
    }

    boolean push(int value) {
        if (size >= capacity)
            return false;
        size++;
        StackNode newNode = new StackNode(value);
        if (size == 1)       //means 1st time insertion
            bottom = newNode;
        join(newNode, top);
        top = newNode;
        return true;
    }

    int pop() {
        if (top == null)
            throw new EmptyStackException();
        int result = top.value;
        top = top.below;
        size--;
        return result;
    }

    //Follow Up
    int removeBottom() {
        StackNode b = bottom;
        bottom = bottom.above;
        if (bottom != null)
            bottom.below = null;
        size--;
        return b.value;
    }
}
