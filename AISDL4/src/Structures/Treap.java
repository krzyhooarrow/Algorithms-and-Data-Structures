package Structures;

import java.util.Random;

public class Treap<T extends Comparable> {
    private static final Random rand = new Random();
    private Node<T> root;

    public void insert(T data) {
        root = add(root, data);
    }

    private Node<T> add(Node<T> node, T data) {
        if (node == null)
            return new Node<T>(data);

        int compare = data.compareTo(node.data);
        if (compare < 0) {
            node.left = add(node.left, data);
            if (node.priority > node.left.priority)
                return rotateRight(node);
        } else if (compare > 0) {
            node.right = add(node.right, data);
            if (node.priority > node.right.priority)
                return rotateLeft(node);
        }
        return node;
    }

    private Node<T> rotateRight(Node<T> node) {
        Node<T> lnode = node.left;
        node.left = lnode.right;
        lnode.right = node;
        return lnode;
    }

    private Node<T> rotateLeft(Node<T> node) {
        Node<T> rnode = node.right;
        node.right = rnode.left;
        rnode.left = node;
        return rnode;
    }

    public void remove(T data) {
        root = remove(root, data);
    }

    private Node<T> remove(Node<T> node, T data) {
        if (node != null) {
            int compare = data.compareTo(node.data);
            if (compare < 0) {
                node.left = remove(node.left, data);
            } else if (compare > 0) {
                node.right = remove(node.right, data);
            } else {
                if (node.left == null) {
                    return node.right;
                } else if (node.right == null) {
                    return node.left;
                } else {
                    node.data = minVal(node.right);
                    node.right = remove(node.right, node.data);
                }
            }
        }
        return node;
    }

    public boolean search(T data) {
        Node<T> node = root;
        while (node != null) {
            int compare = data.compareTo(node.data);
            if (compare < 0) node = node.left;
            else if (compare > 0) node = node.right;
            else return true;
        }
        return false;
    }




    public void inorder() {
        int i=0;
        inorder(root,i);
        System.out.println();
    }

    private void inorder(Node root,int i) { // i oznacza poziom w drzewie
        if (root != null) {
            i++;
            inorder(root.left,i);
            System.out.print(root.data + "{" + i+"} ");
            inorder(root.right,i);
        }
    }

    private T minVal(Node<T> searchNode) {
        Node<T> node = searchNode;
        while (node.left != null) node = node.left;
        return node.data;
    }


    private static class Node<T extends Comparable> {
        public Node<T> right, left;
        public final int priority = rand.nextInt();
        public T data;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return               "priority= " + priority +
                    ", data=" + data;
        }
    }
}