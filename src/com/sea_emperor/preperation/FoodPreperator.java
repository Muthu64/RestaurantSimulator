package com.sea_emperor.preperation;

import com.sea_emperor.chef.Chef;
import com.sea_emperor.chef.ChefProvider;
import com.sea_emperor.request.CreateOrderRequest;
import com.sea_emperor.request.Item;

import java.util.Date;
import java.util.Objects;

public class FoodPreperator
{
    private ChefProvider chefProvider;

    public FoodPreperator( ChefProvider chefProvider )
    {
        Objects.requireNonNull( chefProvider, "chefProvider must not be null" );
        this.chefProvider = chefProvider;
    }

    public Date prepareOrder( CreateOrderRequest createOrderRequest )
    {
        for ( Item item : createOrderRequest.getItems() ) {
            this.assignTaskToChef( item );
        }
        return new Date();
    }


    private void assignTaskToChef( Item item )
    {
        Chef chef = chefProvider.getChef( item.getItemCategory() );
        chef.prepareFood( item );
    }
}
