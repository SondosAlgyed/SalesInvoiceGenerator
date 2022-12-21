package model;

import java.util.ArrayList;

public class invoiceHeader {
    private int invoic_num;
    private String invoice_date;
    private String customer_name;
    private ArrayList<invoiceLine> items;
    @Override
    public String toString()
    {
        return "invoiceHeader{" + "invoice_num=" + invoic_num + ", invoiceDate="
                + invoice_date + ",customer_name ="
                + customer_name
                + ", items=" + items + '}';
    }

    public invoiceHeader(){
    }

    public invoiceHeader(int invoic_num, String customer_name, String invoice_date) {
        this.invoic_num= invoic_num;
        this.customer_name= customer_name;
        this.invoice_date= invoice_date;
    }

    public double calculateTotalInvoice(){
        double total=0.0;
        for(invoiceLine item : getItems()){
            total= total + item.calculateTotal();
        }
        return total;
    }

    public int getinvoicnum() {
        return invoic_num;
    }

    public void setinvoicnum(int invoic_num){
        this.invoic_num = invoic_num;
    }

    public double getTotal()
    {
        double total=0;
        for(invoiceLine item: getItems())
        {
            total= total+ item.CalculateTotalLine();
        }
        return total;
    }
    public String getInvoicesFromTabel()
    {

        return invoic_num+ "," + invoice_date + "," + customer_name ;
    }

    public void setInvoiceDate(String invoice_date) {
        this.invoice_date = invoice_date;
    }
    public ArrayList<invoiceLine> getItems() {
        if(items==null){
            items=new ArrayList();
        }
        return items;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public void setCustomerName(String customer_nameame) {
        this.customer_name = customer_name;
    }
    public String getInvoiceDate()
    {

        return invoice_date;
    }



}
