package lab12;

import lab11.Export;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SAXExportParser {
    private List<Export> exportList;
    public static SAXExportParser newInstance(Path path) throws ParserConfigurationException, SAXException, IOException {
        return new SAXExportParser(path);
    }
    private SAXExportParser(Path path) throws ParserConfigurationException, SAXException, IOException {
        exportList = new ArrayList<>();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        DefaultHandler handler = new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                super.startElement(uri, localName, qName, attributes);
                // not ready
            }

            @Override
            public void characters(char[] ch, int start, int length) throws SAXException {
                super.characters(ch, start, length);
                // not ready
            }
        };
        parser.parse(path.toFile(), handler);
    }

    public List<Export> getExportList() {
        return exportList;
    }
}
