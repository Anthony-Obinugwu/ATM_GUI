import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;

public class ActivEdge_ATM_GUI extends JFrame {
    private CardLayout cardLayout;
    private static double balance = 1000; // Initial balance for demo purposes
    private static String CODE = "1234"; // Initial PIN for demo purposes

    public ActivEdge_ATM_GUI() {
        setTitle("ActivEdge ATM");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Initialize panels
        WelcomePanel welcomePanel = new WelcomePanel(this);
        PinPanel pinPanel = new PinPanel(this);
        MainPanel mainPanel = new MainPanel(this);
        BuyCreditPanel buyCreditPanel = new BuyCreditPanel(this);
        BuyDataPanel buyDataPanel = new BuyDataPanel(this);
        ChangePinPanel changePinPanel = new ChangePinPanel(this);
        ResetPinPanel resetPinPanel = new ResetPinPanel(this);

        // Add panels to CardLayout
        add(welcomePanel, "Welcome");
        add(pinPanel, "Pin");
        add(mainPanel, "Main");
        add(buyCreditPanel, "BuyCredit");
        add(buyDataPanel, "BuyData");
        add(changePinPanel, "ChangePin");
        add(resetPinPanel, "ResetPin");

        // Show the welcome panel
        cardLayout.show(getContentPane(), "Welcome");
    }

    public void switchPanel(String panelName) {
        cardLayout.show(getContentPane(), panelName);
    }

    public static double getBalance() {
        return balance;
    }

    public static void setBalance(double newBalance) {
        balance = newBalance;
    }

    public static String getCode() {
        return CODE;
    }

    public static void setCode(String newCode) {
        CODE = newCode;
    }

    public static String credit(String number) {
        if (number.length() != 11) {
            return "Number must be equal to 11 digits";
        }
        String digits = number.substring(0, 4);
        Map<String, String> credit = CreditLine();
        String line = credit.get(digits);
        return (line != null) ? line : "Unable to retrieve line";
    }

    private static Map<String, String> CreditLine() {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ActivEdge_ATM_GUI().setVisible(true);
            }
        });
    }

}

