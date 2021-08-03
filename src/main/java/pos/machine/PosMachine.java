package pos.machine;
import java.util.*;

public class PosMachine {
    public String printReceipt(List<String> barcodes) {
        List<Item> items = convertToItems(barcodes);
        GenerateReceipt receipt = calculateReceipt(items);

        return generateReceipt(receipt);
    }

    private List<ItemInfo> loadAllItemsInfo(){
        return ItemDataLoader.loadAllItemInfos();
    }

    private int retrieveItemCount(String currentItemBarcode) {
        return Collections.frequency(ItemDataLoader.loadBarcodes(), currentItemBarcode);
    }

 

}