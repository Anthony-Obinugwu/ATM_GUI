import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyDataPanel extends JPanel {
    private JTextField phoneDataField;

    public BuyDataPanel(ActivEdge_ATM_GUI parent) {
        setLayout(new GridLayout(4, 2));
        JLabel phoneDataLabel = new JLabel("Phone Number:");
        phoneDataField = new JTextField();
        JButton confirmDataButton = new JButton("Confirm");
        JButton cancelDataButton = new JButton("Cancel");
        add(phoneDataLabel);
        add(phoneDataField);
        add(new JLabel());  // Empty label for layout
        add(new JLabel());  // Empty label for layout
        add(confirmDataButton);
        add(cancelDataButton);

        confirmDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle confirmation logic
            }
        });

        cancelDataButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.switchPanel("Main");
            }
        });
    }
}

