package Bank.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawal extends JFrame implements ActionListener {
    JTextField amount;
    JButton withdrawal,back;
    String pinNumber;
    Withdrawal(String pinNumber) {
        this.pinNumber=pinNumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the Amount you want to Withdraw");
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(170,300,400,20);
        image.add(text);

        amount =new JTextField();
        amount.setFont(new Font("System",Font.BOLD,22));
        amount.setBounds(170,350,320,25);
        image.add(amount);

        withdrawal =new JButton("Withdraw");
        withdrawal.setBounds(355,485,150,30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back =new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawal){
            String number=amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to Withraw");
            }
            else{
                try {
                    Conn c = new Conn();
                    String query = "Insert into bank values('" + pinNumber + "','" + date + "','Withdrawal','" + number + "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + number +" Withdrawal Successfully");
                    setVisible(false);
                    new Transaction(pinNumber).setVisible(true);
                }
                catch (Exception e){
                    System.out.println(e);
                }
            }

        }
        else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinNumber).setVisible(true);
        }
        //es

    }

    public static void main(String[] args) {
        new Withdrawal("");

    }
}
