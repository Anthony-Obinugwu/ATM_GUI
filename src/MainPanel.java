import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class MainPanel extends JPanel {
        public MainPanel(ActivEdge_ATM_GUI parent) {
            setLayout(new GridLayout(4, 2));
            JButton withdrawButton = new JButton("Withdraw");
            JButton depositButton = new JButton("Deposit");
            JButton checkBalanceButton = new JButton("Check Balance");
            JButton buyCreditButton = new JButton("Buy Credit");
            JButton buyDataButton = new JButton("Buy Data");
            JButton changePinButton = new JButton("Change PIN");
            JButton resetPinButton = new JButton("Reset PIN");

            add(withdrawButton);
            add(depositButton);
            add(checkBalanceButton);
            add(buyCreditButton);
            add(buyDataButton);
            add(changePinButton);
            add(resetPinButton);

            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String amountText = JOptionPane.showInputDialog("Enter amount to withdraw:");
                        int amount = Integer.parseInt(amountText);
                        if (amount > 0 && amount <= ActivEdge_ATM_GUI.getBalance()) {
                            ActivEdge_ATM_GUI.setBalance(ActivEdge_ATM_GUI.getBalance() - amount);
                            JOptionPane.showMessageDialog(null, "Withdrawal successful.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid amount or insufficient balance.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    }
                }
            });

            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String amountText = JOptionPane.showInputDialog("Enter amount to deposit:");
                        int amount = Integer.parseInt(amountText);
                        if (amount > 0) {
                            ActivEdge_ATM_GUI.setBalance(ActivEdge_ATM_GUI.getBalance() + amount);
                            JOptionPane.showMessageDialog(null, "Deposit successful.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid amount.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                    }
                }
            });

            checkBalanceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Your balance is: " + ActivEdge_ATM_GUI.getBalance());
                }
            });

            buyCreditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.switchPanel("BuyCredit");
                }
            });

            buyDataButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.switchPanel("BuyData");
                }
            });

            changePinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.switchPanel("ChangePin");
                }
            });

            resetPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    parent.switchPanel("ResetPin");
                }
            });
        }
    }


