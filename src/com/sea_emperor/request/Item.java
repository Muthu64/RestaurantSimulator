package com.sea_emperor.request;

public class Item
{
    private String itemName;
    private int quantity;
    private ItemCategory itemCategory;

    public Item( String itemName, int quantity, ItemCategory itemCategory )
    {
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemCategory = itemCategory;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public ItemCategory getItemCategory()
    {
        return itemCategory;
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", itemCategory=" + itemCategory +
                '}';
    }
}
