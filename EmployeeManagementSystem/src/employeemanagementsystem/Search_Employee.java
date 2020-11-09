/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author aditya
 */
public class Search_Employee extends JFrame implements ActionListener {
    JLabel image, id;
    JTextField idf;
    JButton search, back;
    
    Search_Employee(){
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
        
        image = new JLabel();
        image.setBounds(0,0,500,270);
        image.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/displaypage.jpg"));
        image.setIcon(img);
        add(image);
        
        id = new JLabel("Employee Id");
        id.setFont(new Font("serif",Font.BOLD,25));
        id.setBackground(Color.white);
        id.setBounds(40,60,250,30);
        image.add(id);
        
        idf = new JTextField();
        idf.setBounds(240,60,220,30);
        image.add(idf);
        
        search = new JButton("Search");
        search.setBounds(240,150,100,30);
        search.addActionListener(this);
        image.add(search);
        
        back = new JButton("Back");
        back.setBounds(360,150,100,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setVisible(true);
        setSize(500,270);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = idf.getText();
        
        if(e.getSource() == back){
            new Details().setVisible(true);
            setVisible(false);
        }
        else if(e.getSource() == search){
            setVisible(false);
            new Update_Employee(id);
        }
    }
    
    public static void main(String[] args) {
        new view_employee();
    }
}
