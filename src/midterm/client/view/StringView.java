package midterm.client.view;

import java.awt.event.ActionListener;
import javax.swing.*;

public class StringView extends JFrame {
    private JTextField firstString = new JTextField(10);
    private JLabel addLabel = new JLabel("+");

    private JTextField secondString = new JTextField(10);
    private JButton concatButton = new JButton("concatenate");

    private ButtonGroup radioGroup = new ButtonGroup();
    private JRadioButton radioAsIs = new JRadioButton("As is", true);
    private JRadioButton radioToUpper = new JRadioButton("toUpper", false);
    private JRadioButton radioToLower = new JRadioButton("toLower", false);

    private JTextField result = new JTextField(10);

    public StringView() {
        JPanel calcPanel = new JPanel();
        radioGroup.add(radioAsIs);
        radioGroup.add(radioToUpper);
        radioGroup.add(radioToLower);

        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calcPanel.add(firstString);
        calcPanel.add(addLabel);
        calcPanel.add(secondString);

        calcPanel.add(radioAsIs);
        calcPanel.add(radioToUpper);
        calcPanel.add(radioToLower);

        calcPanel.add(concatButton);
        calcPanel.add(result);

        this.add(calcPanel);
    }

    public String getFirstString() {
        return firstString.getText();
    }

    public String getSecString() {
        return secondString.getText();
    }

    public String getStringCase() {
        if (radioAsIs.isSelected()) {
            return "";
        } else if (radioToUpper.isSelected()) {
            return "upper";
        } else {
            return "lower";
        }
    }

    public void setResult(String res) {
        result.setText(res);
    }

    public void addStringListener(ActionListener listenForConcatButton) {
        concatButton.addActionListener(listenForConcatButton);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
