package profiles.itemRegistrationUI;

import profiles.IProfileDAO;
import profiles.Profile;
import profiles.itemProfiles.Item;
import profiles.itemProfiles.ItemDAO;
import profiles.vendorManagementUI.vendorMenu;
import profiles.vendorProfiles.Vendor;
import profiles.vendorProfiles.VendorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class itemRegistration {
    private String[] categories = {"vegetables", "fruits", "nuts", "dairy", "meat", "snacks",
            "soda", "juice", "bakery products"};
    private JComboBox vendorList;
    private JTextField quantity = new JTextField("0.0");
    private JTextField itemName = new JTextField("");
    private JTextField sellingPrice = new JTextField("0.0");
    private JTextField purchasePrice = new JTextField("0.0");
    private JTextField unitOfMeasurement = new JTextField("");
    private JTextField expirationDate = new JTextField("mm/dd/yyyy");
    private JComboBox categoryBox = new JComboBox(categories);
    private JPanel registrationMenu = new JPanel();
    private JButton registerButton = new JButton("Register");
    private JFrame f = new JFrame("Registration Menu");
    private JButton ret = new JButton("Return to Item Management");

    private IProfileDAO itemDAO = new ItemDAO();
    private VendorDAO vendorDAO = new VendorDAO();

    public itemRegistration() {
        Vector<Vendor> vendors = vendorDAO.retrieveAll();
        Vector<String> names = new Vector<String>(vendors.size());
        for (int i = 0; i < vendors.size(); i = i + 1){
            names.add(vendors.elementAt(i).getName());
        }
        vendorList = new JComboBox(names);

        vendorList.setPreferredSize(new Dimension(100, 40));
        quantity.setPreferredSize(new Dimension(100, 40));
        itemName.setPreferredSize(new Dimension(300, 40));
        sellingPrice.setPreferredSize(new Dimension(300, 40));
        purchasePrice.setPreferredSize(new Dimension(100, 40));
        unitOfMeasurement.setPreferredSize(new Dimension(100, 40));
        expirationDate.setPreferredSize(new Dimension(300, 40));
        categoryBox.setPreferredSize(new Dimension(100, 40));
        registerButton.setPreferredSize(new Dimension(100, 40));
        ret.setPreferredSize(new Dimension(225, 40));

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = itemDAO.initID();
                String name = itemName.getText();
                double quantityText = Double.parseDouble(quantity.getText());
                String vendor = vendorList.getSelectedItem().toString();
                String category = categoryBox.getSelectedItem().toString();
                double selling = Double.parseDouble(sellingPrice.getText());
                double purchase = Double.parseDouble(purchasePrice.getText());
                String unit = unitOfMeasurement.getText();
                String expiration = expirationDate.getText();

                Item<Profile> item = new Item<Profile>(id, name, vendor, selling, category, expiration,
                        purchase, unit, quantityText);
                if (name.length() > 20 ||  vendor.length() > 20) {
                    if (!name.isEmpty()  && !vendor.isEmpty() && !category.isEmpty()
                            &&  !unit.isEmpty() && !expiration.isEmpty()) {
                        if (!itemDAO.check(name)) {
                            JOptionPane.showMessageDialog(registrationMenu, "Registration Successful");
                            itemDAO.insertItem(item);
                            f.dispose();
                            new vendorMenu();
                        } else {
                            JOptionPane.showMessageDialog(registrationMenu, "Registration Unsuccessful! Username Exists");
                            itemName.setText("");
                            quantity.setText("");
                            sellingPrice.setText("");
                            purchasePrice.setText("");
                            unitOfMeasurement.setText("");
                            expirationDate.setText("");
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
                new itemMenu();
            }
        });

        GridLayout grid = new GridLayout(18,1);
        JPanel[] tempPanel = {new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel(),new JPanel(),new JPanel(),
                new JPanel(),new JPanel()};
        for (int i = 0; i < 11; i++) {
            tempPanel[i].setLayout(new GridLayout(1, 2));
        }

        registrationMenu.setPreferredSize(new Dimension(500, 360));
        registrationMenu.setLayout(grid);
        tempPanel[0].add(new JLabel("Registration"));
        tempPanel[1].add(new JLabel("Item Name"));
        tempPanel[1].add(itemName);
        tempPanel[2].add(new JLabel("Vendor Name"));
        tempPanel[2].add(vendorList);
        tempPanel[3].add(new JLabel("Selling Price"));
        tempPanel[3].add(sellingPrice);
        tempPanel[4].add(new JLabel("Item Category"));
        tempPanel[4].add(categoryBox);
        tempPanel[5].add(new JLabel("Expiration Date"));
        tempPanel[5].add(expirationDate);
        tempPanel[6].add(new JLabel("Purchase Price"));
        tempPanel[6].add(purchasePrice);
        tempPanel[7].add(new JLabel("Unit of Measurement"));
        tempPanel[7].add(unitOfMeasurement);
        tempPanel[8].add(new JLabel("Quantity on hand"));
        tempPanel[8].add(quantity);
        tempPanel[9].add(registerButton);
        tempPanel[10].add(ret);

        for(int i = 0; i < 11; i++)
            registrationMenu.add(tempPanel[i]);

        f.add(registrationMenu, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
