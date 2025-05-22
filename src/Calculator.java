import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener
{
    JFrame frame; //creates a window
    JTextField textField; //will hold my result
    JButton[] numberButtons = new JButton[10]; //an array of the numbers 0-9
    JButton[] functionButtons = new JButton[8]; //an array of the operators
    JButton addButton, subButton, mulButton, divButton; //functions to be implemented...
    JButton decButton, equButton, delButton, clrButton; //functions continued
    JPanel panel; //panel to organize the gui

    Font myFont = new Font("Comic Sans",Font.BOLD,30); //font I want to use throughout the app

    double num1 = 0,num2 = 0, result = 0; //variables that will be used for calculations
    char operator; //function asked to be used

    Calculator(){

        //initial set up of the calculator window
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        //initiating text field
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);

        //initializing buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for (int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false); // outline
        }

        for (int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i)); //initializes the buttons
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false); // outline
        }

        delButton.setBounds(50,430,145,50);
        clrButton.setBounds(205,430,145,50);

        //creating panel to hold buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.PINK);

        //add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);           //end of row 1
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);           //end of row 2
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);           //end of row 3
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);           //emd of row 4







        frame.add(textField);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(panel);
        frame.setVisible(true);

    }
    public static void main(String[] args) {

        Calculator calc = new Calculator(); //creates a calculator

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //when the number buttons are pushed, the number is reflected in the text field
        for(int i = 0; i < 10; i++){
            if (e.getSource() == numberButtons[i]) {
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        //when the decimal button is pushed, the text field has a .
        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        //functionality for addition Button
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        //functionality for subtraction button
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        //functionality for multiplication button
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        //functionality for division button
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        //functionality for equals button and calculates the result
        if(e.getSource()==equButton){
            num2 = Double.parseDouble(textField.getText());

            switch (operator){
                case'+':
                    result = num1 + num2;
                    break;
                case'-':
                    result = num1 - num2;
                    break;
                case'*':
                    result = num1 * num2;
                    break;
                case'/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result; //allows for continued operations

        }


    }
}