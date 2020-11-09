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
public class Add_Employee extends JFrame implements ActionListener{
    
    JLabel title, name, age, address, email, post, id, fname, dob, phone, education, aadharNo, image ;
    JButton submit, cancel;
    JTextField nameF, ageF, addressF, emailF, postF, idF, dobF, fnameF, phoneF, educationF, aadharF;
    
    Add_Employee(){
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
        image.setBounds(0,0,900,700);
        image.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/displaypage.jpg"));
        image.setIcon(img);
        add(image);
        
        title = new JLabel("New Employee Details");
        title.setFont(new Font("serif",Font.ITALIC,25));
        title.setBounds(320,30,500,50);
        title.setForeground(Color.BLACK);
        image.add(title);
        
        name  =  new JLabel("Name");
        name.setFont(new Font("serif", Font.BOLD,20));
        name.setBounds(50,150,100,30);
        name.setForeground(Color.BLACK);
        image.add(name);
        
        
        age  =  new JLabel("Age");
        age.setFont(new Font("serif", Font.BOLD,20));
        age.setBounds(50,200,100,30);
        age.setForeground(Color.BLACK);
        image.add(age);
        
        address =  new JLabel("Address");
        address.setFont(new Font("serif", Font.BOLD,20));
        address.setBounds(50,250,100,30);
        address.setForeground(Color.BLACK);
        image.add(address);
        
        email  =  new JLabel("Email ID");
        email.setFont(new Font("serif", Font.BOLD,20));
        email.setBounds(50,300,100,30);
        email.setForeground(Color.BLACK);
        image.add(email);
        
        post  =  new JLabel("Job Post");
        post.setFont(new Font("serif", Font.BOLD,20));
        post.setBounds(50,350,100,30);
        post.setForeground(Color.BLACK);
        image.add(post);
        
        id  =  new JLabel("ID");
        id.setFont(new Font("serif", Font.BOLD,20));
        id.setBounds(50,400,100,30);
        id.setForeground(Color.BLACK);
        image.add(id);
        
        fname  =  new JLabel("Father Name");
        fname.setFont(new Font("serif", Font.BOLD,20));
        fname.setBounds(400,150,150,30);
        fname.setForeground(Color.BLACK);
        image.add(fname);
        
        dob  =  new JLabel("Date of Birth");
        dob.setFont(new Font("serif", Font.BOLD,20));
        dob.setBounds(400,200,150,30);
        dob.setForeground(Color.BLACK);
        image.add(dob);
        
        
        phone  =  new JLabel("Phone Number ");
        phone.setFont(new Font("serif", Font.BOLD,20));
        phone.setBounds(400,250,150,30);
        phone.setForeground(Color.BLACK);
        image.add(phone);
        
        education  =  new JLabel("Education");
        education.setFont(new Font("serif", Font.BOLD,20));
        education.setBounds(400,300,100,30);
        education.setForeground(Color.BLACK);
        image.add(education);
        
        aadharNo  =  new JLabel("Aadhar Number");
        aadharNo.setFont(new Font("serif", Font.BOLD,20));
        aadharNo.setBounds(400,350,150,30);
        aadharNo.setForeground(Color.BLACK);
        image.add(aadharNo);
        
        nameF = new JTextField();
        nameF.setBounds(200,150,150,30);
        image.add(nameF);
        
        ageF = new JTextField();
        ageF.setBounds(200,200,150,30);
        image.add(ageF);
        
        addressF = new JTextField();
        addressF.setBounds(200,250,150,30);
        image.add(addressF);
        
        emailF = new JTextField();
        emailF.setBounds(200,300,150,30);
        image.add(emailF);
        
        postF = new JTextField();
        postF.setBounds(200,350,150,30);
        image.add(postF);
        
        idF = new JTextField();
        idF.setBounds(200,400,150,30);
        image.add(idF);
        
        fnameF = new JTextField();
        fnameF.setBounds(600,150,150,30);
        image.add(fnameF);
        
        dobF = new JTextField();
        dobF.setBounds(600,200,150,30);
        image.add(dobF);
        
        phoneF = new JTextField();
        phoneF.setBounds(600,250,150,30);
        image.add(phoneF);
        
        educationF = new JTextField();
        educationF.setBounds(600,300,150,30);
        image.add(educationF);
        
        aadharF = new JTextField();
        aadharF.setBounds(600,350,150,30);
        image.add(aadharF);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,550,150,40);
        
        image.add(submit);

        cancel=new JButton("Cancel");   
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(450,550,150,40);
        
        image.add(cancel);
        
        submit.addActionListener(this);
        cancel.addActionListener(this);
        
        setSize(900,690);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        String name = nameF.getText();
        String age = ageF.getText();
        String address = addressF.getText();
        String email = emailF.getText();
        String post = postF.getText();
        String id = idF.getText();
        String fname = fnameF.getText();
        String dob = dobF.getText();
        String phone = phoneF.getText();
        String education = educationF.getText();
        String aadhar = aadharF.getText();
        
        if(e.getSource() == submit){
            try{
                Conn c = new Conn();
                String q = "insert into employee values('"+id+"','"+name+"','"+address+"','"+email+"','"+post+"','"+fname+"','"+dob+"','"+phone+"','"+education+"','"+aadhar+"','"+age+"')";
                c.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                setVisible(false);
                new Details();
              
            }
            catch(Exception exc){
                exc.printStackTrace();
            }
        } else if(e.getSource() == cancel){
            setVisible(false);
            new Details();
        }
    }
    
    public static void main(String[] args) {
        new Add_Employee().setVisible(true);
    }
    
    
}
