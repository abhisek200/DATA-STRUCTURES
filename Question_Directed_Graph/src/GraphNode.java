import java.util.ArrayList;

public class GraphNode {

    String name;
    int index;
    boolean isVisited = false;
    GraphNode parent;
    Graph.State state; //enum State is a type of GraphNode

    public ArrayList<GraphNode> neighbours = new ArrayList<>();

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}
