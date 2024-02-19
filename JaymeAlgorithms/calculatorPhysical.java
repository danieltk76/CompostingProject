package JaymeAlgorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// needs to have variableReferences completely integrated
public class calculatorPhysical extends variableReferences {
    private static final int X_LOC = 100;
    private static final int Y_LOC = 100;
    private static final int HEIGHT = 600;
    private static final int WIDTH = 600;
    private static final String NAME = "Calculator ";
    private static final String RESULT_PREAMBLE = "Amount of possible bags: ";
    private static final String ERROR_MESSAGE = "Error ";
    private JFrame frame;
    private JTextField leftOpField;
    private JTextField rightOpField;
    private JLabel resultLabel;
    private JTextField dodaMath;
    private Image backgroundImage = new ImageIcon("kodkod.jpeg").getImage();

    // standard no arg
    public calculatorPhysical() {
        createFrame();
        initializeComponents();
        displayFrame();
    }

    // returns and prevents shadowing of the variable frame
    public JFrame getFrame() {
        return this.frame;
    }

    // physically creates the frame
    private void createFrame() {
        frame = new JFrame(NAME);
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(HEIGHT, WIDTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // initializes the lesser methods in one place
    private void initializeComponents() {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }


    // display method to initialize the visibility to true
    private void displayFrame() {
        // frame.pack();
        frame.setVisible(true);
    }

    // inputs initialization for panel
    private void initializeInputs() {
        JPanel userIn = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        leftOpField = new JTextField(10);
        leftOpField.setName("leftOperand");
        rightOpField = new JTextField(10);
        rightOpField.setName("rightOperand");

        userIn.add(leftOpField);
        userIn.add(rightOpField);

        frame.add(userIn, BorderLayout.NORTH);
    }

    // initialize results method creates instances of the results and adds a layout to the panel
    private void initializeResults() {
        JPanel userRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel(RESULT_PREAMBLE);

        resultLabel.setName("resultLabel");
        userRes.add(resultLabel);
        frame.add(userRes, BorderLayout.CENTER);
    }

    // initializes an instance of the buttons, adds a layout, has action listeners for buttons to be actives
    private void initializeButtons() {
        JPanel userButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton dodaMath = new JButton("DODAMATH");
        dodaMath.setName("The button that does the math");

        dodaMath.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double leftOperand = Double.parseDouble(leftOpField.getText());
                    double rightOperand = Double.parseDouble(rightOpField.getText());

                    double result = leftOperand * rightOperand;
                    updateResult(result);
                } catch (NumberFormatException | NullPointerException j) {
                    updateResult(Double.NaN);
                }
            }
        });

        userButton.add(dodaMath);
        frame.add(userButton, BorderLayout.SOUTH);
    }


    // some editing to do here. getLeftNum() is designed for if the left field has a number inputed
    private double getLeftNum() {
        try {
            String text = leftOpField.getText();
 
            if (text == null || text.isEmpty()) {
                return Double.NaN;
            }
            return Double.parseDouble(text);
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }

    // some editing to do here. getRightNum() is designed for if the right field has a number inputed
    private double getRightNum() {
        try {
            String text = rightOpField.getText();

            if (text == null || text.isEmpty()) {
                return Double.NaN;
            }
            return Double.parseDouble(text);
        } catch (NumberFormatException | NullPointerException e) {
            return Double.NaN;
        }
    }


    // updates and prints the result
    private void updateResult(double result) {
        if (Double.isNaN(result)) {
            resultLabel.setText(RESULT_PREAMBLE);
        } else {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }

    
    
}
