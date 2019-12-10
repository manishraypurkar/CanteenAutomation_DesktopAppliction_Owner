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
import javax.swing.border.Border;

public class SearchFood  extends JFrame  implements ActionListener{
    
    
     JPanel p =new JPanel();
   
  // JButton back =new JButton(new ImageIcon("E:\\back48.png"));
   JButton back =new JButton("Back");
   JLabel img =new JLabel(new ImageIcon("C:\\Users\\Admin\\Documents\\NetBeansProjects\\CanteenProject\\CanteenAutomation\\back48.png"));
   
     JLabel head=new JLabel("Search Food Item");
     JLabel foodid =new JLabel("FoodItem");

     JButton search=new JButton ("SEARCH");
     
    // Object [][] row={ {"1", "samosa","snacks", "100"} };  
     //String [] colname ={"Fid","Name","Category","Amount"};
     
                       
     //JTable table= new JTable(row, colname);
    
         Border blackline=BorderFactory.createLineBorder(Color.LIGHT_GRAY,10);
         private final JComboBox comboBox = new JComboBox();

    
     
    
    SearchFood()
    {
        p.setBorder(blackline);
        p.setLayout(null);
        back.setBounds(100,100,100,40);
        back.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        img.setBounds(30,100,60,40);
        
       
        head.setBounds(450,100,300,100);
        foodid.setBounds(400,300,100,50);

        search.setBounds(520,400,150, 50);

               
       
      
       head.setFont(new Font ("Monotype Corsiva",Font.BOLD,40));
       foodid.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
       
       search.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));

       //table.setFont(new Font ("Monotype Corsiva",Font.BOLD,25));
        
        head.setForeground(Color.RED);

       // JScrollPane sp =new JScrollPane(table);
        //sp.setBounds(200,500,800,400);
       //table.setEnabled(false);
        //p.add(sp);

        
        p.add(head);
        p.add(foodid);
       
        p.add(search);
        //p.add(table);

        
         
        p.add(back);
        p.add(img);
        getContentPane().add(p);
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Samosa", "VadaPav", "BreadPattice", "Kachori", "Dosa", "Idli", "Upma", "Poha", "Dalrice", "Khichdi", "Rotisabzi", "Sprite", "Pepsi", "Mirinda", "Soda", "Lays", "Kurkure", "Balaji", "Bingo"}));
        comboBox.setBounds(510, 303, 200, 50);
        
        p.add(comboBox);
    
       setResizable(false);
         setLocation(300,50);
        setTitle("SEARCH FOOD ITEMS");
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

                  else     
                  {
                                
                	  String query ="select * from menu where itemname='" +comboBox.getSelectedItem().toString()+ "';";
                	  //ipfid.getText()
                	  Database d =new Database();
                	  Connection con=d.establish();
                	  ResultSet rs=null;
                               
                               
                               
          if(comboBox.getSelectedItem()!=null)
                    
                {                       
           
                        try {
                               Statement st= con.createStatement();
                                
                                 
                                rs =st.executeQuery(query);
                                
                                //System.out.println(rs);
                               
                                  //while(rs.next())
                                 //{
                                       
                                 if(rs.next())
                                 {
                                    System.out.println("record is found");
                                    JOptionPane.showMessageDialog(null,"RECORD IS FOUND..!","FOUND..!",JOptionPane.INFORMATION_MESSAGE );
                       
                                    String tfid=rs.getString("itemname");
                                    int tfname =rs.getInt("quantity");
                                    int tfcat= rs.getInt("price");
                                    //String tfamt= rs.getString(4);
                                            
                                                                            //System.out.println(tfid);
                         
                                    Object  [][] rowdata={ {tfid,tfname,tfcat} };
                                    //,tfamt
                        
    
                                    // Object [][] row={ {"1", "samosa","snacks", "100"} };  
                                    String [] colname ={"itemname","quantity","price"};
                                    JTable table= new JTable(rowdata,colname);
     
                                    JScrollPane sp =new JScrollPane(table);
                                    sp.setBounds(200,540,800,100);
                                    table.setFont(new Font ("Arial",Font.BOLD,17));
                                    table.setEnabled(false);

                                    p.add(sp);
                                 }        
                                    
                                 //}   
                                
                                 else{       
                                   JOptionPane.showMessageDialog(null,"RECORD IS NOT FOUND..!","NOT FOUND..!",JOptionPane.INFORMATION_MESSAGE );

                                 }
                                            
                                    
                                
                                
                                
                           }        
                                
                       
               catch (SQLException ex)
               {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null,"ENTER VALID DATA INPUT ","INVALID DATA!",JOptionPane.INFORMATION_MESSAGE );

               
               }
             }
                                
          else
          {
                     JOptionPane.showMessageDialog(null,"PLEASE FILL ALL FIELDS FIRST ..!","REQUIRED",JOptionPane.INFORMATION_MESSAGE );

          }
                    
         }
        
        
        
        
        
    }

}
