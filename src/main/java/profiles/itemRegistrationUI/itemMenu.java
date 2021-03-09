package profiles.itemRegistrationUI;

// Use this window to link to the registration and search windows
// If you want to use .form files, link them to this class

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class itemMenu {
    private JFrame f = new JFrame("Item Management");
    private JButton btn1 = new JButton("Register New Item");
    private JButton btn2 = new JButton("Search for Item");
    private JButton btn3 = new JButton("Return to Main Menu");
    private JLabel lbl1 = new JLabel("Item Management");
    private JPanel pnl = new JPanel();

    public itemMenu() {
        btn1.setPreferredSize(new Dimension(300, 50));
        btn2.setPreferredSize(new Dimension(300, 50));
        btn3.setPreferredSize(new Dimension(300, 50));

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new itemRegistration();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.dispose();
                new itemSearch();
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
