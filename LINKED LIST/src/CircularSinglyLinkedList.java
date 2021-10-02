public class CircularSinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createCSLL(int nodeValue) {
        head = new Node();
        Node node = new Node();
        node.value = nodeValue;
        node.next = node;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertCSLL(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;
        if (head == null) {
            createCSLL(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
            tail.next = head; //last node's next reference = head's current reference
        } else if (location >= size) {
            tail.next = node; //last node next reference
            tail = node;
            tail.next = head; //new node is tail.next
        } else {
            Node tempNode = new Node();
            for (int index = 0; index < location - 1; index++) {
                tempNode = tempNode.next;
            }
            node = tempNode.next;
            tempNode.next = node;
        }
        size++;
    }

    public void traverseCSLL() {
        if (head == null)
        {
            System.out.println("CSLL does not exist");
            return;
        }
        Node tempNode = new Node();
        tempNode = head;
        for (int i = 0; i < size; i++, tempNode = tempNode.next) {
            System.out.print(tempNode.value);
            if (i != size - 1)
                System.out.print(("->"));
        }
        System.out.println();
    }

    public boolean searchingCSLL(int nodeValue) {
        if (head != null) {
            Node tempNode = head;
            for (int i = 0; i < size; i++, tempNode = tempNode.next) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Value found at index: " + i);
                    return true;
                }
            }
        }
        System.out.println("Value not found");
        return false;
    }

    public void deleteNodeCSLL(int location) {
        if (head == null) {
            System.out.println("CSLL does not exist");
            return;
        } else if (location == 0) {
            head = head.next;
            tail.next = head;
            size--;
            if (size == 0) {
                tail = null;
                head.next = null; //first node's next reference should also be null
                head = null;
                return;
            }
        } else if (location >= size) {
            Node tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head)  //means we only have one element
            {
                head.next = null;
                tail = head = null;
                size--;
                return;
            }
            tempNode.next = head;
            tail = tempNode;
            size--;
        }
        else  //in the middle of the CSLL
        {
            Node tempNode=head;
            for (int i = 0; i < location-1; i++) {
                tempNode=tempNode.next;
            }
            tempNode.next=tempNode.next.next;
            size--;
        }
    }

    public void deleteEntireCSLL(){
        if(head==null)
            System.out.println("CSLL does not exist.");
        else{
            tail.next=null;
            head=tail=null;
            System.out.println("CSLL has been deleted.");
        }
    }
}
