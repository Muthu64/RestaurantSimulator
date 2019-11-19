package com.sea_emperor.factory;

import com.sea_emperor.configurations.CommonConfigurations;
import com.sea_emperor.request.ItemCategory;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder
{
    private List<ItemData> itemDataList;

    ItemBuilder()
    {
        itemDataList = new ArrayList<>();
    }

    public ItemBuilder createNonVegItems()
    {
        ItemData chicken_briyani = new ItemData( CommonConfigurations.CHICKEN_BRIYANI, 10, ItemCategory.NON_VEG );
        ItemData fish_fry = new ItemData( CommonConfigurations.FISH_FRY, 15, ItemCategory.NON_VEG );
        itemDataList.add( chicken_briyani );
        itemDataList.add( fish_fry );

        return this;
    }

    public ItemBuilder createVegItems()
    {

        ItemData veg_briyani = new ItemData( CommonConfigurations.VEG_BRIYANI, 10, ItemCategory.VEG );
        ItemData chappathi = new ItemData( CommonConfigurations.CHAPPATHI, 5, ItemCategory.VEG );
        itemDataList.add( veg_briyani );
        itemDataList.add( chappathi );
        return this;
    }

    public ItemBuilder createSnacksItems()
    {

        ItemData samosa = new ItemData( CommonConfigurations.SAMOSA, 10, ItemCategory.SNACKS );
        ItemData bajji = new ItemData( CommonConfigurations.BAJJI, 5, ItemCategory.SNACKS );
        ItemData sandwich = new ItemData( CommonConfigurations.SANDWICH, 5, ItemCategory.SNACKS );

        itemDataList.add( samosa );
        itemDataList.add( bajji );
        itemDataList.add( sandwich );
        return this;

    }

    public ItemBuilder createTeaItems()
    {

        ItemData tea = new ItemData( CommonConfigurations.TEA, 10, ItemCategory.TEA );
        ItemData coffee = new ItemData( CommonConfigurations.COFFEE, 10, ItemCategory.TEA );
        itemDataList.add( tea );
        itemDataList.add( coffee );

        return this;

    }

    public ItemBuilder createJuiceItems()
    {

        ItemData appleJuice = new ItemData( "Apple Juice", 10, ItemCategory.SNACKS );
        ItemData pomoJuice = new ItemData( "Pomo Juice", 10, ItemCategory.SNACKS );
        itemDataList.add( appleJuice );
        itemDataList.add( pomoJuice );
        return this;

    }

    public List<ItemData> BuildAllCategoryItems()
    {
        this.createVegItems();
        this.createNonVegItems();
        this.createJuiceItems();
        this.createSnacksItems();
        this.createTeaItems();
        return getItemDataList();
    }

    public List<ItemData> getItemDataList()
    {
        return itemDataList;
    }

    @Override
    public String toString()
    {
        return "ItemBuilder{" +
                "itemDataList=" + itemDataList +
                '}';
    }
}
