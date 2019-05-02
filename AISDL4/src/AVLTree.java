@SuppressWarnings("Duplicates")
public class AVLTree {

    private int capatity;
    private AVLNode root;

    public int size(){return capatity;}

    public boolean isEmpty(){return capatity==0;}

    public AVLTree() {capatity = 0;}


//    public void insert(Comparable a) {
//        if (isEmpty()) {
//            root = new AVLNode(a);
//        } else {
//            downheap(new AVLNode(a), root);
//        }
//        capatity++;
//    }
//
//    private void downheap(AVLNode node, AVLNode actual) {
//        if (node.compareTo(actual) < 0) {
//            if (actual.left() == null)
//                actual.setLeft(node);
//            else
//                downheap(node, actual.left());
//        } else if (node.compareTo(actual) >= 0) {
//            if (actual.right() == null)
//                actual.setRight(node);
//            else
//                downheap(node, actual.right());
//        }
//    }






    private class AVLNode<T extends Comparable<T>> implements Comparable<AVLNode> {
        private T key;
        private int height;
        private AVLNode left, right;

        AVLNode(T key) {
            this.key = key;
        }

        T getKey() {
            return key;
        }

        void setKey(T key) {
            this.key = key;
        }

        int getHeight() {
            return height;
        }

        void setHeight(int height) {
            this.height = height;
        }

        AVLNode left() {
            return left;
        }

        void setLeft(AVLNode left) {
            this.left = left;
        }

        AVLNode right() {
            return right;
        }

        void setRight(AVLNode right) {
            this.right = right;
        }

        @Override
        public int compareTo(AVLNode o) {
            return this.key.compareTo((T) o.key);
        }
    }

}
