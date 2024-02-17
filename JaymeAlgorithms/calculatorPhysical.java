package JaymeAlgorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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

    public calculatorPhysical() {
        createFrame();
        initializeComponents();
        displayFrame();
        frame.setContentPane(new BackgroundPanel("kodkod.jpeg"));
        displayFrame();
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private void createFrame() {
        frame = new JFrame(NAME);
        frame.setLocation(X_LOC, Y_LOC);
        frame.setSize(HEIGHT, WIDTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initializeComponents() {
        initializeInputs();
        initializeResults();
        initializeButtons();
    }

    private void displayFrame() {
        // frame.pack();
        frame.setVisible(true);
    }

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

    private void initializeResults() {
        JPanel userRes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        resultLabel = new JLabel(RESULT_PREAMBLE);

        resultLabel.setName("resultLabel");
        userRes.add(resultLabel);
        frame.add(userRes, BorderLayout.CENTER);
    }

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

    private void updateResult(double result) {
        if (Double.isNaN(result)) {
            resultLabel.setText(RESULT_PREAMBLE);
        } else {
            resultLabel.setText(RESULT_PREAMBLE + result);
        }
    }

    public void makeFrameNotUgly(Graphics g) {
        super.makeFrameNotUgly(g);
        g.drawImage(backgroundImage, X_LOC, Y_LOC, dodaMath);
        frame.setContentPane(frame);
    }

    
}
