import java.util.ArrayList;

public class TreeNode {
    String data;
    ArrayList<TreeNode> children;

    TreeNode(String data) {
        this.data = data;
        this.children = new ArrayList<TreeNode>();
    }

    void addChild(TreeNode node) {
        this.children.add(node);
    }

    String print(int level) { //prints the nodes
        String ret;
        ret = " ".repeat(level) + this.data + "\n";
        for (TreeNode node : this.children) {
            ret += node.print(level + 1);
        }
        return ret;
    }
}
