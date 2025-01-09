package Hospital_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Update_Patient extends JFrame {

    Update_Patient(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/updated.png"));
        Image image = imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(500,50,300,300);
        panel.add(label);

        JLabel label1 = new JLabel("Update Patient Details");
        label1.setBounds(124,11,222,25);
        label1.setFont(new Font("Roboto", Font.BOLD, 20));
        label1.setForeground(Color.white);
        panel.add(label1);

        JLabel label2 = new JLabel("Name : ");
        label2.setBounds(25,88,100,14);
        label2.setFont(new Font("Roboto", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(248,85,140,25);
        panel.add(choice);

        try {
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number : ");
        label3.setBounds(25,129,150,14);
        label3.setFont(new Font("Roboto", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JTextField textFieldR = new JTextField();
        textFieldR.setBounds(248,129,140,20);
        panel.add(textFieldR);

        JLabel label4 = new JLabel("In-Time : ");
        label4.setBounds(25,174,100,14);
        label4.setFont(new Font("Roboto", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JTextField textFieldINTime = new JTextField();
        textFieldINTime.setBounds(248,174,140,20);
        panel.add(textFieldINTime);

        JLabel label5 = new JLabel("Amount Paid : ");
        label5.setBounds(25,    216,100,14);
        label5.setFont(new Font("Roboto", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        JTextField textFieldAmount = new JTextField();
        textFieldAmount.setBounds(248,216,140,20);
        panel.add(textFieldAmount);

        JLabel label6 = new JLabel("Pending Amount : ");
        label6.setBounds(25,261,150,14);
        label6.setFont(new Font("Roboto", Font.BOLD, 14));
        label6.setForeground(Color.white);
        panel.add(label6);

        JTextField textFieldPending = new JTextField();
        textFieldPending.setBounds(248,261,140,20);
        panel.add(textFieldPending);

        JButton check = new JButton("CHECK");
        check.setBounds(281, 378, 110, 40);
        check.setFont(new Font("Roboto", Font.BOLD, 14));
        check.setBackground(new Color(60, 120, 140));
        check.setForeground(Color.WHITE);
        check.setFocusPainted(false);
        check.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 120), 2));
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(check);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = choice.getSelectedItem();
                String q = "select * from patient_info where name = '" + id + "'";
                try {
                    conn c = new conn();
                    ResultSet resultSet = c.statement.executeQuery(q);
                    while (resultSet.next()) {
                        textFieldR.setText(resultSet.getString("Room_Number"));
                        textFieldINTime.setText(resultSet.getString("Time"));
                        textFieldAmount.setText(resultSet.getString("Deposit"));
                    }

                    ResultSet resultSet1 = c.statement.executeQuery("select * from room where room_no = '" + textFieldR.getText() + "'");
                    while (resultSet1.next()) {
                        String price = resultSet1.getString("Price");
                        int amountPaid = Integer.parseInt(price) - Integer.parseInt(textFieldAmount.getText());
                        textFieldPending.setText("" + amountPaid);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton update = new JButton("UPDATE");
        update.setBounds(56, 378, 110, 40); // Adjust width and height for better proportions
        update.setFont(new Font("Roboto", Font.BOLD, 14)); // Modern font
        update.setBackground(new Color(60, 120, 140)); // Muted teal background
        update.setForeground(Color.WHITE); // White text for contrast
        update.setFocusPainted(false); // Remove default focus behavior
        update.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 120), 2)); // Subtle border
        update.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Hand cursor for hover
        panel.add(update);

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    conn c = new conn();
                    String q = choice.getSelectedItem();
                    String room = textFieldR.getText();
                    String time = textFieldINTime.getText();
                    String amount = textFieldAmount.getText();

                    c.statement.executeUpdate("update patient_info set Room_Number = '"+room+"', Time = '"+time+"', Deposit = '"+amount+"' where name =  '"+q+"'");

                    JOptionPane.showMessageDialog(null, "Update Successful");
                } catch (Exception E) {
                    E.printStackTrace();
                }
            }
        });


        JButton back = new JButton("BACK");
        back.setBounds(168, 378, 110, 40);
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBackground(new Color(60, 120, 140));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 120), 2));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });



        setUndecorated(true);
        setSize(950, 500);
        setLocation(600, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Update_Patient();
    }
}
