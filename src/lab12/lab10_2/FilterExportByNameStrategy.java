package lab12.lab10_2;

import java.util.List;

public interface FilterExportByNameStrategy {
    List<Export> filterByName(List<Export> exports, String name);

    String calculateTotalQuantity(List<Export> exports);
}
