public class linearQueue_LinkedList {
    LinkedList list;

    linearQueue_LinkedList() {
        list = new LinkedList();
        System.out.println("Queue is Succesfully created.");
    }

    boolean isEmpty() {
        if (list.head == null)
            return true;
        else
            return false;
    }

    void enQueue(int value) {
        list.insertInLinkedList(value, list.size); //list.size means end of LL
        System.out.println(value + " value successfully inserted.");
    }

    int deQueue() {
        int value = -1;
        if (isEmpty())
            System.out.println("Queue is empty");
        else {
            value = list.head.value;
            list.deletionOfNode(0);
            System.out.println(value + " is deleted.");
        }
        return value;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        } else {
            return list.head.value;
        }
    }

    void deleteQueue() {
        list.head = list.tail = null;
        System.out.println("Queue dissolved.");
    }
}
