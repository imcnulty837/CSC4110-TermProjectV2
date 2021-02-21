package vendorRegistrationUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 */
public class vendorRegistration {
    private JTextField phoneNumber;
    private JTextField cityName;
    private JTextField streetAddress;
    private JTextField companyName;
    private JTextField bal;
    private JTextField lastPaid;
    private JTextField lastOrder;
    private JTextField seasonalDiscount;
    private JComboBox stateBox;
    private JPanel menu;
    private JButton registerButton;

    public vendorRegistration() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("vendorRegistration");
        frame.setContentPane(new vendorRegistration().menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
