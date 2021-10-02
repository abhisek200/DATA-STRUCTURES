public class LQ_A_main {
    public static void main(String[] args) {
        LinearQueue_Array q1=new LinearQueue_Array(5);
        System.out.println(q1.isFull());
        System.out.println(q1.isEmpty());
        q1.enQueue(1); //1st element
        q1.enQueue(2);
        q1.enQueue(3);
        q1.enQueue(4); // 1-2-3-4 FIFO
        System.out.println(q1.deQueue()); // 1st element 1 is removed
        System.out.println(q1.deQueue()); // 2nd element 2 is removed
        System.out.println(q1.peek());
        q1.deleteQueue();
        //queue is destroyed, new queue is made.
        q1=new LinearQueue_Array(3);
        System.out.println(q1.deQueue());
    }
}
