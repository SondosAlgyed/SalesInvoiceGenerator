
package controller;

import model.LineTabel;
import model.invoiceLine;
import model.invoiceHeader;
import view.invoiceFrame;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class ActiosTT implements ListSelectionListener{
    private invoiceFrame frame;

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        int Index = frame.getTableHeader().getSelectedRow();
        if(Index != -1)
        {
             invoiceHeader selectedRow = frame.getInvoices().get(Index);
             ArrayList<invoiceLine> Elements = selectedRow.getItems();
             frame.getTostalCost().setText(""+selectedRow.calculateTotalInvoice());LineTabel line = new LineTabel(Elements);
        }
    }
    public ActiosTT(invoiceFrame frame)
    {

        this.frame = frame;
    }
    
}
