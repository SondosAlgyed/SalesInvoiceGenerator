package model;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
public class InvioceTabel extends AbstractTableModel{

    private ArrayList<invoiceHeader> Newinvoices;
    private String Colums[]  = {"Num", "Date", "Customer", "Total"};

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        invoiceHeader inv = Newinvoices.get(rowIndex);
        if(columnIndex==0)
        {
            return inv.getinvoicnum();
        }
        else if(columnIndex==1)
        {
            return inv.calculateTotalInvoice();
        }
        else if(columnIndex==2)
        {
            return inv.getCustomerName();

        }
        else if(columnIndex==3)
        {
            return inv.getInvoiceDate();

        }
        else
        {
            return null;
        }

    }

    @Override
    public String getColumnName(int col) {
        return Colums[col];
    }
    @Override
    public int getRowCount() {return Newinvoices.size();}
    @Override
    public int getColumnCount() {return Colums.length;}
    public InvioceTabel(ArrayList<invoiceHeader> invoices) {this.Newinvoices = invoices;}



}
