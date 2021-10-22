import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<WeightedNode> nodeList = new ArrayList<>();

    static void makeSet(ArrayList<WeightedNode> nodeList) {
        for (WeightedNode node : nodeList) {
            DisjointSet set = new DisjointSet(); //make a set of this class
            set.nodeList.add(node);
            node.set = set;
        }
    }

    public static DisjointSet findSet(WeightedNode node) {
        return node.set;
    }

    public static DisjointSet unionSet(WeightedNode node1, WeightedNode node2) {
        //check for same set, if yes no need for union
        if (node1.set.equals(node2.set))
            return null;
        else {
            DisjointSet set1 = node1.set;
            DisjointSet set2 = node2.set;

            if (set1.nodeList.size() > set2.nodeList.size()) {
                ArrayList<WeightedNode> nodeSet2 = set2.nodeList;
                for (WeightedNode node : nodeSet2) { //set is lower size will add the lower size , sets to the higher size set .
                    node.set = set1;
                    set1.nodeList.add(node); //merge the second set to first
                }
                return set1;
            } else {
                ArrayList<WeightedNode> nodeSet1 = set1.nodeList;
                for (WeightedNode node : nodeSet1) {
                    node.set = set2;
                    set2.nodeList.add(node); //merge the first set to second
                }
                return set2;
            }
        }
    }

    public void printAllNodesOfThisSet() {
        System.out.println("Printing all nodes of this set: ");
        for (WeightedNode node : nodeList) {
            System.out.print(node + "");
        }
        System.out.println();
    }


}
