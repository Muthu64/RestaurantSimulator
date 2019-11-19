package com.sea_emperor.chef;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Testing
{
    public static void main( String[] args )
    {

        Map<String, Integer> stringIntegerMap = new HashMap<>(  );
        stringIntegerMap.put( "Briyani",2 );
        stringIntegerMap.put( "Grill Chicken",5 );
        stringIntegerMap.put( "Tandoori",3 );
        //stringIntegerMap.put( "Chicken tikka",2 );
        //stringIntegerMap.put( "Crab lollipop",5 );

        Queue<String> nonVegChefQueue = new LinkedBlockingDeque<>( 2 );

        int preperationTime = 0;

        for( Map.Entry<String,Integer> item :stringIntegerMap.entrySet())
        {
            if(nonVegChefQueue.isEmpty())
            {
                preperationTime = preperationTime + item.getValue();
            }
            try
            {
                if(item.getValue() > preperationTime)
                {
                    preperationTime = item.getValue();
                }
                nonVegChefQueue.add( item.getKey() );
            }
            catch(IllegalStateException e)
            {
                nonVegChefQueue.clear();
                nonVegChefQueue.add( item.getKey() );
                if(preperationTime < item.getValue())
                {
                    preperationTime = preperationTime + item.getValue();
                }
            }
        }
        System.out.println(preperationTime);
    }

}
