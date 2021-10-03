import java.util.ArrayList;

public class DoubleHashing {
    String[] hashTable;
    int noOfCellsUsedInHashTable;


    //Constructor
    DoubleHashing(int size) {
        hashTable = new String[size];
        noOfCellsUsedInHashTable = 0;
    }


    // HashFunction to be used on Keys
    public int simpleASCIIHashFunction(String x, int M) {
        char ch[];
        ch = x.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < x.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    //Creates a new HashTable and does ReHashing    //creates new hashTable
    public void rehashKeys(String newStringToBeInserted) {
        noOfCellsUsedInHashTable = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hashTable) {
            if (s != null)
                data.add(s);
        }
        data.add(newStringToBeInserted);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertKeyInHashTable(s);
        }
    }

    // Display the hash table
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exits !");
            return;
        } else {
            System.out.println("\n---------- HashTable ---------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index:" + i + ".   Key:" + hashTable[i]);
            }
        }
        System.out.println("\n");
    }

    //helper
    // -------------------------------------------------------------------------
    private int addAllDigitsTogether(int sum) {
        int value = 0;
        while (sum > 0) {
            value = sum % 10;
            sum /= 10;
        }
        return value;
    }

    public int secondHashFunction(String x, int M) {
        char ch[];
        ch = x.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < x.length(); i++) {
            sum += ch[i];
        }
        while (sum > hashTable.length) {
            sum = addAllDigitsTogether(sum);
        }
        return sum % M;
    }

    public double getLoadFactor() {
        return noOfCellsUsedInHashTable * 1.0 / hashTable.length;
    }

    public void insertKeyInHashTable(String value) {
        double loadFactor = getLoadFactor();
        if (loadFactor >= 0.75) {
            rehashKeys(value);
        } else {
            int x = simpleASCIIHashFunction(value, hashTable.length);
            int y = secondHashFunction(value, hashTable.length);
            for (int i = 0; i < hashTable.length; i++) {
                int newIndex = (x + i * y) % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = value;
                    System.out.println(value + " inserted at location:" + newIndex);
                    break;
                } else {
                    System.out.println(newIndex + " is occupied. Tryin next empty index..");
                }

            }
        }
        noOfCellsUsedInHashTable++;
    }

    //search
    //-----------------------------------------------------------------------
    boolean searchHash(String word) {
        int index = simpleASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                System.out.println("\"" + word + "\"" + " found at this location: " + newIndex);
                return true;
            }
        }
        System.out.println("\"" + word + "\"" + " not found in hashtable. ");
        return false;
    }
    //delete
    void deleteKeyHashTable(String word) {
        int index = simpleASCIIHashFunction(word, hashTable.length);
        for (int i = index; i < index + hashTable.length; i++) {
            int newIndex = i % hashTable.length;
            if (hashTable[newIndex] != null && hashTable[newIndex].equals(word)) {
                hashTable[newIndex] = null;
                System.out.println("\"" + word + "\"" + " has been deleted from HashTable");
                return;
            }
        }
        System.out.println("\"" + word + "\"" + " not found.");
    }
}
