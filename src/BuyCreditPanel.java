import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyCreditPanel extends JPanel {
    private JTextField phoneField;

    public BuyCreditPanel(ActivEdge_ATM_GUI parent) {
        setLayout(new GridLayout(4, 2));
        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();
        JButton confirmCreditButton = new JButton("Confirm");
        JButton cancelCreditButton = new JButton("Cancel");
        add(phoneLabel);
        add(phoneField);
        add(new JLabel());  // Empty label for layout
        add(new JLabel());  // Empty label for layout
        add(confirmCreditButton);
        add(cancelCreditButton);

        confirmCreditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String phoneNumber = phoneField.getText();
                if (phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a phone number.");
                    return;
                }

                String line = ActivEdge_ATM_GUI.credit(phoneNumber);
                int choice = JOptionPane.showOptionDialog(null,
                        "This is an " + line + " number. Do you wish to proceed?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        new Object[]{"Yes", "No"},
                        "No");

                if (choice == JOptionPane.YES_OPTION) {
                    String[] options = {"N100", "N500", "N1000", "Custom amount"};
                    int response = JOptionPane.showOptionDialog(null,
                            "Select amount to buy:",
                            "Buy Credit",
                            JOptionPane.DEFAULT_OPTION,
                            JOptionPane.INFORMATION_MESSAGE,
                            null,
                            options,
                            options[0]);

                    double amount = 0;
                    switch (response) {
                        // Handle options
                    }
                }
            }
        });

        cancelCreditButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.switchPanel("Main");
            }
        });
    }
}


