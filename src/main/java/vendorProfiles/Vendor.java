// TODO:
//  Check if id is unique
package vendorProfiles;

import java.util.Random;

/**
 * This class details the vendor profile's characteristics
 * @author Ian McNulty
 */
public class Vendor {
    private String id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String phoneNumber;
    private double balance;
    private double lastPaidAmount;
    private String lastOrderDate;
    private String seasonalDiscountsStartDate;

    public void main(String args[]){
        // Randomizes the values of the id
        Random rand = new Random();
        StringBuilder temp = new StringBuilder("012345");
        for (int i = 0; i < 6; i++){
            // Randomizes and stores each digit of id
            temp.setCharAt(i, (char) rand.nextInt(10));
        }

        // Sets id to random unique value
        setId(temp.toString());
    }

    // Block of accessor functions
    public String getId(){ return id; }
    public String getName(){ return name; }
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
    public void setId(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setBalance(double balance) { this.balance = balance; }
    public void setCity(String city) { this.city = city; }
    public void setLastOrderDate(String lastOrderDate) { this.lastOrderDate = lastOrderDate; }
    public void setLastPaidAmount(double lastPaidAmount) { this.lastPaidAmount = lastPaidAmount; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public void setSeasonalDiscountsStartDate(String seasonalDiscountsStartDate) { this.seasonalDiscountsStartDate = seasonalDiscountsStartDate; }
    public void setState(String state) { this.state = state; }
}

