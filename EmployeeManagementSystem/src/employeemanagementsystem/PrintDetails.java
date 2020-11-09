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
public class PrintDetails extends JFrame implements ActionListener {
    
    JButton back, cancel;
    String eid, ename, efather, eaddress, ephone, eemail, eeducation, epost, eage, edob, eaadhar;
    JLabel title, name, age, address, email, post, id, fname, dob, phone, education, aadharNo, image,  p_name, p_age, p_address, p_email, p_post, p_id, p_fname, p_dob, p_phone, p_education, p_aadhar; 
    
    PrintDetails(String eid){
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
        
        title = new JLabel("Employee Details");
        title.setForeground(Color.black);
        title.setBounds(250,20,200,40);
        title.setFont(new Font("serif",Font.BOLD,25));
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
        
        setVisible(true);
        setSize(900,690);
        
         try{
            Conn con = new Conn();
            String str = "select * from employee where id = '"+eid+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){

               
                ename = rs.getString("name");
                efather = rs.getString("Father_Name");
                eage = rs.getString("age");
                edob = rs.getString("Date_Of_Birth");
                eaddress = rs.getString("address");
                ephone = rs.getString("Phone");
                eemail = rs.getString("email");
                eeducation = rs.getString("Education");
                epost = rs.getString("Job_Post");
                eaadhar = rs.getString("aadhar");
                eid = rs.getString("id");
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
         
        p_name = new JLabel(ename);
        p_name.setBounds(200,150,150,30);
        image.add(p_name);
        
        p_age = new JLabel(eage);
        p_age.setBounds(200,200,150,30);
        image.add(p_age);
        
        p_address = new JLabel(eaddress);
        p_address.setBounds(200,250,150,30);
        image.add(p_address);
        
        p_email = new JLabel(eemail);
        p_email.setBounds(200,300,150,30);
        image.add(p_email);
        
        p_post = new JLabel(epost);
        p_post.setBounds(200,350,150,30);
        image.add(p_post);
        
        p_id = new JLabel(eid);
        p_id.setBounds(200,400,150,30);
        image.add(p_id);
        
        p_fname = new JLabel(efather);
        p_fname.setBounds(600,150,150,30);
        image.add(p_fname);
        
        p_dob = new JLabel(edob);
        p_dob.setBounds(600,200,150,30);
        image.add(p_dob);
        
        p_phone = new JLabel(ephone);
        p_phone.setBounds(600,250,150,30);
        image.add(p_phone);
        
        p_education = new JLabel(eeducation);
        p_education.setBounds(600,300,150,30);
        image.add(p_education);
        
        p_aadhar = new JLabel(eaadhar);
        p_aadhar.setBounds(600,350,150,30);
        image.add(p_aadhar);
        
        back = new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(200,550,150,40);
        
        image.add(back);

        cancel=new JButton("Cancel");   
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setBounds(400,550,150,40);
        
        image.add(cancel);
        
        back.addActionListener(this);
        cancel.addActionListener(this);
        
  

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()== back){
            setVisible(false);
            new view_employee().setVisible(true);
        }
        if(ae.getSource()== cancel){
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        
    }
    
}
