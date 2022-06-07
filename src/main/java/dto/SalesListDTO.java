
package dto;

import java.util.List;
import model.ListItem;

/**
 * Data Transfer Object (DTO) for the iterative non-finalized list of items to be sold. Information is immutable and cannot be changed once created, only read.
 */
public class SalesListDTO {
    private final List<ListItem> theItemList;
    private final double totalPrice;
    private final double totalTax;
    
    /**
     * Initializes the DTO. Once the parameters have been set, they cannot be changed.
     * @param theItemList The list of items and their quantities that has been added thus far
     * @param totalPrice The total price of all items and their quantities excluding taxes
     * @param totalTax The total amount of tax of all items and their quantities
     */
    public SalesListDTO (List<ListItem> theItemList, double totalPrice, double totalTax) {
        this.theItemList = theItemList;
        this.totalPrice = totalPrice;
        this.totalTax = totalTax;
    }
    
    /**
     * Getter for theItemList
     * @return The list of all items and their quantities
     */
    public List<ListItem> getTheItemList () {
        return theItemList;
    }
    
    /**
     * Getter for totalPrice
     * @return The total price for all items and their quantities excluding taxes
     */
    public double getTotalPrice () {
        return totalPrice;
    }
    
    /**
     * Getter for totalTax
     * @return The total amount of tax for all items and their quantities
     */
    public double getTotalTax () {
        return totalTax;
    }
}