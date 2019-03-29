public interface Sortable {
    void sort(int[] array, boolean b);

    int getCounterCOMP();

    int getCounterSWAP();

    void resetCounter();
}
