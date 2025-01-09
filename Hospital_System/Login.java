package Hospital_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField textField;
    JPasswordField jPasswordField;
    JButton b1, b2;

    Login(){

        JLabel nameLabel = new JLabel("Username");
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Roboto",Font.BOLD, 16));
        nameLabel.setForeground(Color.BLACK);
        add(nameLabel);

        JLabel password = new JLabel("Password");
        password.setBounds(40,70,100,30);
        password.setFont(new Font("Roboto",Font.BOLD, 16));
        password.setForeground(Color.BLACK);
        add(password);

        textField = new JTextField();
        textField.setBounds(150, 20, 150, 30);
        textField.setFont(new Font("Roboto", Font.PLAIN, 15));
        textField.setBackground(new Color(255, 255, 255));
        textField.setForeground(new Color(50, 50, 50));
        textField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        addPlaceholderText(textField, "Enter Username");
        add(textField);

        jPasswordField = new JPasswordField();
        jPasswordField.setBounds(150, 70, 150, 30);
        jPasswordField.setFont(new Font("Roboto", Font.PLAIN, 15));
        jPasswordField.setBackground(new Color(255, 255, 255));
        jPasswordField.setForeground(new Color(50, 50, 50));
        jPasswordField.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 2));
        addPlaceholderText(jPasswordField, "Enter Password");
        add(jPasswordField);


        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i1 = imageIcon.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(i1);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(320, -30, 400, 300);
        add(label);

        b1 = new JButton("Login");
        b1.setBounds(40, 140, 120, 30);
        b1.setFont(new Font("Roboto", Font.BOLD, 15));
        b1.setBackground(new Color(180, 150, 120));
        b1.setForeground(Color.WHITE);
        b1.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        b1.setFocusPainted(false);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Cancel");
        b2.setBounds(180, 140, 120, 30);
        b2.setFont(new Font("Roboto", Font.BOLD, 15));
        b2.setBackground(new Color(180, 150, 120));
        b2.setForeground(Color.WHITE);
        b2.setBorder(BorderFactory.createLineBorder(new Color(60, 100, 105), 2));
        b2.setFocusPainted(false);
        b2.addActionListener(this);
        add(b2);

        getContentPane().setBackground(new Color(109,164, 170));
        setSize(750, 300);
        setLocation(600,300);
        setLayout(null);
        setVisible(true);
    }

    private void addPlaceholderText(JTextField field, String placeholder) {
        field.setText(placeholder);
        field.setForeground(new Color(150, 150, 150));

        field.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (field.getText().equals(placeholder)) {
                    field.setText("");
                    field.setForeground(new Color(50, 50, 50));
                }
            }

            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                if (field.getText().isEmpty()) {
                    field.setText(placeholder);
                    field.setForeground(new Color(150, 150, 150));
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            try{
                conn c = new conn();
                String user = textField.getText();
                String Pass = jPasswordField.getText();

                String q = "select * from login where ID = '"+user+"' and PW = '"+Pass+"'";
                ResultSet resultSet = c.statement.executeQuery(q);

                if(resultSet.next()){
                    new Reception();
                    setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid");
                }
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            System.exit(10);
        }
    }
}
