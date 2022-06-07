
package model;

import dto.ItemDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Peter
 */
public class ListItemTest {
    private ListItem listItemTest;
    private ItemDTO testItem;
    
    public ListItemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.testItem = new ItemDTO(12, "bread", "bread", "bread", 40, 12, true);
        this.listItemTest = new ListItem(testItem, 1);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addQuantity method, of class ListItem.
     */
    @Test
    public void testAddQuantity() {
        System.out.println("addQuantity");
        int quantityToAdd = 1;
        ListItem instance = this.listItemTest;
        instance.addQuantity(quantityToAdd);
        int result = instance.quantity;
        int expResult = 2; 
        assertEquals(expResult, result, "Computed the quantity wrong");
    }
    
}
