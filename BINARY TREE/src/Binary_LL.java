import java.util.LinkedList;
import java.util.Queue;

public class Binary_LL {
    BinaryNode root;

    Binary_LL() {
        this.root = null;
    }

    //Pre-order traversal
    void preOrder(BinaryNode node) {
        if (node == null)
            return;
        System.out.println(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    //In-order traversal
    void inOrder(BinaryNode node) {
        if (node == null)
            return;
        inOrder(node.left);
        System.out.println(node.value + " ");
        inOrder(node.right);
    }

    //Post-Order traversal
    void postOrder(BinaryNode node) { //root node is passed
        if (node == null)
            return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " ");
    }

    //Level-Order traversal
    void levelOrder() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    //Search Node (Level Order)
    void Search(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                System.out.println("value is found in the tree.");
                return;
            } else {
                if (presentNode.left != null) {
                    queue.add(presentNode.left);
                }
                if (presentNode.right != null) {
                    queue.add(presentNode.right);
                }
            }
        }
        System.out.println(value + "is not found in the tree.");
    }

    //Insert method (Level Order)
    void insert(String value) {
        BinaryNode newNode = new BinaryNode();
        newNode.value = value;
        if (root == null) {
            root = newNode;
            System.out.println("new node inserted at root");
        } else {
            Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
            queue.add(root);
            while (!queue.isEmpty()) {
                BinaryNode presentNode = queue.remove();
                if (presentNode.left == null) {
                    presentNode.left = newNode;
                    System.out.println("successfully inserted.");
                    break;
                } else if (presentNode.right == null) {
                    presentNode.right = newNode;
                    System.out.println("successfully inserted.");
                    break;
                } else {
                    queue.add(presentNode.left);
                    queue.add(presentNode.right);
                }
            }
        }
    }

    //get Deepest Node
    BinaryNode getDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode presentNode = null;
        while (!queue.isEmpty()) {
            presentNode = queue.remove();
            if (presentNode.left != null)
                queue.add(presentNode.left);
            if (presentNode.right != null)
                queue.add(presentNode.right);
        }
        return presentNode; //deepest node
    }

    //delete deepest node
    public void deleteDeepestNode() {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        BinaryNode previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);
        }
    }

    //delete any given node
    void deleteNode(String value) {
        Queue<BinaryNode> queue = new LinkedList<BinaryNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            if (presentNode.value == value) {
                presentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                System.out.println("node is deleted");
                return;
            } else {
                if (presentNode.left != null)
                    queue.add(presentNode.left);
                if (presentNode.right != null)
                    queue.add(presentNode.right);
            }
        }
        System.out.println("node does not exist in binary tree. ");
    }

    //delete Binary Tree
    void binaryTree(){
        root=null;
        System.out.println("Tree successfully deleted");
    }
}
