package Hospital_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Ambulance {
    JFrame frame;
    JPanel panel;
    JTable table;
    Ambulance(){
        frame=new JFrame();
        frame.setLocation(300,200);
        frame.setSize(900,600);
        frame.setUndecorated(true);
        frame.setLayout(null);

        panel=new JPanel();
        panel.setBackground(new Color(90,156,163));
        panel.setBounds(5,5,890,590);
        panel.setLayout(null);
        frame.add(panel);

        JLabel label=new JLabel("Name");
        label.setBounds(31,11,100,14);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1=new JLabel("Gender");
        label1.setBounds(200,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Car Name");
        label2.setBounds(380,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Available");
        label3.setBounds(600,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Location");
        label4.setBounds(750,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        table=new JTable();
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        table.setBounds(10,40,900,450);
        panel.add(table);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from ambulance");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));

        }catch (Exception e){
            e.printStackTrace();
        }

        JButton back=new JButton("BACK");
        back.setBounds(450,510,120,30);
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
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
        new Ambulance();
    }
}
