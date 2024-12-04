package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Reception {
    JFrame frame;
    JPanel p1,p2;
    JButton newPasent,room,department,empInfo,pasientInfo,patientDischage,updatePatientDetails,AMB,searchRoom,logout;
    Reception(){
        frame=new JFrame();
        frame.setSize(1950,1090);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(Color.white);

        p1=new JPanel();
        p1.setLayout(null);
        p1.setBounds(5,5,1525,150);
        p1.setBackground(new Color(109, 164, 170));
        frame.add(p1);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icon/dr.png"));
        Image image=img.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(image);
        JLabel label=new JLabel(img2);
        label.setBounds(1300,0,250,250);
        p1.add(label);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/amb.png"));
        Image image1=imageIcon.getImage().getScaledInstance(300,100,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image1);
        JLabel label1=new JLabel(imageIcon1);
        label1.setBounds(1000,50,300,100);
        p1.add(label1);

        newPasent=new JButton("Add New Patient");
        newPasent.setBackground(new Color(246,215,118));
        newPasent.setBounds(30,15,200,30);
        newPasent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatient();
            }
        });
        p1.add(newPasent);

        room=new JButton("Room");
        room.setBackground(new Color(246,215,118));
        room.setBounds(30,58,200,30);
        room.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    new RoomDetails();
            }
        });
        p1.add(room);

        department=new JButton("Department");
        department.setBackground(new Color(246,215,118));
        department.setBounds(30,100,200,30);
        department.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Department();
            }
        });
        p1.add(department);

        empInfo=new JButton("All Employee Info");
        empInfo.setBackground(new Color(246,215,118));
        empInfo.setBounds(270,15,200,30);
        empInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new EmployeeInfo();
            }
        });
        p1.add(empInfo);

        pasientInfo=new JButton("Patient Info");
        pasientInfo.setBackground(new Color(246,215,118));
        pasientInfo.setBounds(270,58,200,30);
        pasientInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PatientInfo();
            }
        });
        p1.add(pasientInfo);

        patientDischage=new JButton("Patient Discharge");
        patientDischage.setBackground(new Color(246,215,118));
        patientDischage.setBounds(270,100,200,30);
        patientDischage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new PatientDischage();
            }
        });
        p1.add(patientDischage);

        updatePatientDetails=new JButton("Update Patient Details");
        updatePatientDetails.setBackground(new Color(246,215,118));
        updatePatientDetails.setBounds(510,15,200,30);
        updatePatientDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              new UpdateDetails();
            }
        });
        p1.add(updatePatientDetails);

        AMB=new JButton("Hospital Ambulance");
        AMB.setBackground(new Color(246,215,118));
        AMB.setBounds(510,58,200,30);
        AMB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new Ambulance();
            }
        });
        p1.add(AMB);

        searchRoom=new JButton("Search Room");
        searchRoom.setBackground(new Color(246,215,118));
        searchRoom.setBounds(510,100,200,30);
        searchRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               new SearchRoom();
            }
        });
        p1.add(searchRoom);

        logout=new JButton("Logout");
        logout.setBackground(new Color(246,215,118));
        logout.setBounds(750,15,200,30);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new Login();
            }
        });
        p1.add(logout);





        p2=new JPanel();
        p2.setLayout(null);
        p2.setBounds(5,160,1525,670);
        p2.setBackground(new Color(109, 164, 170));
        frame.add(p2);
        ImageIcon imageIcon2=new ImageIcon(ClassLoader.getSystemResource("icon/splash.png"));
        Image image2=imageIcon2.getImage().getScaledInstance(1225,670,Image.SCALE_DEFAULT);
        ImageIcon imageIcon3=new ImageIcon(image2);
        JLabel label2=new JLabel(imageIcon3);
        label2.setBounds(100,160,1225,670);
        p2.add(label2);


        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Reception();
    }
}
