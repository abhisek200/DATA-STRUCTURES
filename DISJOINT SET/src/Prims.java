import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prims {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    //Constructor
    Prims(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    void addWeightedUndirectedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbours.add(second);
        second.neighbours.add(first);
        first.weightMap.put(second, d);
        second.weightMap.put(first, d);
    }

    //Prims Algorithm

    void prims(WeightedNode node) {
        for (int i = 0; i < nodeList.size(); i++) {
            nodeList.get(i).distance = Integer.MAX_VALUE; //set all values to infinity
        }
        node.distance = 0; //setting source distance to 0
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();              //removes vertex having minimum distance
            for (WeightedNode neighbour : currentNode.neighbours) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);        //refreshing priority queue
                        queue.add(neighbour);
                    }
                }
            }
        }
        int cost = 0;
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.println("Node: " + nodeToCheck + " , key: " + nodeToCheck.distance + " , Parent: " + nodeToCheck.parent);
            cost = cost + nodeToCheck.distance;
        }
        System.out.println("\n Total cost of minimum spanning tree: " + cost);
    }

}
