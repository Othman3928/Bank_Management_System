/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Mohamed
 */
public class Withdrawl  extends JFrame implements ActionListener{
    
    String pin ;
    JButton b1,b2;
    TextField textField;
    
    Withdrawl(String pin)
    {
        this.pin = pin ;
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3); 
        
        JLabel label1 = new JLabel("Maximum Withdrawal is 100,000");
        label1.setBounds(460, 180, 700, 35);
        label1.setFont(new Font("System", Font.BOLD, 16));
        label1.setForeground(Color.WHITE);
        l3.add(label1);
        
        JLabel label2 = new JLabel("Piease Enter Your Amount");
        label2.setBounds(460, 220, 400, 35);
        label2.setFont(new Font("System", Font.BOLD, 16));
        label2.setForeground(Color.WHITE);
        l3.add(label2);
        
        textField = new TextField();
        textField.setBackground(new Color(65, 125, 128));
        textField.setForeground(Color.WHITE);
        textField.setBounds(460, 260, 320, 30);
        textField.setFont(new Font("Raleway", Font.BOLD, 22));
        l3.add(textField);
        
        
        
        b1 = new JButton("WITHDRAW");
        b1.setBounds(700, 362, 150, 35);
        b1.setBackground(new Color(65, 125, 128));
        b1.setForeground(Color.WHITE);
        l3.add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(700, 406, 150, 35);
        b2.setBackground(new Color(65, 125, 128));
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        l3.add(b2);
        b1.addActionListener(this);
        
        
        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);   
    }
    public static void main(String[] args) {
        new Withdrawl("");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
          String amount = textField.getText();
          Date date = new Date(System.currentTimeMillis());
          
         if(e.getSource()== b1)
         {
          if(textField.getText().equals(""))
          {
              JOptionPane.showMessageDialog(null, "Please Enter The Amount You Want Withdraw");
          }
          else
          {
              can c = new can();
              ResultSet resultSet = c.statement.executeQuery("select * from bank where pin = '"+pin+"'");
              int balance = 0;
              while (resultSet.next())
              {
                  if(resultSet.getString("type").equals("Deposit"))
                  {
                      balance += Integer.parseInt(resultSet.getString("amount"));
                  }
                  else
                  {
                      balance -= Integer.parseInt(resultSet.getString("amount"));
                  }
              }
               if(balance < Integer.parseInt(amount))
          {
              JOptionPane.showMessageDialog(null, "Insuffient Balance");
              return;
          }
          
          c.statement.executeUpdate("insert into bank values ('"+pin+"','"+date+"','Withdrawl','"+amount+"')");
          JOptionPane.showMessageDialog(null, " "+amount+" Debited Successfully");
              setVisible(false);
              new main_Class(pin);
          }
         }
         else if(e.getSource()==b2)
           {
               
               setVisible(false);
               new main_Class(pin);
           }
        
        }catch(Exception E)
        {
            
        }
        
    }
    
}
