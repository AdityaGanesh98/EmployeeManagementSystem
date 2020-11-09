/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employeemanagementsystem;

import java.sql.*;
/**
 *
 * @author aditya
 */
public class Conn {
    public Connection c;
    public Statement s;
    
    public Conn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employeeManagementSystem","root","");
            s = c.createStatement();
        }
        catch(Exception e){
            e.printStackTrace();
        
    }
    }
}

