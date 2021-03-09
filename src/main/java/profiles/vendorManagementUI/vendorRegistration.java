package profiles.vendorManagementUI;

import profiles.IProfileDAO;
import profiles.vendorProfiles.Vendor;
import profiles.vendorProfiles.VendorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class vendorRegistration {
    private String[] states = {"AL", "AK", "AZ", "AR", "CS", "CO", "CT", "DE", "FL", "GA", "HI", "ID",
            "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ",
            "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
            "WI", "WY"};
    private JTextField phoneNumber = new JTextField("xxx-xxx-xxxx");
    private JTextField cityName = new JTextField("");
    private JTextField streetAddress = new JTextField("");
    private JTextField companyName = new JTextField("");
    private JTextField bal = new JTextField("0.0");
    private JTextField lastPaid = new JTextField("0.0");
    private JTextField lastOrder = new JTextField("");
    private JTextField seasonalDiscount = new JTextField("mm/dd/yyyy");
    private JComboBox stateBox = new JComboBox(states);
    private JPanel registrationMenu = new JPanel(new GridLayout(9,2));
    private JButton registerButton = new JButton("Register");
    private JFrame f = new JFrame("Registration Menu");
    private JButton ret = new JButton("Return to Vendor Management");

    private JLabel reglbl = new JLabel("Registration");
    private JLabel namelbl = new JLabel("Company Name");
    private JLabel phonelbl = new JLabel("Phone Number");
    private JLabel addresslbl = new JLabel("Street Address");
    private JLabel citylbl = new JLabel("City");
    private JLabel statelbl = new JLabel("State");
    private JLabel ballbl = new JLabel("Balance*");
    private JLabel lastpaidlbl = new JLabel("Last Paid Amount*");
    private JLabel lastorderlbl = new JLabel("Last Order Date");
    private JLabel amountlbl = new JLabel("Seasonal Discount Start Date");
    private JLabel asterisklbl = new JLabel("* asterisks denote an unnecessary field");

    private IProfileDAO vendorDAO = new VendorDAO();

    public vendorRegistration() {
        phoneNumber.setPreferredSize(new Dimension(100, 40));
        cityName.setPreferredSize(new Dimension(100, 40));
        streetAddress.setPreferredSize(new Dimension(100, 40));
        companyName.setPreferredSize(new Dimension(300, 40));
        bal.setPreferredSize(new Dimension(300, 40));
        lastPaid.setPreferredSize(new Dimension(100, 40));
        lastOrder.setPreferredSize(new Dimension(100, 40));
        seasonalDiscount.setPreferredSize(new Dimension(300, 40));
        stateBox.setPreferredSize(new Dimension(100, 40));
        registerButton.setPreferredSize(new Dimension(100, 40));
        ret.setPreferredSize(new Dimension(225, 40));

        reglbl.setPreferredSize(new Dimension(400,40));
        namelbl.setPreferredSize(new Dimension(100,40));
        phonelbl.setPreferredSize(new Dimension(100,40));
        addresslbl.setPreferredSize(new Dimension(100,40));
        citylbl.setPreferredSize(new Dimension(100,40));
        statelbl.setPreferredSize(new Dimension(100,40));
        ballbl.setPreferredSize(new Dimension(100,40));
        lastpaidlbl.setPreferredSize(new Dimension(100,40));
        lastorderlbl.setPreferredSize(new Dimension(100,40));
        amountlbl.setPreferredSize(new Dimension(100,40));
        asterisklbl.setPreferredSize(new Dimension(400,40));

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
                if (name.length() > 20 || address.length() > 20 || city.length() > 20 || phone.length() > 12) {
                    if (!name.isEmpty() && !address.isEmpty() && !city.isEmpty() && !state.isEmpty()
                            && !phone.isEmpty() && !lastOrderDate.isEmpty() && !seasonalDiscountsStartDate.isEmpty()) {
                        if (!vendorDAO.check(name)) {
                            JOptionPane.showMessageDialog(registrationMenu, "Registration Successful");
                            vendorDAO.insertVendor(vendor);
                            f.dispose();
                            new vendorMenu();
                        } else {
                            JOptionPane.showMessageDialog(registrationMenu, "Registration Unsuccessful! Username Exists");
                            companyName.setText("");
                            streetAddress.setText("");
                            cityName.setText("");
                            phoneNumber.setText("");
                            bal.setText("");
                            lastPaid.setText("");
                            lastOrder.setText("");
                            seasonalDiscount.setText("");
                        }
                    } else {
                        JOptionPane.showMessageDialog(registrationMenu, "Please fill out remaining fields");
                    }
                } else {
                    JOptionPane.showMessageDialog(registrationMenu, "Inputs exceed maximum input length");
                }
            }
        });
        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new vendorMenu();
            }
        });

        /**
        GridLayout grid = new GridLayout(9,2);
        JPanel[] tempPanel = {new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel()};
        for (int i = 0; i < 13; i++) {
            tempPanel[i].setLayout(new GridLayout(1, 2));
        }
         **/

        JPanel toppnl = new JPanel();
        toppnl.add(new JLabel("Registration"));

        registrationMenu.setPreferredSize(new Dimension(500,360));
        registrationMenu.add(new JLabel("Company Name"));
        registrationMenu.add(companyName);
        registrationMenu.add(new JLabel("Address"));
        registrationMenu.add(streetAddress);
        registrationMenu.add(new JLabel("City"));
        registrationMenu.add(cityName);
        registrationMenu.add(new JLabel("State"));
        registrationMenu.add(stateBox);
        registrationMenu.add(new JLabel("Phone Number"));
        registrationMenu.add(phoneNumber);
        registrationMenu.add(new JLabel("Balance*"));
        registrationMenu.add(bal);
        registrationMenu.add(new JLabel("Last Paid Balance*"));
        registrationMenu.add(lastPaid);
        registrationMenu.add(new JLabel("Last Order Date"));
        registrationMenu.add(lastOrder);
        registrationMenu.add(new JLabel("Seasonal Discount Start Date"));
        registrationMenu.add(seasonalDiscount);

        JPanel bottompnl = new JPanel(new GridLayout(3,1));
        bottompnl.add(registerButton);
        bottompnl.add(new JLabel("* asterisks denote an unnecessary field"));
        bottompnl.add(ret);

        /**
        registrationMenu.setPreferredSize(new Dimension(500, 360));
        registrationMenu.setLayout(grid);
        tempPanel[0].add(reglbl);
        tempPanel[1].add(namelbl);
        tempPanel[1].add(companyName);
        tempPanel[2].add(addresslbl);
        tempPanel[2].add(streetAddress);
        tempPanel[3].add(citylbl);
        tempPanel[3].add(cityName);
        tempPanel[4].add(statelbl);
        tempPanel[4].add(stateBox);
        tempPanel[5].add(phonelbl);
        tempPanel[5].add(phoneNumber);
        tempPanel[6].add(ballbl);
        tempPanel[6].add(bal);
        tempPanel[7].add(lastpaidlbl);
        tempPanel[7].add(lastPaid);
        tempPanel[8].add(lastorderlbl);
        tempPanel[8].add(lastOrder);
        tempPanel[9].add(amountlbl);
        tempPanel[9].add(seasonalDiscount);
        tempPanel[10].add(registerButton);
        tempPanel[11].add(asterisklbl);
        tempPanel[12].add(ret);


        for(int i = 0; i < 13; i++)
            registrationMenu.add(tempPanel[i]);
         **/

        f.add(toppnl, BorderLayout.PAGE_START);
        f.add(registrationMenu, BorderLayout.CENTER);
        f.add(bottompnl, BorderLayout.PAGE_END);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
