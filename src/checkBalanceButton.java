import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checkBalanceButton extends ATM_GUI {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Your balance is: " + balance);
        }
    }
