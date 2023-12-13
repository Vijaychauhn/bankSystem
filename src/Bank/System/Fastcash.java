package Bank.System;
import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class Fastcash extends JFrame implements ActionListener{
    JButton hundred,fivehundred,thousand,twothousand,fivethousand,tenthousand,exit;
    String pinNumber;
    Fastcash(String pinNumber){
        pinNumber=this.pinNumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.white);
        text.setBounds(210,300,700,35);
        image.add(text);

        hundred=new JButton("RS 100");
        hundred.setBounds(170,415,150,30);
        hundred.addActionListener(this);
        image.add(hundred);

        fivehundred =new JButton("RS 500");
        fivehundred.setBounds(355,415,150,30);
        fivehundred.addActionListener(this);
        image.add(fivehundred);

        thousand =new JButton("RS 1000");
        thousand.setBounds(170,450,150,30);
        thousand.addActionListener(this);
        image.add(thousand);

        twothousand =new JButton("RS 2000");
        twothousand.setBounds(355,450,150,30);
        twothousand.addActionListener(this);
        image.add(twothousand);

        fivethousand =new JButton("RS 5000");
        fivethousand.setBounds(170,485,150,30);
        fivethousand.addActionListener(this);
        image.add(fivethousand);

        tenthousand =new JButton("RS 10000");
        tenthousand.setBounds(355,485,150,30);
        tenthousand.addActionListener(this);
        image.add(tenthousand);

        exit =new JButton("EXIT");
        exit.setBounds(355,520,150,30);
        exit.addActionListener(this);
        image.add(exit);


        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);

            Conn c= new Conn();

            try {
                ResultSet rs= c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
                int balance=0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }
                    else {
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && Integer.parseInt(amount)>balance){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date=new Date();
                String query="Insert into bank values ('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Debited successfully");

                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }
    public static void main(String[] args){
        new Fastcash("");
    }

}
