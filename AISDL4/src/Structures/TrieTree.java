package Structures;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

public class TrieTree<T extends Comparable<T>> {

    TrieNode root = new TrieNode();

    public void insert(T[] keyword) {
        TrieNode var, temp = root;
        for (int i = 0; i < keyword.length; i++) {
            var = temp.children.search(new TrieNode(keyword[i]));
            if (var == null) {
                var = new TrieNode(keyword[i]);
                temp.children.insert(var);
            }

            temp = var;
        }
        temp.isEndOfSequence = true;
    }

    public void inorder() {
        read(root);
    }

    public void read(TrieNode root) {
        for (int i = 0; i < root.children.size(); i++) {
            System.out.println(root.children.arrayList()[i]);
//                if (root.children.arrayList()!=null)
            for (int j = 0; j < root.children.arrayList()[i].children.size(); j++) {
                System.out.print(root.children.arrayList()[i].children.arrayList()[j] + " ");
                read(root.children.arrayList()[i].children.arrayList()[j]);

            }
        }


    }

    public boolean search(T[] keyword) {
        TrieNode var, temp = root;
        for (int i = 0; i < keyword.length; i++) {
            if ((var = temp.children.search(new TrieNode(keyword[i]))) != null) {
                temp = var;
                continue;
            }
            return false;
        }
        if (temp.isEndOfSequence)
            return true;
        return false;
    }


    private class TrieNode<T extends Comparable<T>> implements Comparable<TrieNode> {
        T value;
        private boolean isEndOfSequence = false;
        DynamicArray children = new DynamicArray();

        public TrieNode(T value) {
            this.value = value;
        }

        public TrieNode() {
        }

        @Override
        public int compareTo(TrieNode o) {
            return this.value.compareTo((T) o.value);
        }

        @Override
        public String toString() {
            return value + " "
                    ;
        }
    }

    private class DynamicArray {

        private TrieNode[] dynamicArray;
        private int capatity;

        public DynamicArray() {
            this.capatity = 0;
            dynamicArray = (TrieNode[]) Array.newInstance(TrieNode.class, 1);
        }

        public int size() {
            return capatity;
        }

        public void insert(TrieNode element) {
            if (capatity == dynamicArray.length) {
                this.dynamicArray = Arrays.copyOf(dynamicArray, 2 * size());
                insert(element);
            } else {
                dynamicArray[capatity] = element;
                capatity++;
            }
        }

        public TrieNode search(TrieNode element) {
            for (int i = 0; i < capatity; i++)
                if (dynamicArray[i].compareTo(element) == 0)
                    return dynamicArray[i];
            return null;
        }

        public TrieNode[] arrayList() {
            return dynamicArray;
        }


    }


}