import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random generator = new Random();


        BinarySearchTree bst = new BinarySearchTree();
//        bst.insert(1);
//        bst.insert(5);
//        bst.insert(6);
//        bst.insert(12);
//        bst.insert(25);
//        bst.insert(423);
//        bst.insert(22);

        for (int i =0 ;i <30 ; i ++){
            bst.insert(i%4);
        }
        bst.insert(5);
        bst.inorder();

bst.deleteKey(1);


        bst.inorder();
//        bst.printTree();


// wszystko działa jak narazie git delete left

//        bst.delete("AEFD");
//        bst.insert("a");
//        bst.insert("b");
//        bst.insert("c");
//        bst.insert("d");
//        bst.insert("e");
//        bst.insert("f");
//        bst.printTree();
    }
}
