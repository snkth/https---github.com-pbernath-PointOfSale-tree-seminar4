
package view;

import dto.SaleLogDTO;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import model.SaleObserver;


/**
 *
 * @author Peter
 */
public class TotalRevenueFileOutput implements SaleObserver{
    int totalNumberOfSales = 0;
    double totalRevenue = 0;
    
    private static final String LOG_FILE_NAME = "log.txt";
    private PrintWriter logFile;
    
    
    public TotalRevenueFileOutput () {
        try {
            logFile = new PrintWriter(new FileWriter(LOG_FILE_NAME, true), true);
        } catch (IOException ex) {
            System.out.println("Developer Log: Could not create the Log Handler when running startup.");
        }
    }
    
    
    @Override
    public void newSale (SaleLogDTO saleLogDTO) {
        addNewSale (saleLogDTO);
        outputTotalRevenue ();
    }
    
    private void addNewSale (SaleLogDTO saleLogDTO) {
        totalNumberOfSales++;
        totalRevenue += saleLogDTO.getTotalPrice();
    }
    
    private void outputTotalRevenue () {
        logFile.println("We have made a total of " + totalNumberOfSales + " sales with a total revenue of " + totalRevenue);
    }
}
