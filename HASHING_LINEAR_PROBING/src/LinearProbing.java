import java.util.ArrayList;

public class LinearProbing {
    String[] hashTable;
    int usedCellNumber;

    LinearProbing(int size) {
        hashTable = new String[size];
        usedCellNumber = 0;
    }

    //hash function
    public int modASCIIHashFunction(String word, int M) {
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    //load factor
    private double getLoadFactor() {    //if it's greater than 0.75 we create a new hashTable.
        double loadFactor = usedCellNumber * 1.0 / hashTable.length;
        return loadFactor;
    }

    //reHash                    //create new HashTable of size 2x.
    private void rehashKeys(String word) {
        usedCellNumber = 0;
        ArrayList<String> data = new ArrayList<String>();
        for (String s : hashTable) {        //moving all elements of hashTable to data
            if (s != null) {
                data.add(s);
            }
        }
        data.add(word);
        hashTable = new String[hashTable.length * 2];
        for (String s : data) {
            insertInHashTable(s);
        }
    }

    void insertInHashTable(String word) {
        double loadFactor = getLoadFactor();
        if (loadFactor > 0.75) { //from java documentation
            rehashKeys((word));
        } else {
            int index = modASCIIHashFunction(word, hashTable.length);
            for (int i = index; i < index + hashTable.length; i++) {
                int newIndex = i % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = word;
                    System.out.println(word + " successfully inserted.");
                    break;
                } else {
                    System.out.println(word + " already occupied.Trying next empty cell.");
                }
            }
        }
        usedCellNumber++;
    }

    //display
    public void displayHashTable() {
        if (hashTable == null) {
            System.out.println("\nHashTable does not exists");
            return;
        } else {
            System.out.println("\n----------HashTable----------");
            for (int i = 0; i < hashTable.length; i++) {
                System.out.println("Index " + i + ", key:" + hashTable[i]);
            }
        }
    }

    //search
    boolean searchHash(String word) {
        int index = modASCIIHashFunction(word, hashTable.length);
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
        int index = modASCIIHashFunction(word, hashTable.length);
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
