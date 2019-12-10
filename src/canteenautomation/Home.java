
package canteenautomation;

import javax.swing.*;
import java .awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author manish raypurkar
 */
public class Home extends JFrame implements ActionListener {
	JButton update=new JButton("Update Food Details");
	JButton search=new JButton("Search Food Items");
	JButton log=new JButton("Logout");
	JButton details=new JButton("Show Details");
	
	JPanel p =new JPanel ();
	  
	JLabel back =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\blur-cafe-caffeine-302905.jpg"));
	
	JLabel data=new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\database.png"));
	
	
	
	//Border paneEdge=BorderFactory.createEmptyBorder(0, 10, 10, 10);
	
	Border blackline=BorderFactory.createLineBorder(Color.black,10);
	
	
	Home()
	{
	   
	
	    p.setLayout(null);
            
	    data.setBounds(900,60,200,70);
	    update.setBounds(419,190,350,50);
	    search.setBounds(419,270,350,50);
	    log.setBounds(419,440,350,50);
	    details.setBounds(419,360,350,50);
	 
	    //add.setBorder(blackline);
	    p.setBorder(blackline);
	    update.setBackground(Color.BLACK);
	    search.setBackground(Color.BLACK);
	    log.setBackground(Color.BLACK);
	    details.setBackground(Color.BLACK);
	    
	    update.setForeground(Color.GREEN);
	    search.setForeground(Color.GREEN);
	    log.setForeground(Color.GREEN);
	    details.setForeground(Color.GREEN);
	    
	    update.setFont(new Font ("Monotype Corsiva",Font.BOLD,30));
	    search.setFont(new Font ("Monotype Corsiva",Font.BOLD,30));
	    log.setFont(new Font ("Monotype Corsiva",Font.BOLD,30));
	    details.setFont(new Font ("Monotype Corsiva",Font.BOLD,30));
	       
	    p.add(log);
	    p.add(update);
	    p.add(search);
	    p.add(data);         
	    p.add(details);
	   
	
	    
	     getContentPane().add(p);
	     
	     
	     back.setBounds(0,0,1200,900);
	     p.add(back);
	     
	     
	     
	     
	        setLocation(300,50);
	        setTitle("HOME(CANTEEN AUTOMATION)");
	        setSize(1200,900);
	        setLocationRelativeTo(null);
	        setResizable(false);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        update.addActionListener(this);
	        search.addActionListener(this);
	        log.addActionListener(this);
	        details.addActionListener(this);
	        
	        data.addMouseListener(new MouseAdapter() {
	           
	            public void mouseClicked(MouseEvent me)
	            {
	                ShowData sd =new ShowData();
	                sd.setVisible(true);
	                dispose();
	                sd.action();
	                
	            }
	
	        });
        details.addActionListener(new ActionListener() {
        

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Details d =new Details();
            d.setVisible(true);
            dispose();
            d.actionDetails();
            
		}
        });

 
	}
   
 
 
 public void actionPerformed(ActionEvent e)
 {

     String s=e.getActionCommand();
  
     /*if(s.equalsIgnoreCase("add food items"))
     {
         
       AddItem a =new AddItem();  
         a.setVisible(true);
             dispose();

     }*/
    
     if(s.equalsIgnoreCase("update food details"))
     {
        UpdateFood u =new UpdateFood();
        u.setVisible(true);
            dispose();

     }
 
     else if(s.equalsIgnoreCase("search food items"))
     {
         SearchFood sf =new SearchFood();
                  sf.setVisible(true);
                                      dispose();

     }
     
     /*else if(s.equalsIgnoreCase("Show Details"))
     {
         
         Details d=new Details();
                  d.setVisible(true);
                         dispose();
                        // d.actionDetails();


     }*/
     
 
     else if(s.equalsIgnoreCase("Logout"))
     {
               int input = JOptionPane.showConfirmDialog(null," ARE YOU SURE ?","LOGOUT",JOptionPane.YES_OPTION,JOptionPane.INFORMATION_MESSAGE);
                
                       System.out.println(input);
                       
                       if (input==0)
                       {
                          Login l=new Login();
                          l.setVisible(true);
                          dispose(); 
                          
                       }

 
     }
 
 
 

 }
}



