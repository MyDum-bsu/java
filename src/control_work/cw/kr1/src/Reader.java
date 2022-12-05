package control_work.cw.kr1.src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {

    public static List<Worker> readWorkerFromFile(File file) throws FileNotFoundException, FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<Worker> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.add(Worker.parseFromString(line));
        }
        return result;
    }

}