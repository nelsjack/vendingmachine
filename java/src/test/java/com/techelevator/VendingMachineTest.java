package com.techelevator;

import com.techelevator.application.VendingMachine;
import com.techelevator.models.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class VendingMachineTest {
    private VendingMachine vendingMachine;

    @Before
    public void Setup() {
        vendingMachine = new VendingMachine();

    }

    @Test
    public void checkForValidSelection_returns_true_when_passed_UChews() {
        Item item = new Item("U-chews", new BigDecimal("1.65"), "A1", "Gum");
        vendingMachine.setMoneyProvided(new BigDecimal(5));
        boolean result = vendingMachine.checkForValidSelection(item);
        Assert.assertTrue(result);
    }

    @Test
    public void checkForValidSelection_returns_false_when_passed_UChews() {
        Item item = new Item("U-chews", new BigDecimal("1.65"), "A1", "Gum");
        boolean result = vendingMachine.checkForValidSelection(item);
        Assert.assertFalse(result);

    }

    @Test
    public void checkForValidSelection_returns_true_when_passed_UChews_and_discountAvailable() {
        Item item = new Item("U-chews", new BigDecimal("1.65"), "A1", "Gum");
        vendingMachine.setMoneyProvided(new BigDecimal(1));
        vendingMachine.setDiscountAvailable(true);
        boolean result = vendingMachine.checkForValidSelection(item);
        Assert.assertTrue(result);
    }
    @Test
    public void returnChange_returns_proper_change_6dollars_15cents(){
        vendingMachine.setMoneyProvided(new BigDecimal(6.15));
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("dollars", 6);
        expectedMap.put("quarters", 0);
        expectedMap.put("dimes", 1);
        expectedMap.put("nickels", 1);
        Assert.assertEquals(expectedMap, vendingMachine.returnChange());
    }
    @Test
    public void returnChange_returns_proper_change_4dollars_95cents(){
        vendingMachine.setMoneyProvided(new BigDecimal(4.95));
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("dollars", 4);
        expectedMap.put("quarters", 3);
        expectedMap.put("dimes", 2);
        expectedMap.put("nickels", 0);
        Assert.assertEquals(expectedMap, vendingMachine.returnChange());
    }
    @Test
    public void returnChange_returns_proper_change_0dollars_0cents(){
        vendingMachine.setMoneyProvided(new BigDecimal(0.00));
        Map<String,Integer> expectedMap = new HashMap<>();
        expectedMap.put("dollars", 0);
        expectedMap.put("quarters", 0);
        expectedMap.put("dimes", 0);
        expectedMap.put("nickels", 0);
        Assert.assertEquals(expectedMap, vendingMachine.returnChange());
    }
    @Test
public void formatTransactionSpaces_returns_6spaces_when_pass_Wonka_Bar(){
        String itemName = "Wonka Bar";
        String expectedString = "      ";
        String result = vendingMachine.formatTransactionSpaces(itemName);
        Assert.assertEquals(expectedString,result);
    }
    @Test
    public void formatTransactionSpaces_returns_8spaces_when_pass_popcorn(){
        String itemName = "popcorn";
        String expectedString = "        ";
        String result = vendingMachine.formatTransactionSpaces(itemName);
        Assert.assertEquals(expectedString,result);
    }
    @Test
    public void formatTransactionSpaces_returns_an_empty_string_when_pass_popcorn_Wonka_Bar_U_Chew_pepsi(){
        String itemName = "popcorn Wonka Bar U chew pepsi";
        String expectedString = "";
        String result = vendingMachine.formatTransactionSpaces(itemName);
        Assert.assertEquals(expectedString,result);
    }
}

