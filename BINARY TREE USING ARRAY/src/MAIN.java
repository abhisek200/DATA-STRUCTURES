public class MAIN {
    public static void main(String[] args) {
        BinaryTree bt1 = new BinaryTree(7);
        bt1.insert("N1");
        bt1.insert("N2");
        bt1.insert("N3");
        bt1.insert("N4");
        bt1.insert("N5");
        bt1.insert("N6");
        bt1.insert("N7");
        bt1.levelOrder();
        System.out.println();
        bt1.deleteNode("N3");
        bt1.levelOrder();
        System.out.println();
        bt1.deleteTree();
    }
}
