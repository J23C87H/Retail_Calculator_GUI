package retailcalc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class RetailCalc {


    public static void main(String[] args) {
        
        // Setting up JFrame
        JFrame frame = new JFrame();
        frame.setTitle("Retail Calculator");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Setting up JFrame
        JPanel p = new JPanel();
        p.setBackground(Color.LIGHT_GRAY);
        p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
        p.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //Item Label & TextField
        JLabel itemLab = new JLabel("Item Name");        
        JTextField item = new JTextField(20);
        item.setMaximumSize(item.getPreferredSize());
        item.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemLab.setAlignmentX(Component.CENTER_ALIGNMENT);
        itemLab.setFont(itemLab.getFont().deriveFont(16f));
        
        //Original Price Label & TextField
        JLabel orgPriceLab = new JLabel("Original Price");        
        JTextField orgPrice = new JTextField(20);
        orgPrice.setMaximumSize(orgPrice.getPreferredSize());
        orgPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        orgPriceLab.setAlignmentX(Component.CENTER_ALIGNMENT);        
        orgPriceLab.setFont(orgPriceLab.getFont().deriveFont(16f));
        
        //Percentage Discount Label & TextField
        JLabel discountLab = new JLabel("Discount (Decimal Form)");        
        JTextField discount = new JTextField(20);
        discount.setMaximumSize(discount.getPreferredSize());        
        discount.setAlignmentX(Component.CENTER_ALIGNMENT);
        discountLab.setAlignmentX(Component.CENTER_ALIGNMENT);        
        discountLab.setFont(discountLab.getFont().deriveFont(16f));        
        
        //New Price Label & Unedittable TextField 
        JLabel newPriceLab = new JLabel("Sale Price");                
        JTextField newPrice = new JTextField(20);
        newPrice.setEditable(false);
        newPrice.setMaximumSize(newPrice.getPreferredSize());        
        newPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        newPriceLab.setAlignmentX(Component.CENTER_ALIGNMENT);        
        newPriceLab.setFont(newPriceLab.getFont().deriveFont(16f));         
        
        //Department Label holder invisible
        JLabel dept1 = new JLabel();
         
        //Creating department JComboBox & Label
        JLabel depLab = new JLabel("Department");
        depLab.setAlignmentX(Component.CENTER_ALIGNMENT);  
        depLab.setFont(depLab.getFont().deriveFont(16f)); 
        String[] names = {"Electronics", "Clothing", "Toys", "Automotive", "Crafts"};
        JComboBox department = new JComboBox(names);
        department.setSize(400, 400);
        department.setMaximumSize(department.getPreferredSize());
        department.setAlignmentX(Component.CENTER_ALIGNMENT);          
        
        //Creating JTable for Results & Label
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JLabel tabLab = new JLabel("Results");
        tabLab.setAlignmentX(Component.CENTER_ALIGNMENT);  
        tabLab.setFont(tabLab.getFont().deriveFont(16f));
        
        //Column headers
        model.addColumn("Item Name");
        model.addColumn("Department");
        model.addColumn("Original Price");
        model.addColumn("Sale Price");
        
        //Table Scrollbar
        table.setPreferredScrollableViewportSize(new Dimension (450,63));
        table.setFillsViewportHeight(true);
        JScrollPane jps = new JScrollPane(table);
        
        //Calculate JButton and ActionListener
        JButton calc = new JButton("Calculate");
        calc.setSize(200, 200);
        calc.setMaximumSize(calc.getPreferredSize());
        calc.setAlignmentX(Component.CENTER_ALIGNMENT);  
        calc.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                
                //Converting TextField data into double
                String orgPriceValue = orgPrice.getText();
                String discountValue = discount.getText();
                double newOrgPrice = Double.parseDouble(orgPriceValue);
                double newDiscountValue = Double.parseDouble(discountValue);
                double finalPrice;
                
                //Determining finalPrice of item
                finalPrice = newOrgPrice - newDiscountValue * newOrgPrice;
                
                //Converting finalPrice to String
                newPrice.setText(Double.toString(finalPrice));
                
                //Converting department Object to String
                String dept = (String)department.getSelectedItem();
                dept1.setText(dept);
                
                //Adding item name, department, orginal price, & new price to JTable 
                model.addRow(new String[] {item.getText(),dept1.getText(),orgPrice.getText(),newPrice.getText()});
            }
        });
        
        //Adding actionlistener to Exit JButton
        JButton exit = new JButton("Exit");
        exit.setSize(200, 200);
        exit.setMaximumSize(exit.getPreferredSize());
        exit.setAlignmentX(Component.CENTER_ALIGNMENT);  
        exit.addActionListener(new Action());
        
        //Adding objects to JPanel
        p.add(itemLab);        
        p.add(item);
        p.add(orgPriceLab);        
        p.add(orgPrice);
        p.add(discountLab);        
        p.add(discount);
        p.add(newPriceLab);        
        p.add(newPrice);
        p.add(depLab);
        p.add(department);
        p.add(calc);
        p.add(exit);
        p.add(tabLab);
        p.add(jps);
        
        //Adding JPanel to JFrame and setting to visible
        frame.getContentPane().add(p);
        frame.setVisible(true);
        
    }
    
     //Adding ActionListener for exit button.
    private static class Action implements ActionListener {
        public void actionPerformed (ActionEvent e){
                
            System.exit(0);
        }
            
    }
    

}
