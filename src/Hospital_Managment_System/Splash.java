package Hospital_Managment_System;

import javax.swing.*;
import java.awt.*;

public class Splash {
    JFrame frame;
    Splash(){
        frame=new JFrame("Hospital Management System");
        frame.setLayout(null);
        frame.setUndecorated(true);
        frame.setLocation(250,75);
        frame.setSize(900,700);
        ImageIcon imageIcon=new ImageIcon(ClassLoader.getSystemResource("icon/Hospital.gif"));
        Image image=imageIcon.getImage().getScaledInstance(900,700,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1=new ImageIcon(image);
        JLabel label=new JLabel(imageIcon1);
        label.setBounds(0,0,900,700);
        frame.add(label);
        frame.setVisible(true);
        try {
            Thread.sleep(8000);
            frame.setVisible(false);
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String []args){
        new Splash();
    }
}
