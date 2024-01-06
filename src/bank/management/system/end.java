package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohamed
 */
public class end extends JFrame implements ActionListener{
    JButton b1;
    String pin;
    end(String pin)
    {
        this.pin=pin;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/pp.jpg"));
        Image i2 = i1.getImage().getScaledInstance(700, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 700, 400);
        add(image);
        
        b1 = new JButton("Free Palestine");
        b1.setBounds(250, 290, 150, 50);
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);
        
        
        
        setLayout(null);
        setSize(700 , 450);
        setLocation(450, 200);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try
        {
            if(e.getSource()==b1)
            {
                JOptionPane.showMessageDialog(null, "Tanks To Use Our App \n اديني الدرجة كاملة يا رب تدخلي الجنة عشان تعبت ف البروجيكت ");
                System.exit(0);
            }
            
        }catch(Exception E)
        {
            E.printStackTrace();
        }
    }
    
}
