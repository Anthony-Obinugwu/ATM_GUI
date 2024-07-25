import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ResetPinPanel extends JPanel {
    private JTextField cardLast6DigitsField, cardCvvField, cardExpiryField;

    public ResetPinPanel(ActivEdge_ATM_GUI parent) {
        setLayout(new GridLayout(4, 2));
        JLabel cardLast6DigitsLabel = new JLabel("Last 6 Digits of Card:");
        cardLast6DigitsField = new JTextField();
        JLabel cardCvvLabel = new JLabel("CVV:");
        cardCvvField = new JTextField();
        JLabel cardExpiryLabel = new JLabel("Expiry Date (MM/YY):");
        cardExpiryField = new JTextField();
        JButton confirmResetPinButton = new JButton("Confirm");
        JButton cancelResetPinButton = new JButton("Cancel");
        add(cardLast6DigitsLabel);
        add(cardLast6DigitsField);
        add(cardCvvLabel);
        add(cardCvvField);
        add(cardExpiryLabel);
        add(cardExpiryField);
        add(confirmResetPinButton);
        add(cancelResetPinButton);

        confirmResetPinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle PIN reset logic
            }
        });

        cancelResetPinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.switchPanel("Main");
            }
        });
    }
}
