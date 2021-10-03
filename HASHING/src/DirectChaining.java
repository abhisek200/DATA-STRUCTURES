import java.util.Hashtable;
import java.util.LinkedList;

public class DirectChaining {
    LinkedList<String>[] hastTable;
    int maxChainSize = 5;

    DirectChaining(int size) {
        hastTable = new LinkedList[size];
    }

    int modASCIIHashFunction(String word, int M) {      //M: no of cells in the array
        char ch[];
        ch = word.toCharArray();
        int i, sum;
        for (sum = 0, i = 0; i < word.length(); i++) {
            sum = sum + ch[i];
        }
        return sum % M;
    }

    void insertHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hastTable.length);
        if (hastTable[newIndex] == null) { //empty
            hastTable[newIndex] = new LinkedList<String>();
            hastTable[newIndex].add(word);
        } else {
            hastTable[newIndex].add(word);
        }
    }

    void displayHashTable() {
        if (hastTable == null) {
            System.out.println("HashTable does not exist.");
            return;
        } else {
            System.out.println("------------------Hash Table------------------");
            for (int i = 0; i < hastTable.length; i++) {
                System.out.println("Index " + i + ", Key: " + hastTable[i]);
            }
        }
    }

    boolean searchHastTable(String word) {
        int newIndex = modASCIIHashFunction(word, hastTable.length);
        if (hastTable[newIndex] != null && hastTable[newIndex].contains(word)) {
            System.out.println("\n" + "\"" + word + "\"" + " is found in hash table, at index: " + newIndex);
            return true;
        }
        System.out.println("\n" + word + " not found in hashtable.");
        return false;
    }

    void deleteKeyHashTable(String word) {
        int newIndex = modASCIIHashFunction(word, hastTable.length);
        boolean result = searchHastTable(word);
        if (result == true) {
            hastTable[newIndex].remove(word);
            System.out.println("\n" + "\"" + word + "\"" + " has been deleted from hashTable");
        }
    }
}
