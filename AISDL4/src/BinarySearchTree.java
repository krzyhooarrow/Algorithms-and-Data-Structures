@SuppressWarnings("Duplicates")
public class BinarySearchTree {

    private int capatity;
    private Node root;

    public BinarySearchTree() {
        capatity = 0;
    }

    public int size() {
        return capatity;
    }

    public void insert(Comparable a) {
        if (isEmpty()) {
            root = new Node(a);
        } else {
            downheap(new Node(a), root);
        }
        capatity++;
    }

    public boolean isEmpty() {
        return capatity == 0;
    }

    private void downheap(Node node, Node actual) {
        if (node.compareTo(actual) < 0) {
            if (actual.left() == null)
                actual.setLeft(node);
            else
                downheap(node, actual.left());
        } else if (node.compareTo(actual) >= 0) {
            if (actual.right() == null)
                actual.setRight(node);
            else
                downheap(node, actual.right());
        }
    }


    public void inorder() {
        int i=0;
        inorder(root,i);
        System.out.println();
    }

    private void inorder(Node root,int i) { // i oznacza poziom w drzewie
        if (root != null) {
            i++;
            inorder(root.left(),i);
            System.out.print(root.getKey() + "{" + i+"} ");
            inorder(root.right(),i);
        }
    }

    public boolean search(Comparable a) {

        if (!isEmpty()) {
            Node node = root;
            while (node != null && a.compareTo(node.getKey()) != 0) {

                if (a.compareTo(node.getKey()) < 0)
                    node = node.left();
                else if (a.compareTo(node.getKey()) > 0)
                    node = node.right();
                else break;
            }
            if (node != null)
                return true;
        }
        return false;
    }

    void delete(Comparable key) {
        root = del(root, key);
    }

    private Node del(Node root, Comparable key) {
        //puste
        if (root == null) return root;

        if (key.compareTo(root.getKey()) < 0)
            root.setLeft(del(root.left(), key));
        else if (key.compareTo(root.getKey()) > 0)
            root.setRight(del(root.right(), key));
        else {
            if (root.left() == null)
                return root.right();
            else if (root.right() == null)
                return root.left();

            root.setKey(minValue(root.right()));
            root.setRight(del(root.right(), root.getKey()));
        }

        return root;
    }

    private Comparable minValue(Node root)  // min wartosc w poddrzewie
    {
        Comparable minv = root.getKey();
        while (root.left() != null) {
            minv = root.left().getKey();
            root = root.left();
        }
        return minv;
    }

    private class Node<T extends Comparable<T>> implements Comparable<Node> {
        private T key;
        private Node left, right;

        Node(T key) {
            this.key = key;
        }

        void setKey(T key) {
            this.key = key;
        }

        T getKey() {
            return key;
        }

        Node left() {
            return left;
        }

        void setLeft(Node left) {
            this.left = left;
        }

        Node right() {
            return right;
        }

        void setRight(Node right) {
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return this.key.compareTo((T) o.key);
        }

        @Override
        public String toString() {
            return key.toString();

        }
    }

}

