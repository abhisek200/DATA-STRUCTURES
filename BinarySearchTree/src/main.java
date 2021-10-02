public class main {
    public static void main(String[] args) {
        BinarySearchTree bst=new BinarySearchTree();
        bst.insertValue(70);
        bst.insertValue(50);
        bst.insertValue(90);
        bst.insertValue(30);
        bst.insertValue(60);
        bst.insertValue(80);
        bst.insertValue(100);
        bst.insertValue(20);
        bst.insertValue(40);
        bst.search(bst.root,30);
    }
}
