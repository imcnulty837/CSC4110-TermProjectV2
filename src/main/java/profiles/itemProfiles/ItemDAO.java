package profiles.itemProfiles;

import profiles.IProfileDAO;
import profiles.customerProfiles.Customer;
import profiles.vendorProfiles.Vendor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class ItemDAO implements IProfileDAO {
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

    @Override
    public boolean check(String name) {
        boolean exists = false;
        try {
            FileReader reader = new FileReader("IProfiles.txt");
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

    @Override
    public void insertVendor(Vendor vendor) {
        System.out.println("Cannot access this data type with ItemDAO");
    }

    @Override
    public void insertCustomer(Customer customer) {
        System.out.println("Cannot access this data type with ItemDAO");
    }

    @Override
    public void insertItem(Item item) {
        try {
            FileWriter writer = new FileWriter("IProfiles", true);
            writer.write(item.getId() + "\n"); // dataItem = 0
            writer.write(item.getName() + "\n"); // dataItem = 1

            writer.write(item.getSellingPrice() + "\n"); // dataItem = 3
            writer.write(item.getItemCategory() + "\n"); // dataItem = 4
            writer.write(item.getExpirationDate() + "\n"); // dataItem = 5
            writer.write(item.getPurchasePrice() + "\n"); // dataItem = 6
            writer.write(item.getUnit() + "\n"); // dataItem = 7
            writer.write(item.getQuantity() + "\n"); // dataItem = 8
            writer.write("\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
