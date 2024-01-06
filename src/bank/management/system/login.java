/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Mohamed
 */
public class login extends JFrame implements ActionListener{
    JLabel label1,label2,label3;
    JTextField textfield2;
    JPasswordField passwordfield3;
    JButton button1 , button2, button3 ;
    login()
    {
        super("Bank Management System");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 10, 100, 100);
        add(image);
        
        
        ImageIcon ii1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image ii2 = ii1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon ii3 = new ImageIcon(ii2);
        JLabel iimage = new JLabel(ii3);
        iimage.setBounds(630, 150, 200, 200);
        add(iimage);
        
        
        label1 = new JLabel("Welcome To ATM");
        label1.setForeground(Color.white);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 38));
        label1.setBounds(230, 125, 450, 40);
        add(label1);
        
        
        label2 = new JLabel("Card Number");
        label2.setForeground(Color.white);
        label2.setFont(new Font("Ralway", Font.BOLD, 28));
        label2.setBounds(150, 190, 375, 30);
        add(label2);
        
        textfield2 = new JTextField(15);
        textfield2.setBounds(345, 190, 230, 30);
        textfield2.setFont(new Font("Arial", Font.BOLD, 14));
        add(textfield2);
        
        label3 = new JLabel("PIN");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Ralway", Font.BOLD, 28));
        label3.setBounds(150, 250, 375, 30);
        add(label3);
        
        
        passwordfield3 = new JPasswordField(15);
        passwordfield3.setBounds(345, 250, 230, 30);
        passwordfield3.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordfield3);
        
        button1 = new JButton("Sign In");
        button1.setFont(new Font("Arial", Font.BOLD, 14));
        button1.setBackground(Color.black);
        button1.setForeground(Color.white);
        button1.setBounds(345, 300, 100, 30);
        button1.addActionListener(this);
        add(button1);
        
        
        button2 = new JButton("Sign Up");
        button2.setFont(new Font("Arial", Font.BOLD, 14));
        button2.setBackground(Color.black);
        button2.setForeground(Color.white);
        button2.setBounds(345, 350, 230, 30);
        button2.addActionListener(this);
        add(button2);
        
        
        button3 = new JButton("Clear");
        button3.setFont(new Font("Arial", Font.BOLD, 14));
        button3.setBackground(Color.black);
        button3.setForeground(Color.white);
        button3.setBounds(475, 300, 100, 30);
        button3.addActionListener(this);
        add(button3);
        
        
        
        
        
        
        ImageIcon iii1 = new ImageIcon(ClassLoader.getSystemResource("icon/backbg.png"));
        Image iii2 = iii1.getImage().getScaledInstance(850, 488, Image.SCALE_DEFAULT);
        ImageIcon iii3 = new ImageIcon(iii2);
        JLabel iiimage = new JLabel(iii3);
        iiimage.setBounds(0, 0, 850, 480);
        add(iiimage);
        
        
        
        
        setLayout(null);
        setSize(850, 480);
        setLocation(450, 200);
//        setUndecorated(true);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()== button1)
            {
               can c = new can();
               String cardno = textfield2.getText();
               String pin = passwordfield3.getText();
               String q = "select * from login where card_number = '"+cardno+"' and pin = '"+pin+"'";
               ResultSet resultSet = c.statement.executeQuery(q);
               if(resultSet.next())
               {
                   setVisible(false);
                   new main_Class(pin);
               }
               else
               {
                   JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
               }
            }
            else if (e.getSource()== button2)
            {
                new Signup();
                setVisible(false);
            }
            else if (e.getSource() == button3)
            {
              textfield2.setText("");
              passwordfield3.setText("");
            }
        
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        
    }
    
    
}
