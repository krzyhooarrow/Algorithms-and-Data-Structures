public class QuickSort {


    public void quicksort(int[] A, int p, int r) {
        int q;
        if (p < r) {
            q = partition(A, p, r);
            quicksort(A, p, q - 1);
            quicksort(A, q + 1, r);
        }


    }

    private int partition(int[] A, int p, int r) {
        int x = A[r];
        int swap;
        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                i++;
                swap = A[i];
                A[i] = A[j];
                A[j] = swap;
            }
        }
        swap = A[i + 1];
        A[i + 1] = A[r];
        A[r] = swap;
        return i + 1;
    }

}
