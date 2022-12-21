package controller;

import model.operations;
import model.InvioceTabel;
import model.invoiceLine;
import model.invoiceHeader;
import view.invoiceFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;
import java.util.ArrayList;
import view.InvoDialog;
import view.LineDialog;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Controller implements ActionListener, ListSelectionListener {
    public Controller(invoiceFrame invoiceFrame)
    {

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        throw new UnsupportedOperationException(" nothing backing");
    }
    private invoiceFrame frame;private invoiceHeader header;
    private invoiceLine elements;private String name ;
    private InvoDialog invoiceD;private LineDialog ElementD;
////////
    public void savingFile(ArrayList<invoiceHeader> headers)
    {


        String invoices = "";
        String Elements = "";
        File headerFile;
        File lineFile;
        int outcome;

        for(invoiceHeader header: headers) {
            String headerLines = header.getInvoicesFromTabel();
            invoices = invoices + headerLines;
            invoices = invoices + "\n";

            for (invoiceLine item : header.getItems()) {
                String itemFile = item.getItemsFromTabel();
                Elements = Elements + itemFile;
                Elements = Elements + "\n";
            }
        }    }
        /////////

    private void RemoveInvo() {
         int ROWS = frame.getTableHeader().getSelectedRow();
        if(ROWS!= -1){
            frame.getInvoices().remove(ROWS);
            frame.getHeaderTabel().fireTableDataChanged();
            
        }
    }
//create obj dialoge of classaddLineDialoge and set it visible
    private void newLine() {
        ElementD = new LineDialog(frame);
        ElementD.setVisible(true);
        
    }




    public void invoNew() {
      String date= invoiceD.getInvoiceDate().getText();
      String Clients = invoiceD.getCustomerName().getText();int num= frame.TotainvoiceNumber();num++;
        invoiceHeader newInvoice = new invoiceHeader(num,Clients,date);frame.getInvoices().add(newInvoice);
        frame.getHeaderTabel().fireTableDataChanged();invoiceD.setVisible(false);
        invoiceD.dispose();invoiceD=null;

    }



    private void cancelInvoice() {
        invoiceD.setVisible(false);
        invoiceD.dispose();
        invoiceD=null;
    }

    private void cancelLine() {
        ElementD.setVisible(false);
        ElementD.dispose();
        ElementD=null;
    }
    private void newInvoice()
    {
        invoiceD = new InvoDialog(frame);
        invoiceD.setVisible(true);

    }
    @Override
   
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("NewInvoice"))
        {
            newInvoice();
        }
        else if(e.getActionCommand().equals("cancelLine"))
        {
            cancelLine();
        }
        else if(e.getActionCommand().equals("createInvoice"))
        {
            invoNew();
        }

        else if(e.getActionCommand().equals("DeleteInvoice"))
        {
            RemoveInvo();
        }
        else if(e.getActionCommand().equals("NewLine"))
        {
            newLine();
        }
        else if(e.getActionCommand().equals("cancelInvoice"))
        {
            newLine();
        }
        else if(e.getActionCommand().equals("Save File"))
        {
            savingFile(frame.getInvoices());
        }
        else if(e.getActionCommand().equals("OpenFile"))
        {
            frame.setInvoices(null);
            operations operationsOfFile = new operations(frame);
            ArrayList<invoiceHeader> inv= operationsOfFile.readFile();
            InvioceTabel tableOfInvoice = new InvioceTabel(inv);
            frame.setInvoices(inv);
            frame.setTabel(tableOfInvoice);
        }


    }
}
