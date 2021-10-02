import java.lang.module.FindException;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList(int nodeValue){
        head=new Node();
        Node node=new Node();
        node.next=null;
        node.value=nodeValue;
        head=node;
        tail=node;
        size=1;
        return head;
    }

    //Insert Method for Single Linked List
    public void insertLinkedList(int nodeValue,int location){
        Node node=new Node();
        node.value=nodeValue;
        if(head==null){
            createSingleLinkedList(nodeValue);
            return;
        }
        else if(location==0){
            node.next=head;
            head=node;
        }
        else if(location>=size){
            node.next=null;
            tail.next=node;
            tail=node;
        }
        else   //at any given location
        {
            Node tempNode=head;
            int index=0;
            while(index<location-1)
            {
                tempNode=tempNode.next;
                index++;
            }
            Node nextNode=tempNode.next;
            tempNode.next=node;
            node.next=nextNode;
        }
        size+=1;
    }

    //Traversal
    public void traversingSinglyLinkedList(){
        if (head == null) {
            System.out.println("SLL doesn't exist!");
        }
        else{
            Node tempNode=head;
            for (int i = 0; i < size; i++,tempNode=tempNode.next) {
                System.out.print(tempNode.value);
                if(i!=size-1){
                    System.out.print(" -> ");
                }
//                tempNode=tempNode.next; (optional)

            }
        }
        System.out.println("\n");
    }

    //Search Node
    public boolean searchNode(int nodeValue){
        if(head!=null){
            Node tempNode=head;
            for (int i = 0; i < size; i++,tempNode=tempNode.next)
            {
                if(tempNode.value==nodeValue)
                {
                    System.out.println("found at index: "+i+"\n");
                    return true;
                }
                tempNode=tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    //Delete Node
    public void deleteNode(int location){
        if(head==null) {
            System.out.println("The SLL deos not exist");
            return;
        }
        else if (location==0){
            head=head.next;
            size--;
            if(size==0)             //means there's only one element
                tail=null;

        }
        else if(location>=size)
        {
            Node tempNode=head;
            for (int i = 0; i < size-1; i++) {
                tempNode=tempNode.next;
            }
            if(tempNode==head)  //Only one element
            {
                tail=null;
                head=null;
                size--;
                return;
            }
            tempNode.next=null;
            tail=tempNode;
            size--;
        }
        else
        {
            Node tempNode=head;
            for (int i = 0; i < location-1; i++) {
                tempNode=tempNode.next;
            }
            tempNode.next=tempNode.next.next;
            size--;
        }
        }

        //delete SLL
    public void deleteSll(){
        head=null;
        tail=null;
        System.out.println("The SLL is deleted successfully");
    }



}
