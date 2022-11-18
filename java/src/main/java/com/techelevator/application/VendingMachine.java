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

public class VendingMachine
{
    private Inventory inventory = new Inventory();
    private BigDecimal moneyProvided = new BigDecimal(0.00).setScale(2, RoundingMode.HALF_EVEN);

    public void run() {

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                inventory.displayInventory();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                while(true) {
                    String purchaseChoice = UserInput.getPurchaseOption(moneyProvided);
                    if(purchaseChoice.equals("feed money")) {
                        BigDecimal fedMoney =  UserInput.getFeedMoneyAmount();
                        moneyProvided =  moneyProvided.add(fedMoney);
                    }
                    else if(purchaseChoice.equals("select item")) {
                        // display inventory and allow user to input a slot identifier to pick item
                        inventory.displayInventory();
                        String userChoice = UserInput.selectItem();
                        for(Item currentItem : inventory.getListOfItem()) {
                            if(currentItem.getSlotIdentifier().equals(userChoice)) {
                                if (checkForValidSelection(currentItem)) {
                                    // then, moneyProvided - price, .setAmount(.getAmount - 1)
                                    // UserOutput.displayDispensingMessage(name, price, moneyProvided)
                                } else if(currentItem.getAmount() < 1) {
                                    // sout NOT AVAILABLE
                                } else if(moneyProvided.compareTo(currentItem.getPrice()) == -1) {
                                    // sout Insert more funds
                                }

                            }
                        }
                    }
                    else if(purchaseChoice.equals("finish transaction")) {
                        break;
                    }
                }
            }
            else if(choice.equals("exit"))
            {
                // good bye
                break;
            }
        }
    }

    public void stock(){
        File inputFile = new File("catering.csv");

      try (Scanner stocksScanner = new Scanner(inputFile)){
        while (stocksScanner.hasNextLine()){
            String currentItemLine = stocksScanner.nextLine();
            String [] splitItemProperties = currentItemLine.split(",");
            String slotIdentifier = splitItemProperties[0];
            String name = splitItemProperties[1];
            BigDecimal price = new BigDecimal(splitItemProperties[2]);
            String type = splitItemProperties[3];
            Item currentItem = new Item(name, price, slotIdentifier, type);
            inventory.addToInventory(currentItem);
        }
      }
      catch (FileNotFoundException e){
          System.out.println("File not found.");
      }
    }

    public boolean checkForValidSelection(Item item) {
        if (item.getAmount() > 0 && moneyProvided.compareTo(item.getPrice()) >= 0) {
            return true;
        } else {
            return false;
        }
    }

}




