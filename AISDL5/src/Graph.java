import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {

    private List<Edge> edges;
    private List<Vertex> vertices;

    public Graph() {
        edges = new LinkedList<>();
        vertices = new LinkedList<>();
    }

    public void addEdges(Edge ... e){
        edges.addAll(Arrays.asList(e));
    }
    public void addVertices(Vertex ... e){
        vertices.addAll(Arrays.asList(e));
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public List<Vertex> getVertices() {
        return vertices;
    }



}
