import java.awt.event.ActionListener;
import javax.swing.*;

public class StringView extends JFrame {
    private JTextField firstString = new JTextField(10);
    private JLabel addLabel = new JLabel("+");

    private JTextField secondString = new JTextField(10);
    private JButton concatButton = new JButton("concatenate");

    private JTextField result = new JTextField(10);

    public StringView() {
        JPanel calcPanel = new JPanel();
        this.setSize(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        calcPanel.add(firstString);
        calcPanel.add(addLabel);
        calcPanel.add(secondString);
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

    public void setResult(String res) {
        result.setText(res);
    }

    void addStringListener(ActionListener listenForConcatButton) {
        concatButton.addActionListener(listenForConcatButton);
    }

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
}
