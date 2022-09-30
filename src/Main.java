import lab2.Matrix;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path path = Paths.get("src/lab2/A.txt");
        Matrix.run(path);
    }

    private static String terminalInputString(String[] args) {
        StringBuilder s = new StringBuilder();
        for (String arg : args) {
            s.append(arg).append(" ");
        }
        return s.toString();
    }
}

