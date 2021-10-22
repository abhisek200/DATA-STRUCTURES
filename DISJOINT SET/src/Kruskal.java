import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Kruskal {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();
    ArrayList<UndirectedEdge> edgeList = new ArrayList<>();

    Kruskal(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addWeightedUndirectedEdge(int firstIndex, int secondIndex, int weight) {
        UndirectedEdge edge = new UndirectedEdge(nodeList.get(firstIndex), nodeList.get(secondIndex), weight);
        WeightedNode first = edge.first;
        WeightedNode second = edge.second;
        first.neighbours.add(second);
        second.neighbours.add(first); //undirected edge
        first.weightMap.put(second, weight);
        second.weightMap.put(first, weight); //undirected edge
        edgeList.add(edge);
    }

    void kruskal() {
        DisjointSet.makeSet(nodeList); //sorting in ascending order
        Comparator<UndirectedEdge> comparator = new Comparator<UndirectedEdge>() {
            @Override
            public int compare(UndirectedEdge o1, UndirectedEdge o2) { //comparison based on weight
                return o1.weight - o2.weight;
            }
        };
        Collections.sort(edgeList, comparator);
        int cost = 0;
        //loop through
        for (UndirectedEdge edge : edgeList) {
            WeightedNode first = edge.first;
            WeightedNode second = edge.second;
            //check if they located in same set or not
            if (!DisjointSet.findSet(first).equals(DisjointSet.findSet(second))) {
                DisjointSet.unionSet(first, second);
                cost += edge.weight;
                System.out.println("Taken: " + edge);
            }
        }
        System.out.println("\n Total cost of MST= " + cost);
    }
}
