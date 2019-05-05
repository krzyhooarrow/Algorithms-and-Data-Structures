import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

    public ArrayList<String> parseFile(String path) {
        ArrayList<String> list = new ArrayList();

        String file = path;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            System.out.println("error");
            e.printStackTrace();
        }
//        scanner.useDelimiter(" ");
        scanner.useDelimiter("\n");

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        return list;
    }
}
