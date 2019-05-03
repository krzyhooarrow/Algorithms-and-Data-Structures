import jdk.nashorn.internal.ir.BinaryNode;

@SuppressWarnings("Duplicates")
public class SplayTree {

    private SNode root;
    private int capatity;

    public int size() {
        return capatity;
    }

    public boolean isEmpty() {
        return capatity == 0;
    }

    public boolean search(Comparable a) {
        if (!isEmpty()) {
            SNode node = root;
            SNode toSplay=node;
            while (node != null && a.compareTo(node.getKey()) != 0) {
                if (a.compareTo(node.getKey()) < 0)
                    node = node.left();
                else if (a.compareTo(node.getKey()) > 0)
                    node = node.right();
                else break;
                if (node!=null)toSplay=node;
            }
//            splay(toSplay);
            if (node != null)
                return true;
        }
        return false;
    }




    public void insert(Comparable key) {
        SNode n;
        int c;
        if (root == null) {
            root = new SNode(key);
            return;
        }
        splay(key);
        if ((c = key.compareTo(root.key)) == 0) {
            //	    throw new DuplicateItemException(x.toString());
            return;
        }
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
    private  SNode header = new SNode(null);

     private void splay(Comparable key) {
        SNode l, r, t, y;
        l = r = header;
        t = root;
        header.left = header.right = null;
        for (;;) {
            if (key.compareTo(t.key) < 0) {
                if (t.left == null) break;
                if (key.compareTo(t.left.key) < 0) {
                    y = t.left;                            /* rotate right */
                    t.left = y.right;
                    y.right = t;
                    t = y;
                    if (t.left == null) break;
                }
                r.left = t;                                 /* link right */
                r = t;
                t = t.left;
            } else if (key.compareTo(t.key) > 0) {
                if (t.right == null) break;
                if (key.compareTo(t.right.key) > 0) {
                    y = t.right;                            /* rotate left */
                    t.right = y.left;
                    y.left = t;
                    t = y;
                    if (t.right == null) break;
                }
                l.right = t;                                /* link left */
                l = t;
                t = t.right;
            } else {
                break;
            }
        }
        l.right = t.left;                                   /* assemble */
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


//    private SNode splay(SNode root, Comparable key) {
//        SNode temp = new SNode(key);
//
//        if (root==null || root.key ==key)
//            return root;
//        if (root.compareTo(temp)>0){
//            if (root.left==null)return root;
//
//            if (root.left.compareTo(temp)>0){
//                root.left.left=splay(root.left.left,key);
//                root = rightRotate(root);
//            }else if (root.left.compareTo(temp) <0){
//            root.left.right = splay(root.left.right,key);
//
//            if (root.left.right !=null)
//                root.left = leftRotate(root.left);
//            }
//
//return root.left == null;
//
//        }
//    }
//
//    private SNode leftRotate(SNode left) {
//    }
//
//    private SNode rightRotate(SNode root) {
//    }
//
//
//    public void insert(Comparable a) {
//        SNode sNode = new SNode(a);
//        if (isEmpty())
//            root = sNode;
//        else {
//        ins(sNode);
//        }
//    }
//
//    private void ins(SNode sNode) {
//
//    }
//
//    private void zig(SNode sNode){ // od parenta
//        SNode g = sNode.parent.parent;
//        sNode.parent.left=sNode.right;
//        sNode.right.parent=sNode.parent;
//
//        sNode.right=sNode.parent;
//        sNode.parent=g;
//
//
//    }


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
