package profiles.customerManagementUI;

import profiles.customerProfiles.CustomerDAO;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerSearch {

        private JTextField searchUsername = new JTextField("Enter a username to search here");
        private JTextField searchID = new JTextField("Enter an ID to search here");
        private JButton searchByUsername = new JButton("Search for Username");
        private JButton searchByID = new JButton("Search for ID");
        private JButton list = new JButton("List all users");
        private JButton ret = new JButton("Return to Customer Management");
        private JPanel pnl = new JPanel();
        private JFrame f = new JFrame("Customer Search");

        private CustomerDAO customerDAO = new CustomerDAO();

        public customerSearch(){
            searchUsername.setPreferredSize(new Dimension(250, 40));
            searchID.setPreferredSize(new Dimension(250, 40));
            searchByUsername.setPreferredSize(new Dimension(200, 50));
            searchByID.setPreferredSize(new Dimension(200, 50));
            list.setPreferredSize(new Dimension(200, 50));
            ret.setPreferredSize(new Dimension(200, 50));

            searchByUsername.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String username = searchUsername.getText();

                    if (username.length() > 20) {
                        if (customerDAO.check(username)) {
                            f.dispose();
                            new customerList(username, 1);
                        } else {
                            JOptionPane.showMessageDialog(pnl, "Cannot find this vendor");
                        }
                    } else {
                        JOptionPane.showMessageDialog(pnl, "Cannot find this vendor");
                    }
                }
            });
            searchByID.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String ID = searchID.getText();

                    if (ID.length() > 20) {
                        if (customerDAO.check(ID)) {
                            f.dispose();
                            new customerList(ID, 2);
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
                    new customerList();
                }
            });
            ret.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new customerMenu();
                }
            });

            JPanel userpnl = new JPanel(new GridLayout(2,1));
            userpnl.add(searchUsername);
            userpnl.add(searchByUsername);

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

