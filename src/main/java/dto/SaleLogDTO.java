
package dto;

import java.time.LocalDateTime;
import java.util.List;
import model.ListItem;

/**
 * Data Transfer Object (DTO) for the finalized sale containing all relevant information. Information is immutable and cannot be changed once created, only read.
 */
public class SaleLogDTO {
    private final List<ListItem> theFinalList;
    private final int amountPaid;
    private final double totalPrice;
    private final int change;
    private final double totalTax;
    private final LocalDateTime timestamp;
    
    /**
     * Initializes the DTO. Once the parameters have been set, they cannot be changed.
     * @param theFinalList The list of items and quantities that have been sold
     * @param amountPaid The amount of money the customer has handed the cashier
     * @param totalPrice The final cost of the sale excluding taxes
     * @param change The amount of money the cashier need to return to the customer
     * @param totalTax The final sum of taxes
     */
    public SaleLogDTO (List<ListItem> theFinalList, int amountPaid, double totalPrice, int change, double totalTax) {
        this.theFinalList = theFinalList;
        this.amountPaid = amountPaid;
        this.totalPrice = totalPrice;
        this.change = change;
        this.totalTax = totalTax;
        timestamp = LocalDateTime.now();
    }
    
    /**
     * Getter for theFinalList
     * @return The list of all items and quantities in the finalizes sale
     */
    public List<ListItem> getTheFinalList () {
        return theFinalList;
    }
    
    /**
     * Getter for amountPaid
     * @return The amount or money the customer paid the cashier
     */
    public int getAmountPaid () {
        return amountPaid;
    }
    
    /**
     * Getter for totalPrice
     * @return The total price of all items and quantities excluding taxes
     */
    public double getTotalPrice () {
        return totalPrice;
    }
    
    /**
     * Getter for change
     * @return The change the cashier gave back to the customer
     */
    public int getChange () {
        return change;
    }
    
    /**
     * Getter for totalTax
     * @return The total tax for all items and quantities
     */
    public double getTotalTax () {
        return totalTax;
    }
    
    /**
     * Getter for timestamp
     * @return The time this DTO and thus the sale of items was created and finalized
     */
    public LocalDateTime getTimestamp () {
        return timestamp;
    }
}
