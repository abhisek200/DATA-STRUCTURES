import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        //Disjoint Set
//        ArrayList<WeightedNode> nodeList=new ArrayList<>();
//        nodeList.add(new WeightedNode("A"));
//        nodeList.add(new WeightedNode("B"));
//        nodeList.add(new WeightedNode("C"));
//        nodeList.add(new WeightedNode("D"));
//
//        DisjointSet.makeSet(nodeList);
//
//        WeightedNode firstNode=nodeList.get(0);
//        WeightedNode secondNode=nodeList.get(1);
//        DisjointSet output=DisjointSet.findSet(secondNode);
//        output.printAllNodesOfThisSet();
//        //--------------------------------------------------
//        DisjointSet.unionSet(firstNode,secondNode);
//        output=DisjointSet.findSet(secondNode);
//        output.printAllNodesOfThisSet();

        //Kruskal Alg.
        ArrayList<WeightedNode> nodeList=new ArrayList<>();
        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));
        nodeList.add(new WeightedNode("E"));

//        Kruskal graph= new Kruskal(nodeList);
//        graph.addWeightedUndirectedEdge(0,1,5);
//        graph.addWeightedUndirectedEdge(0,2,13);
//        graph.addWeightedUndirectedEdge(0,4,15);
//        graph.addWeightedUndirectedEdge(1,2,10);
//        graph.addWeightedUndirectedEdge(1,3,8);
//        graph.addWeightedUndirectedEdge(2,3,6);
//        graph.addWeightedUndirectedEdge(2,4,20);
//        System.out.println("Running Kruskal Algorithm...");
//        graph.kruskal();

        Prims graph2=new Prims(nodeList);
        graph2.addWeightedUndirectedEdge(0,1,5);
        graph2.addWeightedUndirectedEdge(0,2,13);
        graph2.addWeightedUndirectedEdge(0,4,15);
        graph2.addWeightedUndirectedEdge(1,2,10);
        graph2.addWeightedUndirectedEdge(1,3,8);
        graph2.addWeightedUndirectedEdge(2,3,6);
        graph2.addWeightedUndirectedEdge(2,4,20);
        System.out.println("Running Prims Algorithm...");
        graph2.prims(nodeList.get(0));

    }
}
