package Models;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    public int verticles;
    private ArrayList<Edge> edges;
    private List<List<Edge>> adjacencyLists = new LinkedList<>();

    public Graph(int verticles) {
        this.verticles = verticles;
        this.edges = new ArrayList<>();
        this.adjacencyLists = new ArrayList<>();

    }

    public List<List<Edge>> getAdjacencyLists() {
        return adjacencyLists;
    }

    public void addEdge(Edge e) {
        edges.add(e);
    }

    public int getVerticles() {
        return verticles;
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }


    public void calculateAdjacencyListUndirected() {
        for (int i = 0; i < verticles; i++)
            adjacencyLists.add(new LinkedList<Edge>());

        for (Edge e : edges
        ) {
            adjacencyLists.get(e.getPrevious()).add(e); // next dla skierowanego
            adjacencyLists.get(e.getNext()).add(e);
        }


    }
    public void calculateAdjacencyListDirected() {
        for (int i = 0; i < verticles; i++)
            adjacencyLists.add(new LinkedList<Edge>());

        for (Edge e : edges
        ) {
            adjacencyLists.get(e.getNext()).add(e);
        }


    }
}
