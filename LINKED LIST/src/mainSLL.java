public class mainSLL {
    public static void main(String[] args) {
        SinglyLinkedList sll=new SinglyLinkedList();
//        System.out.println(sll.head.value);
//        System.out.println(sll.head.value);
//        System.out.println(sll.head.next.value);
//        System.out.println(sll.head.next.next.value);
//        System.out.println(sll.tail.value);
        sll.createSingleLinkedList(5);
        sll.insertLinkedList(6,0);
        System.out.println(sll.head.value);
/*
        sll.insertLinkedList(7,3);
        sll.insertLinkedList(8 ,4);
        sll.insertLinkedList(9,5);
        sll.traversingSinglyLinkedList();
        sll.deleteNode(3);
        sll.traversingSinglyLinkedList();
        sll.deleteSll();
*/


    }
}
