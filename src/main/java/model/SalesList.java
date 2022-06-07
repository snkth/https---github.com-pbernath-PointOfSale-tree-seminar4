
package model;

import dto.ItemDTO;
import dto.SalesListDTO;
import exceptions.ItemInvalidException;
import java.util.*;

/**
 * Contains the iterative non-finalized list of items to be sold with totalPrice and totalTax to be able to show a running tally of the accumulated price.
 */
public class SalesList {
    private final List<ListItem> theItemList;
    private double totalPrice;
    private double totalTax;
    
    /**
     * Initializes the class with an empty list and no prices or taxes
     */
    public SalesList() {
        theItemList = new ArrayList<>();
        updatePrice();
    }
    
    /**
     * Either adds the item with the quantity to the list if it is not yet present or adds the quantity if it is.
     * @param itemDTO The item data transfer object to be added to the list.
     * @param quantity The amount of the item to be added to the list
     * @return A new iterated SalesListDTO for keeping a running tally
     * @throws exceptions.ItemInvalidException Throws exception if item is not valid
     */
    public SalesListDTO addItem (ItemDTO itemDTO, int quantity) throws ItemInvalidException{
        if (itemDTO.getValidity() == false) {
            throw new ItemInvalidException (itemDTO);
        }
        
        addItemToList(itemDTO, quantity);
        return getSalesListDTO();
    }
    
    /**
     * Updates price and tax then creates a new SalesListDTO to return
     * @return A new updated SalesListDTO
     */
    SalesListDTO getSalesListDTO () {
        updatePrice();
        return new SalesListDTO(theItemList, totalPrice, totalTax);
    }
    
    private void addItemToList (ItemDTO itemDTO, int quantity) {
        boolean present = false;
        for (ListItem i : theItemList) {
            if (itemDTO.getItemID() == i.itemDTO.getItemID()) {
                present = true;
                i.addQuantity(quantity);
                break;
            }
        }
        if (present == false) {
            theItemList.add(new ListItem(itemDTO,quantity));
        }
    }
    
    private void updatePrice() {
        totalPrice = 0;
        totalTax = 0;
        for (ListItem i : theItemList) {
            double itemPrice = i.itemDTO.getPrice();
            double itemTaxRate = i.itemDTO.getTaxRate();
            int quantity = i.quantity;

            double itemAddedTax = itemPrice * itemTaxRate;
            
            totalTax += quantity * itemAddedTax;
            totalPrice += quantity * (itemPrice + itemAddedTax);
        }
    }
}
