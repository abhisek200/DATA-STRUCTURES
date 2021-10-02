public class Main {
    public static void main(String[] args) {
        Binary_LL bs=new Binary_LL();
        bs.insert("N1");
        bs.insert("N2");
        bs.insert("N3");
        bs.insert("N4");
        bs.insert("N5");
        bs.insert("N6");
        bs.levelOrder();
        bs.deleteNode("N2");
        bs.levelOrder();

    }
}
