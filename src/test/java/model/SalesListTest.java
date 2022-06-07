
package model;

import dto.ItemDTO;
import dto.SalesListDTO;
import exceptions.ItemInvalidException;

import java.util.ArrayList;
import java.util.List;
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
public class SalesListTest {
    private ItemDTO testItem;
    private ItemDTO otherTestItem;
    private ListItem listItemTest;
    private List<ListItem> theItemList;
    
    /**
     * a listItem has been created which will contain testItem and its quantity
     * this listItem will be put in theItemList which will be compared to the
     * add item function of the instance of saleslist
     */
    public SalesListTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.testItem = new ItemDTO(13, "bread", "bread desc", "bread category", 40, 1, true);
        this.otherTestItem = new ItemDTO(14, "milk", "milk desc", "dairy category", 23, 13, false);
        listItemTest = new ListItem(testItem, 1);
        this.theItemList = new ArrayList<ListItem>();
        theItemList.add(listItemTest);
    }
    
    @AfterEach
    public void tearDown() {
        this.testItem = null;
        this.theItemList = null;
    }
    
    /**
     * Test if exception is thrown addItem when only 1 item is being added, of class SalesList.
     */
    @Test
    public void testItemInvalidExceptionWithAddItem() {
        System.out.println("addItem");
        ItemDTO itemDTO = this.otherTestItem;
        int quantity = 1;
        SalesList instance = new SalesList();
        String expResult = "To user: Item scanned not found in the inventory system! Try Again!";
        try{
            SalesListDTO result = instance.addItem(itemDTO, quantity);
            fail("exception wasnt thrown");
        } catch(ItemInvalidException e){
            assertEquals(e.getMessage(), expResult);
        }
    }
    
    /**
     * Test if exception is thrown for addItem when 2 items is being added.
     */
    @Test
    public void testItemInvalidExceptionWithAddItemQuantity() {
        System.out.println("addItem");
        ItemDTO itemDTO = this.otherTestItem;
        int quantity = 1;
        SalesList instance = new SalesList();
        String expResult = "To user: Item scanned not found in the inventory system! Try Again!";
        try{
            SalesListDTO result = instance.addItem(itemDTO, quantity);
            result = instance.addItem(itemDTO, quantity);
            fail("exception wasnt thrown");
        } catch(ItemInvalidException e){
            assertEquals(e.getMessage(), expResult);
        }
    }
      /**
     * Test of addItem method, of class SalesList.
     * @throws ItemInvalidException
     */
    @Test
    public void testAddItem() throws ItemInvalidException {
        System.out.println("addItem");
        ItemDTO itemDTO = this.testItem;
        int quantity = 1;
        SalesList instance = new SalesList();
        SalesListDTO expResult = new SalesListDTO(theItemList, 0, 0);
        SalesListDTO result = instance.addItem(itemDTO, quantity);
        assertEquals(expResult.getTheItemList().get(0).getItemDTO().getItemID(), result.getTheItemList().get(0).getItemDTO().getItemID(), "Item was not added to the list");
    }
    
    /**
     * Tests if the quantity of the item increases.
     * @throws ItemInvalidException
     * 
     */
    @Test
    public void testAddItemQuantity() throws ItemInvalidException {
        System.out.println("addItem");
        ItemDTO itemDTO = this.testItem;
        int quantity = 1;
        SalesList instance = new SalesList();
        int expResult = 2;
        SalesListDTO result = instance.addItem(itemDTO, quantity);
        result = instance.addItem(itemDTO, quantity);
        assertEquals(expResult, result.getTheItemList().get(0).getItemQuantity(), "Quantity of item was not increased");
    }
    
    /**
     * Test if item is valid
     * 
    */
    @Test
    public void testItemIsValid() {
        System.out.println("addItem");
        ItemDTO instance = this.testItem;
        boolean expResult = true;
        boolean result = instance.getValidity();
        assertEquals(expResult, result, "Item validity is not true");
    }
    
    /**
     *  Test if item is invalid
     */
    @Test
    public void ItemIsNotValid() {
        System.out.println("addItem");
        ItemDTO instance = this.otherTestItem;
        boolean expResult = false;
        boolean result = instance.getValidity();
        assertEquals(expResult, result, "Item validity is not false");
    }
}
