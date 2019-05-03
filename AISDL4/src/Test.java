import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random generator = new Random();


//
        SplayTree splay = new SplayTree();
        splay.insert(31);
        splay.insert(36);
        for (int i=0 ;i<50 ; i++)
        splay.insert(generator.nextInt(50));
        splay.inorder();
                                // skraca sie bo sie zmienia budowa drzewa , nic sie nie usuwa
        splay.find(31);
        splay.find(36);
        splay.inorder();
        System.out.println(splay.size());

////        BinarySearchTree binarySearchTree = new BinarySearchTree();
////        binarySearchTree.insert(25);
////        for (int i = 0; i < 50; i++) {
////            binarySearchTree.insert(generator.nextInt(50));
////            binarySearchTree.insert(25);
////
////            binarySearchTree.inorder();
//
//            RedBlackTree redBlackTree = new RedBlackTree();
//            redBlackTree.insert(25);
//            for (int i = 0; i < 500; i++)
//                redBlackTree.insert(generator.nextInt(50));
//                redBlackTree.insert(25);
//
//                redBlackTree.inorder();
////        FileParser fileParser = new FileParser();
////        System.out.println(fileParser.parseFile("/home/krzyhoo/Desktop/AISDL4/src/fileparsertest"));
//
//
//            redBlackTree.isBugged();


//        System.out.println(redBlackTree.capatity());
    }


}
