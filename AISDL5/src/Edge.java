import java.util.Arrays;

public class Edge implements Comparable<Edge> {
    private final Vertex previous;
    private final Vertex next;
    private int weight;

    public Edge(Vertex previous, Vertex next, int weight) {
        this.previous = previous;
        this.next = next;
        this.weight = weight;
    }

    public Vertex getPrevious() {
        return previous;
    }

    public Vertex getNext() {
        return next;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "" + Arrays.toString(previous.getLabel()) +
                " to " + Arrays.toString(next.getLabel()) +
                " w: " + weight
                ;
    }


    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }

}