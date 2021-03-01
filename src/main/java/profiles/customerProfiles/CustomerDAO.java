package profiles.customerProfiles;

import profiles.IProfileDAO;
import profiles.itemProfiles.Item;
import profiles.vendorProfiles.Vendor;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

import java.io.*;
import java.util.Random;
/**
 * This class is used to implement the IProfileDAO interface
 *
 * @see IProfileDAO
 * @author Aaliyah Murray
 */
public class CustomerDAO implements IProfileDAO {
    /**
     * Randomizes the ID and returns the new ID
     *
     * @return temp, The randomized string of numerical characters that is the ID
     */
    @Override
    public static String initID() {
        // Randomizes the values of the id
        Random rand = new Random();
        StringBuilder temp = new StringBuilder("012345");
        for (int i = 0; i < 6; i++) {
            // Randomizes and stores each digit of id
            temp.setCharAt(i, (char) (rand.nextInt(10) + '0'));
        }

        // Sets id to random unique value
        return temp.toString();
    }

    /**
     * This function searches the data for a username and returns a true boolean if it is found
     *
     * @param name, the name to be checked for in the dataset
     * @return exists, a true or false stating whether or not the customer already exists in the system
     */

    public boolean check(String name) {

        boolean exists = false;
        try {
            File rd = new File("CProfiles");
            PrintWriter pw = new PrintWriter("CProfiles");
            Scanner sc = new Scanner(System.in);
            sc = new Scanner(rd);
            System.out.println(rd);
            String temp;
            while ((temp = sc.nextLine()) != null) {
                System.out.println(rd);
                if (temp.contains(name)) {
                    exists = true;
                }
                sc.close();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return exists;
    }


        /*try {
            FileReader reader = new FileReader("CProfile.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader);
                if (temp.contains(name)) {
                    exists = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return exists;

    } */
    /**
     * Inserts a new customer object into the place of storage
     *
     * @param customer, A customer object holding all the needed data
     */

    @Override
    public void insertCustomer(Customer customer) {
        try {
            PrintWriter pw = new PrintWriter("CProfile.txt");
            pw.write(customer.getId() + "|");
            pw.write(customer.getName() + "|");
            pw.write(customer.getStreetAddress() + "|");
            pw.write(customer.getCityName() + "|");
            pw.write(customer.getState() + "|");
            pw.write(customer.getPhoneNumber() + "|");
            pw.write(customer.getBalance() + "|");
            pw.write(customer.getlastPaid() + "|");
            pw.write(customer.getlastOrder() + "|");
            pw.write("\n");
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertVendor(Vendor vendor) {
        System.out.println("Cannot access this datatype with CustomerDAO");
    }

    @Override
    public void insertItem(Item item) {
        System.out.println("Cannot access this datatype with CustomerDAO");
    }

}
