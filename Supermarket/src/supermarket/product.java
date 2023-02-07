/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supermarket;

/**
 *
 * @author zahra
 */

import java.awt.*;
import javax.swing.table.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
import javax.swing.JTable;




public class product //extend sections  
{
    JTable jTable1;
    
        
        
        private void PriceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_PriceKeyTyped

    }//GEN-LAST:event_PriceKeyTyped

    private void QtyKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_QtyKeyTyped

    }//GEN-LAST:event_QtyKeyTyped

    private void ADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ADDActionPerformed
        // TODO add your handling code here:

        User s1 = new User();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

        while (id.getText().equals("") || name.getText().equals("") || price.getText().equals("") || quantity.getText().toString().equals("") 
                || category.getText().toString().equals("")) {
            JOptionPane.showMessageDialog(null, "Please fill in the required fields");
            return;
        }
        try {
            int Quantity = Integer.parseInt(guantity.getText());
            int Pr = Integer.parseInt(price.getText());
            if (Quantity <= 0 || Pr <= 0) {
                JOptionPane.showMessageDialog(this, "Enter only positive integer value");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter Only integer value");
            return;
        }

        String Id;
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            Id = model.getValueAt(i, 0).toString().trim();
            if (id.getText().equals(Id)) {
                JOptionPane.showMessageDialog(null, "Product ID should be Unique");
                return;
            }
        }

        s1.setId(id.getText().trim());
        s1.setName(name.getText().trim());
        s1.setPrice(price.getText().trim());
        s1.setQty(quantity.getText().trim());
        s1.setCat(category.getText().trim());

        //Addding data to Txt File
        ProductAddMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQuantity(), s1.getCat());
        //Adding Data to Jtable
        model.addRow(new Object[]{s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat()});
        JOptionPane.showMessageDialog(this, "Data Successfully Added.");

        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");

    }//GEN-LAST:event_ADDActionPerformed

    private void EDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EDITActionPerformed
        // TODO add your handling code here:

        ProductManager s1 = new ProductManager();

        s1.setId(Product.getText().trim());
        s1.setName(Name.getText().trim());
        s1.setPrice(Price.getText().trim());
        s1.setQty(Qty.getText().trim());
        s1.setCat(Cat.getText().trim());
        //Addding the edited data and deleting the privious data from Txt File
        try {
            int Quantity = Integer.parseInt(Qty.getText());
            int Pr = Integer.parseInt(Price.getText());
            if (Quantity <= 0 || Pr <= 0) {
                JOptionPane.showMessageDialog(this, "Enter only positive integer value");
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter Only integer value");
            return;
        }

        ProductEDeleteMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat());
        ProductAddMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat());
 
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRowCount() == 1) {
            //if single row is selected than update

            while (Product.getText().equals("") || Name.getText().equals("") || Price.getText().equals("") || Qty.getText().toString().equals("") || Cat.getText().toString().equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill in the required fields");
                return;
            }

            String prod = Product.getText();
            String nam = Name.getText();
            String price = Price.getText();
            String qty = Qty.getText();
            String cat = Cat.getText();
            //set update value
            model.setValueAt(prod, jTable1.getSelectedRow(), 0);
            model.setValueAt(nam, jTable1.getSelectedRow(), 1);
            model.setValueAt(price, jTable1.getSelectedRow(), 2);
            model.setValueAt(qty, jTable1.getSelectedRow(), 3);
            model.setValueAt(cat, jTable1.getSelectedRow(), 4);
            //Update message display
            JOptionPane.showMessageDialog(this, "Update Successfully..");
        } else {
            if (jTable1.getRowCount() == 0) {
                JOptionPane.showMessageDialog(this, "Table is Empty..");
            } else {
                //if row is not selected or multiple rows are selected
                JOptionPane.showMessageDialog(this, "Please Select Single Row to Update..");
            }

        }
        //editing from the file

        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");
        Product.setEditable(true);
    }//GEN-LAST:event_EDITActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        //Set Data to their Text Field
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        //set data to text field when row is selected
        String product = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
        String name = model.getValueAt(jTable1.getSelectedRow(), 1).toString();
        String price = model.getValueAt(jTable1.getSelectedRow(), 2).toString();
        String qty = model.getValueAt(jTable1.getSelectedRow(), 3).toString();
        String cat = model.getValueAt(jTable1.getSelectedRow(), 4).toString();

        //set to textfield
        Product.setText(product);
        Name.setText(name);
        Price.setText(price);
        Qty.setText(qty);
        Cat.setText(cat);

        Product.setEditable(false);
    }//GEN-LAST:event_jTable1MouseClicked

    private void CLEARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CLEARActionPerformed
        // TODO add your handling code here:
        Product.setText("");
        Name.setText("");
        Price.setText("");
        Qty.setText("");
        Cat.setText("");
        Product.setEditable(true);

    }//GEN-LAST:event_CLEARActionPerformed

    private void DELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DELETEActionPerformed
        // TODO add your handling code here:
        //Gettting jtable Model
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        ProductManager s1 = new ProductManager();
        s1.setId(Product.getText().trim());
        s1.setName(Name.getText().trim());
        s1.setPrice(Price.getText().trim());
        s1.setQty(Qty.getText().trim());
        s1.setCat(Cat.getText().trim());
        //Deleting the text from the file

        ProductDeleteMethod(s1.getId(), s1.getName(), s1.getPrice(), s1.getQty(), s1.getCat());
        //deleting row from the display GUI table
        if (jTable1.getSelectedRowCount() == 1) {
            //if row is selected than delete
            model.removeRow(jTable1.getSelectedRow());
        } else if (jTable1.getRowCount() == 0) {
            //if table is empty (no Data) than display message
            JOptionPane.showMessageDialog(this, "Table is Empty..");
        } else {
            //if table is not empty but row is not selected or multiply rows are selected
            JOptionPane.showMessageDialog(this, "Table is Empty or Muliple Rows are selected");

        }
        product.setText("");
        name.setText("");
        price.setText("");
        quantity.setText("");
        category.setText("");
        product.setEditable(true);
    }//GEN-LAST:event_DELETEActionPerformed

        
    
}
