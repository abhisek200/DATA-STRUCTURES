public class Main {
    public static void main(String[] args) {
        DirectChaining dc = new DirectChaining(13);
        dc.insertHashTable("The");
        dc.insertHashTable("Quick");
        dc.insertHashTable("Brown");
        dc.insertHashTable("Fox");
        dc.insertHashTable("over");
        dc.displayHashTable();
        dc.searchHastTable("Fox");
        dc.deleteKeyHashTable("The");
        dc.displayHashTable();
    }
}
