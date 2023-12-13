package Bank.System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;

    JButton submit,cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);

        JLabel l1= new JLabel("Page 3: Acount Details");
        l1.setFont(new Font("Raleway",Font.BOLD, 22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel accountType = new JLabel("Account Type");
        accountType.setFont(new Font("Raleway",Font.BOLD,22));
        accountType.setBounds(100,140,200,30);
        add(accountType);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway",Font.BOLD,16));
        r1.setBounds(110,180,150,20);
        r1.setBackground(Color.white);
        add(r1);

        r2 = new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway",Font.BOLD,16));
        r2.setBounds(320,180,150,20);
        r2.setBackground(Color.white);
        add(r2);

        r3 = new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway",Font.BOLD,16));
        r3.setBounds(110,220,200,20);
        r3.setBackground(Color.white);
        add(r3);

        r4 = new JRadioButton("Recuring Deposite Account");
        r4.setFont(new Font("Raleway",Font.BOLD,16));
        r4.setBounds(320,220,250,20);
        r4.setBackground(Color.white);
        add(r4);

        ButtonGroup selectAccountType=new ButtonGroup();
        selectAccountType.add(r1);
        selectAccountType.add(r2);
        selectAccountType.add(r3);
        selectAccountType.add(r4);

        JLabel card = new JLabel("Card Number");
        card.setFont(new Font("Raleway",Font.BOLD,22));
        card.setBounds(100,280,200,30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-2311");
        number.setFont(new Font("Raleway",Font.BOLD,22));
        number.setBounds(320,280,300,30);
        add(number);

        JLabel carddetails = new JLabel("This is Your 16 digit CardNumber");
        carddetails.setFont(new Font("Raleway",Font.BOLD,12));
        carddetails.setBounds(100,300,200,30);
        add(carddetails);

        JLabel pin = new JLabel("Pin Number");
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        pin.setBounds(100,340,200,30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway",Font.BOLD,22));
        pnumber.setBounds(320,340,100,30);
        add(pnumber);

        JLabel pindetails = new JLabel("This is Your PinNumber");
        pindetails.setFont(new Font("Raleway",Font.BOLD,12));
        pindetails.setBounds(100,360,200,30);
        add(pindetails);

        JLabel services = new JLabel("Services Required");
        services.setFont(new Font("Raleway",Font.BOLD,22));
        services.setBounds(100,400,200,30);
        add(services);

        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.white);
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,440,200,30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.white);
        c2.setFont(new Font("Raleway",Font.BOLD,17));
        c2.setBounds(320,440,200,30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.white);
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,480,200,30);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alert");
        c4.setBackground(Color.white);
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(320,480,200,30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setBackground(Color.white);
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,520,200,30);
        add(c5);

        c6 = new JCheckBox("E-Statment");
        c6.setBackground(Color.white);
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(320,520,200,30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered declaration are correct to the best of my knowledge");
        c7.setBackground(Color.white);
        c7.setFont(new Font("Raleway",Font.BOLD,12));
        c7.setBounds(100,580,600,30);
        add(c7);

        submit = new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.white);
        submit.setFont(new Font("Raleway",Font.BOLD,14));
        submit.setBounds(280,650,120,30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.white);
        cancel.setFont(new Font("Raleway",Font.BOLD,14));
        cancel.setBounds(420,650,120,30);
        cancel.addActionListener(this);
        add(cancel);


        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == submit) {
            String accountType= null;
            if(r1.isSelected()){
                accountType = "Saving Account";
            }
            else if (r2.isSelected()){
                accountType="Current Account";
            }
            else if (r3.isSelected()){
                accountType="Fixed Deposit Account";
            }
            else if(r4.isSelected()){
                accountType="Recuring Deposite Account";
            }
            Random random= new Random();
            String cardNumber = "" +Math.abs((random.nextLong() % 90000000L) + 5400345600000000L);
            String pinNumber = "" +Math.abs((random.nextLong() % 9000L) + 1000L);

            String facility="";
            if(c1.isSelected()){
                facility = "ATM CARD";
            }
            else if(c2.isSelected()){
                facility += "Internet Banking";
            }
            else if (c3.isSelected()){
                facility+= "Mobile Banking";
            }
            else if(c4.isSelected()){
                facility+="Email & SMS Alert";
            }
            else if(c5.isSelected()){
                facility+="Check Book";
            }
            else if(c6.isSelected()){
                facility+= "E-Statment";
            }

            try {
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null, "Account Type Reqiured");
                    }
                else{
                    Conn conn = new Conn();
                    String query1 = "INSERT INTO signupThree VALUES ('"+formno+"' , '"+accountType+"' , '"+cardNumber+"' , '"+pinNumber+"' , '"+facility+"')";
                    conn.s.executeUpdate(query1);
                    String query2 = "insert into Login values('"+formno+"' , '"+cardNumber+"' , '"+pinNumber+"')";
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number"+cardNumber+ "Pin Number"+pinNumber);
                    setVisible(false);
                    new Login().setVisible(true);
                }
                }

            catch (Exception e){
                System.out.println(e);
            }

        }
        else if(ae.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);

        }

    }
    public static void main(String[] args){
        new SignupThree("formno");
    }
}
