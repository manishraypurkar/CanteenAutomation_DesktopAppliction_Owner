/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenautomation;
import java.sql.*;
import javax.swing.JOptionPane;


public class Database {
    
    

	//String name= "com.mysql.jdbc.Driver";
        
        String url ="jdbc:mysql://localhost:3306/canteen";
	static final String user ="Manish";
	static final String pass ="Manish@123";
     
    Connection con;
Connection establish()
{
   
    try {
          con =DriverManager.getConnection(url,user,pass);
         // System.out.println("connection establish");
     
    }
    catch (SQLException e)
    {
        e.printStackTrace();
       
     
       JOptionPane.showMessageDialog(null,"CHECK YOUR CONNECTION","CONNECTION LOSS..!",JOptionPane.INFORMATION_MESSAGE);
    }
         return con;
    
   
}

}
