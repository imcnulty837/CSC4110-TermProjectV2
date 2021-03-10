package profiles.itemProfiles;

import profiles.IProfileDAO;
import profiles.Profile;
import profiles.customerProfiles.Customer;
import profiles.vendorProfiles.Vendor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

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

    public static Item<Profile> retrieveItemName(String username) {
        Item<Profile> item = new Item<Profile>("","","","","","",0,
                0,"","");
        try {
            FileReader reader = new FileReader("IProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(username)) {
                    flag = true;
                    item.setName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 5 -> item.setExpirationDate(temp);
                        case 6 -> item.setSellingPrice(Double.parseDouble(temp));
                        case 7 -> item.setPurchasePrice(Double.parseDouble(temp));
                        case 8 -> item.setItemCategory(temp);
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
        return item;
    }

    public static Item<Profile> retrieveID(String input) {
        Item<Profile> item = new Item<Profile>("","","","","","",0,
                0,"","");
        try {
            FileReader reader = new FileReader("IProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String temp;
            int dataItem = 0;
            boolean flag = false;
            while ((temp = bufferedReader.readLine()) != null) {
                if (temp.contains(input)) {
                    flag = true;
                    item.setName(temp);
                }
                if (flag = true){
                    switch (dataItem) {
                        case 2 -> item.setName(temp);
                        case 5 -> item.setExpirationDate(temp);
                        case 6 -> item.setSellingPrice(Double.parseDouble(temp));
                        case 7 -> item.setPurchasePrice(Double.parseDouble(temp));
                        case 8 -> item.setItemCategory(temp);
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
        return item;
    }

    public Vector<Item> retrieveAll() {
        Vector<Item> items = new Vector<>();
        try {
            FileReader reader = new FileReader("IProfiles");
            BufferedReader bufferedReader = new BufferedReader(reader);
            Item item = new Item<>("","","","","","",0,
                    0,"","");
            String temp;
            int dataItem = 0;
            int index = 0;
            while ((temp = bufferedReader.readLine()) != null) {
                switch (dataItem) {
                    case 1 -> item.setName(temp);
                    case 5 -> item.setExpirationDate(temp);
                    case 6 -> item.setSellingPrice(Double.parseDouble(temp));
                    case 7 -> item.setPurchasePrice(Double.parseDouble(temp));
                    case 8 -> item.setItemCategory(temp);
                }
                if (dataItem == 9) {
                    items.add(item);
                    dataItem = -1;
                    index = index + 1;
                }
                dataItem = dataItem + 1;
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return items;
    }


    @Override
    public void insertCustomer(Customer customer) {
        System.out.println("Cannot access this data type with ItemDAO");
    }

    @Override
    public void insertItem(Item<Profile> item) {
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
