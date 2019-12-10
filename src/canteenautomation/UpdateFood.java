/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canteenautomation;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.border.Border;


public class UpdateFood extends JFrame implements ActionListener {
   
     JPanel p =new JPanel();
   
   //JButton back =new JButton(new ImageIcon("E:\\back48.png"));
   JButton back =new JButton("Back");
   JLabel img =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\back48.png"));
  
    
   
   JLabel head=new JLabel("Update Food Details");
   JLabel foodid =new JLabel("FoodItem");
   JLabel name =new JLabel("Quantity");
   JLabel amt =new JLabel("Amount");
   JTextField ipname =new JTextField();
   //JTextField ipcat =new JTextField();
   JTextField ipamt =new JTextField();
   
   JButton search =new JButton ("SEARCH");
   JButton update =new JButton("UPDATE");
   
   

     Vector v= new Vector(); 
    JComboBox comboBoxmenu = new JComboBox();;
    
    
    
     Border blackline=BorderFactory.createLineBorder(Color.LIGHT_GRAY,10);

    
    
    UpdateFood()
    {   
        p.setBorder(blackline);
        p.setLayout(null);
        back.setBounds(100,20,100,40);
        back.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        img.setBounds(30,20,60,40);
        
      
        head.setBounds(420,20,400,100);
        foodid.setBounds(386,140,114,50);
        name.setBounds(386,240,114,50);
        amt.setBounds(380,333,120,50);
        ipname.setBounds(500,240, 200, 50);
        ipamt.setBounds(500,334, 200, 50);
        
        
       search.setBounds(431,428,120,50);
       update.setBounds(561,428,120,50);

       
       head.setFont(new Font ("Monotype Corsiva",Font.BOLD,40));
       foodid.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
       name.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
       amt.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
      
       search.setFont(new Font ("Monotype Corsiva",Font.BOLD,20));
       update.setFont(new Font ("Monotype Corsiva",Font.BOLD,20));
       ipname.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
       ipamt.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));

       head.setForeground(Color.RED);
       
       
      // v.add(0, "Snacks");
       //v.add(1,"Coldrinks");
       
       
      
       comboBoxmenu.setModel(new DefaultComboBoxModel(new String[] {"", "Samosa", "VadaPav", "BreadPattice", "Kachori", "Dosa", "Idli", "Upma", "Poha", "Dalrice", "Khichdi", "Rotisabzi", "Sprite", "Pepsi", "Mirinda", "Soda", "Lays", "Kurkure", "Balaji", "Bingo"}));
       comboBoxmenu.setBounds(500, 143, 200, 50);
       p.add(comboBoxmenu);
    
        p.add(head);
        p.add(foodid);
        p.add(name);
        p.add(amt);
        p.add(ipname);
        p.add(ipamt);
        
        p.add(search);
        p.add(update);
        
        
        
        
        
        
        
       p.add(back);
        p.add(img);
        getContentPane().add(p);
        
        
        
        
       setResizable(false);
         //setLocation(300,50);
        setTitle("UPDATE FOOD DETAILS");
        setSize(1200,900);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         
        
        
           
        img.addMouseListener(new MouseAdapter(){ public void mouseClicked(MouseEvent me)
        {
        Home h = new Home();
        h.setVisible(true);
        dispose();
        }}); 
        
        back.addActionListener(this);
        search.addActionListener(this);
        update.addActionListener(this);

    }
   
    
    
     public void actionPerformed(ActionEvent e)
    {
         String temp = e.getActionCommand();
        if(temp.equalsIgnoreCase("back"))
        {
        Home h=new Home();
        h.setVisible(true);
        dispose();
         }
        
        		else if(temp.equalsIgnoreCase("search"))
                {
                    
        						System.out.println(comboBoxmenu.getSelectedItem().toString());
                    
        						String query ="select * from menu where itemname='" +comboBoxmenu.getSelectedItem().toString()+ "';";
           
            
        						Database d =new Database();
        						Connection con=d.establish();
        						ResultSet rs=null;
           
                               
                               
                if(comboBoxmenu.getSelectedItem()!=null)
                    
                {    
        	  
        	  //!ipfid.getText().isEmpty() && !ipname.getText().isEmpty() &&  && !ipamt.getText().isEmpty()
           
                        try {
                               Statement st= con.createStatement();
                                
                                 
                                rs =st.executeQuery(query);
                                
                                
                                
                                  if(rs.next())
                                 {
                                        
                                    System.out.println("record is found");
                                    JOptionPane.showMessageDialog(null,"RECORD IS FOUND..!","FOUND..!",JOptionPane.INFORMATION_MESSAGE );
                       
                                    String tfid=rs.getString("itemname");
                                    int tfname =rs.getInt("quantity");
                                    int tfcat= rs.getInt("price");
                                    String qnt = Integer.toString(tfname);
                                    String amt = Integer.toString(tfcat);
                                    //String tfamt= rs.getString(4);
                                        
                                    ipname.setText(qnt);
                                    ipamt.setText(amt);
//                                    Object  [][] rowdata={ {tfid,tfname,tfcat,} };
//                        
//                                    //tfamt
//    
//                                    // Object [][] row={ {"1", "samosa","snacks", "100"} };  
//                                    String [] colname ={"Name","Quantity","Amount"};
//                                    JTable table= new JTable(rowdata,colname);
//     
//                                    JScrollPane sp =new JScrollPane(table);
//                                    sp.setBounds(200,580,800,100);
//                                    table.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
//                                    table.setEnabled(false);
//
//                                    p.add(sp);
                                       
                                               
                                            
                                    }  
                                  else{
                                    JOptionPane.showMessageDialog(null,"RECORD IS NOT FOUND..!","NOT FOUND..!",JOptionPane.INFORMATION_MESSAGE );
     
                                        }
                           			}        
                                
                       
                                        catch (SQLException ex)
                                             {
                                                      ex.printStackTrace();
                                            JOptionPane.showMessageDialog(null,"ENTER VALID DATA  ..!","INVALID DATA",JOptionPane.INFORMATION_MESSAGE );

               
                                             }
                	}
                                
                                              else
                                        {
                                 JOptionPane.showMessageDialog(null,"Select an item","REQUIRED",JOptionPane.INFORMATION_MESSAGE );

                                         }
                                                           
        }                     
                        
                        

        
        
        else{
            
                String query ="update menu SET itemname='"+comboBoxmenu.getSelectedItem().toString()+"',quantity='"+Integer.parseInt(ipname.getText().toString())+"',Price='"+Integer.parseInt(ipamt.getText().toString())+"'where ItemName='"+comboBoxmenu.getSelectedItem().toString()+"';";
           
            
                    Database d =new Database();
                    Connection con=d.establish();
                    ResultSet rs=null;
            
                if(comboBoxmenu.getSelectedItem()!=null  && !ipname.getText().isEmpty() &&  !ipamt.getText().isEmpty())
                    
                {  
                	
                	//&&!ipfid.getText().isEmpty()
           
           
                      try {
               
                             Statement st =con.createStatement();
            
                             int x=st.executeUpdate(query);
                             //rs=st.getResultSet();
                                if(x>0)
                                {
                                     System.out.println("record is UPDATED successfully");
                                     JOptionPane.showMessageDialog(null,"RECORD UPDATED SUCCEESSFULLY","UPDATED..!",JOptionPane.INFORMATION_MESSAGE );
                                     
                                     
                                }
                                else
                                {
                                     System.out.println("record is NOT UPDATED successfully");
                                     JOptionPane.showMessageDialog(null,"RECORD NOT UPDATED SUCCEESSFULLY, FOODID IS REQUIRED TO BE EXIST","NOT UPDATED..!",JOptionPane.INFORMATION_MESSAGE );
                                }
               
               
                           }
           
                      catch(SQLException ex)
                      {
                                 ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,"ENTER VALID DATA INPUT  ..!","INVALID DATA",JOptionPane.INFORMATION_MESSAGE );

                                 
                         }
           
                    }
               
                
                else
                         {
                                 JOptionPane.showMessageDialog(null,"PLEASE FILL ALL FIELDS FIRST ..!","REQUIRED",JOptionPane.INFORMATION_MESSAGE );

                          }
            
        }
        
    }
}
