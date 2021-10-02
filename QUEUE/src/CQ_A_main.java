public class CQ_A_main {
    public static void main(String[] args) {
        CircularQueue_Array cq=new CircularQueue_Array(4);
        System.out.println(cq.isEmpty());
        cq.enQueue(11);
        cq.enQueue(12);
        cq.enQueue(13);
        cq.enQueue(14);
        System.out.println(cq.isFull());
        System.out.println(cq.deQueue()+" is removed.");
        System.out.println(cq.deQueue()+" is removed.");
        cq.enQueue(16);
        cq.enQueue(17);
        System.out.println(cq.isFull());
        System.out.println("beginning of queue is at: "+cq.peek());
        cq.deleteQueue();
    }
}
