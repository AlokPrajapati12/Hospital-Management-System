package Hospital_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class PatientInfo {
    JFrame frame;
    JPanel panel;
    JTable table;
    PatientInfo(){
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

        JLabel label=new JLabel("ID");
        label.setBounds(31,11,100,14);
        label.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label);

        JLabel label1=new JLabel("Number");
        label1.setBounds(131,11,100,14);
        label1.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label1);

        JLabel label2=new JLabel("Name");
        label2.setBounds(240,11,100,14);
        label2.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label2);

        JLabel label3=new JLabel("Gender");
        label3.setBounds(360,11,100,14);
        label3.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label3);

        JLabel label4=new JLabel("Disease");
        label4.setBounds(470,11,100,14);
        label4.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label4);

        JLabel label5=new JLabel("Room No");
        label5.setBounds(590,11,100,14);
        label5.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label5);

        JLabel label6=new JLabel("Time");
        label6.setBounds(700,11,100,14);
        label6.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label6);

        JLabel label7=new JLabel("Deposit");
        label7.setBounds(800,11,100,14);
        label7.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(label7);

        table=new JTable();
        table.setBackground(new Color(90,156,163));
        table.setFont(new Font("Tahoma",Font.BOLD,12));
        table.setBounds(10,40,900,450);
        panel.add(table);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
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
        new PatientInfo();
    }
}
