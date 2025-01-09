package Hospital_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Room extends JFrame {
    JTable table;

    Room(){
        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 890, 590);
        panel.setBackground(new Color(90, 156, 163));
        panel.setLayout(null);
        add(panel);

// Add Image
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icons/room.png"));
        Image image = imageIcon.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon1);
        label.setBounds(650, 180, 200, 200);
        panel.add(label);

// Table Styling
        JTable table = new JTable();
        table.setFont(new Font("Roboto", Font.PLAIN, 14));
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(50, 50, 50));
        table.setGridColor(new Color(200, 200, 200));
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);


        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 50, 600, 400);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1)); // Add a clean border
        panel.add(scrollPane);


        try {
            conn c = new conn();
            String q = "select * from room";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }



        JButton back = new JButton("Back");
        back.setBounds(200, 500, 120, 40);
        back.setFont(new Font("Roboto", Font.BOLD, 14));
        back.setBackground(new Color(60, 100, 105));
        back.setForeground(Color.WHITE);
        back.setFocusPainted(false);
        back.setBorder(BorderFactory.createLineBorder(new Color(50, 80, 85), 2));
        back.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(back);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

        setUndecorated(true);
        setSize(900, 600);
        setLayout(null);
        setLocation(600,300);
        setVisible(true);

    }
    public static void main(String[] args) {
        new Room();
    }
}
