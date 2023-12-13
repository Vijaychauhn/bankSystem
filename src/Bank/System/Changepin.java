package Bank.System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changepin  extends JFrame implements ActionListener {
    JPasswordField pin,repin;
    JButton change,back;
    String pinNumber;
    Changepin(String pinNumber){
        this.pinNumber=pinNumber;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setBounds(250,290,500,35);
        image.add(text);

        JLabel newpin = new JLabel("ENTER NEW PIN");
        newpin.setForeground(Color.white);
        newpin.setFont(new Font("System",Font.BOLD,16));
        newpin.setBounds(165,330,200,25);
        image.add(newpin);

        pin =new JPasswordField();
        pin.setBounds(330,330,180,25);
        pin.setFont(new Font("Releway",Font.BOLD,25));
        image.add(pin);

        JLabel repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.white);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setBounds(165,370,200,25);
        image.add(repintext);

        repin =new JPasswordField();
        repin.setBounds(330,370,180,25);
        repin.setFont(new Font("Releway",Font.BOLD,25));
        image.add(repin);

        change=new JButton("CHANGE");
        change.setBounds(355,485,150,30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String npin = pin.getText();
                String rpin = repin.getText();
                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Plese Enter new Pin");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Re-enter new Pin ");
                }
                Conn c = new Conn();
                String query1 = "update bank set pinNumber='" + rpin + "' where pinNumber= '" + pinNumber + "'";
                String query2 = "update login set pinNumber='" + rpin + "' where pinNumber= '" + pinNumber + "'";
                String query3 = "update signupThree set pinNumber='" + rpin + "' where pinNumber= '" + pinNumber + "'";

                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                setVisible(false);
                new Transaction(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else{
                setVisible(false);
                new Transaction(pinNumber).setVisible(true);
            }
        }

    public static void main(String[] args){

        new Changepin("");
    }

}
