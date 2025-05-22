import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener
{
    JFrame frame; //creates a window
    JTextField textField; //will hold my result
    JButton[] numberButtons = new JButton[10]; //an array of the numbers 0-9
    JButton[] functionButtons = new JButton[8]; //an array of the operators
    JButton addButton, subButton, multButton, divideButton; //functions to be implemented...
    JButton decButton, equButton, delButton, clrButton; //functions continued
    JPanel panel; //panel to organize the gui

    Font myFont = new Font("Comic Sans",Font.BOLD,30); //font I want to use throughout the app

    double num1 = 0,num2 = 0, result = 0; //variables that will be used for calculations
    char operator; //function asked to be used

    Calculator(){

        //initial set up of the window
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);





        frame.setVisible(true);

    }
    public static void main(String[] args) {

        Calculator calc = new Calculator(); //creates a calculator

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}