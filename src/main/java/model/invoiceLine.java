package model;

public class invoiceLine {

    private invoiceHeader invoice;private String itemName;
    private double Price;private int quantity;

    public invoiceLine()
    {
    }

    public double CalculateTotalLine(){
        return Price * quantity;
    }
    public invoiceHeader getInvoice() {
        return invoice;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public double getPrice() {
        return Price;
    }
    public void setInvoice(invoiceHeader invoice)
    {

        this.invoice = invoice;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }

    @Override
    public String toString() {
        return "invoiceLIne{" + "itemName=" + itemName + ", Price=" + Price + ", quantity=" + quantity + '}';
    }

    public double calculateTotal(){
        return Price * quantity;
    }
    public String getItemsFromTabel(){
        return invoice.getinvoicnum() + "," + itemName + "," + Price + "," +quantity;
    }
    public invoiceLine(String itemName, int quantity,double Price,invoiceHeader header)
    {
        this.invoice= header;
        this.quantity = quantity;
        this.itemName = itemName;
        this.Price = Price;
    }
    public void setQuantity(int quantity)
    {

        this.quantity = quantity;
    }
    public String getItemName()
    {

        return itemName;
    }
    public int getQuantity() {

        return quantity;
    }

}
