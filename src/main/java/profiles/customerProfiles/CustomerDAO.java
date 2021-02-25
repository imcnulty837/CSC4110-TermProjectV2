package profiles.customerProfiles;

import profiles.IProfileDAO;
import profiles.itemProfiles.Item;
import profiles.vendorProfiles.Vendor;

import java.util.Random;

public class CustomerDAO implements IProfileDAO {
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
    public boolean check(String name) {
        return false;
    }

    @Override
    public void insertVendor(Vendor vendor) {

    }

    @Override
    public void insertCustomer(Customer customer) {

    }

    @Override
    public void insertItem(Item item) {

    }
}
