package profiles.customerManagementUI;

import profiles.customerProfiles.Customer;
import profiles.customerProfiles.CustomerDAO;
import profiles.vendorManagementUI.vendorSearch;
import profiles.vendorProfiles.Vendor;
import profiles.vendorProfiles.VendorDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class customerList {

        private JList<String> names, phones, lastDates;
        private JList<Double> balances, lastPaids;
        private JButton btn1 = new JButton("Return to Search Menu");
        private JFrame f = new JFrame("Listed Customer's company names");
        private JPanel pnl = new JPanel(), list = new JPanel();

        private CustomerDAO customerDAO = new CustomerDAO();

        public customerList(String input, int flag) {
            Customer customer = new Customer("","","","","","",0,
                    0,"");
            if (flag == 1)
                customer = customerDAO.retrieveUsername(input);
            if (flag == 2)
                customer = customerDAO.retrieveID(input);
            names = new JList<String>(new String[]{customer.getFullName()});
            phones  = new JList<String>(new String[]{customer.getPhoneNumber()});
            lastDates = new JList<String>(new String[]{customer.getlastOrder()});
            balances = new JList<Double>(new Double[]{customer.getBalance()});
            lastPaids = new JList<Double>(new Double[]{customer.getLastPaid()});

            names.setPreferredSize(new Dimension(200, 300));
            phones.setPreferredSize(new Dimension(200, 300));
            lastDates.setPreferredSize(new Dimension(200, 300));
            balances.setPreferredSize(new Dimension(200, 300));
            lastPaids.setPreferredSize(new Dimension(200, 300));
            list.setPreferredSize(new Dimension(1000, 400));
            btn1.setPreferredSize(new Dimension(200,50));

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new vendorSearch();
                }
            });

            JPanel lbllist = new JPanel(new GridLayout(1,5));
            lbllist.setPreferredSize(new Dimension(1000,25));
            lbllist.add(new JLabel("Name"));
            lbllist.add(new JLabel("Phone Number"));
            lbllist.add(new JLabel("Last Order Date"));
            lbllist.add(new JLabel("Balance"));
            lbllist.add(new JLabel("Last Paid Amount"));

            list.setLayout(new GridLayout(1,5));
            list.add(names);
            list.add(phones);
            list.add(lastDates);
            list.add(balances);
            list.add(lastPaids);
            pnl.setPreferredSize(new Dimension(1000, 500));
            pnl.add(lbllist, BorderLayout.PAGE_START);
            pnl.add(list, BorderLayout.CENTER);
            pnl.add(btn1, BorderLayout.PAGE_END);
            f.add(pnl, BorderLayout.CENTER);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }

        public customerList() {
            Vector<Customer> vendors = customerDAO.retrieveAll();
            Vector<String> name = new Vector<String>(vendors.size()),
                    phone = new Vector<String>(vendors.size()),
                    lastdate = new Vector<String>(vendors.size());
            Vector<Double> bals = new Vector<Double>(vendors.size()),
                    lastpaid = new Vector<Double>(vendors.size());

            for (int i = 0; i < vendors.size(); i = i+1){
                name.add(vendors.elementAt(i).getName());
                phone.add(vendors.elementAt(i).getPhoneNumber());
                lastdate.add(vendors.elementAt(i).getlastOrder());
                bals.add(vendors.elementAt(i).getBalance());
                lastpaid.add(vendors.elementAt(i).getLastPaid());
            }

            names = new JList<String>(name);
            phones  = new JList<String>(phone);
            lastDates = new JList<String>(lastdate);
            balances = new JList<Double>(bals);
            lastPaids = new JList<Double>(lastpaid);

            names.setPreferredSize(new Dimension(200, 300));
            phones.setPreferredSize(new Dimension(200, 300));
            lastDates.setPreferredSize(new Dimension(200, 300));
            balances.setPreferredSize(new Dimension(200, 300));
            lastPaids.setPreferredSize(new Dimension(200, 300));
            list.setPreferredSize(new Dimension(1000, 400));
            btn1.setPreferredSize(new Dimension(200,50));

            btn1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    new vendorSearch();
                }
            });

            JPanel lbllist = new JPanel(new GridLayout(1,5));
            lbllist.setPreferredSize(new Dimension(1000,25));
            lbllist.add(new JLabel("Name"));
            lbllist.add(new JLabel("Phone Number"));
            lbllist.add(new JLabel("Last Order Date"));
            lbllist.add(new JLabel("Balance"));
            lbllist.add(new JLabel("Last Paid Amount"));

            list.setLayout(new GridLayout(1,5));
            list.add(names);
            list.add(phones);
            list.add(lastDates);
            list.add(balances);
            list.add(lastPaids);
            pnl.setPreferredSize(new Dimension(1000, 500));
            pnl.add(lbllist, BorderLayout.PAGE_START);
            pnl.add(list, BorderLayout.CENTER);
            pnl.add(btn1, BorderLayout.PAGE_END);
            f.add(pnl, BorderLayout.CENTER);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.pack();
            f.setVisible(true);
        }
    }

