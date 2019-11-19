package com.sea_emperor.chef;

import com.sea_emperor.request.Item;

public interface Chef
{
    public void prepareFood( Item item );

    public void updateEstimationTime( Item item );

    public int getChefCount();

    public int availableChefCountAtTime();

    public String getChefType();
}
