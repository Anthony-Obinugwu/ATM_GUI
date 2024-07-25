import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChangePinPanel extends JPanel {
    private JTextField currentPinField, newPinField, confirmNewPinField;

    public ChangePinPanel(ActivEdge_ATM_GUI parent) {
        setLayout(new GridLayout(4, 2));
        JLabel currentPinLabel = new JLabel("Current PIN:");
        currentPinField = new JTextField();
        JLabel newPinLabel = new JLabel("New PIN:");
        newPinField = new JTextField();
        JLabel confirmNewPinLabel = new JLabel("Confirm New PIN:");
        confirmNewPinField = new JTextField();
        JButton confirmChangePinButton = new JButton("Confirm");
        JButton cancelChangePinButton = new JButton("Cancel");
        add(currentPinLabel);
        add(currentPinField);
        add(newPinLabel);
        add(newPinField);
        add(confirmNewPinLabel);
        add(confirmNewPinField);
        add(confirmChangePinButton);
        add(cancelChangePinButton);

        confirmChangePinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle PIN change logic
            }
        });

        cancelChangePinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.switchPanel("Main");
            }
        });
    }
}
