package Bank.System;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class SignupTwo extends JFrame implements ActionListener{


    JTextField pannumberTextField,aadharcardTextField;

   JComboBox jreligion,jcategory,jincome,education,joccupation;
    JRadioButton yesone,noone, yestwo,notwo;
    JButton next;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM TWO");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);

        JLabel religion = new JLabel("Religion");
        religion.setFont(new Font("Raleway",Font.BOLD,22));
        religion.setBounds(100,140,100,30);
        add(religion);

        String valReligion[]={"Hindu", "Muslim", "Sikh", "Christian",  "Other"};
        jreligion = new JComboBox(valReligion);
        jreligion.setBounds(300,140,400,30);
        jreligion.setFont(new Font("Arial",Font.BOLD,14));
        jreligion.setBackground(Color.white);
        add(jreligion);

        JLabel category = new JLabel("Category");
        category.setFont(new Font("Raleway",Font.BOLD,22));
        category.setBounds(100,190,200,30);
        add(category);


        String valcategory []={"General","OBC","ST","SC", "Other"};
        jcategory = new JComboBox(valcategory);;
        jcategory.setBounds(300,190,400,30);
        jcategory.setFont(new Font("Arial",Font.BOLD,14));
        jcategory.setBackground(Color.white);
        add(jcategory);

        JLabel income= new JLabel("Income");
        income.setFont(new Font("Raleway",Font.BOLD,22));
        income.setBounds(100,240,200,30);
        add(income);

        String valincome []={"--Null--", "<1,50,000", "<3,50,000", "<5,00,000", "Up to 10,00,000"};
        jincome = new JComboBox(valincome);
        jincome.setBounds(300,240,400,30);
        jincome.setFont(new Font("Arial",Font.BOLD,14));
        jincome.setBackground(Color.white);
        add(jincome);

        JLabel  educational = new JLabel("Educational");
        educational.setFont(new Font("Raleway",Font.BOLD,22));
        educational.setBounds(100,290,200,30);
        add(educational);


        JLabel qualification = new JLabel("Qualification:");
        qualification.setFont(new Font("Raleway",Font.BOLD,22));
        qualification.setBounds(100,320,200,30);
        add(qualification);

        String valeducational[]={"Non-Graduation","Graduation","Post--Graduation","Diploma","ITI","Others" };
        education = new JComboBox(valeducational);
        education.setBounds(300,300,400,30);
        education.setFont(new Font("Arial",Font.BOLD,14));
        education.setBackground(Color.white);
        add(education);


//        qualificationTextField = new JTextField();
//        qualificationTextField.setBounds(300,340,400,30);
//        qualificationTextField.setFont(new Font("Arial",Font.BOLD,14));
//        add(qualificationTextField);

        JLabel occupation = new JLabel("Occupation");
        occupation.setFont(new Font("Raleway",Font.BOLD,22));
        occupation.setBounds(100,370,200,30);
        add(occupation);

        String valoccupation []={"Salaried","Self-employee","Bussiness man","Retired","Others"};
        joccupation = new JComboBox(valoccupation);
        joccupation.setBounds(300,370,400,30);
        joccupation.setFont(new Font("Arial",Font.BOLD,14));
        joccupation.setBackground(Color.white);
        add(joccupation);

        JLabel pannumber = new JLabel("Pan Number");
        pannumber.setFont(new Font("Raleway",Font.BOLD,22));
        pannumber.setBounds(100,420,200,30);
        add(pannumber);

        pannumberTextField = new JTextField();
        pannumberTextField.setBounds(300,420,400,30);
        pannumberTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pannumberTextField);

        JLabel aadharcard = new JLabel("Aadhar Card");
        aadharcard.setFont(new Font("Raleway",Font.BOLD,22));
        aadharcard.setBounds(100,470,200,30);
        add(aadharcard);

        aadharcardTextField= new JTextField();
        aadharcardTextField.setBounds(300,470,400,30);
        aadharcardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(aadharcardTextField);

        JLabel seniorcitizen = new JLabel("Senior Citizen");
        seniorcitizen.setFont(new Font("Raleway",Font.BOLD,22));
        seniorcitizen.setBounds(100,520,200,30);
        add(seniorcitizen);

        yesone = new JRadioButton("YES");
        yesone.setBounds(320,520,100,30);
        yesone.setBackground(Color.white);
        add(yesone);

        noone = new JRadioButton("No");
        noone.setBounds(450,520,100,30);
        noone.setBackground(Color.white);
        add(noone);

        ButtonGroup dmakingGroup=new ButtonGroup();
        dmakingGroup.add(yesone);
        dmakingGroup.add(noone);

        JLabel existingaccount = new JLabel("Existing Account");
        existingaccount.setFont(new Font("Raleway",Font.BOLD,22));
        existingaccount.setBounds(100,570,200,30);
        add(existingaccount);

        yestwo = new JRadioButton("YES");
        yestwo.setBounds(320,570,100,30);
        yestwo.setBackground(Color.white);
        add(yestwo);

        notwo = new JRadioButton("No");
        notwo.setBounds(450,570,100,30);
        notwo.setBackground(Color.white);
        add(notwo);

        ButtonGroup decisionmakingGroup=new ButtonGroup();
        decisionmakingGroup.add(yestwo);
        decisionmakingGroup.add(notwo);



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
        String religion = (String) jreligion.getSelectedItem();
        String category = (String) jcategory.getSelectedItem();
        String income = (String) jincome.getSelectedItem();
        String qualification = (String) education.getSelectedItem();
        String occupation = (String) joccupation.getSelectedItem();
        String pannumber = pannumberTextField.getText();
        String aadharcard = aadharcardTextField.getText();
        String seniorcitizen = null;
        if (yesone.isSelected()) {
            seniorcitizen = "Yes";
        } else if (noone.isSelected()) {
            seniorcitizen = "No";
        }
        String existingaccount = null;
        if (yestwo.isSelected()) {
            existingaccount = "Yes";
        } else if (notwo.isSelected()) {
            existingaccount = "No";
        }

        try {
            if (religion.equals("")) {
                JOptionPane.showMessageDialog(null, "religion is Required");
            }
            else {
                Conn c=new Conn();
                String query = "INSERT INTO SignupTwo VALUES ('" + formno + "','" + religion + "', '" + category + "', '" + income + "', '" + qualification + "', '" + occupation + "', '" + pannumber + "', '" + aadharcard + "', '" + seniorcitizen + "', '" + existingaccount + "')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String args []){
        new SignupTwo("");
    }

}
