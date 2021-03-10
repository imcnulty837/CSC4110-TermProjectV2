package profiles.itemProfiles;

import profiles.Profile;

public class Item<I extends Profile> extends Profile {
    private String vendorID;
    private double sellingPrice;
    private String itemCategory;
    private String expirationDate;
    private double purchasePrice;
    private String unit;
    private double quantity;

    public Item(String id, String name, String vendorID, double sellingPrice,
                String itemCategory, String expirationDate,
                double purchasePrice, String unit, double quantity){
        super.setId(id);
        super.setName(name);
        this.vendorID = vendorID;
        this.sellingPrice = sellingPrice;
        this.itemCategory = itemCategory;
        this.expirationDate = expirationDate;
        this.purchasePrice = purchasePrice;
        this.unit = unit;
        this.quantity = quantity;
    }

    public Item(String id, String name, String vendorID, String s, String itemCategory, String expirationDate, int purchasePrice, int i, String s1, String s2) {
        super.setName(name);
        super.setId(id);
        this.vendorID = vendorID;
        this.itemCategory = itemCategory;
        this.expirationDate = expirationDate;
        this.purchasePrice = purchasePrice;
        this.unit = unit;
        this.quantity = quantity;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getItemCategory() {
        return itemCategory;
    }

    public String getUnit() {
        return unit;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

}

