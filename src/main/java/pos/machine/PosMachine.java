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

    private List<Item> convertToItems(List<String> barcodes) {
        LinkedList<Item> items = new LinkedList<Item>();
        List<ItemInfo> itemInfo = loadAllItemsInfo();
        barcodes = new ArrayList<>(new LinkedHashSet<>(barcodes));
        for (String barcode : barcodes) {
            Item itemValue = new Item();
            for (ItemInfo itemInfoVal : itemInfo) {
                if (barcode.equals(itemInfoVal.getBarcode())) {
                    itemValue.setName(itemInfoVal.getName());
                    itemValue.setPriceUnit(itemInfoVal.getPrice());
                    itemValue.setQuantity(retrieveItemCount(barcode));
                }
            }
            items.add(itemValue);
        }
        return items;
    }

    private List<Item> calculateItemsSubtotal(List<Item> itemsList) {
        for(Item itemValue : itemsList)
        {
            itemValue.setSubTotal(itemValue.getQuantity()*itemValue.getPriceUnit());
        }
        return itemsList;
    }

    private int calculatePriceTotal(List<Item> itemsList) {
        int priceTotal = 0;
        for(Item itemValue : itemsList)
        {
            priceTotal += itemValue.getSubTotal();
        }
        return priceTotal;
    }

    private GenerateReceipt calculateReceipt(List<Item> itemsList) {
        GenerateReceipt receipt = new GenerateReceipt();
        receipt.setItemList(calculateItemsSubtotal(itemsList));
        receipt.setPriceTotal(calculatePriceTotal(itemsList));

        return receipt;
    }

    private String generateItemsDetail(GenerateReceipt receipt) {
        String itemsDetail = "";
        for (Item itemValue : receipt.getItemList())
        {
            itemsDetail += "Name: "+ itemValue.getName() +
                    ", Quantity: " + itemValue.getQuantity() +
                    ", Unit price: " + itemValue.getPriceUnit() + " (yuan)" +
                    ", Subtotal: " + itemValue.getSubTotal() + " (yuan)\n";
        }

        return itemsDetail;
    }

    private String generateReceipt(GenerateReceipt receipt) {
        String itemsDetail = generateItemsDetail(receipt);

        return ("***<store earning no money>Receipt***\n" + itemsDetail + "----------------------\n" +
                "Total: " + receipt.getPriceTotal() + " (yuan)\n" +
                "**********************");
    }

}