package pos.machine;
import java.util.*;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Item> items = convertToItems(barcodes);
        GenerateReceipt receipt = calculateReceipt(items);

        return generateReceipt(receipt);
    }



}