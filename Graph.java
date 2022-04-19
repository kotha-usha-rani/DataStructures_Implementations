import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		List<Edge> edges = Arrays.asList(
                new Edge(0, 1, 6), new Edge(1, 2, 7), new Edge(2, 0, 5),
                new Edge(2, 1, 4), new Edge(3, 2, 10), new Edge(4, 5, 1),
                new Edge(5, 4, 3));
        Graph g = new Graph(edges, 10);
        g.print();
	}
}
class Graph{
    List<List<Node>> g = new ArrayList<>();
    Graph(List<Edge> edgeList, int v){
        for(int i=0 ; i<v ; i++)
            g.add(i, new ArrayList<>());
            
        for(Edge e : edgeList){
            g.get(e.src).add(new Node(e.des, e.wt));
        }
    }
    public void print(){
        for(int i=0 ; i<g.size() ; i++){
            System.out.print(i+"->");
            for(Node n : g.get(i)){
                System.out.print(n.val+" "+n.wt+", ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
class Node{
    int val, wt;
    Node(int val, int wt){
        this.val = val;
        this.wt = wt;
    }
}
class Edge{
    int src, des, wt;
    Edge(int src, int des, int wt){
        this.src = src;
        this.des = des;
        this.wt = wt;
    }
}
