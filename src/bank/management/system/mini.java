/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Mohamed
 */
public class mini extends JFrame implements ActionListener{
    String pin ;
    JButton button;
    
    
    mini(String pin)
    {
        this.pin=pin;
        getContentPane().setBackground(new Color(200, 204, 204));
        setSize(400,600);
        setLocation(20, 20);
        setLayout(null);
        
        
        JLabel label1 = new JLabel();
        label1.setBounds(20, 140, 400, 250);
        add(label1);
        
        JLabel label2 = new JLabel("Mini Statement");
        label2.setFont(new Font("System", Font.BOLD , 15));
        label2.setBounds(150, 20, 200, 20);
        add(label2);
        
        
        JLabel label3 = new JLabel();
        label3.setBounds(20, 80, 300, 25);
        add(label3);
        
        JLabel label4 = new JLabel();
        label4.setBounds(20, 400, 300, 25);
        add(label4);
        
        try
        {
            can c = new can();
            ResultSet resultSet = c.statement.executeQuery("select * from login where pin = '"+pin+"'");
            while(resultSet.next())
            {
                label3.setText("Card Number "+ resultSet.getString("card_number").substring(0,4)+"XXXXXXXX"+resultSet.getString("card_number").substring(12));
            }
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            
            int balance = 0;
            can c = new can();
            ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
                
                while(resultSet.next())
                {
                    label1.setText(label1.getText()+ "<html>"+ resultSet.getString("date") +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("amount")+"<br><br><html>");
                     
                    
                    
                    if(resultSet.getString("type").equals("Deposit"))
                    {
                        balance += Integer.parseInt(resultSet.getString("amount"));
                    }
                    else
                    {
                        balance -= Integer.parseInt(resultSet.getString("amount")); 
                    }
                }
                label4.setText("Your Total Balance is  " + balance);
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        
        button = new JButton("Back");
        button.setBounds(20, 500, 100, 25);
        button.addActionListener(this);
        button.setBackground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);
        
        setVisible(true);
        
        
        
        
    }
    public static void main(String[] args) {
        new mini("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        new main_Class(pin);
        setVisible(false);
        
//        setVisible(false);
        
    }
    
}
