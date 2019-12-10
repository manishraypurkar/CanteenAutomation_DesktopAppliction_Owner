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

public class Logout extends JFrame implements ActionListener{
    
    
     JPanel p =new JPanel();
   
  // JButton back =new JButton(new ImageIcon("E:\\back48.png"));
   
     JButton back =new JButton("Back");
      JLabel img =new JLabel(new ImageIcon("C:\\eclipse\\Projects\\CanteenAutomation (1)\\CanteenAutomation\\back48.png"));
    
    
    Logout()
           
    {
        
        
        p.setLayout(null);
        back.setBounds(100,100,100,40);
        back.setFont(new Font("Monotype Corsiva",Font.BOLD,25));
        img.setBounds(30,100,60,40);
        
        
        
        p.add(back);
        p.add(img);
        getContentPane().add(p);
        
        setResizable(false);
         setLocation(300,50);
        setTitle("LOGOUT");
        setSize(1200,1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                back.addActionListener(this);

    }
    
     public void actionPerformed(ActionEvent e)
    {
        Home h=new Home();
        h.setVisible(true);
                

        dispose();
        
    }

}
