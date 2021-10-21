import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        //BFS AND DFS
//        ArrayList<GraphNode> nodeList=new ArrayList<>();
//        nodeList.add(new GraphNode("A",0));
//        nodeList.add(new GraphNode("B",1));
//        nodeList.add(new GraphNode("C",2));
//        nodeList.add(new GraphNode("D",3));
//        nodeList.add(new GraphNode("E",4));
//        Graph g=new Graph(nodeList);
//        g.addUndirectedEdge(0,1);
//        g.addUndirectedEdge(0,2);
//        g.addUndirectedEdge(0,3);
//        g.addUndirectedEdge(1,4);
//        g.addUndirectedEdge(2,3);
//        g.addUndirectedEdge(3,4);
//        System.out.println(g.toString());
//
//        g.DFS();
//        g.BFS();

//        /*TOPOLOGICAL SORT*/
//        ArrayList<GraphNode> nodeList = new ArrayList<GraphNode>();
//        nodeList.add(new GraphNode("A", 0));
//        nodeList.add(new GraphNode("B", 1));
//        nodeList.add(new GraphNode("C", 2));
//        nodeList.add(new GraphNode("D", 3));
//        nodeList.add(new GraphNode("E", 4));
//        nodeList.add(new GraphNode("F", 5));
//        nodeList.add(new GraphNode("G", 6));
//        nodeList.add(new GraphNode("H", 7));
//        Graph newGraph = new Graph(nodeList);
//        //Add Directed Edges
//        newGraph.addDirectedEdge(0, 2);
//        newGraph.addDirectedEdge(2, 4);
//        newGraph.addDirectedEdge(4, 7);
//        newGraph.addDirectedEdge(4, 5);
//        newGraph.addDirectedEdge(5, 6);
//        newGraph.addDirectedEdge(1, 2);
//        newGraph.addDirectedEdge(1, 3);
//        newGraph.addDirectedEdge(3, 5);
//        System.out.println(newGraph.toString());
//        System.out.println("Topological Sort:");
//        newGraph.topologicalSort();

//        /*SSSPP*/
//        ArrayList<GraphNode> nodeList=new ArrayList<>();
//        nodeList.add(new GraphNode("A",0));
//        nodeList.add(new GraphNode("B",1));
//        nodeList.add(new GraphNode("C",2));
//        nodeList.add(new GraphNode("D",3));
//        nodeList.add(new GraphNode("E",4));
//        nodeList.add(new GraphNode("F",5));
//        nodeList.add(new GraphNode("G",6));
//        Graph newGraph =new Graph(nodeList);
//        newGraph.addUndirectedEdge(0,1);
//        newGraph.addUndirectedEdge(0,2);
//        newGraph.addUndirectedEdge(1,3);
//        newGraph.addUndirectedEdge(1,6);
//        newGraph.addUndirectedEdge(2,3);
//        newGraph.addUndirectedEdge(2,4);
//        newGraph.addUndirectedEdge(3,5);
//        newGraph.addUndirectedEdge(4,5);
//        newGraph.addUndirectedEdge(5,6);
//        newGraph.BFSForSSSPP(nodeList.get(0)); //Shortest Path if we start from A
////      newGraph.BFSForSSSPP(nodeList.get(2)); //Shortest Path if we start from C
    }
}
