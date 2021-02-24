package vendorProfiles;

import java.io.FileReader;
import java.io.FileWriter;

/**
 * This interface is used to access the data stored in Vendor objects
 */
public interface IVendorDAO {
    String initID();
    void insert(Vendor vendor);
    boolean check(String name);
}
