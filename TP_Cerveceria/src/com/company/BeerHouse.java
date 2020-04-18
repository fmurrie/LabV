package com.company;

public class BeerHouse
{
    //Atributtes:
    private final int CAPACITY = 100; //Max capacity of beers that can be in stock
    private int stock = 0; //Stock that can be incremented by the producter or decremented by the consumer
    private boolean isProducing=true; //Variable that indicates if the producter is producing beers for the BeerHouse

    //Getters and Setters:
    public int getStock()
    {
        return stock;
    }

    public boolean isProducing()
    {
        return isProducing;
    }

    public void setProducing(boolean producing)
    {
        isProducing = producing;
    }

    public synchronized void put(BeerProducter beerThread)
    {
        try
        {
            System.out.println(beerThread.getName() + " will put a beer... "); //Send a message that the producter will put some beers in stock
            if (this.stock == this.CAPACITY) //Check if the producter can do that
            {
                System.out.println(beerThread.getName() + " is waiting for put a beer... "); //Send a message indicating that the producter is waiting that the consumer quit some beers of the stock
                beerThread.sleep(3000); //Sleep for pause 3 seconds the console
            }
            while (this.stock == this.CAPACITY) //If the stock is equal the capacity the producter needs wait
            {
                wait(); //Put the producter thread in waiting mode
            }
            int stockToSum=((this.CAPACITY-this.stock)>beerThread.getBeersToPut())?beerThread.getBeersToPut():beerThread.getBeersToPut()-(this.CAPACITY-this.stock); //Calculates the beers that are possible to add to the stock
            this.stock+=stockToSum; //Add the beers in the stock
            beerThread.setBeersProduced(stockToSum); //Set the beers that the producter have produced
            System.out.println("Beer putted by " + beerThread.getName()); //Message of alert that the producter did an action
            notifyAll(); //Notify the consumer for unlock him if is in waiting mode
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

    public synchronized void quit(BeerConsumer beerThread)
    {
        try
        {
            System.out.println(beerThread.getName() + " will take a beer... "); //Send a message that the consumer will take one beer of the stock
            if (this.stock == 0) //Check if the consumer can do that
            {
                System.out.println(beerThread.getName() + " is waiting for take a beer... ");
                beerThread.sleep(3000);
            }
            while (this.stock == 0) //If the stock is equal 0 the consumer needs wait
            {
                wait(); //Put the consumer thread in waiting mode
            }
            this.stock--; //Quit one beer of the stock
            System.out.println("Beer taked by " + beerThread.getName()); //Message of alert that the consumer did an action
            notifyAll(); //Notify the producter for unlock him if is in waiting mode
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}
