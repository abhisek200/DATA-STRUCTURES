import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;

    AVL() {
        root = null;
    }

    // PreOrder Traversal
    public void preOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    // Inorder Traversal
    public void inOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    // PostOrder Traversal
    public void postOrder(BinaryNode node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Level Order
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
    }

    // Search Method
    BinaryNode search(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value: " + value + " not found in AVL");
            return null;
        } else if (node.value == value) {
            System.out.println("Value: " + value + " found in AVL");
            return node;
        } else if (value < node.value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }
    //---------------------------------------------------------------------------------------//

    //getHeight             (- returns height of BT)
    int getHeight(BinaryNode node) {
        if (node == null)
            return 0;
        else
            return node.height;
    }

    //rotateRight
    private BinaryNode rotateRight(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.left;
        disbalancedNode.left = disbalancedNode.left.right;
        newRoot.right = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right)); //1 + because dBNode itself is also counted
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //rotateLeft
    private BinaryNode rotateLeft(BinaryNode disbalancedNode) {
        BinaryNode newRoot = disbalancedNode.right;
        disbalancedNode.right = disbalancedNode.right.left;
        newRoot.left = disbalancedNode;
        disbalancedNode.height = 1 + Math.max(getHeight(disbalancedNode.left), getHeight(disbalancedNode.right));
        newRoot.height = 1 + Math.max(getHeight(newRoot.left), getHeight(newRoot.right));
        return newRoot;
    }

    //getBalance                            (gets balance node acc to which L/R rotation will be done)
    private int getBalance(BinaryNode node) {
        if (node == null)
            return 0;
        return getHeight(node.left) - getHeight(node.right);
    }

    //insertNode
    private BinaryNode insertNode(BinaryNode node, int nodeValue) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.value = nodeValue;
            newNode.height = 1;
            return newNode;
        } else if (nodeValue < node.value) {
            node.left = insertNode(node.left, nodeValue);
        } else if (nodeValue > node.value) {
            node.right = insertNode(node.right, nodeValue);
        }

        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        int balance = getBalance(node);

        if (balance > 1 && nodeValue < node.left.value) {// LL  (means nodeValue is at left child of node.left)
            return rotateRight(node);
        }
        if (balance > 1 && nodeValue > node.left.value) {// LR  (means nodeValue is at right child of node.left)
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && nodeValue > node.right.value) {// RR  (means nodeValue is at right child of node.right)
            return rotateLeft(node);
        }
        if (balance < -1 && nodeValue < node.right.value) {// RL  (means nodeValue is at left child of node.right)
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    //call for insert()
    public void insert(int value) {
        root = insertNode(root, value);
    }

    //minimumNode              (because for deleting a node having two children we need minimum node from right subtree)
    static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null)
            return root;
        return minimumNode(root.left);
    }

    //DeleteNode
    public BinaryNode deleteNode(BinaryNode node, int value) {
        if (node == null) {
            System.out.println("Value not found in AVL tree");
            return node;
        }
        if (value < node.value) {
            node.left = deleteNode(node.left, value);
        } else if (value > node.value) {
            node.right = deleteNode(node.right, value);
        } else {//means node found

            if (node.left != null && node.right != null) {
                BinaryNode tempNode = node;
                BinaryNode minimumNodeForRight = minimumNode(tempNode.right);
                node.value = minimumNodeForRight.value;
                node.right = deleteNode(node.right, minimumNodeForRight.value); //deletes successor value
            } else if (node.left != null) {
                node = node.left;
            } else if (node.right != null) {
                node = node.right;
            } else {
                node = null;
            }
        }
        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0) {  // LL  (means nodeValue is at left child of node.left)
            return rotateRight(node);
        }
        if (balance > 1 && getBalance(node.left) < 0) {  // LR  (means nodeValue is at right child of node.left)
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0) {  // RR  (means nodeValue is at right child of node.right)
            return rotateLeft(node);
        }
        if (balance < -1 && getBalance(node.right) > 0) {  // RL  (means nodeValue is at left child of node.right)
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;
    }

    void delete(int value) {
        root = deleteNode(root, value);
    }
    public void deleteAVL() {
        root = null;
    }
}
