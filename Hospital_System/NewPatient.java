package Hospital_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class NewPatient extends JFrame implements ActionListener {

    JComboBox comboBox;
    JTextField textFieldNumber, textName, textFieldDisease ,Country, textFieldDeposit;
    JRadioButton r1, r2;
    Choice c1;
    JLabel date;
    JButton b1, b2;


    NewPatient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/patient.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel labelName = new JLabel("New Patient Form");
        labelName.setBounds(118,11,260,53);
        labelName.setFont(new Font("Roboto",Font.BOLD,20));
        panel.add(labelName);

        JLabel labelID = new JLabel("ID: ");
        labelID.setBounds(35,76,200,14);
        labelID.setFont(new Font("Roboto",Font.BOLD,14));
        labelID.setForeground(Color.white);
        panel.add(labelID);

        comboBox = new JComboBox<>(new String[] {"Passport", "Driver's License", "State ID"});
        comboBox.setBounds(150, 73, 200, 30);
        comboBox.setBackground(new Color(255, 255, 255));
        comboBox.setForeground(new Color(50, 50, 50));
        comboBox.setFont(new Font("Roboto", Font.PLAIN, 14));
        comboBox.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        comboBox.setFocusable(false);
        panel.add(comboBox);

        JLabel labelNumber = new JLabel("Number: ");
        labelNumber.setBounds(35,120,200,14);
        labelNumber.setFont(new Font("Roboto",Font.BOLD,14));
        labelNumber.setForeground(Color.white);
        panel.add(labelNumber);

        textFieldNumber = new JTextField();
        textFieldNumber.setBounds(150, 111, 200, 30);
        textFieldNumber.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldNumber.setBackground(new Color(255, 255, 255));
        textFieldNumber.setForeground(new Color(50, 50, 50));
        textFieldNumber.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        textFieldNumber.setFocusable(true);
        panel.add(textFieldNumber);

        JLabel labelName1 = new JLabel("Name: ");
        labelName1.setBounds(35,161,200,14);
        labelName1.setFont(new Font("Roboto",Font.BOLD,14));
        labelName1.setForeground(Color.white);
        panel.add(labelName1);

        textName = new JTextField();
        textName.setBounds(150, 151, 200, 30);
        textName.setFont(new Font("Roboto", Font.PLAIN, 14));
        textName.setBackground(new Color(255, 255, 255));
        textName.setForeground(new Color(50, 50, 50));
        textName.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        textName.setFocusable(true);
        panel.add(textName);

        JLabel labelGender = new JLabel("Gender: ");
        labelGender.setBounds(35,201,200,14);
        labelGender.setFont(new Font("Roboto",Font.BOLD,14));
        labelGender.setForeground(Color.white);
        panel.add(labelGender);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Roboto",Font.BOLD,14));
        r1.setForeground(Color.white);
        r1.setBackground(new Color(109,164,170));
        r1.setBounds(150,201,80,15);
        panel.add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Roboto",Font.BOLD,14));
        r2.setForeground(Color.white);
        r2.setBackground(new Color(109,164,170));
        r2.setBounds(229,201,80,15);
        panel.add(r2);

        JLabel labelDisease = new JLabel("Disease: ");
        labelDisease.setBounds(35,241,200,14);
        labelDisease.setFont(new Font("Roboto",Font.BOLD,14));
        labelDisease.setForeground(Color.white);
        panel.add(labelDisease);

        textFieldDisease = new JTextField();
        textFieldDisease.setBounds(150, 231, 200, 30);
        textFieldDisease.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldDisease.setBackground(new Color(255, 255, 255));
        textFieldDisease.setForeground(new Color(50, 50, 50));
        textFieldDisease.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        textFieldDisease.setFocusable(true);
        panel.add(textFieldDisease);

        JLabel labelRoom = new JLabel("Room: ");
        labelRoom.setBounds(35,284,50,14);
        labelRoom.setFont(new Font("Roboto",Font.BOLD,14));
        labelRoom.setForeground(Color.white);
        panel.add(labelRoom);

        c1 = new Choice();
        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from Room");
            while (resultSet.next()){
                c1.add(resultSet.getString("room_no"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        c1.setBounds(150,274,150,20);
        c1.setFont(new Font("Roboto", Font.PLAIN, 14));
        c1.setForeground(Color.WHITE);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        JLabel labelDate = new JLabel("Time: ");
        labelDate.setBounds(35,326,200,14);
        labelDate.setFont(new Font("Roboto",Font.BOLD,14));
        labelDate.setForeground(Color.white);
        panel.add(labelDate);

        Date date1 = new Date();

        date = new JLabel(""+date1);
        date.setBounds(150,326,200,14);
        date.setForeground(Color.white);
        date.setFont(new Font("Roboto",Font.BOLD,14));
        panel.add(date);

        JLabel labelDeposit = new JLabel("Deposit: ");
        labelDeposit.setBounds(35,369,200,14);
        labelDeposit.setFont(new Font("Roboto",Font.BOLD,14));
        labelDeposit.setForeground(Color.white);
        panel.add(labelDeposit);

        textFieldDeposit = new JTextField();
        textFieldDeposit.setBounds(150, 359, 200, 30);
        textFieldDeposit.setFont(new Font("Roboto", Font.PLAIN, 14));
        textFieldDeposit.setBackground(new Color(255, 255, 255));
        textFieldDeposit.setForeground(new Color(50, 50, 50));
        textFieldDeposit.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        textFieldDeposit.setFocusable(true);
        panel.add(textFieldDeposit);

        b1 = new JButton("Add");
        b1.setBounds(145, 430, 120, 30);
        b1.setFont(new Font("Roboto", Font.BOLD, 14));
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(60, 120, 140));
        b1.setFocusPainted(false); // Remove default focus
        b1.setBorder(BorderFactory.createLineBorder(new Color(50, 90, 110), 2));
        b1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b1.addActionListener(this);
        panel.add(b1);

        b2 = new JButton("Back");
        b2.setBounds(300, 430, 120, 30);
        b2.setFont(new Font("Roboto", Font.BOLD, 14));
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(100, 100, 100));
        b2.setFocusPainted(false);
        b2.setBorder(BorderFactory.createLineBorder(new Color(80, 80, 80), 2));
        b2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        b2.addActionListener(this);
        panel.add(b2);

        setUndecorated(true);
        setSize(850,550);
        setLayout(null);
        setLocation(600,300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new NewPatient();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            conn c = new conn();
            String radioBtn = null;
            if (r1.isSelected()) {
                radioBtn = "Male";
            } else if (r2.isSelected()) {
                radioBtn = "Female";
            }
            String s1 = ((String) comboBox.getSelectedItem());
            String s2 = textFieldNumber.getText();
            String s3 = textName.getText();
            String s4 = radioBtn;
            String s5 = textFieldDisease.getText();
            String s6 = c1.getSelectedItem();
            String s7 = date.getText();
            String s8 = textFieldDeposit.getText();

            try {
                String q = "insert into Patient_Info values ('" + s1 + "', '" + s2 + "', '" + s3 + "', '" + s4 + "', '" + s5 + "', '" + s6 + "', '" + s7 + "', '" + s8 + "')";
                String q1 = "update Room set Availability = 'Occupied' where room_no = " + s6;
                c.statement.executeUpdate(q);
                c.statement.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Added Successfully");
                setVisible(false);
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

}
