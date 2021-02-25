package profiles;

/**
 * Profile superclass to provide structure for each of the sub datatypes such as Vendor, Customer, and Item
 *
 * @author Ian McNulty
 */
public class Profile {
    private String id;
    private String name;

    public String getId(){ return id; }
    public String getName(){ return name; }

    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
}
