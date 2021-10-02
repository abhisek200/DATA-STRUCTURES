public class ThreeInOne {
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes; //default array values in java of INTEGER TYPE is 0.

    ThreeInOne(int stackSize) {
        stackCapacity = stackSize;
        values = new int[stackSize * numberOfStacks];
        sizes = new int[numberOfStacks];
    }

    //isFull
    boolean isFull(int indexStackNumber) {
        if (sizes[indexStackNumber] == stackCapacity) //checks where the numbered stack is 3 or not
            return true;
        else
            return false;
    }

    //isEmpty
    boolean isEmpty(int indexStackNumber) { //index of stack number
        if (sizes[indexStackNumber] == 0)
            return true;
        else
            return false;
    }

    //returns index of top element of given stack number
    private int indexOfTop(int indexStackNumber) {
        int offset = indexStackNumber * stackCapacity;
        int size = sizes[indexStackNumber];
        return offset + size - 1; //returns index of top element
    }

    //push method
    void push( int indexStackNumber,int value) {
        if (isFull(indexStackNumber))
            System.out.println("STACK IS FULL.");
        else {
            sizes[indexStackNumber]++;
            values[indexOfTop(indexStackNumber)]=value;
        }
    }

    //pop method
    int pop(int indexStackNumber) {
        if (isEmpty(indexStackNumber)) {
            System.out.println("STACK IS EMPTY");
            return -1;
        } else {
            int topIndex = indexOfTop(indexStackNumber);
            int value = values[topIndex]; //value of the number that 'll be removed
            values[topIndex] = 0;
            sizes[indexStackNumber]--;
            return value;
        }

    }

    //peek method
    int peek(int indexStackNumber) {
        if (isEmpty(indexStackNumber)) {
            System.out.println("STACK IS EMPTY");
            return -1;
        } else {
            int topIndex = indexOfTop(indexStackNumber);
            return values[topIndex];
        }

    }
}
