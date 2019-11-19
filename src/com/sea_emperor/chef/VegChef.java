package com.sea_emperor.chef;

import com.sea_emperor.request.Item;
import com.sea_emperor.request.ItemCategory;

public class VegChef implements Chef
{
    ItemCategory itemCategory = ItemCategory.VEG;

    @Override
    public void prepareFood( Item item )
    {
        System.out.println( getChefType() + " chef started preparing item --> " + item.getItemName() );
    }

    @Override
    public void updateEstimationTime( Item item )
    {

    }

    @Override
    public int getChefCount()
    {
        return itemCategory.getChefCount();
    }

    @Override
    public int availableChefCountAtTime()
    {
        return 0;
    }

    @Override
    public String getChefType()
    {
        return itemCategory.name();
    }
}
