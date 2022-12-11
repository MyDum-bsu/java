import lab12.XMLCreator;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        //lab12.lab10_2.Application.create();
        try {
            XMLCreator.create(Paths.get("src/lab12/data.txt"), Paths.get("src/lab12/data.xml"));
        } catch (ParserConfigurationException | TransformerException | IOException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}