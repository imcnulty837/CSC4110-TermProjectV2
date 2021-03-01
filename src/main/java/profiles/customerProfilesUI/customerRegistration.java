package profiles.customerProfilesUI;

import profiles.customerProfiles.CustomerDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerRegistration {
    private JPanel panel1;
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

    public customerRegistration()
    {
        registerButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String customerID = CustomerDAO.initID();
                String fullName = customerID.getText();
                String address = StreetAddress.getText();
                String city = cityName.getText();
                String state = state.getSelectedItem().toString();
                String phoneNumber = phoneNumber.getText();
                double balance = Double.parseDouble(balance.getText());
                double lastPaid = Double.parseDouble(lastPaid.getText());
                String lastOrder = lastOrder.getText();

            }

            public void main(String[] args)
            {
                JFrame frame = new JFrame("customerRegistration");
                frame.setContentPane(new customerRegistration().menu);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        }
    }
}