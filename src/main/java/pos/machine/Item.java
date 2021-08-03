package pos.machine;

public class Item {
    private String name;
    private int quantity;
    private int priceUnit;
    private int subTotal;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(int unitPrice) {
        this.priceUnit = unitPrice;
    }

    public int getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(int subTotal) {
        this.subTotal = subTotal;
    }
}
