import java.util.Random;

public class Main {


    public static void main(String[] args) {


        Random generator = new Random();
        int array[] = new int[50];
        for (int i = 0; i < 50; i++)
            array[i] = generator.nextInt(100);

        for (int i : array
        ) {
            System.out.print(i + " ");

        }
        System.out.println();
        //   new QuickSort().sort(array,0,array.length-1,true);
        //  new SelectSort().sort(array,false);


        //  new InsertionSort().sort(array,true);
        QuickSort sort = new QuickSort();
        sort.quicksort(array,0,array.length-1);
           //new HeapSort().sort(array);
        for (int i : array
        ) {
            System.out.print(i + " ");

        }

    }



    public static void type(int [] tablica , String type){
        if (type == "desc"){
            for(int i = 0; i < tablica.length / 2; i++)
            {
                int temp = tablica[i];
                tablica[i] = tablica[tablica.length - i - 1];
                tablica[tablica.length - i - 1] = temp;
            }
        }

    }

}
