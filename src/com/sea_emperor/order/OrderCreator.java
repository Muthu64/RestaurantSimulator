package com.sea_emperor.order;

import com.sea_emperor.factory.ItemData;
import com.sea_emperor.request.CreateOrderRequest;
import com.sea_emperor.request.Item;

import java.util.Date;
import java.util.List;

public class OrderCreator
{
    CreateOrderRequest createOrderRequest;

    ItemHelper itemHelper;

    public OrderCreator( List<ItemData> itemDataList )
    {
        this.itemHelper = new ItemHelper( null, itemDataList );
    }

    public List<Item> addItemsToOrder()
    {
        this.itemHelper.addItems();
        return itemHelper.getItems();
    }


    public CreateOrderRequest createOrder()
    {
        List<Item> itemList = this.addItemsToOrder();
        CreateOrderRequest createOrderRequest = new CreateOrderRequest( itemList, new Date() );
        System.out.println( createOrderRequest );
        return createOrderRequest;
    }
}
