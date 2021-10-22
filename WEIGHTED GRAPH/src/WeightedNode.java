import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WeightedNode implements Comparable<WeightedNode> //interface of class WeightNode
{
    String name;
    ArrayList<WeightedNode> neighbours = new ArrayList<>();
    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>(); //edge distance is stored here/ cost of the edge
    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
    public int index;

    public WeightedNode(String name, int index) {
        this.name = name;
        this.index = index;
        distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int compareTo(WeightedNode o) {
        return this.distance - o.distance;
    }

}
