package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class UpdateDetails {
    JFrame frame;
    JPanel panel;
    UpdateDetails(){
        frame=new JFrame();
        frame.setSize(950,500);
        frame.setLayout(null);
        frame.setLocation(400,250);
        frame.setUndecorated(true);

        panel=new JPanel();
        panel.setBounds(5,5,940,490);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        frame.add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/updated.png"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(500,60,300,300);
        panel.add(label);

        JLabel heading=new JLabel("Update Patient Details");
        heading.setBounds(124,11,260,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        JLabel name=new JLabel("Name :");
        name.setBounds(25,88,100,14);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        name.setForeground(Color.WHITE);
        panel.add(name);
        Choice choice=new Choice();
        choice.setBounds(248,85,150,25);
        panel.add(choice);
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from patient_info");
            while (resultSet.next()){
                choice.add(resultSet.getString("name"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel room=new JLabel("Room Number :");
        room.setBounds(25,129,130,14);
        room.setForeground(Color.white);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);
        JTextField roomText=new JTextField();
        roomText.setBounds(248,129,150,20);
        panel.add(roomText);

        JLabel time=new JLabel("In-Time :");
        time.setBounds(25,174,100,14);
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        time.setForeground(Color.WHITE);
        panel.add(time);
        JTextField timeText=new JTextField();
        timeText.setBounds(248,174,150,20);
        panel.add(timeText);

        JLabel amountPaid=new JLabel("Amount Paid (Rs) :");
        amountPaid.setBounds(25,216,150,14);
        amountPaid.setFont(new Font("Tahoma",Font.BOLD,14));
        amountPaid.setForeground(Color.WHITE);
        panel.add(amountPaid);
        JTextField amountPaidText=new JTextField();
        amountPaidText.setBounds(248,216,150,20);
        panel.add(amountPaidText);

        JLabel pandingAmount=new JLabel("Pending Amount (Rs) :");
        pandingAmount.setBounds(25,261,170,17);
        pandingAmount.setFont(new Font("Tahoma",Font.BOLD,14));
        pandingAmount.setForeground(Color.WHITE);
        panel.add(pandingAmount);
        JTextField pandingAmountText=new JTextField();
        pandingAmountText.setBounds(248,261,150,20);
        panel.add(pandingAmountText);

        JButton check=new JButton("Check");
        check.setBounds(281,378,89,23);
        check.setForeground(Color.WHITE);
        check.setBackground(Color.BLACK);
        check.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=choice.getSelectedItem();
                String q="select * from patient_info where name = '"+name+"'";
                try {
                    Config c=new Config();
                    ResultSet resultSet=c.statement.executeQuery(q);
                    while (resultSet.next()){
                     roomText.setText(resultSet.getString("Room_no"));
                     timeText.setText(resultSet.getString("Time"));
                     amountPaidText.setText(resultSet.getString("Deposit"));
                    }
                    ResultSet resultSet1=c.statement.executeQuery("select * from room where Room_no='"+roomText.getText()+"'");
                    while(resultSet1.next()){
                       String price=resultSet1.getString("Price");
                       int amountPaid=Integer.parseInt(price)- Integer.parseInt(amountPaidText.getText());
                       pandingAmountText.setText(""+amountPaid);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(check);

        JButton update=new JButton("Update");
        update.setBounds(56,378,89,23);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLACK);
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Config c=new Config();
                    String q=choice.getSelectedItem();
                    String room=roomText.getText();
                    String time=timeText.getText();
                    String amount=amountPaidText.getText();
                    c.statement.executeUpdate("update patient_info set Room_no='"+room+"',Time='"+time+"',Deposit='"+amount+"' where Name='"+q+"'");
                    JOptionPane.showMessageDialog(null,"Updated Successfully");
                    frame.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(update);

        JButton back=new JButton("Back");
        back.setBounds(168,378,89,23);
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
        new UpdateDetails();
    }
}
