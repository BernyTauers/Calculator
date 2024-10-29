package main;
import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;

public class Main implements ActionListener{
    JFrame jFrame;
    JPanel jPanel;
    JTextField textField;

    Main(){

        jPanel = new JPanel();
        jPanel.setBounds(70, 120, 300, 300);
        jPanel.setBackground(Color.BLUE);

        jFrame =new JFrame("Calculator");
        jFrame.setSize(450, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        jFrame.add(jPanel);
        jFrame.setVisible(true);

        

        
    }
    public static void main(String[] args){
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
