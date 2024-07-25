import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PinPanel extends JPanel {
        private JTextField pinField;

        public PinPanel(ActivEdge_ATM_GUI parent) {
            setLayout(new GridLayout(3, 2));
            JLabel pinLabel = new JLabel("Enter PIN:");
            pinField = new JTextField();
            JButton enterPinButton = new JButton("Enter");
            add(pinLabel);
            add(pinField);
            add(new JLabel());  // Empty label for layout
            add(new JLabel());  // Empty label for layout
            add(enterPinButton);

            enterPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String enteredPin = pinField.getText();
                    if (enteredPin.equals(ActivEdge_ATM_GUI.getCode())) {
                        parent.switchPanel("Main");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid PIN. Please try again.");
                    }
                }
            });
        }
    }

