package com.sea_emperor.chef;

import com.sea_emperor.request.ItemCategory;

public class ChefProvider
{
    Chef chef;

    public Chef getChef( ItemCategory itemCategory )
    {
        if (itemCategory == ItemCategory.NON_VEG)
        {
            chef = new NonVegChef();
        }
        else if (itemCategory == ItemCategory.VEG)
        {
            chef = new VegChef();
        }
        else if (itemCategory == ItemCategory.SNACKS)
        {
            chef = new SnacksChef();
        }
        else if (itemCategory == ItemCategory.TEA)
        {
            chef = new TeaChef();
        }
        else if (itemCategory == ItemCategory.JUICE)
        {
            chef = new JuiceChef();
        }

        return chef;
    }
}
