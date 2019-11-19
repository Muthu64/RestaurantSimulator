package com.sea_emperor.factory;

import com.sea_emperor.request.ItemCategory;

public class ItemData
{
    private String itemName;
    private int timeToPrepareInMins;
    private ItemCategory itemCategory;

    public ItemData( String itemName, int timeToPrepareInMins, ItemCategory itemCategory )
    {
        this.itemName = itemName;
        this.timeToPrepareInMins = timeToPrepareInMins;
        this.itemCategory = itemCategory;
    }

    public String getItemName()
    {
        return itemName;
    }

    public int getTimeToPrepareInMins()
    {
        return timeToPrepareInMins;
    }

    public ItemCategory getItemCategory()
    {
        return itemCategory;
    }
}
