package profiles.itemRegistrationUI;

import profiles.Profile;
import profiles.itemProfiles.Item;
import profiles.itemProfiles.ItemDAO;
import profiles.vendorProfiles.Vendor;

import javax.swing.*;
import java.awt.*;

public class itemList {
    private JList<String> itemName, VendorList, expirationDate;
    private JList<Double> purchasePrice, sellingPrice;
    private JButton btn1 = new JButton("Return to Search Menu");
    private JFrame f = new JFrame("Listed Items");
    private JPanel pnl = new JPanel(), list = new JPanel();

}
