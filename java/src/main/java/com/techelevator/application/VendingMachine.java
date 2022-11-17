package com.techelevator.application;

import com.techelevator.models.Inventory;
import com.techelevator.models.Item;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachine 
{
    private Inventory inventory = new Inventory();
    private BigDecimal moneyProvided = new BigDecimal(0);

    public void run() {

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();
            String purchaseChoice = UserInput.getPurchaseOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
                inventory.displayInventory();
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
                while(true) {
                    if(purchaseChoice.equals("feed money")) {

                    }
                    else if(purchaseChoice.equals("select item")) {

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

    public BigDecimal getMoneyProvided() {
        return moneyProvided;
    }
}
