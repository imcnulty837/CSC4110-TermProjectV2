package profiles.vendorProfiles;

import profiles.IProfileDAO;
import profiles.Profile;
import profiles.customerProfiles.Customer;
import profiles.itemProfiles.Item;

import java.io.*;
import java.util.Random;
import java.util.Vector;

/**
 * This class is used to implement the IProfileDAO interface
 *
 * @see IProfileDAO
 * @author Ian McNulty
 */
public class VendorDAO implements IProfileDAO {

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
        for (int i = 0; i < 6; i++){
            // Randomizes and stores each digit of id
            temp.setCharAt(i, (char) (rand.nextInt(10)+'0'));
        }

        // Sets id to random unique value
        return temp.toString();
    }

    /**
     * This function searches the data for a username and returns a true boolean if it is found
     *
     * @param name, the name to be checked for in the dataset
     * @return existence, a true or false stating whether or not the username already exists in the data
     */
    @Override
    public boolean check(String name) {
        boolean existence = false;
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader);
                if (temp.contains(name)) {
                    existence = true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return existence;
    }

    /**
     * Inserts a new Vendor object into the place of storage
     *
     * @param vendor, A Vendor object holding all the needed data
     */
    @Override
    public void insertVendor(Vendor vendor) {
        try {
            FileWriter writer = new FileWriter("VProfiles", true);
            //BufferedWriter bufferedWriter = new BufferedWriter(writer);
            writer.write(vendor.getId() + "\n"); // DataItem = 0
            writer.write(vendor.getName() + "\n"); // DataItem = 1
            writer.write(vendor.getAddress() + "\n"); // DataItem = 2
            writer.write(vendor.getCity() + "\n"); // DataItem = 3
            writer.write(vendor.getState() + "\n"); // DataItem = 4
            writer.write(vendor.getPhoneNumber() + "\n"); // DataItem = 5
            writer.write(vendor.getBalance() + "\n"); // DataItem = 6
            writer.write(vendor.getLastPaidAmount() + "\n"); // DataItem = 7
            writer.write(vendor.getLastOrderDate() + "\n"); // DataItem = 8
            writer.write(vendor.getSeasonalDiscountsStartDate() + "\n"); // DataItem = 9
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertCustomer(Customer customer) {
        System.out.println("Cannot access this datatype with VendorDAO");
    }

    @Override
    public void insertItem(Item<Profile> item) {
        System.out.println("Cannot access this datatype with VendorDAO");
    }

    public boolean checkId(String id) {
        boolean existence = false;
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader);
                if (temp.contains(id)) {
                    existence = true;
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return existence;
    }

    public Vendor retrieveUsername(String username) {
        Vendor vendor = new Vendor("","","","","","",0,
        0,"","");
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(username)) {
                    flag = true;
                    vendor.setName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 5 -> vendor.setPhoneNumber(temp);
                        case 6 -> vendor.setBalance(Double.parseDouble(temp));
                        case 7 -> vendor.setLastPaidAmount(Double.parseDouble(temp));
                        case 8 -> vendor.setLastOrderDate(temp);
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
        return vendor;
    }

    public Vendor retrieveID(String input) {
        Vendor vendor = new Vendor("","","","","","",0,
                0,"","");
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(input)) {
                    flag = true;
                    vendor.setName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 2 -> vendor.setName(temp);
                        case 5 -> vendor.setPhoneNumber(temp);
                        case 6 -> vendor.setBalance(Double.parseDouble(temp));
                        case 7 -> vendor.setLastPaidAmount(Double.parseDouble(temp));
                        case 8 -> vendor.setLastOrderDate(temp);
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
        return vendor;
    }

    public Vector<Vendor> retrieveAll() {
        Vector<Vendor> vendors = new Vector<Vendor>();
        try {
            FileReader reader = new FileReader("VProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            Vendor vendor = new Vendor("","","","","","",0,
                    0,"","");
            String temp;
            int dataItem = 0;
            int index = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                switch (dataItem) {
                    case 1 -> vendor.setName(temp);
                    case 5 -> vendor.setPhoneNumber(temp);
                    case 6 -> vendor.setBalance(Double.parseDouble(temp));
                    case 7 -> vendor.setLastPaidAmount(Double.parseDouble(temp));
                    case 8 -> vendor.setLastOrderDate(temp);
                }
                if (dataItem == 9) {
                    vendors.add(vendor);
                    dataItem = -1;
                    index = index + 1;
                }
                dataItem = dataItem + 1;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendors;
    }


}
