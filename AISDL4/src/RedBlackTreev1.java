import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class RedBlackTreev1 {

    private RBNode root;
    private int capatity;

    private long counterSWAP = 0;
    private long counterIF = 0;
    private long cS = 0;
    private long cI = 0;
    private long cD = 0;

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




    public ArrayList<RBNode> nodes = new ArrayList<>();

    public void isBugged() {
        for (RBNode r : nodes
        ) {
            if (!r.color) {
                if (r.parent != null && !r.parent.color)
                    System.out.println("bugged");
                if (r.left != null && !r.left.color)
                    System.out.println("bugged");
                if (r.right != null && !r.right.color)
                    System.out.println("bugged");
            }
        }
    }

    public RedBlackTreev1() {
        this.capatity = 0;
    }

    public int capatity() {
        return capatity;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(Comparable a) {
        cI++;
        if (isEmpty()) {
            capatity++;
            root = new RBNode(a, true);
        } else {
            RBNode node = new RBNode(a, false);
            capatity++;
            nodes.add(node);
            downheap(node, root);
            insertFixUp(node);
        }
    }

    private void insertFixUp(RBNode node) {
        RBNode y;
        while (node.parent != null && !node.parent.color) {
            counterIF++;

            if (node.parent.parent.left != null && node.parent == node.parent.parent.left) {
                counterIF++;
                y = node.parent.parent.right;
                if (y != null && !y.color) {
                    counterSWAP += 3;
                    counterIF++;
                    node.parent.setColor(true);
                    y.changeColor();
                    node.parent.parent.setColor(false);
                    node = node.parent.parent;
                } else {
                    counterIF += 2;
                    if (node == node.parent.right) {

                        node = node.parent;
                        insertLeftRotate(node);
                    }
                    counterSWAP += 2;
                    node.parent.setColor(true);
                    node.parent.parent.setColor(false);
                    insertRightRotate(node.parent.parent);
                }

            } else if (node.parent.parent.right != null && node.parent == node.parent.parent.right) {
                counterIF += 3;
                {

                    y = node.parent.parent.left;
                    if (y != null && !y.color) {
                        counterSWAP += 3;
                        node.parent.setColor(true);
                        y.setColor(true);
                        node.parent.parent.setColor(false);
                        node = node.parent.parent;
                    } else {
                        counterIF++;
                        if (node == node.parent.left) {
                            node = node.parent;
                            insertRightRotate(node);
                        }
                        counterSWAP += 2;
                        node.parent.setColor(true);
                        node.parent.parent.setColor(false);
                        insertLeftRotate(node.parent.parent);
                    }

                }
            }
        }
        root.setColor(true);
    }

    private void insertRightRotate(RBNode x) {
        counterSWAP++;
        RBNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
            counterSWAP++;
        }
        counterSWAP++;
        y.parent = x.parent;
        counterIF++;
        if (x.parent == null) {
            counterIF++;
            this.root = y;
        } else if (x == x.parent.right) {
            counterSWAP++;
            counterIF += 2;
            x.parent.right = y;
        } else {
            counterSWAP++;
            counterIF += 2;
            x.parent.left = y;
        }
        counterSWAP += 2;
        y.right = x;
        x.parent = y;

    }

    private void insertLeftRotate(RBNode node) {
        counterSWAP++;
        RBNode y = node.right;
        node.right = y.left;
        if (y.left != null && y.left.parent != null) {
            y.left.parent = node;
            counterSWAP++;
        }
        counterIF++;
        if (y.parent != null) {
            y.parent = node.parent;
            counterSWAP++;
        }
        counterIF++;
        if (node.parent == null)
            root = y;
        else if (node == node.parent.left) {
            node.parent.left = y;
            counterSWAP++;
            counterIF++;
        } else {
            node.parent.right = y;
            counterSWAP++;
            counterIF++;
        }
        counterSWAP += 2;
        counterIF++;
        y.left = node;
        node.parent = y;
    }

    private void downheap(RBNode node, RBNode actual) {
        if (node.compareTo(actual) < 0) {
            counterIF++;
            if (actual.left() == null) {
                counterIF++;
                counterSWAP++;
                actual.setLeft(node);
                node.setParent(actual);
            } else {
                downheap(node, actual.left());
                counterIF++;
            }
        } else if (node.compareTo(actual) > 0) {
            counterIF += 2;
            if (actual.right() == null) {
                counterIF++;
                counterSWAP++;
                actual.setRight(node);
                node.setParent(actual);
            } else {
                downheap(node, actual.right());
                counterIF++;
            }
        } else capatity--;
    }


    public void inorder() {
        int i = 0;
        inorder(root, i);
        System.out.println();
    }

    private void inorder(RBNode root, int i) { // i oznacza poziom w drzewie
        if (root != null) {
            i++;
            inorder(root.left(), i);
            if (root.color)
                System.out.print("{" + root.getKey() + ", " + root.parent + ",black " + i + "} ");
            else
                System.out.print("{" + root.getKey() + ", " + root.parent + ",red " + i + "} ");
            inorder(root.right(), i);
        }
    }

    public void clear() {
        root = null;
        capatity = 0;
    }

    private RBNode findNode(RBNode findNode, RBNode node) {
        cS++;
        counterIF++;
        if (root == null) {
            return null;
        }
        counterIF++;
        if (findNode.compareTo(node) < 0) {
            if (node.left != null) {
                return findNode(findNode, node.left);
            }
        } else if (findNode.compareTo(node) > 0) {
            counterIF++;
            if (node.right != null) {
                return findNode(findNode, node.right);
            }
        } else if (findNode.key == node.key) {
            counterIF += 2;
            return node;
        }
        return null;
    }


    private void fixDelColor(RBNode x) {

            while (x != root && x.color) {
                counterIF++;
                if (x == x.parent.left) {
                    counterIF += 2;
                    RBNode w = x.parent.right;
                    if (!w.color) {
                        counterSWAP += 2;
                        w.changeColor();
                        x.parent.setColor(false);
                        deleteRotateLeft(x.parent);
                        w = x.parent.right;
                    }
                    if (w.left.color && w.right.color) {
                        counterSWAP++;
                        w.setColor(false);
                        x = x.parent;
                        continue;
                    } else if (w.right.color) {
                        counterSWAP += 2;
                        counterIF++;
                        w.left.setColor(true);
                        w.setColor(false);
                        deleteRotateRight(w);
                        w = x.parent.right;
                    }
                    counterIF++;
                    if (!w.right.color) {
                        counterSWAP += 3;
                        w.color = x.parent.color;
                        x.parent.setColor(true);
                        w.right.setColor(true);
                        deleteRotateLeft(x.parent);
                        x = root;
                    }
                } else {
                    counterIF += 2;
                    RBNode w = x.parent.left;
                    if (!w.color) {
                        counterSWAP += 2;
                        w.setColor(true);
                        x.parent.setColor(false);
                        deleteRotateRight(x.parent);
                        w = x.parent.left;
                    }
                    if (w.right.color && w.left.color) {
                        counterSWAP++;
                        w.setColor(false);
                        x = x.parent;
                        continue;
                    } else if (w.left.color) {
                        counterSWAP += 2;
                        counterIF++;
                        w.right.setColor(true);
                        w.setColor(false);
                        deleteRotateLeft(w);
                        w = x.parent.left;
                    }
                    counterIF++;
                    if (!w.left.color) {
                        counterSWAP += 3;
                        w.color = x.parent.color;
                        x.parent.setColor(true);
                        w.left.setColor(true);
                        deleteRotateRight(x.parent);
                        x = root;
                    }
                }
            }
            x.color = true;

    }

    private RBNode treeMinimum(RBNode subTreeRoot)  // minimum w danym poddrzewie
    {
        while (subTreeRoot.left != null) {
            counterIF++;
            subTreeRoot = subTreeRoot.left;
        }
        return subTreeRoot;
    }

    private void replace(RBNode target, RBNode with) {

            if (target.parent == null) {
                counterIF++;
                root = with;
            } else if (target == target.parent.left) {
                counterSWAP++;
                counterIF += 2;
                target.parent.left = with;
            } else {
                counterIF += 2;
                counterSWAP += 2;
                target.parent.right = with;
            }
            with.parent = target.parent;

    }


    private void deleteRotateLeft(RBNode node) {
        if (node.parent != null) {
            counterIF++;
            if (node == node.parent.left) {
                counterSWAP++;
                node.parent.left = node.right;
            } else {
                counterSWAP++;
                node.parent.right = node.right;
            }
            counterIF += 2;
            counterSWAP += 2;
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != null) {
                node.right.left.parent = node;
                counterSWAP++;
            }
            counterSWAP += 2;
            node.right = node.right.left;
            node.parent.left = node;
        } else {
            counterIF++;
            counterSWAP += 5;
            RBNode right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = null;
            root = right;
        }
    }

    private void deleteRotateRight(RBNode node) {
        if (node.parent != null) {
            counterIF++;
            if (node == node.parent.left) {
                counterSWAP++;
                node.parent.left = node.left;
            } else {
                counterSWAP++;
                node.parent.right = node.left;
            }
            counterIF += 2;
            counterSWAP += 2;
            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != null) {
                node.left.right.parent = node;
                counterSWAP++;
            }
            counterSWAP += 2;
            node.left = node.left.right;
            node.parent.right = node;
        } else {
            counterSWAP += 5;
            counterIF++;
            RBNode left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = null;
            root = left;
        }
    }

    public RBNode search(Comparable a) {
        cS++;
        if (!isEmpty()) {
            RBNode node = root;
            while (node != null && a.compareTo(node.getKey()) != 0) {
                counterIF++;
                if (a.compareTo(node.getKey()) < 0){
                    node = node.left();   counterIF++;}
                else if (a.compareTo(node.getKey()) > 0){
                    node = node.right();   counterIF+=2; }
                else{counterIF+=2; break;
                }}
            if (node != null)
                return node;
        }
        return null;
    }



    private class RBNode<T extends Comparable<T>> implements Comparable<RBNode> {

        private T key;
        private RBNode left, right, parent;
        private boolean color;      // czarny to true czerwony false

        RBNode(T key, boolean b) {
            this.key = key;
            this.color = b;
        }

        public RBNode(T a) {
            this.key = a;
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