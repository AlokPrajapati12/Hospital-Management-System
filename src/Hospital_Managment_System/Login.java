package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login {
    JFrame frame;
    JLabel user,pass;
    JTextField userText;
    JPasswordField passText;
    JButton login,cancel;
    Login(){
        frame=new JFrame();
        frame.setSize(650,300);
        frame.setLocation(400,200);
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(new Color(228, 21, 210));

        user=new JLabel("Username");
        user.setBounds(40,20,100,30);
        user.setFont(new Font("Tahoma",Font.BOLD,16));
        frame.add(user);
        userText=new JTextField();
        userText.setBounds(150,20,150,30);
        userText.setFont(new Font("Tahoma",Font.PLAIN,15));
        userText.setBackground(new Color(225,179,0));
        frame.add(userText);

        pass=new JLabel("Password");
        pass.setFont(new Font("Tahoma",Font.BOLD,16));
        pass.setBounds(40,70,100,30);
        frame.add(pass);
        passText=new JPasswordField();
        passText.setBounds(150,70,150,30);
        passText.setFont(new Font("Tahoma",Font.PLAIN,15));
        passText.setBackground(new Color(225,179,0));
        frame.add(passText);

        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        login.setFont(new Font("serif",Font.BOLD,15));
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              try {
                  Config c=new Config();
                  String user=userText.getText();
                  String pass=passText.getText();
                String  q="select * from login where username ='"+user+"' and password ='"+pass+"'";
                  ResultSet resultSet=c.statement.executeQuery(q);
                  if(resultSet.next()){
                      frame.setVisible(false);
                      new Reception();
                  }else{
                      JOptionPane.showMessageDialog(null,"Invalid Username and Password");
                  }

              } catch (Exception ex) {
                  ex.printStackTrace();
              }
            }
        });
        frame.add(login);

        cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        cancel.setFont(new Font("serif",Font.BOLD,15));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(104);
            }
        });
        frame.add(cancel);

        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/home.jpg"));
        Image image=imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label =new JLabel(imageIcon1);
        label.setBounds(300,-30,400,300);
        frame.add(label);

        frame.setVisible(true);
    }
    public static void main(String[] args){
        new Login();
    }
}
