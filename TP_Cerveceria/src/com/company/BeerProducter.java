package com.company;

public class BeerProducter extends BeerThread
{
    //Atributtes:
    private BeerHouse beerHouse;
    private int beersToProduce;
    private int beersProduced;
    private int beersToPut;

    //Constructors:
    public BeerProducter(String name, BeerHouse beerHouse,int beersToProduce)
    {
        super("[Producter-" + name + "]");
        this.beerHouse = beerHouse;
        this.beersToProduce=beersToProduce;
        this.beersProduced=0;
    }

    //Getters and Setters:
    public void setBeersProduced(int beersProduced)
    {
        this.beersProduced += beersProduced;
    }

    public int getBeersToPut()
    {
        return beersToPut;
    }

    public void setBeersToPut(int beersToPut)
    {
        this.beersToPut = beersToPut;
    }

    //Methods:
    @Override
    public void run()
    {
        for(int i=0;(i<this.beersToProduce)&&(this.beersProduced<this.beersToProduce);i++) //If the beers produced are the same that beers to produced in terms of quantity, the producter is already for finish his work
        {
            this.beersToPut=(int)Math.floor(Math.random()*(1-(this.getMaxBeersForProduce()+1))+(this.getMaxBeersForProduce())); //Calculates a quantity of beers that can put and put this quantity or less but no less than one
            this.beerHouse.put(this); //Put beers
        }
        this.beerHouse.setProducing(false); //The producter set that he already finished his work
    }

    private int getMaxBeersForProduce()
    {
        return this.beersToProduce-this.beersProduced;
    }
}
