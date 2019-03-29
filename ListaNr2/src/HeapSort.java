@SuppressWarnings("Duplicates")
public class HeapSort implements Sortable {
    int counterCOMP = 0;
    int counterSWAP = 0;

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


    public void sort(int[] arr, boolean type) {
        int n = arr.length;

        if (type) {
            for (int i = n / 2 - 1; i >= 0; i--)
                heapifyASC(arr, n, i);


            for (int i = n - 1; i >= 0; i--) {

                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapifyASC(arr, i, 0);
            }

        } else {

            for (int i = n / 2 - 1; i >= 0; i--)
                heapifyDESC(arr, n, i);


            for (int i = n - 1; i >= 0; i--) {

                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;

                heapifyDESC(arr, i, 0);
            }


        }

    }

    void heapifyASC(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] > arr[largest])
            largest = l;
            counterCOMP++;

        if (r < n && arr[r] > arr[largest])
            largest = r;
            counterCOMP+=2;

            counterSWAP++;

        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyASC(arr, n, largest);
        }
    }

    void heapifyDESC(int arr[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && arr[l] < arr[largest])
            largest = l;
        counterCOMP++;

        if (r < n && arr[r] < arr[largest])
            largest = r;
        counterCOMP+=2;
        counterSWAP++;
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapifyDESC(arr, n, largest);
        }
    }
}
