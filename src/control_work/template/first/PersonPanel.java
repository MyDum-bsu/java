package control_work.template.first;

import java.io.File;
import java.io.IOException;

public class PersonPanel extends Panel<Person> {
    @Override
    protected ComparableContainer<Person> readFromFile(File file) throws IOException {
        return new ComparableContainer<>(Reader.readPeopleFromFile(file));
    }
}
