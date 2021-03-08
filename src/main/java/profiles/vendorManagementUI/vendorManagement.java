/* TODO:
    6.  The system shall restrict invalid inputs from users
            -Need to restrict based on datatype
            -This problem needs to be fixed in vendorRegistration
    7.  The system shall allow owner or purchaser users to delete any vendor profiles only when their balance is 0.
    8.  The system shall allow owner or purchaser users to search for a vendor profile
        by either vendor id or vendor full name.
    12. When deleting a vendor profile, the system shall warn the users that all associated purchase
        orders will be deleted. If the users accept deletion, then the system shall automatically delete
        all purchase orders associated with the deleted vendor.
 */

package profiles.vendorManagementUI;

public class vendorManagement {
    public static void main(String[] args){
        new vendorMenu();
    }
}
