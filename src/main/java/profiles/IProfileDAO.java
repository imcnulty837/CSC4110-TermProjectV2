package profiles;

import profiles.itemProfiles.Item;
import profiles.vendorProfiles.Vendor;
import profiles.customerProfiles.Customer;

/**
 * This interface is used to access the data stored in Vendor objects
 */
public interface IProfileDAO {
    String initID();
    boolean check(String name);

    void insertVendor(Vendor vendor);
    void insertCustomer(Customer customer);
    void insertItem(Item item);
}
