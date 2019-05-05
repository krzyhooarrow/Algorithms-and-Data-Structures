import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

@SuppressWarnings("Duplicates")
public class Test {
    private static int c=0;
    public static void main(String[] args) {
       test();

//        testINT(1000, Integer.MAX_VALUE, 100);








    }




    private static void testINT(int number, int range, int test) {
        int[] data = new int[9];
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        StringBuilder s3 = new StringBuilder();
        StringBuilder s4 = new StringBuilder();
        StringBuilder s5 = new StringBuilder();
        StringBuilder s6 = new StringBuilder();
        StringBuilder s7 = new StringBuilder();
        StringBuilder s8 = new StringBuilder();
        StringBuilder s9 = new StringBuilder();

        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("data.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int a = 1; a <= test; a++) {

            SplayTree splayTree = new SplayTree();
            BinarySearchTree binarySearchTree = new BinarySearchTree();
            RedBlackTree redBlackTree = new RedBlackTree();
            Random generator = new Random();
            int[] array = new int[a*number];


            binarySearchTree.clear();
            redBlackTree.clear();
            splayTree.clear();

            for (int i = 0; i < a*number; i++)
                array[i] = generator.nextInt(range);

            int temp[] = Arrays.copyOf(array, array.length);
            Collections.shuffle(Collections.singletonList(temp));

            int temp2[] = Arrays.copyOf(array, array.length);
            Collections.shuffle(Collections.singletonList(temp2));

//            System.out.println("SPLAY DATA WITH " + number + " NUMBERS");
            long t1 = System.currentTimeMillis();
            for (int i = 0; i < a*number; i++)
                splayTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[0] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < a*number; i++)
                splayTree.find(temp[generator.nextInt(4)]);
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[1] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i <  a*number; i++)
                splayTree.remove(temp2[i]);
//            System.out.println("removal time = " + (System.currentTimeMillis() - t1));
            data[2] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();

//            System.out.println();
//            System.out.println("BST TREE DATA WITH " + number + " NUMBERS");
            for (int i = 0; i < a*number; i++)
                binarySearchTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[3] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i <a*number; i++)
                binarySearchTree.search(temp[generator.nextInt(temp.length)]);
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[4] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < a*number; i++)
                binarySearchTree.delete(temp2[i]);
//            System.out.println("removal time =" + (System.currentTimeMillis() - t1));
            data[5] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            System.out.println();


            System.out.println("REDBLACK TREE DATA WITH " + number + " NUMBERS");
            for (int i = 0; i <  a*number; i++)
                redBlackTree.insert(array[i]);
//            System.out.println("insert time =" + (System.currentTimeMillis() - t1));
            data[6] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i < a*number; i++)
                redBlackTree.search(temp[generator.nextInt(temp.length)]);
//            System.out.println("find time =" + (System.currentTimeMillis() - t1));
            data[7] += System.currentTimeMillis() - t1;
            t1 = System.currentTimeMillis();
            for (int i = 0; i <  a*number; i++)
                redBlackTree.remove(temp2[i]);
//            System.out.println("removal time =" + (System.currentTimeMillis() - t1));
            data[8] += System.currentTimeMillis() - t1;

//
//            for (int i = 0; i < data.length; i++) {
//                if (i == 0)
//                    System.out.print("Splay tree \nInsert: ");
//                else if (i == 3)
//                    System.out.print("Binary search tree \nInsert: ");
//                else if (i == 6)
//                    System.out.print("RedBlack tree \nInsert: ");
//
//                if (i % 3 == 1)
//                    System.out.print("Search :");
//                if (i % 3 == 2)
//                    System.out.print("Remove :");
//                System.out.println(data[i]);
//
//
//                if (i % 3 == 2)
//                    System.out.println();
//
//            }
//

            for (int i = 0; i < data.length; i++)
                if (i == 0)
                    s1.append(String.valueOf(data[i] + ","));
//                        writer.write(String.valueOf(data[i]) + ",");
//                writer.newLine();

            for (int i = 0; i < data.length; i++)
                if (i == 1)
                    s2.append(String.valueOf(data[i] + ","));
//                        writer.write(String.valueOf(data[i]) + ",");
//                writer.newLine();

            for (int i = 0; i < data.length; i++)
                if (i == 2)
                    s3.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 3)
                    s4.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 4)
                    s5.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 5)
                    s6.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 6)
                    s7.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 7)
                    s8.append(String.valueOf(data[i] + ","));

            for (int i = 0; i < data.length; i++)
                if (i == 8)
                    s9.append(String.valueOf(data[i] + ","));
//                        writer.write(String.valueOf(data[i]) + ",");
//                writer.newLine();


        }


        for (int i = 0; i < data.length; i++) {
                if (i == 0)
                    System.out.print("Splay tree \nInsert: ");
                else if (i == 3)
                    System.out.print("Binary search tree \nInsert: ");
                else if (i == 6)
                    System.out.print("RedBlack tree \nInsert: ");

                if (i % 3 == 1)
                    System.out.print("Search :");
                if (i % 3 == 2)
                    System.out.print("Remove :");
                System.out.println(data[i]);


                if (i % 3 == 2)
                    System.out.println();

            }

        try {
            writer.write(String.valueOf(s1));
            writer.newLine();
            writer.write(String.valueOf(s2));
            writer.newLine();
            writer.write(String.valueOf(s3));
            writer.newLine();
            writer.newLine();
            writer.write(String.valueOf(s4));
            writer.newLine();
            writer.write(String.valueOf(s5));
            writer.newLine();
            writer.write(String.valueOf(s6));
            writer.newLine();
            writer.newLine();
            writer.write(String.valueOf(s7));
            writer.newLine();
            writer.write(String.valueOf(s8));
            writer.newLine();
            writer.write(String.valueOf(s9));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static void test() {

        Random generator = new Random();
        long t1, t2, t3;
        FileParser fileParser = new FileParser();
        int x;

        ArrayList<String> data = fileParser.parseFile("/home/krzyhoo/Desktop/AISDL4/src/aspell_wordlist.txt");
        ArrayList<String> modifiedData = new ArrayList<>();
        modifiedData.addAll(data);


        t1 = System.currentTimeMillis();
        SplayTree splay = new SplayTree();
//        for (int i=0 ;i<number ; i++) {
//            splay.insert(generator.nextInt(range));
//
//        }
        for (String s : data
        ) {
            x = generator.nextInt(modifiedData.size());
            splay.insert(modifiedData.get(x));
            modifiedData.remove(x);

        }

        t1 = System.currentTimeMillis() - t1;
        t2 = System.currentTimeMillis();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
//        for (int i =0 ; i < number;i++) {
//            binarySearchTree.insert(generator.nextInt(range));
//
//
//        }
        modifiedData.addAll(data);
        for (String s : data
        ) {

            x = generator.nextInt(modifiedData.size());
            binarySearchTree.insert(modifiedData.get(x));
            modifiedData.remove(x);
        }


        t2 = System.currentTimeMillis() - t2;
        t3 = System.currentTimeMillis();
        RedBlackTree redBlackTree = new RedBlackTree();
//        for (int i=0;i<number ; i ++) {
//            redBlackTree.insert(generator.nextInt(range));
//
//
//        }   modifiedData.addAll(data);
        modifiedData.addAll(data);
        for (String s : data
        ) {
            x = generator.nextInt(modifiedData.size());
            redBlackTree.insert(modifiedData.get(x));
            modifiedData.remove(x);
        }


        t3 = System.currentTimeMillis() - t3;

        System.out.println("Splay tree data: Ins:" + splay.getcI() + " Del:" + splay.getcD() + " Src:" + splay.getcS());
        System.out.println("Capatity: " + splay.size());
        System.out.println("If counter: " + splay.getCounterIF());
        System.out.println("Modified counter: " + splay.getCounterSWAP());
        System.out.println("Time complexity of insert: " + t1 + "ms");

        t1 = System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s : data
        ) {
            x = generator.nextInt(modifiedData.size());
            splay.find(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis() - t1) + "ms");
        t1 = System.currentTimeMillis();

        for (String s : data
        ) {
            splay.remove(s);
        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis() - t1) + "ms");

        System.out.println();
        System.out.println("BST tree data: Ins:" + binarySearchTree.getcI() + " Del:" + binarySearchTree.getcD() + " Src:" + binarySearchTree.getcS());
        System.out.println("Capatity: " + binarySearchTree.capatity());
        System.out.println("If counter: " + binarySearchTree.getCounterIF());
        System.out.println("Modified counter: " + binarySearchTree.getCounterSWAP()); // liczba taka sama jak cap bo tylko każdemu sie dodaje jako lewy / prawy zamiast nulla , bez zmian struktury
        System.out.println("Time complexity of insert: " + t2 + "ms");
        t1 = System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s : data
        ) {
            x = generator.nextInt(modifiedData.size());
            binarySearchTree.search(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis() - t1) + "ms");

        t1 = System.currentTimeMillis();
        for (String s : data
        ) {

            binarySearchTree.delete(s);
        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis() - t1) + "ms");


        System.out.println();
        System.out.println("RBT tree data: Ins:" + binarySearchTree.getcI() + " Del:" + binarySearchTree.getcD() + " Src:" + binarySearchTree.getcS());
        System.out.println("Capatity: " + redBlackTree.size());
        System.out.println("If counter: " + redBlackTree.getCounterIF());
        System.out.println("Modified counter: " + redBlackTree.getCounterSWAP());
        System.out.println("Time complexity of insert: " + t3 + "ms");
        t1 = System.currentTimeMillis();
        modifiedData.addAll(data);
        for (String s : data
        ) {
            x = generator.nextInt(modifiedData.size());
            redBlackTree.search(modifiedData.get(x));
            modifiedData.remove(x);
        }
        System.out.println("Time complexity of search: " + (System.currentTimeMillis() - t1) + "ms");
        t1 = System.currentTimeMillis();

        for (String s : data
        ) {

            redBlackTree.remove(s);

        }
        System.out.println("Time complexity of delete: " + (System.currentTimeMillis() - t1) + "ms");


    }


}
