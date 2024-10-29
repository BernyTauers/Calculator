package main;
import javax.swing.*;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class Main implements ActionListener{
    JFrame jFrame;
    JPanel jPanel;
    JTextField textField;
    JButton delButton, clcButton;
    JTextField jTextField;
    Font font;
    JButton[] numButtons = new JButton[10];
    JButton[] opButtons = new JButton[8];
    JButton add,sub,div,mod,mult,dot,equal,plusMinus;
    String num1 = "", num2 = "";
    Integer result;
    Boolean opIsPressed = false, plusMinPressed = false;
    String opChar;
    
    
    
    

    Main(){
    	//font = new Font("Arial", 0, 30);
    	
    	jTextField = new JTextField();
    	jTextField.setBounds(70, 20, 320, 80);
    	jTextField.setEditable(false);
    	
    	delButton = new JButton("Delete");
    	delButton.setBounds(70, 450, 320, 50);
    	
    	clcButton = new JButton("Clear");
    	clcButton.setBounds(70, 500,320 , 50);
    	
        
        //Buttons
        add = new JButton("+");
        sub = new JButton("-");
        div = new JButton("/");
        mod = new JButton("%");
        mult = new JButton("*");
        dot = new JButton(".");
        equal = new JButton("=");
        plusMinus = new JButton("+/-");
                
        opButtons[0] = add;
        opButtons[1] = sub;
        opButtons[2] = div;
        opButtons[3] = mod;
        opButtons[4] = mult;
        opButtons[5] = dot;
        opButtons[6] = equal;
        opButtons[7] = plusMinus;
        
        for (int i =0; i<8;i++) {
        	opButtons[i].addActionListener(this);
        	opButtons[i].setFocusable(false);
        	
        }
        
        delButton.addActionListener(this);
    	delButton.setFocusable(false);
    	
    	clcButton.addActionListener(this);
    	clcButton.setFocusable(false);
    	
        for(int i = 0; i<10; i++) {
        	numButtons[i] = new JButton(Integer.valueOf(i).toString());
        	numButtons[i].addActionListener(this);
        	numButtons[i].setFocusable(false);
        }
        
        jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(4,4,10,10));
        jPanel.setBounds(70, 120, 320, 320);
        //jPanel.setBackground(Color.BLUE);
        jPanel.add(numButtons[7]);
        jPanel.add(numButtons[8]);
        jPanel.add(numButtons[9]);
        jPanel.add(opButtons[4]);
        
        jPanel.add(numButtons[4]);
        jPanel.add(numButtons[5]);
        jPanel.add(numButtons[6]);
        jPanel.add(opButtons[0]);
        
        jPanel.add(numButtons[1]);
        jPanel.add(numButtons[2]);
        jPanel.add(numButtons[3]);
        jPanel.add(opButtons[1]);
        
        jPanel.add(opButtons[7]);
        jPanel.add(numButtons[0]);
        jPanel.add(opButtons[2]);
        jPanel.add(opButtons[6]);
        
        jFrame =new JFrame("Calculator");
        jFrame.setSize(450, 600);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
        jFrame.setResizable(false);
        
        
        jFrame.add(clcButton);
        jFrame.add(delButton);
        jFrame.add(jPanel);
        jFrame.add(jTextField);
        jFrame.setVisible(true);
        
        

        
    }
    public static void main(String[] args){
        new Main();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    	if ("1234567890".contains(e.getActionCommand()) && opIsPressed == false ) {
    		num1 += e.getActionCommand();
    		jTextField.setText(num1);
    		
    	}
    	if ("+ - / * ".contains(e.getActionCommand())) {
    		opChar = e.getActionCommand();
    		jTextField.setText("");
    		opIsPressed = true;
    	}
    	if("1234567890".contains(e.getActionCommand()) && opIsPressed == true) {
			num2 += e.getActionCommand();
			jTextField.setText(num2);
			
    	}
    			
		if(e.getActionCommand() == "=" && opChar.isEmpty() != true && opChar == "+" && num2.isEmpty() != true) {
			result = Integer.valueOf(num1) + Integer.valueOf(num2);
			jTextField.setText(result.toString());
		}
		
		if(e.getActionCommand() == "=" && opChar.isEmpty() != true && opChar == "-" && num2.isEmpty() != true) {
			result = (Integer.valueOf(num1) - Integer.valueOf(num2));
			jTextField.setText(result.toString());
		}
		if(e.getActionCommand() == "=" && opChar.isEmpty() != true && opChar == "/" && num2.isEmpty() != true) {
			result = (Integer.valueOf(num1) / Integer.valueOf(num2));
			System.out.println(result);
			
			jTextField.setText(result.toString());
		}
		if(e.getActionCommand() == "=" && opChar.isEmpty() != true && opChar == "*" && num2.isEmpty() != true) {
			result = ( Integer.valueOf(num1) * Integer.valueOf(num2));
			jTextField.setText(result.toString());
		}
		if(e.getActionCommand() == "+/-") {
			plusMinPressed = true;
			if (num2.isEmpty()) {
				result = Integer.valueOf(num1) * -1 ;
				num1 = result.toString();
				jTextField.setText(num1);
	
			}else {
				result = Integer.valueOf(num1) * -1 ;
				num2 = result.toString(); 
				jTextField.setText(num2);
			}
		}
		if(e.getActionCommand() == "Delete") {
			
		}
		if(e.getActionCommand() == "Clear") {
			opIsPressed = false;
			System.out.print("oooo");
			jTextField.setText("0");
			num1 = "";
			num2 = "";
		}
		
    }
}
