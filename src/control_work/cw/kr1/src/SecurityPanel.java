package control_work.cw.kr1.src;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SecurityPanel extends WorkerPanel {

    @Override
    protected ArrayList<Worker> readFromFile(File file) throws IOException {
        return new ArrayList<>(Reader.readWorkerFromFile(file));
    }
}
