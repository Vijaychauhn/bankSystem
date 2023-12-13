package Bank.System;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupOne extends JFrame implements ActionListener{
    long random;
    JLabel formno, personalDetails, name,fname,dob,gender,email,marital,address,city,pincode,state;

    JTextField nameTextField, fnameTextField, emailTextField,addressTextField,
            cityTextField,stateTextField,pincodeTextField;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs(ran.nextLong()%9000L +1000L);
        // System.out.println   (random);

        formno = new JLabel("APPLICATION FORM NO."+random );
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        personalDetails.setBounds(290,80,400,30);
        add(personalDetails);

        name = new JLabel("NAME");
        name.setFont(new Font("Raleway",Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        nameTextField= new JTextField();
        nameTextField.setBounds(300,140,400,30);
        nameTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(nameTextField);

        fname = new JLabel("FATHER NAME");
        fname.setFont(new Font("Raleway",Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnameTextField= new JTextField();
        fnameTextField.setBounds(300,190,400,30);
        fnameTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(fnameTextField);

        dob = new JLabel("DATE OF BIRTH");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(100,240,200,30);
        add(dob);

        dateChooser=new JDateChooser();
        dateChooser.setBounds(300,240,400,30);
        dateChooser.setForeground(Color.RED);
        add(dateChooser);

        gender = new JLabel("GENDER");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);

        male = new JRadioButton("MALE");
        male.setBounds(320,290,60,30);
        male.setBackground(Color.white);
        add(male);

        female = new JRadioButton("FEMALE");
        female.setBounds(450,290,100,30);
        female.setBackground(Color.white);
        add(female);

        ButtonGroup genderGroup=new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        email = new JLabel("EMAIL ADDRESS");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,340,200,30);
        add(email);

        emailTextField= new JTextField();
        emailTextField.setBounds(300,340,400,30);
        emailTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(emailTextField);

        marital = new JLabel("MARITAL STATUS");
        marital.setFont(new Font("Raleway",Font.BOLD,22));
        marital.setBounds(100,390,200,30);
        add(marital);

        married = new JRadioButton("MARRIED");
        married.setBounds(320,390,100,30);
        married.setBackground(Color.white);
        add(married);

        unmarried = new JRadioButton("UNMARRIED");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.white);
        add(unmarried);

        other = new JRadioButton("OTHER");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(married);
        maritalGroup.add(unmarried);
        maritalGroup.add(other);


        address = new JLabel("ADDRESS");
        address.setFont(new Font("Raleway",Font.BOLD,22));
        address.setBounds(100,440,200,30);
        add(address);

        addressTextField= new JTextField();
        addressTextField.setBounds(300,440,400,30);
        addressTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(addressTextField);

        city = new JLabel("CITY");
        city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);

        cityTextField= new JTextField();
        cityTextField.setBounds(300,490,400,30);
        cityTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cityTextField);

        state = new JLabel("STATE");
        state.setFont(new Font("Raleway",Font.BOLD,22));
        state.setBounds(100,540,200,30);
        add(state);

        stateTextField= new JTextField();
        stateTextField.setBounds(300,540,400,30);
        stateTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(stateTextField);

        pincode = new JLabel("PIN CODE");
        pincode.setFont(new Font("Raleway",Font.BOLD,22));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodeTextField= new JTextField();
        pincodeTextField.setBounds(300,590,400,30);
        pincodeTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pincodeTextField);

        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850,800);
        setVisible(true);
        setLocation(350,10);
    }

    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()) {
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }
        String email = emailTextField.getText();
        String marital = null;
        if (married.isSelected()) {
            marital = "married";
        } else if (unmarried.isSelected()) {
            marital = "unmarried";
        } else if (other.isSelected()) {
            marital = "other";
        }
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else {
                Conn c=new Conn();
                String query = "INSERT INTO Signup VALUES ('" + formno + "', '" + name + "', '" + fname + "', '" + dob + "', '" + gender + "', '" + email + "', '" + marital + "', '" + address + "', '" + city + "', '" + pincode + "', '" + state + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String args []){

        new SignupOne();
    }

}
