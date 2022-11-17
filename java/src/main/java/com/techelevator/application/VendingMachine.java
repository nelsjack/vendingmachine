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
    Inventory inventory = new Inventory();
    public void run()
    {

        while(true)
        {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if(choice.equals("display"))
            {
                // display the vending machine slots
            }
            else if(choice.equals("purchase"))
            {
                // make a purchase
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
}
