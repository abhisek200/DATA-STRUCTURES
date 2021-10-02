public class StackLL {
    LinkedList LList;

    public StackLL() {
        LList = new LinkedList();
    }

    //Push method
    public void push(int value) {
        LList.insertInLinkedList(value, 0); //bc everytime we push, element is created at first.
        System.out.println("Insert of " + value + " successful in stack.");
    }

    //isEmpty
    public boolean isEmpty() {
        if (LList.head == null)
            return true;
        else
            return false;
    }

    //pop
    public int pop() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return result;
        } else {
            result = LList.head.value;
            LList.deletionOfNode(0); //deletes 1st node
        }
        return result;
    }

    //peek
    public int peek() {
        int result = -1;
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return result;
        } else {
            result = LList.head.value;
        }
        return result;
    }

    public void deleteStack() {
        LList.head=null;
        System.out.println("Stack is successfully deleted.");
    }
}
