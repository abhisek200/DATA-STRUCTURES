public class DoublyLinkedList {
    public DoublyNode head;
    public DoublyNode tail;
    public int size;

    public DoublyNode createDLL(int nodeValue){
        head=new DoublyNode();
        tail=new DoublyNode();
        DoublyNode newNode =new DoublyNode();
        newNode.value=nodeValue;
        newNode.next=null;
        newNode.previous=null;
        head= newNode;
        tail=newNode;
        size=1;
        return head;
    }

    public void insertionDLL(int nodeValue,int location)
    {
        DoublyNode newNode=new DoublyNode();
        newNode.value=nodeValue;
        if(head==null)
        {
            createDLL(nodeValue);
            return;
        }
        else if(location==0){
            newNode.next=head;
            newNode.previous=null;
            head.previous=newNode;
            head=newNode;
        }
        else if(location>=size){
            newNode.next=null;
            newNode.previous=tail;
            tail.next=newNode;
            tail=newNode;
        }
        else{
            DoublyNode tempNode=new DoublyNode();
            tempNode=head;
            for (int index = 0; index < location-1; index++)
            {
                tempNode=tempNode.next;
            }
             newNode.previous=tempNode;
             newNode.next=tempNode.next;
             //tempNode.next.previous=newNode;
             tempNode.next=newNode;
             newNode.next.previous=newNode;
        }
        size++;

    }

    public void traversalDLL()
    {
        if(head!=null){
            DoublyNode tempNode=head;
            for (int index = 0; index < size; index++) {
                System.out.print(tempNode.value);
                if(index!=size-1)
                    System.out.print("->");
                tempNode=tempNode.next;
            }
        }
        else
            System.out.print("DLL does not exist!");
        System.out.println();
    }

    public void reverseTraversal(){
        if(head!=null){
            DoublyNode tempNode=tail;
            for (int index = 0; index <size ; index++) {
                System.out.print(tempNode.value);
                if(index!=size-1)
                    System.out.print("<-");
                tempNode=tempNode.previous;
            }
        }
        else
            System.out.print("DLL does not exist!");
        System.out.println();

    }
    public void searchNode(int nodeValue){
        DoublyNode tempNode=head;
        if(head!=null){
            for (int i = 0; i < size; i++) {
                if(tempNode.value== nodeValue)
                {
                    System.out.println("Node exists at index "+i);
                    return;
                }
                tempNode=tempNode.next;
            }
            System.out.println("Search not found in the DLL");
        }
        else
            System.out.println("DLL does not exist.");
    }
    public void deleteNode(int location){
        if(head==null)
        {
            System.out.println("DLL does not exist.");
            return;
        }
        else if(location==0)
        {
            if(size==1){
                head=null;
                tail=null;
                size--;
                return;
            }
            else{
                head=head.next;
                head.previous=null;
                size--;
            }
        }
        else if(location>=size)
        {
            if(size==1){
                head=null;
                tail=null;
                return;
            }
            else{
                tail=tail.previous;
                tail.next=null;
                size--;
            }
        }
        else
        {
            DoublyNode tempNode=head;
            for (int index = 0; index < location-1; index++)
            {
                tempNode=tempNode.next;
            }
            tempNode.next=tempNode.next.next;
            tempNode.next.previous=tempNode;
            size--;
        }
    }
    public void deleteDLL(){
        if (head==null){
            System.out.println("DLL does not exist");
            return;
        }
        else{
            DoublyNode tempNode=head;
            for (int index = 0; index < size; index++) {
                tempNode.previous=null;
                tempNode=tempNode.next;
            }
            head=null;
            tail=null;
            System.out.println("DLL has been deleted.");
        }


    }

}
