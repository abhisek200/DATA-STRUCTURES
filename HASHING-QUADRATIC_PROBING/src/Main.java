public class Main {
    public static void main(String[] args) {
        QuadraticProbing qb=new QuadraticProbing(5);
        qb.insertKeyInHashTable("The");
        qb.insertKeyInHashTable("Quick");
        qb.insertKeyInHashTable("Fox");
        qb.insertKeyInHashTable("Jumps");
        qb.insertKeyInHashTable("Over");
        qb.insertKeyInHashTable("Time");
        qb.displayHashTable();
        qb.deleteKeyHashTable("Fox");
        qb.displayHashTable();
    }
}
