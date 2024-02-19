package JaymeAlgorithms;

import javax.swing.*;

public class variableReferences {

    // Constants for the ratio
    protected static final double RATIO_CARBON_TO_NITROGEN = 30.0;
    // Label to display the result
    private static JLabel resultLabel;

    public static void createDropDownBoxAndResultDisplay() {
        JFrame frame = new JFrame("Select Bag Size");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        String[] options = {"25kg", "10kg", "5kg"};
        JComboBox<String> comboBox = new JComboBox<>(options);

        // Initialize the label with default text
        resultLabel = new JLabel("Select a bag size to see the result.");
        panel.add(resultLabel);

        comboBox.addActionListener(e -> {
            String selectedItem = (String) comboBox.getSelectedItem();
            mathOperations(selectedItem);
        });
        panel.add(comboBox);
        frame.add(panel);
        frame.setVisible(true);
    }

    public static void mathOperations(String selectedBagSize) {
        double bagSize = Double.parseDouble(selectedBagSize.replace("kg", ""));
        calculateFinalViableAmount(bagSize);
    }

    private static void calculateFinalViableAmount(double bagSize) {
        // Calculate the total mass of nitrogen needed based on the bag size and ratio
        double nitrogenMass = bagSize / (1 + RATIO_CARBON_TO_NITROGEN);
        // Calculate the carbon mass based on the nitrogen mass and the ratio
        double carbonMass = nitrogenMass * RATIO_CARBON_TO_NITROGEN;

        // Update the label with the calculated amounts
        resultLabel.setText(String.format("<html>For a %skg bag:<br>Carbon required: %.2f kg<br>Nitrogen required: %.2f kg</html>", bagSize, carbonMass, nitrogenMass));
    }

    // test main method
    public static void main(String[] args) {
        createDropDownBoxAndResultDisplay();
    }
}
