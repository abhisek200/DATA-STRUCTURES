public class LL_MAIN {
    public static void main(String[] args) {
//        LinkedList ll=new LinkedList();
//        ll.createLL(3);
//        ll.insertLL(5);
//        ll.insertLL(3);
//        ll.insertLL(7);
//        ll.insertLL(9);
//        ll.traverseLL();
//        Questions_LL qll=new Questions_LL();
//        qll.Delete_Duplicates(ll);
//        ll.traverseLL();
//        Node n=qll.NthToLast(ll,2);
//        System.out.println(n.value);

//        LinkedList llA=new LinkedList();
//        llA.insertLL(7);
//        llA.insertLL(1);
//        llA.insertLL(6);
//        LinkedList llB=new LinkedList();
//        llB.insertLL(5);
//        llB.insertLL(9);
//        llB.insertLL(2);
//        Questions_LL q1=new Questions_LL();
//        LinkedList sum_LL = q1.SumLists(llA, llB);
//        sum_LL.traverseLL();

        LinkedList llA=new LinkedList();
        llA.insertLL(3);
        llA.insertLL(1);
        llA.insertLL(5);
        llA.insertLL(8);
        LinkedList llB=new LinkedList();
        llB.insertLL(11);
        llB.insertLL(21);
        llB.insertLL(9);
        Questions_LL q=new Questions_LL();
        q.addSameNode(llA,llB,7);
        q.addSameNode(llA,llB,3);
        q.addSameNode(llA,llB,2);
        Node intersection=q.IntersectionLL(llA,llB);
        System.out.println(intersection.value);



    }
}
