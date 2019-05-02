import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random generator = new Random();

//        BinarySearchTree bst = new BinarySearchTree();
//
//        for (int i =0 ;i <30 ; i ++){
//            bst.insert(i%4);
//        }
//        bst.insert(5);
//        bst.inorder();
//        bst.deleteKey(1);
//        bst.inorder();\


        RedBlackTree redBlackTree = new RedBlackTree();


        for (int k = 0; k < 10000; k++) {

            for (int i = 0; i < 200; i++)
                redBlackTree.insert(generator.nextInt(100));


//            redBlackTree.inorder();
            System.out.println(redBlackTree.size());
//            redBlackTree.clear();

        }
    }
}



