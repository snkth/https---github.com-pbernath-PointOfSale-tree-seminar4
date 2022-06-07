
package model;

import dto.SaleLogDTO;
import dto.SalesListDTO;
import integration.AccountingSystemHandler;
import integration.InventorySystemHandler;
import integration.PrinterHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is responsible for gathering all information about the sale and finalizing it, as well as 
 */
public class Sale {
    List<ListItem> theFinalList;
    int amountPaid;
    double totalPrice;
    int change;
    double totalTax;
    SalesListDTO salesListDTO;
    SaleLogDTO saleLogDTO;
    
    private List<SaleObserver> saleObservers = new ArrayList<>();
    
    /**
     * Initializes the Sale, fetches information from the SalesList and resets variables
     * @param salesList The SalesList to be processed into a Sale
     */
    public Sale (SalesList salesList) {
        fetchSalesListInfo(salesList);
        resetVariables();
    }
    
    /**
     * Finalizes the Sale, calculates change and constructs a immutable SaleLogDTO to use as a foundation for updating external systems and printing a receipt
     * @param amountPaid The money the customer pays the cashier
     * @param accountingSystemHandler The accounting system handler to process the update
     * @param inventorySystemHandler The inventory system to process the update
     * @param printerHandler The printer handler to process printing the receipt
     * @return The SaleLogDTO containing all relevant information regarding the Sale
     */
    public SaleLogDTO processSale (int amountPaid, AccountingSystemHandler accountingSystemHandler, InventorySystemHandler inventorySystemHandler, PrinterHandler printerHandler) {
        
        setAmountPaid(amountPaid);
        calculateChange();
        constructSaleLogDTO();
        updateExternalSystems(saleLogDTO, accountingSystemHandler, inventorySystemHandler);
        printReceipt(saleLogDTO, printerHandler);
        notifyObservers(saleLogDTO);
        return saleLogDTO;
    }
    
    private void fetchSalesListInfo (SalesList salesList) {
        salesListDTO = salesList.getSalesListDTO();
        theFinalList = salesListDTO.getTheItemList();
        totalPrice = salesListDTO.getTotalPrice();
        totalTax = salesListDTO.getTotalTax();
    }
    
    private void resetVariables () {
        amountPaid = 0;
        change = 0;
    }
    
    private void setAmountPaid (int amountPaid) {
        this.amountPaid = amountPaid;
    }
    
    private void calculateChange () {
        change = (int) Math.round(amountPaid - totalPrice);
    }
    
    private void constructSaleLogDTO () {
        saleLogDTO = new SaleLogDTO(theFinalList, amountPaid, totalPrice, change, totalTax);
    }
    
    private void updateExternalSystems (SaleLogDTO saleLogDTO, AccountingSystemHandler accountingSystemHandler, InventorySystemHandler inventorySystemHandler) {
        accountingSystemHandler.updateAccounting(saleLogDTO);
        inventorySystemHandler.updateInventory(saleLogDTO);
    }
    
    private void printReceipt (SaleLogDTO saleLogDTO, PrinterHandler printerHandler) {
        printerHandler.printReceipt(saleLogDTO);
    }
    
    private void notifyObservers (SaleLogDTO saleLogDTO) {
        for (SaleObserver obs : saleObservers) {
            obs.newSale(saleLogDTO);
        }
    }
    
    /**
     * 
     * @param obs 
     */
    public void addObservers (ArrayList<SaleObserver> obs) {
        for (SaleObserver newObs: obs) {
            saleObservers.add(newObs);
        }
    }
}
