package com.techelevator.models;

import java.math.BigDecimal;

public class Item {
    private String name;
    private BigDecimal price;
    private String slotIdentifier;
    private int amount=6;
    private String type;

    public Item(String name, BigDecimal price, String slotIdentifier, String type) {
        this.name = name;
        this.price = price;
        this.slotIdentifier = slotIdentifier;
        this.type = type;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSlotIdentifier() {
        return slotIdentifier;
    }

    public void setSlotIdentifier(String slotIdentifier) {
        this.slotIdentifier = slotIdentifier;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
