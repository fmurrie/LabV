package com.company;

public class BeerConsumer extends BeerThread
{
    //Atributtes:
    private BeerHouse beerHouse;

    //Constructors:
    public BeerConsumer(String name, BeerHouse beerHouse)
    {
        super("[Consumer-" + name + "]");
        this.beerHouse = beerHouse;
    }

    //Methods:
    @Override
    public void run()
    {
        while(this.beerHouse.isProducing()||this.beerHouse.getStock()>0)
        {
            this.beerHouse.quit(this); //Quit one beer
        }
        System.out.println("Application end - Stock: "+this.beerHouse.getStock());
    }
}
