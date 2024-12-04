package Hospital_Managment_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class SearchRoom {
    JFrame frame;
    JPanel panel;
    JTable table;
    SearchRoom(){
        frame=new JFrame();
        frame.setSize(700,500);
        frame.setLocation(450,250);
        frame.setLayout(null);
        frame.setUndecorated(true);

        panel=new JPanel();
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        panel.setBounds(5,5,690,490);
        frame.add(panel);

        JLabel heading=new JLabel("Search For Room");
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setBounds(250,11,186,35);
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel status=new JLabel("Status :");
        status.setFont(new Font("Tahoma",Font.BOLD,14));
        status.setBounds(70,70,100,20);
        status.setForeground(Color.WHITE);
        panel.add(status);
        Choice choice=new Choice();
        choice.setBounds(170,70,150,20);
        choice.add("Available");
        choice.add("Occupied");
        panel.add(choice);

        JLabel roomNo=new JLabel("Room Number");
        roomNo.setFont(new Font("Tahoma",Font.BOLD,14));
        roomNo.setBounds(15,162,120,22);
        roomNo.setForeground(Color.WHITE);
        panel.add(roomNo);

        JLabel avl=new JLabel("Availability");
        avl.setFont(new Font("Tahoma",Font.BOLD,14));
        avl.setBounds(175,162,100,22);
        avl.setForeground(Color.WHITE);
        panel.add(avl);

        JLabel price=new JLabel("Price");
        price.setFont(new Font("Tahoma",Font.BOLD,14));
        price.setBounds(400,162,100,22);
        price.setForeground(Color.WHITE);
        panel.add(price);

        JLabel bedType=new JLabel("Bed Type");
        bedType.setFont(new Font("Tahoma",Font.BOLD,14));
        bedType.setBounds(580,162,100,22);
        bedType.setForeground(Color.WHITE);
        panel.add(bedType);

        table=new JTable();
        table.setBounds(0,187,700,210);
        table.setBackground(new Color(90,156,163));
        table.setForeground(Color.WHITE);
        panel.add(table);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JButton Search=new JButton("Search");
        Search.setForeground(Color.WHITE);
        Search.setBackground(Color.BLACK);
        Search.setBounds(200,420,100,30);
        Search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               String q="select * from room where Availability = '"+choice.getSelectedItem()+"'";
               try {
                   Config c=new Config();
                   ResultSet resultSet=c.statement.executeQuery(q);
                   table.setModel(DbUtils.resultSetToTableModel(resultSet));
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }
        });
        panel.add(Search);

        JButton back=new JButton("Back");
        back.setForeground(Color.WHITE);
        back.setBackground(Color.BLACK);
        back.setBounds(380,420,100,30);
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
        new SearchRoom();
    }
}
