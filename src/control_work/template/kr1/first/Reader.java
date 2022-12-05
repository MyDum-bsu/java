package control_work.template.kr1.first;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public static List<Person> readPeopleFromFile(File file) throws FileNotFoundException, InputMismatchException {
        Scanner scanner = new Scanner(file);
        List<Person> result = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            result.add(Person.fromString(line));
        }
        return result;
    }

    public static List<Double> readDoublesFromFile(File file) throws FileNotFoundException {
        List<Double> data = new ArrayList<>();
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextDouble()) {
            data.add(scanner.nextDouble());
        }
        if (scanner.hasNext()) {
            throw new InputMismatchException("Not floats in file");
        }
        return data;
    }
}
