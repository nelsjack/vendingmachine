package com.techelevator.ui;

import com.techelevator.VendingMachineCLI;
import com.techelevator.application.VendingMachine;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {

    private static Scanner scanner = new Scanner(System.in);

    public static String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Vending Machine Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("D")) {
            return "display";
        } else if (option.equals("P")) {
            return "purchase";
        } else if (option.equals("E")) {
            return "exit";
        } else {
            return "";
        }

    }

    public static String getPurchaseOption(BigDecimal moneyProvided) {
        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        System.out.println("Current Money Provided: $" + moneyProvided);
        System.out.println();
        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toUpperCase();

        if (option.equals("M")) {
            return "feed money";
        } else if (option.equals("S")) {
            return "select item";
        } else if (option.equals("F")) {
            return "finish transaction";
        } else {
            return "";
        }
    }

    public static BigDecimal getFeedMoneyAmount() {
        System.out.print("Please enter a whole dollar amount: ");
        String money = scanner.nextLine();
        if(money.equals("1") || money.equals("5") || money.equals("10") || money.equals("20") || money.equals("50") || money.equals("100")) {
            BigDecimal moneyFed = new BigDecimal(money);
            return moneyFed;
        } else {
            UserOutput.displayInvalidBill();
            return new BigDecimal(0);
        }
    }

    public static String selectItem() {
        System.out.println("Please select a menu item: ");
        String option = scanner.nextLine();
        return option;
    }

}


