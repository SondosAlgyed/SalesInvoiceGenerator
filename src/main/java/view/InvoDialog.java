
package view;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InvoDialog extends JDialog{
    private JTextField Clintname;private JTextField DateOfInvoice;
    private JLabel labelOfClint;private JLabel dateLabel;
    private JButton oky;private JButton cancel;
    public JTextField getCustomerName() {
        return Clintname;
    }public JTextField getInvoiceDate() {
        return DateOfInvoice;
    }
    public InvoDialog(invoiceFrame frame)
    {
        labelOfClint= new JLabel("Customer Name:");Clintname = new JTextField(30);
        dateLabel = new JLabel("Date:");DateOfInvoice = new JTextField(30);
        oky= new JButton("OK");cancel = new JButton("Cancel");
        oky.setActionCommand("createInvoice");cancel.setActionCommand("cancelInvoice");
        add(Clintname);add(dateLabel);
        add(DateOfInvoice);add(oky);
        add(cancel);pack();
        oky.addActionListener(frame.getController());
        cancel.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 4));
        add(labelOfClint);

    }

    
    
}
