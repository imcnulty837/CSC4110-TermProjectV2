package profiles.customerProfiles;

import profiles.IProfileDAO;
import profiles.Profile;
import profiles.itemProfiles.Item;
import profiles.vendorProfiles.Vendor;

import java.io.*;
import java.util.Random;
import java.util.Vector;

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
    public String initID() {
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
            FileReader reader = new FileReader("CProfiles.txt");
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

    }
    /**
     * Inserts a new customer object into the place of storage
     *
     * @param customer, A customer object holding all the needed data
     */

    @Override
    public void insertCustomer(Customer customer) {
        try {
            System.out.println(customer.getCustomerID());
            FileWriter writer = new FileWriter("CProfiles", true);
            writer.write(customer.getCustomerID() + "\n"); // dataItem = 0
            writer.write(customer.getFullName() + "\n"); // dataItem = 1
            writer.write(customer.getStreetAddress() + "\n"); // dataItem = 2
            writer.write(customer.getCityName() + "\n"); // dataItem = 3
            writer.write(customer.getState() + "\n"); // dataItem = 4
            writer.write(customer.getPhoneNumber() + "\n"); // dataItem = 5
            writer.write(customer.getBalance() + "\n"); // dataItem = 6
            writer.write(customer.getlastPaid() + "\n"); // dataItem = 7
            writer.write(customer.getlastOrder() + "\n"); // dataItem = 8
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertVendor(Vendor vendor) {
        System.out.println("Cannot access this datatype with CustomerDAO");
    }

    @Override
    public void insertItem(Item<Profile> item) {
        System.out.println("Cannot access this datatype with CustomerDAO");
    }

    public Customer retrieveUsername(String username) {
        Customer customer = new Customer("","","","","","",0,
                0,"");
        try {
            FileReader reader = new FileReader("CProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(username)) {
                    flag = true;
                    customer.setFullName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 5 -> customer.setPhoneNumber(temp);
                        case 6 -> customer.setBalance(Double.parseDouble(temp));
                        case 7 -> customer.setlastPaid(Double.parseDouble(temp));
                        case 8 -> customer.setLastOrder(temp);
                        case 9 -> flag = false;
                    }
                }
                if (dataItem == 9)
                    dataItem = -1;
                dataItem = dataItem + 1;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer retrieveID(String input) {
        Customer customer = new Customer("","","","","","",0,
                0,"");
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(input)) {
                    flag = true;
                    customer.setFullName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 2 -> customer.setFullName(temp);
                        case 5 -> customer.setPhoneNumber(temp);
                        case 6 -> customer.setBalance(Double.parseDouble(temp));
                        case 7 -> customer.setlastPaid(Double.parseDouble(temp));
                        case 8 -> customer.setLastOrder(temp);
                        case 9 -> flag = false;
                    }
                }
                if (dataItem == 9)
                    dataItem = -1;
                dataItem = dataItem + 1;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Vector<Customer> retrieveAll() {
        Vector<Customer> customers = new Vector<>();
        Customer customer = null;
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            customer = new Customer("", "", "", "", "", "", 0,
                    0, "");
            String temp;
            int dataItem = 0;
            int index = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                switch (dataItem) {
                    case 1 -> customer.setFullName(temp);
                    case 5 -> customer.setPhoneNumber(temp);
                    case 6 -> customer.setBalance(Double.parseDouble(temp));
                    case 7 -> customer.setlastPaid(Double.parseDouble(temp));
                    case 8 -> customer.setlastOrder(temp);
                }
                if (dataItem == 9) {
                    customers.add(customer);
                    dataItem = -1;
                    index = index + 1;
                }
                dataItem = dataItem + 1;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }


}
