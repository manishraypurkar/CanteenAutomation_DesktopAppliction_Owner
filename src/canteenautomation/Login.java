package canteenautomation;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import javax.swing.*;

//import com.mysql.jdbc.PreparedStatement;

 public class Login extends JFrame implements  ActionListener {
     
     
    JLabel logo =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\Canteen.PNG"));
    
        //JLabel info =new JLabel("@ DESINGED & DEVELOPED BY MANISH RAYPURKAR");

    
    JLabel label =new JLabel ("LOGIN");    
    JLabel head=new JLabel ("WELCOME TO CANTEEN AUTOMATION");
    JLabel luname =new JLabel ("USERNAME :");    
    JLabel lpass =new JLabel ("PASSWORD :");    


    JButton login = new JButton ("LOGIN");
    JTextField username =new JTextField(20);
    JPasswordField password =new JPasswordField(20);
    
    JPanel p =new JPanel();
   
    
    	Login()
    	{   
    		p.setLayout(null);
    
    		logo.setBounds(300,530,600,300);
    		//info.setBounds(430,910,400,60);

    		head.setBounds(320,2,700,200);
    		label.setBounds(550,100,200,100);
    		luname.setBounds(350,200,200,50);
    		lpass.setBounds(350,300,200,50);
    		username.setBounds(500,200,200,50);
    		password.setBounds(500,300,200,50);
    		login.setBounds(500,400,200,50);
  
        
              
    		label.setForeground(Color.GREEN);
    		login.setForeground(Color.BLACK);
    		login.setBackground(Color.WHITE);
                
       // info.setForeground(Color.GREEN);
        //info.setFont(new Font ("ARIAL",Font.BOLD,20));

    		label.setFont(new Font ("Bradley Hand ITC",Font.BOLD,30));
    		login.setFont(new Font ("Bradley Hand ITC",Font.BOLD,25));
    		head.setFont(new Font ("Bradley Hand ITC",Font.BOLD,30));
        
    		username.setFont(new Font ("Bradley Hand ITC",Font.BOLD,25));
    		password.setFont(new Font ("Bradley Hand ITC",Font.BOLD,25));
    		luname.setFont(new Font ("Bradley Hand ITC",Font.BOLD,20));
    		lpass.setFont(new Font ("Bradley Hand ITC",Font.BOLD,20));

         p.add(logo);
       //  p.add(info);

    		p.add(head);
    		p.add(label);
    		p.add(luname);
    		p.add(lpass);
    		p.add(username);
    		p.add(password);
    		p.add(login);
         
    		add(p);
    		setResizable(false);
    		setLocation(300,50);
    		setTitle("LOGIN");
    		setSize(1200,900);
    		setLocationRelativeTo(null);
    		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        
        
    		login.addActionListener(this);
    	}
    
   
   
   
  
    	public void actionPerformed(ActionEvent e)
    	{
    		/*String uname = username.getText();
			String pwd = password.getText();
			if(uname.equals("admin") && pwd.equals("admin")) {
			Home h =new Home();
			h.setVisible(true);
			dispose();
			} else {
		
			JOptionPane.showMessageDialog(null,"Wrong Password / Username");
			username.setText("");
			password.setText("");
			username.requestFocus();
			} */    
	  
	     //try
	     //{
	    	 
	    	//Database obj=new Database();
	 	    //String query ="select * from admin where UserName=? and Password=?" ;   
	 	    //Connection con=null;
	 	    //ResultSet rs;
	 	    //con= obj.establish();
	 	    String user= username.getText();
		    String pass=password.getText();
	         
		    //PreparedStatement stmt=con.prepareStatement("select * from admin where UserName=? and Password=?");
		    //stmt.setString(1, x);
		    //stmt.setString(2, y);
		    //rs=stmt.executeQuery();
		     
		     
		     
		     if(user.equals("admin") && pass.equals("admin"))
		     {
		    
//		         if(x.equalsIgnoreCase(rs.getString("UserName")) &&  y.equals(rs.getString("Password")) )
//		         {
		        	 Home h =new Home();
		        	 h.setVisible(true);
		        	 dispose();
		        	 System.out.println("login successfully");
		         //}
		        
//		         else  
//		         {
//		        	
//		         }
		        
		     }
		     else
		     {
		    	 System.out.println("wrong credentials");
	              
	        	 JOptionPane.showMessageDialog(null,"Wrong Password / Username","wrong data",JOptionPane.INFORMATION_MESSAGE);
	        	 username.setText("");
	        	 password.setText("");
	        	 username.requestFocus();
		    	 System.out.println("no admin login");
		     }
		     
	     
	     //}
	    /* catch(Exception ex)
	     {
	         
	         	int n=ex.getErrorCode();
	         	if(n==ex.getErrorCode())
	         	{
	         			JOptionPane.showMessageDialog(null,"CHECK YOUR CONNECTION","CONNECTION LOSS..!",JOptionPane.INFORMATION_MESSAGE);
	         	}
	
	     }*/
    

     }
}
