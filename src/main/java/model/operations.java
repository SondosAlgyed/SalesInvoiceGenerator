
package model;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JFileChooser;
import view.invoiceFrame;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class operations {
    private invoiceFrame frame;
    //headerFile name



    public operations(invoiceFrame frame) {
        this.frame = frame;
    }



 public ArrayList<invoiceHeader> readFile(){
     String headerPath;
    //items file name
     String elementPath;
        File headerFile ;
        File elementFile;
        List<String> headerLines=null;
        List<String> ElementLines=null;
        int outcome;
        ArrayList<invoiceHeader> invoceArr = new ArrayList<>();
     JFileChooser file = new JFileChooser();
     do

     {
         //do not close till the user chooses the right file
         outcome = file.showOpenDialog(frame);

         if (outcome == JFileChooser.APPROVE_OPTION)
         {
             elementFile = file.getSelectedFile();
             if(elementFile.getName().contains(".csv"))
             {
                 elementPath= elementFile.getAbsolutePath();
                 break;
             }
             else
             {
                 //display an error message
                 System.out.println("Wrong Items File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Element File Format");
             }

         }
     }


     while(true);


     JOptionPane.showMessageDialog(frame, "Please insert Headers File then Lines File");


            do{
                outcome = file.showOpenDialog(frame);
            if (outcome == JFileChooser.APPROVE_OPTION) {
                headerFile = file.getSelectedFile();
                if(headerFile.getName().contains(".csv")){
                    headerPath=headerFile.getAbsolutePath();
                    break;
                }
                else{//display an error message
                  System.out.println("Wrong Headers File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Format please insert the correct file again");
                }
            }
            }




            while(true);

            System.out.println(headerPath);
            System.out.println(elementPath);

                //ready each line in each file as string then save them in array of strings

            try
            {
                headerLines = Files.lines(Paths.get(headerPath)).collect(Collectors.toList());
            }
            catch (IOException ex)
            {
                System.out.println("Wrong Headers File Path");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Path");
            }


            try
            {
                ElementLines = Files.lines(Paths.get(elementPath)).collect(Collectors.toList());
            }
            catch (IOException ex)
            {
                System.out.println("Wrong Items File Path");
                 JOptionPane.showMessageDialog(frame, "Wrong Items File Patth");
            }



                        if(headerLines!=null && ElementLines !=null)
                        {
                        for (String Line : headerLines) {

                            String array[] = Line.split(",");
                            String numToString = array[0];
                            String date = array[1];
                            String customerName = array[2];
                            int num = Integer.parseInt(numToString);
                            //create new invoice and add it in  invArray
                            invoiceHeader invoice = new invoiceHeader(num, customerName, date);
                            invoceArr.add(invoice);
                            frame.getInvoices().add(invoice);

                        }

                }


                return invoceArr;



 }

 

 public invoiceHeader InvoiceByNum(int num)
 {
    for(invoiceHeader invoice : frame.getInvoices()){
        if(invoice.getinvoicnum()==num){
            return invoice;
        }
    }
        return null;
}

 public void savingFile(ArrayList<invoiceHeader> headers)
 {


        String invoices = "";
        String Elements = "";
        File headerFile;
        File lineFile;
        int outcome;

        for(invoiceHeader header: headers){
            String headerLines = header.getInvoicesFromTabel();
            invoices=invoices+headerLines;
            invoices=invoices+"\n";
            
            for(invoiceLine item : header.getItems())
            {
                String ElementFile = item.getItemsFromTabel();
                Elements = Elements+ElementFile;
                Elements = Elements+"\n";
            }
        }
        //open two file chooser to save these two strings inside the desired files if they are not found

        JOptionPane.showMessageDialog(frame, "please  choose the Headers file then Lines file");
        JFileChooser file = new  JFileChooser();
        do{//donot break till the user choose the right format
            outcome = file.showSaveDialog(frame);
                            if(outcome == JFileChooser.APPROVE_OPTION){
                                headerFile = file.getSelectedFile();
            if(headerFile.getName().contains(".csv"))
            {//write only in the correct file
                FileWriter headFileWriter = null;
                try
                {
                    headFileWriter = new FileWriter(headerFile);
                    headFileWriter.write(invoices);
                    headFileWriter.flush();
                    break;
                }
                catch (IOException ex)
                {
                    Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
                }


                }
                else
                {
                  System.out.println("Wrong Headers File Format");
                 JOptionPane.showMessageDialog(frame, "Wrong Headers File Format");  
                }
        }
        }while(true);
            
           
            do{//donot break till the user choose the right format
                outcome = file.showSaveDialog(frame);
            if(outcome == JFileChooser.APPROVE_OPTION)
            {
                lineFile= file.getSelectedFile();
                if(lineFile.getName().contains(".csv"))
                {//write only in the correct file
                    FileWriter lineFileWriter = null;
                    try
                    {
                        lineFileWriter = new FileWriter(lineFile);
                        lineFileWriter.write(Elements);
                        lineFileWriter.flush();
                        break;
                    }
                    catch (IOException ex)
                    {
                        Logger.getLogger(operations.class.getName()).log(Level.SEVERE, null, ex);
                    }

            }
            }
            else
            {

                 JOptionPane.showMessageDialog(frame, "Wrong Lines File Format");   
            }
        }
            while(true);
       
        
         }
}