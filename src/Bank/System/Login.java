package Bank.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setLayout(null);
        setTitle("AUTOMATED TELLER MACHINE");
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome To ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel CardNumber=new JLabel("Card Number:");
        CardNumber.setFont(new Font("Raleway",Font.BOLD,20));
        CardNumber.setBounds(120,150,150,30);
        add(CardNumber);

        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel PIN=new JLabel("PIN:");
        PIN.setFont(new Font("Baleway",Font.BOLD,20));
        PIN.setBounds(120,220,250,30);
        add(PIN);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login = new JButton("SIGN IN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup= new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);


        setSize(800,480);
        setVisible(true);
        setLocation(350,200);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==login){
            Conn conn = new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "Select * from login where cardNumber='"+cardNumber+"' and pinNumber ='"+pinNumber+"'";
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number, Please Provide valid Card Number");
                }
            }catch (Exception e){
                System.out.println(e);
            }

        } else if (ae.getSource()==clear) {
            cardTextField.setText("");
            pinTextField.setText("");
        } else if (ae.getSource()==signup) {
           setVisible(false);
           new SignupOne().setVisible(true);
        }

    }
    public static void main(String [] args){
        new Login();

    }
}
