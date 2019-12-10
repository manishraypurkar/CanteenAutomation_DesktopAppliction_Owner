package canteenautomation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
/**
 *
 * @author Admin
 */
public class Details extends JFrame{
    JPanel p =new JPanel();
    
   JLabel img =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\back48.png"));
   
     JLabel head=new JLabel("ALL DATA HERE");
     private final JButton btnTotalIncome = new JButton("Total Income");
     private JTextField textField;
     //private JTextField textField;
     //private JTextField textField_1;
    
    public Details() {
    	p.setLayout(null);
        
        img.setBounds(30,20,60,40);
        
       
        head.setBounds(450,20,400,50);
        head.setFont(new Font ("Monotype Corsiva",Font.BOLD,40));
        head.setForeground(Color.RED);

        p.add(head);
        p.add(img); 
        getContentPane().add(p);
        btnTotalIncome.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
        btnTotalIncome.setBounds(50, 521, 191, 63);
        
        p.add(btnTotalIncome);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        textField.setBounds(319, 521, 126, 63);
        p.add(textField);
        textField.setColumns(10);
        
       
        
       // JButton btnUpdate = new JButton("Update");
        //btnUpdate.addActionListener(new ActionListener() {
        
       
        
        
         setTitle("DATABASE");
        setLocation(350,50);
        setSize(1200,900);
        setLocationRelativeTo(null);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
          
        
        img.addMouseListener(new MouseAdapter(){ 
            
            public void mouseClicked(MouseEvent me)
    {
        Home h = new Home();
        h.setVisible(true);
        dispose();
    }}); 
        
        btnTotalIncome.addActionListener(new ActionListener() {
            

    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			 Database obj=new Database();
    	            Connection con=null;
    	            ResultSet rs;
    	            con= obj.establish();
    	            int price1=0;
    	            String price2;
    	            String query= "select * from canteen.details";
    	            try
    	            {
    	            	Statement st =con.createStatement();
    	                rs =st.executeQuery(query);
    	                while(rs.next())
    	                {
    	                	int price=rs.getInt("totalprice");
    	                	price1=price1+price;
    	                }
    	                price2=Integer.toString(price1);
    	                textField.setText(price2);
    	            }
    	            catch(Exception e)
    	            {
    	            	e.printStackTrace();
    	            }
                
    		}
            });
               
        
        
    }
    
    public void actionDetails(){
      Database obj=new Database();
            Connection con=null;
            ResultSet rs;
            con= obj.establish();
            
            String query= "select * from canteen.details order by clientid ASC;";
           


    
            try{
                Statement st =con.createStatement();
                rs =st.executeQuery(query);
                
                
                JTable t =new JTable();
                
                t.setModel(new DefaultTableModel(
                 new Object [][] {
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null},
                //{null, null, null, null}

            },
            new String [] {
               "clientid","orderid","item","quantity","totalprice",
            }));
                
        
                                    t.setFont(new Font ("Arial Unicode MS",Font.BOLD,18));
                                    t.setEnabled(false);
                                    t.setBounds(0,120,1200,350);
                                    t.setModel(DbUtils.resultSetToTableModel(rs));
                                    JTableHeader header= t.getTableHeader();
                                    header.setBounds(0,70,1200,50);
                                    header.setFont(new Font ("Arial Unicode MS",Font.BOLD,18));
                                    int vsb=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
                                    int hsb=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

                p.add(header);
                JScrollPane jsp=new JScrollPane(t,vsb,hsb);
                jsp.setBounds(0,120,1200,350);

                p.add(jsp);
                //jsp.add(t,vsb,hsb);
               
              }
            
            catch(SQLException ef)
            {
                ef.printStackTrace();
                
            }
            }
}
