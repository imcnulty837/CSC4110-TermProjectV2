package profiles.customerProfilesUI;

import profiles.IProfileDAO;
import profiles.customerProfiles.Customer;
import profiles.customerProfiles.CustomerDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerRegistration {
    private JTextField fullName;
    private JTextField StreetAddress;
    private JTextField phone;
    private JTextField lastOrderDate;
    private JComboBox stateName;
    private JTextField lastPaidAmount;
    private JButton register;
    private JPanel menu;
    private JLabel customerProfile;
    private JTextField cityName;
    private JTextField bal;

    private IProfileDAO customerDAO = new CustomerDAO();

    public customerRegistration() {
        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String customerID = customerDAO.initID();
                String name = fullName.getText();
                String address = StreetAddress.getText();
                String city = cityName.getText();
                String state = stateName.getSelectedItem().toString();
                String phoneNumber = phone.getText();
                double balance = Double.parseDouble(bal.getText());
                double lastPaid = Double.parseDouble(lastPaidAmount.getText());
                String lastOrder = lastOrderDate.getText();
                System.out.println("hello");

                Customer customer = new Customer(customerID, name, address, state, city, phoneNumber,
                        balance, lastPaid, lastOrder);

                if (!name.isEmpty()  && !address.isEmpty() && !city.isEmpty() &&
                        !state.isEmpty() && !phoneNumber.isEmpty() && !lastOrder.isEmpty()) {
                    if(name.length() > 20 && address.length() > 20 && city.length() > 20 )
                        JOptionPane.showMessageDialog(menu, "Please use only 20 characters or less.");
                    if(customerDAO.check(name))
                        JOptionPane.showMessageDialog(menu, "Name already exists, please try again.");
                    if (!customerDAO.check(name)) {
                        JOptionPane.showMessageDialog(menu, "Registration Successful!");
                        customerDAO.insertCustomer(customer);
                    } else {
                        JOptionPane.showMessageDialog(menu, "Registration was Unsuccessful. Username " +
                                "already exists");
                        fullName.setText("");
                        StreetAddress.setText("");
                        cityName.setText("");
                        phone.setText("");
                        bal.setText("");
                        lastPaidAmount.setText("");
                        lastOrderDate.setText("");
                    }
                } else {
                    JOptionPane.showMessageDialog(menu, "Please fill out the empty fields");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("customer registration");
        frame.setContentPane(new customerRegistration().menu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}