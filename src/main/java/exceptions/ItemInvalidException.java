
package exceptions;

import dto.ItemDTO;

/**
 *
 * @author Peter
 */
public class ItemInvalidException extends Exception {
    
    public ItemInvalidException (ItemDTO itemDTO){
        super("To user: Item scanned not found in the inventory system! Try Again!");
    }
}
