package lab12;

import org.omg.PortableServer.THREAD_POLICY_ID;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class XMLCreator {
    private final Document document;
    private final Element root;

    public static void create(Path inputFile, Path outputFile) throws ParserConfigurationException, TransformerException, IOException {
        new XMLCreator(inputFile, outputFile);
    }

    private XMLCreator(Path path, Path outputFile) throws ParserConfigurationException, TransformerException, IOException {
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.newDocument();
        root = document.createElement("Exports");
        document.appendChild(root);
        try {
            parseFile(path);
        } catch (IOException e) {
            throw new IOException("Can't create XML File. Wrong .txt filename");
        }
        transformation(outputFile);
    }

    private void transformation(Path outputFile) throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource domSource = new DOMSource(document);
        StreamResult streamResult = new StreamResult(outputFile.toFile());
        transformer.transform(domSource, streamResult);
    }

    private void parseFile(Path path) throws IOException {
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] s = line.split(" ");

                Element export = document.createElement("Export");
                root.appendChild(export);

                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(s[0]));
                export.appendChild(name);

                Element country = document.createElement("country");
                country.appendChild(document.createTextNode(s[1]));
                export.appendChild(country);

                Element quantity = document.createElement("quantity");
                quantity.appendChild(document.createTextNode(s[2]));
                export.appendChild(quantity);
            }
        }
    }
}
