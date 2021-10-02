import java.util.EmptyStackException;

public class Single_Stack_SOP {
    public static class StackNode {
        public StackNode above;
        public StackNode below;
        public int value;

        public StackNode(int value){
            this.value=value;
        }
    }
    private int capacityOfStack;
    public StackNode top;
    public StackNode bottom;
    public int size = 0;

    public Single_Stack_SOP(int capacity) {
        this.capacityOfStack = capacity; //identifies the threshold of the stack
    }

    boolean isFull() {
        return (capacityOfStack == size);
    }

    public void join(StackNode above, StackNode below) {
        if (below != null)
            below.above = above;
        if (above != null)
            above.below = below;
    }

    boolean push(int value) {
        if (size >= capacityOfStack)
            return false;
        size++;
        StackNode newNode = new StackNode(value);
        if (size == 1)
            bottom = newNode;
        join(newNode,top);
        top=newNode;
        return true;
    }

    int pop(){
        if(top==null)
            throw new EmptyStackException();
        int result=top.value;
        top=top.below;
        size--;
        return result;
    }



    public static class SOP_main {
        public static void main(String[] args) {
            Single_Stack_SOP newStack=new Single_Stack_SOP(3);
            System.out.println(newStack.push(3));
            System.out.println(newStack.push(4));
            System.out.println(newStack.push(5));
            System.out.println(newStack.pop());
        }
    }
}
