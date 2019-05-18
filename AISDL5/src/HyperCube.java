
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HyperCube {
    private Random generator = new Random();

    private List<Vertex> list = new LinkedList<>();
//    private List<Edge> edges = new LinkedList<>();
    private int[][] adjacencyMatrix;
    public HyperCube(int size) {
        adjacencyMatrix = new int[(int) Math.pow(2, size)][(int) Math.pow(2, size)];

        for (int i = 0; i < Math.pow(2, size); i++) {
            list.add(new Vertex(i, convertToBin(i, size)));
        }

        int vDist;
        int uDist;
        Edge e;
        for (Vertex v : list) {
            for (Vertex u : list) {
                if (HammingDistance(v, u) == 1) {
                    vDist = HammingWeight(v.getLabel(), size);
                    uDist = HammingWeight(u.getLabel(), size);

                    if (u.compareTo(v) < 0){
                        e=new Edge(u, v, randomWeight(capatityRange(vDist, size - vDist, uDist, size - uDist)));
//                        edges.add(e);
                        adjacencyMatrix[u.getNumber()][v.getNumber()] = e.getWeight();

                    }
                }
            }
        }
    }

    private int randomWeight(int range) {
        return generator.nextInt((int) (Math.pow(2, range))) + 1;
    }

    private int capatityRange(int... varargs) {
        int range = varargs[0];
        for (int i : varargs) {
            if (i > range)
                range = i;
        }
        return range;
    }

    public int HammingWeight(int[] array, int regex) {
        int counter = 0;
        for (int i = 0; i < regex; i++)
            if (array[i] == 1)
                counter++;
        return counter;
    }

    private int[] convertToBin(int val, int regex) {
        int[] temp = new int[regex];
        for (int i = 0; i < regex; i++) {
            temp[i] = val % 2;
            val /= 2;
        }
        reverseArray(temp, regex);
        return temp;
    }

    private void reverseArray(int a[], int n) {
        int i, t;
        for (i = 0; i < n / 2; i++) {
            t = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = t;
        }
    }

    public int HammingDistance(Vertex ver1, Vertex ver2) {
        int counter = 0;
        for (int i = 0; i < ver1.getLabel().length; i++)
            if (ver1.getLabel()[i] != ver2.getLabel()[i])
                counter++;
        return counter;
    }

    public int[][] getAdjacencyMatrix(){
        return adjacencyMatrix;
    }


    @Override
    public String toString() {
        return "HyperCube{" +
                "list=" + list +
                '}';
    }
}
