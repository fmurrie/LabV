package com.company;

public class Main
{

    public static void main(String[] args)
    {
        BeerHouse house=new BeerHouse();
        BeerProducter producter=new BeerProducter("Moe",house,(int)Math.floor(Math.random()*(100-(500+1))+(500)));
        BeerConsumer consumer=new BeerConsumer("Homero",house);
        producter.start();
        consumer.start();
    }
}
