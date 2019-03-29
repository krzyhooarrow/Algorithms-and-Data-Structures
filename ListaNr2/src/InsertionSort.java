@SuppressWarnings("Duplicates")
public class InsertionSort implements Sortable {
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

    public void sort(int[] tablica, boolean type) {

        int klucz, j;
        if (type) {
            for (int i = 1; i < tablica.length; i++) {
                j = i;
                klucz = tablica[i];

                while (j > 0 && tablica[j - 1] > klucz) {
                    tablica[j] = tablica[j - 1];
                    j--;
                counterCOMP++;
                }
                tablica[j] = klucz;
                counterSWAP++;
            }
        } else {
            for (int i = 1; i < tablica.length; i++) {
                j = i;
                klucz = tablica[i];

                while (j > 0 && tablica[j - 1] < klucz) {
                    tablica[j] = tablica[j - 1];
                    j--;
                    counterCOMP++;
                }
                tablica[j] = klucz;
                counterSWAP++;
            }

        }
    }

}
