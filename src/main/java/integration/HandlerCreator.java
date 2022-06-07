
package integration;



/**
 * The handlerCreator is responsible for creating and administering the handler that handle calls to databases, external systems or external I/O (such as the printer), it also contains the references to those handlers.
 */
public class HandlerCreator {
    private final AccountingSystemHandler accountingSystemHandler;
    private final CustomerDatabaseHandler customerDatabaseHandler;
    private final DiscountDatabaseHandler discountDatabseHandler;
    private final InventorySystemHandler inventorySystemHandler;
    private final PrinterHandler printerHandler;

    
    /**
     * Initializes the handlerCreator that also creates classes for the external systems it needs to reference
     */
    public HandlerCreator() {
        accountingSystemHandler = new AccountingSystemHandler();
        customerDatabaseHandler = new CustomerDatabaseHandler();
        discountDatabseHandler = new DiscountDatabaseHandler();
        inventorySystemHandler = new InventorySystemHandler();
        printerHandler = new PrinterHandler();
    }
    
    /**
     * Getter for accountingSystemHandler
     * @return The class used to communicate with the external accounting system
     */
    public AccountingSystemHandler getAccountingSystemHandler() {
        return this.accountingSystemHandler;
    }
    
    /**
     * Getter for customerDatabaseHandler
     * @return The class used to communicate with the external customer database
     */
    public CustomerDatabaseHandler getCustomerDatabaseHandler() {
        return this.customerDatabaseHandler;
    }
    
    /**
     * Getter for discountDatabseHandler
     * @return The class used to communicate with the external discount database
     */
    public DiscountDatabaseHandler getDiscountDatabaseHandler() {
        return this.discountDatabseHandler;
    }
    
    /**
     * Getter for inventorySystemHandler
     * @return The class used to communicate with the external inventory system
     */
    public InventorySystemHandler getInventorySystemHandler() {
        return this.inventorySystemHandler;
    }
    
    /**
     * Getter for printerHandler
     * @return The class used to communicate with the external printer
     */
    public PrinterHandler getPrinterHandler() {
        return this.printerHandler;
    }
}