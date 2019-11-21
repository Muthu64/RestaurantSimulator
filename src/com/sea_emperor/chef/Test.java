package com.sea_emperor.chef;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

public class Test
{
    class ChefQueue implements Runnable
    {
        Queue<item> itemQueue;

        public ChefQueue( Queue<item> itemQueue )
        {
            this.itemQueue = itemQueue;
        }

        @Override
        public String toString()
        {
            return "ChefQueue{" +
                    "itemQueue=" + itemQueue +
                    '}';
        }

        @Override
        public void run()
        {
            if ( this.itemQueue.isEmpty() == false )
            {
                itemQueue.stream().forEach( item -> {
                    System.out.println( "preparing item===>" + item.getItemName() );
                    try
                    {
                        Thread.sleep( 10000 );
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println( "done preparing item===>" + item.getItemName() );
                } );
            }
            else
            {
                System.out.println("No items in the queue");
            }
        }
    }

    class item
    {
        String itemName;

        item( String itemName )
        {
            this.itemName = itemName;
        }

        public String getItemName()
        {
            return itemName;
        }

        @Override
        public String toString()
        {
            return "item{" +
                    "itemName='" + itemName + '\'' +
                    '}';
        }
    }

    public static void main( String[] args )
    {
        new Test().test();
    }

    public void test()
    {
        Queue<item> queue1 = new LinkedList<>();
        queue1.add( new item( "Chicken" ) );
        queue1.add( new item( "Mutton" ) );
        queue1.add( new item( "crab" ) );


        Queue<item> queue2 = new LinkedList<>();
        queue2.add( new item( "Rice" ) );
        queue2.add( new item( "Dosa" ) );
        queue2.add( new item( "Vada" ) );


        Queue<item> queue3 = new LinkedList<>();

        queue3.add( new item( "Pongal" ) );
        queue3.add( new item( "Idly" ) );


        List<Queue<item>> listOfQueue = new ArrayList<>();
        listOfQueue.add( queue1 );
        listOfQueue.add( queue2 );
        listOfQueue.add( queue3 );

        System.out.println( "entire list--->" + listOfQueue );
        ExecutorService executorService = Executors.newFixedThreadPool( listOfQueue.size() );

        listOfQueue.stream().forEach( queue ->
        {
            ChefQueue chefQueue = new ChefQueue( queue );
            executorService.execute( chefQueue );
            System.out.println("Queue added to processing list --->"+ chefQueue);
        } );

        executorService.shutdown();

    }


}
