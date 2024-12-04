package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class AddPatient {
    JFrame frame;
    JComboBox comboBox;
    JTextField numberText,nameText,diseaseText,depositText;
    JLabel number,name,deposit,gender,disease,room,time;
    JRadioButton r1,r2;
    Choice c1;
    JLabel date;
    JButton add,back;
    AddPatient(){
        frame=new JFrame();
        frame.setSize(850,550);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(300,250);

        JPanel panel=new JPanel();
        panel.setBounds(5,5,840,540);
        panel.setBackground(new Color(90,156,163));
        panel.setLayout(null);
        frame.add(panel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/patient.png"));
        Image image=imageIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(550,150,200,200);
        panel.add(label);

        JLabel heading =new JLabel("NEW PATIENT FORM");
        heading.setBounds(118,11,260,53);
        heading.setFont(new Font("Tahoma",Font.BOLD,20));
        panel.add(heading);

        JLabel ID=new JLabel("ID :");
        ID.setFont(new Font("Tahoma",Font.BOLD,14));
        ID.setForeground(Color.WHITE);
        ID.setBounds(35,76,200,14);
        panel.add(ID);
        comboBox=new JComboBox<>(new String[] {"Aadhaar Card","Voter Id","Driving License"});
        comboBox.setBounds(271,73,150,20);
        comboBox.setForeground(Color.WHITE);
        comboBox.setBackground(new Color(3,45,48));
        comboBox.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(comboBox);

        number=new JLabel("Number :");
        number.setForeground(Color.white);
        number.setBounds(35,111,200,14);
        number.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(number);
        numberText=new JTextField();
        numberText.setBounds(271,111,150,20);
        panel.add(numberText);


        name=new JLabel("Name :");
        name.setForeground(Color.white);
        name.setBounds(35,151,200,14);
        name.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(name);
        nameText=new JTextField();
        nameText.setBounds(271,151,150,20);
        panel.add(nameText);

        gender=new JLabel("Gender :");
        gender.setForeground(Color.white);
        gender.setBounds(34,191,200,14);
        gender.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(gender);
       r1=new JRadioButton("Male");
       r1.setBounds(271,191,80,14);
       r1.setFont(new Font("Tahoma",Font.BOLD,15));
       r1.setBackground(new Color(109,164,170));
       r1.setForeground(Color.WHITE);
       panel.add(r1);
        r2=new JRadioButton("Female");
        r2.setBounds(350,191,80,14);
        r2.setFont(new Font("Tahoma",Font.BOLD,15));
        r2.setBackground(new Color(109,164,170));
        r2.setForeground(Color.WHITE);
        panel.add(r2);
        ButtonGroup group=new ButtonGroup();
        group.add(r1);
        group.add(r2);

        disease=new JLabel("Disease :");
        disease.setForeground(Color.white);
        disease.setBounds(35,231,200,14);
        disease.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(disease);
        diseaseText=new JTextField();
        diseaseText.setBounds(271,231,150,20);
        panel.add(diseaseText);

        room=new JLabel("Room :");
        room.setForeground(Color.white);
        room.setBounds(35,271,200,14);
        room.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(room);
        c1=new Choice();
        try {
            Config c=new Config();
            ResultSet resultSet=c.statement.executeQuery("select * from room");
            while (resultSet.next()){
                c1.add(resultSet.getString("Room_no"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        c1.setBounds(271,271,150,20);
        c1.setFont(new Font("Tahoma",Font.BOLD,14));
        c1.setForeground(Color.white);
        c1.setBackground(new Color(3,45,48));
        panel.add(c1);

        time=new JLabel("Time :");
        time.setForeground(Color.white);
        time.setBounds(35,311,200,14);
        time.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(time);

        Date date1=new Date();
        date=new JLabel(""+date1);
        date.setBounds(271,311,280,14);
        date.setFont(new Font("Tahoma",Font.BOLD,14));
        date.setForeground(Color.WHITE);
        panel.add(date);

        deposit=new JLabel("Deposit :");
        deposit.setForeground(Color.white);
        deposit.setBounds(35,351,200,17);
        deposit.setFont(new Font("Tahoma",Font.BOLD,14));
        panel.add(deposit);
        depositText=new JTextField();
        depositText.setBounds(271,351,150,20);
        panel.add(depositText);

        add=new JButton("Add");
        add.setBounds(100,430,120,30);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               Config c=new Config();
               String gender=null;
               if(r1.isSelected()){
                   gender="Male";
               } else if (r2.isSelected()) {
                   gender="Female";
               }
               String ID=(String) comboBox.getSelectedItem();
               String number=numberText.getText();
               String name=nameText.getText();
               String gan=gender;
               String disease=diseaseText.getText();
               String choice=c1.getSelectedItem();
               String d=date.getText();
               String dep=depositText.getText();
               try {
                   String q="insert into patient_info values('"+ID+"','"+number+"','"+name+"','"+gan+"','"+disease+"','"+choice+"','"+d+"','"+dep+"')";
                   String q1="update room set Availability ='Occupied' where Room_no = "+choice;
                   c.statement.executeUpdate(q);
                   c.statement.executeUpdate(q1);
                   JOptionPane.showMessageDialog(null,"Added Successfully");
                   frame.setVisible(false);
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
            }
        });
        panel.add(add);

        back=new JButton("Back");
        back.setBounds(260,430,120,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
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
        new AddPatient();
    }
}
