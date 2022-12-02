package lab10.second;

import java.util.List;

public interface FilterExportByNameStrategy {
    List<Export> sortByName(List<Export> exports, String name);

    String calculateTotalQuantity(List<Export> exports);
}
