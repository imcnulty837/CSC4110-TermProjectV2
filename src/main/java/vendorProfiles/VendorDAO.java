package vendorProfiles;

import java.io.*;
import java.util.Random;

/**
 * This class is used to implement the VendorDAO interface
 * @author Ian McNulty
 */
public class VendorDAO implements IVendorDAO {

    /**
     * Randomizes the ID and returns the new ID
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

    @Override
    public void insert(Vendor vendor) {
        try {
            FileWriter writer = new FileWriter("profiles.txt", true);
            //BufferedWriter bufferedWriter = new BufferedWriter(writer);
            writer.write(vendor.getId() + "|");
            writer.write(vendor.getName() + "|");
            writer.write(vendor.getAddress() + "|");
            writer.write(vendor.getCity() + "|");
            writer.write(vendor.getState() + "|");
            writer.write(vendor.getPhoneNumber() + "|");
            writer.write(vendor.getBalance() + "|");
            writer.write(vendor.getLastPaidAmount() + "|");
            writer.write(vendor.getLastOrderDate() + "|");
            writer.write(vendor.getSeasonalDiscountsStartDate() + "|");
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean check(String name) {
        boolean existence = false;
        try {
            FileReader reader = new FileReader("profiles.txt");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println(bufferedReader);
            String temp;
            while ((temp = bufferedReader.readLine()) != null) {
                System.out.println(bufferedReader);
                if (temp.contains(name)) {
                    existence = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return existence;
    }
}
