import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {
    public WelcomePanel(ActivEdge_ATM_GUI parent) {
        add(new JLabel("Welcome to ActivEdge ATM"));
        JButton aContinue = new JButton("Continue");
        add(aContinue);

        aContinue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                parent.switchPanel("Pin");
            }
        });
    }
}
