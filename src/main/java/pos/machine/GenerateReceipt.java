package pos.machine;

import java.util.List;

public class GenerateReceipt {
    private List<Item> itemList;
    private int priceTotal;

    public GenerateReceipt() {
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public int getPriceTotal() {
        return priceTotal;
    }

    public void setPriceTotal(int priceTotal) {
        this.priceTotal = priceTotal;
    }


}
