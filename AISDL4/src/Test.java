import java.util.Random;
@SuppressWarnings("Duplicates")
public class Test {
    public static void main(String[] args) {
       test(10000000,10000);
    }
    private static void test(int number , int range){

        Random generator = new Random();
        long t1,t2,t3;
        t1 = System.currentTimeMillis();
        SplayTree splay = new SplayTree();
        for (int i=0 ;i<number ; i++) {
            splay.insert(generator.nextInt(range));

        }
        t1=System.currentTimeMillis()-t1;
        t2=System.currentTimeMillis();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        for (int i =0 ; i < number;i++) {
            binarySearchTree.insert(generator.nextInt(range));


        }
        t2=System.currentTimeMillis()-t2;
        t3=System.currentTimeMillis();
        RedBlackTree redBlackTree = new RedBlackTree();
        for (int i=0;i<number ; i ++) {
            redBlackTree.insert(generator.nextInt(range));


        }
        t3 = System.currentTimeMillis()-t3;

        System.out.println("Splay tree data:");
        System.out.println("Capatity: " + splay.size());
        System.out.println("If counter: " +splay.getCounterIF());
        System.out.println("Time complexity: " + t1 + "ms");
        System.out.println();


        System.out.println("BST tree data:");
        System.out.println("Capatity: " + binarySearchTree.capatity());
        System.out.println("If counter: " +binarySearchTree.getCounterIF());
        System.out.println("Time complexity: " + t2 +"ms");
        System.out.println();



        System.out.println("RB tree data:");
        System.out.println("Capatity: " + redBlackTree.capatity());
        System.out.println("If counter: " + redBlackTree.getCounterIF());
        System.out.println("Time complexity: " + t3+"ms");
        System.out.println();

    }


}
