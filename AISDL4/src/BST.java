import java.lang.reflect.Array;
import java.util.Arrays;

public class BST<T extends Comparable<T>> {

    private T[] array;
    private int capatity;

    public BST(Class<T> type) {
        array = (T[]) Array.newInstance(type, 1);
        capatity = 0;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    public int size() {
        return capatity;
    }

    public void insert(T element) {
        if (isEmpty()) {
            array[0] = element;
            capatity++;
        } else {
            if (right(capatity) < array.length) { // gdyby wszystko było na lini w prawo
                capatity++;
                heap(element, 0);
            } else {
                this.array = Arrays.copyOf(array, 2 * array.length);
                insert(element);
            }
        }
    }

    private void heap(T element, int i) {
        if (array[i] != null && element.compareTo(array[i]) < 0) {
            heap(element, left(i));
        } else if (array[i] != null && element.compareTo(array[i]) > 0)
            heap(element, right(i));
        else array[i] = element;
    }


    private boolean isEmpty() {
        return capatity == 0;
    }

    public void printTree() {
        System.out.println(Arrays.toString(array));
    }
}
