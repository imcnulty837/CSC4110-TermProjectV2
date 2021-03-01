package profiles.customerProfiles;

import profiles.Profile;

/**
 * This class details the customer profile's characteristics
 * @author Aaliyah Murray
 */
public class Customer extends Profile {
        private String customerID;
        private String firstName;
        private String lastName;
        private String streetAddress;
        private String state;
        private String cityName;
        private String phoneNumber;
        private double balance;
        private double lastPaid;
        private int lastOrder;

        //parameterized constructor
        public Customer(String cusID, String fn, String ln, String sa, String st,
                        String cn, String pn, double bal, double lp) {

                this.customerID = cusID;
                this.firstName = fn;
                this.lastName = ln;
                this.streetAddress = sa;
                this.state = st;
                this.cityName = cn;
                this.phoneNumber = pn;
                this.balance = bal;
                this.lastPaid = lp;

        }


//setters & getters
        public double getLastPaid() {
                return lastPaid;
        }

        public void setLastPaid(int lastPaid) {
                this.lastPaid = lastPaid;
        }

        public int getLastOrder() {
                return lastOrder;
        }

        public void setLastOrder(int lastOrder) {
                this.lastOrder = lastOrder;
        }

        public String getPhoneNumber() {
                return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
                this.phoneNumber = phoneNumber;
        }

        public double getBalance() {
                return balance;
        }

        public void setBalance(int balance) {
                this.balance = balance;
        }

        public String getCustomerID() {
                return customerID;
        }

        public void setCustomerID(String customerID) {
                this.customerID = customerID;
        }

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getStreetAddress() {
                return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
                this.streetAddress = streetAddress;
        }

        public String getCityName() {
                return cityName;
        }

        public void setCityName(String cityName) {
                this.cityName = cityName;
        }

        public String getState() {
                return state;
        }

        public void setState(String state) {
                this.state = state;
        }

        public double getlastPaid() {
                return lastPaid;
        }

        public void setlastPaid(double lastPaidAmount) {
                lastPaid = lastPaidAmount;
        }

        public int getlastOrder() {
                return lastOrder;
        }

        public void setlastOrder(String lastOrderDate) {
                lastOrder = lastOrder;
        }
}


