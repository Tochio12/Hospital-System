package Hospital_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Discharge extends JFrame {
    Discharge(){

        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JLabel label = new JLabel("CHECK-OUT");
        label.setBounds(100, 20, 150, 20);
        label.setFont(new Font("Roboto", Font.BOLD, 20));
        label.setForeground(Color.white);
        panel.add(label);

        JLabel label2 = new JLabel("Customer Name");
        label2.setBounds(30, 80, 150, 20);
        label2.setFont(new Font("Roboto", Font.BOLD, 14));
        label2.setForeground(Color.white);
        panel.add(label2);

        Choice choice = new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);

        try{
            conn c = new conn();
            ResultSet resultSet = c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("Name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        JLabel label3 = new JLabel("Room Number");
        label3.setBounds(30, 130, 150, 20);
        label3.setFont(new Font("Roboto", Font.BOLD, 14));
        label3.setForeground(Color.white);
        panel.add(label3);

        JLabel RNo = new JLabel();
        RNo.setBounds(200, 130, 150, 20);
        RNo.setFont(new Font("Roboto", Font.BOLD, 14));
        RNo.setForeground(Color.white);
        panel.add(RNo);

        JLabel label4 = new JLabel("In Time");
        label4.setBounds(30, 180, 150, 20);
        label4.setFont(new Font("Roboto", Font.BOLD, 14));
        label4.setForeground(Color.white);
        panel.add(label4);

        JLabel INTime = new JLabel();
        INTime.setBounds(200, 180, 250, 20);
        INTime.setFont(new Font("Roboto", Font.BOLD, 14));
        INTime.setForeground(Color.white);
        panel.add(INTime);

        JLabel label5 = new JLabel("Out Time");
        label5.setBounds(30, 230, 150, 20);
        label5.setFont(new Font("Roboto", Font.BOLD, 14));
        label5.setForeground(Color.white);
        panel.add(label5);

        Date date = new Date();

        JLabel OUTTime = new JLabel(""+date);
        OUTTime.setBounds(200, 230, 250, 20);
        OUTTime.setFont(new Font("Roboto", Font.BOLD, 14));
        OUTTime.setForeground(Color.white);
        panel.add(OUTTime);

        JButton discharge = new JButton("Discharge");
        discharge.setBounds(30, 300, 120, 40);
        discharge.setFont(new Font("Roboto", Font.BOLD, 14));
        discharge.setBackground(new Color(60, 120, 140));
        discharge.setForeground(Color.WHITE);
        discharge.setFocusPainted(false);
        discharge.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 120), 2));
        discharge.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(discharge);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                conn c = new conn();
                try {
                    c.statement.executeUpdate("DELETE FROM patient_info WHERE name = '" + choice.getSelectedItem() + "'");

                    c.statement.executeUpdate("UPDATE room SET Availability = 'Available' WHERE room_no = '" + RNo.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Discharge Successful");
                    setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        JButton check = new JButton("Check");
        check.setBounds(170, 300, 120, 40);
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
                conn c = new conn();
                try {
                    String query = "select * from patient_info where name = '" + choice.getSelectedItem() + "'";
                    ResultSet resultSet = c.statement.executeQuery(query);

                    while (resultSet.next()) {
                        RNo.setText(resultSet.getString("room_number"));
                        INTime.setText(resultSet.getString("time"));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        JButton back = new JButton("Back");
        back.setBounds(300, 300, 120, 40);
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
        setSize(800, 600);
        setLocation(600, 300);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Discharge();
    }
}
