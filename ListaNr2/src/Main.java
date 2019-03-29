import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        long start = System.currentTimeMillis();


        if (args.length > 5) {

            Sortable sort;
            switch (args[1]) {
                case "select":
                    sort = new SelectSort();

                    break;
                case "insert":
                    sort = new InsertionSort();

                    break;
                case "heap":
                    sort = new HeapSort();

                    break;
                case "quick":
                    sort = new QuickSort();

                    break;

                case "mquick":
                    sort = new ImprovedQuickSort();

                    break;
                default:
                    sort= new QuickSort();
            }


            if (args[0].equals("--type") && (args[2].equals("--desc") || args[2].equals("--asc")) && args[3].equals("--stat")) {

                Random generator = new Random();
                int array[];
                BufferedWriter writer = null;
                try {
                    writer = new BufferedWriter(new FileWriter(args[4]+".txt"));
                } catch (IOException e) {
                    e.printStackTrace();
                }


                for (int n = 1; n < 100; n++) {
                    array = new int[100 * n];
                    for (int k = 0; k < Integer.valueOf(args[5]); k++) {

                        for (int i = 0; i < 100 * n; i++)
                            array[i] = generator.nextInt(100 * n);


                        System.out.println();

                        if (args[2].equals("--desc"))
                        sort.sort(array, false);
                        else
                            sort.sort(array,true);


                        long stop = System.currentTimeMillis();
                        System.out.println();
                        System.out.println("Type = " + sort.getClass() + ", n = " + 100*n);
                        System.out.println("Czas wykonania (w milisekundach): " + (stop - start));
                        System.out.println("Comp: " + sort.getCounterCOMP());
                        System.out.println("Swap: " + sort.getCounterSWAP());

                        sort.resetCounter();
                        try {
                            writer.write(sort.getCounterCOMP() + ";" + sort.getCounterSWAP() + ";" + (stop - start));
                            writer.newLine();

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        start = stop;
                    }
                    try {
                        writer.newLine();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }

                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }



            } else if (args[0].equals("--type") && (args[2].equals("--desc") || args[2].equals("--asc"))){


                int[] temp = new int[Integer.valueOf(args[3])];
                for (int i = 0; i < Integer.valueOf(args[3]) ; i++)
                    temp[i] = Integer.valueOf(args[i + 4]);

                for (int i = 0 ; i < temp.length ; i++)
                    System.out.print(temp[i] + " ");

                System.out.println();


                if (args[2].equals("--desc"))
                    sort.sort(temp, false);
                else
                    sort.sort(temp,true);

                for (int i = 0 ; i < temp.length ; i++)
                    System.out.print(temp[i] + " ");

                System.out.println();

                long stop = System.currentTimeMillis();
                System.out.println("Type = " + sort.getClass() );
                System.out.println("Czas wykonania (w milisekundach): " + (stop - start));
                System.out.println("Comp: " + sort.getCounterCOMP());
                System.out.println("Swap: " + sort.getCounterSWAP());

            }




        }

    }


}
