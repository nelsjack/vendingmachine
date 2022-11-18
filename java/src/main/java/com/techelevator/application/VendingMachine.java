package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class VendingMachine {
    private Inventory inventory = new Inventory();
    private BigDecimal moneyProvided = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_EVEN);
    private boolean discountAvailable = false;

    public void run() {

        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                // display the vending machine slots
                inventory.displayInventory();
            } else if (choice.equals("purchase")) {
                // make a purchase
                while (true) {
                    String purchaseChoice = UserInput.getPurchaseOption(moneyProvided);
                    if (purchaseChoice.equals("feed money")) {
                        BigDecimal fedMoney = UserInput.getFeedMoneyAmount();
                        moneyProvided = moneyProvided.add(fedMoney);
                    } else if (purchaseChoice.equals("select item")) {
                        // display inventory and allow user to input a slot identifier to pick item
                        inventory.displayInventory();
                        String userChoice = UserInput.selectItem();
                        int count = 0;
                        for (Item currentItem : inventory.getListOfItem()) {
                            if (currentItem.getSlotIdentifier().equals(userChoice)) {

                                if (checkForValidSelection(currentItem)) {
                                    // then, moneyProvided - price, .setAmount(.getAmount - 1)
                                    makePurchase(currentItem);
                                    currentItem.setAmount(currentItem.getAmount() - 1);
                                    UserOutput.displayDispensingMessage(currentItem.getName(), currentItem.getPrice(), moneyProvided, currentItem.getType());

                                } else if (currentItem.getAmount() < 1) {
                                    UserOutput.displayItemNoLongerAvailable();
                                } else if (moneyProvided.compareTo(currentItem.getPrice()) == -1) {
                                    UserOutput.displayNotEnoughFund();
                                }
                            } else {
                                count++;
                                if (count == inventory.getListOfItem().size()) {
                                    UserOutput.displayItemDoesNotExist();
                                }
                            }
                        }
                    } else if (purchaseChoice.equals("finish transaction")) {
                        returnChange();
                        break;
                    }
                }
            } else if (choice.equals("exit")) {
                // good bye
                break;
            }
        }
    }

    public void stock() {
        File inputFile = new File("catering.csv");

        try (Scanner stocksScanner = new Scanner(inputFile)) {
            while (stocksScanner.hasNextLine()) {
                String currentItemLine = stocksScanner.nextLine();
                String[] splitItemProperties = currentItemLine.split(",");
                String slotIdentifier = splitItemProperties[0];
                String name = splitItemProperties[1];
                BigDecimal price = new BigDecimal(splitItemProperties[2]);
                String type = splitItemProperties[3];
                Item currentItem = new Item(name, price, slotIdentifier, type);
                inventory.addToInventory(currentItem);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public boolean checkForValidSelection(Item item) {
        BigDecimal discount = new BigDecimal(1);
        BigDecimal discountedPrice = item.getPrice().subtract(discount);
        if (item.getAmount() > 0 && moneyProvided.compareTo(item.getPrice()) >= 0 || discountAvailable && item.getAmount() > 0 && moneyProvided.compareTo(discountedPrice) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public void makePurchase(Item item) {
        if (discountAvailable) {
            BigDecimal discount = new BigDecimal(1);
            BigDecimal discountedPrice = item.getPrice().subtract(discount);
            moneyProvided = moneyProvided.subtract(discountedPrice);
            discountAvailable = false;
        } else {
            moneyProvided = moneyProvided.subtract(item.getPrice());
            discountAvailable = true;
        }
    }

    public BigDecimal returnChange() {
        BigDecimal remainingChange = moneyProvided;
        int dollars = 0;
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        if (remainingChange.compareTo(new BigDecimal(1)) >= 0) {
            dollars = remainingChange.divide(new BigDecimal(1)).intValue();
            remainingChange = remainingChange.remainder(new BigDecimal(1));
        }
        if (remainingChange.compareTo(new BigDecimal(0.25)) >= 0) {
            quarters = remainingChange.divide(new BigDecimal(0.25)).intValue();
            remainingChange = remainingChange.remainder(new BigDecimal(0.25));
            System.out.println(remainingChange.compareTo(new BigDecimal(0.05)));
        }
        if (remainingChange.compareTo(new BigDecimal(0.10)) >= 0) {
            dimes = remainingChange.divide(new BigDecimal(0.10), 2, RoundingMode.HALF_EVEN).intValue();
            remainingChange = remainingChange.remainder(new BigDecimal("0.10"));
        }
        if (remainingChange.compareTo(new BigDecimal("0.05")) >= 0) {
            nickels = remainingChange.divide(new BigDecimal(0.05), 2, RoundingMode.HALF_EVEN).intValue();
        }

        System.out.println("Your change comes out to " + dollars + " dollars, " + quarters + " quarters, " + dimes + " dimes, and " + nickels + " nickels.");
        moneyProvided = new BigDecimal(0);
        return new BigDecimal(0);
    }
}


