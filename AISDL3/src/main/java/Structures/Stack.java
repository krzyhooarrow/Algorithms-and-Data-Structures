package Structures;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Stack<T> {

    private T[] array;
    private int heapSize;

    public Stack(Class<T> type) {
        array = (T[]) Array.newInstance(type, 1);
        heapSize = 0;
    }

    public void push(T element) {
        if (heapSize < array.length) {
            array[heapSize] = element;
            heapSize++;
        } else {
            this.array = Arrays.copyOf(array, 2 * heapSize);
            push(element);
        }
    }

    public void printStack() {
        for (int i = 0; i < heapSize; i++)
            System.out.println(array[i]);

    }

    public boolean isEmpty() {
        if (array[0] == null) return true;
        return false;
    }


    public T pop() {
        if (heapSize >0) {
            T element = array[heapSize-1];
            heapSize--;
            array[heapSize]=null;
            return element;
        }
            return null;

    }


}
