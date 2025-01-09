package Hospital_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Reception extends JFrame {
    Reception(){

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(5, 160, 1950, 1000);
        panel.setBackground(new Color(109, 170, 115));
        add(panel);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(5, 5, 1950, 150);
        panel1.setBackground(new Color(109,164,170));
        add(panel1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dr.png"));
        Image image = i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(image);
        JLabel label = new JLabel(i2);
        label.setBounds(1650,0,250,250);
        panel1.add(label);

        ImageIcon i12 = new ImageIcon(ClassLoader.getSystemResource("icons/amb.png"));
        Image image2 = i12.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon i22 = new ImageIcon(image2);
        JLabel label2 = new JLabel(i22);
        label2.setBounds(1400,50,300,100);
        panel1.add(label2);

        JButton btn1 = new JButton("Add New Patient");
        btn1.setBounds(30, 15, 200, 30);
        btn1.setFont(new Font("Roboto", Font.BOLD, 15));
        btn1.setBackground(new Color(180, 150, 120));
        btn1.setForeground(Color.WHITE);
        btn1.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn1.setFocusPainted(false);
        btn1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn1);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NewPatient();
            }
        });

        JButton btn2 = new JButton("Room");
        btn2.setBounds(30, 58, 200, 30);
        btn2.setFont(new Font("Roboto", Font.BOLD, 15));
        btn2.setBackground(new Color(180, 150, 120));
        btn2.setForeground(Color.WHITE);
        btn2.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn2.setFocusPainted(false);
        btn2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Room();
            }
        });

        JButton btn3 = new JButton("Department");
        btn3.setBounds(30, 100, 200, 30);
        btn3.setFont(new Font("Roboto", Font.BOLD, 15));
        btn3.setBackground(new Color(180, 150, 120));
        btn3.setForeground(Color.WHITE);
        btn3.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn3.setFocusPainted(false);
        btn3.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn3);
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Department();
            }
        });

        JButton btn4 = new JButton("All Employee Info");
        btn4.setBounds(270, 15, 200, 30);
        btn4.setFont(new Font("Roboto", Font.BOLD, 15));
        btn4.setBackground(new Color(180, 150, 120));
        btn4.setForeground(Color.WHITE);
        btn4.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn4.setFocusPainted(false);
        btn4.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn4);
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Employee_info();
            }
        });

        JButton btn5 = new JButton("Patient Info");
        btn5.setBounds(270, 58, 200, 30);
        btn5.setFont(new Font("Roboto", Font.BOLD, 15));
        btn5.setBackground(new Color(180, 150, 120));
        btn5.setForeground(Color.WHITE);
        btn5.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn5.setFocusPainted(false);
        btn5.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn5);
        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Patient_info();
            }
        });

        JButton btn6 = new JButton("Patient Discharge");
        btn6.setBounds(270, 100, 200, 30);
        btn6.setFont(new Font("Roboto", Font.BOLD, 15));
        btn6.setBackground(new Color(180, 150, 120));
        btn6.setForeground(Color.WHITE);
        btn6.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn6.setFocusPainted(false);
        btn6.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn6);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Discharge();
            }
        });

        JButton btn7 = new JButton("Update Patient details");
        btn7.setBounds(510, 15, 200, 30);
        btn7.setFont(new Font("Roboto", Font.BOLD, 15));
        btn7.setBackground(new Color(180, 150, 120));
        btn7.setForeground(Color.WHITE);
        btn7.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn7.setFocusPainted(false);
        btn7.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn7);
        btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Update_Patient();
            }
        });

        JButton btn10 = new JButton("Logout");
        btn10.setBounds(510, 58, 200, 30);
        btn10.setFont(new Font("Roboto", Font.BOLD, 15));
        btn10.setBackground(new Color(180, 150, 120));
        btn10.setForeground(Color.WHITE);
        btn10.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        btn10.setFocusPainted(false);
        btn10.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel1.add(btn10);
        btn10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Login();
            }
        });


        setSize(1950, 1090);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Reception();
    }

}
