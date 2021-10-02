public class mainDLL {
    public static void main(String[] args) {
        DoublyLinkedList dll=new DoublyLinkedList();
        dll.createDLL(5);
        System.out.println(dll.head.value);
        dll.insertionDLL(3,1);
        dll.insertionDLL(7,0);
        dll.insertionDLL(9,4);
        dll.insertionDLL(6,3);
        dll.traversalDLL();
        dll.reverseTraversal();
        dll.searchNode(3);
        dll.deleteNode(1);
        dll.traversalDLL();
        dll.deleteDLL();
    }
}
