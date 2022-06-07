
package view;

import dto.SaleLogDTO;
import model.SaleObserver;

/**
 *
 * @author Peter
 */
public class TotalRevenueView implements SaleObserver{
    int totalNumberOfSales = 0;
    double totalRevenue = 0;
    
    @Override
    public void newSale (SaleLogDTO saleLogDTO) {
        addNewSale (saleLogDTO);
        printTotalRevenue ();
    }
    
    private void addNewSale (SaleLogDTO saleLogDTO) {
        totalNumberOfSales++;
        totalRevenue += saleLogDTO.getTotalPrice();
    }
    
    private void printTotalRevenue () {
        System.out.println("To a view: We have made a total of " + totalNumberOfSales + " sales with a total revenue of " + totalRevenue);
    }
}
