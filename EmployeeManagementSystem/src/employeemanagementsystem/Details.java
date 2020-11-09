package employeemanagementsystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author aditya
 */
public class Details extends JFrame implements ActionListener {
    
    JLabel l1,l2;
    JButton add, remove, update, view;
    
    Details(){
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("Employee Management System");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"Employee Mangement System");
        
        setLayout(null);
        setBackground(Color.white);
        
        l1 = new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/displaypage.jpg"));
        l1.setIcon(i1);
        add(l1);
        
        l2 = new JLabel("Employee Details");
        l2.setForeground(Color.black);
        l2.setBounds(430,20,200,40);
        l1.add(l2);
        
        add = new JButton("Add");
        add.setBounds(420,80,100,40);
        add.addActionListener(this);
        l1.add(add);
        
        remove = new JButton("Remove");
        remove.setBounds(530,80,100,40);
        remove.addActionListener(this);
        l1.add(remove);
        
        update = new JButton("Update");
        update.setBounds(420,140,100,40);
        update.addActionListener(this);
        l1.add(update);
        
        view = new JButton("View");
        view.setBounds(530,140,100,40);
        view.addActionListener(this);
        l1.add(view);
        
        setVisible(true);
        setSize(700,500);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == add){
            new Add_Employee().setVisible(true);
            setVisible(false);
        }else
        if(e.getSource() == update){
            new Search_Employee().setVisible(true);
            setVisible(false);
        }
        else if(e.getSource() == remove){
            new Remove_Employee().setVisible(true);
            setVisible(false);
        }
        else if(e.getSource() == view){
            new view_employee().setVisible(true);
            setVisible(false);
        }
        
        
    }
    
    public static void main(String[] args) {
        new Details().setVisible(true);
    }
    
}
