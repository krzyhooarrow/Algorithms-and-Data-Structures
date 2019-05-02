@SuppressWarnings("Duplicates")
public class RedBlackTree {

    private int capatity;
    private RBNode root;

    public RedBlackTree() {
        this.capatity = 0;
    }

    public int size() {
        return capatity;
    }

    public boolean isEmpty() {
        return capatity == 0;
    }

    public void insert(Comparable a) {
        if (isEmpty()) {
            root = new RBNode(a, true);
        } else {
            RBNode node = new RBNode(a, false);
            downheap(node, root);
            fixUp(node);
        }
        capatity++;
    }



    private void fixUp(RBNode node) {
        RBNode y;
        while (node.parent != null && !node.parent.color) {
            if (node.parent.parent.left != null && node.parent == node.parent.parent.left) {

                y = node.parent.parent.right;
                    if (y!=null &&!y.color) {
                        node.parent.setColor(true);
                        y.changeColor();
                        node.parent.parent.setColor(false);
                        node = node.parent.parent;
                    } else {
                        if (node == node.parent.right) {
                            node = node.parent;
                            leftRotate(node);
                        }
                        node.parent.setColor(true);
                        node.parent.parent.setColor(false);
                        rightRotate(node.parent.parent);
                    }

            } else if (node.parent.parent.right != null && node.parent == node.parent.parent.right) {
                {

                    y = node.parent.parent.left;
                        if (y!=null && !y.color) {
                            node.parent.setColor(true);
                            y.setColor(true);
                            node.parent.parent.setColor(false);
                            node = node.parent.parent;
                        } else {
                            if (node == node.parent.left) {
                                node = node.parent;
                                rightRotate(node);
                            }
                            node.parent.setColor(true);
                            node.parent.parent.setColor(false);
                            leftRotate(node.parent.parent);
                        }

                }
            }
        }
        root.setColor(true);
    }

    private void rightRotate(RBNode x) {

        RBNode y = x.left;
        x.left = y.right;
        if(y.right != null){
            y.right.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;
        }
        else if(x == x.parent.right){
            x.parent.right = y;
        }
        else{
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

    }

    private void leftRotate(RBNode node) {
        RBNode y = node.right;
        node.right = y.left;
        if (y.left!=null && y.left.parent!=null)
        y.left.parent=node;
        if (y.parent!=null)
        y.parent = node.parent;
        if (node.parent==null)
            root=y;
        else if (node==node.parent.left)
            node.parent.left=y;
        else node.parent.right=y;
        y.left = node;
        node.parent=y;



    }


    private void downheap(RBNode node, RBNode actual) {
        if (node.compareTo(actual) < 0) {
            if (actual.left() == null) {
                actual.setLeft(node);
                node.setParent(actual);
            } else
                downheap(node, actual.left());
        } else if (node.compareTo(actual) >= 0) {
            if (actual.right() == null) {
                actual.setRight(node);
                node.setParent(actual);
            } else
                downheap(node, actual.right());
        }
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(RBNode root) {
        if (root != null) {
            inorder(root.left());
            if (root.color)
                System.out.print("{" + root.getKey() + ", " + root.parent + ",black" + "} ");
            else
                System.out.print("{" + root.getKey() + ", " + root.parent + ",red" + "} ");
            inorder(root.right());
        }

    }

    public void clear() {
        root=null;
        capatity=0;
    }


    private class RBNode<T extends Comparable<T>> implements Comparable<RBNode> {

        private T key;
        private RBNode left, right, parent;
        private boolean color;      // czarny to true czerwony false

        RBNode(T key, boolean b) {
            this.key = key;
            this.color = b;
        }

        public RBNode(T a) {this.key = a;
        }

        T getKey() {
            return key;
        }

        RBNode left() {
            return left;
        }

        void setLeft(RBNode left) {
            this.left = left;
        }

        RBNode right() {
            return right;
        }

        void setRight(RBNode right) {
            this.right = right;
        }


        void setParent(RBNode parent) {
            this.parent = parent;
        }


        void setColor(boolean b) {
            this.color = b;
        }

        void changeColor() {
            color = !color;
        }

        @Override
        public int compareTo(RBNode o) {
            return this.key.compareTo((T) o.key);
        }

        @Override
        public String toString() {
            return key.toString();
        }
    }


}
