package com.techelevator.models;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
private List<Item> listOfItem = new ArrayList<>();
public Inventory(){

}
public void addToInventory(Item item){
    listOfItem.add(item);
}
}
