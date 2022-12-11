package lab12;

import lab12.app.Export;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class DOMExportParser {
    private final List<Export> exportList;

    public static DOMExportParser newInstance(Path path) throws ParserConfigurationException, IOException, SAXException {
        return new DOMExportParser(path);
    }

    private DOMExportParser(Path path) throws ParserConfigurationException, IOException, SAXException {
        exportList = new ArrayList<>();
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(path.toFile());
        document.getDocumentElement().normalize();
        NodeList exportNodeList = document.getElementsByTagName("Export");
        parseExportNodeList(exportNodeList);
    }

    private void parseExportNodeList(NodeList exportNodeList) throws ParserConfigurationException {
        for (int i = 0; i < exportNodeList.getLength(); i++) {
            Node exportNode = exportNodeList.item(i);
            Export export = parseExportNode(exportNode);
            exportList.add(export);
        }
    }

    private Export parseExportNode(Node exportNode) throws ParserConfigurationException {
        if (exportNode instanceof Element) {
            Export export = new Export();
            NodeList tags = exportNode.getChildNodes();
            for (int j = 0; j < tags.getLength(); j++) {
                Node tag = tags.item(j);
                if (tag instanceof Element) {
                    String value = tag.getTextContent();
                    if ("name".equals(((Element) tag).getTagName())) {
                        export.setName(value);
                    } else if ("country".equals(((Element) tag).getTagName())) {
                        export.setCountry(value);
                    } else if ("quantity".equals(((Element) tag).getTagName())) {
                        export.setQuantity(Integer.parseInt(value));
                    }
                }
            }
            return export;
        }
        throw new ParserConfigurationException("wrong data");
    }

    public List<Export> getExportList() {
        return exportList;
    }
}
