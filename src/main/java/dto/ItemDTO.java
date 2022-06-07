
package dto;

/**
 * Data Transfer Object (DTO) for items, containing all relevant information about an item. Information is immutable and cannot be changed once created, only read.
 */
public class ItemDTO {
    
    private final int itemID;
    private final String itemName;
    private final String itemDescription;
    private final String itemCategory;
    private final double price;
    private final double taxRate;
    private final boolean validity;
    
    /**
     * Initializes the DTO. Once the parameters have been set, they cannot be changed.
     * @param itemID Item identification number, corresponding to the bar code if applicable.
     * @param itemName The items name
     * @param itemDescription Further description of the item if needed
     * @param itemCategory The category the item belongs to, used for discounts
     * @param price The price of the item excluding taxes
     * @param taxRate The tax rate for the item
     * @param validity if the item is contained in the inventory database this should be true
     */
    public ItemDTO (int itemID, String itemName, String itemDescription, String itemCategory, double price, double taxRate, boolean validity) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.itemCategory = itemCategory;
        this.price = price;
        this.taxRate = taxRate;
        this.validity = validity;
    }
    
    /**
     * Getter for itemID
     * @return Identification number of the item
     */
    public int getItemID () {
        return itemID;
    }
    
    /**
     * Getter for itemName
     * @return Name of the item
     */
    public String getItemName () {
        return itemName;
    }
    
    /**
     * Getter for itemDescription
     * @return Description of the item
     */
    public String getItemDescription () {
        return itemDescription;
    }
    
    /**
     * Getter for itemCategory
     * @return Category the item belongs to
     */
    public String getItemCategory () {
        return itemCategory;
    }
    
    /**
     * Getter for price
     * @return Price of the item
     */
    public double getPrice () {
        return price;
    }
    
    /**
     * Getter for taxRate
     * @return Tax rate of the item
     */
    public double getTaxRate () {
        return taxRate;
    }
    
    /**
     * Getter for validity
     * @return The validity of the item
     */
    public boolean getValidity () {
        return validity;
    }
}
