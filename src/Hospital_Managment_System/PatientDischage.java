package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.DrbgParameters;
import java.sql.ResultSet;
import java.util.Date;

public class PatientDischage {
    JFrame frame;
    JPanel panel;
    JButton check,discharge,back;
    PatientDischage(){
        frame=new JFrame();
        frame.setSize(800,400);
        frame.setUndecorated(true);
        frame.setLayout(null);
        frame.setLocation(400,250);

        panel=new JPanel();
        panel.setLayout(null);
        panel.setBounds(5,5,790,390);
        panel.setBackground(new Color(90,156,163));
        frame.add(panel);

        JLabel label=new JLabel("CHECK-OUT");
        label.setBounds(100,20,120,22);
        label.setFont(new Font("Tahoma",Font.BOLD,20));
        label.setForeground(Color.WHITE);
        panel.add(label);

        JLabel label1=new JLabel("Customer ID");
        label1.setBounds(30,80,150,20);
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);
        Choice choice=new Choice();
        choice.setBounds(200,80,150,25);
        panel.add(choice);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("number"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel label2=new JLabel("Room Number");
        label2.setBounds(30,130,150,20);
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);
        JLabel roomText=new JLabel();
        roomText.setBounds(200,130,150,20);
        roomText.setFont(new Font("Tahoma",Font.BOLD,14));
        roomText.setForeground(Color.WHITE);
        panel.add(roomText);

        JLabel label3=new JLabel("In Time");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        label3.setBounds(30,180,150,20);
        panel.add(label3);
        JLabel timeText=new JLabel();
        timeText.setForeground(Color.WHITE);
        timeText.setFont(new Font("Tahoma",Font.BOLD,14));
        timeText.setBounds(200,180,270,20);
        panel.add(timeText);

        JLabel date=new JLabel("Out Time");
        date.setForeground(Color.WHITE);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setBounds(30,230,150,20);
        panel.add(date);
        Date date1=new Date();
        JLabel dateText=new JLabel(""+date1);
        dateText.setForeground(Color.WHITE);
        dateText.setFont(new Font("Tahoma",Font.BOLD,14));
        dateText.setBounds(200,230,270,20);
        panel.add(dateText);

        discharge=new JButton("Discharge");
        discharge.setBackground(Color.BLACK);
        discharge.setForeground(Color.WHITE);
        discharge.setBounds(30,300,120,30);
        discharge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Config c=new Config();
                try {
                    c.statement.executeUpdate("delete from patient_info where number = '"+choice.getSelectedItem()+"'");
                    c.statement.executeUpdate("update room set Availability = 'Available' where Room_no = '"+roomText.getText()+"'");
                    JOptionPane.showMessageDialog(null,"Done!!");
                    frame.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(discharge);

        check=new JButton("Check");
        check.setBackground(Color.BLACK);
        check.setForeground(Color.WHITE);
        check.setBounds(170,300,120,30);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Config c=new Config();
               try {
                   ResultSet resultSet=c.statement.executeQuery("select * from patient_info where number='"+choice.getSelectedItem()+"'");
                   while (resultSet.next()){
                       roomText.setText(resultSet.getString("Room_no"));
                       timeText.setText(resultSet.getString("Time"));
                   }
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }
        });
        panel.add(check);

        back=new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(300,300,120,30);
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
        new PatientDischage();
    }
}
