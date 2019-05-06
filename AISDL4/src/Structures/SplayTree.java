package Structures;

@SuppressWarnings("Duplicates")
public class SplayTree {
    private  SNode header = new SNode(null);
    private SNode root;
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

    public int size() {
        return capatity;
    }

    public boolean isEmpty() {
        return capatity == 0;
    }


    public void insert(Comparable key) {
        cI++;
        SNode n;
        int c;
        counterIF++;
        if (root == null) {
            capatity++;
            root = new SNode(key);
            return;
        }
        splay(key);
        counterIF++;
        if ((c = key.compareTo(root.key)) == 0) { // czy w tym drzewie są duplikaty?
            return;
        }
        capatity++;
        counterIF++;
        n = new SNode(key);
        if (c < 0) {
            counterSWAP+=3;
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
            counterSWAP+=3;
            n.right = root.right;
            n.left = root;
            root.right = null;
        }
        root = n;
    }

     private void splay(Comparable key) {

        SNode l, r, t, y;
        l = r = header;
        t = root;
        header.left = header.right = null;
        while (true) {
            if (key.compareTo(t.key) < 0) {
                counterIF+=2;
                if (t.left == null) break;
                counterIF++;
                if (key.compareTo(t.left.key) < 0) {
                    counterSWAP+=2;
                    y = t.left;                           //rightrot
                    t.left = y.right;
                    y.right = t;
                    t = y;
                    counterIF++;
                    if (t.left == null) break;
                }
                counterSWAP++;
                r.left = t;                                 //link right
                r = t;
                t = t.left;
            } else if (key.compareTo(t.key) > 0) {
                counterIF+=3;
                if (t.right == null) break;
                counterIF++;
                if (key.compareTo(t.right.key) > 0) {
                    counterSWAP+=2;
                    y = t.right;                            //left rot
                    t.right = y.left;
                    y.left = t;
                    t = y;
                    counterIF++;
                    if (t.right == null) break;
                }
                counterSWAP++;
                l.right = t;                                //left link
                l = t;
                t = t.right;
            } else {counterIF+=2;
                break;
            }
        }
        counterSWAP+=4;
        l.right = t.left;
        r.left = t.right;
        t.left = header.right;
        t.right = header.left;
        root = t;
    }


    public void inorder() {
         int i=0;
        inorder(root,i);
        System.out.println();
    }

    private void inorder(SNode root,int i) { // i oznacza poziom w drzewie
        if (root != null) {
            i++;
            inorder(root.left(),i);
            System.out.print(root.getKey() + "{" + i+"} ");
            inorder(root.right(),i);
        }
    }

    public SNode find(Comparable key) {
        cS++;
        if (root == null) return null;
        splay(key);
        if(root.key.compareTo(key) != 0) return null;
        return root;
    }


    public void remove(Comparable key) {
        cD++;
        SNode x;
        splay(key);
        counterIF++;
        if (key.compareTo(root.key) != 0) {

            return;
        }
        capatity--;
        counterIF++;
        if (root.left == null) {
            counterSWAP++;
            root = root.right;
        } else {
            counterSWAP++;
            x = root.right;
            root = root.left;
            splay(key);
            root.right = x;
        }
    }

    public void clear() {root=null; capatity=0;
    }

    public class SNode<T extends Comparable<T>> implements Comparable<SNode> {
        private T key;

        private SNode left, right;

        SNode(T key) {
            this.key = key;
        }

        public T getKey() {
            return key;
        }

        void setKey(T key) {
            this.key = key;
        }

        SNode left() {
            return left;
        }

        SNode right() {
            return right;
        }

        @Override
        public int compareTo(SNode o) {
            return this.key.compareTo((T) o.key);
        }
    }


}
