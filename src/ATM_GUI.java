import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

    public class ATM_GUI extends JFrame {
        private static String CODE = "1234";  // Default PIN
        // Change PIN Panel
        private JPanel changePinPanel;
        private JTextField currentPinField; // Field to enter current pin
        private JTextField newPinField; // Field to enter new pin
        private JTextField confirmNewPinField; // Field to confirm new pin

        // Reset PIN Panel
        private JPanel resetPinPanel;
        private JTextField cardLast6DigitsField; // Field to verify last 6 digits of the account number
        private JTextField cardCvvField; // Field to verify card CVV
        private JTextField cardExpiryField; // Field to verify card expiry date
        private JTextField pinField; // Field to enter new pin during reset
        private JTextField amountField; // Field to enter amount during any transaction
        private JTextField phoneField; // Field to enter phone number for the related purposes (buy credit and buy data functions)
        private JPanel mainPanel; // ATM Interface Panel
        private JPanel pinPanel; // Pin panel
        private JPanel buyCreditPanel; // Buy credit panel
        private JPanel buyDataPanel; // Buy data panel
        private int balance = 1000;  // initial balance

        // Public class for the ATM_GUI method
        public ATM_GUI() {
//      String imagePath = "CompanyLogo.png";
            ImageIcon image = new ImageIcon(getClass().getResource("/CompanyLogo.png")); // Instantiating image logo for frame
            setIconImage(image.getImage()); // Setting logo for the application
            setTitle("ActivEdge ATM"); // Title of ATM Window
            setSize(400, 300); // Size of ATM
            setDefaultCloseOperation(EXIT_ON_CLOSE); // Function to close window upon clicking "X"
            setResizable(false); // Function to not allow the window to be resizable
            setLayout(new CardLayout()); // setting layout manager to be a card allowing functions in panels to be placed in anu order

            // Welcome Panel
            JPanel welcomePanel = new JPanel();
            welcomePanel.setLayout(new GridLayout(2, 1)); // setting panel to have 2 rows and 1 column to accommodate cells
            JLabel welcomeLabel = new JLabel("Welcome to ActivEdge ATM", SwingConstants.CENTER); // instantiating label for welcome message
            JButton aContinue = new JButton("Continue"); // instantiating a continue button

            welcomePanel.add(welcomeLabel); // function to add the welcome label to the panel
            welcomePanel.add(aContinue); // function to add the continue button to the panel

            // Pin Panel
            pinPanel = new JPanel();
            pinPanel.setLayout(new GridLayout(2, 2)); // calling the method pinPanel to set its layout to Grid
            JLabel pinLabel = new JLabel("Enter PIN:"); // instantiating the label for the pin to display "Enter Pin"
            pinField = new JTextField(); // creating a field for pin input
            JButton enterPinButton = new JButton("Enter"); // creating a button for submission of pin

            pinPanel.add(pinLabel); // function to add pinlabel to pinPanel
            pinPanel.add(pinField); // function to add pinField to pinPanel
            pinPanel.add(new JLabel());  // Empty label for layout
            pinPanel.add(enterPinButton); // function to add pinButton to pinPanel

            // Main Panel
            mainPanel = new JPanel(); // creating a panel for the main menu (main panel is main menu)
            mainPanel.setLayout(new GridLayout(8, 1)); // setting layout for main menu panel

            JButton withdrawButton = new JButton("Withdraw"); // creating button for Withdraw named withdraw
            JButton depositButton = new JButton("Deposit"); // creating button for Deposit named deposit
            JButton checkBalanceButton = new JButton("Check Balance"); // creating button to Check Balance named Check Balance
            JButton buyCreditButton = new JButton("Buy Credit"); // creating button for Buy Credit named Buy Credit
            JButton buyDataButton = new JButton("Buy Data"); // creating button for Buy Data named Buy Data
            JButton changePinButton = new JButton("Change PIN"); // creating button for Change Pin named Change Pin
            JButton resetPinButton = new JButton("Reset PIN"); // creating button for reset pin named reset pin

            mainPanel.add(withdrawButton); // adding withdraw button to main panel
            mainPanel.add(depositButton); // adding deposit button to main panel
            mainPanel.add(checkBalanceButton); // adding check Balance button to main panel
            mainPanel.add(buyCreditButton); // adding buy credit button to main panel
            mainPanel.add(buyDataButton); // adding buy data button to main panel
            mainPanel.add(changePinButton); // adding change pin button to main panel
            mainPanel.add(resetPinButton); // adding reset pin button to main panel

            // Buy Credit Panel
            buyCreditPanel = new JPanel();
            buyCreditPanel.setLayout(new GridLayout(4, 2)); // setting layout for buy credit panel
            JLabel phoneLabel = new JLabel("Phone Number:"); // adding label for phone number named "Phone number"
            phoneField = new JTextField(); // creating field for phone number input
            JButton confirmCreditButton = new JButton("Confirm"); // creating button for confirmation
            JButton cancelCreditButton = new JButton("Cancel"); // creating button to cancel operation

            buyCreditPanel.add(phoneLabel); // adding label for phone to buy credit panel
            buyCreditPanel.add(phoneField); // adding field for number input into buy credit panel
            buyCreditPanel.add(new JLabel());  // Empty label for layout
            buyCreditPanel.add(new JLabel());  // Empty label for layout
            buyCreditPanel.add(confirmCreditButton); // adding button for confirming transaction to buy credit panel
            buyCreditPanel.add(cancelCreditButton); // adding button for cancelling operation to buy credit panel

            // Buy Data Panel
            buyDataPanel = new JPanel();
            buyDataPanel.setLayout(new GridLayout(4, 2)); // setting layout for buy Data panel
            JLabel phoneDataLabel = new JLabel("Phone Number:"); // creating label for phone number
            JTextField phoneDataField = new JTextField(); // creating field for number input
            JButton confirmDataButton = new JButton("Confirm"); // creating button for confirmation
            JButton cancelDataButton = new JButton("Cancel"); // creating button for cancellation

            buyDataPanel.add(phoneDataLabel); // adding label for phone to buy data panel
            buyDataPanel.add(phoneDataField); // adding field for number input into buy data panel
            buyDataPanel.add(new JLabel());  // Empty label for layout
            buyDataPanel.add(new JLabel());  // Empty label for layout
            buyDataPanel.add(confirmDataButton); // adding button for confirming transaction to buy data panel
            buyDataPanel.add(cancelDataButton); // adding button for cancelling operation to buy data panel

            // Change PIN Panel
            changePinPanel = new JPanel();
            changePinPanel.setLayout(new GridLayout(4, 2)); // setting layout for change pin panel
            JLabel currentPinLabel = new JLabel("Current PIN:"); // creating label for current pin
            currentPinField = new JTextField(); // creating field for current pin input
            JLabel newPinLabel = new JLabel("New PIN:"); // creating a label for New pin
            newPinField = new JTextField(); // creating a field for new pin input
            JLabel confirmNewPinLabel = new JLabel("Confirm New PIN:"); // creating label for new pin confirmation
            confirmNewPinField = new JTextField(); // creating field for new pin confirmation
            JButton confirmChangePinButton = new JButton("Confirm"); // creating button for change pin confirmation
            JButton cancelChangePinButton = new JButton("Cancel"); // creating button for change pin cancellation

            changePinPanel.add(currentPinLabel); // adding current pin label to change pin panel
            changePinPanel.add(currentPinField); // adding current pin field to change pin panel
            changePinPanel.add(newPinLabel); // adding new pin label to change pin panel
            changePinPanel.add(newPinField); // adding new pin field to change pin panel
            changePinPanel.add(confirmNewPinLabel); // adding new pin label confirmation
            changePinPanel.add(confirmNewPinField); // adding new pin field for confirmation
            changePinPanel.add(confirmChangePinButton); // adding button for change pin confirmation
            changePinPanel.add(cancelChangePinButton); // adding button for change pin cancellation

            // Reset PIN Panel
            resetPinPanel = new JPanel();
            resetPinPanel.setLayout(new GridLayout(4, 2)); // setting layout for reset pin panel
            JLabel cardLast6DigitsLabel = new JLabel("Last 6 Digits of Card:"); // creating label for last 6 digits
            cardLast6DigitsField = new JTextField(); // creating field for last 6 digits
            JLabel cardCvvLabel = new JLabel("CVV:"); // creating label for card CVV
            cardCvvField = new JTextField(); // creating field for CVV input
            JLabel cardExpiryLabel = new JLabel("Expiry Date (MM/YY):"); // creating label for card expiry digits
            cardExpiryField = new JTextField(); // creating field for expiry date input
            JButton confirmResetPinButton = new JButton("Confirm"); // creating reset pin button for confirmation
            JButton cancelResetPinButton = new JButton("Cancel"); // creating reset pin button for cancellation

            resetPinPanel.add(cardLast6DigitsLabel); // adding last 6 digits label to reset pin panel
            resetPinPanel.add(cardLast6DigitsField); // adding last 6 digits field to reset pin panel
            resetPinPanel.add(cardCvvLabel); // adding CVV label to reset pin panel
            resetPinPanel.add(cardCvvField); // adding CVV field to reset pin panel
            resetPinPanel.add(cardExpiryLabel);
            resetPinPanel.add(cardExpiryField);
            resetPinPanel.add(confirmResetPinButton);
            resetPinPanel.add(cancelResetPinButton);

            // Add Panels to Frame
            add(welcomePanel, "Welcome");
            add(pinPanel, "Pin");
            add(mainPanel, "Main");
            add(buyCreditPanel, "BuyCredit");
            add(buyDataPanel, "BuyData");
            add(changePinPanel, "ChangePin");
            add(resetPinPanel, "ResetPin");

            // Show Welcome Panel
            CardLayout cardLayout = (CardLayout) getContentPane().getLayout(); // retrieves the layout of jframe then casts it to cardlayout
            cardLayout.show(getContentPane(), "Welcome"); // this tells the cardLayout with the identifier "Welcome" to show first covering all other panels

            // Continue Button Action
            aContinue.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "Pin"); // this command makes the content identifier pin be the content shown once clicked
                }
            });

            // Enter Pin Button Action
            enterPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String enteredPin = pinField.getText();
                    if (enteredPin.equals("1234")) { // if statement to handle pin logic
                        cardLayout.show(getContentPane(), "Main");
                    } else { // else statement to handle pin logic
                        JOptionPane.showMessageDialog(null, "Invalid PIN. Please try again."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                    }
                }
            });

            // Withdraw Button Action
            withdrawButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String amountText = JOptionPane.showInputDialog("Enter amount to withdraw:"); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        int amount = Integer.parseInt(amountText); // converts the input into integer
                        // if/else statement to handle withdraw logic
                        if (amount > 0 && amount <= balance) {
                            balance -= amount;
                            JOptionPane.showMessageDialog(null, "Withdrawal successful."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid amount or insufficient balance."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                    }
                }
            });

            // Deposit Button Action
            depositButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // try catch statement to return any errors that are not valid integers
                    try {
                        String amountText = JOptionPane.showInputDialog("Enter amount to deposit:"); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        int amount = Integer.parseInt(amountText);
                        // if/else statement to handle deposit logic
                        if (amount > 0) {
                            balance += amount;
                            JOptionPane.showMessageDialog(null, "Deposit successful."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid amount."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number."); // JoptionPane to create a dialogue box and showMessageDialogue to preview the message within string
                    }
                }
            });

            // Check Balance Button Action
            checkBalanceButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Your balance is: " + balance);
                }
            });

            // Buy Credit Button Action
            buyCreditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "BuyCredit");
                }
            });

            // Confirm Button Action in Buy Credit Panel
            confirmCreditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String phoneNumber = phoneField.getText();
                    if (phoneNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a phone number.");
                        return;
                    }

                    // Determines the telecom line associated with the phone number
                    String line = credit(phoneNumber);
                    int choice = JOptionPane.showOptionDialog(null, // shows an option dialogue box while "null" centers it
                            "This is an " + line + " number. Do you wish to proceed?",
                            "Confirm",
                            JOptionPane.YES_NO_OPTION, // displays the options that are possible
                            JOptionPane.QUESTION_MESSAGE, // displays a question mark
                            null, // null uses the default icon for the message type.
                            new Object[]{"Yes", "No"}, // labels of the options "Yes" and "No"
                            "No"); // default option selected

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
                            case 0: amount = 100; break;
                            case 1: amount = 500; break;
                            case 2: amount = 1000; break;
                            case 3:
                                String customAmountText = JOptionPane.showInputDialog("Enter custom amount:");
                                amount = Double.parseDouble(customAmountText);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid choice.");
                                return;
                        }

                        if (amount > 0 && balance >= amount) {
                            balance -= amount;
                            JOptionPane.showMessageDialog(null, "The " + line + " line has been successfully credited with " + amount + " naira worth of credit.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance or invalid amount.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Transaction cancelled.");
                    }

                    cardLayout.show(getContentPane(), "Main");
                }
            });

            // Cancel Button Action in Buy Credit Panel
            cancelCreditButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "Main");
                }
            });

            // Buy Data Button Action
            buyDataButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "BuyData");
                }
            });

            // Confirm Button Action in Buy Data Panel
            confirmDataButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String phoneNumber = phoneDataField.getText();
                    if (phoneNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter a phone number.");
                        return;
                    }

                    String line = credit(phoneNumber);
                    int choice = JOptionPane.showOptionDialog(null,
                            "This is an " + line + " number. Do you wish to proceed?",
                            "Confirm",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            new Object[]{"Yes", "No"},
                            "No");

                    if (choice == JOptionPane.YES_OPTION) {
                        String[] options = {"N100 - 200MB", "N500 - 1.0GB", "N1000 - 3.0GB", "Custom amount"};
                        int response = JOptionPane.showOptionDialog(null,
                                "Select amount to buy:",
                                "Buy Data",
                                JOptionPane.DEFAULT_OPTION,
                                JOptionPane.INFORMATION_MESSAGE,
                                null,
                                options,
                                options[0]);

                        double amount = 0;
                        switch (response) {
                            case 0: amount = 100; break;
                            case 1: amount = 500; break;
                            case 2: amount = 1000; break;
                            case 3:
                                String customAmountText = JOptionPane.showInputDialog("Enter custom amount:");
                                amount = Double.parseDouble(customAmountText);
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Invalid choice.");
                                return;
                        }

                        if (amount > 0 && balance >= amount) {
                            balance -= amount;
                            JOptionPane.showMessageDialog(null, "The " + line + " line has been successfully credited with " + amount + " worth of data.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Insufficient balance or invalid amount.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Transaction cancelled.");
                    }

                    cardLayout.show(getContentPane(), "Main");
                }
            });

            // Cancel Button Action in Buy Data Panel
            cancelDataButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "Main");
                }
            });
            // Change PIN Button Action
            changePinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "ChangePin");
                }
            });

// Reset PIN Button Action
            resetPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "ResetPin");
                }
            });
            // Confirm Button Action in Change PIN Panel
            confirmChangePinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String currentPin = currentPinField.getText();
                        String newPin = newPinField.getText();
                        String confirmNewPin = confirmNewPinField.getText();

                        if (!currentPin.equals("1234")) {
                            JOptionPane.showMessageDialog(null, "Current PIN is incorrect.");
                            return;
                        }

                        if (!newPin.equals(confirmNewPin)) {
                            JOptionPane.showMessageDialog(null, "New PIN and Confirm PIN do not match.");
                            return;
                        }

                        if (newPin.length() != 4) {
                            JOptionPane.showMessageDialog(null, "PIN must be 4 digits.");
                            return;
                        }

                        // Update PIN (assuming CODE is the current PIN)
                        CODE = String.valueOf(Short.parseShort(newPin));
                        JOptionPane.showMessageDialog(null, "PIN successfully changed.");

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid PIN format. Please enter a numeric value.");
                    }

                    cardLayout.show(getContentPane(), "Main");
                }
            });

// Cancel Button Action in Change PIN Panel
            cancelChangePinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "Main");
                }
            });

// Confirm Button Action in Reset PIN Panel
            confirmResetPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        String cardLast6Digits = cardLast6DigitsField.getText();
                        String cardCvv = cardCvvField.getText();
                        String cardExpiry = cardExpiryField.getText();

                        // Dummy data for validation
                        String last6Digits = "123456"; // Replace with your logic to retrieve the last 6 digits
                        String cvv = "123"; // Replace with your logic to retrieve CVV
                        String expiry = "12/24"; // Replace with your logic to retrieve expiry date

                        if (cardLast6Digits.equals(last6Digits) && cardCvv.equals(cvv) && cardExpiry.equals(expiry)) {
                            String newPin = JOptionPane.showInputDialog("Enter new PIN:");
                            String confirmPin = JOptionPane.showInputDialog("Confirm new PIN:");

                            if (newPin.equals(confirmPin) && newPin.length() == 4) {
                                CODE = String.valueOf(Short.parseShort(newPin));
                                JOptionPane.showMessageDialog(null, "PIN successfully reset.");
                            } else {
                                JOptionPane.showMessageDialog(null, "New PIN must match Confirm PIN and be 4 digits.");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Card details do not match.");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null, "Invalid PIN format. Please enter numeric value only.");
                    }

                    cardLayout.show(getContentPane(), "Main");
                }
            });

// Cancel Button Action in Reset PIN Panel
            cancelResetPinButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    cardLayout.show(getContentPane(), "Main");
                }
            });
        }


        private Map<String, String> CreditLine() {
            Map<String, String> credit = new HashMap<>();
            credit.put("0703", "MTN");
            credit.put("0706", "MTN");
            credit.put("0803", "MTN");
            credit.put("0806", "MTN");
            credit.put("0810", "MTN");
            credit.put("0813", "MTN");
            credit.put("0814", "MTN");
            credit.put("0816", "MTN");
            credit.put("0903", "MTN");
            credit.put("0906", "MTN");
            credit.put("0913", "MTN");
            credit.put("0916", "MTN");
            credit.put("0705", "Glo");
            credit.put("0805", "Glo");
            credit.put("0807", "Glo");
            credit.put("0811", "Glo");
            credit.put("0815", "Glo");
            credit.put("0905", "Glo");
            credit.put("0915", "Glo");
            credit.put("0701", "Airtel");
            credit.put("0708", "Airtel");
            credit.put("0802", "Airtel");
            credit.put("0808", "Airtel");
            credit.put("0812", "Airtel");
            credit.put("0907", "Airtel");
            credit.put("0912", "Airtel");
            credit.put("0809", "Etisalat");
            credit.put("0817", "Etisalat");
            credit.put("0818", "Etisalat");
            credit.put("0909", "Etisalat");
            credit.put("0908", "Etisalat");
            return credit;
        }

        public static String credit(String number) {
            if (number.length() != 11) {
                return "Number must be equal to 11 digits";
            }
            String digits = number.substring(0, 4);
            Map<String, String> credit = new ATM_GUI().CreditLine();
            String line = credit.get(digits);
            return (line != null) ? line : "Unable to retrieve line";
        }
}
