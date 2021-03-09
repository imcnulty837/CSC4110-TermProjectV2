package profiles.customerManagementUI;

import profiles.IProfileDAO;
import profiles.customerProfiles.Customer;
import profiles.customerProfiles.CustomerDAO;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// This works exactly like the original class you created, I just have not added the components
// to the GUI

public class customerRegistration {
    private String[] states = {"AL", "AK", "AZ", "AR", "CS", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
            "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
            "WI", "WY"};
    private JTextField fullName = new JTextField("");
    private JTextField StreetAddress = new JTextField("");
    private JTextField phone = new JTextField("");
    private JTextField lastOrderDate = new JTextField("mm/dd/yyyy");
    private JTextField lastPaidAmount = new JTextField("");
    private JButton register = new JButton("Register");
    private JPanel menu = new JPanel();
    private JComboBox stateBox = new JComboBox(states);
    private JLabel customerProfile = new JLabel();
    private JTextField cityName = new JTextField("");
    private JTextField bal = new JTextField("0.0");
    private JFrame frame = new JFrame("Customer Registration");

    private IProfileDAO customerDAO = new CustomerDAO();

    public customerRegistration() {

        register.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                String customerID = customerDAO.initID();
                String name = fullName.getText();
                String address = StreetAddress.getText();
                String city = cityName.getText();
                String state = stateBox.getSelectedItem().toString();
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

        // Need to add more components to this if you plan to use it
        // Use this block to add components to the menu
        menu.setPreferredSize(new Dimension(500, 500));
        menu.add(customerProfile);

        // Use this block to show the menu
        frame.add(menu, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
