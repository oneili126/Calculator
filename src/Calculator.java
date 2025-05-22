import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener
{
    JFrame frame; //creates a window
    JTextField textField; //will hold my result
    JButton[] numberButtons = new JButton[10]; //an array of the numbers 0-9
    JButton[] functionButtons = new JButton[9]; //an array of the operators
    JButton addButton, subButton, mulButton, divButton; //functions to be implemented...
    JButton decButton, equButton, delButton, clrButton, negButton; //functions continued
    JPanel panel; //panel to organize the gui

    Font myFont = new Font("Montserrat",Font.PLAIN,30); //font I want to use throughout the app

    Color lightestPurple = new Color(229, 200, 230);
    Color dustyPurple = new Color(178, 136, 192);
    Color regPurple = new Color(126, 90, 155);
    Color deepPurple = new Color(99, 69, 138);

    double num1 = 0,num2 = 0, result = 0; //variables that will be used for calculations
    char operator; //function asked to be used

    Calculator(){

        //initial set up of the calculator window
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.getContentPane().setBackground(dustyPurple);
        frame.setLayout(null);

        //initiating text field
        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);
        textField.setBackground(lightestPurple);

        //initializing buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clear");
        negButton = new JButton("Neg");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < 9; i++){
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

        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);

        //creating panel to hold buttons in a grid layout
        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(deepPurple);

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
        frame.add(negButton);
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

        //clears the text field when clear button is pressed
        if(e.getSource()==clrButton) {
            textField.setText("");
        }

        //removes the last character from the text field
        if(e.getSource()==delButton) {
            String string = textField.getText();
            textField.setText("");
            for (int i = 0; i < string.length()-1;i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

        //makes a value negative
        if(e.getSource()==negButton) {
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }




    }
}