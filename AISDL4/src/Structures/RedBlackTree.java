package Structures;

@SuppressWarnings("Duplicates")


public class RedBlackTree {
    private final Node nil = new Node(-1, false);
    private Node root = nil;
    private int capatity = 0;

    private long counterSWAP = 0;
    private long counterIF = 0;


    public long getCounterSWAP() {
        return counterSWAP;
    }

    public long getCounterIF() {
        return counterIF;
    }


    public void clear() {
        capatity = 0;
        root = nil;
    }

    public int size() {
        return capatity;
    }

    public void insert(Comparable a) {
        Node element = new Node(a);

        if (root == nil) {
            capatity++;
            root = new Node(a, nil, nil, nil, false);
            return;
        }
        Node n = root;
        capatity++;
        counterSWAP += 2;
        while (true) {
            if (element.compareTo(n) < 0) {
                counterIF++;

                if (n.left == nil) {
                    counterIF++;
                    n.left = new Node(a, nil, nil, n);
                    fixAfterInsert(n.left);
                    break;
                } else {
                    counterIF++;
                    n = n.left;
                }
            } else if (element.compareTo(n) > 0) {
                counterIF++;
                if (n.right == nil) {
                    counterIF++;
                    n.right = new Node(a, nil, nil, n);
                    fixAfterInsert(n.right);
                    break;
                } else {
                    counterIF++;
                    n = n.right;
                }
            } else break;
        }
    }


    public void inorder() {
        int i = 0;
        inorder(root, i);
        System.out.println();
    }

    private void inorder(Node root, int i) { // i oznacza poziom w drzewie
        if (root != null) {

            i++;
            inorder(root.left, i);
            if (!root.red && root != nil)
                System.out.print("{" + root.value + "," + root.parent + ",black ," + i + "} ");
            else if (root != nil)
                System.out.print("{" + root.value + ", " + root.parent + ",red " + i + "} ");
            inorder(root.right, i);
        }
    }


    private void fixAfterInsert(Node n) {

        while (n.parent.red) {

            Node gp = n.parent.parent;

            if (n.parent == gp.left) {
                counterIF++;
                Node uncle = gp.right;
                if (uncle.red) {
                    counterIF++;
                    gp.red = true;
                    uncle.red = false;
                    n.parent.red = false;
                    counterSWAP += 3;
                    n = gp;
                } else if (n.parent.right == n) {
                    counterIF++;
                    Node tmp = n.parent;
                    leftRotate(n.parent);
                    counterSWAP++;
                    n = n.left;
                } else {
                    counterIF++;
                    rightRotate(gp);
                    gp.red = true;
                    n.parent.red = false;
                    counterSWAP += 2;
                }
            } else {
                counterIF++;
                Node uncle = gp.left;
                if (uncle.red) {
                    counterIF++;
                    gp.red = true;
                    uncle.red = false;
                    n.parent.red = false;
                    counterSWAP += 3;
                    n = gp;
                } else if (n.parent.left == n) {
                    counterIF++;
                    Node tmp = n.parent;
                    rightRotate(n.parent);

                    n = n.right;
                } else {
                    counterIF++;
                    leftRotate(gp);
                    gp.red = true;
                    n.parent.red = false;
                    counterSWAP += 2;
                }
            }
        }
        counterSWAP++;
        root.red = false;
    }

    private void rightRotate(Node n) {


        Node nl = n.left;
        n.left = nl.right;
        counterSWAP++;
        if (nl.right != nil) {
            counterIF++;
            nl.right.parent = n;
        }
        swap(n, nl);
        nl.right = n;
        n.parent = nl;
    }

    private void leftRotate(Node n) {

        counterSWAP++;
        Node nr = n.right;
        n.right = nr.left;

        if (nr.left != nil) {
            counterIF++;
            nr.left.parent = n;
        }
        swap(n, nr);
        nr.left = n;
        n.parent = nr;
    }


    private void swap(Node n1, Node n2) {

        if (n1.parent == nil) {
            counterIF++;
            root = n2;
        } else {
            counterIF++;
            if (n1.parent.left == n1) {
                counterIF++;
                n1.parent.left = n2;
            } else {
                counterIF++;
                n1.parent.right = n2;
            }
        }
        n2.parent = n1.parent;
    }


    public Node search(Comparable element) {
        Node node = new Node(element);
        Node actual = root;
        while (actual != nil && node.value.compareTo(actual.value) != 0) {
            counterIF++;
            if (node.value.compareTo(actual.value) < 0)
                actual = actual.left;
            else actual = actual.right;
        }
        if (actual == nil)
            return null;
        else return actual;

    }


    public void remove(Comparable element) {
        Node z = search(element);
        if (z != null) {

            capatity--;
            Node x;
            boolean yoc;
            if (z.right == nil) {
                counterIF++;
                swap(z, z.left);
                x = z.left;
                yoc = z.red;
            } else {
                counterIF++;
                Node sr = successor(z);

                x = sr.right;
                yoc = sr.red;
                if (sr.parent != z) {
                    counterIF++;
                    swap(sr, x);
                    sr.right = z.right;
                    counterSWAP += 2;
                    z.right.parent = sr;
                } else {
                    counterIF++;
                    x.parent = sr;
                    counterSWAP++;
                }
                counterSWAP++;
                sr.left = z.left;
                if (z.left != nil) {
                    counterSWAP++;
                    counterIF++;
                    z.left.parent = sr;
                }
                counterSWAP++;
                sr.red = z.red;
                swap(z, sr);
            }
            if (!yoc) {
                counterIF++;
                fixAfterRemove(x);
            }
        }
    }

    private void fixAfterRemove(Node x) {       // ciągle jebany null
        while (x != root && !x.red) {
            counterIF++;
            if (x == x.parent.left) {
                counterIF++;
                Node w = x.parent.right;

                if (w.red) {
                    counterSWAP += 2;
                    counterIF++;
                    x.parent.red = true;
                    w.red = false;
                    leftRotate(x.parent);
                } else {
                    counterIF++;
                    if (!w.left.red && !w.right.red) {
                        counterSWAP++;
                        w.red = true;
                        x = x.parent;
                        counterIF++;
                    } else if (w.left.red && !w.right.red) {
                        counterSWAP += 2;
                        w.red = true;
                        counterIF++;
                        w.left.red = false;
                        rightRotate(w);
                    } else {
                        counterSWAP += 3;
                        counterIF++;
                        w.red = x.parent.red;
                        w.right.red = false;
                        x.parent.red = false;
                        leftRotate(x.parent);
                        x = root;
                    }
                }
            } else {
                Node w = x.parent.left;

                if (w.red) {
                    counterSWAP += 2;
                    counterIF++;
                    x.parent.red = true;
                    w.red = false;
                    rightRotate(x.parent);
                } else {
                    if (!w.left.red && !w.right.red) {
                        counterSWAP++;
                        counterIF++;
                        w.red = true;
                        x = x.parent;
                    } else if (!w.left.red && w.right.red) {
                        counterSWAP += 2;
                        counterIF++;
                        w.red = true;
                        w.right.red = false;
                        leftRotate(w);
                    } else {
                        counterIF++;
                        counterSWAP += 3;
                        w.red = x.parent.red;
                        w.left.red = false;
                        x.parent.red = false;
                        rightRotate(x.parent);
                        x = root;
                    }
                }
            }
        }
        counterSWAP++;
        x.red = false;
    }

    private Node successor(Node node) {

        if (node.right == nil) {
            counterIF++;
            Node p = node.parent;
            while (p != nil && p.right == node) {

                p = p.parent;
                node = node.parent;
            }
            return p;
        } else {
            counterIF++;
            Node n = node.right;
            while (n.left != nil) {
                n = n.left;
            }
            return n;
        }
    }

    public boolean isEmpty() {
        return root == nil;
    }


    private class Node<T extends Comparable<T>> implements Comparable<Node> {
        T value;
        Node left, right, parent;
        boolean red = true;

        public Node(T value, Node left, Node right, Node parent, boolean red) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
            this.red = red;
        }

        public Node(T value, Node left, Node right, Node parent) {
            this.value = value;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        public Node(T value, boolean red) {
            this.value = value;
            this.red = red;
        }

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return " " +
                    value;

        }

        @Override
        public int compareTo(Node o) {
            return this.value.compareTo((T) o.value);
        }
    }

}