package profiles.customerProfiles;

import profiles.Profile;

import javax.swing.*;

/**
 * This class details the customer profile's characteristics
 * @author Aaliyah Murray
 */
public class Customer extends Profile {
        private String customerID;
        private String fullName;
        private String streetAddress;
        private String state;
        private String cityName;
        private String phoneNumber;
        private double balance;
        private double lastPaid;
        private String lastOrder;

        //parameterized constructor
        public Customer(String cusID, String fn, String sa, String st,
                        String cn, String pn, double bal, double lp, String lOr) {

                this.customerID = cusID;
                this.fullName = fn;
                this.streetAddress = sa;
                this.state = st;
                this.cityName = cn;
                this.phoneNumber = pn;
                this.balance = bal;
                this.lastPaid = lp;
                this.lastOrder = lOr;

        }

        public Customer(JTextField fullName, JTextField streetAddress, JTextField cityName, String state,
                        JTextField phone, JTextField bal, double lastPaid, String lastOrder) {
                super();
        }

        //setters & getters
        public double getLastPaid() {
                return lastPaid;
        }

        public void setLastPaid(int lastPaid) {
                this.lastPaid = lastPaid;
        }

        public String getLastOrder() {
                return lastOrder;
        }

        public void setLastOrder(String lastOrder) {
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

        public void setBalance(double balance) {
                this.balance = balance;
        }

        public String getCustomerID() {
                return customerID;
        }

        public void setCustomerID(String customerID) {
                this.customerID = customerID;
        }

        public String getFullName() {
                return fullName;
        }

        public void setFullName(String fullName) {
                this.fullName = fullName;
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

        public String getlastOrder() {
                return lastOrder;
        }

        public void setlastOrder(String lastOrderDate) {
                lastOrder = lastOrder;
        }
}