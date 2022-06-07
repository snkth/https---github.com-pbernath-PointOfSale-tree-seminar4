
package integration;

import dto.SaleLogDTO;

/**
 * This class handles all calls to the external accounting system and formats information as to suit the external system when requesting or sending data
 */
public class AccountingSystemHandler {
    
    /**
     * Updates both cash register and general finances, as well as logging the sale
     * @param saleLogDTO The finalized sale to be logged and used to update finances and cash register
     */
    public void updateAccounting (SaleLogDTO saleLogDTO) {
        // logs sale
        // updates accounting
        // updates cash register
    }
}
