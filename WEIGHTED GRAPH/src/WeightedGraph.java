import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {

    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    void addWeightedEdge(int i, int j, int d) { //d= weight of the edge
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbours.add(second);
        first.weightMap.put(second, d);
    }

    static void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }
        System.out.print(node.name + " ");
    }

    //Dijkstra's Algorithm
    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);
        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbour : currentNode.neighbours) {
                if (queue.contains(neighbour)) {
                    if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.distance + currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                        queue.remove(neighbour);      //refreshing the priority queue
                        queue.add(neighbour);
                    }
                }
            }
        }
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node: " + nodeToCheck + " ,distance: " + nodeToCheck.distance + " ,Path:");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }


    //Bellman Ford Algorithm
    void bellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0;
        for (int i = 0; i < nodeList.size(); i++) {//v-1 iterations
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbour : currentNode.neighbours) {
                    if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                        neighbour.distance = currentNode.distance + currentNode.weightMap.get(neighbour);
                        neighbour.parent = currentNode;
                    }
                }
            }
        }
        System.out.println("Checking for Negative Cycle...");

        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbour : currentNode.neighbours) {
                if (neighbour.distance > currentNode.distance + currentNode.weightMap.get(neighbour)) {
                    //means distance is changing
                    System.out.println("Negative Cycle Found:\n");
                    System.out.println("Vertex Name: " + neighbour.name);
                    System.out.println("Old Cost: " + neighbour.distance);
                    System.out.println("New Cost: " + currentNode.distance + currentNode.weightMap.get(neighbour)); //new distance which keeps changing
                    return;
                }
            }
        }
        System.out.println("Negative Cycle Not Found.");

        //printing
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node: " + nodeToCheck + " ,distance: " + nodeToCheck.distance + " ,Path:");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }


    //Floyd Warshall Algorithm
    void floydWarshall() {
        //creating default matrix, initiating direct connected values and unconnected as infinity
        int size = nodeList.size();
        int[][] V = new int[size][size];
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    V[i][j] = 0;
                } else if (first.weightMap.containsKey(second)) {
                    V[i][j] = first.weightMap.get(second);
                } else {
                    V[i][j] = Integer.MAX_VALUE / 10; //Infinity //divide by 10 to avoid arithmetic overflow
                }
                //or else V[i][j] = first.weightMap.getOrDefault(second, Integer.MAX_VALUE / 10);
            }
        }
        //FW main algorithm
        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (V[i][j] > V[i][k] + V[k][j]) {
                        V[i][j] = V[i][k] + V[k][j];
                    }
                }
            }
        }
        //Print
        for (int i = 0; i < size; i++) {//vertical column
            System.out.print("Print distance list for node " + nodeList.get(i) + " : ");
            for (int j = 0; j < size; j++) { //horizontal column
                System.out.print(V[i][j] + " ");
            }
            System.out.println();
        }
    }
}
