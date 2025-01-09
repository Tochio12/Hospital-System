package Hospital_System;
import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Employee_info extends JFrame{
    Employee_info(){
        JPanel panel = new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        add(panel);

        JTable table = new JTable();
        table.setBounds(10, 34, 980, 450);

        table.setFont(new Font("Roboto", Font.PLAIN, 15));
        table.setRowHeight(25);
        table.setBackground(Color.WHITE);
        table.setForeground(new Color(50, 50, 50));
        table.setGridColor(new Color(200, 200, 200));
        table.setShowVerticalLines(false);
        table.setShowHorizontalLines(true);



        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(10, 34, 980, 450);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        scrollPane.getViewport().setBackground(new Color(109, 164, 170));
        panel.add(scrollPane);

        try {
            conn c = new conn();
            String q = "select * from Emplyee_Info";
            ResultSet resultSet = c.statement.executeQuery(q);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton button = new JButton("BACK");
        button.setBounds(350, 500, 120, 40);
        button.setFont(new Font("Roboto", Font.BOLD, 14));
        button.setBackground(new Color(60, 120, 140));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(new Color(50, 100, 120), 2));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        panel.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });




        setUndecorated(true);
        setSize(1000, 600);
        setLocation(600, 300);
        setLayout(null);
        setVisible(true);
    }
    public static void main(String[] args) {
        new Employee_info();
    }
}
