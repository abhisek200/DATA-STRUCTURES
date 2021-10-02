import java.util.HashSet;

public class Questions_LL {
    public void Delete_Duplicates(LinkedList ll) {
        HashSet<Integer> hs = new HashSet<>();
        Node current = ll.head;
        Node previous = null;
        while (current != null) {
            int curval = current.value;
            if (hs.contains(curval)) {
                previous.next = current.next;
                ll.size--;
            } else {
                hs.add(curval);
                previous = current;
            }
            current = current.next;
        }
    }

    public Node NthToLast(LinkedList ll, int N) {
        Node pointer1 = ll.head;
        Node pointer2 = ll.head;
        for (int i = 0; i < N; i++) {
            if (pointer2 == null) return null;
            pointer2 = pointer2.next;
        }
        while (pointer2 != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        return pointer1;
    }
//PARTITION LISTS
    LinkedList partition(LinkedList ll, int x) {
        Node currentNode = ll.head;
        ll.tail = ll.head;
        while (currentNode != null) {
            Node next = currentNode.next;
            if (currentNode.value < x) {
                currentNode.next = ll.head;
                ll.head = currentNode;
            } else {
                ll.tail.next = currentNode;
                ll.tail = currentNode;
            }
            currentNode = next;
        }
        ll.tail.next = null;
        return ll;
    }
//SUM_LISTS
    LinkedList SumLists(LinkedList llA, LinkedList llB ){
        Node n1=llA.head;
        Node n2= llB.head;
        int carry =0;
        LinkedList resultLL=new LinkedList();
        while(n1!=null && n2!=null){
            int result=carry;
            if(n1!=null){
                result+=n1.value;
                n1=n1.next;
            }
            if(n2!=null){
                result+=n2.value;
                n2=n2.next;
            }
            resultLL.insertLL(result%10);
            carry=result/10;
        }
        return resultLL;
    }

//INTERSECTION LIST NODE
    Node IntersectionLL(LinkedList llA, LinkedList llB){
        if(llA.head==null || llB.head==null) return null;
        if (llA.tail!=llB.tail) return null;
        Node longer=new Node();
        Node shorter=new Node();
        if(llA.size>llB.size){
            longer= llA.head;
            shorter=llB.head;
        }
        else{
            longer= llB.head;
            shorter=llA.head;
        }
        longer=bringCounterNode(longer,Math.abs(llA.size- llB.size));
        while(shorter!=longer){
            shorter=shorter.next;
            longer=longer.next;
        }
        return longer;  //intersected node
    }
    Node bringCounterNode(Node head,int k)  //bring node location of longer node
    {
        Node current=head;
        while(k>0 && current!=null){
            current=current.next;
            k--;
        }
        return current;
    }
    public void addSameNode(LinkedList llA, LinkedList llB, int nodeValue)  //Add same node
    {
        Node newNode=new Node();
        newNode.value=nodeValue;
        llA.tail.next=newNode; //prev stored last node pointer change
        llA.tail=newNode;      //tail pointer changed
        llB.tail.next=newNode;
        llB.tail=newNode;
    }
}
