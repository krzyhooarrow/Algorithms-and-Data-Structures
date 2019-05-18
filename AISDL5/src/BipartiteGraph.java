
import java.util.Random;

public class BipartiteGraph {

    private int[][] flowNetwork;

    public BipartiteGraph(int k, int i) {
        flowNetwork = buildFlowNetwork(k, i);
    }

    private int[][] buildFlowNetwork(int k, int i) {
        int[][] temp = new int[(int) (Math.pow(2, k + 1) + 2)][(int) (Math.pow(2, k + 1) + 2)]; // 2 zbiory po 2^k + sink i source
        Random generator = new Random();

        int random;

        for (int j = 1; j < Math.pow(2, k) + 1; j++) {
            temp[0][j] = 1;
        }// source cap = 1 foreach V : V1

        for (int j = (int) (Math.pow(2, k) + 1); j < Math.pow(2, k + 1) + 1; j++) // for each V : V2 cap -> sink = 1;
        {
            temp[j][(int) (Math.pow(2, k + 1) + 1)] = 1;
        }

        for (int j = 1; j < Math.pow(2, k) + 1; j++) {
            //foreach V : V1
            random = (int) (generator.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);

            for (int a = 0; a < i; a++) {

                while (temp[j][random] != 0)
                    random = (int) (generator.nextInt((int) (Math.pow(2, k))) + Math.pow(2, k) + 1);

                temp[j][random] = 1;

            }
        }

        return temp;
    }


    public int[][] getFlowNetwork() {
        return flowNetwork;
    }
}
