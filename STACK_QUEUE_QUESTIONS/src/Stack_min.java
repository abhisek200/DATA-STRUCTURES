public class Stack_min {
    Node top;
    Node min;

    Stack_min() {
        top = null;
        min = null;
    }

    //min
    int minValue() {
        return min.value;
    }

    //push
    void push(int value) {
        if (min == null)
            min = new Node(value, min);
        else if (min.value < value)
            min = new Node(min.value, min);
        else
            min = new Node(value, min);
        top = new Node(value, top);
    }

    //pop
    int pop() {
        min = min.next;
        int result = top.value;
        top = top.next;
        return result;
    }
}
