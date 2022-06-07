
package integration;

import exceptions.DatabaseConnectionException;
import dto.ItemDTO;
import dto.SaleLogDTO;

/**
 * This class handles all calls to the external inventory system and formats information as to suit the external system when requesting or sending data
 */
public class InventorySystemHandler {
    
    /**
     * Fetches all information available about an item based on the itemID, and packages that as a DTO in return
     * @param itemID The identification number of the item to be fetched from the external database
     * @return A DTO containing all relevant information regarding the itemID sent to be fetched
     * @throws exceptions.DatabaseConnectionException
     */
    public ItemDTO getItem (int itemID) throws DatabaseConnectionException {
        
        if (itemID == 69) {
            throw new DatabaseConnectionException();
        }
        
        String itemName;
        String itemDescription;
        String itemCategory;
        double price;
        double taxRate;
        boolean validity;
        
        // call to database to fetch info
        // below is an example of information that could be returned
        
        itemName = "Name of item";
        itemDescription = "Description of item";
        itemCategory = "one of a number of categories";
        price = 80;
        taxRate = 0.25;
        validity = true;
        
        return new ItemDTO(itemID, itemName, itemDescription, itemCategory, price, taxRate, validity);
    }
    
    /**
     * Updates inventory status and logs the sale
     * @param saleLogDTO The finalized sale to be logged and used to update inventory status and statistics
     */
    public void updateInventory (SaleLogDTO saleLogDTO) {
        // updates inventory status
        
        // would not throw exception for no contact with database, but store the saleLogDTO to send whenever contact is reestablished in some reoccuring function
        
    }
}
