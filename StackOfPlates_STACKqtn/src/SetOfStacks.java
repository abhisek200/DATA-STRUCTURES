import java.util.ArrayList;
import java.util.EmptyStackException;

public class SetOfStacks {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity; //threshold

    SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0)
            return null;
        return stacks.get(stacks.size() - 1); //gives last stack as it is stored in index
    }

    public void push(int v) {
        Stack last = getLastStack(); //returns the last stack
        if (last != null && !last.isFull()) {
            last.push(v);
        } else {//create a new stack
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() { //last stacks top element
        Stack last = getLastStack();
        if (last == null)
            throw new EmptyStackException();
        int result = last.pop();
        if (last.size == 0)
            stacks.remove(stacks.size() - 1);
        return result;
    }

    //Follow Up
    //remove top element of a specified stack.


    //helper fn
    //leftShift

    int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if (removeTop)
            removedItem = stack.pop();
        else
            removedItem = stack.removeBottom();
        if (stack.size == 0) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }

    int popAt(int index) {
        return leftShift(index, true);
    }


}

