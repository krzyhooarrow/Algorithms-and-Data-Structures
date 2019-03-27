public class InsertionSort {


    public static void sort(int[] tablica , boolean type) {

        int klucz, j;

        for (int i = 1; i < tablica.length; i++) {
            j = i;
            klucz = tablica[i];

            while (j > 0 && tablica[j - 1] > klucz) {
                tablica[j] = tablica[j - 1];
                j--;
            }
            tablica[j] = klucz;
        }





    }

}
