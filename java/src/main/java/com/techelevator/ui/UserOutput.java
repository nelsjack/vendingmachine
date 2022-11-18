package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Map;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput {

    public static void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
        System.out.println();
    }

    public static void displayHomeScreen() {
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

    public static void displayDispensingMessage(String name, BigDecimal price, BigDecimal moneyRemaining, String type) {
        System.out.println("Dispensing " + name + " " + price + ". money Remaining: " + moneyRemaining);
        if (type.equals("Munchy")) {
            System.out.println("Munchy, Munchy, So Good!");
        }
        if (type.equals("Candy")) {
            System.out.println("Sugar, Sugar, So Sweet!");
        }
        if (type.equals("Drink")) {
            System.out.println("Drinky, Drinky, Slurp Slurp!");
        }
        if (type.equals("Gum")) {
            System.out.println("Chewy, Chewy, Lots O Bubbles!");
        }
    }

    public static void displayItemDoesNotExist() {
        System.out.println("slot identifier does not match item!");
    }

    public static void displayItemNoLongerAvailable() {
        System.out.println("display item no longer available!");
    }
    public static void displayNotEnoughFund(){
        System.out.println("fund is not enough!");
    }

    public static void displayInvalidBill() {
        System.out.println("Please enter a valid bill");
    }

}

