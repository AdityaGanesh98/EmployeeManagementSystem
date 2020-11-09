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
public class Remove_Employee extends JFrame implements ActionListener {
    JLabel id,name,email,phone,image;
    JLabel p_name,p_email,p_phone;
    JButton search,remove, cancel,back;
    JTextField idf;
    
    Remove_Employee(){
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
        setVisible(true);
        setSize(900,700);
        
        image = new JLabel();
        image.setBounds(0,0,900,700);
        image.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/displaypage.jpg"));
        image.setIcon(img);
        add(image);
        
        id=new JLabel("Employee Id");
        id.setBounds(50,50,250,30);
        id.setForeground(Color.white);
        Font f2 = new Font("serif",Font.BOLD,25); 
        id.setFont(f2);
        add(id);
        
        idf = new JTextField();
        idf.setBounds(250,50,150,30);
        image.add(idf);


        search = new JButton("Search");
        search.setBounds(200,100,100,30);
        search.addActionListener(this);
        image.add(search);

        back = new JButton("back");
        back.setBounds(360,100,100,30);   
        back.addActionListener(this);
        image.add(back);
        
        name = new JLabel("Name:"); 
        name.setBounds(50,150,250,30);
        name.setForeground(Color.white);
        Font f3 = new Font("serif",Font.BOLD,20); 
        name.setFont(f3);
        image.add(name);
        
        phone = new JLabel("Mobile No:");
        phone.setBounds(50,200,250,30);
        phone.setForeground(Color.white);
        Font f4 = new Font("serif",Font.BOLD,20); 
        phone.setFont(f4);
        image.add(phone);
        
        email = new JLabel("Email Id:");
        email.setBounds(50,250,250,30);
        email.setForeground(Color.white);
        Font F5=new Font("serif",Font.BOLD,20); 
        email.setFont(F5);
        image.add(email);
        
        remove = new JButton("Remove");
        remove.setBounds(120,300,100,30);
        remove.addActionListener(this);
        image.add(remove);

        cancel = new JButton("Cancel");
        cancel.setBounds(300,300,100,30);
        cancel.addActionListener(this);
        image.add(cancel);
        
        p_name=new JLabel();    
        p_name.setBounds(200,150,350,30);
        p_name.setForeground(Color.white);
        Font F6=new Font("serif",Font.BOLD,20); 
        p_name.setFont(F6);
        image.add(p_name);
        
        p_phone=new JLabel();
        p_phone.setBounds(200,200,350,30);
        p_phone.setForeground(Color.white);
        Font F7=new Font("serif",Font.BOLD,20); 
        p_phone.setFont(F7);
        image.add(p_phone);
        
        p_email = new JLabel();
        p_email.setBounds(200,250,350,30);
        p_email.setForeground(Color.white);
        Font f8=new Font("serif",Font.BOLD,20); 
        p_email.setFont(f8);
        image.add(p_email);
        
        name.setVisible(false);
        email.setVisible(false);
        phone.setVisible(false);
        remove.setVisible(false);
        cancel.setVisible(false);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            try{
                Conn c = new Conn();
                String q = "select * from employee where id = '"+idf.getText()+"'";
                ResultSet rs = c.s.executeQuery(q);
                boolean flag = false;
                
                if(rs.next()){
                  String d_name = rs.getString("name");
                  String d_phone = rs.getString("phone");
                  String d_email = rs.getString("email");
                  name.setVisible(true);
                  email.setVisible(true);
                  phone.setVisible(true);
                  remove.setVisible(true);
                  cancel.setVisible(true);
                  flag = true;
                  p_name.setText(d_name);
                  p_phone.setText(d_phone);
                  p_email.setText(d_email);
      
                }
                if(!flag){
                    JOptionPane.showMessageDialog(null,"Id not found");                 
                }   
            }
            catch(Exception exc){
                exc.printStackTrace();
            }
        }
        else if(e.getSource() == remove){
            try{
              Conn con = new Conn();
              String q = "delete from employee where id = '"+idf.getText()+"'";
              con.s.executeUpdate(q);
              JOptionPane.showMessageDialog(null,"deleted successfully");
              name.setVisible(false);
              email.setVisible(false);
              phone.setVisible(false);
              p_name.setVisible(false);
              p_email.setVisible(false);
              p_phone.setVisible(false);
              remove.setVisible(false);
              cancel.setVisible(false);
             
            }
            catch(Exception exc){
                exc.printStackTrace();
            }   
        }
        else if(e.getSource() == back){
            setVisible(false);
            new Details().setVisible(true);
        }
        else if(e.getSource() == cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Remove_Employee().setVisible(true);
    }
    
    
}
