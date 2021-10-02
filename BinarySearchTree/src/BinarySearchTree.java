import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    BinaryNode root;

    BinarySearchTree() {
        this.root = null;
    }

    //Insert node
    private BinaryNode insert(BinaryNode currentNode, int value) {
        if (currentNode == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = value;
            System.out.println(newNode.value + " Value successfully inserted.");
            return newNode;
        } else if (value <= currentNode.value) {
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    void insertValue(int value) {
        root = insert(root, value);
    }

    //Pre-Order traversal
    void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " "); //root
        preOrder(node.left);
        preOrder(node.right);
    }

    //In-order traversal
    void inOrder(BinaryNode node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " "); //root
        inOrder(node.right);
    }

    //Post-Order traversal
    void postOrder(BinaryNode node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " "); //root
    }

    //Level-Order traversal
    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null)
                queue.add(presentNode.left);
            if (presentNode.right != null)
                queue.add(presentNode.right);
        }
    }

    //Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println(value + " value doesn't exist in the tree.");
            return null;
        } else if (node.value == value) {
            System.out.println(value + " exits in the tree.");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    //Successor node / Minimum node
    BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null)
            return root;
        else return minimumNode(root.left);
    }

    //Delete Node
    BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value Not Found");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else { //equal case
            if (root.left != null && root.right != null) {
                BinaryNode temp = root; //present node
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
            } else if (root.left != null) { //deleting leaf nodes
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }
        return root;
    }

    //Delete Entire Tree
    void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully.");
    }
}
