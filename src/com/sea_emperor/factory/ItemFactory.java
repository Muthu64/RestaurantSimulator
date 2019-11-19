package com.sea_emperor.factory;

import java.util.List;

public class ItemFactory
{
    List<ItemData> itemDataList;

    public List<ItemData> buildAndGetItems()
    {
        ItemBuilder itemBuilder = new ItemBuilder();
        itemDataList = itemBuilder.BuildAllCategoryItems();
        System.out.println( itemDataList );
        return itemDataList;
    }

}
