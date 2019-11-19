package com.sea_emperor.order;

import com.sea_emperor.configurations.CommonConfigurations;
import com.sea_emperor.factory.ItemData;
import com.sea_emperor.request.Item;
import com.sea_emperor.request.ItemCategory;

import java.util.ArrayList;
import java.util.List;

public class ItemHelper
{
    private List<Item> items;
    private List<ItemData> itemDataList;

    public ItemHelper( List<Item> items, List<ItemData> itemDataList )
    {
        this.items = ( items == null ) ? new ArrayList<>() : items;
        this.itemDataList = itemDataList;
    }

    private void createVegItemAndAddToList()
    {
        filterItemAndAddToList( CommonConfigurations.VEG_BRIYANI, ItemCategory.VEG, 2 );
        filterItemAndAddToList( CommonConfigurations.CHAPPATHI, ItemCategory.VEG, 2 );
    }

    private void createNonVegItemAndAddToList()
    {
        filterItemAndAddToList( CommonConfigurations.CHICKEN_BRIYANI, ItemCategory.NON_VEG, 2 );
        filterItemAndAddToList( CommonConfigurations.FISH_FRY, ItemCategory.NON_VEG, 2 );
    }

    private void createJuiceItemAndAddToList()
    {
        filterItemAndAddToList( CommonConfigurations.APPLE_JUICE, ItemCategory.JUICE, 1 );
        //filterItemAndAddToList( items, itemDataList, CommonConfigurations.POMO_JUICE, ItemCategory.JUICE, 1 );
    }

    private void createSnacksItemAndAddToList()
    {
        filterItemAndAddToList( CommonConfigurations.BAJJI, ItemCategory.SNACKS, 2 );
        //filterItemAndAddToList( items, itemDataList, CommonConfigurations.CHAPPATHI, ItemCategory.SNACKS, 2 );
    }

    private void createTeaItemAndAddToList()
    {
        filterItemAndAddToList( CommonConfigurations.TEA, ItemCategory.TEA, 2 );
        //filterItemAndAddToList( items, itemDataList, CommonConfigurations.CHAPPATHI, ItemCategory.VEG, 2 );
    }

    private ItemData filterItemAndAddToList( String itemName, ItemCategory itemCategory )
    {
        ItemData filteredItemData = itemDataList.stream().filter( itemData -> itemData.getItemName().equals( itemName ) && itemData.getItemCategory() == itemCategory ).findFirst().get();

        return filteredItemData;
    }


    private void filterItemAndAddToList( String itemName, ItemCategory itemCategory, int quantity )
    {
        ItemData filteredItemData = itemDataList.stream().filter( itemData -> itemData.getItemName().equals( itemName ) && itemData.getItemCategory() == itemCategory ).findFirst().get();

        Item item = new Item( filteredItemData.getItemName(), quantity, itemCategory );
        items.add( item );
    }

    public void addItems()
    {
        createVegItemAndAddToList();
        createNonVegItemAndAddToList();
        createSnacksItemAndAddToList();
    }

    public List<Item> getItems()
    {
        return items;
    }
}
