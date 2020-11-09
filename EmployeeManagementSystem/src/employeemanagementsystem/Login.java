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
public class Login extends JFrame implements ActionListener{
    
    JLabel username, password;
    JButton b1, b2;
    JTextField f1;
    JPasswordField f2;
    
    
    Login(){
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
        
        username = new JLabel("Username");
        username.setBounds(40,20,100,30);
        add(username);
       
        password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        add(password);
        
        f1 = new JTextField();
        f1.setBounds(150,20,100,30);
        add(f1);
        
        f2 = new JPasswordField();
        f2.setBounds(150,70,100,30);
        add(f2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/Login.png"));
        Image i2 = i1.getImage().getScaledInstance(150,750,Image.SCALE_DEFAULT);
        ImageIcon login_Image = new ImageIcon(i2);
        JLabel icon_label = new JLabel(login_Image);
        icon_label.setBounds(350,20,100,100);
        add(icon_label);
        
        b1 = new JButton("Login");
        b1.setBounds(40,140,120,30);
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        add(b1);
        b1.addActionListener(this);
        
        b2 = new JButton("Cancel");
        b2.setBounds(180,140,120,30);
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        add(b2);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.white);
        setVisible(true);
        setSize(600,300);
        
        
 
    }


    @Override
    public void actionPerformed(ActionEvent ae) {
        
        try{
            Conn c = new Conn();
            String username = f1.getText();
            String pswd = f2.getText();
         
            String q = "select * from login where username = '"+username+"' and password ='"+pswd+"'";
            ResultSet rs = c.s.executeQuery(q);
            
            if(rs.next()){
                new Details();
                setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid login");
            }
            
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
