package profiles.itemRegistrationUI;

import profiles.itemProfiles.Item;
import profiles.itemProfiles.ItemDAO;
import profiles.vendorManagementUI.vendorList;
import profiles.vendorManagementUI.vendorMenu;
import profiles.vendorProfiles.VendorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemSearch {
    private JTextField searchItem = new JTextField("Enter an item to search here");
    private JTextField searchID = new JTextField("Enter an ID to search here");
    private JButton searchByItem = new JButton("Search for Item");
    private JButton searchByID = new JButton("Search for ID");
    private JButton list = new JButton("List all items");
    private JButton ret = new JButton("Return to Item Management");
    private JPanel pnl = new JPanel();
    private JFrame f = new JFrame("Item Search");

    private ItemDAO itemDAO = new ItemDAO();

    public itemSearch(){
        searchItem.setPreferredSize(new Dimension(250, 40));
        searchID.setPreferredSize(new Dimension(250, 40));
        searchByItem.setPreferredSize(new Dimension(200, 50));
        searchByID.setPreferredSize(new Dimension(200, 50));
        list.setPreferredSize(new Dimension(200, 50));
        ret.setPreferredSize(new Dimension(200, 50));

        searchByItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = searchItem.getText();

                if (username.length() > 20) {
                    if (itemDAO.check(username)) {
                        f.dispose();
                        new vendorList(username, 1);
                    } else {
                        JOptionPane.showMessageDialog(pnl, "Cannot find this item");
                    }
                } else {
                    JOptionPane.showMessageDialog(pnl, "Cannot find this item");
                }
            }
        });

        searchByID.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ID = searchID.getText();

                if (ID.length() > 20) {
                    if (itemDAO.checkId(ID)) {
                        f.dispose();
                        new vendorList(ID, 2);
                    } else {
                        JOptionPane.showMessageDialog(pnl, "Cannot find this vendor");
                    }
                } else {
                    JOptionPane.showMessageDialog(pnl, "Cannot find this vendor");
                }
            }
        });
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new itemList();
            }
        });

        ret.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new itemMenu();
            }
        });

        JPanel userpnl = new JPanel(new GridLayout(2,1));
        userpnl.add(searchItem);
        userpnl.add(searchByItem);

        JPanel idpnl = new JPanel(new GridLayout(2, 1));
        idpnl.add(searchID);
        idpnl.add(searchByID);

        pnl.setPreferredSize(new Dimension(300, 350));
        pnl.add(userpnl, BorderLayout.PAGE_START);
        pnl.add(idpnl, BorderLayout.NORTH);
        pnl.add(list, BorderLayout.SOUTH);
        pnl.add(ret, BorderLayout.PAGE_END);
        f.add(pnl, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
