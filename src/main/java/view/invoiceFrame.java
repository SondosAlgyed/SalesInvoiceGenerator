package view;

import controller.Controller;
import controller.ActiosTT;
import model.operations;
import model.InvioceTabel;
import model.invoiceHeader;
import model.invoiceLine;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTable;
public class invoiceFrame extends javax.swing.JFrame {

    public invoiceFrame() {
        initintComponents();
    }
    @SuppressWarnings("unchecked")

    private void initintComponents() {

        jScroll1 = new javax.swing.JScrollPane();tableInvoiceHeader = new javax.swing.JTable();
        tableInvoiceHeader.getSelectionModel().addListSelectionListener(tableAction);jScroll2 = new javax.swing.JScrollPane();

        invoicebutton = new javax.swing.JButton();
        invoicebutton.addActionListener(controller);
        btnDeleteInvoice = new javax.swing.JButton();btnDeleteInvoice.addActionListener(controller);
        lineButton = new javax.swing.JButton();lineButton.addActionListener(controller);
        buttonDelet = new javax.swing.JButton();buttonDelet.addActionListener(controller);JMenu = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();OpenMenu = new javax.swing.JMenuItem();
        OpenMenu.addActionListener(controller);SaveMenuItem = new javax.swing.JMenuItem();
        SaveMenuItem.addActionListener(controller);
        tableInvoiceLines = new javax.swing.JTable();
        invoiceNum = new javax.swing.JLabel();invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        TotalCost = new javax.swing.JLabel();labelCustomerName = new javax.swing.JLabel();
        labelTostalCost = new javax.swing.JLabel();
        labelInvoiceDate = new javax.swing.JLabel();labelInvoiceNum = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tableInvoiceHeader.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceHeader.setShowGrid(true);
        jScroll1.setViewportView(tableInvoiceHeader);

        tableInvoiceLines.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        tableInvoiceLines.setShowGrid(true);
        jScroll2.setViewportView(tableInvoiceLines);
        tableInvoiceLines.getAccessibleContext().setAccessibleName("");

        invoiceNum.setText("Invoice Number:");invoiceDate.setText("Invoice Date:");

        customerName.setText("Customer Name:");TotalCost.setText("Invoice Total :");

        labelCustomerName.setText("-");labelTostalCost.setText("-");

        labelInvoiceDate.setText("-");labelInvoiceNum.setText("-");invoicebutton.setText("Create New Invoice");

        btnDeleteInvoice.setText("Delete Invoice");lineButton.setText("New Line");

        buttonDelet.setText("Delete Line");Menu.setText("File");OpenMenu.setText("Open File");
        OpenMenu.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenMenuItemActionPerformed(evt);
            }
        });
        Menu.add(OpenMenu);SaveMenuItem.setText("Save File");
        Menu.add(SaveMenuItem);JMenu.add(Menu);

        setJMenuBar(JMenu);
        JMenu.getAccessibleContext().setAccessibleName("");

        javax.swing.GroupLayout obj = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(obj);
        obj.setHorizontalGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(obj.createSequentialGroup().addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(obj.createSequentialGroup().addContainerGap().addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE).addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(obj.createSequentialGroup().addGap(17, 17, 17).addComponent(invoiceNum)).addGroup(obj.createSequentialGroup().addGap(18, 18, 18)
                                                                             .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)

                                                                                     .addGroup(obj.createSequentialGroup().addComponent(TotalCost).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                                                                             .addComponent(labelTostalCost)).addGroup(obj.createSequentialGroup()
                                                                                            .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(customerName)

                                                                                                    .addComponent(invoiceDate)).addGap(18, 18, 18)


                                                                                             .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(labelInvoiceDate)


                                                                                                    .addComponent(labelCustomerName)
                                                                                                    .addComponent(labelInvoiceNum))))))).addGroup(obj.createSequentialGroup().addGap(30, 30, 30)
                                                                .addComponent(invoicebutton)

                                .addGap(35, 35, 35)

                                                                .addComponent(btnDeleteInvoice)

                                .addGap(65, 65, 65)
                                                                .addComponent(lineButton)

                                                                .addGap(110, 110, 110)

                                                                .addComponent(buttonDelet)))
                                                .addContainerGap(21, Short.MAX_VALUE))
        );
        obj.setVerticalGroup(
                obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(obj.createSequentialGroup()

                                .addContainerGap().addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)

                                                                                                         .addGroup(obj.createSequentialGroup()
                                                .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                                                .addComponent(invoiceNum).addComponent(labelInvoiceNum)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)


                                                .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)


                                                                                             .addComponent(invoiceDate).addComponent(labelInvoiceDate))

                                                                                             .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)

                                                .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(customerName).addComponent(labelCustomerName))
                                                                                                                 .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                                                                                                         .addComponent(TotalCost).addComponent(labelTostalCost))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jScroll2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))


                                        .addComponent(jScroll1, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

                                        .addComponent(invoicebutton).addGroup(obj.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)

                                                .addComponent(btnDeleteInvoice)
                                                .addComponent(lineButton)
                                                .addComponent(buttonDelet))).addContainerGap(20, Short.MAX_VALUE))
        );


        invoiceDate.getAccessibleContext().setAccessibleName("jLabel2");

        pack();
    }

    private void OpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {

    }
    private javax.swing.JLabel invoiceNum;
    private javax.swing.JLabel TotalCost;
    private javax.swing.JScrollPane jScroll1;

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(invoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(invoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(invoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(invoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                invoiceFrame frame= new invoiceFrame();frame.setVisible(true);
                operations fileOperations = new operations(frame);
                ArrayList<invoiceHeader> inv= fileOperations.readFile();frame.setInvoices(inv);
                InvioceTabel invoiceTable = new InvioceTabel(inv);frame.setTabel(invoiceTable);
                frame.getTableHeader().setModel(invoiceTable);frame.getHeaderTabel().fireTableDataChanged();

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar JMenu;private javax.swing.JMenu Menu;
    private javax.swing.JMenuItem OpenMenu;private javax.swing.JMenuItem SaveMenuItem;
    private javax.swing.JButton btnDeleteInvoice;

    private javax.swing.JScrollPane jScroll2;private javax.swing.JLabel labelCustomerName;private javax.swing.JLabel labelInvoiceDate;
    private javax.swing.JLabel labelInvoiceNum;private javax.swing.JLabel labelTostalCost;private javax.swing.JTable tableInvoiceHeader;private javax.swing.JTable tableInvoiceLines;


    public JLabel getinvoiceDate() {
        return labelInvoiceDate;
    }

    public Controller getController() {
        return controller;
    }
    public void setinvoiceDate(JLabel labelInvoiceDate) {
        this.labelInvoiceDate = labelInvoiceDate;
    }public JLabel getLabelInvoiceNum() {
        return labelInvoiceNum;
    }
    public void setInvoiceNum(JLabel labelInvoiceNum) {
        this.labelInvoiceNum = labelInvoiceNum;
    }
    public void setLines(ArrayList<invoiceLine> lines) {
        this.lines = lines;
    }private InvioceTabel Tabel;

    public InvioceTabel getHeaderTabel() {
        return Tabel;
    }public void setTabel(InvioceTabel headerTabel){
        this.Tabel= headerTabel;
    }
    public ArrayList<invoiceHeader> getInvoices(){
        if(invoices==null){
            invoices= new ArrayList<>();
        }
        return invoices;
    }

    public void setInvoices(ArrayList<invoiceHeader> invoices) {
        this.invoices= invoices;
    }

    public JLabel getCustomer() {
        return customerName;
    }

    public JLabel getInvoiceDate() {
        return invoiceDate;
    }public JLabel getInvoiceNum() {
        return invoiceNum;
    }

    public JLabel getTotalCost() {
        return TotalCost;
    }public JLabel getCustomerName() {
        return labelCustomerName;
    }

    public JLabel getTostalCost() {
        return labelTostalCost;
    }public JTable getTableHeader() {
        return tableInvoiceHeader;
    }

    public JTable getTablLines() {
        return tableInvoiceLines;
    }public Controller getLisener(){
        return controller;
    }
    public void setCustomerLabel(String name){
        labelCustomerName.setText(name);
    }


    public void setCustomerName(String name){
        tableInvoiceHeader.setName(name);

    }
    public int TotainvoiceNumber(){
        int num=0;
        for(invoiceHeader invoice: invoices){
            if(invoice.getinvoicnum()>num){
                num= invoice.getinvoicnum();
            }
        }

        return num;
    }
    private Controller controller = new Controller(this);private ActiosTT tableAction = new ActiosTT(this);public  SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
    private ArrayList<invoiceHeader> invoices;private ArrayList<invoiceLine> lines;
    private javax.swing.JButton buttonDelet;private javax.swing.JButton invoicebutton;
    private javax.swing.JButton lineButton;private javax.swing.JLabel customerName;
    private javax.swing.JLabel invoiceDate;

}


