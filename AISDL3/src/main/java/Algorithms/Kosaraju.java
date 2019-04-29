package Algorithms;
import Models.Edge;
import  Models.Graph;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {

    private Graph graph;

    public Kosaraju(Graph graph){this.graph=graph;}

    void DFSUtil(int v, boolean visited[], Graph graph)
    {

        visited[v] = true;
        System.out.print(v + " ");


        for (Edge e:graph.getAdjacencyLists().get(v)
        ) {
            if(!visited[e.getNext()])
                DFSUtil(e.getNext(),visited,graph);
        }
    }

    Graph getTranspose()
    {
        Graph g = new Graph(graph.getVerticles());
        for (int i = 0; i < graph.getVerticles(); i++)
            g.getAdjacencyLists().add(new LinkedList<Edge>());

        for (Edge e:graph.getEdges()
        ) {

            g.getAdjacencyLists().get(e.getNext()).add(new Edge(e.getNext(),e.getPrevious(),e.getWeight()));
            g.addEdge(new Edge(e.getNext(),e.getPrevious(),e.getWeight()));

        }
        g.calculateAdjacencyListUndirected();


        return g;
    }

    void fillOrder(int v, boolean visited[], Stack stack, Graph graph)
    {

        visited[v] = true;

        for (Edge e:graph.getAdjacencyLists().get(v)
        ) {
            if(!visited[e.getNext()])
                fillOrder(e.getNext(), visited, stack,graph);
        }
        stack.push(new Integer(v));
    }
    public void printSCCs()
    {
        Stack stack = new Stack();

        boolean visited[] = new boolean[graph.getVerticles()];
        for(int i = 0; i < graph.getVerticles(); i++)
            visited[i] = false;


        for (int i = 0; i < graph.getVerticles(); i++)
            if (!visited[i])
                fillOrder(i, visited, stack,graph);


        Graph graph  = getTranspose();

        for (int i = 0; i < graph.getVerticles(); i++)
            visited[i] = false;


        while (!stack.empty())
        {

            int v = (int)stack.pop();


            if (!visited[v])
            {
                DFSUtil(v, visited,graph);
                System.out.println();
            }
        }
    }
}