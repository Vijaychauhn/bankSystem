package Bank.System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;


public class Ministatement extends JFrame {
    Ministatement(String pinNumber){
        setTitle("MINI STATEMENT");
        setLayout(null);

        JLabel mini =new JLabel();
        mini.setBounds(20,140,400,200);
        add(mini);

        JLabel balance= new JLabel();
        balance.setBounds(20,400,300,20);
        add(balance);

        JLabel bank =new JLabel("Indian Bank");
        bank.setBounds(150,20,100,20);
        add(bank);

        JLabel card =new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pinNumber= '"+pinNumber+"'");
            while (rs.next()){
                card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4)+"XXXXXXXX"+ rs.getString("cardNumber").substring(12));
            }
        }catch (Exception e){
            System.out.println(e);
        }

        try {
            Conn c = new Conn();
            ResultSet rs=c.s.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
            int bal=0;
                    while (rs.next()){
                        mini.setText(mini.getText()+"<html>"+ rs.getString("date")+ "      "+rs.getString("type")+"      "+rs.getString("amount")+"<br><br><html>");
                        if (rs.getString("type").equals("Deposit")) {
                            bal += Integer.parseInt(rs.getString("amount"));
                        } else {
                            bal -= Integer.parseInt(rs.getString("amount"));
                        }
                        balance.setText("Your current balance is: "+ bal);
                    }
        }
        catch (Exception e){
            System.out.println(e);
        }

        setSize(400,600);
        setLocation(20,20);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }
    public static  void main(String[] args){
        new Ministatement("");
    }
}
