package Structures;

@SuppressWarnings("Duplicates")
public class BinarySearchTree {

    private Node root;
    private int capatity;

    private long counterSWAP = 0;
    private long counterIF =0;
    private long counterCHANGES=0;
    private long cS=0;
    private long cI=0;
    private long cD=0;

    public long getcS() {
        return cS;
    }

    public long getcI() {
        return cI;
    }

    public long getcD() {
        return cD;
    }

    public long getCounterSWAP() {
        return counterSWAP;
    }

    public long getCounterIF() {
        return counterIF;
    }

    public long getCounterCHANGES() {
        return counterCHANGES;
    }

    public void insert(Comparable a) {
        cI++;
        if (isEmpty()) {capatity++;
            root = new Node(a);
        } else {
            capatity++;
            downheap(new Node(a), root);
        }
    }

    public int capatity(){return capatity;}

    public BinarySearchTree() {this.capatity=0;}

    public boolean isEmpty() {
        return root==null;
    }

    private void downheap(Node node, Node actual) {
        if (node.compareTo(actual) < 0) {
            counterIF+=2;
            if (actual.left() == null){
                counterSWAP++;
                actual.setLeft(node);}
            else
                downheap(node, actual.left());
        } else if (node.compareTo(actual) > 0) {
            counterIF+=3;
            if (actual.right() == null){
                actual.setRight(node);
            counterSWAP++;}
            else
                downheap(node, actual.right());
        }else          capatity--;
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
        cS++;
        if (!isEmpty()) {
            Node node = root;
            while (node != null && a.compareTo(node.getKey()) != 0) {
                counterIF++;
                if (a.compareTo(node.getKey()) < 0){
                    node = node.left();   counterIF++;}
                else if (a.compareTo(node.getKey()) > 0){
                    node = node.right();   counterIF+=2; }
                else{counterIF+=2; break;
            }}
            if (node != null)
                return true;
        }
        return false;
    }

    public void delete(Comparable key) {
        cD++;
        root = del(root, key);
    }

    private Node del(Node root, Comparable key) {
        //puste

        if (root == null) {
         counterIF++;   return null;
        }
        if (key.compareTo(root.getKey()) < 0){
            root.setLeft(del(root.left(), key));
            counterSWAP++;
        counterIF+=2;
        }
        else if (key.compareTo(root.getKey()) > 0){
            root.setRight(del(root.right(), key));
            counterSWAP++;
        counterIF+=3;
        }
        else {
            capatity--;
            if (root.left() == null){
                counterIF+=4;
                return root.right();}
            else if (root.right() == null){
                counterIF+=5;
                return root.left();}

            root.setKey(minValue(root.right()));
            counterSWAP+=2;
            root.setRight(del(root.right(), root.getKey()));
        }

        return root;
    }

    private Comparable minValue(Node root)  // min wartosc w poddrzewie
    {
        Comparable minv = root.getKey();
        while (root.left() != null) {
            counterIF++;
            minv = root.left().getKey();
            root = root.left();
        }
        return minv;
    }

    public void clear() {root=null; capatity=0;
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


