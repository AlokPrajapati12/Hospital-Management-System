package Hospital_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Department {
    JFrame frame;
    JPanel panel;
    JTable table;
    Department(){
        frame=new JFrame();
        frame.setSize(700,500);
        frame.setLocation(350,250);
        frame.setUndecorated(true);
        frame.setLayout(null);

        panel=new JPanel();
        panel.setBounds(5,5,690,490);
        panel.setLayout(null);
        panel.setBackground(new Color(90,156,163));
        frame.add(panel);

        JLabel label=new JLabel("Department");
        label.setBounds(100,11,105,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1=new JLabel("Phone Number");
        label1.setBounds(370,11,120,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JButton back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(400,410,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(back);

        table=new JTable();
        table.setBounds(2,40,700,350);
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(table);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Department();
    }
}
