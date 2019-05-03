import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Random generator = new Random();






//        SplayTree splay = new SplayTree();
//        splay.insert(31);
////        for (int i=0 ;i<50 ; i++)
////        splay.insert(generator.nextInt(50));
//        splay.inorder();
//        splay.insert(31);
//        splay.insert(31);
//        splay.insert(31);
//        splay.find(31);
//        splay.inorder();

        FileParser fileParser = new FileParser();
        System.out.println(fileParser.parseFile("/home/krzyhoo/Desktop/AISDL4/src/fileparsertest"));


    }
}



