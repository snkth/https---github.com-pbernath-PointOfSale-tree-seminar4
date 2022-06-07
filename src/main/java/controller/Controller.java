
package controller;



import integration.HandlerCreator;
import integration.AccountingSystemHandler;
import integration.CustomerDatabaseHandler;
import integration.DiscountDatabaseHandler;
import integration.InventorySystemHandler;
import integration.PrinterHandler;
import model.SalesList;
import model.Sale;
import dto.ItemDTO;
import dto.SaleLogDTO;
import dto.SalesListDTO;
import exceptions.DatabaseConnectionException;
import exceptions.ItemInvalidException;
import java.util.ArrayList;
import java.util.List;
import model.SaleObserver;

/**
 * The programs only controller and is only receiving calls from the view
 */
public class Controller {
    private final HandlerCreator handlerCreator;
    private final AccountingSystemHandler accountingSystemHandler;
    private final CustomerDatabaseHandler customerDatabaseHandler;
    private final DiscountDatabaseHandler discountDatabseHandler;
    private final InventorySystemHandler inventorySystemHandler;
    private final PrinterHandler printerHandler;
    private SalesList salesList;
    private Sale sale;
    
    private ArrayList<SaleObserver> saleObservers = new ArrayList<>();
    
    /**
     * Initializes the programs only controller that is used to relay calls from the view to the rest of the system
     * @param handlerCreator The handlerCreator that is responsible for creating the handlers that handle calls to databases or I/O, it also contains the references to those handlers
     */
    public Controller (HandlerCreator handlerCreator) {
        this.handlerCreator = handlerCreator;
        this.accountingSystemHandler = handlerCreator.getAccountingSystemHandler();
        this.customerDatabaseHandler = handlerCreator.getCustomerDatabaseHandler();
        this.discountDatabseHandler = handlerCreator.getDiscountDatabaseHandler();
        this.inventorySystemHandler = handlerCreator.getInventorySystemHandler();
        this.printerHandler = handlerCreator.getPrinterHandler();
    }
    
    /**
     * Initializes a new blank sale to be filled with items. This function must be called before items can be scanned with scanItem.
     */
    public void startSale () {
        this.salesList = new SalesList();
    }
    
    /**
     * Adds the specified amount of items to the sale initialized earlier
     * @param itemID The itemID scanned or entered manually
     * @param quantity The amount of items with the same itemID to be added at the same time
     * @return 
     * @throws exceptions.ItemInvalidException Throws exception if item is not verified
     */
    public SalesListDTO scanItem (int itemID, int quantity) throws ItemInvalidException, DatabaseConnectionException{
        ItemDTO itemDTO = inventorySystemHandler.getItem(itemID);
        
        return salesList.addItem(itemDTO, quantity);
        
    }
    
    /**
     * Finalizes the list of items to be sold and prepares to receive payment. Must be called before receiving payment from customer.
     */
    public void endSale () {
        this.sale = new Sale(salesList);
        this.sale.addObservers(saleObservers);
    }
    
    /**
     * Finalizes and finished the sale after payment has been received (from the customer). This includes updating inventory and accounting as well as printing a receipt. Must be called after endSale that finalizes the list of items to be sold.
     * @param amountPaid The amount paid in cash to the cashier
     * @return 
     */
    public SaleLogDTO processSale (int amountPaid) {
        return sale.processSale(amountPaid, accountingSystemHandler, inventorySystemHandler, printerHandler);
    }
    
    public void addSaleObserver (SaleObserver obs) {
        saleObservers.add(obs);
    }
}
