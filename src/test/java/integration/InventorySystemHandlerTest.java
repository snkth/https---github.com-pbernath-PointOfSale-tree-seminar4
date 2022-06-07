package integration;

import exceptions.DatabaseConnectionException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Peter
 */
public class InventorySystemHandlerTest {
    
    public InventorySystemHandlerTest() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getItem method, of class InventorySystemHandler.
     * @throws DatabaseConnectionException
     */
    @Test
    public void testGetItem() throws DatabaseConnectionException {
        System.out.println("getItem");
        int itemID = 1;
        InventorySystemHandler instance = new InventorySystemHandler();
        String expResult = "Name of item" ;
        String result = instance.getItem(itemID).getItemName();
        assertEquals(expResult, result, "Function did not manage to get any item.");
    }
    @Test
    public void testGetItemDatabaseConnectionException() {
        System.out.println("getItem");
        int itemID = 69;
        InventorySystemHandler instance = new InventorySystemHandler();
        String expResult = "Developer log: Connection to inventory system failed at " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES) + " and through IP-address '8.8.8.8'.";
        try {
            String result = instance.getItem(itemID).getItemName();
            fail("DatabaseConnectionException was not thrown");
        }catch(DatabaseConnectionException e){
            assertEquals(expResult, e.getMessage());

        }
    }
}