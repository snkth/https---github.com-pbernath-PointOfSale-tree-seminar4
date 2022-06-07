
package view;

import controller.Controller;
import dto.SaleLogDTO;
import exceptions.DatabaseConnectionException;
import exceptions.ItemInvalidException;
import java.time.format.*;






/**
 * This class represents the part of the program that the user (a cashier) would interact with
 */
public class View {
    private final Controller controller;
    
    /**
     * Initializes the only instance of the view class.
     * @param controller The controller the view should interact with and send commands to
     */
    public View (Controller controller) {
        this.controller = controller;
        controller.addSaleObserver(new TotalRevenueView());
        controller.addSaleObserver(new TotalRevenueFileOutput());
    }
    
    /**
     * Runs a fictitious execution of the functions in controller that the view would generally call and prints a message to System.out after each call
     */
    public void runFakeExecution () {
        controller.startSale();
        System.out.println("To user: A new sale has been started");
        
        int anItemID = 69;
        int aItemQuantity = 1;
        System.out.println("To user: Scanned itemID " + anItemID + " with quantity " + aItemQuantity);
        try {
            controller.scanItem(anItemID, aItemQuantity);
        } catch (ItemInvalidException ex) {
            System.out.println( ex.getMessage());
        } catch (DatabaseConnectionException ex) {
            System.out.println("To user: Could not scan item. Try Again!");
            System.out.println( ex.getMessage());
        }
        controller.endSale();
        System.out.println("To user: The current sale is ending");
        
        int anAmountPaid = 1000;
        SaleLogDTO theLog = controller.processSale(anAmountPaid);
        System.out.println("To user: Sale is processed at " + theLog.getTimestamp().format(DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM)) + ", customer paid " + anAmountPaid + " for " + theLog.getTheFinalList().size() + " items, and got a change of " + theLog.getChange() + " back");
    }
}
