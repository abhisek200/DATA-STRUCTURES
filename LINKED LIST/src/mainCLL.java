public class mainCLL {
    public static void main(String[] args) {
        CircularSinglyLinkedList cll=new CircularSinglyLinkedList();
        cll.createCSLL(8);
        cll.insertCSLL(4,0);
        cll.insertCSLL(6,2);
        System.out.println(cll.head.value);
        System.out.println(cll.head.next.value);
        cll.traverseCSLL();
        cll.searchingCSLL(6);
        cll.deleteNodeCSLL(1);
        cll.traverseCSLL();
        cll.deleteEntireCSLL();
        cll.traverseCSLL();
    }
}
