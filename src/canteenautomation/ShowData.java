/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class ShowData extends JFrame{
    JPanel p =new JPanel();
    
   JLabel img =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\back48.png"));
   
     JLabel head=new JLabel("ALL DATA HERE");
     private JTextField textField;
     private JTextField textField_1;
    
    public ShowData() {
    	p.setLayout(null);
        
        img.setBounds(30,20,60,40);
        
       
        head.setBounds(450,20,400,50);
        head.setFont(new Font ("Monotype Corsiva",Font.BOLD,40));
        head.setForeground(Color.RED);

        p.add(head);
        p.add(img); 
        getContentPane().add(p);
        
        JLabel client = new JLabel("client id");
        client.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
        client.setBounds(30, 581, 104, 32);
        p.add(client);
        
        textField = new JTextField();
        textField.setFont(new Font("Arial Unicode MS", Font.BOLD, 20));
        textField.setBounds(157, 591, 86, 20);
        p.add(textField);
        textField.setColumns(10);
        
        JLabel status = new JLabel("new status");
        status.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
        status.setBounds(289, 581, 111, 32);
        p.add(status);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
        textField_1.setBounds(416, 591, 86, 20);
        p.add(textField_1);
        textField_1.setColumns(10);
        
        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg) 
        	{
        		String clientid=textField.getText();
        		String new_status=textField_1.getText();
        		Database obj=new Database();
                Connection con=null;
                ResultSet rs;
                con= obj.establish();
                String query; 
                if(new_status.equals("ready"))
                {
                	query="update canteen.ordert set status='"+new_status+"' where clientid='"+clientid+"'";
                }
                else
                {
                 query="delete from canteen.ordert where clientid='"+clientid+"';";
                }
               


        
                try{
                    Statement st =con.createStatement();
                    st.executeUpdate(query);
                    
        	
                }
                catch(SQLException e)
                {
                	e.printStackTrace();
                }
        	}
        });
        btnUpdate.setFont(new Font("Arial Unicode MS", Font.BOLD, 18));
        btnUpdate.setBounds(665, 577, 111, 41);
        p.add(btnUpdate);
        
        
        
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
        
        
    }
    
    public void action(){
      Database obj=new Database();
            Connection con=null;
            ResultSet rs;
            con= obj.establish();
            
            String query= "select * from canteen.ordert order by clientid ASC;";
           


    
            try{
                Statement st =con.createStatement();
                rs =st.executeQuery(query);
                
                
                JTable t =new JTable();
                
              /*  t.setModel(new DefaultTableModel(
                 new Object [][] {},
                 new String [] { "clientid","orderid","item","quantity","totalprice","status",
            }));*/
                
        
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
            
            catch(SQLException e)
            {
                e.printStackTrace();
                
            }
            }
}
