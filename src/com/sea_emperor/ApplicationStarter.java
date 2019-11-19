package com.sea_emperor;

import com.sea_emperor.chef.ChefProvider;
import com.sea_emperor.factory.ItemData;
import com.sea_emperor.factory.ItemFactory;
import com.sea_emperor.order.OrderCreator;
import com.sea_emperor.preperation.FoodPreperator;
import com.sea_emperor.request.CreateOrderRequest;

import java.util.List;

public class ApplicationStarter
{
    List<ItemData> itemDataList;
    OrderCreator orderCreator;
    FoodPreperator foodPreperator;

    public static void main( String[] args )
    {
        ApplicationStarter applicationStarter = new ApplicationStarter();
        applicationStarter.doInitialTasks();
    }

    public void doInitialTasks()
    {
        itemDataList = getItemFactory().buildAndGetItems();
        setDependencies();
        CreateOrderRequest createOrderRequest = this.orderCreator.createOrder();
        foodPreperator.prepareOrder( createOrderRequest );

    }

    private void setDependencies()
    {
        orderCreator = new OrderCreator( itemDataList );
        foodPreperator = new FoodPreperator( new ChefProvider() );
    }

    public ItemFactory getItemFactory()
    {
        return new ItemFactory();
    }
}