public class LinkedList {
    public Node head;
    public Node tail;
    public int size;

    public void createLL(int nodeValue){
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=head;
        head=newNode;
        tail=newNode;
        size=1;
    }
    public void insertLL(int nodeValue){
        if(head==null){
            createLL(nodeValue);
            return;
        }
        Node newNode=new Node();
        newNode.value=nodeValue;
        newNode.next=null;
        tail.next=newNode;
        tail=newNode;
        size++;
    }
     public void traverseLL(){
        Node tempNode=head;
         for (int i = 0; i < size; i++,tempNode=tempNode.next) {
             System.out.print(tempNode.value);
             if(i != size-1)
                 System.out.print(" -> ");
         }
         System.out.println();
     }

}
