package Algorithms;

import Models.Edge;
import Models.Graph;
import Structures.PriorityQueque;

import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class Borµwka {

    private Graph graph;
    private PriorityQueque S;
    private ArrayList<Edge> T = new ArrayList<>();
    private UnionFind unionFind = new UnionFind();

    public Borµwka(Graph graph) {
        this.graph = graph;
        S = new PriorityQueque(Edge.class);
    }

    public void find() {


        for (int i = 0; i < graph.getVerticles(); i++) {
            unionFind.getSetsList().add(unionFind.MakeSet(i));
        }
        int h = 0;
        Edge e;

        while (unionFind.getSetsList().get(0).size() != graph.getVerticles())
            for (int i = 0; i < graph.verticles; i++) {
                for (Edge k : graph.getAdjacencyLists().get(i)
                ) {
                    S.insert(k);
                }




                e = (Edge) S.pop();
                graph.getAdjacencyLists().get(i).remove(e);

                if (unionFind.find(e.getNext()) == unionFind.find(e.getPrevious()))
                    continue;
                else {
                    unionFind.union(unionFind.find(e.getNext()), unionFind.find(e.getPrevious()));
                    if (!T.contains(e))
                    T.add(e);


                }

//
                S.clear();
            }

        System.out.println(T);
        System.out.println("N=:" + T.size());
        System.out.println("W=:" + getMinWeight());


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
        return unionFind.find(0).size() == graph.getVerticles();
    }
}
