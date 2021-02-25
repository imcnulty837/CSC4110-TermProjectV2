package profiles.vendorRegistrationUI;

import profiles.IProfileDAO;
import profiles.vendorProfiles.Vendor;
import profiles.vendorProfiles.VendorDAO;

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

    private IProfileDAO vendorDAO = new VendorDAO();

    public vendorRegistration() {
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = vendorDAO.initID();
                String name = companyName.getText();
                String address = streetAddress.getText();
                String city = cityName.getText();
                String state = stateBox.getSelectedItem().toString();
                String phone = phoneNumber.getText();
                double balance = Double.parseDouble(bal.getText());
                double lastPaidAmount = Double.parseDouble(lastPaid.getText());
                String lastOrderDate = lastOrder.getText();
                String seasonalDiscountsStartDate = seasonalDiscount.getText();

                Vendor vendor = new Vendor(id, name, address, city, state, phone, balance,
                        lastPaidAmount, lastOrderDate, seasonalDiscountsStartDate);
                if (!vendorDAO.check(name)) {
                    JOptionPane.showMessageDialog(menu, "Registration Successful");
                    vendorDAO.insertVendor(vendor);
                } else {
                    JOptionPane.showMessageDialog(menu, "Registration Unsuccessful! Username Exists");
                    companyName.setText("");
                    streetAddress.setText("");
                    cityName.setText("");
                    phoneNumber.setText("");
                    bal.setText("");
                    lastPaid.setText("");
                    lastOrder.setText("");
                    seasonalDiscount.setText("");
                }
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
