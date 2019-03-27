public class SelectSort {
    @SuppressWarnings("Duplicates")

    public static void sort(int tablica[],boolean type) {
        int min,i,j,temp;

        if (type)//asc
        for (i=0;i<tablica.length-1;i++)  {
            min=i;
            for (j=i+1;j<tablica.length;j++)

                if (tablica[j]<tablica[min])
                    min=j;
            temp=tablica[min];
            tablica[min]=tablica[i];
            tablica[i]=temp;
        }
        else{//desc

            for (i=0;i<tablica.length-1;i++)  {
                min=i;
                for (j=i+1;j<tablica.length;j++)

                    if (tablica[j]>tablica[min])
                        min=j;
                temp=tablica[min];
                tablica[min]=tablica[i];
                tablica[i]=temp;
            }

        }
    }

}
