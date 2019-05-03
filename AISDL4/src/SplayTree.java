import jdk.nashorn.internal.ir.BinaryNode;

@SuppressWarnings("Duplicates")
public class SplayTree {
    private  SNode header = new SNode(null);
    private SNode root;
    private int capatity;

    public int size() {
        return capatity;
    }

    public boolean isEmpty() {
        return capatity == 0;
    }


    public void insert(Comparable key) {
        SNode n;
        int c;
        if (root == null) {
            capatity++;
            root = new SNode(key);
            return;
        }
        splay(key);
        if ((c = key.compareTo(root.key)) == 0) { // czy w tym drzewie są duplikaty?
            return;
        }
        capatity++;
        n = new SNode(key);
        if (c < 0) {
            n.left = root.left;
            n.right = root;
            root.left = null;
        } else {
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
        for (;;) {
            if (key.compareTo(t.key) < 0) {
                if (t.left == null) break;
                if (key.compareTo(t.left.key) < 0) {
                    y = t.left;                           //rightrot
                    t.left = y.right;
                    y.right = t;
                    t = y;
                    if (t.left == null) break;
                }
                r.left = t;                                 //link right
                r = t;
                t = t.left;
            } else if (key.compareTo(t.key) > 0) {
                if (t.right == null) break;
                if (key.compareTo(t.right.key) > 0) {
                    y = t.right;                            //left rot
                    t.right = y.left;
                    y.left = t;
                    t = y;
                    if (t.right == null) break;
                }
                l.right = t;                                //left link
                l = t;
                t = t.right;
            } else {
                break;
            }
        }
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

    public boolean find(Comparable key) {
        if (root == null) return false;
        splay(key);
        if(root.key.compareTo(key) != 0) return false;
        return true;
    }


    public void remove(Comparable key) {
        SNode x;
        splay(key);
        if (key.compareTo(root.key) != 0) {

            return;
        }
        capatity--;
        if (root.left == null) {
            root = root.right;
        } else {
            x = root.right;
            root = root.left;
            splay(key);
            root.right = x;
        }
    }

    private class SNode<T extends Comparable<T>> implements Comparable<SNode> {
        private T key;

        private SNode left, right;

        SNode(T key) {
            this.key = key;
        }

        T getKey() {
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
