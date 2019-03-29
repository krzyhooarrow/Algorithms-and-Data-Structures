@SuppressWarnings("Duplicates")

public class SelectSort implements Sortable {

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

    private int counterCOMP = 0;
    private int counterSWAP = 0;


    public void sort(int tablica[], boolean type) {
        int min, i, j, temp;

        if (type)//asc
            for (i = 0; i < tablica.length - 1; i++) {
                min = i;
                for (j = i + 1; j < tablica.length; j++)

                    if (tablica[j] < tablica[min]){
                        min = j;
                        counterCOMP++;
                    }
                temp = tablica[min];
                tablica[min] = tablica[i];
                tablica[i] = temp;
                counterSWAP++;
            }
        else {//desc

            for (i = 0; i < tablica.length - 1; i++) {
                min = i;
                for (j = i + 1; j < tablica.length; j++)

                    if (tablica[j] > tablica[min]){
                        min = j;
                        counterCOMP++;
                    }
                temp = tablica[min];
                tablica[min] = tablica[i];
                tablica[i] = temp;
                counterSWAP++;
            }

        }
    }

}
