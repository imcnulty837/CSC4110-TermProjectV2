package profiles.vendorProfiles;

import profiles.Profile;

/**
 * This class details the vendor profile's characteristics
 * @author Ian McNulty
 */
public class Vendor extends Profile {
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private double balance;
    private double lastPaidAmount;
    private String lastOrderDate;
    private String seasonalDiscountsStartDate;

    public Vendor(String id, String name, String address, String city, String state, String phoneNumber, double balance,
                  double lastPaidAmount, String lastOrderDate, String seasonalDiscountsStartDate){
        super.setName(name);
        super.setId(id);
        this.address = address;
        this.city = city;
        this.state = state;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
        this.lastPaidAmount = lastPaidAmount;
        this.lastOrderDate = lastOrderDate;
        this.seasonalDiscountsStartDate = seasonalDiscountsStartDate;
    }

    // Block of accessor functions
    public String getAddress(){ return address; }
    public String getCity(){ return city; }
    public String getState(){ return state; }
    public String getPhoneNumber(){ return phoneNumber; }
    public double getBalance(){ return balance; }
    public double getLastPaidAmount(){ return lastPaidAmount; }
    public String getLastOrderDate(){ return lastOrderDate; }
    public String getSeasonalDiscountsStartDate(){ return seasonalDiscountsStartDate; }

    // Block of transformer functions
    public void setAddress(String address) { this.address = address; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setCity(String city) { this.city = city; }
    public void setLastOrderDate(String lastOrderDate) { this.lastOrderDate = lastOrderDate; }
    public void setLastPaidAmount(double lastPaidAmount) { this.lastPaidAmount = lastPaidAmount; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setSeasonalDiscountsStartDate(String seasonalDiscountsStartDate) { this.seasonalDiscountsStartDate = seasonalDiscountsStartDate; }
    public void setState(String state) { this.state = state; }
}

