/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 *
 * @author aditya
 */
public class DisplayPage extends JFrame implements ActionListener {
    
    
    JLabel l1,l2;
    JButton b;
    
    DisplayPage(){
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
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("employeemanagementsystem/icons/displaypage.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1200,700,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
        l1.setBounds(0,150,1360,530);
        add(l1);
        
        b = new JButton("CLICK HERE TO CONTINUE");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(500,600,300,70);
        b.addActionListener(this);
        
        
        l2 = new JLabel();
        l2.setBounds(0,0,1360,750);
        l2.setLayout(null);
        l2.setVisible(true);
        add(l2);
        l2.add(b);
        
        JLabel title = new JLabel("Employee Management System");
        title.setBounds(220,30,1500,100);
        title.setFont(new Font("serif",Font.PLAIN,70));
        title.setForeground(Color.red);
        add(title);
        
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        setSize(1360,750);
       
        while(true){
            
            title.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){}
            
            title.setVisible(true);
            try{
                Thread.sleep(500);
            }
            catch(Exception e){}
            
        }
                
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == b){
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String[] args) {
        DisplayPage p = new DisplayPage();
        p.setVisible(true);
    }
    
}
