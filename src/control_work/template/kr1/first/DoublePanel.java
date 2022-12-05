package control_work.template.kr1.first;

import java.io.File;
import java.io.IOException;

public class DoublePanel extends Panel<Double> {
    @Override
    protected ComparableContainer<Double> readFromFile(File file) throws IOException {
        return new ComparableContainer<Double>(Reader.readDoublesFromFile(file));
    }
}
