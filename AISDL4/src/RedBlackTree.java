import java.util.ArrayList;

@SuppressWarnings("Duplicates")
public class RedBlackTree {

    private RBNode root;
    private int capatity;

    private long counterSWAP = 0;
    private long counterIF = 0;
    private long counterCHANGES = 0;


    public long getCounterSWAP() {
        return counterSWAP;
    }

    public long getCounterIF() {
        return counterIF;
    }

    public long getCounterCHANGES() {
        return counterCHANGES;
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

    public RedBlackTree() {
        this.capatity = 0;
    }

    public int capatity() {
        return capatity;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(Comparable a) {
        if (isEmpty()) {capatity++;
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
                    node.parent.setColor(true);
                    node.parent.parent.setColor(false);
                    insertRightRotate(node.parent.parent);
                }

            } else if (node.parent.parent.right != null && node.parent == node.parent.parent.right) {
                counterIF += 3;
                {

                    y = node.parent.parent.left;
                    if (y != null && !y.color) {
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

        RBNode y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        counterIF++;
        if (x.parent == null) {
            counterIF++;
            this.root = y;
        } else if (x == x.parent.right) {
            counterIF += 2;
            x.parent.right = y;
        } else {
            counterIF += 2;
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;

    }

    private void insertLeftRotate(RBNode node) {
        RBNode y = node.right;
        node.right = y.left;
        if (y.left != null && y.left.parent != null)
            y.left.parent = node;
        counterIF++;
        if (y.parent != null)
            y.parent = node.parent;
        counterIF++;
        if (node.parent == null)
            root = y;
        else if (node == node.parent.left) {
            node.parent.left = y;
            counterIF++;
        } else {
            node.parent.right = y;
            counterIF++;
        }
        counterIF++;
        y.left = node;
        node.parent = y;
    }

    private void downheap(RBNode node, RBNode actual) {
        if (node.compareTo(actual) < 0) {
            counterIF++;
            if (actual.left() == null) {
                counterIF++;
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

    public RBNode findNode(RBNode findNode, RBNode node) {
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
            counterIF+=2;
            return node;
        }
        return null;
    }


    public boolean delete(Comparable a) {
        RBNode z = new RBNode(a);
        counterIF++;
        if ((z = findNode(z, root)) == null)
            return false;
        RBNode x;
        RBNode y = z;
        boolean yc = y.color;
        counterIF++;
        if (z.left == null) {
            x = z.right;
            replace(z, z.right);
        } else if (z.right == null) {
            counterIF++;
            x = z.left;
            replace(z, z.left);
        } else {
            counterIF++;
            y = treeMinimum(z.right);
            yc = y.color;
            x = y.right;
            counterIF++;
            if (y.parent == z)
                x.parent = y;
            else {
                replace(y, y.right);
                y.right = z.right;
                y.right.parent = y;
            }
            replace(z, y);
            y.left = z.left;
            y.left.parent = y;
            y.color = z.color;
        }
        counterIF++;
        if (yc)
            fixDelColor(x);
        return true;
    }

    private void fixDelColor(RBNode x) {
        while (x != root && x.color) {
            counterIF++;
            if (x == x.parent.left) {
                counterIF+=2;
                RBNode w = x.parent.right;
                if (!w.color) {
                    w.changeColor();
                    x.parent.setColor(false);
                    deleteRotateLeft(x.parent);
                    w = x.parent.right;
                }
                if (w.left.color && w.right.color) {
                    w.setColor(false);
                    x = x.parent;
                    continue;
                } else if (w.right.color) {
                    counterIF++;
                    w.left.setColor(true);
                    w.setColor(false);
                    deleteRotateRight(w);
                    w = x.parent.right;
                }
                counterIF++;
                if (!w.right.color) {
                    w.color = x.parent.color;
                    x.parent.setColor(true);
                    w.right.setColor(true);
                    deleteRotateLeft(x.parent);
                    x = root;
                }
            } else {
                counterIF+=2;
                RBNode w = x.parent.left;
                if (!w.color) {
                    w.setColor(true);
                    x.parent.setColor(false);
                    deleteRotateRight(x.parent);
                    w = x.parent.left;
                }
                if (w.right.color && w.left.color) {
                    w.setColor(false);
                    x = x.parent;
                    continue;
                } else if (w.left.color) {
                    counterIF++;
                    w.right.setColor(true);
                    w.setColor(false);
                    deleteRotateLeft(w);
                    w = x.parent.left;
                }
                counterIF++;
                if (!w.left.color) {
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
            counterIF+=2;
            target.parent.left = with;
        } else{counterIF+=2;
            target.parent.right = with;}
        with.parent = target.parent;
    }


    private void deleteRotateLeft(RBNode node) {
        if (node.parent != null) {
            counterIF++;
            if (node == node.parent.left) {

                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
            counterIF+=2;
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != null) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        } else {
            counterIF++;
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
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
            counterIF+=2;
            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != null) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        } else {
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
