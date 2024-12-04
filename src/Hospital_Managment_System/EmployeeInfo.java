package Hospital_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeInfo {
    JFrame frame;
    JPanel panel;
    JTable table;
    EmployeeInfo(){
        frame=new JFrame();
        frame.setSize(1000,600);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(350,230);

        panel=new JPanel();
        panel.setBounds(5,5,990,590);
        panel.setBackground(new Color(109,164,170));
        panel.setLayout(null);
        frame.add(panel);

        JLabel label=new JLabel("Name");
        label.setBounds(41,9,70,20);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);
        JLabel label1=new JLabel("Age");
        label1.setBounds(180,9,70,20);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        JLabel label2=new JLabel("Phone Number");
        label2.setBounds(350,9,150,20);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        JLabel label3=new JLabel("Salary");
        label3.setBounds(550,9,70,20);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);
        JLabel label4=new JLabel("Gmail");
        label4.setBounds(710,9,70,20);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);
        JLabel label5=new JLabel("Aadhaar Number");
        label5.setBounds(830,9,150,20);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        table=new JTable();
        table.setBounds(10,40,980,450);
        table.setBackground(new Color(109,164,170));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        panel.add(table);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from employeeInfo");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton back=new JButton("BACK");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(350,500,120,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        panel.add(back);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new EmployeeInfo();
    }
}
