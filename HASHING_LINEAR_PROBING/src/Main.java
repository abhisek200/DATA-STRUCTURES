public class Main {
    public static void main(String[] args) {
        LinearProbing lp = new LinearProbing(13);
        lp.insertInHashTable("The");
        lp.insertInHashTable("quick");
        lp.insertInHashTable("fox");
        lp.insertInHashTable("jumps");
        lp.insertInHashTable("over");
        lp.displayHashTable();
        lp.searchHash("fox");
        lp.deleteKeyHashTable("quick");
        lp.displayHashTable();
    }
}
