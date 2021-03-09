package profiles.customerManagementUI;

// Use this to link to the other GUI files
// This can link to .form files or hard coded GUI files
// You do not have to use this, this is just an example of what you can do

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class customerMenu {
    private JFrame f = new JFrame("Customer Management");
    private JButton btn1 = new JButton("Register New Customer");
    private JButton btn2 = new JButton("Search for Customer");
    private JButton btn3 = new JButton("Return to Main Menu");
    private JLabel lbl1 = new JLabel("Customer Management");
    private JPanel pnl = new JPanel();

    public customerMenu() {
        btn1.setPreferredSize(new Dimension(300, 50));
        btn2.setPreferredSize(new Dimension(300, 50));
        btn3.setPreferredSize(new Dimension(300, 50));

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new customerRegistration();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new customerSearch();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                // Insert way back to Shuhel's menu here
            }
        });

        pnl.setPreferredSize(new Dimension(400, 200));
        pnl.add(lbl1, BorderLayout.PAGE_START);
        pnl.add(btn1, BorderLayout.NORTH);
        pnl.add(btn2, BorderLayout.CENTER);
        pnl.add(btn3, BorderLayout.PAGE_END);
        f.add(pnl, BorderLayout.CENTER);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setVisible(true);
    }
}
