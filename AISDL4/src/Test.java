import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
@SuppressWarnings("Duplicates")
public class Test {
    public static void main(String[] args) {
//       test();

        testINT(1000,Integer.MAX_VALUE,10);
    }

    private static void testINT(int number , int range,int test) {
        int[] data = new int[9];


        for (int a = 0; a < test; a++) {
            SplayTree splayTree = new SplayTree();
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            RedBlackTree redBlackTree = new RedBlackTree();
            Random generator = new Random();

            int[] array = new int[number*10];


            for (int i = 0; i < 10*number; i++)
                array[i] = i;

            int temp[] = Arrays.copyOf(array, array.length);
            Collections.shuffle(Collections.singletonList(temp));

            int temp2[] = Arrays.copyOf(array, array.length);
            Collections.shuffle(Collections.singletonList(temp2));

//            System.out.println("SPLAY DATA WITH " + number + " NUMBERS");
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < 10*number; i++)
                splayTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[0] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i <  number; i++)
                splayTree.find(temp[generator.nextInt(10)]);
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[1] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < 9*number; i++)
                splayTree.remove(temp2[i]);
//            System.out.println("removal time = " + (System.currentTimeMillis() - t1));
            data[2] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();

//            System.out.println();
//            System.out.println("BST TREE DATA WITH " + number + " NUMBERS");
            for (int i = 0; i <10* number; i++)
                binarySearchTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[3] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i <  number; i++)
                binarySearchTree.search(generator.nextInt(range));
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[4] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < 9*number; i++)
                binarySearchTree.delete(temp2[i]);
//            System.out.println("removal time =" + (System.currentTimeMillis() - t1));
            data[5] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
//            System.out.println();
//            System.out.println("REDBLACK TREE DATA WITH " + number + " NUMBERS");
            for (int i = 0; i < 10*number; i++)
                redBlackTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[6] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < number; i++)
                redBlackTree.search(temp[generator.nextInt(10)]);
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[7] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < 9*number; i++)
                redBlackTree.delete(temp2[i]);
//            System.out.println("removal time =" + (System.currentTimeMillis() - t1));
            data[8] += System.currentTimeMillis() - t1;
        }

        for (int i=0; i < data.length ; i ++) {
            if (i==0)
                System.out.print("Splay tree \nInsert: ");
            else if (i==3)
                System.out.print("Binary search tree \nInsert: ");
            else if (i==6)
                System.out.print("RedBlack tree \nInsert: ");

            if (i%3==1)
                System.out.print("Search :");
            if (i%3==2)
                System.out.print("Remove :");
            System.out.println(data[i]);


            if (i%3==2)
                System.out.println();

        }


    }








    private static void test(){

        Random generator = new Random();
        long t1,t2,t3;
        FileParser fileParser = new FileParser();
        int x;

        ArrayList<String> data = fileParser.parseFile("/home/krzyhoo/Desktop/AISDL4/src/KJB.txt");
        ArrayList<String> modifiedData = new ArrayList<>();
        modifiedData.addAll(data);


        t1 = System.currentTimeMillis();
        SplayTree splay = new SplayTree();
//        for (int i=0 ;i<number ; i++) {
//            splay.insert(generator.nextInt(range));
//
//        }
        for (String s:data
             ) {
            x=generator.nextInt(modifiedData.size());
            splay.insert(modifiedData.get(x));
            modifiedData.remove(x);

        }

        t1=System.currentTimeMillis()-t1;
        t2=System.currentTimeMillis();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        for (int i =0 ; i < number;i++) {
//            binarySearchTree.insert(generator.nextInt(range));
//
//
//        }
        modifiedData.addAll(data);
        for (String s:data
        ) {

            x=generator.nextInt(modifiedData.size());
            binarySearchTree.insert(modifiedData.get(x));
            modifiedData.remove(x);
        }



        t2=System.currentTimeMillis()-t2;
        t3=System.currentTimeMillis();
        RedBlackTree redBlackTree = new RedBlackTree();
//        for (int i=0;i<number ; i ++) {
//            redBlackTree.insert(generator.nextInt(range));
//
//
//        }   modifiedData.addAll(data);
        modifiedData.addAll(data);
        for (String s:data
        ) { x=generator.nextInt(modifiedData.size());
            redBlackTree.insert(modifiedData.get(x));
            modifiedData.remove(x);
        }




        t3 = System.currentTimeMillis()-t3;

        System.out.println("Splay tree data: Ins:" + splay.getcI() + " Del:" + splay.getcD() + " Src:" + splay.getcS());
        System.out.println("Capatity: " + splay.size());
        System.out.println("If counter: " +splay.getCounterIF());
        System.out.println("Modified counter: " +splay.getCounterSWAP());
        System.out.println("Time complexity of insert: " + t1 + "ms");

        t1=System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s:data
        ) {
            x=generator.nextInt(modifiedData.size());
            splay.find(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis()-t1) + "ms");
        t1=System.currentTimeMillis();

        for (String s:data
        ) {
            splay.remove(s);
        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis()-t1) + "ms");

        System.out.println();
        System.out.println("BST tree data: Ins:" + binarySearchTree.getcI() + " Del:" + binarySearchTree.getcD() + " Src:" + binarySearchTree.getcS());
        System.out.println("Capatity: " + binarySearchTree.capatity());
        System.out.println("If counter: " +binarySearchTree.getCounterIF());
        System.out.println("Modified counter: " +binarySearchTree.getCounterSWAP()); // liczba taka sama jak cap bo tylko każdemu sie dodaje jako lewy / prawy zamiast nulla , bez zmian struktury
        System.out.println("Time complexity of insert: " + t2 +"ms");
        t1=System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s:data
        ) {
            x=generator.nextInt(modifiedData.size());
            binarySearchTree.search(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis()-t1) + "ms");

        t1=System.currentTimeMillis();
        for (String s:data
        ) {

            binarySearchTree.delete(s);
        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis()-t1) + "ms");


        System.out.println();
        System.out.println("RB tree data: Ins:"+ redBlackTree.getcI() + " Del:" + redBlackTree.getcD() + " Src:" + redBlackTree.getcS());
        System.out.println("Capatity: " + redBlackTree.capatity());
        System.out.println("If counter: " + redBlackTree.getCounterIF());
        System.out.println("Modified counter: " +redBlackTree.getCounterSWAP());
        System.out.println("Time complexity of insert: " + t3+"ms");
        t1=System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s:data
        ) {
            x=generator.nextInt(modifiedData.size());
            redBlackTree.search(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis()-t1) + "ms");
        t1=System.currentTimeMillis();

        for (String s:data
        ) {

            redBlackTree.delete(s);

        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis()-t1) + "ms");



    }


}
