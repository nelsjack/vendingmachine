package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    public static void displayMessage(String message)
    {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen()
    {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public static void displayInventoryPrintout(String slotIdentifier, String name, BigDecimal price, int amount) {
        System.out.println(slotIdentifier + " " + name + " Price: $" + price + " | Amount Remaining: " + amount);

    }

    public static void displayInventoryOutOfStock(String slotIdentifier, String name, BigDecimal price) {
        System.out.println(slotIdentifier + " " + name + " Price: $" + price + " | ITEM NO LONGER AVAILABLE");
    }

}
