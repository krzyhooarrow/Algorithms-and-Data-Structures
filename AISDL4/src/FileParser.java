import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileParser {

    public ArrayList parseFile(String path) {
        ArrayList list = new ArrayList();

        String file = path;
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        scanner.useDelimiter(" ");

        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        return list;
    }
}
