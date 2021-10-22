import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();
        nodeList.add(new GraphNode("A", 0));
        nodeList.add(new GraphNode("B", 1));
        nodeList.add(new GraphNode("C", 2));
        nodeList.add(new GraphNode("D", 3));
        nodeList.add(new GraphNode("E", 4));
        nodeList.add(new GraphNode("F", 5));
        nodeList.add(new GraphNode("G", 6));
        nodeList.add(new GraphNode("H", 7));
        nodeList.add(new GraphNode("I", 8));
        nodeList.add(new GraphNode("J", 9));
        Graph newGraph = new Graph(nodeList);
        newGraph.addDirectedEdge(0, 1); //A -> B
        newGraph.addDirectedEdge(0, 2); //A -> C
        newGraph.addDirectedEdge(0, 3); //A -> D
        newGraph.addDirectedEdge(1, 9); //B -> J
        newGraph.addDirectedEdge(2, 6); //C -> G
        newGraph.addDirectedEdge(4, 0); //E -> A
        newGraph.addDirectedEdge(4, 5); //E -> F
        newGraph.addDirectedEdge(5, 8); //F -> I
        newGraph.addDirectedEdge(6, 7); //G -> H
        newGraph.addDirectedEdge(6, 3); //G -> D
        boolean result = Graph.search(nodeList.get(4), nodeList.get(0));
        System.out.println(result);
    }
}
