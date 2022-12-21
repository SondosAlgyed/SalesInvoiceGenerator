/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class LineDialog extends JDialog {
    public JTextField getElement() {

        return ElemenetName;
    }

    public JTextField getMount() {
        return mount;
    }

    public LineDialog(invoiceFrame frame) {
        itemNameLabel= new JLabel("Item Name:");ElemenetName = new JTextField(30);
        PriceLabel = new JLabel("Unit Price:");Price = new JTextField(30);
        mountLabel = new JLabel("Quantity:");mount = new JTextField(30);
        okay= new JButton("OK");cancel = new JButton("Cancel");
        okay.setActionCommand("createLine");cancel.setActionCommand("cancelLine");
        okay.addActionListener(frame.getController());cancel.addActionListener(frame.getController());
        setLayout(new GridLayout(4, 4));add(itemNameLabel);
        add(ElemenetName);add(PriceLabel);
        add(Price);add(mountLabel);
        add(mount);add(okay);
        add(cancel);pack();
    }
    private JTextField ElemenetName;private JTextField Price;
    private JTextField mount;private JLabel itemNameLabel;
    private JLabel PriceLabel;private JLabel mountLabel;
    private JButton okay;private JButton cancel;
    public JTextField getPrice()
    {

        return Price;
    }


    
}
