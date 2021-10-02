public class BinaryTree {
    String arr[];
    int lastUsedIndex;

    BinaryTree(int size) {
        arr = new String[size + 1];
        this.lastUsedIndex = 0;
        System.out.printf("Blank tree of size %d is created", size);
    }

    //isFull
    boolean isFull() {
        if (arr.length - 1 == lastUsedIndex)
            return true;
        else
            return false;
    }

    //Insertion method
    void insert(String value) {
        if (!isFull()) {
            arr[lastUsedIndex + 1] = value;
            lastUsedIndex++;
            System.out.println(value + " is inserted");
        } else
            System.out.println("Binary Tree is Full");
    }

    //Pre-order traversal
    void preOrder(int index) { //start from index 1 so everytime you need to put index 1
        if (index > lastUsedIndex) {
            return;
        }
        System.out.println(arr[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    //In-order traversal
    void inOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrder(index * 2); //left subtree
        System.out.println(arr[index] + " "); //root node
        preOrder(index * 2 + 1); //right subtree
    }

    //Post-order traversal
    void postOrder(int index) {
        if (index > lastUsedIndex) {
            return;
        }
        preOrder(index * 2);  //left subtree
        preOrder(index * 2 + 1); //right subtree
        System.out.println(arr[index] + " ");//root node
    }

    //Level-order traversal
    void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //search value
    int search(String value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (arr[i] == value) {
                System.out.println(value + " exists at location " + i);
                return i;
            }
        }
        System.out.println("value does exist in tree.");
        return -1;
    }

    //delete node in tree
    void deleteNode(String value) {
        int location = search(value);
        if (location == -1) {
            return;
        } else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println(value + " successfully deleted.");
        }
    }

    //delete tree
    void deleteTree() {
        try {
            arr = null;
            System.out.println("Tree has been successfully deleted.");
        } catch (Exception e) {
            System.out.println("Error deleting a tree!");
        }
    }
}


