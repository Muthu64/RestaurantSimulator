package com.sea_emperor.chef;

import com.sea_emperor.factory.ItemFactory;
import com.sea_emperor.order.ItemHelper;
import com.sea_emperor.request.Item;
import com.sea_emperor.request.ItemCategory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.BlockingDeque;

public class NonVegChef implements Chef
{
    ItemCategory itemCategory = ItemCategory.NON_VEG;

   public static List<Item> chefList = new ArrayList( ItemCategory.NON_VEG.getChefCount() );
   public static int estimationTime = 0;

    @Override
    public void prepareFood( Item item )
    {
        System.out.println( getChefType() + " chef started preparing item --> " + item.getItemName() );

        if(chefList.size() == 0 )
        {
            updateEstimationTime( item );
        }

    }

    @Override
    public void updateEstimationTime( Item item )
    {
        //return chefList.
    }

    @Override
    public int getChefCount()
    {
        return itemCategory.getChefCount();
    }

    @Override
    public int availableChefCountAtTime()
    {
        return chefList.size();
    }

    @Override
    public String getChefType()
    {
        return itemCategory.name();
    }
}
