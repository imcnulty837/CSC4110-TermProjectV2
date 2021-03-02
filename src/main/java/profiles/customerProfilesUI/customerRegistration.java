package profiles.customerProfilesUI;

import profiles.customerProfiles.CustomerDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerRegistration {
    private JTextField customerRegistrationTextField;
    private JTextField customerID;
    private JTextField fullName;
    private JTextField StreetAddress;
    private JTextField phoneNumber;
    private JTextField balance;
    private JTextField lastOrder;
    private JTextField cityName;
    private JComboBox state;
    private JTextField lastPaid;
    private JButton register;
    private JPanel menu;
    private JButton registerButton;

    /**
    public customerRegistration() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                 * A few different errors here, you are constantly trying to reinitiate variables as different types
                 * Such as with String customerID, String state, and String phoneNumber
                 * It would be better to use different values for the boxes


                // You cannot use a class without first creating an instance of it
                String customerID = CustomerDAO.initID();

                // You cannot call the customerID variable as a JTextField because you reinitiated it to String
                String fullName = customerID.getText();

                // These are fine
                String address = StreetAddress.getText();
                String city = cityName.getText();

                // You are reinitating both state and phoneNumber to be String datatypes, you need to use different names
                String state = state.getSelectedItem().toString();
                String phoneNumber = phoneNumber.getText();

                // You are also reinitiating balance, lastPaid, and lastOrder
                double balance = Double.parseDouble(balance.getText());
                double lastPaid = Double.parseDouble(lastPaid.getText());
                String lastOrder = lastOrder.getText();

            }
        });
    }
    **/

    public static void main(String[] args) {
        JFrame frame = new JFrame("customerProfilesUI/customerRegistration.form");
        frame.setContentPane(new customerRegistration().menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}