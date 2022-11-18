package com.techelevator.models;

import com.techelevator.ui.UserOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> listOfItem = new ArrayList<>();

    public Inventory(){}

    public void addToInventory(Item item){
    listOfItem.add(item);
}

    public List<Item> getListOfItem() {
        return listOfItem;
    }

    public void displayInventory() {
        for (Item currentItem : listOfItem) {
            String slotIdentifier = currentItem.getSlotIdentifier();
            String name = currentItem.getName();
            BigDecimal price = currentItem.getPrice();
            int amount = currentItem.getAmount();
            if (currentItem.getAmount() < 1) {
                UserOutput.displayInventoryOutOfStock(slotIdentifier, name, price);
            } else {
                UserOutput.displayInventoryPrintout(slotIdentifier, name, price, amount);
            }
        }
    }
}

// A6 U-Chews Price: $2.30 |NOT AVAILABLE