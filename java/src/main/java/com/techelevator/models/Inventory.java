package com.techelevator.models;

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
            if (currentItem.getAmount() < 1) {
                System.out.println(currentItem.getSlotIdentifier() + " " + currentItem.getName() + " Price: $" + currentItem.getPrice() + " | ITEM NO LONGER AVAILABLE");
            } else {
                System.out.println(currentItem.getSlotIdentifier() + " " + currentItem.getName() + " Price: $" + currentItem.getPrice() + " | Amount Remaining: " + currentItem.getAmount());
            }
        }
    }
}

// A6 U-Chews Price: $2.30 |NOT AVAILABLE