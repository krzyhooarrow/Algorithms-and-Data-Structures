@SuppressWarnings("Duplicates")
public class ImprovedQuickSort implements Sortable {
    int counterCOMP = 0;
    int counterSWAP = 0;

    @Override
    public void sort(int[] array, boolean b) {
    if (b)
        quicksortASC(array,0,array.length-1);
    else
        quicksortDESC(array,0,array.length-1);
    }

    public int getCounterCOMP() {
        return counterCOMP;
    }

    public int getCounterSWAP() {
        return counterSWAP;
    }

    @Override
    public void resetCounter() {
        counterCOMP=0;
        counterSWAP=0;
    }

    public void quicksortASC(int[] A, int p, int r) {
        int q;
        if (p < r) {
            q = partitionASC(A, p, r);
            quicksortASC(A, p, q - 1);
            quicksortASC(A, q + 1, r);

        }
    }

    public void quicksortDESC(int[] A, int p, int r) {

        int q;
        if (p < r) {

            q = partitionDESC(A, p, r);
            quicksortDESC(A, p, q);
            quicksortDESC(A, q + 1, r);


        }

    }

    private int partitionASC(int[] A, int p, int r) {

        int x;
        int swap;

        if (A.length > 3) {
            if (A[p] < A[r]) {
                if (A[A.length / 2] < A[p]) {
                    x = A[p];
                    A[p] = A[r];
                    A[r] = x;
                } else if (A[A.length / 2] > A[r])
                    x = A[r];
                else {
                    x = A[A.length / 2];
                    A[A.length / 2] = A[r];
                    A[r] = x;
                }
            } else {
                if (A[A.length / 2] < A[r])
                    x = A[r];
                else if (A[A.length / 2] > A[p]) {
                    x = A[p];
                    A[p] = A[r];
                    A[r] = x;
                } else {
                    x = A[A.length / 2];
                    A[A.length / 2] = A[r];
                    A[r] = x;
                }

            }
        } else x = A[r];
        // wybor pivota

        int i = p - 1;
        for (int j = p; j <= r - 1; j++) {
            if (A[j] <= x) {
                counterCOMP++;
                counterSWAP++;
                i++;
                swap = A[i];
                A[i] = A[j];
                A[j] = swap;

            }
        }
        swap = A[i + 1];
        A[i + 1] = A[r];
        A[r] = swap;
        counterSWAP++;
        return i + 1;
    }


    private int partitionDESC(int[] A, int p, int r) {

        int x;


        x = A[p]; // pivot
        int i = p;
        int j = r;
        while (true) {
            //ignore all the numbers greater than X to left
            while (A[i] > x) {
                i++;
                counterCOMP++;
            }
            //ignore all numbers lesser than X to right
            while (A[j] < x) {
                counterCOMP++;
                j--;
            }

            //swap a number lesser than X on left with a number greater than X on right
            if (i < j) {

                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
                counterCOMP++;
                counterSWAP++;

            } else {
                //Now the array is so sorted, that all numbers lesser than X are on right of it and greater than X are to left of it. Hence return position of X
                return j;
            }
        }
    }


}
