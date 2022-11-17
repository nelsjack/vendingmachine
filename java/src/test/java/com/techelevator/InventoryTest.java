package com.techelevator;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class InventoryTest {
private Inventory inventory;
    List<Item> listOfItem = new ArrayList<>();
@Before
    public void setup (){

    inventory = new Inventory();

}



    @Test

    public void addToInventory_adds_crackers(){
        BigDecimal price = new BigDecimal(1);
    Item cracker = new Item("cracker", price, "A6", "munchy");
    inventory.addToInventory(cracker);
    List<Item> expectedList = new ArrayList<>();
    expectedList.add(cracker);
        Assert.assertEquals(expectedList, inventory.getListOfItem());
    }
}
