import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

     zadanie2(3,1);

        System.out.println();

     zadanie1(3);


    }


    private static void zadanie1(int cubeSize){

        long t1 = System.currentTimeMillis();
        HyperCube cube = new HyperCube(cubeSize);

        EdmondsKarp edmund = new EdmondsKarp((int) (Math.pow(2, cubeSize)));

        System.out.println("The maximum possible flow is " +
                edmund.edmonds_Karp(cube.getAdjacencyMatrix(), 0, (int) Math.pow(2, cubeSize) - 1));
        System.out.println("Time equals " + (System.currentTimeMillis() - t1) + " ms");
        System.out.println("Paths counter " +edmund.getPathsCounter());

    }

    private static void zadanie2(int k , int i){

        long t1 = System.currentTimeMillis();

        BipartiteGraph bipartiteGraph = new BipartiteGraph(k,i);

//        System.out.println(Arrays.deepToString(bipartiteGraph.getFlowNetwork()));

        EdmondsKarp edmund = new EdmondsKarp((int) (Math.pow(2, k+1)+2));

        System.out.println("The maximum possible flow is " +
                edmund.edmonds_Karp(bipartiteGraph.getFlowNetwork(), 0, (int) Math.pow(2, k+1) +1));
        System.out.println("Time equals " + (System.currentTimeMillis() - t1) + " ms");
        System.out.println("Paths counter " +edmund.getPathsCounter());


    }
}
