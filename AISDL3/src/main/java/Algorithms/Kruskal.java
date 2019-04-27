package Algorithms;

import Models.Edge;
import Models.Graph;
import Structures.PriorityQueque;
import java.util.ArrayList;


public class Kruskal {

    private Graph graph;
    private PriorityQueque S;
    private ArrayList<Edge> T = new ArrayList<>();
    private UnionFind unionFind = new UnionFind();

    public Kruskal(Graph graph) {
        this.graph = graph;
        S = new PriorityQueque(Edge.class);
        for (Edge e : graph.getEdges()
        ) {
            S.insert(e);
        }
    }

    public void find() {
        Edge e;

        for (int i = 0; i < graph.getVerticles(); i++) {
            unionFind.getSetsList().add(unionFind.MakeSet(i));
        }

        while (!S.isEmpty() && !check(graph)) {
            e = (Edge) S.pop();
            if (unionFind.find(e.getPrevious()) != unionFind.find(e.getNext())) {
                T.add(e);
                unionFind.union(unionFind.find(e.getPrevious()), unionFind.find(e.getNext()));
            }

        }
    }

    public int getMinWeight() {
        if (check(graph)) {
            int i = 0;
            for (Edge e : T
            ) {
                i += e.getWeight();

            }
            return i;
        }
        return 0;
    }

    public ArrayList<Edge> getT() {
        return T;
    }

    private boolean check(Graph graph) {
        if (unionFind.find(0).size() != graph.getVerticles())
            return false;

        return true;
    }

}