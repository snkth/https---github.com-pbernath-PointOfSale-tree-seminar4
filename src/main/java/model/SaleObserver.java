
package model;

import dto.SaleLogDTO;

/**
 *
 * @author Peter
 */
public interface SaleObserver {
    
    void newSale (SaleLogDTO saleLogDTO);
}
