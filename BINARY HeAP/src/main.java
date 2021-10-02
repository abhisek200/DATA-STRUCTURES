public class main {
    public static void main(String[] args) {
        BinaryHeap BH = new BinaryHeap(5);
        BH.insert(10,"Max");
        BH.insert(5,"Max");
        BH.insert(15,"Max");
        BH.insert(1,"Max");
        BH.levelOrder();
        BH.extractHeadOfHeap("Max");
        BH.levelOrder();
        BH.deleteHeap();
    }
}
