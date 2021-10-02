public class main {             //array
    public static void main(String[] args) {
        Stack sc = new Stack(4);
//        System.out.println(sc.isEmpty());
//        System.out.println(sc.isFull());
        sc.push(12);
        sc.push(2);
        sc.push(21);
        sc.push(24);
        System.out.println(sc.pop());   // pop-removes and returns the ex-last number
        System.out.println(sc.peek()); //only return the last element
        sc.deleteStack();
    }
}
