public class mainLL {
    public static void main(String[] args) {
        StackLL sLL=new StackLL();
        sLL.push(1);
        sLL.push(2);
        sLL.push(3);
        System.out.println(sLL.pop());
        System.out.println(sLL.pop());
        System.out.println(sLL.peek());
        sLL.deleteStack();
    }
}
