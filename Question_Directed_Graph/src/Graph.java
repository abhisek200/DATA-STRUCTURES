import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    static ArrayList<GraphNode> nodeList = new ArrayList<>();

    public enum State {
        //Enumerations serve the purpose of representing a group of named constants in a programming language.
        //Enum declaration can be done outside a Class or inside a Class but not inside a Method.
        Unvisited, Visited, Visiting;
    }

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    void addDirectedEdge(int i, int j) {
        GraphNode first = nodeList.get(i);
        GraphNode second = nodeList.get(j);
        first.neighbours.add(second);
    }

    //Route between nodes
    public static boolean search(GraphNode start, GraphNode end) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        for (GraphNode node : nodeList) {
            node.state = State.Unvisited;  //default state is Unvisited
        }
        start.state = State.Visiting;
        queue.add(start);
        GraphNode currentNode;
        while (!queue.isEmpty()){
            currentNode= queue.removeFirst();
            if(currentNode!=null){
                for (GraphNode v:currentNode.neighbours){
                    if(v.state==State.Unvisited){
                        if(v==end)
                            return true;
                        else{
                            v.state=State.Visiting;
                            queue.add(v);
                        }
                    }
                }
                currentNode.state=State.Visited;
            }
        }
        return false;
    }

}
