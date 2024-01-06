/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.management.system;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


/**
 *
 * @author Mohamed
 */
public class Signup extends JFrame implements ActionListener{
    JTextField textName , textFname , textEmail , textAdd,textcity,textState,textPin;
    JDateChooser dateChooser;
    JRadioButton r1,r2,m1,m2,m3;
    JButton next;
    
    Random ran = new Random();
    Long first4 = (ran.nextLong() % 9000L) + 1000L ;
    String first = "" + Math.abs(first4);
    
    
    
    Signup(){
        super("Appliction Form");
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(25, 10, 100, 100);
        add(image);
        
        JLabel label1 = new JLabel("Application Form No."+ first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 38));
        add(label1);
        
        JLabel label2 = new JLabel("Page 1");
        label2.setBounds(330, 70, 600, 30);
        label2.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label2);
        
        
        JLabel label3 = new JLabel("Personal Details");
        label3.setBounds(290, 90, 600, 30);
        label3.setFont(new Font("Raleway", Font.BOLD, 22));
        add(label3);
        
        JLabel labelName = new JLabel("Name");
        labelName.setBounds(100, 190, 100, 30);
        labelName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelName);
        
        textName = new JTextField();
        textName.setFont(new Font("Raleway", Font.BOLD, 14));
        textName.setBounds(300, 190, 400, 30);
        add(textName);
        
        JLabel labelfName = new JLabel("Father Name");
        labelfName.setBounds(100, 240, 200, 30);
        labelfName.setFont(new Font("Raleway", Font.BOLD, 20));
        add(labelfName);
        
        textFname = new JTextField();
        textFname.setFont(new Font("Raleway", Font.BOLD, 14));
        textFname.setBounds(300, 240, 400, 30);
        add(textFname);
        
        JLabel DOB = new JLabel("Date Of Birth");
        DOB.setBounds(100, 340, 200, 30);
        DOB.setFont(new Font("Raleway", Font.BOLD, 20));
        add(DOB);
        
        
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 340, 400, 30);
        add(dateChooser);
        
        
        JLabel labelG = new JLabel("Gender");
        labelG.setFont(new Font("Raleway", Font.BOLD, 20));
        labelG.setBounds(100, 290, 200, 30);
        add(labelG);
        
        
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(300, 290, 60, 30);
        add(r1);
        
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(450, 290, 90, 30);
        add(r2);
        
        
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        
        
        JLabel labelEmail = new JLabel("Email Address");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(100,390,200,30);
        add(labelEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(300, 390, 400, 30);
        add(textEmail);
     
        
        JLabel labelAdd = new JLabel("Address");
        labelAdd.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAdd.setBounds(100,490,200,30);
        add(labelAdd);
        
        textAdd = new JTextField();
        textAdd.setFont(new Font("Raleway", Font.BOLD, 14));
        textAdd.setBounds(300, 490, 400, 30);
        add(textAdd);
        
        JLabel labelCity = new JLabel("City");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCity.setBounds(100,540,200,30);
        add(labelCity);
        
        textcity = new JTextField();
        textcity.setFont(new Font("Raleway", Font.BOLD, 14));
        textcity.setBounds(300, 540, 400, 30);
        add(textcity);
        
        
        JLabel labelPin = new JLabel("Number Phone");
        labelPin.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPin.setBounds(100,590,200,30);
        add(labelPin);
        
        textPin = new JTextField();
        textPin.setFont(new Font("Raleway", Font.BOLD, 14));
        textPin.setBounds(300, 590, 400, 30);
        add(textPin);
        
        
        JLabel labelstate = new JLabel("Country");
        labelstate.setFont(new Font("Raleway", Font.BOLD, 20));
        labelstate.setBounds(100,640,200,30);
        add(labelstate);
        
        textState = new JTextField();
        textState.setFont(new Font("Raleway", Font.BOLD, 14));
        textState.setBounds(300, 640, 400, 30);
        add(textState);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(620, 710, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(800, 850);
        setLocation(360, 40);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new Signup();
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String formno = first ;
        String name = textName.getText();
        String fname = textFname.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(r1.isSelected())
        {
            gender = "Male";
      
        }
        else if (r2.isSelected())
        {
            gender="Female";
        }
        
        String email = textEmail.getText();
        String marital = null ;
          
        String address = textAdd.getText();
        String city = textcity.getText();
        String pincode = textPin.getText();
        String stste = textState.getText();
        
        try
        {
            if(textName.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null,"Fill all the Fields");
            }else
            {
                can con1 = new can();
                String q = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+pincode+"','"+stste+"')";
                con1.statement.executeUpdate(q);
                new Signup3(formno);
                setVisible(false);
            
            }
            
            
        }catch (Exception E)
        {
            E.printStackTrace();
        }
        
       
    }
    
}
