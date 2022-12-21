package model;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class LineTabel extends AbstractTableModel{
    private String Column[]  = {"Num", "Item", "Unit Price", "Quantity", "Total"};
    private ArrayList<invoiceLine> Element;

    public LineTabel(ArrayList<invoiceLine> items) {
        this.Element = items;
    }



    @Override
    public Object getValueAt(int rowIndex, int column) {
        invoiceLine element = Element.get(rowIndex);
        if(column==0)
        {
            return element.getItemName();
        }
        else if(column==1)
        {
            return element.getQuantity();
        }
        else if(column==2)
        {
            return element.getPrice();

        }
        else if(column==3)
        {
            return element.CalculateTotalLine();

        }
        else if(column==4)
        {
            return element.getInvoice().getinvoicnum();
        }
        else
        {
            return null;
        }


    }

    @Override
    public String getColumnName(int col) {
        return Column[col];
    }
    @Override
    public int getRowCount() {
        return Element.size();
    }

    @Override
    public int getColumnCount() {
        return Column.length;
    }
}
